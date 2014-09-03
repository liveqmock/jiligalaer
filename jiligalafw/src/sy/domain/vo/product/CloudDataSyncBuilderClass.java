package sy.domain.vo.product;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 *
 * @author lidongbo
 *
 */
@Target({ FIELD })
@Retention(RUNTIME)
public @interface CloudDataSyncBuilderClass {

	Class<? extends CloudDataSyncBuilder<?>> beanClass();
}
