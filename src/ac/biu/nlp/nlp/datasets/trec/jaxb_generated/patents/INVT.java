//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.28 at 10:37:56 AM GMT+02:00 
//


package ac.biu.nlp.nlp.datasets.trec.jaxb_generated.patents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}NAM"/>
 *         &lt;element ref="{}STR" minOccurs="0"/>
 *         &lt;element ref="{}CTY"/>
 *         &lt;element ref="{}STA" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{}CNT"/>
 *           &lt;element ref="{}ZIP"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nam",
    "str",
    "cty",
    "sta",
    "cnt",
    "zip"
})
@XmlRootElement(name = "INVT")
public class INVT {

    @XmlElement(name = "NAM", required = true)
    protected String nam;
    @XmlElement(name = "STR")
    protected String str;
    @XmlElement(name = "CTY", required = true)
    protected String cty;
    @XmlElement(name = "STA")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String sta;
    @XmlElement(name = "CNT")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cnt;
    @XmlElement(name = "ZIP")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String zip;

    /**
     * Gets the value of the nam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAM() {
        return nam;
    }

    /**
     * Sets the value of the nam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAM(String value) {
        this.nam = value;
    }

    /**
     * Gets the value of the str property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTR() {
        return str;
    }

    /**
     * Sets the value of the str property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTR(String value) {
        this.str = value;
    }

    /**
     * Gets the value of the cty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTY() {
        return cty;
    }

    /**
     * Sets the value of the cty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTY(String value) {
        this.cty = value;
    }

    /**
     * Gets the value of the sta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTA() {
        return sta;
    }

    /**
     * Sets the value of the sta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTA(String value) {
        this.sta = value;
    }

    /**
     * Gets the value of the cnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNT() {
        return cnt;
    }

    /**
     * Sets the value of the cnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNT(String value) {
        this.cnt = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZIP() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZIP(String value) {
        this.zip = value;
    }

}
