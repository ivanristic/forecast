package com.sargije.ws.hidmet.app;

import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.server.endpoint.interceptor.SoapEnvelopeLoggingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

import com.sargije.ws.hidmet.app.faults.DetailSoapFaultDefinitionExceptionResolver;
import com.sargije.ws.hidmet.app.faults.ServiceFaultException;

@EnableWs
@Configuration
@EnableTransactionManagement
public class WSConfig extends WsConfigurerAdapter {
	private static final Log LOG = LogFactory.getLog(WSConfig.class);
	
	@Autowired
	//Wss4jSecurityInterceptor securityInterceptor;
	XwsSecurityInterceptor securityInterceptor;
	
	@Bean
	public SoapFaultMappingExceptionResolver exceptionResolver() {
		SoapFaultMappingExceptionResolver exceptionResolver = new DetailSoapFaultDefinitionExceptionResolver();

		SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
		faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
		exceptionResolver.setDefaultFault(faultDefinition);

		Properties errorMappings = new Properties();
		errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
		errorMappings.setProperty(ServiceFaultException.class.getName(), SoapFaultDefinition.SERVER.toString());
		exceptionResolver.setExceptionMappings(errorMappings);
		exceptionResolver.setOrder(1);
		return exceptionResolver;
	}

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "forecasts")
	public DefaultWsdl11Definition defaultWsdl11Definition() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ForecastsPort");
		wsdl11Definition.setServiceName("Forecasts");
		wsdl11Definition.setLocationUri("/ws");

		wsdl11Definition.setTargetNamespace("http://www.sargije.com/ws/hidmet");
		wsdl11Definition.setSchemaCollection(forecastsXsd());// .setSchema(forecastsSchema);

		return wsdl11Definition;
	}

	@Bean
	public CommonsXsdSchemaCollection forecastsXsd() {
		CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection(
				new Resource[] { new ClassPathResource("/xsd/ForecastOperations.xsd") });
		collection.setInline(true);
		return collection;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {

		interceptors.add(securityInterceptor);
		//interceptors.add(new CustomEndpointInterceptor());
		// interceptors.add(loggingInterceptor());
		//interceptors.add(soapLoggingInterceptor());
	}
	
	@Bean
	public PayloadLoggingInterceptor loggingInterceptor() {
		PayloadLoggingInterceptor payloadLoggingInterceptor = new PayloadLoggingInterceptor();
		payloadLoggingInterceptor.setLogRequest(true);
		payloadLoggingInterceptor.setLogResponse(true);
		// payloadLoggingInterceptor.setTransformerFactoryClass(transformerFactoryClass);
		return payloadLoggingInterceptor;

	}

	@Bean
	public SoapEnvelopeLoggingInterceptor soapLoggingInterceptor() {
		SoapEnvelopeLoggingInterceptor soapEnvelopeLoggingInterceptor = new SoapEnvelopeLoggingInterceptor();
		soapEnvelopeLoggingInterceptor.setLogRequest(true);
		soapEnvelopeLoggingInterceptor.setLogResponse(true);
		return soapEnvelopeLoggingInterceptor;

	}

}
