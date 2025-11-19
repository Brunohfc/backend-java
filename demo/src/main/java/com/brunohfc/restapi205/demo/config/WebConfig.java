package com.brunohfc.restapi205.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

    //injetando os valores definidos no arquivo de config e colocando um padrao, caso esteja vazio o cors
    @Value("${cors.originPatterns:http:localhost:8080}")
    private String corsOriginPattern = "";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var allowedOrigins = corsOriginPattern.split(",");
        //toda aplicacao recebera essa config
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("*")
                .allowCredentials(true);
    }

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){

        // Serilizacao por QUERY PARAM
//        configurer.
//                favorParameter(true).
//                parameterName("mediaType").
//                ignoreAcceptHeader(false).
//                defaultContentType(MediaType.APPLICATION_JSON).
//                mediaType("xml", MediaType.APPLICATION_XML).
//                mediaType("json", MediaType.APPLICATION_JSON);
//
        // Serilizacao por HEADER PARAM
        // O header tem que mudar para Accept: application/json ||Accept: application/xml
        configurer.
                favorParameter(false).
                ignoreAcceptHeader(false).
                useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);


    }
}