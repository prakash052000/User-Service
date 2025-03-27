package com.user.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("User Service API")
//                        .description("API documentation for User Service")
//                        .version("1.0"));
//    }
	
	 @Bean
	    public GroupedOpenApi serviceApi() {
	        return GroupedOpenApi.builder()
	                .group("User-Service API")
	                .pathsToMatch("/api/**") // Adjust as per your service's API endpoints
	                .build();
	    }
}
