package sy.service.base;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.shared.TreeVo;
import sy.service.shared.BasicServiceI;

/**
 *
 * @author lidongbo
 *
 */
public interface BasicResourceServiceI extends BasicServiceI<BasicResourceVo>{

	List<TreeVo> getTree(QueryContext context) throws ValidatorException;

	List<BasicResourceVo> getNavigations();
	
	List<BasicResourceVo> getSubNavigations(String parentResId);

	List<BasicResourceVo> getResources();
}
