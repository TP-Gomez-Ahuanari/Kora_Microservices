package com.kora.healthdataservice;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class HealthDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthDataServiceApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kora - Health Data Service")
                        .version("1.0")
                        .description("Kora Health Data Service, made with java and springboot, applying domain-driven architecture approach.")
                        .termsOfService(".")
                        .license(new License()
                                .name("Apache 2.0 License")
                                .url(""))
                        .contact(new Contact()
                                .url("")
                                .name("Kora,.studio")))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                        )
                ).addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));

    }
}
