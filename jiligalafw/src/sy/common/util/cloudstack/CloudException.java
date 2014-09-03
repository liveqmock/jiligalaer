package sy.common.util.cloudstack;


/**
 * 
 * @author lidongbo
 * 
 */
public class CloudException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 420150772794924967L;

	private CloudErrorType errorType;
	private int httpCode;

	public CloudException() {
		super();
	}

	public CloudException(String message) {
		super(message);
	}

	public CloudException(String message, Throwable cause) {
		super(message, cause);
	}

	public CloudException(Throwable cause) {
		super(cause);
	}

	public CloudException(CloudErrorType type, int httpCode,String msg) {
		super(msg);
		this.errorType = type;
		this.httpCode = httpCode;
	}
	
	public CloudException(int httpCode,String msg) {
		super(msg);
		this.httpCode = httpCode;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public CloudErrorType getErrorType() {
		return (errorType == null ? CloudErrorType.GENERAL : errorType);
	}

}
