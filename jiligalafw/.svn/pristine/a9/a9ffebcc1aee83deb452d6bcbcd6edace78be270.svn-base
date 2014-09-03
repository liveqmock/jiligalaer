package sy.common.util.validator.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateDecimalMin;


/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public class ValidateDecimalMinForNumberImpl implements ConstraintValidator<ValidateDecimalMin, Number> {

	private BigDecimal minValue;

	public void initialize(ValidateDecimalMin minValue) {
		try {
			this.minValue = new BigDecimal( minValue.value() );
		}
		catch ( NumberFormatException nfe ) {
			throw new IllegalArgumentException(
					minValue.value() + " 不是一个正确的数值,请开发人员写入正确的参数!", nfe
			);
		}
	}

	public boolean isValid(Number value, ConstraintValidatorContext constraintValidatorContext) {

		//空值视为有效
		if ( value == null ) {
			return true;
		}

		if ( value instanceof BigDecimal ) {
			return ( ( BigDecimal ) value ).compareTo( minValue ) != -1;
		}
		else if ( value instanceof BigInteger ) {
			return ( new BigDecimal( ( BigInteger ) value ) ).compareTo( minValue ) != -1;
		}
		else {
			return ( BigDecimal.valueOf( value.longValue() ).compareTo( minValue ) ) != -1;
		}
	}
}

