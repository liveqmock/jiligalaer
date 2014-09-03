package sy.service.base;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.base.BasicDictItemVo;
import sy.domain.vo.base.BasicDictVo;
import sy.domain.vo.shared.TreeVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface BasicDictItemServiceI extends BasicServiceI<BasicDictItemVo> {

	public List<TreeVo> getTree(QueryContext context, String dictId,
			String levelCode, String state) throws ValidatorException;
	public BasicDictItemVo getBasicDictItemVoByItemCode(String dictType,String itemCode)
			throws Exception;
	
	public List<BasicDictItemVo> getBaiscDictItemListByDictType(String dictType) throws Exception;
	
	public BasicDictVo getBasicDictByDictId(String dictId) throws ValidatorException;

}
