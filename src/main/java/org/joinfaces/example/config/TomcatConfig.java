package org.joinfaces.example.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ContextEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

                logger.info("Setting distributable Web.xml to true");
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

}
