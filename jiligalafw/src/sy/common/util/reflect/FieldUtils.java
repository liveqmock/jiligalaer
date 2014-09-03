package sy.common.util.reflect;

import java.lang.reflect.Field;

/**
 * 
 * @author lidongbo
 * 
 */
public class FieldUtils {

	public static Field getFieldFromHierarchy(final Class<?> cls,
			String fieldName) {
		if (cls == null) {
			throw new IllegalArgumentException("The class must not be null");
		}
		if (fieldName == null) {
			throw new IllegalArgumentException(
					"The field name must not be null");
		}

		// check up the superclass hierarchy
		for (Class<?> acls = cls; acls != null; acls = acls.getSuperclass()) {
			try {
				return acls.getDeclaredField(fieldName);
			} catch (NoSuchFieldException ex) {
				// ignore
			}
		}

		return null;
	}

}
