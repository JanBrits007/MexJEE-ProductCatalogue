
package za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains information about where and when the request was originated.
 * 
 * <p>Java class for RequestOriginator_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestOriginator_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MachineIPAddress" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}MachineIPAddress_Type"/>
 *         &lt;element name="UserPrincipleName" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}UserPrincipleName_Type"/>
 *         &lt;element name="MachineDNSName" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}MachineDNSName_Type"/>
 *         &lt;element name="ChannelId" type="{http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext}ChannelId_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestOriginator_Type", propOrder = {
    "machineIPAddress",
    "userPrincipleName",
    "machineDNSName",
    "channelId"
})
public class RequestOriginatorType {

    @XmlElement(name = "MachineIPAddress", required = true)
    protected String machineIPAddress;
    @XmlElement(name = "UserPrincipleName", required = true)
    protected String userPrincipleName;
    @XmlElement(name = "MachineDNSName", required = true)
    protected String machineDNSName;
    @XmlElement(name = "ChannelId")
    protected long channelId;

    /**
     * Gets the value of the machineIPAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachineIPAddress() {
        return machineIPAddress;
    }

    /**
     * Sets the value of the machineIPAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachineIPAddress(String value) {
        this.machineIPAddress = value;
    }

    /**
     * Gets the value of the userPrincipleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPrincipleName() {
        return userPrincipleName;
    }

    /**
     * Sets the value of the userPrincipleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPrincipleName(String value) {
        this.userPrincipleName = value;
    }

    /**
     * Gets the value of the machineDNSName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachineDNSName() {
        return machineDNSName;
    }

    /**
     * Sets the value of the machineDNSName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachineDNSName(String value) {
        this.machineDNSName = value;
    }

    /**
     * Gets the value of the channelId property.
     * 
     */
    public long getChannelId() {
        return channelId;
    }

    /**
     * Sets the value of the channelId property.
     * 
     */
    public void setChannelId(long value) {
        this.channelId = value;
    }

}
