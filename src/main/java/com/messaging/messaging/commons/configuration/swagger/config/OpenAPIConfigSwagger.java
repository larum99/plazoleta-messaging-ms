package com.messaging.messaging.commons.configuration.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfigSwagger {

    @Bean
    public OpenAPI messagingServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Messaging - Notification Service API")
                        .description("Microservicio para envío de notificaciones SMS de pedidos listos.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo Messaging")
                                .email("soporte@messaging.com")
                                .url("https://messaging.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                );
    }
}
