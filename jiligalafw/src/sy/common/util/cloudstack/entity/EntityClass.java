package sy.common.util.cloudstack.entity;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import sy.common.util.cloudstack.CloudBean;

/**
 *
 * @author lidongbo
 *
 */
@Target({ FIELD })
@Retention(RUNTIME)
public @interface EntityClass {

	Class<? extends CloudBean> cloudBean();
	
}
