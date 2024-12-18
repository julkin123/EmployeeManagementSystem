package com.ems;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SpringDocConfig implements WebMvcConfigurer
{


	 @Override
	    public void addCorsMappings(CorsRegistry registry) {  
	        registry.addMapping("/**")
	                .allowedOrigins("http://protective-endurance-production.up.railway.app","http://localhost:8080")  
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowedHeaders("*"); 
	    }
}