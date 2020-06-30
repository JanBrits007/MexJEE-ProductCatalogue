
package za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains information about the context within which the request is executing.
 * 
 * <p>Java class for ContextInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContextInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessContextId" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}ProcessContextId_Type" minOccurs="0"/>
 *         &lt;element name="ExecutionContextId" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}ExecutionContextId_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContextInfo_Type", propOrder = {
    "processContextId",
    "executionContextId"
})
public class ContextInfoType {

    @XmlElement(name = "ProcessContextId")
    protected String processContextId;
    @XmlElement(name = "ExecutionContextId", required = true)
    protected String executionContextId;

    /**
     * Gets the value of the processContextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessContextId() {
        return processContextId;
    }

    /**
     * Sets the value of the processContextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessContextId(String value) {
        this.processContextId = value;
    }

    /**
     * Gets the value of the executionContextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionContextId() {
        return executionContextId;
    }

    /**
     * Sets the value of the executionContextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionContextId(String value) {
        this.executionContextId = value;
    }

}
