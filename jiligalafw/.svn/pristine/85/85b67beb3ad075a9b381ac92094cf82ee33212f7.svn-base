package sy.common.util.move.converter;

import org.dozer.CustomConverter;

/**
 * 
 * @author lidongbo
 * 2010-12-8
 */
public class Enum2StringConverter implements CustomConverter {

	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		
		if (sourceFieldValue == null) {
			return null;
	    }
		 
		if(sourceClass.isEnum() 
				&& String.class.isAssignableFrom(destinationClass)){
			return ((Enum<?>)sourceFieldValue).name();
		}
		return null;
	}

	
	
}

