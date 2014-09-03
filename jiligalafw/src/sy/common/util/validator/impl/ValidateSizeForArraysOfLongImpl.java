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
public class ValidateSizeForArraysOfLongImpl extends ValidateSizeForArraysOfPrimitivesImpl
		implements ConstraintValidator<ValidateSize, long[]> {

	public boolean isValid(long[] array, ConstraintValidatorContext constraintValidatorContext) {
		if ( array == null ) {
			return true;
		}
		int length = Array.getLength( array );
		return length >= min && length <= max;
	}
}

