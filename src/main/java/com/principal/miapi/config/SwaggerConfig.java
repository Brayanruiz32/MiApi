package com.principal.miapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Api de Usuarios",
        description = "Esta api esta desarrollada por el propietario de la cuenta de Github",
        contact = @Contact(
            name = "Brayan Ruiz Marreros",
            url = "https://github.com/Brayanruiz32"
        )
    ), 
    servers = {
        @Server(
        url =  "http://localhost:8080", 
        description = "DEV-SERVER"
        )
    }
)
public class SwaggerConfig {

}
