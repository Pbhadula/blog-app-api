package com.myproject.blog.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.service.contexts.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apiKeys() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	private List<SecurityContext> securityContexts() {
		
		return Arrays.asList(SecurityContext.builder().securityReferences(securityReference()).build());
		
	}
	
	private List<SecurityReference> securityReference() {
		
		AuthorizationScope scope = new AuthorizationScope("global", "Access Everything");
		
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scope }));
		
	}
	
	@Bean
	public Docket api() {
		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {

		return new ApiInfo("Blogging Application backend", "This Project is developed by Prashant Bhadula", "1.0",
				"Terms of Service", new Contact("Prashant", "", "pbhadula19@gmail.com"), "License of API's",
				"APi License URL", Collections.emptyList());
	}

}
