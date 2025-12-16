package com.example.notesbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application entry point for Notes Backend.
 */
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Notes API",
                version = "0.1.0",
                description = "REST API for managing notes",
                contact = @Contact(name = "Notes Backend")
        )
)
public class NotesbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesbackendApplication.class, args);
    }

}
