package br.com.careplus.nutrition.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI carePlusOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CarePlus Nutrition API")
                        .description("API de serviços digitais de saúde (nutrição, hábitos saudáveis) para Care Plus / Bupa")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação Swagger")
                        .url("http://localhost:8080/swagger-ui.html"));
    }
}