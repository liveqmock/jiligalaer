package sy.controller.finance;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicDictItemVo;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountRefundVo;
import sy.service.base.BasicDictItemServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.core.MailServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.finance.AccountRefundServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 账户退款处理
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/processRefund")
@SessionAttributes("accountRefundVo")
public class ProcessRefundController extends BaseControllerTemplate<AccountRefundVo> {
	
	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private AccountRefundServiceI accountRefundService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	@Autowired
	private MailServiceI mailService;

	public MailServiceI getMailService() {
		return mailService;
	}

	public void setMailService(MailServiceI mailService) {
		this.mailService = mailService;
	}
	
	public BasicDictItemServiceI getBasicDictItemService() {
		return basicDictItemService;
	}

	public void setBasicDictItemService(
			BasicDictItemServiceI basicDictItemService) {
		this.basicDictItemService = basicDictItemService;
	}
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}
	
	public AccountRefundServiceI getAccountRefundService() {
		return accountRefundService;
	}

	public void setAccountRefundService(AccountRefundServiceI accountRefundService) {
		this.accountRefundService = accountRefundService;
	}

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}
	
	public String getViewPath() {
		return "finance";
	}

	@Override
	public BasicServiceI<AccountRefundVo> getService() {
		return accountRefundService;
	}
	
	
	/**
	 * 获取字典项信息
	 * @param request
	 */
	public void getDictItemInfo(HttpServletRequest request){
		List<BasicDictItemVo> userAccountTypeItemList = null;
		List<BasicDictItemVo> userIdentityItemList = null;
		List<BasicDictItemVo> industryDictItemList = null;
		List<BasicDictItemVo> geoDictItemList = null;
		try {
			//账户类别
			userAccountTypeItemList = basicDictItemService.getBaiscDictItemListByDictType("userAccountType");
			//账户类型
			userIdentityItemList = basicDictItemService.getBaiscDictItemListByDictType("userIdentity");
			//行业
			industryDictItemList = basicDictItemService.getBaiscDictItemListByDictType("industry");
			//地区
			geoDictItemList = basicDictItemService.getBaiscDictItemListByDictType("geo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("userAccountType", userAccountTypeItemList);
		request.setAttribute("userIdentity", userIdentityItemList);
		request.setAttribute("industry", industryDictItemList);
		request.setAttribute("geo", geoDictItemList);
	}
	
	/**
	 * 获取账户退款申请列表
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		this.getDictItemInfo(request);
		
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		//清理上一次查询参数
		context.clearParmeters();
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		
		if("0".equals(queryType)){//账户类别一键式
			String userAccountTypeFlag = request.getParameter("userAccountTypeFlag");
			context.put("$eq_basicUser_userTypeDictItem_itemCode", userAccountTypeFlag);
			
		}else if("1".equals(queryType)){//账户类型一键式
			String userIdentityFlag = request.getParameter("userIdentityFlag");
			context.put("$eq_basicUser_userIdentityDictItem_itemCode", userIdentityFlag);
			
		}else if("2".equals(queryType)){//地区一键式
			String geoFlag = request.getParameter("geoFlag");
			context.put("$eq_basicUser_geoDictItem_itemCode", geoFlag);
			
		}else if("3".equals(queryType)){//行业一键式
			String industryFlag = request.getParameter("industryFlag");
			context.put("$eq_basicUser_industryDictItem_itemCode", industryFlag);			
			
		}else if("4".equals(queryType)){//退款申请日期一键式
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag0");
			if ("1".equals(timeFlag)){
				context.put("$ge_applyDate", DateUtil.getTodayDate());
				context.put("$le_applyDate", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_applyDate", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_applyDate", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_applyDate", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_applyDate", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_applyDate", DateUtil.getMonthFirstDay(null));
				context.put("$le_applyDate", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_applyDate", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_applyDate", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_applyDate", DateUtil.getFirstDayOfLastMonth());
			}
			
		}else if("5".equals(queryType)){//退款处理日期一键式
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag1");
			if ("1".equals(timeFlag)){
				context.put("$ge_refundDate", DateUtil.getTodayDate());
				context.put("$le_refundDate", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_refundDate", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_refundDate", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_refundDate", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_refundDate", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_refundDate", DateUtil.getMonthFirstDay(null));
				context.put("$le_refundDate", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_refundDate", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_refundDate", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_refundDate", DateUtil.getFirstDayOfLastMonth());
			}			
			
		}else if("6".equals(queryType)){//处理状态一键式
			String stateFlag = request.getParameter("stateFlag");
			context.put("$eq_state", stateFlag);
			
		}else{//高级搜索
			
			//充值日期
			String applyDateS = request.getParameter("applyDateS");
			String applyDateE = request.getParameter("applyDateE");
			String processDateS = request.getParameter("processDateS");
			String processDateE = request.getParameter("processDateE");			

			context.put("$ge_applyDate", applyDateS);
			context.put("$le_applyDate", applyDateE);
			context.put("$ge_refundDate", processDateS);
			context.put("$le_refundDate", processDateE);
			
			String userName = request.getParameter("userName");
			String userAccount = request.getParameter("userAccount");
			context.put("$lk_basicUser.userName", userName);
			context.put("$lk_basicUser.userAccount", userAccount);
			
			request.setAttribute("applyDateS", applyDateS);
			request.setAttribute("applyDateE", applyDateE);			
			request.setAttribute("processDateS", processDateS);
			request.setAttribute("processDateE", processDateE);
			request.setAttribute("userName", userName);
			request.setAttribute("userAccount", userAccount);
			
			//账户类别
			String[] userAccountTypeArr = request.getParameterValues("userAccountType");
			String userAccountTypeStr = "";
			if(userAccountTypeArr != null && userAccountTypeArr.length > 0){
				for(int i=0; i<userAccountTypeArr.length; i++){
					userAccountTypeStr += userAccountTypeArr[i] + ",";
				}
				context.put("$in_basicUser_userTypeDictItem_itemCode", userAccountTypeStr.substring(0, userAccountTypeStr.length()-1));
				request.setAttribute("userAccountTypeStr", userAccountTypeStr.substring(0, userAccountTypeStr.length()-1));
			}
			
			//账户类型
			String[] userIdentityArr = request.getParameterValues("userIdentity");
			String userIdentityStr = "";
			if(userIdentityArr != null && userIdentityArr.length > 0){
				for(int i=0; i<userIdentityArr.length; i++){
					userIdentityStr += userIdentityArr[i] + ",";
				}
				context.put("$in_basicUser_userIdentityDictItem_itemCode", userIdentityStr.substring(0, userIdentityStr.length()-1));
				request.setAttribute("userIdentityStr", userIdentityStr.substring(0, userIdentityStr.length()-1));
			}

			//地区
			String[] geoArr = request.getParameterValues("geo");
			String geoStr = "";
			if(geoArr != null && geoArr.length > 0){
				for(int i=0; i<geoArr.length; i++){
					geoStr += geoArr[i] + ",";
				}
				context.put("$in_basicUser_geoDictItem_itemCode", geoStr.substring(0, geoStr.length()-1));
				request.setAttribute("geoStr", geoStr.substring(0, geoStr.length()-1));
			}

			//行业
			String[] industryArr = request.getParameterValues("industry");
			String industryStr = "";
			if(industryArr != null && industryArr.length > 0){
				for(int i=0; i<industryArr.length; i++){
					industryStr += industryArr[i] + ",";
				}
				context.put("$in_basicUser_industryDictItem_itemCode", industryStr.substring(0, industryStr.length()-1));
				request.setAttribute("industryStr", industryStr.substring(0, industryStr.length()-1));
			}
			//退款处理状态
			String[] stateArr = request.getParameterValues("state");
			String stateStr = "";
			if(stateArr != null && stateArr.length > 0){
				for(int i=0; i<stateArr.length; i++){
					stateStr += stateArr[i] + ",";
				}
				context.put("$in_state", stateStr.substring(0, stateStr.length()-1));
				request.setAttribute("stateStr", stateStr.substring(0, stateStr.length()-1));
			}	
			
		}
		
		List<?> refundList = this.accountRefundService.list(context);
		context.initTotalRows(modelMap);
		modelMap.put("list", refundList);
	
		return "finance/accountRefundList";
	}

	/**
	 * 退款处理编辑页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "edit")
	public String edit(HttpServletRequest request, ModelMap modelMap, String id) throws ValidatorException {
		super.edit(request, modelMap, id);
		
		AccountRefundVo vo = this.getService().get(id);
		AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(vo.getBasicUser().getUserId());
		modelMap.put("expVo", expVo);
		modelMap.put("refundDate", DateUtil.formatDate(new Date()));
		
		return "finance/accountRefundEdit";
	}
	
	/**
	 * 退款处理保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap, @Valid AccountRefundVo vo, BindingResult errors) {
		//修改总费用表金额
		AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(vo.getBasicUser().getUserId());
//		if(expVo != null && null != expVo.getIsBilling() && expVo.getIsBilling() == 1){
//			modelMap.put("processMsg", "现在系统计费时间，请稍后再进行处理。");
//			return "finance/accountRefundEdit";
//		}
		if(this.accountExpenseService.isBilling()){
			modelMap.put("processMsg", "现在系统计费时间，请稍后再进行退款处理。");
			return "finance/accountRefundEdit";
		}
		
		String refundDate = request.getParameter("refundDate");
		vo.setRefundDate(refundDate);
		vo.setRefundBy(this.getCurrentUser(request).getUserName());
		
		//保存时：1，修改费用总表；2，修改退款表；3，验证费用是否够用；
		try {
			if(vo.getState() == 1){
				//确认退款
				this.accountRefundService.saveRefund(expVo, vo);
				
				//发送退款处理成功邮件
				try {
					BasicUserVo basicUser = this.basicUserService.get(vo.getBasicUser().getUserId());
					mailService.sendMail(
							basicUser.getUserAccount(),
							"",
							BaseConfigurator.getInstance().getCompanyName() + "账户退款成功通知",
							getRefundSuccessContent(basicUser, vo.getApplyAmount(), vo.getRefundAmount()));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				modelMap.put("processMsg", "退款处理成功");					
			}else{
				//拒绝退款
				this.accountRefundService.saveRefund(null, vo);
				modelMap.put("processMsg", "已拒绝退款");
			}
			
		} catch (ValidatorException e) {
			modelMap.put("processMsg", "退款处理失败");
			errors.rejectValue("errors",null, e.getMessage());
			e.printStackTrace();
		}			

		return "finance/accountRefundEdit";
//		return getRedirectStr("/processRefund/list.do");
//		return getRedirectStr(getCloseView());
	}

	private String getRefundSuccessContent(BasicUserVo basicUserVo, Double applyAmount, Double refundAmount) {
		String content = "亲爱的：" + basicUserVo.getUserName() 
				+ "<br>您好！您的退款申请已通过系统审批，退款成功。<br>申请退款金额：" + applyAmount + "，实际退款金额：" + refundAmount 
				+ "<br>请及时查看您的账户到账金额。"
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}
	
}
