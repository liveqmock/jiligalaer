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

import sy.common.util.validator.impl.ValidateDigitsForNumberImpl;
import sy.common.util.validator.impl.ValidateDigitsForStringImpl;

/**
 * 校验一个数的整数部分与小数部分长度
 * 被注解Field必须是以下类型
 * <ul>
 * <li><code>BigDecimal</code></li>
 * <li><code>BigInteger</code></li>
 * <li><code>String</code></li>
 * <li><code>byte</code>, <code>short</code>, <code>int</code>, <code>long</code>,
 * 和他们的包装类</li>
 * </ul>
 * <p/>
 * <code>null</code> 值会通过校验
 * @author lidongbo
 * 2010-12-3
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidateDigitsForStringImpl.class,ValidateDigitsForNumberImpl.class})
public @interface ValidateDigits {

	String message() default "\"{description}\"的值,整数部分长度需小于{integer}且小数部分长度需小于{fraction}!";

	String  description();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};

	/**
	 * 整数部分的最大位数
	 */
	int integer();

	/**
	 * 小数部分的最大位数
	 */
	int fraction();


	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ValidateDigits[] value();
	}
}

