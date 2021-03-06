package sy.controller.base;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import sy.common.util.BaseConfigurator;
import sy.common.util.Constants;
import sy.common.util.StringUtil;
import sy.common.util.StringUtils;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserActivationCodeVo;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.base.UserRegisterVo;
import sy.service.base.BasicDictItemServiceI;
import sy.service.base.BasicUserActivationCodeServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.core.MailServiceI;
import sy.service.shared.BasicServiceI;

@Controller
@RequestMapping("/base/userRegister")
@SessionAttributes("userRegisterVo")
public class UserRegisterController extends BaseControllerTemplate<BasicUserVo> {

	@Autowired
	private MailServiceI mailService;

	public MailServiceI getMailService() {
		return mailService;
	}

	public void setMailService(MailServiceI mailService) {
		this.mailService = mailService;
	}

	@RequestMapping(value = "selectAccountType")
	public String selectAccountType(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		UserRegisterVo userRegisterVo = new UserRegisterVo();
		// 默认注册正式账户
		userRegisterVo.setUserAccountType("zhengshi");
		String invitationKey = request.getParameter("invitationKey");
		if (invitationKey != null && invitationKey.length() > 0) {
			userRegisterVo.setInvitationKey(invitationKey);
		}
		modelMap.put("userRegisterVo", userRegisterVo);
		return getViewPath() + "/accountReg_1_SelAccountType";
	}

	@RequestMapping(value = "accountInfoFill")
	public String accountInfoFill(HttpServletRequest request,
			ModelMap modelMap, @Valid UserRegisterVo userRegisterVo,
			BindingResult errors) {
		// 默认账户身份为公司
		userRegisterVo.setUserIdentity("gongsi");
		userRegisterVo.setUserFlag(Constants.USER_FLAG_ACCOUNT);
		modelMap.put("userRegisterVo", userRegisterVo);
		return getViewPath() + "/accountReg_2_UserInfo_FillIn";
	}

	@RequestMapping(value = "userInfoFill")
	public String userInfoFill(HttpServletRequest request, ModelMap modelMap,
			@Valid UserRegisterVo userRegisterVotemp, BindingResult errors) {
		UserRegisterVo userRegisterVo = new UserRegisterVo();
		userRegisterVo.setUserFlag(Constants.USER_FLAG_USER);
		String invitationKey = request.getParameter("invitationKey");
		if (invitationKey != null && invitationKey.length() > 0) {
			userRegisterVo.setInvitationKey(invitationKey);
		}
		modelMap.put("userRegisterVo", userRegisterVo);
		return getViewPath() + "/userReg_1_UserInfo_FillIn";
	}

	@RequestMapping(value = "saveAccountInfo")
	public String saveAccountInfo(HttpServletRequest request,
			ModelMap modelMap, @Valid UserRegisterVo vo, BindingResult errors) {

//		String agree = request.getParameter("chkAgree");
		request.setAttribute("chkAgree", "1");
		if (StringUtils.isBlank(vo.getUserAccount())) {
			errors.rejectValue("userAccount", null, "账户名不能空!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		// 检查用户名是否符合邮箱地址格式
		if (!StringUtils.checkEmailAddress(vo.getUserAccount().trim())) {
			errors.rejectValue("userAccount", null, "账户名不是有效的Email地址!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		// 检查用户名是否已存在
		if (checkAccountIsExist(vo.getUserAccount().trim())) {
			errors.rejectValue("userAccount", null, "账户名已存在!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getUserPassword())) {
			errors.rejectValue("userPassword", null, "密码不能空!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getReUserPassword())) {
			errors.rejectValue("reUserPassword", null, "确认密码不能空!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		if (!vo.getReUserPassword().trim().equals(vo.getUserPassword().trim())) {
			errors.rejectValue("reUserPassword", null, "两次密码输入不一致，请重新输入!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getUserName())) {
			errors.rejectValue("userName", null, "姓名不能空!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getTel())) {
			errors.rejectValue("tel", null, "联系电话不能空!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}

		// 注册正式账户时，公司类型必填项.
		if (vo.getUserIdentity().equals("gongsi")
				&& vo.getUserAccountType().equals("zhengshi")) {
			if (StringUtils.isBlank(vo.getCompanyName())) {
				errors.rejectValue("companyName", null, "公司名称不能空!");
				return getViewPath() + "/accountReg_2_UserInfo_FillIn";
			}
			if (StringUtils.isBlank(vo.getBusinessLicense())) {
				errors.rejectValue("businessLicense", null, "营业执照号不能空!");
				return getViewPath() + "/accountReg_2_UserInfo_FillIn";
			}
			if (StringUtils.isBlank(vo.getBusinewssOrgCode())) {
				errors.rejectValue("businewssOrgCode", null, "企业组织机构代码不能空!");
				return getViewPath() + "/accountReg_2_UserInfo_FillIn";
			}
			if (StringUtils.isBlank(vo.getTaxCode())) {
				errors.rejectValue("taxCode", null, "税务登记证不能空!");
				return getViewPath() + "/accountReg_2_UserInfo_FillIn";
			}
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFiles("companyLogoFile")
					.get(0);
			String onDiskFileName = uploadFile(request, file);
			if (onDiskFileName != null && onDiskFileName.trim().length() > 0) {
				vo.setCompanyLogoFileURI(onDiskFileName);
			}
		}
		// 注册正式账户时，个人，开发者需填写身份证号.
		if (!vo.getUserIdentity().equals("gongsi")
				&& vo.getUserAccountType().equals("zhengshi")) {
			if (StringUtils.isBlank(vo.getIdentityCard())) {
				errors.rejectValue("identityCard", null, "身份证号不能空!");
				return getViewPath() + "/accountReg_2_UserInfo_FillIn";
			}
			if(basicUserService.userCardIsExist(vo.getIdentityCard(), vo.getUserAccount())){
				errors.rejectValue("identityCard", null, "该身份证号已被注册!");
				return getViewPath() + "/accountReg_2_UserInfo_FillIn";				
			}
		}
		if (StringUtils.isBlank(vo.getRand())) {
			errors.rejectValue("rand", null, "验证码不能空!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}
		if (!vo.getRand().equals(request.getSession().getAttribute("rand"))) {
			errors.rejectValue("rand", null, "验证码不正确!");
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";
		}

		try {
			BasicUserVo basicUservo = genBasicUserVoForAccount(vo);
			this.basicUserService.save(basicUservo);
			BasicUserActivationCodeVo basicUserActivationCodeVo = new BasicUserActivationCodeVo();
			basicUserActivationCodeVo.setUserId(basicUservo.getUserId());
			basicUserActivationCodeVo.setState(1);
			this.basicUserActivationCodeService.save(basicUserActivationCodeVo);
			mailService.sendMail(
					basicUservo.getUserAccount(),
					"",
					BaseConfigurator.getInstance().getCompanyName() + " 账户激活",
					getActivateMailContent(basicUservo,
							basicUserActivationCodeVo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errors.rejectValue("errors", null, "账户注册失败，" + e.getMessage());
			e.printStackTrace();
			return getViewPath() + "/accountReg_2_UserInfo_FillIn";

		}
		return getViewPath() + "/accountReg_3_Email_Verify";
	}

	@RequestMapping(value = "saveUserInfo")
	public String saveUserInfo(HttpServletRequest request, ModelMap modelMap,
			@Valid UserRegisterVo vo, BindingResult errors) {
//		String agree = request.getParameter("chkAgree");
		if (StringUtils.isBlank(vo.getUserAccount())) {
			errors.rejectValue("userAccount", null, "用户名不能空!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		// 检查用户名是否符合邮箱地址格式
		if (!StringUtils.checkEmailAddress(vo.getUserAccount().trim())) {
			errors.rejectValue("userAccount", null, "用户名不是有效的Email地址!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		// 检查用户名是否已存在
		if (checkAccountIsExist(vo.getUserAccount().trim())) {
			errors.rejectValue("userAccount", null, "用户名已存在!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getUserPassword())) {
			errors.rejectValue("userPassword", null, "密码不能空!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getReUserPassword())) {
			errors.rejectValue("reUserPassword", null, "确认密码不能空!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		if (!vo.getReUserPassword().trim().equals(vo.getUserPassword().trim())) {
			errors.rejectValue("reUserPassword", null, "两次密码输入不一致，请重新输入!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getUserName())) {
			errors.rejectValue("userName", null, "姓名不能空!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		if (StringUtils.isBlank(vo.getTel())) {
			errors.rejectValue("tel", null, "联系电话不能空!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}

		if (StringUtils.isBlank(vo.getRand())) {
			errors.rejectValue("rand", null, "验证码不能空!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}
		if (!vo.getRand().equals(request.getSession().getAttribute("rand"))) {
			errors.rejectValue("rand", null, "验证码不正确!");
			return getViewPath() + "/userReg_1_UserInfo_FillIn";
		}

		try {
			BasicUserVo basicUservo = genBasicUserVoForUser(vo);
			this.basicUserService.save(basicUservo);
			BasicUserActivationCodeVo basicUserActivationCodeVo = new BasicUserActivationCodeVo();
			basicUserActivationCodeVo.setUserId(basicUservo.getUserId());
			basicUserActivationCodeVo.setState(1);
			this.basicUserActivationCodeService.save(basicUserActivationCodeVo);
			mailService.sendMail(
					basicUservo.getUserAccount(),
					"",
					BaseConfigurator.getInstance().getCompanyName() + " 激活",
					getActivateMailContent(basicUservo,
							basicUserActivationCodeVo));
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getViewPath() + "/userReg_2_Email_Verify";
	}

	@RequestMapping(value = "accountRegisterComfirm")
	public String accountRegisterComfirm(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String key = request.getParameter("key");
		if (StringUtil.isNotNull(key)) {
			try {
				BasicUserActivationCodeVo basicUserActivationCodeVo = this.basicUserActivationCodeService
						.getUserActivationBykey(key);
				if (basicUserActivationCodeVo != null) {
					BasicUserVo basicUserVo = this.basicUserService
							.getBasicUserVoByUserId(basicUserActivationCodeVo
									.getUserId());
					basicUserVo.setState(Constants.USER_STATE_ACTIVE);
					this.basicUserService.save(basicUserVo);
					basicUserActivationCodeVo.setState(0);
					this.basicUserActivationCodeService
							.save(basicUserActivationCodeVo);
					return getViewPath() + "/accountReg_4_Finish";
				} else {
					return getViewPath() + "/keyInvalid";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "userRegisterComfirm")
	public String userRegisterComfirm(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String key = request.getParameter("key");
		if (StringUtil.isNotNull(key)) {
			try {
				BasicUserActivationCodeVo basicUserActivationCodeVo = this.basicUserActivationCodeService
						.getUserActivationBykey(key);
				if (basicUserActivationCodeVo != null) {
					BasicUserVo basicUserVo = this.basicUserService
							.getBasicUserVoByUserId(basicUserActivationCodeVo
									.getUserId());
					basicUserVo.setState(Constants.USER_STATE_ACTIVE);
					this.basicUserService.save(basicUserVo);
					basicUserActivationCodeVo.setState(0);
					this.basicUserActivationCodeService
							.save(basicUserActivationCodeVo);
					
					//用户通过前台注册激活后，发送邮件给上级账户申请审批
					mailService.sendMail(
							basicUserVo.getParentBasicUser().getUserAccount(),
							"",
							basicUserVo.getUserAccount() + " 用户审批申请",
							getApprovalRequestContent(basicUserVo));
					
					return getViewPath() + "/userReg_3_Finish";
				} else {
					return getViewPath() + "/keyInvalid";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	private String getApprovalRequestContent(BasicUserVo basicUserVo) {
		String content = "亲爱的：" + basicUserVo.getParentBasicUser().getUserName() 
				+ "<br>您好！用户" + basicUserVo.getUserName() + "已注册成功，正等待您的审批，"
				+ "请尽快登陆" + BaseConfigurator.getInstance().getCompanyName() + "进行审批。"
				+ "<br>系统登录地址：<a href='"+BaseConfigurator.getInstance().getServerAddress()+"'>"+BaseConfigurator.getInstance().getServerAddress()+"</a>"
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}
	
	
	
	@RequestMapping(value = "gotoInvitation")
	public String gotoInvitation(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		BasicUserVo basicUserVo = (BasicUserVo) request.getSession()
				.getAttribute(Constants.SESSION_USER_KEY);
		UserRegisterVo userRegisterVo = new UserRegisterVo();
		userRegisterVo.setUserFlag(Integer.parseInt(request
				.getParameter("userFlag")));
		String userAccount = request.getParameter("userAccount");
		if (StringUtils.isNotBlank(userAccount)) {
			userRegisterVo.setUserAccount(userAccount);
		}
		BasicUserActivationCodeVo basicUserActivationCodeVo = new BasicUserActivationCodeVo();
		basicUserActivationCodeVo.setUserId(basicUserVo.getUserId());
		basicUserActivationCodeVo.setState(1);
		try {
			this.basicUserActivationCodeService.save(basicUserActivationCodeVo);
			// 账户邀请
			if (userRegisterVo.getUserFlag().intValue() == Constants.USER_FLAG_ACCOUNT) {
				userRegisterVo
						.setRemark(BaseConfigurator.getInstance()
								.getServerAddress()
								+ "/base/userRegister/selectAccountType.do?invitationKey="
								+ basicUserActivationCodeVo.getActivationCode());
			} else {
				// 用户邀请
				userRegisterVo.setRemark(BaseConfigurator.getInstance()
						.getServerAddress()
						+ "/base/userRegister/userInfoFill.do?invitationKey="
						+ basicUserActivationCodeVo.getActivationCode());
			}
			modelMap.put("userRegisterVo", userRegisterVo);
			// if(userRegisterVo.getUserFlag().equals("1")){
			if (userRegisterVo.getUserFlag() == Constants.USER_FLAG_ACCOUNT) {
				request.setAttribute("invitationTitle", "账户邀请");
			} else {
				request.setAttribute("invitationTitle", "用户邀请");
			}
			return getViewPath() + "/sendInvitation";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "sendInvitation")
	public String sendInvitation(HttpServletRequest request, ModelMap modelMap,
			@Valid UserRegisterVo vo, BindingResult errors) {
		if (StringUtils.isBlank(vo.getUserAccount())) {
			errors.rejectValue("userAccount", null, "被邀请人邮箱不能为空!");
			return getViewPath() + "/sendInvitation";
		}
		// 检查邀请邮箱地址格式
		if (!StringUtils.checkEmailAddress(vo.getUserAccount().trim())) {
			errors.rejectValue("userAccount", null, "被邀请人邮箱不是有效的Email地址!");
			return getViewPath() + "/sendInvitation";
		}
		// 检查邀请邮箱是否已注册存在
		if (checkAccountIsExist(vo.getUserAccount().trim())) {
			errors.rejectValue("userAccount", null, "该邮箱在本系统已注册!");
			return getViewPath() + "/sendInvitation";
		}
		try {
			BasicUserVo basicUservo = genBasicUserVoForAccount(vo);
			mailService.sendMail(vo.getUserAccount(), "", BaseConfigurator
					.getInstance().getCompanyName() + " 账户/用户注册邀请",
					getInviteMailContent(basicUservo));
			modelMap.put("messages", "邀请链接发送成功！");
			return getViewPath() + "/sendInvitation";
			// return getViewPath()+"/sendInvitationFinish";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkAccountIsExist(String account) {
		BasicUserVo userVo = null;
		try {
			userVo = this.basicUserService.getBasicUserVoByUserAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userVo == null) {
			return false;
		} else {
			return true;
		}
	}

	public BasicUserVo genBasicUserVoForAccount(UserRegisterVo vo)
			throws Exception {
		BasicUserVo userVo = new BasicUserVo();
		userVo.setUserAccount(vo.getUserAccount().trim());
		userVo.setUserPassword(vo.getUserPassword());
		userVo.setUserName(vo.getUserName());
		userVo.setTel(vo.getTel());
		userVo.setCompanyName(vo.getCompanyName());
		userVo.setBusinessLicense(vo.getBusinessLicense());
		userVo.setBusinewssOrgCode(vo.getBusinewssOrgCode());
		userVo.setTaxCode(vo.getTaxCode());
		userVo.setIdentityCard(vo.getIdentityCard());
		userVo.setRemark(vo.getRemark());
		userVo.setUserTypeDictItem(this.basicDictItemService
				.getBasicDictItemVoByItemCode("userAccountType",
						vo.getUserAccountType()));
		userVo.setUserIdentityDictItem(this.basicDictItemService
				.getBasicDictItemVoByItemCode("userIdentity",
						vo.getUserIdentity()));
		userVo.setRegisterDate(new Date());
		userVo.setUserFlag(Constants.USER_FLAG_ACCOUNT);
		userVo.setState(Constants.USER_STATE_NOACTIVE);
		userVo.setCompanyLogoFileURI(vo.getCompanyLogoFileURI());
		// 检查是否通过邀请注册
		if (vo.getInvitationKey() != null
				&& vo.getInvitationKey().trim().length() > 0) {
			BasicUserActivationCodeVo basicUserActivationCodeVo = this.basicUserActivationCodeService
					.getUserActivationBykey(vo.getInvitationKey());
			if (basicUserActivationCodeVo != null) {
				BasicUserVo inviteUserVo = this.basicUserService
						.getBasicUserVoByUserId(basicUserActivationCodeVo
								.getUserId());
				userVo.setInviteBasicUser(inviteUserVo);
			}
		}
		return userVo;
	}

	public BasicUserVo genBasicUserVoForUser(UserRegisterVo vo)
			throws Exception {
		BasicUserVo userVo = new BasicUserVo();
		userVo.setUserAccount(vo.getUserAccount().trim());
		userVo.setUserPassword(vo.getUserPassword());
		userVo.setUserName(vo.getUserName());
		userVo.setTel(vo.getTel());
		userVo.setRemark(vo.getRemark());
		userVo.setRegisterDate(new Date());
		userVo.setUserFlag(Constants.USER_FLAG_USER);
		userVo.setState(Constants.USER_STATE_NOACTIVE);
		userVo.setBirthDate(vo.getBirthDate());
		// 检查是否通过邀请注册
		if (vo.getInvitationKey() != null
				&& vo.getInvitationKey().trim().length() > 0) {
			BasicUserActivationCodeVo basicUserActivationCodeVo = this.basicUserActivationCodeService
					.getUserActivationBykey(vo.getInvitationKey());
			if (basicUserActivationCodeVo != null) {
				BasicUserVo inviteUserVo = this.basicUserService
						.getBasicUserVoByUserId(basicUserActivationCodeVo
								.getUserId());
				userVo.setParentBasicUser(inviteUserVo);
			}
		}
		return userVo;
	}

	/**
	 * 账户注册激活邮件内容生成
	 * 
	 * @param user
	 * @param basicUserActivationCodeVo
	 * @return
	 */
	private String getActivateMailContent(BasicUserVo user,
			BasicUserActivationCodeVo basicUserActivationCodeVo) {
		String strActivationMethod;
		String userType = "账户";
		if (user.getUserFlag() == Constants.USER_FLAG_ACCOUNT) {
			strActivationMethod = "accountRegisterComfirm";
		} else {
			userType = "用户";
			strActivationMethod = "userRegisterComfirm";
		}
		String content = "亲爱的"
				+ BaseConfigurator.getInstance().getCompanyName() + userType + "："
				+ user.getUserName() + "<br>您好！感谢您成为"
				+ BaseConfigurator.getInstance().getCompanyName()
				+ userType + "，您可以通过点击以下地址来直接激活" + "<br> <a href='"
				+ BaseConfigurator.getInstance().getServerAddress()
				+ "/base/userRegister/" + strActivationMethod + ".do?key="
				+ basicUserActivationCodeVo.getActivationCode() + "' >"
				+ BaseConfigurator.getInstance().getServerAddress()
				+ "/base/userRegister/" + strActivationMethod + ".do?key="
				+ basicUserActivationCodeVo.getActivationCode() + "</a>"
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}

	/**
	 * 账户邀请邮件生成
	 * 
	 * @param user
	 * @param basicUserActivationCodeVo
	 * @return
	 */
	private String getInviteMailContent(BasicUserVo user) {
		String content = "亲爱的：" + user.getUserAccount() + "<br>您好！盛情邀请您注册成为"
				+ BaseConfigurator.getInstance().getCompanyName()
				+ "账户/用户，您可以通过点击以下地址来进行注册" + "<br> <a href='"
				+ user.getRemark() + "' >" + user.getRemark() + "</a>"
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}

	/**
	 * 跳转至用户激活页面.
	 */
	@RequestMapping(value = "redirectActivationInfo")
	public String redirectActivationInfo(HttpServletRequest request,
			ModelMap modelMap, BindingResult errors) {
		return getViewPath() + "/activationInfo";
	}

	/**
	 * 邮箱激活用户
	 * 
	 * @param userAccount
	 * @return
	 */
	@RequestMapping(value = "activationInfo")
	public void activationInfo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> resultMap = new HashMap<String, String>();
		HttpSession session = request.getSession();
		String userAccount = request.getParameter("userAccount");
		String rand = request.getParameter("rand");
		try {
			if (StringUtils.isBlank(rand)) {
				resultMap.put("flag", "01");
				resultMap.put("error", "验证码不能为空!");
				printOutSteamContent(JSONObject.fromObject(resultMap)
						.toString(), response);
			} else if (!rand.equals(session.getAttribute("rand"))) {
				resultMap.put("flag", "02");
				resultMap.put("error", "验证码不正确!");
			} else {
				BasicUserVo basicUserVo = null;
				basicUserVo = basicUserService
						.getBasicUserVoByUserAccount(userAccount);
				if (basicUserVo == null) {
					resultMap.put("flag", "03");
					resultMap.put("error", "用户邮箱不存在!");
				} else {
					BasicUserActivationCodeVo basicUserActivationCodeVo = new BasicUserActivationCodeVo();
					basicUserActivationCodeVo
							.setUserId(basicUserVo.getUserId());
					basicUserActivationCodeVo.setState(1);
					this.basicUserActivationCodeService
							.save(basicUserActivationCodeVo);
					mailService.sendMail(
							basicUserVo.getUserAccount(),
							"",
							BaseConfigurator.getInstance().getCompanyName()+" 账户激活",
							getActivateMailContent(basicUserVo,
									basicUserActivationCodeVo));
					resultMap.put("flag", "10");
				}
			}
		} catch (Exception e) {
			resultMap.put("flag", "04");
			resultMap.put("error", "发送邮件不正确，请重新填写！");
			e.printStackTrace();
		} finally {
			try {
				printOutSteamContent(JSONObject.fromObject(resultMap)
						.toString(), response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public String getViewPath() {
		return "base";
	}

	@Override
	public BasicServiceI<BasicUserVo> getService() {
		return basicUserService;
	}

	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	@Autowired
	private BasicUserActivationCodeServiceI basicUserActivationCodeService;

	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	public BasicDictItemServiceI getBasicDictItemService() {
		return basicDictItemService;
	}

	public void setBasicDictItemService(
			BasicDictItemServiceI basicDictItemService) {
		this.basicDictItemService = basicDictItemService;
	}

	public BasicUserActivationCodeServiceI getBasicUserActivationCodeService() {
		return basicUserActivationCodeService;
	}

	public void setBasicUserActivationCodeService(
			BasicUserActivationCodeServiceI basicUserActivationCodeService) {
		this.basicUserActivationCodeService = basicUserActivationCodeService;
	}

}
