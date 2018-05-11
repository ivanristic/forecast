package com.sargije.ws.hidmet.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SpringSecurityPasswordValidationCallbackHandler;

@Configuration
public class WSSecurityConfig {
		
	@Autowired
	UserDetailsService userDetailsService;

/*	  @Bean 
	  public SimplePasswordValidationCallbackHandler securityCallbackHandler() { 
		   SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
	       Properties users = new Properties(); 
	       users.setProperty("admin", "secret"); 
	       callbackHandler.setUsers(users); 
	       return callbackHandler; 
	  }*/
	 
	@Bean
	public SpringSecurityPasswordValidationCallbackHandler securityCallbackHandler() {
		SpringSecurityPasswordValidationCallbackHandler callbackHandler = new SpringSecurityPasswordValidationCallbackHandler();
		callbackHandler.setUserDetailsService(userDetailsService);
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
