package com.vaas.vaasbackend.swaggerconfig;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class config {
    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI().info(new Info().title("Voting and Approval system").version("1.0.0").description("Spring doc"));
    }
}
