package org.dozer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.loader.api.BeanMappingBuilder;

/**
 * 
 * @author lidongbo
 * 2010-12-9
 */
public class DoFieldMoveUtil {

	static class SimpleField{
		
		private String _name;
		
		private Class<?> _type;
		
		private Class<?> _belongsClass;
	

		private SimpleField(String name,Class<?> type,Class<?> belongsClass){
			_name=name;
			_type=type;
			_belongsClass=belongsClass;
		}

		public String getName() {
			return _name;
		}

		public Class<?> getType() {
			return _type;
		}

		public Class<?> getBelongsClass() {
			return _belongsClass;
		}

	
	}
	
	
	private static void putFieldsNameAndType(Class<?> clzz,Set<Class<?>> cycleRecoverable,List<SimpleField> result){
		cycleRecoverable.add(clzz);
		if(clzz.getSuperclass()!=null&&!cycleRecoverable.contains(clzz.getSuperclass())){
			putFieldsNameAndType(clzz.getSuperclass(),cycleRecoverable,result);
		}
		Field[] fields=clzz.getDeclaredFields();
		for (Field field : fields) {
			SimpleField simpleField=new SimpleField(field.getName(),field.getType(),clzz);
			//System.out.println(field.getName() +"\t"+field.getType());
			result.add(simpleField);
			if(!cycleRecoverable.contains(field.getType())&&!exist(field.getType())){
				putFieldsNameAndType(field.getType(),cycleRecoverable,result);
			}
		}
	}
	
	/**JDK的类不进行查找Field*/
	private static boolean exist(Class<?> type) {

		if(type.isPrimitive()){
			return true;
		}
		if(type.getName().startsWith("java.")){
			return true;
		}
		return false;
	}

	private static List<SimpleField> doStartGetField(Class<?> clzz){
		/**防止相互引用的拆锁器*/
		Set<Class<?>> cycleRecoverable=new HashSet<Class<?>>();
		List<SimpleField> result=new ArrayList<SimpleField>();
		putFieldsNameAndType(clzz,cycleRecoverable,result);
		cycleRecoverable.clear();
		return result;
	}
	
	public static void mappings(BeanMappingBuilder beanMappingBuilder,
			final Object source, final Object destination) {
		
		Set<Class<?>> noDuplicate=new HashSet<Class<?>>();
		noDuplicate.add(source.getClass());
		beanMappingBuilder.mapping(source.getClass(), 
				destination.getClass(),
				BeanMappingBuilder.mapNull(false),BeanMappingBuilder.mapEmptyString(true));
		
		List<SimpleField> sourceFileds = doStartGetField(source.getClass());
		List<SimpleField> destinationFileds = doStartGetField(destination.getClass());
		
		for (SimpleField destinationFiled : destinationFileds) {
			for (SimpleField sourceFiled : sourceFileds) {
				if (destinationFiled.getName().equals(sourceFiled.getName())) {
					if(!noDuplicate.contains(sourceFiled.getType())){
						noDuplicate.add(sourceFiled.getType());
						beanMappingBuilder.mapping(sourceFiled.getType(), 
								destinationFiled.getType(),
								BeanMappingBuilder.mapNull(false),
								BeanMappingBuilder.mapEmptyString(true));
						
					}
				}
			}
		}
	}
	
	static class BeanMappingBuilderConfigureMapNullFalseEmptyStringTrue extends BeanMappingBuilder{
		private Class<?> _source;
		private Class<?> _destination;
		public BeanMappingBuilderConfigureMapNullFalseEmptyStringTrue(Class<?> source,Class<?> destination){
			_source=source;
			_destination=destination;
		}
		protected void configure() {
			mapping(_source, 
					_destination,
					BeanMappingBuilder.mapNull(false),BeanMappingBuilder.mapEmptyString(true));
		}
	}

	public static void addMapping(DozerBeanMapper dozerBeanMapper,
			final Object source,final  Object destination) {
		
		Set<Class<?>> noDuplicate=new HashSet<Class<?>>();
		noDuplicate.add(source.getClass());
		
		dozerBeanMapper.addMapping(	
				new BeanMappingBuilderConfigureMapNullFalseEmptyStringTrue(source.getClass(),destination.getClass())
				);
		
		List<SimpleField> sourceFileds = doStartGetField(source.getClass());
		List<SimpleField> destinationFileds = doStartGetField(destination.getClass());
		
		for (final SimpleField destinationFiled : destinationFileds) {
			for (final SimpleField sourceFiled : sourceFileds) {
				if (destinationFiled.getName().equals(sourceFiled.getName())) {
					if(!noDuplicate.contains(sourceFiled.getType())){
						noDuplicate.add(sourceFiled.getType());
						dozerBeanMapper.addMapping(	
								new BeanMappingBuilderConfigureMapNullFalseEmptyStringTrue(sourceFiled.getType(), 
										destinationFiled.getType())
								);
					}
				}
			}
		}
	}
}

