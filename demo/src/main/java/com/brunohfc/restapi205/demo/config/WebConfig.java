package com.brunohfc.restapi205.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

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