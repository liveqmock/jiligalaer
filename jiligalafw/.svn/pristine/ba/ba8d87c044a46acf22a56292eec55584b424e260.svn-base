package sy.controller.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.BaseConfigurator;
import sy.common.util.Constants;
import sy.common.util.StringUtils;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.base.BasicRoleServiceI;
import sy.service.base.BasicUserRoleServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.core.MailServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("basicUserVo")
public class BasicUserController extends BaseControllerTemplate<BasicUserVo> {

	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private BasicUserRoleServiceI basicUserRoleService;
	@Autowired
	private BasicRoleServiceI basicRoleService;
	@Autowired
	private MailServiceI mailService;

	public BasicUserRoleServiceI getBasicUserRoleService() {
		return basicUserRoleService;
	}

	public void setBasicUserRoleService(
			BasicUserRoleServiceI basicUserRoleService) {
		this.basicUserRoleService = basicUserRoleService;
	}

	public String getViewPath() {
		return "base";
	}

	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	public BasicRoleServiceI getBasicRoleService() {
		return basicRoleService;
	}

	public void setBasicRoleService(BasicRoleServiceI basicRoleService) {
		this.basicRoleService = basicRoleService;
	}

	@Override
	public BasicServiceI<BasicUserVo> getService() {
		return basicUserService;
	}
	
	public MailServiceI getMailService() {
		return mailService;
	}

	public void setMailService(MailServiceI mailService) {
		this.mailService = mailService;
	}

	/**
	 * 查询用户审批信息
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		context.clearParmeters();
		BasicUserVo user =(BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		String userFlag = request.getParameter("userFlag");
		String userId = request.getParameter("parentUserId");
		if("".equals(userId) || null == userId){
			userId=user.getUserId();
		}
		if ("".equals(userFlag) || null == userFlag) {
			userFlag = String.valueOf(Constants.USER_FLAG_USER);
		}
		context.put("$eq_parentBasicUser_userId", userId);
		context.put("$in_userFlag", userFlag);
		List<BasicRoleVo> basicRoleVoList = null;
		
		try {
			basicRoleVoList = basicRoleService.getBasicRoleVoListByUserFlag(Integer.parseInt(userFlag));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("roleList", basicRoleVoList);
		String roleFlag = "";
		String queryType = request.getParameter("queryType");
		// queryType为1标示简单查询中的用户状态查询，0为简单查询中的角色查询，2为高级查询.
		if ("0".equals(queryType)) {
			context.put("$lk_userName", null);
			context.put("$lk_userAccount", null);
			context.put("$lk_tel", null);
			context.put("$in_basicUser_state", null);
			context.put("$eq_basicUser_state", null);
			roleFlag = request.getParameter("roleFlag");
			request.setAttribute("roleFlag", roleFlag);

		} else if ("1".equals(queryType)) {
			context.put("$lk_userName", null);
			context.put("$lk_userAccount", null);
			context.put("$lk_tel", null);
			context.put("$in_state", null);
			context.put("$eq_role", null);
			String stateFlag = request.getParameter("stateFlag");
			context.put("$eq_state", stateFlag);
		} else {
			context.put("$eq_state", null);
			context.put("$in_state", null);
			String[] stateArr = request.getParameterValues("state");
			String stateStr = "";
			if (stateArr != null && stateArr.length > 0) {
				for (int i = 0; i < stateArr.length; i++) {
					stateStr += stateArr[i] + ",";
				}
				context.put("$in_state", stateStr.substring(0, stateStr.length() - 1));
				request.setAttribute("stateStr", stateStr.substring(0, stateStr.length() - 1));
			}
			String[] roleArr = request.getParameterValues("role");
			String roleStr = "";
			if (roleArr != null && roleArr.length > 0) {
				for (int i = 0; i < roleArr.length; i++) {
					roleStr += roleArr[i] + ",";
				}
				request.setAttribute("roleStr", roleStr.substring(0, roleStr.length() - 1));
				roleFlag = roleStr.substring(0, roleStr.length() - 1);
			}
		}
		List<BasicUserVo> basicUserVoList = null;
		try {
			basicUserVoList = basicUserRoleService.getBasicUserRoleTotalByUser(roleFlag, context);

		} catch (Exception e) {
			e.printStackTrace();
		}
		context.setTotalRowCount(basicUserVoList.size());
		context.setPageSize(5);
		context.initTotalRows(modelMap);
		modelMap.put("list", basicUserVoList);
		request.setAttribute("queryType", queryType);
		request.setAttribute("user", user);

		return getViewPath() + "/userList";

	}

	protected void prepareEditView(HttpServletRequest request,
			ModelMap modelMap, BasicUserVo obj) {
		super.prepareEditView(request, modelMap, obj);
		Map<String,String> stateMap = new HashMap<String,String>();
		BasicUserVo user = (BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		stateMap.put("0", "停用");
		stateMap.put("1", "未激活");
		stateMap.put("2", "待审批");
		stateMap.put("3", "审批通过");
		stateMap.put("-1", "注销");
		stateMap.put("-2", "审批拒绝");
		modelMap.put("parentUserId", user.getUserId());
		modelMap.put("state", stateMap);
		
	}

	

	/**
	 * 激活管理员、账户、用户
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "userActivation")
	public String userActivation(HttpServletRequest request,
			HttpServletResponse response, BasicUserVo vo, ModelMap modelMap) throws ValidatorException {
		String dealUserId = request.getParameter("userId");
		String redirectFlag = request.getParameter("flag");
		
		if (StringUtils.isNotBlank(dealUserId)) {
			try {
				BasicUserVo basicUserVo = basicUserService.get(dealUserId);
				List<BasicUserVo> userList = new ArrayList<BasicUserVo>();
				userList.add(basicUserVo);
				this.basicUserService.batchStopOrEnabledUser(userList, this.getCurrentUser(request), String.valueOf(Constants.USER_STATE_PASS));
				
				//发送邮件通知账户、用户状态变更
				if(Integer.parseInt(redirectFlag) != Constants.USER_FLAG_ADMIN){
					this.userStateChangeSendMail(userList, Constants.USER_STATE_PASS);
				}
				
				
//				// 启用账户
//				BasicUserVo basicUserVo = basicUserService.get(dealUserId);
//				basicUserVo.setState(Constants.USER_STATE_PASS);
//				basicUserService.save(basicUserVo);
//
//				List<BasicUserVo> basicUsers;
//				// 启用账户下用户
//				basicUsers = basicUserService
//						.getBaiscUserVoListByParentBaiscUserVo(basicUserVo);
//				for (BasicUserVo user : basicUsers) {
//					user.setState(Constants.USER_STATE_PASS);
//					basicUserService.save(user);
//				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		int flag = Integer.valueOf(redirectFlag);
		if (flag == Constants.USER_FLAG_ACCOUNT) {
			return getRedirectStr("/account/list.do");
		} else if (flag == Constants.USER_FLAG_ADMIN) {
			return getRedirectStr("/admin/list.do");
		} else {
			return getRedirectStr("/user/list.do");
		}

	}
	
	
	/**
	 * 停用管理员、账户、用户
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "stopUser")
	public String stopUser(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		String userId = request.getParameter("userId");
		String userFlag = request.getParameter("userFlag");
		
		if (StringUtils.isNotBlank(userId)) {
			BasicUserVo basicUserVo = null;
			try {
				basicUserVo = basicUserService.get(userId);
				List<BasicUserVo> userList = new ArrayList<BasicUserVo>();
				userList.add(basicUserVo);
				this.basicUserService.batchStopOrEnabledUser(userList, this.getCurrentUser(request), String.valueOf(Constants.USER_STATE_BLOCK));
				
				//发送邮件通知账户、用户状态变更
				if(Integer.parseInt(userFlag) != Constants.USER_FLAG_ADMIN){
					this.userStateChangeSendMail(userList, Constants.USER_STATE_BLOCK);
				}				
				
				
//				if (null != basicUserVo) {
//					//停用账户
//					basicUserVo.setState(Constants.USER_STATE_BLOCK);
//					basicUserService.save(basicUserVo);
//					
//					List<BasicUserVo> basicUsers = null;
//					//调用接口停用账户
//					basicUsers = basicUserService .getBaiscUserVoListByParentBaiscUserVo(basicUserVo);
//					
//					//停用账户下用户
//					for (BasicUserVo user : basicUsers) {
//						user.setState(Constants.USER_STATE_BLOCK);
//						basicUserService.save(user);
//					}
//				}

				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				int flag = Integer.valueOf(userFlag);
				if (flag==Constants.USER_FLAG_ACCOUNT) {
					return getRedirectStr("/account/list.do");
				} else if(flag==Constants.USER_FLAG_ADMIN) {
					return getRedirectStr("/admin/list.do");
				}else{
					return getRedirectStr("/user/list.do");
				}
				
			}
		}
		return null;

	}

	
	/**
	 * 批量激活、停用账户和用户（目前只有批量停用账户功能）
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "batchOperateUser")
	public String batchOperateUser(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		String userIdArr = request.getParameter("userIdArr");
		String userFlag = request.getParameter("userFlag");
		String state = request.getParameter("state");
		
		if (StringUtils.isNotBlank(userIdArr)) {
			try {
				QueryContext context = new ECContext(request, modelMap, getNameSpace());
				context.put("$in_userId", userIdArr);
				List<BasicUserVo> userList = this.basicUserService.list(context);
				this.basicUserService.batchStopOrEnabledUser(userList, this.getCurrentUser(request), state);
				
				//发送邮件通知账户、用户状态变更
				if(Integer.parseInt(userFlag) != Constants.USER_FLAG_ADMIN){
					this.userStateChangeSendMail(userList, Integer.parseInt(state));
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				int flag = Integer.valueOf(userFlag);
				if (flag==Constants.USER_FLAG_ACCOUNT) {
					return getRedirectStr("/account/list.do");
				} else if(flag==Constants.USER_FLAG_ADMIN) {
					return getRedirectStr("/admin/list.do");
				}else{
					return getRedirectStr("/user/list.do");
				}
			}
		}
		return null;
	}
	
	public void userStateChangeSendMail(List<BasicUserVo> userList, int userState){
		for(BasicUserVo vo : userList){
			try {
				String userType = "账户";
				if(vo.getUserFlag() == Constants.USER_FLAG_USER){
					userType = "用户";
				}
				if(userState == Constants.USER_STATE_PASS){
					this.mailService.sendMail(vo.getUserAccount(), "", 
							BaseConfigurator.getInstance().getCompanyName()+userType+"通知",
							vo.getUserName() + "，您好！<br>您的账号已激活，可以正常登陆，如有问题请与系统管理员联系。" +
								"<br>系统登录地址：<a href='"+BaseConfigurator.getInstance().getServerAddress()+"'>"+BaseConfigurator.getInstance().getServerAddress()+"</a><br>");
				}else{
					this.mailService.sendMail(vo.getUserAccount(), "", 
							BaseConfigurator.getInstance().getCompanyName()+userType+"通知",
							vo.getUserName() + "，您好！<br>您的账号已被停用，如有问题请与系统管理员联系。");			
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 用户-我的资料编辑页面初始化
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "userDetailInfo")
	public String userDetailInfo(HttpServletRequest request, BasicUserVo vo,  ModelMap modelMap)
			throws ValidatorException {
		if(null == vo.getUserId()){
		vo = (BasicUserVo) request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		}
	    this.prepareEditView(request, modelMap, vo);
	    if(vo.getState()==0){
			modelMap.put("stateName", "停用");
		}else if(vo.getState()==1){
			modelMap.put("stateName", "未激活");
		}else if(vo.getState()==2){
			modelMap.put("stateName", "待审批");
		}else if(vo.getState()==3){
			modelMap.put("stateName", "审批通过");
		}else if(vo.getState()==-1){
			modelMap.put("stateName", "注销");
		}else if(vo.getState()==-2){
			modelMap.put("stateName", "审批拒绝");
		}else{
			modelMap.put("stateName", "未定义");
		}
		String roleNames="";
		Iterator<BasicRoleVo> basicRoleIt =  basicUserRoleService.getRoleByUser(vo).iterator();
		while(basicRoleIt.hasNext()){
			BasicRoleVo bur = basicRoleIt.next();
			if(null !=bur.getRoleName()){
				roleNames=roleNames+bur.getRoleName()+",";
			}
		}
		if(!"".equals(roleNames)){
			roleNames=roleNames.substring(0, roleNames.lastIndexOf(","));
		}
		
		modelMap.put("roleName",roleNames);
		modelMap.put("userAccountShow", vo.getUserAccount());
		return getViewPath() + "/userDetailInfo";
	}
	
	/**
	 * 用户 - 我的资料编辑信息保存
	 * @throws ValidatorException 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "saveInfo")
	public String saveInfo(HttpServletRequest request, ModelMap modelMap, @Valid BasicUserVo vo, BindingResult errors) throws ValidatorException{
		if (errors.hasErrors()) {
			prepareEditView(request, modelMap, vo);
			return getViewPath() + "/userDetailInfo";
		}
		String passwrodSave=request.getParameter("passwrodSave");
		String password = vo.getUserPassword();
		if(StringUtils.isNotBlank(passwrodSave)){
			try {
				vo = basicUserService.get(vo.getUserId());
			} catch (ValidatorException e) {
				e.printStackTrace();
			}
		}
		vo.setUserPassword(password);
	
		try {
			getService().save(vo);
			
		} catch (ValidatorException e) {
			modelMap.put("userMsg", e.getMessage());
			userDetailInfo(request, vo, modelMap);
			return getViewPath() + "/userDetailInfo";
		} catch (Exception e) {
			modelMap.put("userMsg", e.getMessage());
			userDetailInfo(request, vo, modelMap);
			return getViewPath() + "/userDetailInfo";
		}
		
		userDetailInfo(request, vo, modelMap);
		modelMap.put("userMsg", "保存成功！");
		return getViewPath() + "/userDetailInfo";
	}
	/**
	 * 用户详细信息
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "detailInfo")
	public String detailInfo(HttpServletRequest request, ModelMap modelMap, String userId) throws ValidatorException {
		BasicUserVo basicUser = this.basicUserService.get(userId);
		request.setAttribute("basicUser", basicUser);
		 if(StringUtils.isNotBlank(userId) && null != basicUser){
			 if(basicUser.getState()==0){
			  request.setAttribute("stateName", "停用");
			}else if(basicUser.getState()==1){
				request.setAttribute("stateName", "未激活");
			}else if(basicUser.getState()==2){
				request.setAttribute("stateName", "待审批");
			}else if(basicUser.getState()==3){
				request.setAttribute("stateName", "审批通过");
			}else if(basicUser.getState()==-1){
				request.setAttribute("stateName", "注销");
			}else if(basicUser.getState()==-2){
				request.setAttribute("stateName", "审批拒绝");
			}else{
				request.setAttribute("stateName", "未定义");
			}
		 }
		return "base/user_detailInfo";
	}
	
	@Override
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap,
			BasicUserVo vo, BindingResult errors) {
		String createFlag = vo.getUserId();
		try {
			//super.save(request, modelMap, vo, errors);
			
			QueryContext context = new ECContext(request, modelMap, getNameSpace());
			context.put("$eq_userAccount", vo.getUserAccount());
			context.put("$ne_userId", vo.getUserId());
			List<?> list = this.basicUserService.list(context);
			if(list.size() > 0){
				modelMap.put("saveMsg", "保存失败，用户名重复。");
				return "base/userEdit";
			}
			getService().save(vo);
			modelMap.put("saveMsg", "保存成功");
			
			//发送邮件通知账户
			if(StringUtils.isBlank(createFlag)){
				this.mailService.sendMail(vo.getUserAccount(), "", 
					BaseConfigurator.getInstance().getCompanyName()+"用户通知",
					vo.getUserName() + "，您好！<br>您的账号已开通，请您尽快登陆修改账号密码。" +
						"<br>系统登录地址：<a href='"+BaseConfigurator.getInstance().getServerAddress()+"'>"+BaseConfigurator.getInstance().getServerAddress()+"</a><br>" +
						"账号："+vo.getUserAccount()+"<br>密码："+vo.getUserPassword());
			}
			
		} catch (Exception e) {
			modelMap.put("saveMsg", "保存失败："+e.getMessage());
			e.printStackTrace();
		}
		
		return "base/userEdit";
	}

	public String getSavedView() {
		return getSuccesedView();
	}
	
}
