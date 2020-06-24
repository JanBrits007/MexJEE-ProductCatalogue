package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2.environment;

import za.co.nb.configuration.environment.ConfiguredValue;

public class Environment {
	
	public static class ProductOfferInformationServiceUrl extends ConfiguredValue<ProductOfferInformationServiceUrl>{
		public ProductOfferInformationServiceUrl(){
			super(ProductOfferInformationServiceUrl.class);
			DEV = "https://ssg-d.it.nednet.co.za:454/services/ent/productandservicedevelopment/productofferinformation/v2";
			ETE = "https://ssg-e.it.nednet.co.za:454/services/ent/productandservicedevelopment/productofferinformation/v2";
			QA = "https://ssg-q.it.nednet.co.za:454/services/ent/productandservicedevelopment/productofferinformation/v2";
			PROD = "https://ssg.it.nednet.co.za:454/services/ent/productandservicedevelopment/productofferinformation/v2";
					
		}
	}

	public static class ServerUsernameToken extends ConfiguredValue<ServerUsernameToken>{
		public ServerUsernameToken(){
			super(ServerUsernameToken.class);
			DEV = "AP411120";
			ETE = "AP411120";
			QA = "AP411120";
			PROD = "AP411120";
		}
	}
	
	public static class CurrentEnvironment extends ConfiguredValue<CurrentEnvironment>{
		public CurrentEnvironment(){
			super(CurrentEnvironment.class);
			DEV = "DEV";
			ETE = "ETE";
			QA = "QA";
			PROD = "PROD";
		}
	}

	public static boolean EnableDefaults = true;	
	public static ProductOfferInformationServiceUrl PRODUCT_OFFER_INFORMATION_SERVICE_URL = new ProductOfferInformationServiceUrl();
	public static ServerUsernameToken SERVERUSERNAMETOKEN = new ServerUsernameToken();
	public static CurrentEnvironment CURRENTENVIRONMENT = new CurrentEnvironment();
	
}

