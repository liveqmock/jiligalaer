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

import sy.common.util.validator.impl.ValidateDecimalMaxForNumberImpl;
import sy.common.util.validator.impl.ValidateDecimalMaxForStringImpl;

/**
 * 注解的值要小于或等于valu值
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
@Constraint(validatedBy = {ValidateDecimalMaxForNumberImpl.class,ValidateDecimalMaxForStringImpl.class })
public @interface ValidateDecimalMax {
	
	String message() default "\"{description}\"的值必须小于或等于{value}!";

	String  description();
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};

	String value();

	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
			@interface List {
		ValidateDecimalMax[] value();
	}
}

