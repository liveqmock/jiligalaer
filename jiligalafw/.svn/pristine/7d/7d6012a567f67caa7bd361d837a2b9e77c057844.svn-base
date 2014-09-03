package sy.common.util.validator.impl;

import java.lang.reflect.Array;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateSize;

/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public class ValidateSizeForArrayImpl implements ConstraintValidator<ValidateSize, Object[]> {
	private int min;
	private int max;

	public void initialize(ValidateSize parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
	}

	public boolean isValid(Object[] array, ConstraintValidatorContext constraintValidatorContext) {
		if ( array == null ) {
			return true;
		}
		int length = Array.getLength( array );
		return length >= min && length <= max;
	}

	private void validateParameters() {
		if ( min < 0 ) {
			throw new IllegalArgumentException( "min 参数不能为负数!" );
		}
		if ( max < 0 ) {
			throw new IllegalArgumentException( "min 参数不能为负数!" );
		}
		if ( max < min ) {
			throw new IllegalArgumentException( "max 参数不能小于min!" );
		}
	}
}

