package sy.controller.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.BaseConfigurator;
import sy.common.util.Constants;
import sy.controller.shared.BaseController;
import sy.domain.vo.base.BasicUserActivationCodeVo;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.base.ChangePasswordVo;
import sy.service.base.BasicUserActivationCodeServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.core.MailServiceI;

@Controller
@RequestMapping("/change")
public class ChangePasswordController extends BaseController {

	@Autowired
	private MailServiceI mailService;

	@Autowired
	private BasicUserServiceI basicUserService;

	@Autowired
	private BasicUserActivationCodeServiceI basicUserActivationCodeService;

	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	public MailServiceI getMailService() {
		return mailService;
	}

	public void setMailService(MailServiceI mailService) {
		this.mailService = mailService;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "passwordLink")
	public String changePassLink(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String userId = request.getParameter("id");
		ChangePasswordVo changePassVo = new ChangePasswordVo();
		try {
			if (StringUtils.isBlank(userId)) {
				request.setAttribute("userAccountError", "用户名不存在!");
			} else {
				BasicUserVo basicUserVo = null;
				basicUserVo = this.getBasicUserService().get(userId);
				if (basicUserVo != null) {
					changePassVo.setUserAccount(basicUserVo.getUserAccount());
				} else {
					request.setAttribute("userAccountError", "用户名不存在!");
				}
			}
		} catch (Exception e) {
			request.setAttribute("userAccountError", "获取用户名错误,请重新获取邮件!");
			e.printStackTrace();
		} finally {
			modelMap.put("changePasswordVo", changePassVo);
			return "base/changePass";
		}
	}

	@RequestMapping(value = "password")
	public String excute(HttpServletRequest request, ModelMap modelMap,
			@Valid ChangePasswordVo vo, BindingResult errors) {
		if (StringUtils.isBlank(vo.getUserAccount())) {
			errors.rejectValue("userAccount", null, "用户名不能空!");
			return "base/changePass";
		}
		if (StringUtils.isBlank(vo.getUserPassword())) {
			errors.rejectValue("userPassword", null, "密码不能空!");
			return "base/changePass";
		}
		if (!vo.getUserPassword().equals(vo.getReUserPassword())) {
			errors.rejectValue("reUserPassword", null, "两次密码不符!");
			return "base/changePass";
		}
		BasicUserVo basicUserVo = null;
		try {
			basicUserVo = basicUserService.getBasicUserVoByUserAccount(vo
					.getUserAccount());
			if (basicUserVo == null) {
				errors.rejectValue("userAccount", null, "用户名不存在!");
				return "base/changePass";
			} else {
				basicUserVo.setUserPassword(vo.getUserPassword());
				basicUserService.save(basicUserVo);
				request.setAttribute("success", "修改成功，请返回登录页面重新登录!");
				return "base/changePass";
			}
		} catch (Exception e) {
			errors.rejectValue("errors", null, "用户修改密码时错误，请重新修改!");
			e.printStackTrace();
			return "base/login";

		}
	}

	/**
	 * 适用于激活账户以及忘记密码，激活账户是activationFlag=1
	 * 
	 * @param request
	 * @param modelMap
	 * @param vo
	 * @param errors
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forgotPass.do")
	public String forgotPass(HttpServletRequest request, ModelMap modelMap,
			@Valid ChangePasswordVo vo, BindingResult errors,
			HttpServletResponse response) {
		String activationFlag = request.getParameter("activationFlag");
		if (StringUtils.isNotBlank(activationFlag)) {
			vo.setActivationFlag("1");
		}
		return "base/forgotPass";

	}

	@RequestMapping(value = "/doForgotPass.do")
	public String doForgotPass(HttpServletRequest request, ModelMap modelMap,
			@Valid ChangePasswordVo vo, BindingResult errors,
			HttpServletResponse response) {
		if (StringUtils.isBlank(vo.getUserAccount())) {
			errors.rejectValue("userAccount", null, "用户名不能空!");
			return "base/forgotPass";
		}
		if (!vo.getRand().equals(request.getSession().getAttribute("rand"))) {
			errors.rejectValue("rand", null, "验证码不正确!");
			return "base/forgotPass";
		}
		try {
			BasicUserVo basicUserVo = null;
			basicUserVo = basicUserService.getBasicUserVoByUserAccount(vo
					.getUserAccount());
			if (basicUserVo == null) {
				errors.rejectValue("userAccount", null, "用户名不存在!");
				return "base/forgotPass";
			} else {
				if (StringUtils.isBlank(vo.getActivationFlag())) {
					mailService.sendMail(basicUserVo.getUserAccount(), "",
							BaseConfigurator.getInstance().getCompanyName()
									+ "重置密码邮件", getMailContent(basicUserVo));
				} else {
					QueryContext context = new ECContext(request, modelMap,
							"user");
					context.clearParmeters();
					context.put("userId", basicUserVo.getUserId());
					context.put("state", "1");
					List<BasicUserActivationCodeVo> basicUserActivationCodeList = new ArrayList<BasicUserActivationCodeVo>();
					basicUserActivationCodeList = this.basicUserActivationCodeService
							.list(context);
					for (BasicUserActivationCodeVo basicUserActivationCodeVo : basicUserActivationCodeList) {
						basicUserActivationCodeVo.setState(0);
						this.basicUserActivationCodeService
								.save(basicUserActivationCodeVo);
					}
					BasicUserActivationCodeVo basicUserActivationCodeVo = new BasicUserActivationCodeVo();
					basicUserActivationCodeVo
							.setUserId(basicUserVo.getUserId());
					basicUserActivationCodeVo.setState(1);
					this.basicUserActivationCodeService
							.save(basicUserActivationCodeVo);
					mailService.sendMail(
							basicUserVo.getUserAccount(),
							"",
							BaseConfigurator.getInstance().getCompanyName()
									+ "账户激活",
							getActivateMailContent(basicUserVo,
									basicUserActivationCodeVo));
				}
			}
		} catch (Exception e) {
			errors.rejectValue("errors", null, "找回密码错误，请重试!");
			e.printStackTrace();
			return "base/forgotPass";
		} finally {

		}
		request.setAttribute("success", "激活链接已经发送至邮箱，请查收!");
		return "base/forgotPass";
	}

	private String getMailContent(BasicUserVo user) {
		String content = "尊敬的" + user.getUserName()
				+ "，您好！ <br>您收到这封这封电子邮件是因为您 (也可能是某人冒充您的名义) 申请了一个新的密码。"
				+ "假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。"
				+ "<br><br> 要使用新的密码, 请使用以下链接启用密码。<br><br> <a href='"
				+ BaseConfigurator.getInstance().getServerAddress()
				+ "/change/passwordLink.do?id=" + user.getUserId() + "' >"
				+ BaseConfigurator.getInstance().getServerAddress()
				+ "/change/passwordLink.do?id=" + user.getUserId() + "</a>";
		return content;
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

}
