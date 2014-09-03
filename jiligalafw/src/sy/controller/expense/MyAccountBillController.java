package sy.controller.expense;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.base.BasicHelper;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.model.base.BasicUser;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountBilllVo;
import sy.domain.vo.expense.AccountExpenseItemVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.expense.BillQueryParameterVo;
import sy.domain.vo.expense.MonthBillTotalVo;
import sy.service.base.BasicUserServiceI;
import sy.service.expense.AccountExpenseItemServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 账户、用户我的本期账单
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/bill")
@SessionAttributes("accountExpenseItemVo")
public class MyAccountBillController extends
		BaseControllerTemplate<AccountExpenseItemVo> {

	private static final Logger log = Logger
			.getLogger(MyAccountBillController.class);
	
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	@Autowired
	private AccountExpenseItemServiceI accountExpenseItemService;

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

	public AccountExpenseItemServiceI getAccountExpenseItemService() {
		return accountExpenseItemService;
	}

	public void setAccountExpenseItemService(
			AccountExpenseItemServiceI accountExpenseItemService) {
		this.accountExpenseItemService = accountExpenseItemService;
	}

	@Override
	public BasicServiceI<AccountExpenseItemVo> getService() {
		return null;
	}

	@Override
	public String getViewPath() {
		return null;
	}

	/**
	 * 账户、用户登录后，首页-我的本期账单
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "myBill")
	public String myBill(HttpServletRequest request,
			HttpServletResponse response, AccountBilllVo vo, ModelMap modelMap)
			throws ValidatorException {
		BasicUserVo basicUser = this.getCurrentUser(request);
		BillQueryParameterVo billQueryParameterVo = new BillQueryParameterVo();
		billQueryParameterVo.setBasicUserVo(basicUser);
		
		//初始化导航月份
		ArrayList<MonthBillTotalVo> monthList = new ArrayList<MonthBillTotalVo>();
		Calendar cal =Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH);
		
		for (int i = 5 ; i >= 0 ; i--) {
			
			MonthBillTotalVo billTotal = new MonthBillTotalVo();
			String firstDay = DateUtil.getFirstDayOfMonth(year,month+1);
			String lastDay = DateUtil.getLastDayOfMonth(year,month+1);
			String monthTitle = firstDay.substring(0,4)+"年" +firstDay.substring(5,7) + "月";
			billTotal.setMonthTitle(monthTitle);
			billTotal.setMonth(lastDay);
			
			BillQueryParameterVo billQeryVo = new BillQueryParameterVo();
			billQeryVo.setBasicUserVo(basicUser);
			billQeryVo.setExpDateStart(firstDay );
			billQeryVo.setExpDateEnd(lastDay + " 23:59:59");
			billTotal.setBillTotal(this.accountExpenseItemService.getExpenseAmoutTotal(billQeryVo));
			
			monthList.add(billTotal);
			
			if (month == 0 ) {
				month = 11 ;
				year = year -1;
			} else {
				month = month-1;
			}
		}
		
		request.setAttribute("monthList", monthList);
		
		//end 导航月份初始化
		
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);

		year = cal.get(Calendar.YEAR);
		if ("0".equals(queryType)) {
			// 1: 本月 2:本年 3:去年
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)) {
				billQueryParameterVo.setExpDateStart(DateUtil.getMonthFirstDay(null));
				billQueryParameterVo.setExpDateEnd( DateUtil.getMonthLastDay(null));
			} else if ("2".equals(timeFlag)) {
				billQueryParameterVo.setExpDateStart(String.valueOf(year) + "-01" + "-01");
				billQueryParameterVo.setExpDateEnd(String.valueOf(year) + "-12" + "-31");
			} else if ("3".equals(timeFlag)) {
				year = year - 1;
				billQueryParameterVo.setExpDateStart(String.valueOf(year) + "-01" + "-01");
				billQueryParameterVo.setExpDateEnd(String.valueOf(year) + "-12" + "-31");
			}

		} else if ("2".equals(queryType)) {
			//导航月份查询
			String monthDate =request.getParameter("monthDate");
			billQueryParameterVo.setExpDateStart(monthDate.substring(0,7)+"-01");
			billQueryParameterVo.setExpDateEnd(monthDate);
			request.setAttribute("monthDate", monthDate);
		} else {
			// 高级搜索
			// 费用日期
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			billQueryParameterVo.setExpDateStart(dateS);
			billQueryParameterVo.setExpDateEnd(dateE);
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
		}

		List<Object[]> expList = this.accountExpenseItemService.getAccountExpenseTotalList(billQueryParameterVo);
		
		// 处理结果列表
		request.setAttribute("expList", expList);
		request.setAttribute("expTotal", calculateTotal(expList));
		modelMap.put("userFlag", basicUser.getUserFlag());

		AccountExpenseVo expVo = this.accountExpenseService
				.getExpenseByUserId(basicUser.getUserId());
		modelMap.put("expVo", expVo);

		return "expense/myAccountBillList";
	}

	/**手动触发计费逻辑.要求当前登录用户为admin*/
	@RequestMapping(value = "manualBilling")
	public String manualBilling(HttpServletRequest request,
			HttpServletResponse response) throws ValidatorException {
		BasicUserVo user = BasicHelper.getCurrentUser(request);
		if ("admin".equals(user.getUserAccount())) {
			log.info("手动出发计费[开始].");
			accountExpenseService.billing();
			log.info("手动出发计费[结束].");
		} else {
			log.warn(user.getUserAccount() + "没有手动触发计费的权限.");
		}
		return null;
	}
	
	private Double calculateTotal(List<Object[]> expList) {
		Double total = 0D;
		for(Object[] objArray : expList) {
			total = total + ((Double)objArray[1]);
		}
		return total;
	}

}
