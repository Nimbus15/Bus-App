package com.belfastdev.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder,
                               @Value("${bus.tracker.api.url:http://localhost:8000}") String apiBaseUrl) {
        return builder.baseUrl(apiBaseUrl).build();
    }
}
