package com.sargije.ws.hidmet.app;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {
	
 //   private static final Log LOG = LogFactory.getLog(CustomEndpointInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
    	String uuid = UUID.randomUUID().toString();
  
    	MDC.clear();
		
		MDC.put("uuid", uuid);
		
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
    	MDC.remove("uuid");
    }
}