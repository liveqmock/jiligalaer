package sy.controller.finance;

import java.util.ArrayList;
import java.util.List;

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

import sy.common.export.ExcelHandler;
import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicDictItemVo;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseItemVo;
import sy.domain.vo.expense.BillQueryParameterVo;
import sy.service.base.BasicDictItemServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.expense.AccountExpenseItemServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.finance.AccountPayServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 账户 费用清单
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/accBills")
@SessionAttributes("accountExpenseItemVo")
public class AccountBillsController extends BaseControllerTemplate<AccountExpenseItemVo> {
	
	@Autowired
	private AccountPayServiceI accountPayService;
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	@Autowired
	private AccountExpenseItemServiceI accountExpenseItemService;
	
	private ExcelHandler excelHandler;
	
	public AccountPayServiceI getAccountPayService() {
		return accountPayService;
	}

	public void setAccountPayService(AccountPayServiceI accountPayService) {
		this.accountPayService = accountPayService;
	}

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
	
	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}
	
	public AccountExpenseItemServiceI getAccountExpenseItemService() {
		return accountExpenseItemService;
	}

	public void setAccountExpenseItemService(
			AccountExpenseItemServiceI accountExpenseItemService) {
		this.accountExpenseItemService = accountExpenseItemService;
	}

	public ExcelHandler getExcelHandler() {
		return excelHandler;
	}

	public void setExcelHandler(ExcelHandler excelHandler) {
		this.excelHandler = excelHandler;
	}

	public String getViewPath() {
		return "base";
	}

	@Override
	public BasicServiceI<AccountExpenseItemVo> getService() {
		return accountExpenseItemService;
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
	 * 获取账户扣费清单
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
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
			
		}else if("4".equals(queryType)){//充值日期一键式
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getTodayDate());
				context.put("$le_expDate", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_expDate", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_expDate", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getMonthFirstDay(null));
				context.put("$le_expDate", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_expDate", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_expDate", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_expDate", DateUtil.getFirstDayOfLastMonth());
			}			
			
		}else{//高级搜索
			
			//充值日期
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			String userName = request.getParameter("userName");
			String userAccount = request.getParameter("userAccount");
			context.put("$ge_expDate", dateS);
			context.put("$le_expDate", dateE);
			context.put("$lk_basicUser.userName", userName);
			context.put("$lk_basicUser.userAccount", userAccount);
			
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			request.setAttribute("userName", userName);
			request.setAttribute("userAccount", userAccount);
			
			//账户类别
			String[] userAccountTypeArr = request.getParameterValues("userAccountType");
			String userAccountTypeStr = "";
			if(userAccountTypeArr != null && userAccountTypeArr.length > 0){
				for(int i=0; i<userAccountTypeArr.length; i++){
					userAccountTypeStr += userAccountTypeArr[i] + ",";
				}
				context.put("$in_basicUser_userIdentityDictItem_itemCode", userAccountTypeStr.substring(0, userAccountTypeStr.length()-1));
				request.setAttribute("userAccountTypeStr", userAccountTypeStr.substring(0, userAccountTypeStr.length()-1));
			}
			
			//账户类型
			String[] userIdentityArr = request.getParameterValues("userIdentity");
			String userIdentityStr = "";
			if(userIdentityArr != null && userIdentityArr.length > 0){
				for(int i=0; i<userIdentityArr.length; i++){
					userIdentityStr += userIdentityArr[i] + ",";
				}
				context.put("$in_basicUser_userTypeDictItem_itemCode", userIdentityStr.substring(0, userIdentityStr.length()-1));
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
			
		}
		
		context.setSort(" basicUser.userId, expDate ");
		
		List<AccountExpenseItemVo> list = this.accountExpenseItemService.list(context);
		
		//合并结果集
		List<AccountExpenseItemVo> expItemList = new ArrayList<AccountExpenseItemVo>();
		if(list != null && list.size()>0){
			String userId = "";
			String expDate = "";
			int i=0;
			for(AccountExpenseItemVo vo : list){
				String tUserId = vo.getBasicUser().getUserId();
				String tExpDate = DateUtil.format(vo.getExpDate(), "yyyy-MM-dd");
				if(i != 0){
					//如何账户和费用日期相同，合并费用金额
					if(tUserId.equals(userId) && tExpDate.equals(expDate)){
						AccountExpenseItemVo tVo = expItemList.get(expItemList.size()-1);
						tVo.setExpAmount(tVo.getExpAmount()+vo.getExpAmount());
						expItemList.remove(expItemList.size()-1);
						expItemList.add(tVo);
					}else{
						userId = vo.getBasicUser().getUserId();
						expDate = DateUtil.format(vo.getExpDate(), "yyyy-MM-dd");
						expItemList.add(vo);
					}
					
				}else{
					userId = vo.getBasicUser().getUserId();
					expDate = DateUtil.format(vo.getExpDate(), "yyyy-MM-dd");
					expItemList.add(vo);
				}
				i++;
			}
		}
		
		context.setTotalRowCount(expItemList.size());
		context.initTotalRows(modelMap);
		modelMap.put("list", expItemList);
	
		return "finance/accountBillsList";
	}

	
	/**
	 * 费用清单
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
//	@RequestMapping(value = "view")
	@RequestMapping(method = RequestMethod.GET, value = "view")
	public String view(HttpServletRequest request, ModelMap modelMap) 
			throws ValidatorException {
		String param = request.getParameter("param");
		String[] paramArr = param.split("_");
		String userId = paramArr[0];
		String expDate = paramArr[2];
		String expAmount = paramArr[3];
		BasicUserVo basicUser = this.basicUserService.get(userId);
		
		modelMap.put("basicUser", basicUser);
		modelMap.put("expDate", expDate);
		modelMap.put("expAmount", expAmount);
		
		return "finance/accountBillsView";
	}

	/**
	 * 费用清单详细
	 * @param request
	 * @param modelMap
	 * @param vo
	 * @param errors
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "detail")
	public String detail(HttpServletRequest request, ModelMap modelMap, String userId) throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		context.clearParmeters();
		String expDate = request.getParameter("expDate");
		context.put("$eq_basicUser_userId", userId);
		context.put("$ge_expDate", expDate);
		context.put("$le_expDate", expDate + " 23:59:59");
		List<?> expItemList = this.accountExpenseItemService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("expItemList", expItemList);
		modelMap.put("userId", userId);
		modelMap.put("expDate", expDate);
		
		return "finance/accountBillsDetail";
	}

	/**
	 * 财务管理 - 账户扣费账单 - 费用明细 - 详细信息导出（改成用ectable导出）
	 * @param request
	 * @param modelMap
	 * @param userId
	 * @param response
	 * @return
	 * @throws ValidatorException
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "exportExcel")
	public String exportExcel(HttpServletRequest request, ModelMap modelMap, String userId, HttpServletResponse response) throws ValidatorException {
		response.setContentType("application/excel");
		response.setHeader("Content-disposition", "attachment; filename=expense.xls");
		try {
			QueryContext context = new ECContext(request, modelMap, getNameSpace());
			context.clearParmeters();
			String expDate = request.getParameter("expDate");
			context.put("$eq_basicUser_userId", userId);
			context.put("$eq_expDate", expDate);
			List<AccountExpenseItemVo> expItemList = this.accountExpenseItemService.list(context);
			
			String[] title = {"序号","扣费日期","扣费金额","计费类型","计费周期"};
			List<Object[]> list = new ArrayList<Object[]>();
			int i=1;
			for(AccountExpenseItemVo vo : expItemList){
				Object[] obj = new Object[5];
				obj[0]=i++;
				obj[1]=DateUtil.format(vo.getExpDate(), "yyyy-MM-dd");
				obj[2]=vo.getExpAmount();
				obj[3]=Constants.BILLING_TYPE_SINGLE.equals(vo.getBillingType()) ? "一次性" : "周期性";
				String billingCycle = "";
				if(Constants.BILLING_CYCLE_YEAR.equals(vo.getCloudUserOrder().getBillingCycle())){
					billingCycle= "年收费";
				}else if(Constants.BILLING_CYCLE_MONTH.equals(vo.getCloudUserOrder().getBillingCycle())){
					billingCycle= "月收费";
				}else{
					billingCycle= "日收费";
				}
				obj[4]=billingCycle;
				list.add(obj);
			}
			
			excelHandler.excelDownLoad(response.getOutputStream(),title,list);
			
		} catch (Exception e) {
			
		}
		return null;
	}
	

	/**
	 * 我的账单 - 账单 - 账单详细导出
	 * @param modelMap
	 * @param vo
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "exportBills")
	public String exportBills(HttpServletRequest request, ModelMap modelMap, @Valid AccountExpenseItemVo vo, BindingResult errors) throws ValidatorException{
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		context.clearParmeters();
		//日期
		String expDate = request.getParameter("expDate");
		context.put("$le_expDate", expDate+" 23:59:59");
		context.put("$ge_expDate", expDate);
		//管理员、账户、用户 不同数据范围
		BasicUserVo basicUser = this.getCurrentUser(request);
		if (basicUser.getUserFlag().equals(Constants.USER_FLAG_ACCOUNT)) {
			context.put("$eq_cloudUserOrder.basicAccount.userId", basicUser.getUserId());
		} if (basicUser.getUserFlag().equals(Constants.USER_FLAG_USER)) {
			context.put("$eq_cloudUserOrder.basicUser.userId", basicUser.getUserId());
		}
		List<AccountExpenseItemVo> expItemList = this.accountExpenseItemService.list(context);
		afterQueryList(request, expItemList, context, modelMap);
		request.setAttribute("expDate", expDate);
		
		BillQueryParameterVo billQueryParameterVo = new BillQueryParameterVo();
		billQueryParameterVo.setBasicUserVo(basicUser);
		billQueryParameterVo.setExpDateStart(expDate );
		billQueryParameterVo.setExpDateEnd(expDate + " 23:59:59");
		
		request.setAttribute("expAmountTotal", this.accountExpenseItemService.getExpenseAmoutTotal(billQueryParameterVo));
		
		return "finance/exportBillsDetail";
	}
}
