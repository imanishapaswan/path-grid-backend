
package com.pathgrid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Comma-separated allowed origins. Defaults to local dev; override in
    // production with the APP_CORS_ALLOWED_ORIGINS env var, e.g.:
    //   APP_CORS_ALLOWED_ORIGINS=https://your-app.vercel.app,https://*.vercel.app
    // Patterns (allowedOriginPatterns) support wildcards like *.vercel.app,
    // which plain allowedOrigins does not.
    @Value("${app.cors.allowed-origins:http://localhost:5173,http://127.0.0.1:5173}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
