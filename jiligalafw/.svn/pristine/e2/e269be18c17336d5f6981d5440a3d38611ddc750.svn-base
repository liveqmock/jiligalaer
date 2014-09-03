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
public class ValidateSizeForArraysOfIntImpl extends ValidateSizeForArraysOfPrimitivesImpl
		implements ConstraintValidator<ValidateSize, int[]> {

	public boolean isValid(int[] array, ConstraintValidatorContext constraintValidatorContext) {
		if ( array == null ) {
			return true;
		}
		int length = Array.getLength( array );
		return length >= min && length <= max;
	}
}

