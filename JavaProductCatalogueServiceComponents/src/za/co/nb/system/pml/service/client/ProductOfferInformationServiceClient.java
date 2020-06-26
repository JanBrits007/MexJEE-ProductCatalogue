package za.co.nb.system.pml.service.client;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibm.websphere.wssecurity.callbackhandler.UNTGenerateCallbackHandler;
import com.ibm.websphere.wssecurity.wssapi.WSSFactory;
import com.ibm.websphere.wssecurity.wssapi.WSSGenerationContext;
import com.ibm.websphere.wssecurity.wssapi.token.SecurityToken;
import com.ibm.websphere.wssecurity.wssapi.token.UsernameToken;

import za.co.nb.system.config.plm.environment.ServiceLocator;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.CharacteristicType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.CodeDescriptionType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.IProductOfferInformation;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ProductOfferInformation;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RateIdentifierType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.ResultSet;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRates;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse.InterestRateDetails;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.environment.Environment;


public class ProductOfferInformationServiceClient
{

  private final Log mLog = LogFactory.getLog(getClass());

  public double retrieveProductInterestRates(Holder<BigInteger> productIdentifier)
  {
    mLog.debug("Trace 1");
    BigDecimal effectiveInterestRate = null;
    List<BigDecimal> listEffectiveInterestRate = new ArrayList<BigDecimal>();
    Holder<ResultSet> resultSet = new Holder<ResultSet>();
    try
    {
      mLog.debug("Trace 2");

      RetrieveProductInterestRates.InterestRates interestRates = new RetrieveProductInterestRates.InterestRates();
      RateIdentifierType reIdentifierType = new RateIdentifierType();
      reIdentifierType.setRateId(null);
      reIdentifierType.setRateName("Nominal");
      interestRates.getInterestRate().add(reIdentifierType);
      Holder<String> featureIdentifier = new Holder<String>();
      CodeDescriptionType channelType = new CodeDescriptionType();
      String productLine = "investment";
      List<CharacteristicType> characteristicFilters = new ArrayList<CharacteristicType>();
      Holder<List<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse.InterestRateDetails>> interestRateDetails= new Holder<List<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse.InterestRateDetails>>();
      Holder<List<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse.CharacteristicSets>> characteristicSets = new Holder<List<za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.RetrieveProductInterestRatesResponse.CharacteristicSets>>();
   
      getProductOfferInformationPort().retrieveProductInterestRates(interestRates, productIdentifier, featureIdentifier, channelType, productLine, characteristicFilters, interestRateDetails, characteristicSets, resultSet);

      for(InterestRateDetails interestRate : interestRateDetails.value)
      {
    	  for(CharacteristicType characteristic : interestRate.getRateParameters())
    	  {
        	  if(characteristic.getType().getDescription().equalsIgnoreCase("Interest Frequency") && characteristic.getValue().equalsIgnoreCase("M")) 
        	  {        	
        		  effectiveInterestRate = interestRate.getInterestRate().getEffectiveInterestRate();
        		  listEffectiveInterestRate.add(effectiveInterestRate);
        	  }
    	  }	  
      }
      BigDecimal UpperRate = Collections.max(listEffectiveInterestRate);
      
      double highestInterestRate = UpperRate.doubleValue();

      mLog.debug("highestInterestRate: " + highestInterestRate);

      return highestInterestRate;
    }
    catch (Exception e)
    {
      mLog.error(">> ProductOfferInformation Service failed : " + e + " << ");
      e.printStackTrace();
      return 0.00;
    }

  }

  private IProductOfferInformation getProductOfferInformationPort()
  {
    try
    {
      mLog.debug("Trace 1");

      ProductOfferInformation service = new ProductOfferInformation();

      IProductOfferInformation port = (IProductOfferInformation) service.getProductOfferInformationEC2SOAPBindingPort();

      mLog.debug("Trace 2");
      
      String SERVICE_URL = "";

      if ( Environment.EnableDefaults )
      {
        SERVICE_URL = Environment.PRODUCT_OFFER_INFORMATION_SERVICE_URL.toString();
      }
      else
      {
        SERVICE_URL = (String) ServiceLocator.getInstance().getString("ProductOfferInformationServiceUrl");
      }
      mLog.debug("Trace 3 ");

      String USER_NAME_TOKEN = "";
      if ( Environment.EnableDefaults )
      {
        USER_NAME_TOKEN = Environment.SERVERUSERNAMETOKEN.toString();
      }
      else
      {
        USER_NAME_TOKEN = (String) ServiceLocator.getInstance().getString("ServerUsernameToken");
      }

      BindingProvider bindingProvider = (BindingProvider) port;

      bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, SERVICE_URL);

      Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();

      WSSFactory factory = WSSFactory.getInstance();

      WSSGenerationContext gencont = factory.newWSSGenerationContext();
      UNTGenerateCallbackHandler untCallbackHandler = new UNTGenerateCallbackHandler(USER_NAME_TOKEN, null);

      SecurityToken unt = factory.newSecurityToken(UsernameToken.class, untCallbackHandler);

      // add the SecurityToken to the WSSGenerationContext
      gencont.add(unt);

      // generate the WS-Security header
      gencont.process(req_ctx);

      return port;
    }
    catch (Exception ex)
    {
      mLog.debug("Trace 12");
      ex.printStackTrace();
    }
    mLog.debug("Trace 13");
    return null;
  }

}
