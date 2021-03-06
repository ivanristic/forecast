//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.27 at 09:25:15 AM CET 
//

package com.sargije.ws.wsfaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for FaultMessage complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="FaultMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MessageLevel" type="{http://www.sargije.com/ws/wsfaults}MessageLevel"/&gt;
 *         &lt;element name="FaultMessageText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FaultParameters" type="{http://www.sargije.com/ws/wsfaults}FaultParametersType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultMessage", propOrder = { "messageType", "messageLevel", "faultMessageText", "faultParameters" })
public class FaultMessage {

	@XmlElement(name = "MessageType", required = true)
	protected String messageType;
	@XmlElement(name = "MessageLevel", required = true)
	@XmlSchemaType(name = "string")
	protected MessageLevel messageLevel;
	@XmlElement(name = "FaultMessageText", required = true)
	protected String faultMessageText;
	@XmlElement(name = "FaultParameters", required = true)
	protected FaultParametersType faultParameters;

	/**
	 * Gets the value of the messageType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * Sets the value of the messageType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessageType(String value) {
		this.messageType = value;
	}

	/**
	 * Gets the value of the messageLevel property.
	 * 
	 * @return possible object is {@link MessageLevel }
	 * 
	 */
	public MessageLevel getMessageLevel() {
		return messageLevel;
	}

	/**
	 * Sets the value of the messageLevel property.
	 * 
	 * @param value
	 *            allowed object is {@link MessageLevel }
	 * 
	 */
	public void setMessageLevel(MessageLevel value) {
		this.messageLevel = value;
	}

	/**
	 * Gets the value of the faultMessageText property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFaultMessageText() {
		return faultMessageText;
	}

	/**
	 * Sets the value of the faultMessageText property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFaultMessageText(String value) {
		this.faultMessageText = value;
	}

	/**
	 * Gets the value of the faultParameters property.
	 * 
	 * @return possible object is {@link FaultParametersType }
	 * 
	 */
	public FaultParametersType getFaultParameters() {
		return faultParameters;
	}

	/**
	 * Sets the value of the faultParameters property.
	 * 
	 * @param value
	 *            allowed object is {@link FaultParametersType }
	 * 
	 */
	public void setFaultParameters(FaultParametersType value) {
		this.faultParameters = value;
	}

}
