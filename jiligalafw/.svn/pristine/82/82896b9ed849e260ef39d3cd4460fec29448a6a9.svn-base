package sy.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.service.base.BasicUserServiceI;
import sy.service.product.CloudUserOrderItemServiceI;
import sy.service.product.CloudUserOrderServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 账户、用户我的订单
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/order")
@SessionAttributes("cloudUserOrderVo")
public class MyOrderController extends BaseControllerTemplate<CloudUserOrderVo> {
	
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	@Autowired
	private BasicUserServiceI basicUserService;
	
	public CloudUserOrderServiceI getCloudUserOrderService() {
		return cloudUserOrderService;
	}

	public void setCloudUserOrderService(
			CloudUserOrderServiceI cloudUserOrderService) {
		this.cloudUserOrderService = cloudUserOrderService;
	}

	public CloudUserOrderItemServiceI getCloudUserOrderItemService() {
		return cloudUserOrderItemService;
	}

	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	/**
	 * 账户、用户登录后，首页-我的订单
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "myOrder")
	public String myOrder(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap, "myOrder");
		//清理上一次查询参数
		context.clearParmeters();
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		
		String userId = this.getCurrentUser(request).getUserId();
		String userIdAndAccountIdStr = this.basicUserService.getSubUserByParentUserId(userId);
		//当前用户
		context.put("$in_cloudUserOrder_basicUser_userId", userIdAndAccountIdStr);
		
		//由于资源购买失败，订单状态为0，虚机销毁和计费过程中删除虚机订单状态也为0
		//所以用订单主表购买的资源字段非空判断该订单是否购买成功
		context.equals("cloudUserOrder_state", String.valueOf(Constants.VALID_STATE));
		
		if("0".equals(queryType)){
			//计费方式
			String billingTypeFlag = request.getParameter("billingTypeFlag");
			context.put("$eq_billingType", billingTypeFlag);
			
		}else if("1".equals(queryType)){//购买日期
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
			
		}else{//高级搜索
			
			//订单日期
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			context.put("$ge_cloudUserOrder_orderTime", dateS);
			context.put("$le_cloudUserOrder_orderTime", dateE);
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			
			String prodName = request.getParameter("prodName");
			context.put("$lk_cloudMdmProduct_prodName", prodName);
			request.setAttribute("prodName", prodName);
			
			//计费方式
			String[] billingTypeArr = request.getParameterValues("billingType");
			String billingTypeArrStr = "";
			if(billingTypeArr != null && billingTypeArr.length > 0){
				for(int i=0; i<billingTypeArr.length; i++){
					billingTypeArrStr += billingTypeArr[i] + ",";
				}
				context.put("$in_billingType", billingTypeArrStr.substring(0, billingTypeArrStr.length()-1));
				request.setAttribute("billingTypeArrStr", billingTypeArrStr.substring(0, billingTypeArrStr.length()-1));
			}
		}

		List<?> orderList = this.cloudUserOrderItemService.list(context);
		context.initTotalRows(modelMap);
		modelMap.put("list", orderList);
		
		return "product/myOrderList";
	}

	@Override
	public BasicServiceI<CloudUserOrderVo> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getViewPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
