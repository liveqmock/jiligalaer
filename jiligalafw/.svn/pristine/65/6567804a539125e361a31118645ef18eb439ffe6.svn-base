package sy.common.util.move;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;

import sy.common.util.spring.BeansHolder;
import sy.common.util.validator.ValidatorException;
import sy.common.util.validator.ValidatorMessage;
import sy.common.util.validator.ValidatorRuntimeException;

/**
 * 
 * @author lidongbo
 * 2010-11-30
 */
public class Mover{
	
	private static final Logger log = Logger.getLogger(Mover.class);  

	private static final String BEAN_NAME="mover";
	
	private static final String CONFIG="mapperBean";
	
	private Mover(){}

	/**
	 * 
	 * @param <T>                     目标对象类型
	 * @param sourceObject		                源对象
	 * @param destinationObjectClass  目标对象类
	 * @return                        目标对象
	 * @throws ValidatorException     校验信息
	 */
	public <T> T moveCheck(Object sourceObject,Class<T> destinationObjectClass,Class<?> ... group) throws ValidatorException{ 
		if(sourceObject == null){
			return null;
		}
		T result=null;
		try {
			result=getMapper().moveCheck(sourceObject, destinationObjectClass,group);
		} catch (ValidatorRuntimeException e) {
			List<ValidatorMessage> validatorMessageCollection=e.getValidatorMessageCollection();
			for (ValidatorMessage validatorMessage : validatorMessageCollection) {
				log.error(validatorMessage.message());
			}
			throw new ValidatorException(e);
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param <T>                     目标对象类型
	 * @param sourceObject		                 源对象
	 * @param destinationObjectClass  目标对象类
	 * @return                        目标对象
	 * @throws ValidatorException     校验信息
	 */
	public <T> T moveCheck(Object sourceObject,T destination,Class<?> ... group) throws ValidatorException{ 
		if(sourceObject == null){
			return null;
		}
		try {
			getMapper().moveCheck(sourceObject, destination,group);
		} catch (ValidatorRuntimeException e) {
			List<ValidatorMessage> validatorMessageCollection=e.getValidatorMessageCollection();
			for (ValidatorMessage validatorMessage : validatorMessageCollection) {
				log.error(validatorMessage.message());
			}
			throw new ValidatorException(e);
		}
		return destination;
	}
	
	
	
	/**
	 * null值不做移动
	 * @param <T>                     目标对象类型
	 * @param sourceObject		                 源对象
	 * @param destinationObjectClass  目标对象类
	 * @return                        目标对象
	 * @throws ValidatorException     校验信息
	 */
	public <T> T moveCheckIgnoreNull(Object sourceObject,T destination,Class<?> ... group) throws ValidatorException{ 
		if(sourceObject == null){
			return null;
		}
		try {
			getMapper(CONFIG).moveCheckIgnoreNull(sourceObject, destination,group);
		} catch (ValidatorRuntimeException e) {
			List<ValidatorMessage> validatorMessageCollection=e.getValidatorMessageCollection();
			for (ValidatorMessage validatorMessage : validatorMessageCollection) {
				log.error(validatorMessage.message());
			}
			throw new ValidatorException(e);
		}
		return destination;
	}
	
	/**
	 * null值不做移动
	 * @param <T>					     目标对象类型
	 * @param sourceObject		                源对象
	 * @param destinationObject		     目标对象
	 */
	public <T> T moveIgnoreNull( Object sourceObject, T destination){ 
		if(sourceObject == null){
			return null;
		}
        getMapper(CONFIG).moveIgnoreNull(sourceObject, destination);
		return destination;
	}
	
	/**
	 *  
	 * @param <T>                     目标对象类型
	 * @param sourceObject		                源对象
	 * @param destinationObjectClass  目标对象类
	 * @return                        目标对象
	 */
	public <T> T move(Object sourceObject,Class<T> destinationObjectClass){ 
		if(sourceObject == null){
			return null;
		}
		return getMapper().map(sourceObject, destinationObjectClass);
	}
	
	/**
	 * 
	 * @param <T>					     目标对象类型
	 * @param sourceObject		                源对象
	 * @param destinationObject		     目标对象
	 */
	public <T> T move(Object sourceObject,T destination){ 
		if(sourceObject == null){
			return null;
		}
		getMapper().map(sourceObject, destination);
		return destination;
	}
	
	/***
	 * 把一个List内的所有对象转换为目标对象
	 * @param <FROM>
	 * @param <TO>
	 * @param sourceObjects            源对象
	 * @param destinationClass         目标类型
	 * @return
	 */
	public <FROM,TO> List<TO> move(List<FROM> sourceObjects,Class<TO> destinationClass){ 
		if(sourceObjects == null){
			return null;
		}
		List<TO> destinations=new ArrayList<TO>();
		for (FROM from : sourceObjects) {
			destinations.add(move(from, destinationClass));
		}
		return destinations;
	}
	
	public void copyProperties(Object from, Object to, String ... ignoreProperties){
		BeanUtils.copyProperties(from, to);
	}
	
	private Mapper getMapper(String mappName) {
		return (Mapper) BeansHolder.getBean(mappName);
	}
	
	public static Mover getInstance(){
		return (Mover) BeansHolder.getBean(BEAN_NAME);
	}
	
	private Mapper mapper;
	
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	private Mapper getMapper() {
		return mapper;
	}
	
}

