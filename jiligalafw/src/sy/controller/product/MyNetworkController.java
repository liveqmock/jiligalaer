package sy.controller.product;

import java.util.ArrayList;
import java.util.Arrays;
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
import sy.common.util.cloudstack.entity.LoadBalancerAlgorithm;
import sy.common.util.cloudstack.entity.NetworkType;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.product.CloudLBStickinessPolicyVo;
import sy.domain.vo.product.CloudLoadBalancerRuleInstanceVo;
import sy.domain.vo.product.CloudLoadbalancerruleVo;
import sy.domain.vo.product.CloudMdmIPVo;
import sy.domain.vo.product.CloudMdmNetworkVo;
import sy.domain.vo.product.CloudMdmNicVo;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.domain.vo.product.CloudProductPriceVo;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.domain.vo.product.CloudVpnUserVo;
import sy.domain.vo.promotion.CloudPromotionValue;
import sy.service.base.BasicUserServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.product.CloudEgressruleServiceI;
import sy.service.product.CloudIngressruleServiceI;
import sy.service.product.CloudLBStickinessPolicyServiceI;
import sy.service.product.CloudLoadBalancerRuleInstanceServiceI;
import sy.service.product.CloudLoadbalancerruleServiceI;
import sy.service.product.CloudMdmEgressFirewallRuleServiceI;
import sy.service.product.CloudMdmFirewallruleServiceI;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkServiceI;
import sy.service.product.CloudMdmNetworkSolnServiceI;
import sy.service.product.CloudMdmNicServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmZoneServiceI;
import sy.service.product.CloudPortForwardingRuleServiceI;
import sy.service.product.CloudProductPriceServiceI;
import sy.service.product.CloudRemoteaccessVpnServiceI;
import sy.service.product.CloudSecurityGroupServiceI;
import sy.service.product.CloudUserOrderItemServiceI;
import sy.service.product.CloudUserOrderServiceI;
import sy.service.product.CloudVpnUserServiceI;
import sy.service.promotion.CloudPromotionInfoServiceI;
import sy.service.promotion.CloudPromotionProductServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 我的资源 - 我的网络
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/network")
@SessionAttributes("cloudMdmProductVo")
public class MyNetworkController extends BaseControllerTemplate<CloudMdmProductVo> {

	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	@Autowired
	private CloudMdmZoneServiceI cloudMdmZoneService;
	@Autowired
	private CloudMdmNetworkServiceI cloudMdmNetworkService;
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	@Autowired
	private CloudPromotionInfoServiceI cloudPromotionInfoService;
	@Autowired
	private CloudMdmIPServiceI cloudMdmIPService;
	@Autowired
	private CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService;
	@Autowired
	private CloudMdmEgressFirewallRuleServiceI cloudMdmEgressFirewallRuleService;
	@Autowired
	private CloudMdmFirewallruleServiceI cloudMdmFirewallruleService;
	@Autowired
	private CloudSecurityGroupServiceI cloudSecurityGroupService;
	@Autowired
	private CloudIngressruleServiceI cloudIngressruleService;
	@Autowired
	private CloudEgressruleServiceI cloudEgressruleService;
	@Autowired
	private CloudPortForwardingRuleServiceI cloudPortForwardingRuleService;
	@Autowired
	private CloudVpnUserServiceI cloudVpnUserService;
	@Autowired 
	private CloudRemoteaccessVpnServiceI cloudRemoteaccessVpnService;
	@Autowired
	private CloudPromotionProductServiceI cloudPromotionProductService;
	@Autowired
	private CloudMdmNicServiceI cloudMdmNicService;
	
	@Autowired
	private CloudLoadbalancerruleServiceI cloudLoadbalancerruleService;
	@Autowired
	private CloudLoadBalancerRuleInstanceServiceI cloudLoadBalancerRuleInstanceService;
	@Autowired
	private CloudLBStickinessPolicyServiceI cloudLBStickinessPolicyService;
	
	@Override
	public BasicServiceI<CloudMdmProductVo> getService() {
		return cloudMdmProductService;
	}
	
	public String getViewPath() {
		return "myresources";
	}
	
	/**
	 * 我的网络主页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) {

		return "myresources/myNetworkList";
	}

	/**
	 * 我的网络 - 基本网络 - 安全组查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "basicNet")
	public String basicNet(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {

		QueryContext context = new ECContext(request, modelMap, "securityList");
		context.clearParmeters();
		context.put("$eq_account", this.getCurrentParentUser(request).getUserAccount());
		
		String securityGroupName = request.getParameter("securityGroupName");
		context.put("$eq_name", securityGroupName);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> securityList = this.cloudSecurityGroupService.list(context);
		
		modelMap.put("securityList", securityList);
		modelMap.put("securityGroupName", securityGroupName);
		
		return "myresources/myNetwork_basicNet";
	}
	

	/**
	 * 我的网络 - 基本网络 - 安全组保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "saveSecurityGroup")
	public String saveSecurityGroup(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String securityGroup = request.getParameter("securityGroup");
		try{
			try {
				BasicUserVo parentUser = this.getCurrentParentUser(request);
				this.cloudSecurityGroupService.create(parentUser.getUserAccount(), securityGroup, securityGroup);
				
				modelMap.put("groupMsg", "安全组添加成功");
				
			} catch (ValidatorException e) {
				modelMap.put("groupMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		}catch(CloudException e){
			modelMap.put("groupMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}

		modelMap.put("securityList", new ArrayList<Object>());
		return "myresources/myNetwork_basicNet";
	}
	
	/**
	 * 我的网络 - 基本网络 - 安全组删除
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "delSecurityGroup")
	public String delSecurityGroup(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String securityGroupId = request.getParameter("groupId");
		try{
			try {
				this.cloudSecurityGroupService.delete(securityGroupId);
				
				modelMap.put("groupMsg", "安全组删除成功");
				
			} catch (ValidatorException e) {
				modelMap.put("groupMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		}catch(CloudException e){
			modelMap.put("groupMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("securityList", new ArrayList<Object>());
		return "myresources/myNetwork_basicNet";
	}

	
	/**
	 * 我的网络 - 基本网络 - 安全组 - 出口规则查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "outEdit")
	public String outEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "outRuleList");
		context.clearParmeters();
//		context.put("$eq_account", this.getCurrentParentUser(request).getUserAccount());
		
		String groupId = request.getParameter("groupId");
		context.put("$eq_securityGroupId", groupId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> outRuleList = this.cloudEgressruleService.list(context);
		
		modelMap.put("outRuleList", outRuleList);
		modelMap.put("groupId", groupId);
		
		return "myresources/myNetwork_basicNet_outEdit";
	}
	
	/**
	 * 我的网络 - 基本网络 - 安全组 - 出口规则保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "outRuleSave")
	public String outRuleSave(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String groupId = request.getParameter("groupId");
		String cidr = request.getParameter("cidr");
		String protocol = request.getParameter("protocol");
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		try{
			try {
				if("ICMP".equals(protocol)){
					this.cloudEgressruleService.create(groupId, cidr, protocol, null, null, val1, val2);
				}else{
					this.cloudEgressruleService.create(groupId, cidr, protocol, val1, val2, null, null);
				}
				
				modelMap.put("outRuleMsg", "出口规则添加成功");
			} catch (ValidatorException e) {
				modelMap.put("outRuleMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("outRuleMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}

		modelMap.put("outRuleList", new ArrayList<Object>());
		modelMap.put("groupId", groupId);
		return "myresources/myNetwork_basicNet_outEdit";
	}
	
	/**
	 * 我的网络 - 基本网络 - 安全组 - 出口规则删除
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "outRuleDel")
	public String outRuleDel(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String groupId = request.getParameter("groupId");
		String interfaceId = request.getParameter("interfaceId");

		try {
			try {
				this.cloudEgressruleService.delete(interfaceId);
				modelMap.put("outRuleMsg", "出口规则删除成功");
				
			} catch (ValidatorException e) {
				modelMap.put("outRuleMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("outRuleMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("outRuleList", new ArrayList<Object>());
		modelMap.put("groupId", groupId);
		return "myresources/myNetwork_basicNet_outEdit";
	}
	
	
	/**
	 * 我的网络 - 基本网络 - 安全组 - 入口规则查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "inEdit")
	public String inEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "inRuleList");
		context.clearParmeters();
//		context.put("$eq_account", this.getCurrentParentUser(request).getUserAccount());
		
		String groupId = request.getParameter("groupId");
		context.put("$eq_securityGroupId", groupId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> inRuleList = this.cloudIngressruleService.list(context);
		
		modelMap.put("inRuleList", inRuleList);
		modelMap.put("groupId", groupId);
		
		return "myresources/myNetwork_basicNet_inEdit";
	}
	
	/**
	 * 我的网络 - 基本网络 - 安全组 - 入口规则保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "saveInRule")
	public String saveInRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String groupId = request.getParameter("groupId");
		String cidr = request.getParameter("cidr");
		String protocol = request.getParameter("protocol");
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		try{
			try {
				if("ICMP".equals(protocol)){
					this.cloudIngressruleService.create(groupId, cidr, protocol, null, null, val1, val2);
				}else{
					this.cloudIngressruleService.create(groupId, cidr, protocol, val1, val2, null, null);
				}
				
				modelMap.put("inRuleMsg", "入口规则添加成功");
			} catch (ValidatorException e) {
				modelMap.put("inRuleMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("inRuleMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}

		modelMap.put("inRuleList", new ArrayList<Object>());
		modelMap.put("groupId", groupId);
		return "myresources/myNetwork_basicNet_inEdit";
	}
	
	/**
	 * 我的网络 - 基本网络 - 安全组 - 入口规则删除
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delInRule")
	public String delInRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String groupId = request.getParameter("groupId");
		String interfaceId = request.getParameter("interfaceId");

		try {
			try {
				this.cloudIngressruleService.delete(interfaceId);
				modelMap.put("inRuleMsg", "入口规则删除成功");
				
			} catch (ValidatorException e) {
				modelMap.put("inRuleMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("inRuleMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("inRuleList", new ArrayList<Object>());
		modelMap.put("groupId", groupId);
		return "myresources/myNetwork_basicNet_inEdit";
	}
	

	
	
	/**
	 * 我的网络 - 高级网络查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highNet")
	public String highNet(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "networkList");
		context.clearParmeters();
		context.put("$eq_account", this.getCurrentParentUser(request).getUserAccount());
		
		String networkName = request.getParameter("networkName");
		String networkSolnName = request.getParameter("networkSolnName");
		context.put("$eq_name", networkName);
		context.put("$eq_networkofferingname", networkSolnName);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> networkList = this.cloudMdmNetworkService.list(context);
		
		modelMap.put("networkList", networkList);
		modelMap.put("networkName", networkName);
		modelMap.put("networkSolnName", networkSolnName);
		
		return "myresources/myNetwork_highNet";
	}
	
	/**
	 * 我的网络 - 高级网络 - 初始化添加网络页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "addHighNet")
	public String addHighNet(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {

		QueryContext context = new ECContext(request, modelMap, "addNet");
		context.clearParmeters();
		context.put("$eq_networkType", NetworkType.Advanced.toString());
		List<?> dclist = this.cloudMdmZoneService.list(context);
		modelMap.put("dclist", dclist);
		
//		context.clearParmeters();
//		context.put("$eq_cloudMdmProductItem_itemType", Constants.PROD_TYPE_NETWORK_SOLN);
//		context.put("$eq_cloudMdmProductItem_mdmNetworkSoln_forvpc", "false");
//		context.put("$le_effectiveDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
//		context.put("$ge_invalidDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
//		List<?> netWorklist = this.cloudProductPriceService.list(context);

		String zoneId = request.getParameter("zoneId");
		List<?> netWorklist = this.cloudMdmProductItemService.getNetworkSingleProd(zoneId);
		
		modelMap.put("netWorklist", netWorklist);
		modelMap.put("zoneId", zoneId);
		
		return "myresources/myNetwork_highNet_add";
	}
	
	/**
	 * 我的网络 - 高级网络 - 添加网络保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "saveHighNet")
	public String saveHighNet(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		try{
			try{
				BasicUserVo basicUser = this.getCurrentUser(request);
				
				String description = request.getParameter("description");
				String networkName = request.getParameter("networkName");
				String selValue = request.getParameter("selValue");
				String zoneId = request.getParameter("zoneId");
				String[] priceInfo = selValue.split("_");
				String prodId = priceInfo[0];				//产品主表ID
				String price = priceInfo[1];				//选择的计费价格
				String prodItemId = priceInfo[2];			//产品子表ID
				String ifId = priceInfo[3];					//接口元素ID
				String billingCycle = priceInfo[4];			//计费周期
				
				//验证网络名称是否重复
				boolean isExist = this.cloudMdmNetworkService.checkNetworkNameIsExist(networkName, basicUser.getUserAccount());
				if(isExist){
					modelMap.put("networkAddMsg", "网络添加失败，网络名称重复。");
					modelMap.put("netWorklist", new ArrayList<Object>());
					return "myresources/myNetwork_highNet_add"; 
				}
				
				//主订单信息
				CloudUserOrderVo orderVo = new CloudUserOrderVo();
				BasicUserVo parentUser = basicUser;
				if(basicUser.getUserFlag() == Constants.USER_FLAG_USER){
					parentUser = basicUser.getParentBasicUser();
				}
				orderVo.setBasicUser(parentUser);
				orderVo.setOrderTime(new Date());
				orderVo.setCloudMdmNetworkSoln(this.cloudMdmProductItemService.get(prodItemId).getMdmNetworkSoln());
				orderVo.setBuyType(Constants.PROD_BUY_SINGLE);
				orderVo.setBillingFlag(Constants.BILLING_FALG_STOP);//是否开始计费
				if(!billingCycle.equals(Constants.BILLING_TYPE_SINGLE)){
					orderVo.setBillingCycle(billingCycle);
				}
				orderVo.setState(String.valueOf(Constants.INVALID_STATE));
				orderVo.setCreated(new Date());
				orderVo.setCreatedBy(basicUser.getUserAccount());
				orderVo.setCreateId(this.getCurrentUser(request).getUserId());
				orderVo.setOrderType(Constants.ORDER_TYPE_NETWORK);
				
				//子订单信息
				CloudUserOrderItemVo itemVo = new CloudUserOrderItemVo();
				itemVo.setCloudUserOrder(orderVo);
				itemVo.setCloudMdmProduct(this.cloudMdmProductService.get(prodId));
				itemVo.setCloudMdmProductItem(this.cloudMdmProductItemService.get(prodItemId));
				itemVo.setProdType(Constants.PROD_TYPE_NETWORK_SOLN);
				//是否开始计费
				itemVo.setBillingFlag(Constants.BILLING_FALG_STOP);
				//一次性计费是否已发生（如果是周期性的本不用填写，填写了也没用影响）
				itemVo.setOneTimeBillingFlag(Constants.BILLING_FALG_STOP);
				
//				//开始计费时间=明天凌晨
//				itemVo.setBeginBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
//				//计费调度时填写
//				itemVo.setNextBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
				//计费类型
				if(Constants.BILLING_TYPE_SINGLE.equals(billingCycle)){
					itemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
				}else{
					itemVo.setBillingType(Constants.BILLING_TYPE_CYCLE);
				}
				//获取产品促销价格
				CloudPromotionValue promo = cloudPromotionProductService.getDiscountAmountByProdId(prodId, Double.valueOf(price));
				if(promo != null){
					itemVo.setPromotionId(promo.getPromotionId());
					itemVo.setRebateAmount(promo.getRebateAmount());
					itemVo.setRebateFlag(promo.getRebateFlag());
				}
				
				
				//购买时账户费用不足，购买失败。
				AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(parentUser.getUserId());
				if(expVo == null || (expVo.getPayTotalAmount()- expVo.getExpTotalAmount()) < Double.valueOf(price)){
					modelMap.put("networkAddMsg", "网络添加失败，账户费用不足，请充值。");
					modelMap.put("netWorklist", new ArrayList<Object>());
					return "myresources/myNetwork_highNet_add"; 
				}
				
				//保存购买订单
				this.cloudUserOrderService.saveOrder(orderVo, itemVo);
				
				//调用接口创建网络
				CloudMdmNetworkVo networkVo = this.cloudMdmNetworkService.create(parentUser.getUserAccount(), zoneId, ifId, networkName, description);
				
				
				//修改计费状态
				orderVo.setBillingFlag(Constants.BILLING_FALG_START);
				orderVo.setState(String.valueOf(Constants.VALID_STATE));
				orderVo.setCloudMdmNetwork(networkVo);
				
				itemVo.setBillingFlag(Constants.BILLING_FALG_START);
				this.cloudUserOrderService.saveOrder(orderVo,itemVo);
				
				//立即计费调用
				this.accountExpenseService.billing();
				
				modelMap.put("networkAddMsg", "网络添加成功，已开始计费，" + orderVo.getCycleName() + price + "元。");
			}catch(ValidatorException e){
				modelMap.put("networkAddMsg", "网络添加失败："+e.getMessage());
				e.printStackTrace();
			}
		}catch(CloudException e){
			modelMap.put("networkAddMsg", "网络添加失败："+e.getMessage());
			e.printStackTrace();
		}
		
		//成功提示，收费提示信息：已进入计费时间
		modelMap.put("netWorklist", new ArrayList<Object>());
		return "myresources/myNetwork_highNet_add";
	}
	
	/**
	 * 我的网络 - 高级网络 - 删除网络
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delNetwork")
	public String delNetwork(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		//接口网络ID
		String interfaceId = request.getParameter("interfaceId");
		//Cloud系统网络ID
		String networkId = request.getParameter("networkId");
		try{
			try{

//				//需要验证网络是否被用，在虚拟机表（NIC子表）查找该账户下有效的虚拟机，如果dataState有效说明虚机正在使用，只有虚机销毁了dataState才为无效。
//				QueryContext context = new ECContext(request, modelMap, "nicList");
//				context.put("$eq_networkId", interfaceId);
//				context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
//				List<?> nicList = this.cloudMdmNicService.list(context);
//				if(nicList != null && nicList.size()>0){
//					modelMap.put("networkMsg", "网络删除失败：虚拟机正在该网络上运行。");
//					modelMap.put("networkList", new ArrayList<Object>());
//					return "myresources/myNetwork_highNet";
//				}
				
				//删除网络验证，放到cloudstack中验证，让他抛出异常，捕捉后提示到页面。
				
				//调用接口删除网络
				this.cloudMdmNetworkService.delete(interfaceId);
				
				//修改订单主表订单状态、添加订单子表资源销毁时间
				this.cloudUserOrderService.updateDestroyDateById(networkId, "network");
				
				modelMap.put("networkMsg", "网络删除成功");
			}catch(ValidatorException e){
				modelMap.put("networkMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
		}catch(CloudException e){
			modelMap.put("networkMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("networkList", new ArrayList<Object>());
		return "myresources/myNetwork_highNet";
	}
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 列表查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highIpAddr")
	public String highIpAddr(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		//查询当前账户下，当前网络下的IP列表
		String ipAddr = request.getParameter("ipAddr");
		String networkId = request.getParameter("networkId");
		QueryContext context = new ECContext(request, modelMap, "ipList");
		context.clearParmeters();
		context.put("$eq_account", this.getCurrentParentUser(request).getUserAccount());
		context.put("$eq_associatednetworkid", networkId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		context.put("$eq_ipAddress", ipAddr);
		List<?> ipList = this.cloudMdmIPService.listByNetwork(context, networkId);
		
		modelMap.put("ipAddr", ipAddr);
		modelMap.put("networkId", networkId);
		modelMap.put("ipList", ipList);
		
		return "myresources/myNetwork_highNet_ipAddrList";
	}
	
	/**
	 * IP地址申请收费选择页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "ipApplyInit")
	public String ipApplyInit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {

		QueryContext context = new ECContext(request, modelMap, "ipPriceList");
		context.clearParmeters();
		context.put("$eq_cloudMdmProductItem_itemType", Constants.PROD_TYPE_IP);
		context.put("$le_effectiveDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
		context.put("$ge_invalidDate", DateUtil.format(new Date(), "yyyy-MM-dd"));
		List<CloudProductPriceVo> ipPriceList = this.cloudProductPriceService.list(context);
		
		modelMap.put("ipPriceVo",(null==ipPriceList || 0==ipPriceList.size())
				? new CloudProductPriceVo() : ipPriceList.get(0));
		
		String networkId = request.getParameter("networkId");
		modelMap.put("networkId", networkId);
		
		return "myresources/myNetwork_highNet_ipApply";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 申请IP地址
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "applyAddr")
	public String applyAddr(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		try{
			String selValue = request.getParameter("selValue");
			//String prodId = request.getParameter("prodId");
			String prodItemId = request.getParameter("prodItemId");
			String[] priceInfo = selValue.split("_");
			String price = priceInfo[0];				//选择的计费价格
			String billingCycle = priceInfo[1];			//计费周期
			
			//购买时账户没有钱，购买失败。
			try {
				BasicUserVo basicUser = this.getCurrentParentUser(request);

				//查询IP定价信息（单一产品IP，系统初始化数据）
				CloudMdmProductItemVo prodItemVo = this.cloudMdmProductItemService.get(prodItemId);
				
				//主订单信息
				CloudUserOrderVo orderVo = new CloudUserOrderVo();
				orderVo.setBasicUser(basicUser);
				orderVo.setOrderTime(new Date());
				orderVo.setBuyType(Constants.PROD_BUY_SINGLE);
				if(!billingCycle.equals(Constants.BILLING_TYPE_SINGLE)){
					orderVo.setBillingCycle(billingCycle);
				}
				orderVo.setBillingFlag(Constants.BILLING_FALG_STOP);//是否开始计费
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
				if(Constants.BILLING_TYPE_SINGLE.equals(billingCycle)){
					itemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
				}else{
					itemVo.setBillingType(Constants.BILLING_TYPE_CYCLE);
				}
//				//开始计费时间=明天凌晨
//				itemVo.setBeginBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
//				//计费调度时填写
//				itemVo.setNextBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));

				//获取产品促销价格
				CloudPromotionValue promo = cloudPromotionProductService.getDiscountAmountByProdId(prodItemVo.getMdmProduct().getId(), Double.valueOf(price));
				if(promo != null){
					itemVo.setPromotionId(promo.getPromotionId());
					itemVo.setRebateAmount(promo.getRebateAmount());
					itemVo.setRebateFlag(promo.getRebateFlag());
				}
				
				//购买时账户费用不足，购买失败。
				AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(basicUser.getUserId());
				if(expVo == null || (expVo.getPayTotalAmount()- expVo.getExpTotalAmount()) < Double.valueOf(price)){
					modelMap.put("ipOperationMsg", "IP申请失败，账户费用不足，请充值。");
					modelMap.put("ipPriceVo", new CloudProductPriceVo());
					modelMap.put("networkId", networkId);
					return "myresources/myNetwork_highNet_ipApply";
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
					this.cloudUserOrderService.saveOrder(orderVo, itemVo);
					
					//立即计费调用
					this.accountExpenseService.billing();
					
					modelMap.put("ipOperationMsg", "IP申请成功，已开始计费， " + orderVo.getCycleName() + price + "元。");
				}else{
					//修改订单状态
					orderVo.setState(String.valueOf(Constants.VALID_STATE));
					orderVo.setRemark("源natIP不需要收费。");
					this.cloudUserOrderService.save(orderVo);
					modelMap.put("ipOperationMsg", "IP申请成功");
				}

				
			} catch (ValidatorException e) {
				modelMap.put("ipOperationMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		}catch(CloudException e){
			modelMap.put("ipOperationMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("ipPriceVo", new CloudProductPriceVo());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipApply";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 删除IP地址
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "delIpAddr")
	public String delIpAddr(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) throws ValidatorException {
		String networkId = request.getParameter("networkId");
		String interfaceId = request.getParameter("interfaceId");
		String ipAddrId = request.getParameter("ipAddrId");
		
		try {
			//判断IP地址是否被虚拟机用了（这个地方不需要判断了，因为虚拟机和网络关联，网络和IP关联，这个地方的IP和虚拟机无关连）
			
			try{
				//接口删除IP地址
				this.cloudMdmIPService.disassociateIpAddress(interfaceId);
				//修改计费状态
				this.cloudUserOrderService.updateDestroyDateById(ipAddrId, "ip");
				
				modelMap.put("ipOperationMsg", "IP地址删除成功");
				
				//如果删除时抛的是ValidatorException，则直接返回错误到页面
				//因为CloudException继承了RuntimeException，ValidatorException继承了Exception
			} catch (ValidatorException e) {
				modelMap.put("ipOperationMsg", "失败："+e.getMessage());
				e.printStackTrace();
				throw e;
			}
			
		} catch (CloudException e) {
			modelMap.put("ipOperationMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("ipList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddrList";
	}
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - NAT启用、禁用
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "highNatEdit")
	public String highNatEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String vmId = request.getParameter("vmId");
		String state = request.getParameter("state");
		String ipAddrId = request.getParameter("ipAddrId");
		try {
			try {
				if("0".equals(state)){
					//禁用
					this.cloudMdmIPService.disableStaticNat(ipAddrId);
					modelMap.put("ipOperationMsg", "成功禁用");
				}else{
					//启用
					this.cloudMdmIPService.enableStaticNat(ipAddrId, vmId);
					modelMap.put("ipOperationMsg", "成功启用");
				}
				
			} catch (ValidatorException e) {
				modelMap.put("ipOperationMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
		} catch (CloudException e) {
			modelMap.put("ipOperationMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("ipList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddrList";
	}
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - VPN启用、禁用
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vpnOperate")
	public String vpnOperate(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		
		BasicUserVo basicUser = this.getCurrentParentUser(request);
		String networkId = request.getParameter("networkId");
		String ipAddrId = request.getParameter("ipAddrId");
		String state = request.getParameter("state");
		
		try {
			try {
				if("0".equals(state)){
					//禁用
					this.cloudRemoteaccessVpnService.delete(ipAddrId);
					modelMap.put("ipOperationMsg", "VPN禁用成功");
				}else{
					//启用
					this.cloudRemoteaccessVpnService.create(basicUser.getUserAccount(), ipAddrId);
					modelMap.put("ipOperationMsg", "VPN启用成功");
				}
				
			} catch (ValidatorException e) {
				modelMap.put("ipOperationMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
		} catch (CloudException e) {
			modelMap.put("ipOperationMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("ipList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddrList";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - VPN - VPN账号查询
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highVpnEdit")
	public String highVpnEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		String networkId = request.getParameter("networkId");
		QueryContext context = new ECContext(request, modelMap, "vpnUserList");
		context.clearParmeters();
		context.put("$eq_account", this.getCurrentParentUser(request).getUserAccount());
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> vpnUserList = this.cloudVpnUserService.list(context);
		
		modelMap.put("vpnUserList", vpnUserList);
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_vpn";
	}

	/**
	 * 我的网络 - 高级网络 - IP地址维护 - VPN -保存VPN账户
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "saveVpnUser")
	public String saveVpnUser(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String vpnUserName = request.getParameter("vpnUserName");
		String vpnUserPass = request.getParameter("vpnUserPass");
		String accountName = this.getCurrentParentUser(request).getUserAccount();
		
		try{
			try {
				this.cloudVpnUserService.create(accountName, vpnUserName, vpnUserPass);
				modelMap.put("vpnUserMsg", "VPN用户添加成功");
				
			} catch (ValidatorException e) {
				modelMap.put("vpnUserMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("vpnUserMsg", "失败："+e.getMessage().replaceAll("'", ""));
			e.printStackTrace();
		}
		
		modelMap.put("vpnUserList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_vpn";
	}

	/**
	 * 我的网络 - 高级网络 - IP地址维护 - VPN -删除VPN账户
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delVpnUser")
	public String delVpnUser(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String vpnUserId = request.getParameter("vpnUserId");
		String accountName = this.getCurrentParentUser(request).getUserAccount();
		
		try{
			try {
				CloudVpnUserVo vpnUserVo = this.cloudVpnUserService.get(vpnUserId);
				this.cloudVpnUserService.delete(accountName, vpnUserVo.getUsername());
				modelMap.put("vpnUserMsg", "VPN用户删除成功");
				
			} catch (ValidatorException e) {
				modelMap.put("vpnUserMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("vpnUserMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("vpnUserList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_vpn";
	}
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 防火墙
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highFirewallEdit")
	public String highFirewallEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		
//		由于防火墙表中存放的IP地址接口IP为数值，而不是UUID，故暂时用下面的IP地址字符过滤。
//		CloudMdmIPVo ipVO = this.cloudMdmIPService.getIpAddrByInterfaceId(ipAddrId);
//		context.put("$eq_ipaddress", ipVO.getIpAddress());
//		context.put("$eq_networkid", networkId); 	//防火墙只用IP地址过滤就行，不需要网络ID，因为防火墙只挂在IP地址上。
		
		QueryContext context = new ECContext(request, modelMap, "firewallList");
		context.clearParmeters();
		context.put("$eq_ipaddressid", ipAddrId);	
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> firewallList = this.cloudMdmFirewallruleService.list(context);
		
		modelMap.put("firewallList", firewallList);
		modelMap.put("networkId", networkId);
		modelMap.put("ipAddrId", ipAddrId);
		
		return "myresources/myNetwork_highNet_ipAddr_firewall";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 保存防火墙
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "saveHighFirewall")
	public String saveHighFirewall(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String ipAddrId = request.getParameter("ipAddrId");
		String cidr = request.getParameter("cidr");
		String protocol = request.getParameter("protocol");
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		try{
			try {
				if("ICMP".equals(protocol)){
					this.cloudMdmFirewallruleService.create(ipAddrId, cidr, null, null, val1, val2, protocol);
				}else{
					this.cloudMdmFirewallruleService.create(ipAddrId, cidr, val1, val2, null, null, protocol);
				}
				
				modelMap.put("firewallMsg", "防火墙添加成功");
			} catch (ValidatorException e) {
				modelMap.put("firewallMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("firewallMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}

		modelMap.put("firewallList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		modelMap.put("ipAddrId", ipAddrId);
		return "myresources/myNetwork_highNet_ipAddr_firewall";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 删除防火墙
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delHighFirewall")
	public String delHighFirewall(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String ipAddrId = request.getParameter("ipAddrId");
		
		String interfaceId = request.getParameter("interfaceId");

		try {
			try {
				this.cloudMdmFirewallruleService.delete(interfaceId);
				modelMap.put("firewallMsg", "防火墙删除成功");
				
			} catch (ValidatorException e) {
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("firewallMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("firewallList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		modelMap.put("ipAddrId", ipAddrId);
		return "myresources/myNetwork_highNet_ipAddr_firewall";
	}
	
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 负载均衡列表
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highLoadEdit")
	public String highLoadEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		BasicUserVo userVo = this.getCurrentParentUser(request);
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		
		QueryContext context = new ECContext(request, modelMap, "loadRuleList");
		context.clearParmeters();
		context.put("$eq_account", userVo.getUserAccount());
		context.put("$eq_publicipid", ipAddrId);	
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> loadRuleList = this.cloudLoadbalancerruleService.loadList(context);
		
		modelMap.put("loadRuleList", loadRuleList);
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_load";
	}

	/**
	 * 保存负载均衡规则
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "saveLoadRule")
	public String saveLoadRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		BasicUserVo userVo = this.getCurrentParentUser(request);
		
		String balancerName = request.getParameter("balancerName");
		String ipAddrId = request.getParameter("ipAddrId");
		String publicPort = request.getParameter("publicPort");
		String privatePort = request.getParameter("privatePort");
		String arithmetic = request.getParameter("arithmetic");
		String vmId = request.getParameter("vmId");
		List<String> vmids = Arrays.asList(vmId.split(","));
		
		LoadBalancerAlgorithm hm = null;
		if(arithmetic.equals(LoadBalancerAlgorithm.source.CODE)){
			hm = LoadBalancerAlgorithm.source;
		}else if(arithmetic.equals(LoadBalancerAlgorithm.leastconn.CODE)){
			hm = LoadBalancerAlgorithm.leastconn;
		}else{
			hm = LoadBalancerAlgorithm.roundrobin;
		}
		
		CloudLoadbalancerruleVo ruleVo = null;
		String msg = "";
		try {
			ruleVo = this.cloudLoadbalancerruleService.create(userVo.getUserAccount(), balancerName, ipAddrId, publicPort, privatePort, hm);
			this.cloudLoadBalancerRuleInstanceService.addInstance(ruleVo.getInterfaceId(), vmids);
			
			msg = "负载均衡添加成功";
		} catch (CloudException e) {
			try {
				if(ruleVo != null){
					this.cloudLoadbalancerruleService.delete(ruleVo.getInterfaceId());
				}
			} catch (CloudException e1) {
				e1.printStackTrace();
			} catch (ValidatorException e1) {
				e1.printStackTrace();
			}			
			e.printStackTrace();
			msg = "添加失败："+e.getMessage();
		} catch (Exception e) {
			msg = "添加失败："+e.getMessage();
		}
		
		modelMap.put("loadRuleMsg", msg);
		modelMap.put("loadRuleList", new ArrayList<Object>());
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", request.getParameter("networkId"));
		return "myresources/myNetwork_highNet_ipAddr_load";
	}

	/**
	 * 删除负载均衡规则
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delLoadRule")
	public String delLoadRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String loadRuleId = request.getParameter("loadRuleId");
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		
		try {
			this.cloudLoadbalancerruleService.delete(loadRuleId);
			modelMap.put("loadRuleMsg", "负载均衡删除成功");
			
		} catch (CloudException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "删除失败"+e.getMessage());
		} catch (ValidatorException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "删除失败"+e.getMessage());
		}
		
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_load";
	}

	/**
	 * 调整负载均衡规则
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "updLoadRule")
	public String updLoadRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String loadRuleId = request.getParameter("loadRuleId");
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		
		String ruleName = request.getParameter("ruleName");
		String updArithmetic = request.getParameter("updArithmetic");
		
		try {
			LoadBalancerAlgorithm hm = null;
			if(updArithmetic.equals(LoadBalancerAlgorithm.source.CODE)){
				hm = LoadBalancerAlgorithm.source;
			}else if(updArithmetic.equals(LoadBalancerAlgorithm.leastconn.CODE)){
				hm = LoadBalancerAlgorithm.leastconn;
			}else{
				hm = LoadBalancerAlgorithm.roundrobin;
			}
			
			this.cloudLoadbalancerruleService.update(loadRuleId, ruleName, "", hm);
			modelMap.put("loadRuleMsg", "负载均衡修改成功");
			
		} catch (CloudException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "修改失败"+e.getMessage());
		} catch (ValidatorException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "修改失败"+e.getMessage());
		}
		
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_load";
	}

	/**
	 * 查找该网络下的虚拟机实例
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "initAddInstance")
	public String initAddInstance(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		String loadRuleId = request.getParameter("loadRuleId");
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		
		//通过网络ID查询nic（网卡）
		QueryContext context = new QueryContext(request, modelMap, "vmInstance", false);
		context.clearParmeters();
		context.put("$eq_networkId", networkId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<CloudMdmNicVo> nicList = this.cloudMdmNicService.list(context);
		String vmIds ="";
		for(CloudMdmNicVo nicVo : nicList){
			vmIds += nicVo.getVirtualmachineId()+",";
		}
		if(vmIds.length() > 0){
			vmIds = vmIds.substring(0,vmIds.length()-1);
		}else{
			vmIds = "-1";
		}
		
		//过滤已添加的实例
		context.clearParmeters();
		context.put("$eq_lbruleid", loadRuleId);
		List<CloudLoadBalancerRuleInstanceVo> instanceList = this.cloudLoadBalancerRuleInstanceService.list(context);
		String notinVmIds ="";
		for(CloudLoadBalancerRuleInstanceVo instanceVo : instanceList){
			notinVmIds += instanceVo.getVirtualmachineid()+",";
		}
		if(notinVmIds.length() > 0){
			notinVmIds = notinVmIds.substring(0,notinVmIds.length()-1);
			
		}else{
			notinVmIds = "-1";
		}
		
		
		//通过nic中vmid查询虚拟机
		context.clearParmeters();
		BasicUserVo basicUser = this.getCurrentParentUser(request);
		context.put("$eq_account", basicUser.getUserAccount());
		context.put("$in_interfaceId", vmIds);
		context.put("$nin_interfaceId", notinVmIds);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<CloudMdmVmVo> vmlist = this.cloudMdmVMService.list(context);
		
//		List<CloudMdmVmVo> list = new ArrayList<CloudMdmVmVo>();
//		if(instanceList != null && instanceList.size() > 0){
//			for(CloudLoadBalancerRuleInstanceVo instanceVo : instanceList){
//				for(CloudMdmVmVo vmVo : vmlist){
//					if(!vmVo.getInterfaceId().equals(instanceVo.getVirtualmachineid())){
//						list.add(vmVo);
//					}
//				}
//			}
//		}else{
//			list.addAll(vmlist);
//		}
		
		modelMap.put("vmlist", vmlist);
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", networkId);
		modelMap.put("loadRuleId", loadRuleId);
		return "myresources/addInstance";
	}
	
	/**
	 * 添加负载均衡中虚拟机实例
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "addLoadRuleVm")
	public String addLoadRuleVm(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String loadRuleId = request.getParameter("loadRuleId");
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		String[] vmId = request.getParameterValues("vmId");
		List<String> vmids = Arrays.asList(vmId);
		
		try {
			this.cloudLoadBalancerRuleInstanceService.addInstance(loadRuleId, vmids);
			modelMap.put("loadRuleMsg", "虚拟机添加成功");
			
		} catch (CloudException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "添加失败"+e.getMessage());
		} catch (ValidatorException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "添加失败"+e.getMessage());
		}
		
		modelMap.put("vmlist", new ArrayList<Object>());
		modelMap.put("loadRuleId", loadRuleId);
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", networkId);
		return "myresources/addInstance";
	}
	
	/**
	 * 删除负载均衡中虚拟机实例
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delLoadRuleVm")
	public String delLoadRuleVm(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String loadRuleId = request.getParameter("loadRuleId");
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		String vmId = request.getParameter("vmid");
		List<String> vmids = Arrays.asList(vmId.split(","));
		
		try {
			this.cloudLoadBalancerRuleInstanceService.removeInstance(loadRuleId, vmids);
			modelMap.put("loadRuleMsg", "虚拟机删除成功");
			
		} catch (CloudException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "删除失败"+e.getMessage());
		} catch (ValidatorException e) {
			e.printStackTrace();
			modelMap.put("loadRuleMsg", "删除失败"+e.getMessage());
		}
		
		modelMap.put("ipAddrId", ipAddrId);
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_ipAddr_load";
	}
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 负载均衡列表 - 粘性配置页面初始化
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "stickinessConfigInit")
	public String stickinessConfigInit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		String loadRuleId = request.getParameter("loadRuleId");
		CloudLBStickinessPolicyVo policyVo = this.cloudLBStickinessPolicyService.getStickinessByRuleId(loadRuleId);
		if(policyVo != null){
			policyVo.init();
			if(policyVo.getMethodname().equals("AppCookie")){
				modelMap.put("AppCookie_name", policyVo.getName());
				modelMap.put("AppCookie_cookieName", policyVo.getCookieName());
				modelMap.put("AppCookie_modeName", policyVo.getMode());
				modelMap.put("length", policyVo.getLength());
				modelMap.put("holdtime", policyVo.getHoldtime());
				modelMap.put("requestLearn", policyVo.getRequestLearn());
				modelMap.put("prefix", policyVo.getPrefix());
				
			}else if(policyVo.getMethodname().equals("LbCookie")){
				modelMap.put("LbCookie_name", policyVo.getName());
				modelMap.put("LbCookie_cookieName", policyVo.getCookieName());
				modelMap.put("LbCookie_modeName", policyVo.getMode());				
				modelMap.put("nocache", policyVo.getNocache());
				modelMap.put("indirect", policyVo.getIndirect());
				modelMap.put("postonly", policyVo.getPostonly());
				modelMap.put("domain", policyVo.getDomain());
				
			}else if(policyVo.getMethodname().equals("SourceBased")){
				modelMap.put("SourceBased_name", policyVo.getName());
				modelMap.put("tableSize", policyVo.getTablesize());
				modelMap.put("expireTime", policyVo.getExpire());
			}			
		}

		modelMap.put("policyVo", policyVo);
		modelMap.put("loadRuleId", loadRuleId);
		return "myresources/myNetwork_highNet_ipAddr_loadConfig";
	}

	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 负载均衡列表 - 粘性配置保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "saveConfig")
	public String saveConfig(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String loadRuleId = request.getParameter("loadRuleId");
		String configId = request.getParameter("configId");
		try {
			CloudLBStickinessPolicyVo voParam = null;
			if(!"".equals(configId)){
				voParam = this.cloudLBStickinessPolicyService.get(configId);
			}else{
				voParam = new CloudLBStickinessPolicyVo();
			}
			voParam.setLbruleid(loadRuleId);
			
			String arithmetic = request.getParameter("arithmetic");
			voParam.setMethodname(arithmetic);

			if(arithmetic.equals("AppCookie")){
				voParam.setName("".equals(request.getParameter("AppCookie_name")) ? null : request.getParameter("AppCookie_name"));
				voParam.setCookieName("".equals(request.getParameter("AppCookie_cookieName")) ? null : request.getParameter("AppCookie_cookieName"));
				voParam.setMode("".equals(request.getParameter("AppCookie_modeName")) ? null : request.getParameter("AppCookie_modeName"));
				if(!"".equals(request.getParameter("length"))){
					voParam.setLength(request.getParameter("length"));
				}
				if(!"".equals(request.getParameter("holdtime"))){
					voParam.setHoldtime(request.getParameter("holdtime"));
				}
				if(!"".equals(request.getParameter("requestLearn"))){
					voParam.setRequestLearn(request.getParameter("requestLearn"));
				}
				if(!"".equals(request.getParameter("prefix"))){
					voParam.setPrefix(request.getParameter("prefix"));
				}
				
			}else if(arithmetic.equals("LbCookie")){
				voParam.setName("".equals(request.getParameter("LbCookie_name")) ? null : request.getParameter("LbCookie_name"));
				voParam.setCookieName("".equals(request.getParameter("LbCookie_cookieName")) ? null : request.getParameter("LbCookie_cookieName"));
				voParam.setMode("".equals(request.getParameter("LbCookie_modeName")) ? null : request.getParameter("LbCookie_modeName"));
				if(!"".equals(request.getParameter("nocache"))){
					voParam.setNocache(request.getParameter("nocache"));
				}
				if(!"".equals(request.getParameter("indirect"))){
					voParam.setIndirect(request.getParameter("indirect"));
				}
				if(!"".equals(request.getParameter("postonly"))){
					voParam.setPostonly(request.getParameter("postonly"));
				}
				if(!"".equals(request.getParameter("domain"))){
					voParam.setDomain(request.getParameter("domain"));
				}				

			}else if(arithmetic.equals("SourceBased")){
				voParam.setName(request.getParameter("SourceBased_name"));
				if(!"".equals(request.getParameter("expireTime"))){
					voParam.setExpire(request.getParameter("expireTime"));
				}
				if(!"".equals(request.getParameter("tableSize"))){
					voParam.setTablesize(request.getParameter("tableSize"));
				}
			}else{
				voParam = new CloudLBStickinessPolicyVo();
				voParam.setInterfaceId(configId);
				voParam.setLbruleid(loadRuleId);
			}
			//voParam.init();
			
			this.cloudLBStickinessPolicyService.setStickinessPolicy(voParam);
			modelMap.put("loadRuleMsg", "配置保存成功");
			
		} catch (CloudException e) {
			modelMap.put("loadRuleMsg", "配置保存失败："+e.getMessage());
			e.printStackTrace();
		} catch (ValidatorException e) {
			modelMap.put("loadRuleMsg", "配置保存失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("loadRuleId", loadRuleId);
		return "myresources/myNetwork_highNet_ipAddr_loadConfig";
	}
	
	
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 端口转发
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highPortEdit")
	public String highPortEdit(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {
		
		String ipAddrId = request.getParameter("ipAddrId");
		String networkId = request.getParameter("networkId");
		
		QueryContext context = new ECContext(request, modelMap, "portForwardList");
		context.clearParmeters();
		context.put("$eq_ipaddressid", ipAddrId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> portForwardList = this.cloudPortForwardingRuleService.listByPortForward(context);
		
		modelMap.put("portForwardList", portForwardList);
		modelMap.put("networkId", networkId);
		modelMap.put("ipAddrId", ipAddrId);
		
		return "myresources/myNetwork_highNet_ipAddr_port";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 保存端口转发
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "savePortForward")
	public String savePortForward(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String ipAddrId = request.getParameter("ipAddrId");

		String protocol = request.getParameter("protocol");;
		String privatePortS = request.getParameter("privatePortS");
		String privatePortE = request.getParameter("privatePortE");
		String publicPortS = request.getParameter("publicPortS");
		String publicPortE = request.getParameter("publicPortE");
		String vmId = request.getParameter("vmId");

		try{
			try {
				
				this.cloudPortForwardingRuleService.create(ipAddrId, privatePortS, protocol, publicPortS, vmId, privatePortE, publicPortE);
				modelMap.put("portForwardMsg", "端口转发添加成功");
				
			} catch (ValidatorException e) {
				modelMap.put("portForwardMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
		} catch (CloudException e) {
			modelMap.put("portForwardMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("portForwardList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		modelMap.put("ipAddrId", ipAddrId);
		return "myresources/myNetwork_highNet_ipAddr_port";
	}
	
	/**
	 * 我的网络 - 高级网络 - IP地址维护 - 删除端口转发
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delPortForward")
	public String delPortForward(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String ipAddrId = request.getParameter("ipAddrId");
		String interfaceId = request.getParameter("interfaceId");

		try {
			try {
				this.cloudPortForwardingRuleService.delete(interfaceId);
				modelMap.put("portForwardMsg", "端口转发删除成功");
				
			} catch (ValidatorException e) {
				modelMap.put("portForwardMsg", "失败："+e.getMessage());
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("portForwardMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("portForwardList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		modelMap.put("ipAddrId", ipAddrId);
		return "myresources/myNetwork_highNet_ipAddr_port";
	}
	
	
	
	/**
	 * 我的网络 - 高级网络 - 出口规则维护
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highOutRule")
	public String highOutRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) throws ValidatorException {

		QueryContext context = new ECContext(request, modelMap, "outRoleList");
		context.clearParmeters();
		String networkId = request.getParameter("networkId");
		context.put("$eq_networkid", networkId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> outRoleList = this.cloudMdmEgressFirewallRuleService.list(context);
		
		modelMap.put("outRoleList", outRoleList);
		modelMap.put("networkId", networkId);
		
		return "myresources/myNetwork_highNet_outRuleList";
	}	
	
	/**
	 * 我的网络 - 高级网络 - 保存出口规则信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "saveOutRule")
	public String saveOutRule(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String cidr = request.getParameter("cidr");
		String protocol = request.getParameter("protocol");
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");

		try {
			if("ICMP".equals(protocol)){
				this.cloudMdmEgressFirewallRuleService.create(networkId, cidr, null, null, protocol, val1, val2);
			}else{
				this.cloudMdmEgressFirewallRuleService.create(networkId, cidr, val1, val2, protocol, null, null);
			}
			
			modelMap.put("outRoleMsg", "出口规则添加成功");
		} catch (ValidatorException e) {
			modelMap.put("outRoleMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("outRoleList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_outRuleList";
	}
	
	/**
	 * 我的网络 - 高级网络 - 删除出口规则信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "delOutRule")
	public String delOutRule(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap) {
		String networkId = request.getParameter("networkId");
		String interfaceId = request.getParameter("interfaceId");

		try {
			try {
				this.cloudMdmEgressFirewallRuleService.delete(interfaceId);
				modelMap.put("outRoleMsg", "出口规则删除成功");
				
			} catch (ValidatorException e) {
				e.printStackTrace();
			}
			
		} catch (CloudException e) {
			modelMap.put("outRoleMsg", "失败："+e.getMessage());
			e.printStackTrace();
		}
		
		modelMap.put("outRoleList", new ArrayList<Object>());
		modelMap.put("networkId", networkId);
		return "myresources/myNetwork_highNet_outRuleList";
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vmList")
	public String vmList(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {
		String selectType = request.getParameter("selectType");
		
		if("checkbox".equals(selectType)){
			return "myresources/vmCheckboxList";
		}else{
			return "myresources/vmRadioList";
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * 我的网络 - VPC网络
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vpcNet")
	public String vpcNet(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {

		return "myresources/myNetwork_vpcNet";
	}

	/**
	 * 我的网络 - VPC网络 - 出口规则维护
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vpcOutRule")
	public String vpcOutRule(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {

		return "myresources/myNetwork_vpcNet_outRuleList";
	}

	/**
	 * 我的网络 - VPC网络 - IP地址维护
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "vpcIpAddr")
	public String vpcIpAddr(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {

		return "myresources/myNetwork_vpcNet_ipAddrList";
	}
	
	

	public CloudProductPriceServiceI getCloudProductPriceService() {
		return cloudProductPriceService;
	}

	public void setCloudProductPriceService(
			CloudProductPriceServiceI cloudProductPriceService) {
		this.cloudProductPriceService = cloudProductPriceService;
	}

	public CloudPromotionInfoServiceI getCloudPromotionInfoService() {
		return cloudPromotionInfoService;
	}

	public void setCloudPromotionInfoService(
			CloudPromotionInfoServiceI cloudPromotionInfoService) {
		this.cloudPromotionInfoService = cloudPromotionInfoService;
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

	public CloudMdmNetworkSolnServiceI getCloudMdmNetworkSolnService() {
		return cloudMdmNetworkSolnService;
	}

	public void setCloudMdmNetworkSolnService(
			CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService) {
		this.cloudMdmNetworkSolnService = cloudMdmNetworkSolnService;
	}

	public CloudMdmIPServiceI getCloudMdmIPService() {
		return cloudMdmIPService;
	}

	public void setCloudMdmIPService(CloudMdmIPServiceI cloudMdmIPService) {
		this.cloudMdmIPService = cloudMdmIPService;
	}

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

	public CloudMdmNetworkServiceI getCloudMdmNetworkService() {
		return cloudMdmNetworkService;
	}

	public void setCloudMdmNetworkService(
			CloudMdmNetworkServiceI cloudMdmNetworkService) {
		this.cloudMdmNetworkService = cloudMdmNetworkService;
	}
	
	public CloudMdmEgressFirewallRuleServiceI getCloudMdmEgressFirewallRuleService() {
		return cloudMdmEgressFirewallRuleService;
	}

	public void setCloudMdmEgressFirewallRuleService(
			CloudMdmEgressFirewallRuleServiceI cloudMdmEgressFirewallRuleService) {
		this.cloudMdmEgressFirewallRuleService = cloudMdmEgressFirewallRuleService;
	}

	public CloudMdmFirewallruleServiceI getCloudMdmFirewallruleService() {
		return cloudMdmFirewallruleService;
	}

	public void setCloudMdmFirewallruleService(
			CloudMdmFirewallruleServiceI cloudMdmFirewallruleService) {
		this.cloudMdmFirewallruleService = cloudMdmFirewallruleService;
	}

	public CloudSecurityGroupServiceI getCloudSecurityGroupService() {
		return cloudSecurityGroupService;
	}

	public void setCloudSecurityGroupService(
			CloudSecurityGroupServiceI cloudSecurityGroupService) {
		this.cloudSecurityGroupService = cloudSecurityGroupService;
	}

	public CloudIngressruleServiceI getCloudIngressruleService() {
		return cloudIngressruleService;
	}

	public void setCloudIngressruleService(
			CloudIngressruleServiceI cloudIngressruleService) {
		this.cloudIngressruleService = cloudIngressruleService;
	}

	public CloudEgressruleServiceI getCloudEgressruleService() {
		return cloudEgressruleService;
	}

	public void setCloudEgressruleService(
			CloudEgressruleServiceI cloudEgressruleService) {
		this.cloudEgressruleService = cloudEgressruleService;
	}

	public CloudPortForwardingRuleServiceI getCloudPortForwardingRuleService() {
		return cloudPortForwardingRuleService;
	}

	public void setCloudPortForwardingRuleService(
			CloudPortForwardingRuleServiceI cloudPortForwardingRuleService) {
		this.cloudPortForwardingRuleService = cloudPortForwardingRuleService;
	}

	public CloudVpnUserServiceI getCloudVpnUserService() {
		return cloudVpnUserService;
	}

	public void setCloudVpnUserService(CloudVpnUserServiceI cloudVpnUserService) {
		this.cloudVpnUserService = cloudVpnUserService;
	}

	public CloudRemoteaccessVpnServiceI getCloudRemoteaccessVpnService() {
		return cloudRemoteaccessVpnService;
	}

	public void setCloudRemoteaccessVpnService(
			CloudRemoteaccessVpnServiceI cloudRemoteaccessVpnService) {
		this.cloudRemoteaccessVpnService = cloudRemoteaccessVpnService;
	}

	public CloudPromotionProductServiceI getCloudPromotionProductService() {
		return cloudPromotionProductService;
	}

	public void setCloudPromotionProductService(
			CloudPromotionProductServiceI cloudPromotionProductService) {
		this.cloudPromotionProductService = cloudPromotionProductService;
	}

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}

	public CloudUserOrderItemServiceI getCloudUserOrderItemService() {
		return cloudUserOrderItemService;
	}

	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}

	public CloudMdmNicServiceI getCloudMdmNicService() {
		return cloudMdmNicService;
	}

	public void setCloudMdmNicService(CloudMdmNicServiceI cloudMdmNicService) {
		this.cloudMdmNicService = cloudMdmNicService;
	}

	public CloudLoadbalancerruleServiceI getCloudLoadbalancerruleService() {
		return cloudLoadbalancerruleService;
	}

	public void setCloudLoadbalancerruleService(
			CloudLoadbalancerruleServiceI cloudLoadbalancerruleService) {
		this.cloudLoadbalancerruleService = cloudLoadbalancerruleService;
	}

	public CloudLoadBalancerRuleInstanceServiceI getCloudLoadBalancerRuleInstanceService() {
		return cloudLoadBalancerRuleInstanceService;
	}

	public void setCloudLoadBalancerRuleInstanceService(
			CloudLoadBalancerRuleInstanceServiceI cloudLoadBalancerRuleInstanceService) {
		this.cloudLoadBalancerRuleInstanceService = cloudLoadBalancerRuleInstanceService;
	}

	public CloudLBStickinessPolicyServiceI getCloudLBStickinessPolicyService() {
		return cloudLBStickinessPolicyService;
	}

	public void setCloudLBStickinessPolicyService(
			CloudLBStickinessPolicyServiceI cloudLBStickinessPolicyService) {
		this.cloudLBStickinessPolicyService = cloudLBStickinessPolicyService;
	}
	
}
