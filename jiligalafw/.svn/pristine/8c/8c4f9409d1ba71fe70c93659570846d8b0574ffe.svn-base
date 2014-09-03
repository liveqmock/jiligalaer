package sy.common.util.validator.impl;

import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateSize;

/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public class ValidateSizeForMapImpl  implements ConstraintValidator<ValidateSize, Map> {
	private int min;
	private int max;

	public void initialize(ValidateSize parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
	}


	public boolean isValid(Map map, ConstraintValidatorContext constraintValidatorContext) {
		if ( map == null ) {
			return true;
		}
		int size = map.size();
		return size >= min && size <= max;
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

