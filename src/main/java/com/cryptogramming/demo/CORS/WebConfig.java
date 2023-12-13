package com.cryptogramming.demo.CORS;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Configura la ruta de tu API
                .allowedOrigins("http://127.0.0.1:5173/")  // Permite solicitudes desde este dominio
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowCredentials(true)  // Permite el envío de cookies
                .maxAge(3600);  // Tiempo máximo de almacenamiento en caché de la configuración CORS en segundos
    }
}
