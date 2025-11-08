package com.cliente.ws.valmerdev.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RasmoPlus")
                        .version("0.0.1")
                        .description("Api para atender o cliente Rasmo Plus")
                        .contact(new Contact()
                                .name("Harlan desenvolvedor Java")
                                .email("hvalmer@gmail.com"))


                );
    }
}
