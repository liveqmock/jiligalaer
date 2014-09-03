package sy.service.shared;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.shared.BaseVo;

/**
 *
 * @author lidongbo
 *
 */
public interface BasicServiceI<T extends BaseVo> {

	public List<T> list(QueryContext context) throws ValidatorException;

	public T get(Serializable id) throws ValidatorException;

	public void save(T obj) throws ValidatorException;

	public void delete(Serializable id) throws ValidatorException;
	
	public void saveAll(Collection<T> collection) throws ValidatorException;
	
}
