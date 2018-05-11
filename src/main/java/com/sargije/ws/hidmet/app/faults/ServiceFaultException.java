package com.sargije.ws.hidmet.app.faults;

import com.sargije.ws.wsfaults.FaultMessage;

public class ServiceFaultException extends RuntimeException {

	/*
	 * private static final long serialVersionUID = 2431112931791750505L;
	 * 
	 * private ServiceFault serviceFault;
	 * 
	 * public ServiceFaultException(String message, ServiceFault serviceFault) {
	 * super(message); this.serviceFault = serviceFault; }
	 * 
	 * public ServiceFaultException(String message, Throwable e, ServiceFault
	 * serviceFault) { super(message, e); this.serviceFault = serviceFault; }
	 * 
	 * public ServiceFault getServiceFault() { return serviceFault; }
	 * 
	 * public void setServiceFault(ServiceFault serviceFault) { this.serviceFault =
	 * serviceFault; }
	 */

	private static final long serialVersionUID = 2431112931791750505L;

	private FaultMessage faultMessage;

	public ServiceFaultException(String message, FaultMessage faultMessage) {
		super(message);
		this.faultMessage = faultMessage;
	}

	public ServiceFaultException(String message, Throwable e, FaultMessage faultMessage) {
		super(message, e);
		this.faultMessage = faultMessage;
	}

	public FaultMessage getServiceFault() {
		return faultMessage;
	}

	public void setServiceFault(FaultMessage faultMessage) {
		this.faultMessage = faultMessage;
	}
}