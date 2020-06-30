package za.co.nb.system.config.plm.environment;

/**
 * @author staigerr
 *
 */
public class ServiceLocatorException extends Exception {


	/**
	 * 
	 */
	public ServiceLocatorException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public ServiceLocatorException(String message) {
		super(message);
	}
	/**
	 * @param message
	 * @param cause
	 */
	public ServiceLocatorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ServiceLocatorException(Throwable cause) {
		super(cause);
	}
}
