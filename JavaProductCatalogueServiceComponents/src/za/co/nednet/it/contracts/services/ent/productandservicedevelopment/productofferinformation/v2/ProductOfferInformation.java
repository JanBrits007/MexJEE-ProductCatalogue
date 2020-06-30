
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ProductOfferInformation", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", wsdlLocation = "META-INF/wsdl/ProductOfferInformation_v2.0_EC2SoapEndpoint.wsdl")
public class ProductOfferInformation
    extends Service
{

    private final static URL PRODUCTOFFERINFORMATION_WSDL_LOCATION;
    private final static WebServiceException PRODUCTOFFERINFORMATION_EXCEPTION;
    private final static QName PRODUCTOFFERINFORMATION_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "ProductOfferInformation");

    static {
            PRODUCTOFFERINFORMATION_WSDL_LOCATION = za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ProductOfferInformation.class.getClassLoader().getResource("/META-INF/wsdl/ProductOfferInformation_v2.0_EC2SoapEndpoint.wsdl");
        WebServiceException e = null;
        if (PRODUCTOFFERINFORMATION_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'META-INF/wsdl/ProductOfferInformation_v2.0_EC2SoapEndpoint.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        PRODUCTOFFERINFORMATION_EXCEPTION = e;
    }

    public ProductOfferInformation() {
        super(__getWsdlLocation(), PRODUCTOFFERINFORMATION_QNAME);
    }

    public ProductOfferInformation(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCTOFFERINFORMATION_QNAME, features);
    }

    public ProductOfferInformation(URL wsdlLocation) {
        super(wsdlLocation, PRODUCTOFFERINFORMATION_QNAME);
    }

    public ProductOfferInformation(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCTOFFERINFORMATION_QNAME, features);
    }

    public ProductOfferInformation(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductOfferInformation(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IProductOfferInformation
     */
    @WebEndpoint(name = "ProductOfferInformationEC2SOAPBindingPort")
    public IProductOfferInformation getProductOfferInformationEC2SOAPBindingPort() {
        return super.getPort(new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "ProductOfferInformationEC2SOAPBindingPort"), IProductOfferInformation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IProductOfferInformation
     */
    @WebEndpoint(name = "ProductOfferInformationEC2SOAPBindingPort")
    public IProductOfferInformation getProductOfferInformationEC2SOAPBindingPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "ProductOfferInformationEC2SOAPBindingPort"), IProductOfferInformation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCTOFFERINFORMATION_EXCEPTION!= null) {
            throw PRODUCTOFFERINFORMATION_EXCEPTION;
        }
        return PRODUCTOFFERINFORMATION_WSDL_LOCATION;
    }

}
