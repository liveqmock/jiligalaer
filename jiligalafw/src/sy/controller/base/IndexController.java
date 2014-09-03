package sy.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.controller.shared.BaseController;

/**
 * 
 * @author lidongbo
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

	@RequestMapping(value = "/{path}/{src}")
	public String index(HttpServletRequest request, ModelMap modelMap,
			@PathVariable("path") String path,
			@PathVariable("src") String src) {
		
		modelMap.put("uri", "/"+path+"/"+src+".do");
		modelMap.put("_queryString", request.getQueryString());
		return "/base/index";
	}

}
