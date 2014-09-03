package sy.common.util.validator.impl;

import sy.common.util.validator.annotations.ValidateSize;


/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public abstract class ValidateSizeForArraysOfPrimitivesImpl {

	protected int min;
	protected int max;

	public void initialize(ValidateSize parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
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

