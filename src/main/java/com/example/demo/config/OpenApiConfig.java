package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();
        server.setUrl("https://9071.32procr.amypo.ai/");
        server.setDescription("Production Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Academic Integrity Case Tracker API")
                        .description("REST API for managing student academic integrity cases")
                        .version("1.0.0"))
                .servers(List.of(server));
    }
}
