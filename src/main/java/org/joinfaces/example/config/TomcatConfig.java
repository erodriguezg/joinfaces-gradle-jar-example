package org.joinfaces.example.config;

import java.util.concurrent.Executors;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ContextEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class TomcatConfig {

    @Value("${jsf.flash-secret-key}")
    private String jsfFlashSecretKey;

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {

                logger.info("Initializing distributable to true in postProcessContext");
                context.setDistributable(true);

                logger.info("Initializing jsf/FlashSecretKey in postProcessContext");
                // adding <env-entry>
                ContextEnvironment ce = new ContextEnvironment();
                ce.setName("jsf/FlashSecretKey");
                ce.setType(String.class.getName());
                ce.setValue(jsfFlashSecretKey);
                context.getNamingResources().addEnvironment(ce);
            }
        };
    }

    @Bean
    public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
        return protocolHandler -> {
            protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        };
    }

    @Bean
    public AsyncTaskExecutor applicationTaskExecutor() {
        return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
    }

}
