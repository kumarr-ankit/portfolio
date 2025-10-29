package ankitkumar.TodoTracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all endpoints
                // Crucial: Must exactly match your frontend's origin
//                .allowedOrigins("http://127.0.0.1:5500/")
//                .allowedOrigins("http://127.0.0.1:5500/frontend/")
//                .allowedOrigins("https://ankitkumar2020.github.io/")
                  .allowedOrigins("*");
        // Crucial: Explicitly allow the DELETE method and OPTIONS for preflight
        //  .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        // .allowCredentials(true); // If you're using cookies/sessions
    }
}