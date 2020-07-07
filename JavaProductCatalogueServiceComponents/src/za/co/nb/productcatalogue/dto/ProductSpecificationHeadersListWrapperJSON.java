package za.co.nb.productcatalogue.dto;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductSpecificationHeadersListWrapperJSON implements Serializable {

	private static final long serialVersionUID = -9021247044236249906L;

	private String categoryName;
	private List<String> mHeaders = new LinkedList<String>();
	
	public List<String> getHeaders() {
		return mHeaders;
	}
	
	public void setHeaders(List<String> pHeader) {
		this.mHeaders = pHeader;
	}
	
	public String toString() {
		Iterator<String> vIterator = mHeaders.iterator();

    	String vString = "{'headers': [";
		
		while(vIterator.hasNext()) {
			String vHeader = vIterator.next();
	    	
	    	vString = vString + vHeader;

	    	if(vIterator.hasNext()) {
		    	vString = vString + ", ";	    		
	    	}
		}

    	vString = vString + "]}";

    	return vString;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}	
}
