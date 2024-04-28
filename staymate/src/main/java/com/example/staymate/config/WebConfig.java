package com.example.staymate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Mapea todas las URL de tu aplicación
                .allowedOrigins("*") // Permite solicitudes desde cualquier origen
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite estos métodos HTTP
                .allowedHeaders("*"); // Permite todos los encabezados
    }
}
