package sy.controller.base;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.mail.EmailHandler;
import sy.common.mail.EmailInfo;
import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.service.base.BasicUserServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 用户审批（用户激活后需要账户审批，是否可以登录系统）
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/userApproval")
@SessionAttributes("basicUserVo")
public class UserApprovalController extends BaseControllerTemplate<BasicUserVo> {

	@Autowired
	private BasicUserServiceI basicUserService;

	public String getViewPath(){
		return "base";
	}
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	@Override
	public BasicServiceI<BasicUserVo> getService() {
		return basicUserService;
	}
	
	protected void initContextParams(HttpServletRequest request,
			QueryContext context) {
		
	}

	
	/**
	 * 查询用户审批信息
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		//清理上一次查询参数
		context.clearParmeters();
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		BasicUserVo user =(BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		String 	userId=user.getUserId();
		context.put("$eq_parentBasicUser_userId", userId);
		//用户
		context.put("$in_userFlag", String.valueOf(Constants.USER_FLAG_USER));
		
		if("0".equals(queryType)){//审批状态一键式
			String stateFlag = request.getParameter("stateFlag");
			context.put("$eq_state", stateFlag);
			
		}else if("1".equals(queryType)){//申请日期
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_registerDate", DateUtil.getTodayDate());
				context.put("$le_registerDate", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_registerDate", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_registerDate", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_registerDate", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_registerDate", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_registerDate", DateUtil.getMonthFirstDay(null));
				context.put("$le_registerDate", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_registerDate", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_registerDate", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_registerDate", DateUtil.getFirstDayOfLastMonth());
			}			
			
		}else{//高级搜索
			
			//申请日期
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			context.put("$ge_registerDate", dateS);
			context.put("$le_registerDate", dateE);
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			
			String userName = request.getParameter("userName");
			String userAccount = request.getParameter("userAccount");
			String tel = request.getParameter("tel");
			context.put("$lk_userName", userName);
			context.put("$lk_userAccount", userAccount);
			context.put("$lk_tel", tel);
			request.setAttribute("userName", userName);
			request.setAttribute("userAccount", userAccount);
			request.setAttribute("tel", tel);
			
			//审批状态
			String[] stateArr = request.getParameterValues("state");
			String stateArrStr = "";
			if(stateArr != null && stateArr.length > 0){
				for(int i=0; i<stateArr.length; i++){
					stateArrStr += stateArr[i] + ",";
				}
				context.put("$in_state", stateArrStr.substring(0, stateArrStr.length()-1));
				request.setAttribute("stateArrStr", stateArrStr.substring(0, stateArrStr.length()-1));
			}
		}

		List<?> users = getService().list(context);
		context.initTotalRows(modelMap);
		modelMap.put("list", users);
		
		return getViewPath() + "/userApprovalList";
	}

	/**
	 * 审批通过
	 * @param userId
	 * @param request
	 * @param vo
	 * @param modelMap
	 * @param errors
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "approval")
	public String approval(@RequestParam("userId") String userId, HttpServletRequest request,
			BasicUserVo vo, ModelMap modelMap, BindingResult errors,HttpServletResponse response) throws ValidatorException {
		Map<String, String> resultMap = new HashMap<String, String>();
		String approvalState = request.getParameter("approvalState");
		String rejectRemark = request.getParameter("rejectRemark");
		BasicUserVo user = (BasicUserVo)this.basicUserService.get(userId);
		user.setState(Integer.parseInt(approvalState));
		user.setApprovalDate(new Date());
		user.setRefuseMemo(rejectRemark);
		
		// send mail
		try {
			if(Constants.USER_STATE_PASS == Integer.parseInt(approvalState)){
				//通过
				this.sendMail(user.getUserAccount(), "", Constants.USER_APPROVAL_MAIL_THEME.replace("@userType", "用户"), getMailContent(user, "pass"));
			}else{
				//拒绝
				this.sendMail(user.getUserAccount(), "", Constants.USER_APPROVAL_MAIL_THEME.replace("@userType", "用户"), getMailContent(user, "reject"));
			}
			
			this.basicUserService.save(user);
			resultMap.put("flag", "01");
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("flag", "02");
		}finally{
			try {
				printOutSteamContent(JSONObject.fromObject(resultMap).toString(), response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return this.list(request, modelMap);
	}

	/**
	 * 发送邮件
	 * @param toMail
	 * @param ccMail
	 * @param theme
	 * @param content
	 * @throws Exception 
	 */
	public void sendMail(String toMail, String ccMail, String theme, String content) throws Exception{
		EmailInfo emailInfo = new EmailInfo();
		emailInfo.setToEmail(new String[]{toMail});
		emailInfo.setCcEmail(new String[]{ccMail});
		emailInfo.setTheme(theme);
		emailInfo.setContent(content);

		emailHandler.sendHtmlMail(emailInfo);
		//throw new Exception();
	}
	
	private String getMailContent(BasicUserVo user, String mailType){
		String content = "";
		if("pass".equals(mailType)){
			content = user.getUserName() + Constants.USER_APPROVAL_PASS_TEMPLATE.replace("userAccount", user.getUserAccount())+user.getRefuseMemo();
		}else{
			content = user.getUserName()+Constants.USER_APPROVAL_REJECT_TEMPLATE.replace("userAccount", user.getUserAccount())+user.getRefuseMemo();
		}
		return content.replace("@userType", "用户");
	}
	
	private EmailHandler emailHandler;

	public EmailHandler getEmailHandler() {
		return emailHandler;
	}

	public void setEmailHandler(EmailHandler emailHandler) {
		this.emailHandler = emailHandler;
	}
	

}
