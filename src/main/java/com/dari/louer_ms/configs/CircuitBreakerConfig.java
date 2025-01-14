package com.dari.louer_ms.configs;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfig {


    @Bean
    public CircuitBreaker circuitBreaker() {
        return CircuitBreaker.ofDefaults("propertyCircuitBreaker");
    }

    @Bean
    public CircuitBreakerConfig customCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // Taux d'échec avant d'ouvrir le circuit breaker
                .waitDurationInOpenState(Duration.ofMillis(1000)) // Temps d'attente avant de vérifier si le circuit breaker peut être fermé
                .slidingWindowSize(10) // Taille de la fenêtre glissante
                .build();
    }
}
