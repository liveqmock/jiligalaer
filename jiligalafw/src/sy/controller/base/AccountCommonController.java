package sy.controller.base;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseController;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseItemVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountPayVo;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.service.base.BasicRemindServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.expense.AccountExpenseItemServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.finance.AccountPayServiceI;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudMdmTemplateServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmVolumeServiceI;
import sy.service.product.CloudUserOrderItemServiceI;
import sy.service.product.CloudUserOrderServiceI;

/**
 * 账户维护编辑页面底部的订单、账单、提醒、虚拟机、网络、模板、快照、卷、ISO、IP地址）
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/accInfo")
public class AccountCommonController extends BaseController {
	
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	@Autowired
	private AccountPayServiceI accountPayService;
	@Autowired
	private AccountExpenseItemServiceI accountExpenseItemService;
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	@Autowired
	private CloudMdmVolumeServiceI cloudMdmVolumeService;
	@Autowired
	private CloudMdmTemplateServiceI cloudMdmTemplateService;
	@Autowired
	private CloudMdmIPServiceI cloudMdmIPService;
	@Autowired
	private CloudMdmNetworkServiceI cloudMdmNetworkService;
	@Autowired
	private BasicRemindServiceI basicRemindService;
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}

	public AccountPayServiceI getAccountPayService() {
		return accountPayService;
	}

	public void setAccountPayService(AccountPayServiceI accountPayService) {
		this.accountPayService = accountPayService;
	}

	public AccountExpenseItemServiceI getAccountExpenseItemService() {
		return accountExpenseItemService;
	}

	public void setAccountExpenseItemService(
			AccountExpenseItemServiceI accountExpenseItemService) {
		this.accountExpenseItemService = accountExpenseItemService;
	}
	
	public CloudUserOrderServiceI getCloudUserOrderService() {
		return cloudUserOrderService;
	}

	public void setCloudUserOrderService(
			CloudUserOrderServiceI cloudUserOrderService) {
		this.cloudUserOrderService = cloudUserOrderService;
	}

	public CloudMdmProductServiceI getCloudMdmProductService() {
		return cloudMdmProductService;
	}

	public void setCloudMdmProductService(
			CloudMdmProductServiceI cloudMdmProductService) {
		this.cloudMdmProductService = cloudMdmProductService;
	}

	public CloudMdmProductItemServiceI getCloudMdmProductItemService() {
		return cloudMdmProductItemService;
	}

	public void setCloudMdmProductItemService(
			CloudMdmProductItemServiceI cloudMdmProductItemService) {
		this.cloudMdmProductItemService = cloudMdmProductItemService;
	}

	
	public CloudMdmVMServiceI getCloudMdmVMService() {
		return cloudMdmVMService;
	}

	public void setCloudMdmVMService(CloudMdmVMServiceI cloudMdmVMService) {
		this.cloudMdmVMService = cloudMdmVMService;
	}

	public CloudMdmVolumeServiceI getCloudMdmVolumeService() {
		return cloudMdmVolumeService;
	}

	public void setCloudMdmVolumeService(
			CloudMdmVolumeServiceI cloudMdmVolumeService) {
		this.cloudMdmVolumeService = cloudMdmVolumeService;
	}

	public CloudMdmTemplateServiceI getCloudMdmTemplateService() {
		return cloudMdmTemplateService;
	}

	public void setCloudMdmTemplateService(
			CloudMdmTemplateServiceI cloudMdmTemplateService) {
		this.cloudMdmTemplateService = cloudMdmTemplateService;
	}

	public CloudMdmIPServiceI getCloudMdmIPService() {
		return cloudMdmIPService;
	}

	public void setCloudMdmIPService(CloudMdmIPServiceI cloudMdmIPService) {
		this.cloudMdmIPService = cloudMdmIPService;
	}

	public CloudMdmNetworkServiceI getCloudMdmNetworkService() {
		return cloudMdmNetworkService;
	}

	public void setCloudMdmNetworkService(
			CloudMdmNetworkServiceI cloudMdmNetworkService) {
		this.cloudMdmNetworkService = cloudMdmNetworkService;
	}

	public CloudUserOrderItemServiceI getCloudUserOrderItemService() {
		return cloudUserOrderItemService;
	}

	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}
	
	public BasicRemindServiceI getBasicRemindService() {
		return basicRemindService;
	}

	public void setBasicRemindService(BasicRemindServiceI basicRemindService) {
		this.basicRemindService = basicRemindService;
	}
	
	
	/**
	 * 账户、用户编辑页面-订单信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "orderInfo")
	public String orderInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String userId) throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap, "orderInfo");
		context.clearParmeters();
		if("".equals(userId)){
			List<?> orderList = new ArrayList<Object>();
			context.initTotalRows(modelMap);
			modelMap.put("orderList", orderList);
			return "product/acc_orderInfo";
		}

		
		BasicUserVo basicUser = this.basicUserService.get(userId);
		if(basicUser.getUserFlag() == Constants.USER_FLAG_ACCOUNT){
			//账户下所有用户ID拼接（包含账户ID）
			//String userIdAndAccountIdStr = this.basicUserService.getSubUserByParentUserId(userId);
			context.put("$eq_cloudUserOrder_basicAccount_userId", userId);
		}else{
			context.put("$eq_cloudUserOrder_basicUser_userId", userId);
		}
		modelMap.put("userId", userId);
		
		// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
		String timeFlag = request.getParameter("timeFlag");
		if ("1".equals(timeFlag)){
			context.put("$ge_cloudUserOrder_orderTime", DateUtil.getTodayDate());
			context.put("$le_cloudUserOrder_orderTime", DateUtil.getTodayDate());
			
		} else if ("2".equals(timeFlag)){
			context.put("$ge_cloudUserOrder_orderTime", DateUtil.getFirstDayOfCurrWeek());
			context.put("$le_cloudUserOrder_orderTime", DateUtil.getLastDayOfCurrWeek());
			
		} else if ("3".equals(timeFlag)){
			context.put("$ge_cloudUserOrder_orderTime", DateUtil.getFirstDayOfLastWeek());
			context.put("$le_cloudUserOrder_orderTime", DateUtil.getLastDayOfLastWeek());
			
		} else if ("4".equals(timeFlag)){
			context.put("$ge_cloudUserOrder_orderTime", DateUtil.getMonthFirstDay(null));
			context.put("$le_cloudUserOrder_orderTime", DateUtil.getMonthLastDay(null));
			
		} else if ("5".equals(timeFlag)){
			context.put("$ge_cloudUserOrder_orderTime", DateUtil.getFirstDayOfLastMonth());
			context.put("$le_cloudUserOrder_orderTime", DateUtil.getLastDayOfLastMonth());
			
		} else if ("6".equals(timeFlag)){
			context.put("$lt_cloudUserOrder_orderTime", DateUtil.getFirstDayOfLastMonth());
		}
		
		context.isNotNull("resDestroyTime");
		context.equals("cloudUserOrder_state", String.valueOf(Constants.VALID_STATE));
		context.setSort(" cloudUserOrder_orderTime desc ");
		context.setSort(" cloudUserOrder_orderId asc ");
		
		List<?> orderList = this.cloudUserOrderItemService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("orderList", orderList);
		modelMap.put("timeFlag", timeFlag);
		
		return "product/acc_orderInfo";
	}

	/**
	 * 账单信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "billInfo")
	public String billInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String userId) throws ValidatorException {
		
		AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(userId);
		QueryContext context = new ECContext(request, modelMap, "billInfo");
		context.clearParmeters();
		context.put("$in_basicUser_userId", userId=="" ? "-1" : userId);
		//充值
		List<AccountPayVo> payList = this.accountPayService.list(context);
		Double totalPayAmount = 0D;
		for(AccountPayVo itemVo : payList){
			totalPayAmount += itemVo.getPayAmount();
		}
		
		//费用
		context.clearParmeters();
		BasicUserVo basicUser = null;
		int userFlag = -1;
		if(!"".equals(userId)){
			basicUser = this.basicUserService.get(userId);
			userFlag = basicUser.getUserFlag();
		}
		if(userFlag == Constants.USER_FLAG_ACCOUNT){
			context.put("$eq_cloudUserOrder_basicAccount_userId", userId);
		}else if(userFlag == Constants.USER_FLAG_USER){
			context.put("$eq_cloudUserOrder_basicUser_userId", userId);
		}else{
			context.put("$eq_cloudUserOrder_basicUser_userId", "-1");
		}
		//context.put("$eq_cloudUserOrder_basicUser_userId", userId=="" ? "-1" : userId);
		List<AccountExpenseItemVo> expItemList = this.accountExpenseItemService.list(context);
		
		Double totalExpAmount = 0D;
		for(AccountExpenseItemVo itemVo : expItemList){
			totalExpAmount += itemVo.getExpAmount();
		}
		
		context.initTotalRows(modelMap);
		modelMap.put("expItemList", expItemList);
		modelMap.put("payList", payList);
		modelMap.put("expVo", expVo);
		modelMap.put("totalExpAmount", totalExpAmount);
		modelMap.put("totalPayAmount", totalPayAmount);
		
		return "product/acc_billInfo";
	}

	/**
	 * 提醒信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "remindInfo")
	public String remindInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String userId) throws ValidatorException {

		QueryContext context = new ECContext(request,modelMap,"remindInfo");
		context.clearParmeters();
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		context.put("$eq_accountId", userId);
		
		if("0".equals(queryType)){
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getTodayDate());
				context.put("$le_created", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_created", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_created", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getMonthFirstDay(null));
				context.put("$le_created", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_created", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_created", DateUtil.getFirstDayOfLastMonth());
			}			
			
		}else{//高级搜索
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			context.put("$ge_created", dateS);
			context.put("$le_created", dateE);
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			
			String keyword = request.getParameter("keyword");
			context.put("$lk_message", keyword);
			request.setAttribute("keyword", keyword);
			
		}
		
		List<?> remindList = this.basicRemindService.list(context);
		context.initTotalRows(modelMap);
		modelMap.put("remindList", remindList);
		modelMap.put("userId", userId);
		
		return "product/acc_remindInfo";
	}

	/**
	 * 虚拟机信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "vmInfo")
	public String vmInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String userId) throws ValidatorException {
		
//		QueryContext context = new ECContext(request, modelMap, "vmInfo");
//		context.clearParmeters();
//		context.put("$eq_account", userId);
//		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
//		List<?> vmList = this.cloudMdmVMService.list(context);
//		
//		context.initTotalRows(modelMap);
//		modelMap.put("vmList", vmList);
		
		
		QueryContext context = new ECContext(request, modelMap, "vmInfo");
		context.clearParmeters();
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		BasicUserVo basicUser = this.basicUserService.get(userId);
		context.put("$eq_account", basicUser.getUserAccount());
		//context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		String vmState = Constants.VM_STATE_RUNNING + "," + Constants.VM_STATE_STOPPED + "," + Constants.VM_STATE_DESTROYED;
		context.put("$in_state", vmState);
		
		if("0".equals(queryType)){//虚拟机状态
			String stateFlag = request.getParameter("stateFlag");
			context.put("$eq_state", stateFlag);
			
		}else if("1".equals(queryType)){
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getTodayDate());
				context.put("$le_created", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_created", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_created", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getMonthFirstDay(null));
				context.put("$le_created", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_created", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_created", DateUtil.getFirstDayOfLastMonth());
			}			
			
		}else{
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			String vmName = request.getParameter("vmName");
			context.put("$ge_created", dateS);
			context.put("$le_created", dateE);
			context.put("$lk_name", vmName);
			
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			request.setAttribute("vmName", vmName);
			
			//状态
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
		
		List<?> vmList = this.cloudMdmVMService.list(context);
		context.initTotalRows(modelMap);
		modelMap.put("vmList", vmList);
		modelMap.put("userId", userId);
		
		return "product/acc_vmInfo";
	}

	/**
	 * 网络信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "netInfo")
	public String netInfo(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap, String userId) throws ValidatorException {
		
		BasicUserVo basicUser = this.basicUserService.get(userId);
		QueryContext context = new ECContext(request, modelMap, "netInfo");
		context.clearParmeters();
		context.put("$eq_account", basicUser.getUserAccount());
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> networkList = this.cloudMdmNetworkService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("networkList", networkList);
		
		return "product/acc_netInfo";
	}
	
	/**
	 * 模板信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "templateInfo")
	public String templateInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String userId) throws ValidatorException {
		
//		List<Object[]> templateList = this.cloudUserOrderService.getTemplateOrderInfo(userId);
		//页面展示价格，所以从订单表出数据。
		QueryContext context = new ECContext(request, modelMap, "templateInfo");
		context.clearParmeters();
		context.put("$eq_cloudUserOrder_basicAccount_userId", userId);
		context.put("$eq_cloudUserOrder_state", String.valueOf(Constants.VALID_STATE));
		context.put("$eq_cloudMdmProductItem_itemType", Constants.PROD_TYPE_TEMPLATE);
		context.isNotNull("resDestroyTime");
		
		List<?> templateList = this.cloudUserOrderItemService.list(context);
		modelMap.put("templateList", templateList);

		return "product/acc_templateInfo";
	}

	
	/**
	 * 卷信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "volumeInfo")
	public String volumeInfo(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap, String userId) throws ValidatorException {
		
		BasicUserVo basicUser = this.basicUserService.get(userId);
		QueryContext context = new ECContext(request, modelMap, "volumeInfo");
		context.clearParmeters();
		context.put("$eq_account", basicUser.getUserAccount());
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> volumeList = this.cloudMdmVolumeService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("volumeList", volumeList);
		
		return "product/acc_volumeInfo";
	}

	/**
	 * IP地址信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "ipInfo")
	public String ipInfo(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap, String userId) throws ValidatorException {
		
		BasicUserVo basicUser = this.basicUserService.get(userId);
		QueryContext context = new ECContext(request, modelMap, "ipInfo");
		context.clearParmeters();
		context.put("$eq_account", basicUser.getUserAccount());
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> ipList = this.cloudMdmIPService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("ipList", ipList);
		
		return "product/acc_ipInfo";
	}
	
	
	
	
	
	
	/**
	 * ISO信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "isoInfo")
	public String isoInfo(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {

		return "product/acc_isoInfo";
	}
	
	

	/**
	 * 快照信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "snapshotInfo")
	public String snapshotInfo(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {

		return "product/acc_snapshotInfo";
	}
	
	
	
	
	/**
	 * 用户编辑-账单页面初始化
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "initUserBill")
	public String initUserBill(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String userId = request.getParameter("userId");
		
		modelMap.put("userId", userId);
		return "product/user_billInfo";
	}

	/**
	 * 用户编辑-账单查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "queryBillInfo")
	public String queryBillInfo(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		String userId = request.getParameter("userId");
		QueryContext context = new ECContext(request, modelMap, "queryBillInfo");
		context.clearParmeters();
		context.put("$eq_cloudUserOrder_basicUser_userId", userId=="" ? "-1" : userId);
		//context.put("$eq_cloudUserOrder_basicUser_userId", userId);
		
		String queryType = request.getParameter("queryType");
		modelMap.put("queryType", queryType);
		if("0".equals(queryType)){
			// 1: 本月     5:本年     6:去年
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getMonthFirstDay(null));
				context.put("$le_expDate", DateUtil.getMonthLastDay(null));
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getFirstDayOfYear());
				context.put("$le_expDate", DateUtil.getLastDayOfYear());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getFirstDayOfLastYear());
				context.put("$le_expDate", DateUtil.getLastDayOfLastYear());
			}
			
		}else{
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			context.put("$ge_expDate", dateS);
			context.put("$le_expDate", dateE);
			modelMap.put("dateS", dateS);
			modelMap.put("dateE", dateE);
		}

		List<AccountExpenseItemVo> expItemList = this.accountExpenseItemService.list(context);
		Double totalExpAmount = 0D;
		for(AccountExpenseItemVo itemVo : expItemList){
			totalExpAmount += itemVo.getExpAmount();
		}
		
		modelMap.put("expItemList", expItemList);
		modelMap.put("totalExpAmount", totalExpAmount);
		modelMap.put("userId", userId);
		return "product/user_billInfo";
	}

}
