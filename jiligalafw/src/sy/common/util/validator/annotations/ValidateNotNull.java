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

import sy.common.util.validator.impl.ValidateNotNullImpl;

/**
 * 校验值是否为空，可以标注任意对象
 * @author lidongbo
 * 2010-12-1
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidateNotNullImpl.class})
public @interface ValidateNotNull {
	
	String message() default "\"{description}\"不允许为空!";

	String  description();
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};

	/**
	 * Example
	 * @NotNull.List({
	 * 		@NotNull(description="描述信息A"),
	 * 		@NotNull(description="描述信息B"),
	 * 		@NotNull(description="描述信息C")
	 * })
	 * @author lidongbo
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ValidateNotNull[] value();
	}
}

