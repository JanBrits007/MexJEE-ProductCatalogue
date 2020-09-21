package za.co.nb.productcatalogue.exceptions;

public class BusinessRuleExecutionException extends Exception {

	private static final long serialVersionUID = 1L;

	BusinessRuleExecutionException(String message) {
		super(message);
	}
}
