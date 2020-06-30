
package za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains information that is used when perform instrumentation.
 * 
 * <p>Java class for InstrumentationInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstrumentationInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParentInstrumentationId" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}ParentInstrumentationId_Type"/>
 *         &lt;element name="ChildInstrumentationId" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}ChildInstrumentationId_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstrumentationInfo_Type", propOrder = {
    "parentInstrumentationId",
    "childInstrumentationId"
})
public class InstrumentationInfoType {

    @XmlElement(name = "ParentInstrumentationId", required = true)
    protected String parentInstrumentationId;
    @XmlElement(name = "ChildInstrumentationId", required = true)
    protected String childInstrumentationId;

    /**
     * Gets the value of the parentInstrumentationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentInstrumentationId() {
        return parentInstrumentationId;
    }

    /**
     * Sets the value of the parentInstrumentationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentInstrumentationId(String value) {
        this.parentInstrumentationId = value;
    }

    /**
     * Gets the value of the childInstrumentationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildInstrumentationId() {
        return childInstrumentationId;
    }

    /**
     * Sets the value of the childInstrumentationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildInstrumentationId(String value) {
        this.childInstrumentationId = value;
    }

}
