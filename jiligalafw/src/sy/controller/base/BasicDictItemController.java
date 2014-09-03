package sy.controller.base;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicDictItemVo;
import sy.domain.vo.shared.TreeVo;
import sy.service.base.BasicDictItemServiceI;
import sy.service.base.BasicDictServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */

@Controller
@RequestMapping("/dictItem")
@SessionAttributes("basicDictItemVo")
public class BasicDictItemController extends
		BaseControllerTemplate<BasicDictItemVo> {

	@Autowired
	private BasicDictItemServiceI basicDictItemService;

	@Autowired
	private BasicDictServiceI basicDictService;
	
	public BasicDictServiceI getBasicDictService() {
		return basicDictService;
	}

	public void setBasicDictService(BasicDictServiceI basicDictService) {
		this.basicDictService = basicDictService;
	}

	@RequestMapping(value = "tree")
	public String tree(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {

		QueryContext context = new ECContext(request, modelMap, getNameSpace());

		List<TreeVo> nodes = basicDictItemService.getTree(context,
				request.getParameter("dictId"),
				request.getParameter("levelCode"),
				request.getParameter("state"));
		
		request.setAttribute("tree", nodes);
		return "commons/ztree";
	}

	@Override
	public BasicServiceI<BasicDictItemVo> getService() {
		return basicDictItemService;
	}

	@Override
	public String getViewPath() {
		return "base";
	}

	
	
	@Override
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		context.clearParmeters();
		context.put("$in_basicDict_dictId", "geo,industry");
		context.put("$eq_basicDict_dictId", request.getParameter("dictType"));
		context.put("$lk_itemName", request.getParameter("keyword"));
		List<?> dictItemList = this.basicDictItemService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("list", dictItemList);
		modelMap.put("dictType", request.getParameter("dictType"));
		modelMap.put("keyword", request.getParameter("keyword"));
		return getViewPath() + "/basicDictItemList";
	}

	@Override
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap,
			BasicDictItemVo vo, BindingResult errors) {
		String dictId = request.getParameter("dictId");
		String itemName = request.getParameter("itemName");
		try {
			String dictItemId = request.getParameter("dictItemId");
			if(!"".equals(dictItemId)){
				//修改
				vo = this.basicDictItemService.get(dictItemId);
				vo.setUpdated(new Date());
				vo.setUpdatedBy(this.getCurrentUser(request).getUserAccount());
			}else{
				//新增
				vo.setBasicDict(this.basicDictService.get(dictId));
				vo.setItemCode(itemName);
				vo.setCreated(new Date());
				vo.setCreatedBy(this.getCurrentUser(request).getUserAccount());
			}
			vo.setItemName(itemName);
			
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		
		return super.save(request, modelMap, vo, errors);
	}
	
	
	

}
