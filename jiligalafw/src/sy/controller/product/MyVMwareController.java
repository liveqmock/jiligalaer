package sy.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.product.CloudMdmIPVo;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.domain.vo.product.CloudProductPriceVo;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.domain.vo.promotion.CloudPromotionValue;
import sy.service.base.BasicUserServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkServiceI;
import sy.service.product.CloudMdmNetworkSolnServiceI;
import sy.service.product.CloudMdmNicServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmVolumeServiceI;
import sy.service.product.CloudMdmZoneServiceI;
import sy.service.product.CloudProductPriceServiceI;
import sy.service.product.CloudUserOrderItemServiceI;
import sy.service.product.CloudUserOrderServiceI;
import sy.service.promotion.CloudPromotionProductServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 我的资源 - 我的虚拟机
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/myVm")
@SessionAttributes("cloudMdmVmVo")
public class MyVMwareController extends BaseControllerTemplate<CloudMdmVmVo> {

	//产品基础数据
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	@Autowired
	private CloudMdmZoneServiceI cloudMdmZoneService;
	@Autowired
	private CloudMdmNetworkServiceI cloudMdmNetworkService;
	@Autowired
	private CloudMdmIPServiceI cloudMdmIPService;
	@Autowired
	private CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService;
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private CloudMdmNicServiceI cloudMdmNicService;
	@Autowired
	private CloudMdmVolumeServiceI cloudMdmVolumeService;
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;
	@Autowired
	private CloudPromotionProductServiceI cloudPromotionProductService;
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	
	public CloudMdmVMServiceI getCloudMdmVMService() {
		return cloudMdmVMService;
	}

	public void setCloudMdmVMService(CloudMdmVMServiceI cloudMdmVMService) {
		this.cloudMdmVMService = cloudMdmVMService;
	}

	public CloudMdmZoneServiceI getCloudMdmZoneService() {
		return cloudMdmZoneService;
	}

	public void setCloudMdmZoneService(CloudMdmZoneServiceI cloudMdmZoneService) {
		this.cloudMdmZoneService = cloudMdmZoneService;
	}

	public CloudMdmNetworkServiceI getCloudMdmNetworkService() {
		return cloudMdmNetworkService;
	}

	public void setCloudMdmNetworkService(
			CloudMdmNetworkServiceI cloudMdmNetworkService) {
		this.cloudMdmNetworkService = cloudMdmNetworkService;
	}

	public CloudMdmIPServiceI getCloudMdmIPService() {
		return cloudMdmIPService;
	}

	public void setCloudMdmIPService(CloudMdmIPServiceI cloudMdmIPService) {
		this.cloudMdmIPService = cloudMdmIPService;
	}

	public CloudMdmNetworkSolnServiceI getCloudMdmNetworkSolnService() {
		return cloudMdmNetworkSolnService;
	}

	public void setCloudMdmNetworkSolnService(
			CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService) {
		this.cloudMdmNetworkSolnService = cloudMdmNetworkSolnService;
	}
	
	public CloudUserOrderServiceI getCloudUserOrderService() {
		return cloudUserOrderService;
	}

	public void setCloudUserOrderService(
			CloudUserOrderServiceI cloudUserOrderService) {
		this.cloudUserOrderService = cloudUserOrderService;
	}

	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}
	
	public CloudMdmNicServiceI getCloudMdmNicService() {
		return cloudMdmNicService;
	}

	public void setCloudMdmNicService(CloudMdmNicServiceI cloudMdmNicService) {
		this.cloudMdmNicService = cloudMdmNicService;
	}

	public CloudMdmVolumeServiceI getCloudMdmVolumeService() {
		return cloudMdmVolumeService;
	}

	public void setCloudMdmVolumeService(
			CloudMdmVolumeServiceI cloudMdmVolumeService) {
		this.cloudMdmVolumeService = cloudMdmVolumeService;
	}

	public CloudUserOrderItemServiceI getCloudUserOrderItemService() {
		return cloudUserOrderItemService;
	}

	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}

	public CloudProductPriceServiceI getCloudProductPriceService() {
		return cloudProductPriceService;
	}

	public void setCloudProductPriceService(
			CloudProductPriceServiceI cloudProductPriceService) {
		this.cloudProductPriceService = cloudProductPriceService;
	}
	
	public CloudPromotionProductServiceI getCloudPromotionProductService() {
		return cloudPromotionProductService;
	}

	public void setCloudPromotionProductService(
			CloudPromotionProductServiceI cloudPromotionProductService) {
		this.cloudPromotionProductService = cloudPromotionProductService;
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

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}

	@Override
	public BasicServiceI<CloudMdmVmVo> getService() {
		return cloudMdmVMService;
	}
	
	public String getViewPath() {
		return "myresources";
	}
	
	/**
	 * 我虚拟机主页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {

		BasicUserVo basicUser = this.getCurrentUser(request);
		QueryContext context = new ECContext(request, modelMap, "myVmList");
		context.clearParmeters();
		String keyword = request.getParameter("keyword");
		context.put("$lk_vmName", keyword);
		//订单表状态
		context.put("$eq_state", String.valueOf(Constants.VALID_STATE));
		//虚拟机表状态
		context.put("$eq_cloudMdmVm_dataState", String.valueOf(Constants.VALID_STATE));
		context.put("$ne_state", Constants.VM_STATE_DESTROYED);
		//不属于IP、网络、磁盘产品购买
		context.put("$ne_buyType", Constants.PROD_BUY_SINGLE);
		//账户查看自己及下属用户的，用户查看自己的
		if(basicUser.getUserFlag() == Constants.USER_FLAG_USER){
			//用户
			context.put("$eq_basicUser_userId", basicUser.getUserId());
		}else{
			//账户
			String userStr = basicUser.getUserId() + ",";
			try {
				List<BasicUserVo> userList = this.basicUserService.getBaiscUserVoListByParentBaiscUserVo(basicUser);
				if(userList != null && userList.size() > 0){
					for(BasicUserVo vo : userList){
						userStr += vo.getUserId() + ",";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			context.put("$in_basicUser_userId", userStr.substring(0, userStr.length()-1));
		}
		
		List<?> myVmList = this.cloudUserOrderService.list(context);
		
		context.initTotalRows(modelMap);
		modelMap.put("myVmList", myVmList);
		modelMap.put("keyword", keyword);
		
		return "myresources/myVmwareList";
	}

	/**
	 * 我的虚拟机 - 启动
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vmStart")
	public String vmStart(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String interfaceId = request.getParameter("interfaceId");
		String vmId = request.getParameter("vmId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					this.cloudMdmVMService.startup(interfaceId);
					
					CloudMdmVmVo vmVo = this.cloudMdmVMService.get(vmId);
					response.getWriter().println("虚拟机启动成功"+"@"+vmVo.getState());
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 我的虚拟机 - 停止
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vmStop")
	public String vmStop(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String interfaceId = request.getParameter("interfaceId");
		String vmId = request.getParameter("vmId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					this.cloudMdmVMService.stop(interfaceId, false);
					
					CloudMdmVmVo vmVo = this.cloudMdmVMService.get(vmId);
					response.getWriter().println("虚拟机成功停止"+"@"+vmVo.getState());
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 我的虚拟机 - 重启
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vmRestart")
	public String vmRestart(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String interfaceId = request.getParameter("interfaceId");
		String vmId = request.getParameter("vmId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					this.cloudMdmVMService.reboot(interfaceId);
					
					CloudMdmVmVo vmVo = this.cloudMdmVMService.get(vmId);
					response.getWriter().println("虚拟机重启成功"+"@"+vmVo.getState());
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 我的虚拟机 - 销毁
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vmDestroy")
	public String vmDestroy(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String interfaceId = request.getParameter("interfaceId");
		String vmId = request.getParameter("vmId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					this.cloudMdmVMService.destroy(interfaceId);
					
					//修改订单状态、设置资源销毁时间
					this.cloudUserOrderService.destroyVmOrder(vmId);
					
					CloudMdmVmVo vmVo = this.cloudMdmVMService.get(vmId);
					response.getWriter().println("虚拟机成功销毁"+"@"+vmVo.getState());
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 我的虚拟机 - 密码重置
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "changePassword")
	public String changePassword(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String interfaceId = request.getParameter("interfaceId");
		String vmId = request.getParameter("vmId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					//虚拟机必须停止，并且该虚拟机使用的模板必须支持重置命令
					this.cloudMdmVMService.resetPassword(interfaceId);
					
					CloudMdmVmVo vmVo = this.cloudMdmVMService.get(vmId);
					response.getWriter().println("密码重置成功"+"@"+vmVo.getState());
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 我的虚拟机 - 虚机重置
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vmReset")
	public String vmReset(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String interfaceId = request.getParameter("interfaceId");
		String vmId = request.getParameter("vmId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					this.cloudMdmVMService.restore(interfaceId);
					
					CloudMdmVmVo vmVo = this.cloudMdmVMService.get(vmId);
					response.getWriter().println("虚拟机重置成功"+"@"+vmVo.getState());
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 我的虚拟机 - 申请IP地址
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "applyIP")
	public String applyIP(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		//String interfaceId = request.getParameter("interfaceId");
		//String vmId = request.getParameter("vmId");
		String orderId = request.getParameter("orderId");
		
		response.setCharacterEncoding("UTF-8");
		try {
			try{
				try{
					//获取该虚机的第一个网络
					CloudUserOrderVo oVo = this.cloudUserOrderService.get(orderId);
					String networkId = oVo.getNetIds().split(",")[0];
					
					BasicUserVo basicUser = this.getCurrentUser(request);

					//查询IP定价信息（单一产品IP，系统初始化数据）
					CloudMdmProductItemVo prodItemVo = this.cloudMdmProductItemService.get(Constants.IP_PRODUCT_ID);
					CloudProductPriceVo priceVo = this.cloudProductPriceService.getPriceByProdId(prodItemVo.getMdmProduct().getId());
					
					//查找该虚机购买时的收费方式
					String billingCycle = oVo.getBillingCycle();
					boolean buyFlag = false;
					Double price = 0d;
					String billingType = Constants.BILLING_TYPE_CYCLE;
					if(null == billingCycle || Integer.parseInt(billingCycle) < 1){
						//验证IP是否有一次性收费定价
						if(!Constants.PRICE_MODE_ONE_TIME.equals(priceVo.getPriceMode())){
							buyFlag = true;
						}
						price = priceVo.getOneTimePrice();
						billingType = Constants.BILLING_TYPE_SINGLE;
					}else{
						//验证IP是否有周期性收费定价
						if(!Constants.PRICE_MODE_CYCLE.equals(priceVo.getPriceMode())){
							buyFlag = true;
						}
						if(Constants.BILLING_CYCLE_YEAR.equals(billingCycle)){
							price = priceVo.getYearPrice();
						}else if(Constants.BILLING_CYCLE_MONTH.equals(billingCycle)){
							price = priceVo.getMonthPrice();
						}else if(Constants.BILLING_CYCLE_DAY.equals(billingCycle)){
							price = priceVo.getDayPrice();
						}else{
							price = priceVo.getHourPrice();
						}
					}
					if(buyFlag){
						response.getWriter().println("IP申请失败，未找到和该虚拟机相同的计费方式。");
						return null;
					}
					
					
					//主订单信息
					CloudUserOrderVo orderVo = new CloudUserOrderVo();
					orderVo.setBasicUser(basicUser);
					orderVo.setOrderTime(new Date());
					orderVo.setBuyType(Constants.PROD_BUY_SINGLE);
					//计费周期
					orderVo.setBillingCycle(billingCycle);
					//获取产品促销价格
					CloudPromotionValue promo = cloudPromotionProductService.getDiscountAmountByProdId(prodItemVo.getMdmProduct().getId(), priceVo.getDayPrice());
					//计费状态
					orderVo.setBillingFlag(Constants.BILLING_FALG_STOP);
					orderVo.setState(String.valueOf(Constants.INVALID_STATE));
					orderVo.setCreated(new Date());
					orderVo.setCreatedBy(basicUser.getUserAccount());
					orderVo.setCreateId(this.getCurrentUser(request).getUserId());
					orderVo.setOrderType(Constants.ORDER_TYPE_IP);
					
					//子订单信息
					CloudUserOrderItemVo itemVo = new CloudUserOrderItemVo();
					itemVo.setCloudUserOrder(orderVo);
					itemVo.setCloudMdmProduct(prodItemVo.getMdmProduct());
					itemVo.setCloudMdmProductItem(prodItemVo);
					itemVo.setProdType(Constants.PROD_TYPE_IP);
					//是否开始计费
					itemVo.setBillingFlag(Constants.BILLING_FALG_STOP);
					//一次性计费是否已发生（如果是周期性的本不用填写，填写了也没用影响）
					itemVo.setOneTimeBillingFlag(Constants.BILLING_FALG_STOP);
					//计费类型
					itemVo.setBillingType(billingType);
//					//开始计费时间=明天凌晨
//					itemVo.setBeginBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
//					//计费调度时填写
//					itemVo.setNextBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
					//计费调度时、虚拟机销毁时、删除IP或者网络是填写
					//itemVo.setResDestroyTime(resDestroyTime)
					if(promo != null){
						itemVo.setPromotionId(promo.getPromotionId());
						itemVo.setRebateAmount(promo.getRebateAmount());
						itemVo.setRebateFlag(promo.getRebateFlag());
					}
					
					//购买时账户费用不足，购买失败。
					AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(basicUser.getUserId());
					if(expVo == null || (expVo.getPayTotalAmount()- expVo.getExpTotalAmount()) < Double.valueOf(priceVo.getDayPrice())){
						response.getWriter().println("IP申请失败，账户费用不足，请充值。");
						return null;
					}
					
					//保存订单
					this.cloudUserOrderService.saveOrder(orderVo, itemVo);

					//调用申请IP接口
					CloudMdmIPVo ipVo = this.cloudMdmIPService.associateIpAddress(basicUser.getUserAccount(), networkId);
					
					
					//如果是原NAT类型IP，暂定不用收费
					orderVo.setCloudMdmIP(ipVo);
					if("false".equals(ipVo.getIssourcenat())){
						//修改计费、订单状态
						orderVo.setBillingFlag(Constants.BILLING_FALG_START);
						orderVo.setState(String.valueOf(Constants.VALID_STATE));
						itemVo.setBillingFlag(Constants.BILLING_FALG_START);
						this.cloudUserOrderService.saveOrder(orderVo,itemVo);
						
						//立即计费调用
						this.accountExpenseService.billing();
						
						response.getWriter().println("IP申请成功，已开始计费，" + orderVo.getCycleName() + price + "元。");
						return null;
					}else{
						//修改订单状态
						orderVo.setState(String.valueOf(Constants.VALID_STATE));
						this.cloudUserOrderService.save(orderVo);
						response.getWriter().println("IP申请成功。");
						return null;
					}

					//response.getWriter().println("IP申请成功，已开始计费，" + orderVo.getCycleName() + price + "元。");
					
				}catch (ValidatorException e){
					response.getWriter().println("失败："+e.getMessage());
				}
			}catch (CloudException e){
				e.printStackTrace();
				response.getWriter().println("失败："+e.getMessage());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 我的虚拟机 - 附加ISO
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "addIso")
	public String addIso(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {

		return "myresources/myVmware_detail";
	}
	
	/**
	 * 我的虚拟机 - 查看控制台
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "viewConsole")
	public String viewConsole(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {

		return "myresources/myVmware_detail";
	}

	
	
	
	/**
	 * 我的虚拟机 - 详细信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "detail")
	public String detail(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		String vmId = request.getParameter("vmId");
		String orderId = request.getParameter("orderId");
		CloudMdmVmVo vmVo = this.cloudMdmVMService.getVmById(vmId);
		CloudUserOrderVo orderVo = this.cloudUserOrderService.get(orderId);
		
		modelMap.put("vmVo", vmVo);
		modelMap.put("orderVo", orderVo);
		return "myresources/myVmware_detail";
	}
	
	/**
	 * 我的虚拟机 - nic
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "nic")
	public String nic(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		String interfaceId = request.getParameter("interfaceId");
		QueryContext context = new ECContext(request, modelMap, "nicList");
		context.clearParmeters();
		//如果interfaceId为""会把所有虚拟机的nic查询出来
		context.put("$eq_virtualmachineId", "".equals(interfaceId) ? "-1" : interfaceId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		
		List<?> nicList = this.cloudMdmNicService.list(context);
		
		modelMap.put("nicList", nicList);
		return "myresources/myVmware_nic";
	}

	/**
	 * 我的虚拟机 - 卷
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "volume")
	public String volume(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		String interfaceId = request.getParameter("interfaceId");
		QueryContext context = new ECContext(request, modelMap, "volumeList");
		context.clearParmeters();
		context.put("$eq_virtualmachineid", "".equals(interfaceId) ? "-1" : interfaceId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		
		List<?> volumeList = this.cloudMdmVolumeService.list(context);
		
		modelMap.put("volumeList", volumeList);
		return "myresources/myVmware_volume";
	}

	/**
	 * 我的虚拟机 - 统计数据
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "statistic")
	public String statistic(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		String vmId = request.getParameter("vmId");
		CloudMdmVmVo vmVo = this.cloudMdmVMService.getVmById(vmId);
		
		modelMap.put("vmVo", vmVo);
		return "myresources/myVmware_statistic";
	}


	
	
	/**
	 * 我的虚拟机 - 更改计算资源
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "compResource")
	public String compResource(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		//计算方案更改，必须停机
		//自定义购买的虚拟机：更换计算方案时，销毁原虚拟机计算方案，增加新的计算方案订单，挂在该虚拟机上。
		//快速购买的虚拟机：更换计算方案时，直接增加新的计算方案订单（收取2份计算方案的费用），挂在该虚拟机上。
		
		//订单主表信息
		String orderId = request.getParameter("orderId");
		CloudUserOrderVo orderVo = this.cloudUserOrderService.get(orderId);
		
		//查找与该虚拟机相同计费方式的计算资源
		//在自定义购买时，虚机组成的元素计费类型可能不同，会存在一次性和周期性计费，
		//所以在更换配置方案时，必须知道这个元素是按照什么方式计费的，
		//在提供更换配置方案列表时，以此相同计费方式的产品定价展示供用户选择。
		
		String priceMode = Constants.PRICE_MODE_CYCLE;
		modelMap.put("billingCycle", orderVo.getBillingCycle());
		if(null == orderVo.getBillingCycle() || Constants.BILLING_TYPE_SINGLE.equals(orderVo.getBillingCycle())){
			priceMode = Constants.PRICE_MODE_ONE_TIME;
			modelMap.put("billingCycle", Constants.BILLING_TYPE_SINGLE);
		}
		
		
		//根据订单的计费类型和计费周期，查找相同计费类型和计费周期的产品定价信息（单独创建磁盘定价，可以忽略）
		QueryContext pc = new ECContext(request, modelMap, "priceList");
		pc.clearParmeters();
		pc.put("$le_effectiveDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
		pc.put("$ge_invalidDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
		pc.put("$eq_priceMode", priceMode);
		pc.put("$eq_cloudMdmProductItem_itemType", Constants.PROD_TYPE_CPU_SOLN);
		
		List<?> priceList = this.cloudProductPriceService.list(pc);
		
		modelMap.put("orderId", orderId);
		modelMap.put("priceList", priceList);
		return "myresources/changeService_computResource";
	}
	
	/**
	 * 我的虚拟机 - 计算资源更改保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "changeCpu")
	public String changeCpu(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		//自定义购买：由于更改计算方案会创建新的订单挂在该虚拟机上，如果多次更换计算方案后，会存在多个计算方案的订单，只有一个有效的订单。
		//快速购买：由于更改计算方案会创建新的订单挂在该虚拟机上，原计算方案不用管理（打包的产品），如果多次更换计算方案后，会存在多个计算方案的订单，只有一个有效的订单。
		
		String billingCycle = request.getParameter("billingCycle");
		String prodId = request.getParameter("prodId");
		String priceId = request.getParameter("priceId");
		String prodItemId = request.getParameter("prodItemId");
		String orderId = request.getParameter("orderId");

		//订单主表信息
		CloudUserOrderVo orderVo = new CloudUserOrderVo(); 
		//订单子表
		CloudUserOrderItemVo newItemVo = new CloudUserOrderItemVo();
		try{
			try {
				//该订单所在的虚拟机
				vo = this.cloudUserOrderService.get(orderId);
				String vmInterfaceId = vo.getCloudMdmVm().getInterfaceId();
				
				//新选择的计算方案产品
				CloudMdmProductItemVo prodItemVo = this.cloudMdmProductItemService.get(prodItemId);
				
				//更换的新元素价格
				CloudProductPriceVo priceVo = this.cloudProductPriceService.get(priceId);
				
				//待销毁被替换的子订单元素信息
				//快速购买的虚机，第一次更换方案时订单表没有和该虚机相关联的计算方案订单
				CloudUserOrderItemVo oldItemVo =
					this.cloudUserOrderItemService.getOrderItemByVmIdAndProdType(vo.getCloudMdmVm().getId(), Constants.PROD_TYPE_CPU_SOLN);
				String oldOrderId = null;
				if(oldItemVo != null){
					if(oldItemVo.getCloudMdmProductItem().getId().equals(prodItemId)){
						modelMap.put("cpuChangeMsg", "您选择的计算方案和本虚拟机计算方案一致。");
						modelMap.put("priceList", new ArrayList<Object>());
						return "myresources/changeService_computResource";
					}
					
					//被替换的计算方案子订单信息(如果该虚拟机为自定义购买)
					//if(Constants.PROD_BUY_CUSTOM.equals(vo.getBuyType())){
					oldItemVo.setResDestroyTime(new Date());
					oldOrderId = oldItemVo.getOrderItemId();
				}

				
				Double newProdPrice = 0d;
				if(billingCycle.equals(Constants.BILLING_TYPE_SINGLE)){
					newProdPrice = priceVo.getOneTimePrice();
				}else if(billingCycle.equals(Constants.BILLING_CYCLE_YEAR)){
					newProdPrice = priceVo.getYearPrice();
				}else if(billingCycle.equals(Constants.BILLING_CYCLE_MONTH)){
					newProdPrice = priceVo.getMonthPrice();
				}else if(billingCycle.equals(Constants.BILLING_CYCLE_DAY)){
					newProdPrice = priceVo.getDayPrice();
				}else{
					newProdPrice = priceVo.getHourPrice();
				}
				//产品促销信息
				CloudPromotionValue promo = cloudPromotionProductService.getDiscountAmountByProdId(prodId, newProdPrice);

				
				//订单主表
				BasicUserVo basicUser = this.getCurrentUser(request);
				BasicUserVo basicAccount = basicUser.getUserFlag()==Constants.USER_FLAG_ACCOUNT ? basicUser : basicUser.getParentBasicUser();
				orderVo.setBasicUser(basicUser);
				orderVo.setBasicAccount(basicAccount);
				orderVo.setOrderTime(new Date());
				orderVo.setBuyType(Constants.PROD_BUY_SINGLE);
				//是否开始计费
				orderVo.setBillingFlag(Constants.BILLING_FALG_STOP);
				//计费周期：不属于一次性计费的才写值
				if(!billingCycle.equals(Constants.BILLING_TYPE_SINGLE)){
					orderVo.setBillingCycle(billingCycle);
				}
				orderVo.setState(String.valueOf(Constants.INVALID_STATE));
				orderVo.setCreated(new Date());
				orderVo.setCreatedBy(basicUser.getUserAccount());
				orderVo.setCreateId(this.getCurrentUser(request).getUserId());
				orderVo.setOrderType(Constants.ORDER_TYPE_CPU);
				orderVo.setCloudMdmVm(vo.getCloudMdmVm());//计算方案所在的虚拟机
				orderVo.setRemark(vo.getOrderId());

				//订单子表
				newItemVo.setCloudUserOrder(orderVo);
				newItemVo.setCloudMdmProduct(this.cloudMdmProductService.get(prodId));
				newItemVo.setCloudMdmProductItem(prodItemVo);
				newItemVo.setProdType(Constants.PROD_TYPE_CPU_SOLN);
				//是否开始计费，变更成功后修改这个状态
				newItemVo.setBillingFlag(Constants.BILLING_FALG_STOP);
				//一次性计费是否已发生，2013-11-10和冬播确认，不管是一次性还是周期性，都填写未开始
				newItemVo.setOneTimeBillingFlag(Constants.BILLING_FALG_STOP);
				
				//计费类型
				if(Constants.BILLING_TYPE_SINGLE.equals(billingCycle)){
					//一次性计费，如果已经收费，用了几个月后，更换方案，会再次收费。
					newItemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
				}else{
					//周期性计费，如果是按年收费，并且已经收费，到了3月份更换方案，如何收费？目前处理方式：再次收费，因为创建了独立的订单。
					newItemVo.setBillingType(Constants.BILLING_TYPE_CYCLE);
				}
				if(promo != null){
					newItemVo.setPromotionId(promo.getPromotionId());
					newItemVo.setRebateAmount(promo.getRebateAmount());
					newItemVo.setRebateFlag(promo.getRebateFlag());
				}
				newItemVo.setRemark(oldOrderId);
				
				//订单变更保存，先保存主订单和子订单，修改该虚拟机原计算方案元素销毁时间放到接口调用成功后
				//this.cloudUserOrderService.savePordChange(orderVo, oldItemVo, newItemVo, "add");
				this.cloudUserOrderService.savePordChange(orderVo, null, newItemVo);
				
				
				//调用变更接口
				this.cloudMdmVMService.changeService(vmInterfaceId, prodItemVo.getMdmCpuSoln().getInterfaceId());
				
				
				//变更成功后：修改订单主表订单和计费状态
				orderVo.setBillingFlag(Constants.BILLING_FALG_START);
				orderVo.setState(String.valueOf(Constants.VALID_STATE));
				//变更成功后：修改子订单计费状态
				newItemVo.setBillingFlag(Constants.BILLING_FALG_START);
				
				//修改该虚拟机原计算方案元素销毁时间
				this.cloudUserOrderService.savePordChange(orderVo, oldItemVo, newItemVo);
				
				//立即计费调用
				this.accountExpenseService.billing();
				
				modelMap.put("cpuChangeMsg", "计算方案更改成功");
				
			} catch (Exception e) {
				modelMap.put("cpuChangeMsg", "失败："+e.getMessage());
			}
			
		}catch(CloudException e){
			modelMap.put("cpuChangeMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("priceList", new ArrayList<Object>());
		return "myresources/changeService_computResource";
	}
	
	/**
	 * 我的虚拟机 - 增加磁盘资源
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "diskResource")
	public String diskResource(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		//磁盘方案只能增加，不可修改，必须停机才能调用接口
		String orderId = request.getParameter("orderId");
		//订单主表信息
		CloudUserOrderVo orderVo = this.cloudUserOrderService.get(orderId);
		
//		//订单子表信息，查找该虚机的磁盘方案计费类型
//		CloudUserOrderItemVo itemVo = this.cloudUserOrderItemService.getOrderItemByOrderIdAndProdType(orderId, Constants.PROD_TYPE_DISK_SOLN);
//		if(itemVo == null){
//			modelMap.put("orderId", orderId);
//			modelMap.put("priceList", new ArrayList<Object>());
//			return "myresources/changeService_diskResource";
//		}
		
		//查找与该虚拟机相同计费方式的磁盘资源
		String priceMode = Constants.PRICE_MODE_CYCLE;
		modelMap.put("billingCycle", orderVo.getBillingCycle());
		if(null == orderVo.getBillingCycle() || Constants.BILLING_TYPE_SINGLE.equals(orderVo.getBillingCycle())){
			priceMode = Constants.PRICE_MODE_ONE_TIME;
			modelMap.put("billingCycle", Constants.BILLING_TYPE_SINGLE);
		}
		
		//根据订单的计费类型和计费周期，查找相同计费类型和计费周期的产品定价信息（单独创建磁盘定价，可以忽略）
		QueryContext pc = new ECContext(request, modelMap, "priceList");
		pc.clearParmeters();
		pc.put("$le_effectiveDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
		pc.put("$ge_invalidDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
		pc.put("$eq_priceMode", priceMode);
		pc.put("$eq_cloudMdmProductItem_itemType", Constants.PROD_TYPE_DISK_SOLN);
		pc.put("$eq_cloudMdmProductItem_mdmDiskSoln_iscustomized", "false");//不属于自定义磁盘方案
		
		List<?> priceList = this.cloudProductPriceService.list(pc);
		
		modelMap.put("orderId", orderId);
		modelMap.put("priceList", priceList);
		
		return "myresources/changeService_diskResource";
	}
	
	/**
	 * 我的虚拟机 - 磁盘资源增加保存（新增订单）
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "changeDisk")
	public String changeDisk(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		//********************自定义磁盘增加未考虑
		String billingCycle = request.getParameter("billingCycle");
		String prodId = request.getParameter("prodId");
		String priceId = request.getParameter("priceId");
		String prodItemId = request.getParameter("prodItemId");
		String orderId = request.getParameter("orderId");
		
		//该订单所在的虚拟机
		vo = this.cloudUserOrderService.get(orderId);
		String vmInterfaceId = vo.getCloudMdmVm().getInterfaceId();

		//订单主表信息
		CloudUserOrderVo orderVo = new CloudUserOrderVo(); 
		//订单子表信息
		CloudUserOrderItemVo newItemVo = new CloudUserOrderItemVo();
		
		try{
			try {
				//增加的磁盘资源定价信息
				CloudProductPriceVo priceVo = this.cloudProductPriceService.get(priceId);
				Double newProdPrice = 0d;
				if(billingCycle.equals(Constants.BILLING_TYPE_SINGLE)){
					newProdPrice = priceVo.getOneTimePrice();
				}else if(billingCycle.equals(Constants.BILLING_CYCLE_YEAR)){
					newProdPrice = priceVo.getYearPrice();
				}else if(billingCycle.equals(Constants.BILLING_CYCLE_MONTH)){
					newProdPrice = priceVo.getMonthPrice();
				}else if(billingCycle.equals(Constants.BILLING_CYCLE_DAY)){
					newProdPrice = priceVo.getDayPrice();
				}else{
					newProdPrice = priceVo.getHourPrice();
				}
				//产品促销信息
				CloudPromotionValue promo = cloudPromotionProductService.getDiscountAmountByProdId(prodId, newProdPrice);
				
				
				//订单主表
				//orderVo = this.cloudUserOrderService.get(orderId);
				BasicUserVo basicUser = this.getCurrentUser(request);
				BasicUserVo basicAccount = basicUser.getUserFlag()==Constants.USER_FLAG_ACCOUNT ? basicUser : basicUser.getParentBasicUser();
				orderVo.setBasicUser(basicUser);
				orderVo.setBasicAccount(basicAccount);
				orderVo.setOrderTime(new Date());
				orderVo.setBuyType(Constants.PROD_BUY_SINGLE);
				//是否开始计费
				orderVo.setBillingFlag(Constants.BILLING_FALG_STOP);
				//计费周期：不属于一次性计费的才写值
				if(!billingCycle.equals(Constants.BILLING_TYPE_SINGLE)){
					orderVo.setBillingCycle(billingCycle);
				}
				orderVo.setState(String.valueOf(Constants.INVALID_STATE));
				orderVo.setCreated(new Date());
				orderVo.setCreatedBy(basicUser.getUserAccount());
				orderVo.setCreateId(this.getCurrentUser(request).getUserId());
				orderVo.setOrderType(Constants.ORDER_TYPE_DISK);
				orderVo.setCloudMdmVm(vo.getCloudMdmVm());//磁盘所在的虚拟机
				
				//订单子表
				newItemVo.setCloudUserOrder(orderVo);
				newItemVo.setCloudMdmProduct(this.cloudMdmProductService.get(prodId));
				newItemVo.setCloudMdmProductItem(this.cloudMdmProductItemService.get(prodItemId));
				newItemVo.setProdType(Constants.PROD_TYPE_DISK_SOLN);
				//是否开始计费，变更成功后修改这个状态
				newItemVo.setBillingFlag(Constants.BILLING_FALG_STOP);
				//一次性计费是否已发生
				newItemVo.setOneTimeBillingFlag(Constants.BILLING_FALG_STOP);
//				//开始计费时间=明天凌晨
//				newItemVo.setBeginBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
//				//下次计费时间
//				newItemVo.setNextBillingTime(newItemVo.getBeginBillingTime());
				//计费类型
				if(Constants.BILLING_TYPE_SINGLE.equals(billingCycle)){
					newItemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
				}else{
					newItemVo.setBillingType(Constants.BILLING_TYPE_CYCLE);
				}
				if(promo != null){
					newItemVo.setPromotionId(promo.getPromotionId());
					newItemVo.setRebateAmount(promo.getRebateAmount());
					newItemVo.setRebateFlag(promo.getRebateFlag());
				}
				
				
				//订单变更保存
				this.cloudUserOrderService.saveOrder(orderVo, newItemVo);
				
				
				//调用增加磁盘接口
				String diskofferingid = priceVo.getCloudMdmProductItem().getMdmDiskSoln().getInterfaceId();
				this.cloudMdmVMService.addDiskService(vmInterfaceId, basicAccount.getUserAccount(), diskofferingid, null);
				
				
				//修改计费状态
				orderVo.setBillingFlag(Constants.BILLING_FALG_START);
				orderVo.setState(String.valueOf(Constants.VALID_STATE));
				
				newItemVo.setBillingFlag(Constants.BILLING_FALG_START);
				this.cloudUserOrderService.saveOrder(orderVo, newItemVo);
	
				//立即计费调用
				this.accountExpenseService.billing();
				
				modelMap.put("diskChangeMsg", "增加磁盘成功");
			} catch (ValidatorException e) {
				modelMap.put("diskChangeMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
		}catch(CloudException e){
			modelMap.put("diskChangeMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("priceList", new ArrayList<Object>());
		return "myresources/changeService_diskResource";
	}
	
	
}
