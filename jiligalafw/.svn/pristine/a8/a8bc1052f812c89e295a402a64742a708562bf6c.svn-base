package sy.controller.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.util.Constants;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseController;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.base.HeaderVo;
import sy.service.base.BasicAuthorizationServiceI;
import sy.service.base.BasicResourceServiceI;
import sy.service.base.BasicUserServiceI;

/**
 *
 * @author lidongbo
 *
 */
@Controller
@RequestMapping("/header")
public class HeaderController extends BaseController {

	@Autowired
	private BasicResourceServiceI basicResourceService;
	
	@Autowired
	private BasicAuthorizationServiceI basicAuthorizationService;
	
	@Autowired
	private BasicUserServiceI basicUserService;
	
	public BasicResourceServiceI getBasicResourceService() {
		return basicResourceService;
	}

	public void setBasicResourceService(BasicResourceServiceI basicResourceService) {
		this.basicResourceService = basicResourceService;
	}

	public BasicAuthorizationServiceI getBasicAuthorizationService() {
		return basicAuthorizationService;
	}

	public void setBasicAuthorizationService(
			BasicAuthorizationServiceI basicAuthorizationService) {
		this.basicAuthorizationService = basicAuthorizationService;
	}
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}
	
	

	@RequestMapping(value = "display")
	public String display(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws ValidatorException {

		//获取头部导航列表
		List<BasicResourceVo> allNavs = basicResourceService.getNavigations();
		
		List<BasicResourceVo> ownReses = BasicHelper.getOwnedResources(request);
		
		List<BasicResourceVo> reses = new ArrayList<BasicResourceVo>();
		
		for (BasicResourceVo nav : allNavs) {
			for (BasicResourceVo ownRes : ownReses) {
				if(nav.getResId().equals(ownRes.getResId())){
					reses.add(nav);
					continue;
				}
			}
		}
		
		HeaderVo vo = new HeaderVo();
		
		vo.setResources(reses);
		request.setAttribute("headerVo", vo);
		BasicUserVo user = (BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		
		BasicUserVo userVo = this.basicUserService.get(user.getUserId());
		request.setAttribute("userFlag", userVo.getUserFlag());
		request.setAttribute("user", userVo);
		
		return "base/header";
	}
	
}
