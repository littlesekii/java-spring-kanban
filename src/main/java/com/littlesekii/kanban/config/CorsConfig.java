package com.littlesekii.kanban.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry cors) {
        final String port = "5173";

        cors.addMapping("/**").allowedOrigins("http://localhost:" + port)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
