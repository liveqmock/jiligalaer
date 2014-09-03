package sy.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.StringUtils;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.base.BasicResource;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.shared.TreeVo;
import sy.service.shared.BaseServiceTemplate;

/**
 *
 * @author lidongbo
 *
 */
@Service("basicResourceService")
public class BasicResourceService extends BaseServiceTemplate<BasicResource, BasicResourceVo> implements BasicResourceServiceI{

	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	
	public BasicDictItemServiceI getBasicDictItemService() {
		return basicDictItemService;
	}

	public void setBasicDictItemService(BasicDictItemServiceI basicDictItemService) {
		this.basicDictItemService = basicDictItemService;
	}

	@Override
	public void presave(BasicResourceVo vo,BasicResource po) throws ValidatorException {

		if(po.getResType()==null
				|| StringUtils.isBlank(po.getResType().getDictItemId())){
			throw new ValidatorException("resType","请选择资源分类");
		}
		
		if(po!=null
				&& po.getResUrl() != null
				&& (po.getResUrl().contains("?")
						|| po.getResUrl().contains("&"))){
			throw new ValidatorException("resUrl","地址中不允许包含以下符号：?、&");
		}
		
		if(po.getState() == null){
			po.setState(1);
		}
	}
	
	@Override
	public void postsave(BasicResourceVo vo,BasicResource po) throws ValidatorException{
		makeHierarchyCode(po);
	}

	@Override
	public List<TreeVo> getTree(QueryContext context) throws ValidatorException{
		
		List<TreeVo> nodes = basicDictItemService.getTree(new QueryContext(), "resource", "", "1");
		
		context.setPaging(false);
		
		context.equals("state", "1");
		
		List<BasicResourceVo> list = list(context);
		
		for (TreeVo node : nodes) {
			node.setResult(false);
		}
		
		for (BasicResourceVo resVo : list) {
			TreeVo node = new TreeVo();
			
			String pid = "";
			if(resVo.getParentRes()!=null
					&& resVo.getParentRes().getResId() != null){
				pid = resVo.getParentRes().getResId();
			}else if(resVo.getResType() != null){
				pid = resVo.getResType().getDictItemId();
			}
			
			String id = resVo.getResId();
			String name = resVo.getResName();
			node.setPid(pid);
			node.setId(id);
			node.setName(name);
			
			nodes.add(node);
		}
		
		return nodes;
	}

	@Override
	public List<BasicResourceVo> getNavigations() {
		String queryString =
				"	From BasicResource res" +
				"	Where res.state = 1 " +
				"	And res.levelCode = 1 " +
				"	And res.resType.dictItemId = 'navigation' " +
				"	Order by res.sort";
		return find( queryString);
	}

	@Override
	public List<BasicResourceVo> getSubNavigations(String parentResId) {
		String queryString =
				"	From BasicResource res" +
				"	Where res.state = 1 " +
				"	And res.levelCode = 2 " +
				"	And res.resType.dictItemId = 'navigation' " +
				"	And res.parentRes.resId = ? " +
				"	Order by res.sort";
		return find( queryString,parentResId);
	}

	
	public List<BasicResourceVo> getResources() {
		return find(BasicResourceVo.class, "from BasicResource where state=1");
	}
}
