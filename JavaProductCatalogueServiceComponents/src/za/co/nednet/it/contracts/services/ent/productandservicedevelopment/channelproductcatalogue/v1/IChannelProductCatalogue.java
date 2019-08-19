//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "iChannelProductCatalogue", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IChannelProductCatalogue {


    /**
     * Returns a list of products based on certain search criteria
     * 
     * @param productLinesID
     * @param productFamilyID
     * @param productCategoryID
     * @param productCatalogue
     * @param resultSet
     */
    @WebMethod(operationName = "RetrieveProducts", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1/RetrieveProducts")
    @RequestWrapper(localName = "RetrieveProducts", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.RetrieveProductsType")
    @ResponseWrapper(localName = "RetrieveProductsResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.RetrieveProductsResponseType")
    public void retrieveProducts(
        @WebParam(name = "productCategoryID", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1")
        String productCategoryID,
        @WebParam(name = "productFamilyID", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1")
        String productFamilyID,
        @WebParam(name = "productLinesID", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1")
        String productLinesID,
        @WebParam(name = "resultSet", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", mode = WebParam.Mode.OUT)
        Holder<ResultSetType> resultSet,
        @WebParam(name = "productCatalogue", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", mode = WebParam.Mode.OUT)
        Holder<ProductCatalogueType> productCatalogue);

    /**
     * Retrieves the complete product hierarchy, together with channel-centred metadata, such as filterable attributes for a given product category in the product hierarchy.
     * 
     * @param productCatalogueID
     * @param productCatalogue
     * @param resultSet
     */
    @WebMethod(operationName = "GetProductHierarchy", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1/GetProductHierarchy")
    @RequestWrapper(localName = "GetProductHierarchy", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.GetProductHierarchyType")
    @ResponseWrapper(localName = "GetProductHierarchyResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.GetProductHierarchyResponseType")
    public void getProductHierarchy(
        @WebParam(name = "productCatalogueID", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1")
        String productCatalogueID,
        @WebParam(name = "resultSet", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", mode = WebParam.Mode.OUT)
        Holder<ResultSetType> resultSet,
        @WebParam(name = "productCatalogue", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", mode = WebParam.Mode.OUT)
        Holder<ProductCatalogueType> productCatalogue);

    /**
     * Retrieves the complete information for a given product
     * 
     * @param product
     * @param productIdentifier
     * @param resultSet
     */
    @WebMethod(operationName = "GetProduct", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1/GetProduct")
    @RequestWrapper(localName = "GetProduct", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.GetProductType")
    @ResponseWrapper(localName = "GetProductResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.GetProductResponseType")
    public void getProduct(
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1")
        List<Integer> productIdentifier,
        @WebParam(name = "resultSet", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", mode = WebParam.Mode.OUT)
        Holder<ResultSetType> resultSet,
        @WebParam(name = "product", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", mode = WebParam.Mode.OUT)
        Holder<List<ProductType>> product);

    /**
     * CRUD operations for a given product
     * 
     * @param maintainCatalogueRequest
     * @return
     *     returns za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.MaintainCatalogueResponseType
     */
    @WebMethod(operationName = "MaintainCatalogue", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1/MaintainCatalogue")
    @WebResult(name = "MaintainCatalogueResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", partName = "MaintainCatalogueResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public MaintainCatalogueResponseType maintainCatalogue(
        @WebParam(name = "MaintainCatalogueRequest", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", partName = "MaintainCatalogueRequest")
        MaintainCatalogueRequestType maintainCatalogueRequest);

    /**
     * Mapping Product ID between ProductSpec and Siyaka
     * 
     * @param getProductMappingRequest
     * @return
     *     returns za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.GetProductMappingResponseType
     */
    @WebMethod(operationName = "GetProductMapping", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1/GetProductMapping")
    @WebResult(name = "GetProductMappingResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", partName = "GetProductMappingResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public GetProductMappingResponseType getProductMapping(
        @WebParam(name = "GetProductMappingRequest", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", partName = "GetProductMappingRequest")
        GetProductMappingRequestType getProductMappingRequest);

}
