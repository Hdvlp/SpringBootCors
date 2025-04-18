package com.springbootcors.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Value("${allowed-origins:*}")
    String allowedOriginsPattern;
        // contains "http://localhost:8080,http://127.0.0.1:8080,http://[::1]:8080"

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       String[] origins = allowedOriginsPattern.split(",");

       registry.addMapping("/**")
           .allowedOriginPatterns(origins)
           .allowedMethods("GET", "OPTIONS", "POST")
           .allowCredentials(true);
    }
}
