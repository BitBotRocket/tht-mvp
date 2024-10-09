package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-09T18:44:33.080945746Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Acme Sales and Inventory System")
                .description("Simple REST API contract for the Acme Product Management and Sales Retail Company     We are going to approach this a little differently and trim down the complexity in the model and api structure. ")
                .termsOfService("")
                .version("1.0.7")
                .license(new License()
                    .name("MIT")
                    .url("https://opensource.org/license/mit"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("adams.dave.m@gmail.com")));
    }

}
