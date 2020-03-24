package za.co.nb.productcatalogue.dto.deprecated;

import java.io.Serializable;

public class ProductCatalogueJSON implements Serializable {

	private static final long serialVersionUID = -9021247044236249906L;

	private String catalogue;
	
	public String getCatalogue() {
		return catalogue;
	}
	
	public void setCatalogue(String pcatalogue) { 
		this.catalogue = pcatalogue; 
	}
	
	public String toString() {
		return this.catalogue;
	}
	
}
