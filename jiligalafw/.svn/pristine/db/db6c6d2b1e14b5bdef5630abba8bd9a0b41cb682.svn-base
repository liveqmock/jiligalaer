package sy.common.util.validator.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateDecimalMax;

/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public class ValidateDecimalMaxForNumberImpl implements ConstraintValidator<ValidateDecimalMax, Number> {

	private BigDecimal maxValue;

	public void initialize(ValidateDecimalMax maxValue) {
		try {
			this.maxValue = new BigDecimal( maxValue.value() );
		}
		catch ( NumberFormatException nfe ) {
			throw new IllegalArgumentException(
					maxValue.value() + " 不是一个正确的数值,请开发人员写入正确的参数!", nfe
			);
		}
	}

	public boolean isValid(Number value, ConstraintValidatorContext constraintValidatorContext) {
		//空值视为有效
		if ( value == null ) {
			return true;
		}

		if ( value instanceof BigDecimal ) {
			return ( ( BigDecimal ) value ).compareTo( maxValue ) != 1;
		}
		else if ( value instanceof BigInteger ) {
			return ( new BigDecimal( ( BigInteger ) value ) ).compareTo( maxValue ) != 1;
		}
		else {
			return ( BigDecimal.valueOf( value.longValue() ).compareTo( maxValue ) ) != 1;
		}
	}
}
