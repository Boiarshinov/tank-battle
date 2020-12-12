package dev.boiarshinov.tankbattle.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI publicApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Танчики")
                .version("0.0.1")
            );
    }
}
