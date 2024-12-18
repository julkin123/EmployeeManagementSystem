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
	                .allowedOrigins("http://agile-cooperation-production.up.railway.app","http://agile-cooperation-production.up.railway.app/"
	                		,"https://agile-cooperation-production.up.railway.app",
	                		"https://agile-cooperation-production.up.railway.app/","http://localhost:8080")  
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowedHeaders("*"); 
	    }
}