package com.pe.project.food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
    @Bean
    public WebClient.Builder getWebClientBuilder() {
    	
        WebClient.Builder builder = WebClient.builder().baseUrl("http://localhost:8000/api/v1/");
 
        return builder;
    }
}
