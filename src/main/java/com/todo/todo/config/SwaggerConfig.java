package com.todo.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenApi() {

        Info info = new Info();

        Contact contact = new Contact();
        contact.name("Patrick");
        contact.email("patrick.almeida06@gmail.com");

        info.title("Todo Api");
        info.version("v1");
        info.description("Projeto Spring Boot para um todo");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}