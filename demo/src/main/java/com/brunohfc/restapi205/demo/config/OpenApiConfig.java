package com.brunohfc.restapi205.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI docsOpenApi(){

        return new OpenAPI().
                info(new Info().
                        title("Rest API documentacao")
                        .version("v1")
                        .description("API versao 1 da aplicação do curso"));
    }
}
