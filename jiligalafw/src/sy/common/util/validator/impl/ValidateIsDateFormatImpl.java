package sy.common.util.validator.impl;

import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateIsDateFormat;
/**
 * @author lidongbo
 * 2010-12-1   
 */
public class ValidateIsDateFormatImpl implements ConstraintValidator<ValidateIsDateFormat, String> {
	
	private String format;
	
	public void initialize(ValidateIsDateFormat constraintAnnotation) {
		this.format = constraintAnnotation.format();
	}

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		if(object==null)return true;
		try {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			sf.setLenient(false);
			sf.parse((String)object);
			return true;
		} catch (Exception pe) {
			return false;
		}
	}

}
