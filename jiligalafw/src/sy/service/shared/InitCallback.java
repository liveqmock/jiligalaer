package sy.service.shared;

import sy.common.util.validator.ValidatorException;

/**
 * 
 * @author lidongbo
 * 
 */
public interface InitCallback<T> extends Newable<T>{

	public void postinit(T t) throws ValidatorException;
	
}
