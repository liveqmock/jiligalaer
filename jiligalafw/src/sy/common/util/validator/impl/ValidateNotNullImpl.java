package sy.common.util.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateNotNull;

/**
 * 
 * @author lidongbo
 * 2010-12-1
 */
public class ValidateNotNullImpl implements ConstraintValidator<ValidateNotNull, Object> {
	
	public void initialize(ValidateNotNull parameters) {
	}

	public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
		return object != null;
	}
}

