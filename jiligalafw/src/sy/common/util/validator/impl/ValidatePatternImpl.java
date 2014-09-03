package sy.common.util.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sy.common.util.StringUtils;
import sy.common.util.validator.annotations.ValidatePattern;

/**
 * 
 * @author lidongbo
 * 2010-12-3
 */
public class ValidatePatternImpl implements ConstraintValidator<ValidatePattern, String> {

	private java.util.regex.Pattern pattern;

	public void initialize(ValidatePattern parameters) {
		ValidatePattern.Flag flags[] = parameters.flags();
		int intFlag = 0;
		for ( ValidatePattern.Flag flag : flags ) {
			intFlag = intFlag | flag.getValue();
		}

		try {
			pattern = java.util.regex.Pattern.compile( parameters.regexp(), intFlag );
		}
		catch ( PatternSyntaxException e ) {
			throw new IllegalArgumentException( "正则表达式书写错误!", e );
		}
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if ( value == null || StringUtils.isTrimEmpty(value)) {
			return true;
		}
		Matcher m = pattern.matcher( value );
		return m.matches();
	}
}
