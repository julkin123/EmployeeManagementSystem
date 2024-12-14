package com.ems;
//
//import org.springdoc.core.customizers.OpenApiCustomizer;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import io.swagger.v3.oas.models.ExternalDocumentation;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//
//


//@Configuration
public class SpringDocConfig
{
//	@Bean
//	 GroupedOpenApi controllerApi() {
//		
//		OpenApiCustomizer customizer=openApi ->{
//			final ExternalDocumentation externalDocumentation=new ExternalDocumentation();
//			
//			externalDocumentation.setUrl("http://localhost:8080/v3/api-docs/");
//			openApi.setExternalDocs(externalDocumentation);
//		
//			
//		};
//		
//		return GroupedOpenApi.builder()
//				.group("controller-api")
//				.pathsToMatch("/rest/**")
//				.packagesToScan("com.ems")
//				.displayName("Employee")
//				.addOpenApiCustomizer(customizer)
//				.build()
//				;
//		
//		
//	}
//	
//	
//	@Bean
//	   OpenAPI customOpenAPI(
//			  @Value("${application-description}") String appDescription,
//			  @Value("${application-version}") String appVersion
//			  ) {
//		return new OpenAPI()
//				.info(new Info()
//						.title("Employee System API")
//						.version(appVersion)
//						.description(appDescription)
//						);
//		
//		
//	}

}