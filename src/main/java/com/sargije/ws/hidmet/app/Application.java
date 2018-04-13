package com.sargije.ws.hidmet.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class Application extends SpringBootServletInitializer  {
	
	private static final Log LOG = LogFactory.getLog(WSConfig.class);
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOG.info("Lokacija servisa je http://localhost:8080/ws/forecasts.wsdl");
	}
	
}