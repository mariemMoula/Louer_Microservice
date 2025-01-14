package com.dari.louer_ms.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAxon
public class AxonConfig {

    @Bean
    public Configuration axonConfiguration() {
        return Configuration.defaultConfiguration();
    }
}
