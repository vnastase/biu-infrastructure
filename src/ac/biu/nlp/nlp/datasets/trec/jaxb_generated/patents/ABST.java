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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}PAL"/>
 *         &lt;element ref="{}PAR"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pal",
    "par"
})
@XmlRootElement(name = "ABST")
public class ABST {

    @XmlElement(name = "PAL")
    protected String pal;
    @XmlElement(name = "PAR")
    protected String par;

    /**
     * Gets the value of the pal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAL() {
        return pal;
    }

    /**
     * Sets the value of the pal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAL(String value) {
        this.pal = value;
    }

    /**
     * Gets the value of the par property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAR() {
        return par;
    }

    /**
     * Sets the value of the par property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAR(String value) {
        this.par = value;
    }

}