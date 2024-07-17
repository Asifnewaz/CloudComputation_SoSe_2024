package com.asif.cc_summer.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
//https://bell-sw.com/blog/documenting-rest-api-with-swagger-in-spring-boot-3/

@Configuration
public class OpenAPIConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
       Server server = new Server();
       server.setUrl("http://localhost:8080");
       server.setDescription("Development");

       Contact myContact = new Contact();
       myContact.setName("Asif Newaz");
       myContact.setEmail("dev.asifnewaz@gmail.com");

       Info information = new Info()
               .title("Cloud Computation Summer 2024")
               .version("1.0")
               .description("This API exposes endpoints to manage employees.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(server));
   }
}