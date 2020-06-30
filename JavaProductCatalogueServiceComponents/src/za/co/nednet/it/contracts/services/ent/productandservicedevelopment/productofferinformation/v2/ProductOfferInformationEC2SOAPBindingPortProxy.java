package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Holder;
import javax.xml.ws.Response;

public class ProductOfferInformationEC2SOAPBindingPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ProductOfferInformation _service = null;
        private za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.IProductOfferInformation _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ProductOfferInformation(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ProductOfferInformation();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getProductOfferInformationEC2SOAPBindingPort();
        }

        public za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.IProductOfferInformation getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "ProductOfferInformationEC2SOAPBindingPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public ProductOfferInformationEC2SOAPBindingPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public ProductOfferInformationEC2SOAPBindingPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public Response<RetrieveProductFeesResponse> retrieveProductFeesAsync(List<FeeIdentifierType> fees, BigInteger productIdentifier, String featureIdentifier, CodeDescriptionType channelType, String productLine, List<CharacteristicType> characteristicFilters) {
        return _getDescriptor().getProxy().retrieveProductFeesAsync(fees,productIdentifier,featureIdentifier,channelType,productLine,characteristicFilters);
    }

    public Future<?> retrieveProductFeesAsync(List<FeeIdentifierType> fees, BigInteger productIdentifier, String featureIdentifier, CodeDescriptionType channelType, String productLine, List<CharacteristicType> characteristicFilters, AsyncHandler<RetrieveProductFeesResponse> asyncHandler) {
        return _getDescriptor().getProxy().retrieveProductFeesAsync(fees,productIdentifier,featureIdentifier,channelType,productLine,characteristicFilters,asyncHandler);
    }

    public void retrieveProductFees(List<FeeIdentifierType> fees, Holder<BigInteger> productIdentifier, Holder<String> featureIdentifier, CodeDescriptionType channelType, String productLine, List<CharacteristicType> characteristicFilters, Holder<List<RetrieveProductFeesResponse.FeeDetails>> feeDetails, Holder<List<RetrieveProductFeesResponse.CharacteristicsSets>> characteristicsSets, Holder<ResultSet> resultSet) {
        _getDescriptor().getProxy().retrieveProductFees(fees,productIdentifier,featureIdentifier,channelType,productLine,characteristicFilters,feeDetails,characteristicsSets,resultSet);
    }

    public Response<RetrieveProductInterestRatesResponse> retrieveProductInterestRatesAsync(za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates.InterestRates interestRates, BigInteger productIdentifier, String featureIdentifier, CodeDescriptionType channelType, String productLine, List<CharacteristicType> characteristicFilters) {
        return _getDescriptor().getProxy().retrieveProductInterestRatesAsync(interestRates,productIdentifier,featureIdentifier,channelType,productLine,characteristicFilters);
    }

    public Future<?> retrieveProductInterestRatesAsync(za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates.InterestRates interestRates, BigInteger productIdentifier, String featureIdentifier, CodeDescriptionType channelType, String productLine, List<CharacteristicType> characteristicFilters, AsyncHandler<RetrieveProductInterestRatesResponse> asyncHandler) {
        return _getDescriptor().getProxy().retrieveProductInterestRatesAsync(interestRates,productIdentifier,featureIdentifier,channelType,productLine,characteristicFilters,asyncHandler);
    }

    public void retrieveProductInterestRates(za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates.InterestRates interestRates, Holder<BigInteger> productIdentifier, Holder<String> featureIdentifier, CodeDescriptionType channelType, String productLine, List<CharacteristicType> characteristicFilters, Holder<List<RetrieveProductInterestRatesResponse.InterestRateDetails>> interestRateDetails, Holder<List<RetrieveProductInterestRatesResponse.CharacteristicSets>> characteristicSets, Holder<ResultSet> resultSet) {
        _getDescriptor().getProxy().retrieveProductInterestRates(interestRates,productIdentifier,featureIdentifier,channelType,productLine,characteristicFilters,interestRateDetails,characteristicSets,resultSet);
    }

    public Response<RetrieveProductOfferInformationResponse> retrieveProductOfferInformationAsync(BigInteger productIdentifier, List<CodeDescriptionType> channelType, String productLine, List<CharacteristicType> characteristicFilters) {
        return _getDescriptor().getProxy().retrieveProductOfferInformationAsync(productIdentifier,channelType,productLine,characteristicFilters);
    }

    public Future<?> retrieveProductOfferInformationAsync(BigInteger productIdentifier, List<CodeDescriptionType> channelType, String productLine, List<CharacteristicType> characteristicFilters, AsyncHandler<RetrieveProductOfferInformationResponse> asyncHandler) {
        return _getDescriptor().getProxy().retrieveProductOfferInformationAsync(productIdentifier,channelType,productLine,characteristicFilters,asyncHandler);
    }

    public void retrieveProductOfferInformation(Holder<BigInteger> productIdentifier, List<CodeDescriptionType> channelType, String productLine, List<CharacteristicType> characteristicFilters, Holder<List<ProductNameType>> productNames, Holder<List<ProductAlternativeIdentifier>> productAlternativeIdentifiers, Holder<List<ConditionType>> productConditions, Holder<List<RetrieveProductOfferInformationResponse.ProductFeatureDetails>> productFeatureDetails, Holder<RetrieveProductOfferInformationResponse.ProductRateConditions> productRateConditions, Holder<List<RetrieveProductOfferInformationResponse.ResourceItemDetails>> resourceItemDetails, Holder<List<RetrieveProductOfferInformationResponse.CharacteristicSets>> characteristicSets, Holder<ResultSet> resultSet) {
        _getDescriptor().getProxy().retrieveProductOfferInformation(productIdentifier,channelType,productLine,characteristicFilters,productNames,productAlternativeIdentifiers,productConditions,productFeatureDetails,productRateConditions,resourceItemDetails,characteristicSets,resultSet);
    }

}