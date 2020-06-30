
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "iProductOfferInformation", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
@XmlSeeAlso({
    za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ObjectFactory.class,
    za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext.ObjectFactory.class
})
public interface IProductOfferInformation {


    /**
     * Retrieve the product specific fees
     * 
     * @param featureIdentifier
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param fees
     * @return
     *     returns javax.xml.ws.Response<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFeesResponse>
     */
    @WebMethod(operationName = "RetrieveProductFees", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductFees")
    @RequestWrapper(localName = "RetrieveProductFees", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFees")
    @ResponseWrapper(localName = "RetrieveProductFeesResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFeesResponse")
    public Response<RetrieveProductFeesResponse> retrieveProductFeesAsync(
        @WebParam(name = "fees", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<FeeIdentifierType> fees,
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        BigInteger productIdentifier,
        @WebParam(name = "featureIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String featureIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        CodeDescriptionType channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters);

    /**
     * Retrieve the product specific fees
     * 
     * @param featureIdentifier
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param asyncHandler
     * @param fees
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "RetrieveProductFees", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductFees")
    @RequestWrapper(localName = "RetrieveProductFees", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFees")
    @ResponseWrapper(localName = "RetrieveProductFeesResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFeesResponse")
    public Future<?> retrieveProductFeesAsync(
        @WebParam(name = "fees", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<FeeIdentifierType> fees,
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        BigInteger productIdentifier,
        @WebParam(name = "featureIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String featureIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        CodeDescriptionType channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<RetrieveProductFeesResponse> asyncHandler);

    /**
     * Retrieve the product specific fees
     * 
     * @param featureIdentifier
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param feeDetails
     * @param resultSet
     * @param fees
     * @param characteristicsSets
     */
    @WebMethod(operationName = "RetrieveProductFees", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductFees")
    @RequestWrapper(localName = "RetrieveProductFees", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFees")
    @ResponseWrapper(localName = "RetrieveProductFeesResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductFeesResponse")
    public void retrieveProductFees(
        @WebParam(name = "fees", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<FeeIdentifierType> fees,
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.INOUT)
        Holder<BigInteger> productIdentifier,
        @WebParam(name = "featureIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.INOUT)
        Holder<String> featureIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        CodeDescriptionType channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters,
        @WebParam(name = "feeDetails", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductFeesResponse.FeeDetails>> feeDetails,
        @WebParam(name = "characteristicsSets", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductFeesResponse.CharacteristicsSets>> characteristicsSets,
        @WebParam(name = "resultSet", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<ResultSet> resultSet);

    /**
     * Retrieve product specific interest rates
     * 
     * @param featureIdentifier
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param interestRates
     * @return
     *     returns javax.xml.ws.Response<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse>
     */
    @WebMethod(operationName = "RetrieveProductInterestRates", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductInterestRates")
    @RequestWrapper(localName = "RetrieveProductInterestRates", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates")
    @ResponseWrapper(localName = "RetrieveProductInterestRatesResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse")
    public Response<RetrieveProductInterestRatesResponse> retrieveProductInterestRatesAsync(
        @WebParam(name = "interestRates", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates.InterestRates interestRates,
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        BigInteger productIdentifier,
        @WebParam(name = "featureIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String featureIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        CodeDescriptionType channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters);

    /**
     * Retrieve product specific interest rates
     * 
     * @param featureIdentifier
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param interestRates
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "RetrieveProductInterestRates", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductInterestRates")
    @RequestWrapper(localName = "RetrieveProductInterestRates", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates")
    @ResponseWrapper(localName = "RetrieveProductInterestRatesResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse")
    public Future<?> retrieveProductInterestRatesAsync(
        @WebParam(name = "interestRates", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates.InterestRates interestRates,
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        BigInteger productIdentifier,
        @WebParam(name = "featureIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String featureIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        CodeDescriptionType channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<RetrieveProductInterestRatesResponse> asyncHandler);

    /**
     * Retrieve product specific interest rates
     * 
     * @param featureIdentifier
     * @param interestRateDetails
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param interestRates
     * @param resultSet
     * @param characteristicSets
     */
    @WebMethod(operationName = "RetrieveProductInterestRates", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductInterestRates")
    @RequestWrapper(localName = "RetrieveProductInterestRates", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates")
    @ResponseWrapper(localName = "RetrieveProductInterestRatesResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse")
    public void retrieveProductInterestRates(
        @WebParam(name = "interestRates", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates.InterestRates interestRates,
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.INOUT)
        Holder<BigInteger> productIdentifier,
        @WebParam(name = "featureIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.INOUT)
        Holder<String> featureIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        CodeDescriptionType channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters,
        @WebParam(name = "interestRateDetails", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductInterestRatesResponse.InterestRateDetails>> interestRateDetails,
        @WebParam(name = "characteristicSets", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductInterestRatesResponse.CharacteristicSets>> characteristicSets,
        @WebParam(name = "resultSet", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<ResultSet> resultSet);

    /**
     * Retrieve information relevant to Product offering.  Characteristic sets is a Card specific requirement and not applicable to other products at this stage
     * 
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @return
     *     returns javax.xml.ws.Response<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformationResponse>
     */
    @WebMethod(operationName = "RetrieveProductOfferInformation", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductOfferInformation")
    @RequestWrapper(localName = "RetrieveProductOfferInformation", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformation")
    @ResponseWrapper(localName = "RetrieveProductOfferInformationResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformationResponse")
    public Response<RetrieveProductOfferInformationResponse> retrieveProductOfferInformationAsync(
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        BigInteger productIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CodeDescriptionType> channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters);

    /**
     * Retrieve information relevant to Product offering.  Characteristic sets is a Card specific requirement and not applicable to other products at this stage
     * 
     * @param characteristicFilters
     * @param channelType
     * @param productLine
     * @param productIdentifier
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "RetrieveProductOfferInformation", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductOfferInformation")
    @RequestWrapper(localName = "RetrieveProductOfferInformation", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformation")
    @ResponseWrapper(localName = "RetrieveProductOfferInformationResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformationResponse")
    public Future<?> retrieveProductOfferInformationAsync(
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        BigInteger productIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CodeDescriptionType> channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<RetrieveProductOfferInformationResponse> asyncHandler);

    /**
     * Retrieve information relevant to Product offering.  Characteristic sets is a Card specific requirement and not applicable to other products at this stage
     * 
     * @param productConditions
     * @param characteristicFilters
     * @param channelType
     * @param productFeatureDetails
     * @param productLine
     * @param productRateConditions
     * @param productAlternativeIdentifiers
     * @param productNames
     * @param productIdentifier
     * @param resultSet
     * @param characteristicSets
     * @param resourceItemDetails
     */
    @WebMethod(operationName = "RetrieveProductOfferInformation", action = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2/RetrieveProductOfferInformation")
    @RequestWrapper(localName = "RetrieveProductOfferInformation", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformation")
    @ResponseWrapper(localName = "RetrieveProductOfferInformationResponse", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", className = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductOfferInformationResponse")
    public void retrieveProductOfferInformation(
        @WebParam(name = "productIdentifier", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.INOUT)
        Holder<BigInteger> productIdentifier,
        @WebParam(name = "channelType", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CodeDescriptionType> channelType,
        @WebParam(name = "productLine", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        String productLine,
        @WebParam(name = "characteristicFilters", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2")
        List<CharacteristicType> characteristicFilters,
        @WebParam(name = "productNames", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<ProductNameType>> productNames,
        @WebParam(name = "productAlternativeIdentifiers", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<ProductAlternativeIdentifier>> productAlternativeIdentifiers,
        @WebParam(name = "productConditions", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<ConditionType>> productConditions,
        @WebParam(name = "productFeatureDetails", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductOfferInformationResponse.ProductFeatureDetails>> productFeatureDetails,
        @WebParam(name = "productRateConditions", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<RetrieveProductOfferInformationResponse.ProductRateConditions> productRateConditions,
        @WebParam(name = "resourceItemDetails", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductOfferInformationResponse.ResourceItemDetails>> resourceItemDetails,
        @WebParam(name = "characteristicSets", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<List<RetrieveProductOfferInformationResponse.CharacteristicSets>> characteristicSets,
        @WebParam(name = "resultSet", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", mode = WebParam.Mode.OUT)
        Holder<ResultSet> resultSet);

}
