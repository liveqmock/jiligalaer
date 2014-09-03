package sy.controller.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.shared.TreeVo;
import sy.service.base.BasicResourceServiceI;
import sy.service.shared.BasicServiceI;

/**
 *
 * @author lidongbo
 *
 */

@Controller
@RequestMapping("/resource")
@SessionAttributes("basicResourceVo")
public class BasicResourceController  extends BaseControllerTemplate<BasicResourceVo> {

	@Autowired
	private BasicResourceServiceI basicResourceService;

	@Override
	public BasicServiceI<BasicResourceVo> getService() {
		return basicResourceService;
	}

	public BasicResourceServiceI getBasicResourceService() {
		return basicResourceService;
	}


	public void setBasicResourceService(BasicResourceServiceI basicResourceService) {
		this.basicResourceService = basicResourceService;
	}

	@Override
	public String getViewPath() {
		return "base";
	}
	
	protected void initContextParams(HttpServletRequest request,
			QueryContext context) {
		context.setSort(" resType_itemName asc,subCode, sort");
	}
	
	
	@RequestMapping(value = "tree")
	public String tree(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {

		QueryContext context = new QueryContext(request, modelMap, getNameSpace()+"tree",false);

		List<TreeVo> nodes = basicResourceService.getTree(context);
		
		request.setAttribute("tree", nodes);
		return "commons/ztree";
	}
	
//	public String getSavedView() {
//		return getCloseView();
//	}
}
