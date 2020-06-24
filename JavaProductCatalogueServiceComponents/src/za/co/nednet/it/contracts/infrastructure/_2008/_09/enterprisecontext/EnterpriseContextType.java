
package za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contain enterprise specific information that is required on every request.
 * 
 * <p>Java class for EnterpriseContext_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnterpriseContext_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContextInfo" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}ContextInfo_Type"/>
 *         &lt;element name="RequestOriginator" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}RequestOriginator_Type"/>
 *         &lt;element name="InstrumentationInfo" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}InstrumentationInfo_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnterpriseContext_Type", propOrder = {
    "contextInfo",
    "requestOriginator",
    "instrumentationInfo"
})
public class EnterpriseContextType {

    @XmlElement(name = "ContextInfo", required = true)
    protected ContextInfoType contextInfo;
    @XmlElement(name = "RequestOriginator", required = true)
    protected RequestOriginatorType requestOriginator;
    @XmlElement(name = "InstrumentationInfo", required = true)
    protected InstrumentationInfoType instrumentationInfo;

    /**
     * Gets the value of the contextInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContextInfoType }
     *     
     */
    public ContextInfoType getContextInfo() {
        return contextInfo;
    }

    /**
     * Sets the value of the contextInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextInfoType }
     *     
     */
    public void setContextInfo(ContextInfoType value) {
        this.contextInfo = value;
    }

    /**
     * Gets the value of the requestOriginator property.
     * 
     * @return
     *     possible object is
     *     {@link RequestOriginatorType }
     *     
     */
    public RequestOriginatorType getRequestOriginator() {
        return requestOriginator;
    }

    /**
     * Sets the value of the requestOriginator property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestOriginatorType }
     *     
     */
    public void setRequestOriginator(RequestOriginatorType value) {
        this.requestOriginator = value;
    }

    /**
     * Gets the value of the instrumentationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link InstrumentationInfoType }
     *     
     */
    public InstrumentationInfoType getInstrumentationInfo() {
        return instrumentationInfo;
    }

    /**
     * Sets the value of the instrumentationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstrumentationInfoType }
     *     
     */
    public void setInstrumentationInfo(InstrumentationInfoType value) {
        this.instrumentationInfo = value;
    }

}
