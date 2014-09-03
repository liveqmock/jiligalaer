package sy.common.util.validator.impl;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.validator.annotations.ValidateDigits;

/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public class ValidateDigitsForNumberImpl implements ConstraintValidator<ValidateDigits, Number> {

	private int maxIntegerLength;
	private int maxFractionLength;

	public void initialize(ValidateDigits constraintAnnotation) {
		this.maxIntegerLength = constraintAnnotation.integer();
		this.maxFractionLength = constraintAnnotation.fraction();
		validateParameters();
	}

	public boolean isValid(Number num, ConstraintValidatorContext constraintValidatorContext) {
		//空值视为有效
		if ( num == null ) {
			return true;
		}

		BigDecimal bigNum;
		if ( num instanceof BigDecimal ) {
			bigNum = ( BigDecimal ) num;
		}
		else {
			bigNum = new BigDecimal( num.toString() ).stripTrailingZeros();
		}

		int integerPartLength = bigNum.precision() - bigNum.scale();
		int fractionPartLength = bigNum.scale() < 0 ? 0 : bigNum.scale();

		return ( maxIntegerLength >= integerPartLength && maxFractionLength >= fractionPartLength );
	}

	private void validateParameters() {
		if ( maxIntegerLength < 0 ) {
			throw new IllegalArgumentException( "整数部分的长度不能为负数,请开发人员改变参数!" );
		}
		if ( maxFractionLength < 0 ) {
			throw new IllegalArgumentException( "小数部分的长度不能为负数,请开发人员改变参数!" );
		}
	}
}

