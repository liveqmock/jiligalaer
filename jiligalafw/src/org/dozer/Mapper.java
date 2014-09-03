package org.dozer;

/**
 * Public root interface for performing Dozer mappings from application code.
 * 
 * @author tierney.matt
 * @author garsombke.franz
 * @Modifyer lidongbo at 2010-12-2
 */
public interface Mapper {
	
	void moveCheckIgnoreNull(Object source, Object destination,Class<?> ... clzzs) throws MappingException;
	
	void moveIgnoreNull(Object source, Object destination) throws MappingException;
	
	<T> T moveCheck(Object source, Class<T> destinationClass,Class<?> ... clzzs) throws MappingException;

	void moveCheck(Object source, Object destination,Class<?> ... clzzs) throws MappingException;
	
	<T> T map(Object source, Class<T> destinationClass) throws MappingException;

	void map(Object source, Object destination) throws MappingException;
	
	<T> T map(Object source, Class<T> destinationClass, String mapId)
			throws MappingException;
	
	void map(Object source, Object destination, String mapId)
			throws MappingException;

}
