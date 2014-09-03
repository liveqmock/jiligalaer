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

import sy.common.util.validator.impl.ValidateSizeForArrayImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfBooleanImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfByteImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfCharImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfDoubleImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfFloatImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfIntImpl;
import sy.common.util.validator.impl.ValidateSizeForArraysOfLongImpl;
import sy.common.util.validator.impl.ValidateSizeForCollectionImpl;
import sy.common.util.validator.impl.ValidateSizeForMapImpl;
import sy.common.util.validator.impl.ValidateSizeForStringImpl;

/**
 * 被注解元素的大小必须在指定的边界之内
 * 
 * 被注解Field必须是以下类型
 * <ul>
 * <li><code>String</code> (String的长度)</li>
 * <li><code>Collection</code> (集合容器的大小)</li>
 * <li><code>Map</code> (map 容器的大小)</li>
 * <li>Array (数组的长度)</li>
 *
 * <code>null</code> 值会通过校验
 * @author lidongbo
 * 2010-12-3
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {
		 ValidateSizeForStringImpl.class ,
		 ValidateSizeForCollectionImpl.class ,
		 ValidateSizeForArrayImpl.class ,
		 ValidateSizeForMapImpl.class ,
		 ValidateSizeForArraysOfBooleanImpl.class ,
		 ValidateSizeForArraysOfByteImpl.class ,
		 ValidateSizeForArraysOfCharImpl.class ,
		 ValidateSizeForArraysOfDoubleImpl.class ,
		 ValidateSizeForArraysOfFloatImpl.class ,
		 ValidateSizeForArraysOfIntImpl.class ,
		 ValidateSizeForArraysOfLongImpl.class ,
})
public @interface ValidateSize {
	
	String message() default "\"{description}\"的长度(或个数)不能小于{min}且不能大于{max}";
	
	String description();
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 0;

	int max() default Integer.MAX_VALUE;

	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ValidateSize[] value();
	}
}

