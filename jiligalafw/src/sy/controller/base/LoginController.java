package sy.controller.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.util.Constants;
import sy.controller.shared.BaseController;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.base.LoginVo;
import sy.service.base.BasicAuthorizationServiceI;
import sy.service.base.BasicUserServiceI;

@Controller
@RequestMapping("/login")
public class LoginController  extends  BaseController {

	@Autowired
	private BasicUserServiceI basicUserService;
	
	@Autowired
	private BasicAuthorizationServiceI basicAuthorizationService;
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}
	
	public BasicAuthorizationServiceI getBasicAuthorizationService() {
		return basicAuthorizationService;
	}

	public void setBasicAuthorizationService(
			BasicAuthorizationServiceI basicAuthorizationService) {
		this.basicAuthorizationService = basicAuthorizationService;
	}

	@RequestMapping(value = "visit")
	public String visit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		modelMap.put("loginVo", new LoginVo());
		return "base/login";
	}
	
	@RequestMapping(value = "excute")
	public String excute(HttpServletRequest request,ModelMap modelMap, @Valid LoginVo vo, BindingResult errors){
		
		BasicUserVo basicUserVo = (BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		if(basicUserVo != null){
       		request.getSession().setAttribute(Constants.SESSION_USER_KEY, basicUserVo);
       		request.getSession().setAttribute(Constants.SESSION_RES_KEY, basicAuthorizationService.getResources(basicUserVo));
   			return "/base/index";
		}
		
		if(StringUtils.isBlank(vo.getUserAccount())){
			errors.rejectValue("userAccount",null, "用户名不能空!");
			return "base/login";
		}
		if(StringUtils.isBlank(vo.getUserPassword())){
			errors.rejectValue("userPassword",null, "密码不能空!");
			return "base/login";
		}
		if(StringUtils.isBlank(vo.getRand())){
			errors.rejectValue("rand",null, "验证码不能空!");
			return "base/login";
		}
		if(!vo.getRand().equals(request.getSession().getAttribute("rand"))){
			errors.rejectValue("rand",null, "验证码不正确!");
			return "base/login";
		}
		 
		try {
			basicUserVo = basicUserService.getBasicUserVoByUserAccount(vo.getUserAccount());
			if (basicUserVo == null) {
				errors.rejectValue("userAccount", null, "用户名不存在!");
				return "base/login";
			} else {
				if (basicUserVo.getState().equals(Constants.USER_STATE_NOACTIVE)) {
					errors.rejectValue("errors", null, "用户未激活，若想重新发送激活链接请:");
					request.setAttribute("activateFlag", 1);
					return "base/login";
				}
				if (basicUserVo.getState().equals(Constants.USER_STATE_BLOCK)) {
					errors.rejectValue("errors", null, "用户已停用,若想重新激活请：");
					request.setAttribute("activateFlag", 1);
					return "base/login";
				}
				if (basicUserVo.getState().equals(Constants.USER_STATE_ACTIVE)) {
					errors.rejectValue("errors", null, "用户或者账户尚未审批,不能登录!");
					return "base/login";
				}
				if (basicUserVo.getState().equals(Constants.USER_STATE_REJECT)) {
					errors.rejectValue("errors", null, "用户或者账户审批拒绝,请登录注册邮箱查看详情!");
					return "base/login";
				}
				if (basicUserVo.getState().equals(Constants.USER_STATE_LOGOFF)) {
					errors.rejectValue("errors", null, "用户或者账户已注销,不能登录!");
					return "base/login";
				}
				if (!vo.getUserPassword().equals(basicUserVo.getUserPassword())) {
					errors.rejectValue("userPassword", null, "密码错误!");
					return "base/login";
				} 
				
				List<BasicResourceVo> resVo = basicAuthorizationService.getResources(basicUserVo);
				if (null == resVo || resVo.size() < 1){
					errors.rejectValue("errors", null, "用户权限不足!");
					return "base/login";
				}
				else {
					request.getSession().setAttribute(Constants.SESSION_USER_KEY, basicUserVo);
					request.getSession().setAttribute(Constants.SESSION_RES_KEY, resVo);
					return "/base/index";
				}
			}
		}catch(Exception e){
			errors.rejectValue("errors",null,"用户登录时错误，请重新登录!");
			e.printStackTrace();
			return "base/login";
		
		}
	}
	
	@RequestMapping(value = "identitySwitch")
	public String identitySwitch(HttpServletRequest request, ModelMap modelMap){
		//当前用户身份
		HttpSession session = request.getSession();
		BasicUserVo currUser = (BasicUserVo)session.getAttribute("parent_user");
		if(currUser == null){
			currUser = (BasicUserVo)session.getAttribute(Constants.SESSION_USER_KEY);
		}
		try {
			//被切换的用户身份
			BasicUserVo userVo = basicUserService.getBasicUserVoByUserId(request.getParameter("userId"));
			session.invalidate();
			
			if (userVo == null) {
				//errors.rejectValue("userAccount", null, "用户不存在!");
				return "base/login";
				
			} else {
				List<BasicResourceVo> resVo = basicAuthorizationService.getResources(userVo);
				
				String actionType = request.getParameter("actionType");
				if(actionType != null && !"".equals(actionType)){
					//管理员切换到账户
					request.getSession().setAttribute("parent_user", currUser);
				}else{
					request.getSession().removeAttribute("parent_user");
				}

				request.getSession().setAttribute(Constants.SESSION_USER_KEY, userVo);
				request.getSession().setAttribute(Constants.SESSION_RES_KEY, resVo);
				return "/base/index";
			}
			
		}catch(Exception e){
			//errors.rejectValue("errors",null,"身份切换出错，请重新登录!");
			e.printStackTrace();
			return "base/login";
		}
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		   HttpSession session = request.getSession();
		   session.removeAttribute(Constants.SESSION_USER_KEY);
		   session.removeAttribute(Constants.SESSION_USER_ROLE_KEY);
	       session.invalidate();
	       return getRedirectStr("visit.do");
		
	}
	
}
