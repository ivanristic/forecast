//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.27 at 09:25:15 AM CET 
//


package com.sargije.ws.hidmet.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CurrentForecast complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrentForecast"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="currentWeatherId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="temperature" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="presure" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="windDirection" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="windSpeed" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="humidity" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="feelsLike" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tableTime" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="syncTime" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="City" type="{http://www.sargije.com/ws/hidmet/entities}City"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentForecast", propOrder = {
    "currentWeatherId",
    "temperature",
    "presure",
    "windDirection",
    "windSpeed",
    "humidity",
    "feelsLike",
    "image",
    "description",
    "tableTime",
    "syncTime",
    "active",
    "city"
})
public class CurrentForecast {

    protected long currentWeatherId;
    protected long temperature;
    protected long presure;
    @XmlElement(required = true)
    protected String windDirection;
    @XmlElement(required = true)
    protected String windSpeed;
    protected long humidity;
    protected long feelsLike;
    @XmlElement(required = true)
    protected String image;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar tableTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar syncTime;
    protected Long active;
    @XmlElement(name = "City", required = true)
    protected City city;

    /**
     * Gets the value of the currentWeatherId property.
     * 
     */
    public long getCurrentWeatherId() {
        return currentWeatherId;
    }

    /**
     * Sets the value of the currentWeatherId property.
     * 
     */
    public void setCurrentWeatherId(long value) {
        this.currentWeatherId = value;
    }

    /**
     * Gets the value of the temperature property.
     * 
     */
    public long getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     */
    public void setTemperature(long value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the presure property.
     * 
     */
    public long getPresure() {
        return presure;
    }

    /**
     * Sets the value of the presure property.
     * 
     */
    public void setPresure(long value) {
        this.presure = value;
    }

    /**
     * Gets the value of the windDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * Sets the value of the windDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindDirection(String value) {
        this.windDirection = value;
    }

    /**
     * Gets the value of the windSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the value of the windSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindSpeed(String value) {
        this.windSpeed = value;
    }

    /**
     * Gets the value of the humidity property.
     * 
     */
    public long getHumidity() {
        return humidity;
    }

    /**
     * Sets the value of the humidity property.
     * 
     */
    public void setHumidity(long value) {
        this.humidity = value;
    }

    /**
     * Gets the value of the feelsLike property.
     * 
     */
    public long getFeelsLike() {
        return feelsLike;
    }

    /**
     * Sets the value of the feelsLike property.
     * 
     */
    public void setFeelsLike(long value) {
        this.feelsLike = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the tableTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTableTime() {
        return tableTime;
    }

    /**
     * Sets the value of the tableTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTableTime(XMLGregorianCalendar value) {
        this.tableTime = value;
    }

    /**
     * Gets the value of the syncTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSyncTime() {
        return syncTime;
    }

    /**
     * Sets the value of the syncTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSyncTime(XMLGregorianCalendar value) {
        this.syncTime = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActive(Long value) {
        this.active = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setCity(City value) {
        this.city = value;
    }

}
