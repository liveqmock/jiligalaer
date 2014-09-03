package sy.controller.finance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountPayVo;
import sy.service.base.BasicDictItemServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.finance.AccountPayServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 账户在线充值
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/onlinePay")
@SessionAttributes("accountPayVo")
public class OnlinePayController extends BaseControllerTemplate<AccountPayVo> {
	
	@Autowired
	private AccountPayServiceI accountPayService;
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	
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

	public String getViewPath() {
		return "finance";
	}

	@Override
	public BasicServiceI<AccountPayVo> getService() {
		return accountPayService;
	}
	
	
	
	@Override
	protected void initContextParams(HttpServletRequest request,
			QueryContext context) {
		super.initContextParams(request, context);
	}


	/**
	 * 获取账户充值列表信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		context.clearParmeters();
		//默认查询当前用户的退款申请记录
		BasicUserVo basicUser = this.getCurrentUser(request);
		context.put("$eq_basicUser_userId", basicUser.getUserId());
		
		//清理上一次查询参数
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		
		if("0".equals(queryType)){//充值方式一键式
			String payFlag = request.getParameter("payFlag");
			context.put("$eq_payType", payFlag);
			
		}else if("1".equals(queryType)){//充值日期一键式
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_payDate", DateUtil.getTodayDate());
				context.put("$le_payDate", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_payDate", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_payDate", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_payDate", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_payDate", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_payDate", DateUtil.getMonthFirstDay(null));
				context.put("$le_payDate", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_payDate", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_payDate", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_payDate", DateUtil.getFirstDayOfLastMonth());
			}			
			
		}else{//高级搜索
			
			//充值日期
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			context.put("$ge_payDate", dateS);
			context.put("$le_payDate", dateE);
			
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			
			//充值方式
			String[] payTypeArr = request.getParameterValues("payType");
			String payTypeStr = "";
			if(payTypeArr != null && payTypeArr.length > 0){
				for(int i=0; i<payTypeArr.length; i++){
					payTypeStr += payTypeArr[i] + ",";
				}
				context.put("$in_payType", payTypeStr.substring(0, payTypeStr.length()-1));
				request.setAttribute("payTypeStr", payTypeStr.substring(0, payTypeStr.length()-1));
			}
		}
		
		List<?> payList = getAccountPayService().list(context);
		context.initTotalRows(modelMap);
		modelMap.put("list", payList);
	
		AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(basicUser.getUserId());
		modelMap.put("expVo", expVo);
		
		return "finance/onlinePayList";
	}

	/**
	 * 银联在线充值 -- 发送请求
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "unionpay")
	public String unionpay(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		
		return "finance/onlinePayList";
	}

	/**
	 * 支付宝 在线充值 -- 发送请求
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "alipay")
	public String alipay(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		
		return "finance/onlinePayList";
	}

}
