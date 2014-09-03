package sy.controller.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseController;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.MainVo;
import sy.service.base.BasicAuthorizationServiceI;
import sy.service.base.BasicResourceServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

	@Autowired
	private BasicResourceServiceI basicResourceService;
	
	@Autowired
	private BasicAuthorizationServiceI basicAuthorizationService;
	
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

	@RequestMapping(value = "display")
	public String display(HttpServletRequest request,
			HttpServletResponse response, MainVo vo, ModelMap modelMap) throws ValidatorException {

		String parId = vo.getNavResId();
		
		request.getSession().setAttribute("CURRENT_NAV_ID", parId);
		
		List<BasicResourceVo> ownReses = BasicHelper.getOwnedResources(request);
		
		List<BasicResourceVo> allSubNavs = basicResourceService.getSubNavigations(parId);
		
		if(CollectionUtils.isEmpty(allSubNavs)){
			BasicResourceVo res = basicResourceService.get(parId);
			vo.setResource(res);
		}else{
			
			List<BasicResourceVo> reses = new ArrayList<BasicResourceVo>();
			for (BasicResourceVo nav : allSubNavs) {
				for (BasicResourceVo ownRes : ownReses) {
					if(nav.getResId().equals(ownRes.getResId())){
						reses.add(nav);
						continue;
					}
				}
			}
			
			vo.setSvbResources(reses);
		}
		request.setAttribute("mainVo", vo);
		return "base/main";
	}

	@RequestMapping(value = "openResource")
	public String openResource(HttpServletRequest request,
			HttpServletResponse response, String id, ModelMap modelMap) throws ValidatorException {
		
		BasicResourceVo res = basicResourceService.get(id);
		
		request.getSession().setAttribute("CURRENT_SUBNAV_ID", id);
		
		return getRedirectStr(res.getResUrl());
	}
}
