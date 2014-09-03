package sy.common.util.validator.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import sy.common.util.validator.impl.ValidatePatternImpl;


/**
 * 标注的String Field必须满足正则表达式参数
 * 正则的语法满足java.util.regex.Pattern
 * <code>null</code> 值会通过校验
 * @author lidongbo
 * 2010-12-3
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidatePatternImpl.class})
public @interface ValidatePattern {
	
	String regexp();

	String description();
	
	String regexpName();
	
	Flag[] flags() default {};

	String message() default "\"{description}\"不满足[{regexpName}]格式!";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};

	/**
	 * Regexp flags
	 */
	public static enum Flag {

		/**
		 * 启用 Unix lines 模式
		 * @see java.util.regex.Pattern#UNIX_LINES
		 */
		UNIX_LINES(java.util.regex.Pattern.UNIX_LINES),

		/** 
		 * 启用 case-insensitive matching
		 * @see java.util.regex.Pattern#CASE_INSENSITIVE
		 */
		CASE_INSENSITIVE(java.util.regex.Pattern.CASE_INSENSITIVE),

		/**
		 * Permits whitespace and comments in pattern
		 * @see java.util.regex.Pattern#COMMENTS
		 */
		COMMENTS(java.util.regex.Pattern.COMMENTS),

		/**
		 * 启用 multiline 模式
		 * @see java.util.regex.Pattern#MULTILINE
		 */
		MULTILINE(java.util.regex.Pattern.MULTILINE),

		/**
		 * 启用 dotall 模式
		 * @see java.util.regex.Pattern#DOTALL
		 */
		DOTALL(java.util.regex.Pattern.DOTALL),

		/**
		 * 启用 Unicode-aware case folding
		 * @see java.util.regex.Pattern#UNICODE_CASE
		 */
		UNICODE_CASE(java.util.regex.Pattern.UNICODE_CASE),

		/**
		 * 启用 canonical equivalence
		 * @see java.util.regex.Pattern#CANON_EQ
		 */
		CANON_EQ(java.util.regex.Pattern.CANON_EQ);

		//JDK flag 
		private final int value;

		private Flag(int value) {
			this.value = value;
		}

		/**
		 * @return flag 定义在 {@link java.util.regex.Pattern}
		 */
		public int getValue() {
			return value;
		}
	}

	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ValidatePattern[] value();
	}
}

