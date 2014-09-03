package sy.common.util.validator;

import java.util.List;

/**
 * 
 * @author lidongbo
 * 2010-12-2
 */
public class ValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6128158347667678457L;

	private String errorKey;
	
	public ValidatorException(String message){
		this("errors", message);
	}
	
	public ValidatorException(String message, Throwable cause){
		this("errors", message,cause);
	}
	
	public ValidatorException(String errorKey,String message){
		super(message);
		this.errorKey = errorKey;
		ValidatorRuntimeException vre = new ValidatorRuntimeException();
		vre.addErrorMessage(new ValidatorMessage(message));
		validatorMessageCollection = vre.getValidatorMessageCollection();
	}
	
	public ValidatorException(String errorKey,String message, Throwable cause){
		super(message,cause);
		this.errorKey = errorKey;
		ValidatorRuntimeException vre = new ValidatorRuntimeException();
		vre.addErrorMessage(new ValidatorMessage(message));
		validatorMessageCollection = vre.getValidatorMessageCollection();
	}
	
	public ValidatorException(
			ValidatorRuntimeException validatorRuntimeException) {
		super(getMessageAsString(validatorRuntimeException),validatorRuntimeException);
		this.validatorMessageCollection = validatorRuntimeException
				.getValidatorMessageCollection();
	}
	/**
	 * 错误信息集合
	 */
	private final List<ValidatorMessage> validatorMessageCollection;

	public List<ValidatorMessage> getValidatorMessageCollection() {
		return validatorMessageCollection;
	}
	
	private static String getMessageAsString(ValidatorRuntimeException validatorRuntimeException){
		StringBuilder sb=new StringBuilder();
		for (ValidatorMessage validatorMessage : validatorRuntimeException.getValidatorMessageCollection()) {
			sb.append(validatorMessage.message()).append("\n");
		}
		return sb.toString();
	}
	
	public  int messageSize(){
		return validatorMessageCollection.size();
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
}

