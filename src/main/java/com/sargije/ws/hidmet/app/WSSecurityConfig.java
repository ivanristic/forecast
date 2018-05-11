package com.sargije.ws.hidmet.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SpringSecurityPasswordValidationCallbackHandler;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SpringPlainTextPasswordValidationCallbackHandler;

@Configuration
public class WSSecurityConfig {
		
	@Autowired
	UserDetailsService userDetailsService;

	/*
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
*/
	
	@Bean
	public SpringPlainTextPasswordValidationCallbackHandler securityCallbackHandler() {
		SpringPlainTextPasswordValidationCallbackHandler callbackHandler = new SpringPlainTextPasswordValidationCallbackHandler();
		callbackHandler.setAuthenticationManager(authenticationManager());
		return callbackHandler;
	}
	
	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
		XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
		securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
		securityInterceptor.setCallbackHandler(securityCallbackHandler());
		return securityInterceptor;
	}
	
	@Bean
	public ProviderManager authenticationManager() {
		List<AuthenticationProvider> auth = new ArrayList<AuthenticationProvider>();
		auth.add(authProvider());
		ProviderManager providerManager = new ProviderManager(auth);
		return providerManager;
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
