package sy.common.util.validator.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import sy.common.util.validator.impl.ValidateIsDateFormatImpl;

/**
 * 校验日期格式是否是yyyy-MM-dd
 * 被注解Field必须是以下类型
 * <ul>
 * <li><code>String</code></li>
 * </ul>
 * <p/>
 * <code>null</code> 值会通过校验
 * @author lidongbo
 * 2010-12-1
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateIsDateFormatImpl.class)
@Documented
public @interface ValidateIsDateFormat {
	
	String message() default "\"{description}\"日期格式不正确!";
	
	String description();
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String format();
}

