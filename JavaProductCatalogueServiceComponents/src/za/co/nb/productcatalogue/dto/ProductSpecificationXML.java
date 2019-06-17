package za.co.nb.productcatalogue.dto;

import java.io.Serializable;

public class ProductSpecificationXML implements Serializable {

	private static final long serialVersionUID = -9021247044236249906L;

	private String mHeader;
	private String mDetails;
	
	public String getHeader() {
		return mHeader;
	}
	
	public void setHeader(String pHeader) {
		this.mHeader = pHeader;
	}
	
	public String getDetails() {
		return mDetails;
	}
	
	public void setmDetails(String pDetails) {
		this.mDetails = pDetails;
	}
/*	
	public String toString() {
		return "{'header': " + this.mHeader + ", 'details': " + this.mDetails + "}";
	}
*/	
}
