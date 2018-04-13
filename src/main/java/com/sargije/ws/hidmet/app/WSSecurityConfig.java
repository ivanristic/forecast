package com.sargije.ws.hidmet.app;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.callback.SimplePasswordValidationCallbackHandler;


@SuppressWarnings("deprecation")
@Configuration
public class WSSecurityConfig {
/*
	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
	    XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
	    securityInterceptor.setCallbackHandler(xwsCallbackHandler());
	    securityInterceptor.setPolicyConfiguration(new ClassPathResource("WEB-INF/securityPolicy.xml"));
	    return securityInterceptor;
	}

	@Bean 
	public SimplePasswordValidationCallbackHandler xwsCallbackHandler() { 
		SimplePasswordValidationCallbackHandler callbackHandler = new
		  SimplePasswordValidationCallbackHandler(); Properties users = new
		  Properties(); users.setProperty("admin", "secret");
		  callbackHandler.setUsers(users); return callbackHandler; 
	}
	*/
	 /* auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");*/
	//	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
/*
  <beans>
  <bean id="springSecurityHandler"
      class="org.springframework.ws.soap.security.xwss.callback.SpringPlainTextPasswordValidationCallbackHandler">
    <property name="authenticationManager" ref="authenticationManager"/>
  </bean>

  <bean id="authenticationManager" class="org.springframework.security.providers.ProviderManager">
      <property name="providers">
          <bean class="org.springframework.security.providers.dao.DaoAuthenticationProvider">
              <property name="userDetailsService" ref="userDetailsService"/>
          </bean>
      </property>
  </bean>

  <bean id="userDetailsService" class="com.mycompany.app.dao.UserDetailService" />
  ...
</beans>
 */
	
	
		
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
		// securityInterceptor.setValidationActions("Timestamp UsernameToken");
		securityInterceptor.setValidationActions("UsernameToken");
		securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
		// za output message
		// securityInterceptor.setSecurementActions("UsernameToken");
		// securityInterceptor.setSecurementUsername("admin");
		// securityInterceptor.setSecurementPassword("secret");

		return securityInterceptor;
	}
	
	
	/*
	 * @Bean public XwsSecurityInterceptor xwsSecurityInterceptor(){
	 * XwsSecurityInterceptor xwsSecurityInterceptor = new
	 * XwsSecurityInterceptor();
	 * xwsSecurityInterceptor.setCallbackHandler(xwsCallbackHandler());
	 * xwsSecurityInterceptor.setPolicyConfiguration( new
	 * ClassPathResource("WEB-INF/securityPolicy.xml")); return
	 * xwsSecurityInterceptor;
	 * 
	 * }
	 * 
	 * @Bean public SimplePasswordValidationCallbackHandler xwsCallbackHandler()
	 * { SimplePasswordValidationCallbackHandler callbackHandler = new
	 * SimplePasswordValidationCallbackHandler(); Properties users = new
	 * Properties(); users.setProperty("admin", "secret");
	 * callbackHandler.setUsers(users); return callbackHandler; }
	 */
}
