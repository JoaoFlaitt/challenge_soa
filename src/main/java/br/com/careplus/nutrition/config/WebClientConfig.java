package br.com.careplus.nutrition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final FatSecretProperties fatSecretProperties;

    public WebClientConfig(FatSecretProperties fatSecretProperties) {
        this.fatSecretProperties = fatSecretProperties;
    }

    @Bean
    public WebClient fatSecretWebClient() {
        return WebClient.builder()
                .baseUrl(fatSecretProperties.getBaseUrl())
                .build();
    }
}