package sy.common.util.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lidongbo
 * 2010-12-2
 */
public class ValidatorRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6128158347667678457L;
	/**
	 * 错误信息集合
	 */
	private List<ValidatorMessage> validatorMessageCollection=new ArrayList<ValidatorMessage>();

	public List<ValidatorMessage> getValidatorMessageCollection() {
		return validatorMessageCollection;
	}
	
	public void addErrorMessage(ValidatorMessage validatorErrorMessage) {
		this.validatorMessageCollection.add(validatorErrorMessage);
	}
	
	public  int messageSize(){
		return validatorMessageCollection.size();
	}
	
}

