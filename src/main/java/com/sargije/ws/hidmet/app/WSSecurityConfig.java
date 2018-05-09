package com.sargije.ws.hidmet.app;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;

@Configuration
public class WSSecurityConfig {
		
    @Bean
	public SimplePasswordValidationCallbackHandler securityCallbackHandler() {
		SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
		Properties users = new Properties();
		users.setProperty("admin", "secret");
		callbackHandler.setUsers(users);
		return callbackHandler;
	}

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
		securityInterceptor.setValidationActions("UsernameToken");
		securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());

		return securityInterceptor;
	}
	
}
