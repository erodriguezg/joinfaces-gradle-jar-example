package org.joinfaces.example.config;

import org.joinfaces.example.application.jsf.converters.JsonConverter;
import org.joinfaces.example.application.jsf.converters.RutConverter;
import org.joinfaces.example.utils.JsfUtils;
import org.joinfaces.example.utils.RutConverterUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class JsfConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RutConverter rutConverter() {
        return new RutConverter(new RutConverterUtils());
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public JsonConverter jsonConverter() {
        return new JsonConverter();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public JsfUtils jsfUtils() {
        return new JsfUtils();
    }

}
