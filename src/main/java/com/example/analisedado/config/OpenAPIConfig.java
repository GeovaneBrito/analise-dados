package com.example.analisedado.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${analisedado.openapi.config-url}")
    private String configUrl;

    @Bean
    public OpenAPI myOpenAPI(){
        Server devServer = new Server();
        devServer.setUrl(configUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setName("Geovane");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Data Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage data.").termsOfService("https://www.google.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));

    }
}
