package sy.controller.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.BaseConfigurator;
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.StringUtil;
import sy.common.util.StringUtils;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.entity.NetworkType;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.product.CloudMdmNetworkVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.domain.vo.product.CloudMdmZoneVo;
import sy.domain.vo.product.CloudOrderApprovalVo;
import sy.domain.vo.product.CloudProductCustomBuyVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.domain.vo.product.CloudSecurityGroupVo;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.domain.vo.promotion.CloudPromotionValue;
import sy.service.core.MailServiceI;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.product.CloudMdmCPUSolnServiceI;
import sy.service.product.CloudMdmDiskSolnServiceI;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudMdmTemplateServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmZoneServiceI;
import sy.service.product.CloudOrderAppprovalServiceI;
import sy.service.product.CloudSecurityGroupServiceI;
import sy.service.product.CloudUserOrderItemServiceI;
import sy.service.product.CloudUserOrderServiceI;
import sy.service.promotion.CloudPromotionInfoServiceI;
import sy.service.promotion.CloudPromotionProductServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 产品购买-自定义购买
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/customBuy")
@SessionAttributes("cloudProductCustomBuyVo")
public class ProductCustomBuyController extends BaseControllerTemplate<CloudUserOrderVo> {

	/**
	 * 产品购买-自定义购买-选择数据中心
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectDc")
	public String selectDc(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		try {
			
			//CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
			this.remomveCurCustomBuyVo(request);
			CloudProductCustomBuyVo customBuyVo = new CloudProductCustomBuyVo();
			List<CloudMdmZoneVo> mdmZoneList = this.getCloudMdmZoneService().getAllMdmZoneList();
			request.setAttribute("mdmZoneList", mdmZoneList);
			modelMap.put("cloudProductCustomBuyVo", customBuyVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "product/productCustomBuy_selectDc";
	}
	
	/**
	 * 产品购买-自定义购买-选择数据中心(购买流程后退返回选择数据中心)
	 */
	@RequestMapping(value = "selectDcBack")
	public String selectDcBack(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		try {
			CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
			List<CloudMdmZoneVo> mdmZoneList = this.getCloudMdmZoneService().getAllMdmZoneList();
			request.setAttribute("mdmZoneList", mdmZoneList);
			modelMap.put("cloudProductCustomBuyVo", customBuyVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "product/productCustomBuy_selectDc";
	}

	/**
	 * 产品购买-自定义购买-选择网络（高级 网络）
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectNet")
	public String selectNet(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) throws ValidatorException{
		String selectNetUrl="";
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		customBuyVo.setMdmZoneId(vo.getMdmZoneId());
		CloudMdmZoneVo cloudMdmZoneVo = this.cloudMdmZoneService.findZone(vo.getMdmZoneId());
		customBuyVo.setZoneName(cloudMdmZoneVo.getName());
		this.putCurCustomBuyVo(request, customBuyVo);
		
		//选择安全组（基础网络）
		if (cloudMdmZoneVo.getNetworkType().equalsIgnoreCase(NetworkType.Basic.toString())){
			List<CloudSecurityGroupVo> securityGroupList = new ArrayList<CloudSecurityGroupVo>();
			try {
				securityGroupList = this.cloudSecurityGroupService
						.getSecurityGroupListByAccount(this.getCurAccountName(request));
				request.setAttribute("securityGroupList", securityGroupList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			selectNetUrl = "product/productCustomBuy_selectSecurityGroup";
		} else {
			QueryContext context = new ECContext(request, modelMap, "addNet");
			context.clearParmeters();
			context.put("$eq_networkType", NetworkType.Advanced.toString());
			List<?> dclist = this.cloudMdmZoneService.list(context);
			modelMap.put("dclist", dclist);
			
			String zoneId = request.getParameter("zoneId");
			List<?> netWorklist = this.cloudMdmProductItemService.getNetworkSingleProd(zoneId);
			modelMap.put("netWorklist", netWorklist);
			modelMap.put("zoneId", zoneId);
			//----------------------------------
			List<CloudMdmNetworkVo> networkList = new ArrayList<CloudMdmNetworkVo>();
			try {
				networkList = this.cloudMdmNetworkService
						.getNetworkByZoneAccount(vo.getMdmZoneId(), this.getCurAccountName(request));
				request.setAttribute("networkList", networkList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			selectNetUrl = "product/productCustomBuy_selectNet";
		}
		
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		
		return selectNetUrl;
	}
	
	
	/**
	 * 产品购买-自定义购买-选择模板
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectTemplate")
	public String selectTemplate(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		customBuyVo.setSecurityGroupId(vo.getSecurityGroupId());
		/*customBuyVo.setNewNetFlag(request.getParameter("newNetFlag"));*/
		customBuyVo.setNetworkName(vo.getNetworkName());
		customBuyVo.setDescription(vo.getDescription());
		this.putCurCustomBuyVo(request, customBuyVo);
		
		List<Object[]> templateList = new ArrayList<Object[]>();
		try {
			templateList = this.cloudMdmProductItemService.getTemplateSingleProd(vo.getMdmZoneId());
			request.setAttribute("templateList", templateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		
		return "product/productCustomBuy_selectTemplate";
	}

	/**
	 * 产品购买-自定义购买-选择计算资源
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "computResource")
	public String computResource(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		customBuyVo.setProdTemplateId(vo.getProdTemplateId());
		this.putCurCustomBuyVo(request, customBuyVo);
		
		List<Object[]> cpuSolnList = new ArrayList<Object[]>();
		try {
			cpuSolnList = this.cloudMdmProductItemService.getCpuSolnSingleProd();
			request.setAttribute("cpuSolnList", cpuSolnList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		
		return "product/productCustomBuy_computResource";
	}

	/**
	 * 产品购买-自定义购买-选择磁盘资源
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "diskResource")
	public String diskResource(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		customBuyVo.setProdCpuSolnId(vo.getProdCpuSolnId());
		this.putCurCustomBuyVo(request, customBuyVo);
		
		List<Object[]> diskSolnList = new ArrayList<Object[]>();
		try {
			diskSolnList = this.cloudMdmProductItemService.getDiskSolnSingleProd();
			request.setAttribute("diskSolnList", diskSolnList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		
		return "product/productCustomBuy_diskResource";
	}

	/**
	 * 产品购买-自定义购买-选择网络方案
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "networkSolution")
	public String networkSolution(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {

		return "product/productCustomBuy_networkSolution";
	}

	/**
	 * 产品购买-自定义购买-选择主机配置
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "hostConfig")
	public String hostConfig(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap ) {
		
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		customBuyVo.setProdDiskSolnId(vo.getProdDiskSolnId());
		this.putCurCustomBuyVo(request, customBuyVo);
		
		try {
			CloudProductDetail prodDisk = this.cloudMdmDiskSolnService.getCloudMdmDiskSolnByProdId(vo.getProdDiskSolnId());
			customBuyVo.setProdDisk(prodDisk);
			//modelMap.put("prodDisk", prodDisk);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		
		
		return "product/productCustomBuy_hostConfig";

	}

	
	/**
	 * 产品购买-自定义购买-信息确认
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "infoConfirm")
	public String infoConfirm(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap , BindingResult errors) {
		
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		
		if(StringUtils.isBlank(vo.getHostAmount())){
			errors.rejectValue("hostAmount",null, "主机数量不能为空!");
			return "product/productCustomBuy_hostConfig";
		} else {
			if(!StringUtil.isNumberStr(vo.getHostAmount())){
				errors.rejectValue("hostAmount",null, "主机数量必须为数字!");
				return "product/productCustomBuy_hostConfig";
			}
		}
		
		if(StringUtils.isBlank(vo.getHostName())){
			errors.rejectValue("hostName",null, "主机名称不能为空!");
			return "product/productCustomBuy_hostConfig";
		} else {
			if (!vo.getHostName().matches("[0-9A-Za-z-]*")) {
				errors.rejectValue("hostName",null, "主机名称只能由字母、数字组成!");
				return "product/productCustomBuy_hostConfig";
			}
		}
		
		try {
			CloudProductDetail prodDisk = this.cloudMdmDiskSolnService.getCloudMdmDiskSolnByProdId(vo.getProdDiskSolnId());
			if(null != prodDisk && null != prodDisk.getCustomized() && prodDisk.getCustomized().equals("true")){
				if(StringUtils.isBlank(vo.getDiskSize())){
					modelMap.put("prodDisk", prodDisk);
					errors.rejectValue("diskSize",null, "自定义磁盘大小不能为空!");
					return "product/productCustomBuy_hostConfig";
				} else {
					if(!StringUtil.isNumberStr(vo.getDiskSize())){
						errors.rejectValue("diskSize",null, "自定义磁盘大小必须为数字!");
						return "product/productCustomBuy_hostConfig";
					}
				}
				customBuyVo.setDiskSize(vo.getDiskSize());
			}
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		
		
		if(StringUtils.isBlank(vo.getStopHostTime())){
			//errors.rejectValue("stopHostTime",null, "停机时间不能为空!");
			//return "product/productCustomBuy_hostConfig";
		}
		
		//检查主机名称是否已被使用
		Integer vmNumber = Integer.parseInt(vo.getHostAmount());
		String vmName = "";
		String accountId = this.getCurrentParentUser(request).getUserId();
		if (vmNumber==1) {
			vmName = customBuyVo.getHostName();
			if (this.cloudUserOrderService.checkVmNameIsExist(vmName, accountId)){
				errors.rejectValue("hostName",null, "该主机名称已被使用，请重新命名!");
				return "product/productCustomBuy_hostConfig";
			}
		} else {
			for (int i =1 ; i<=vmNumber; i++){
				vmName = customBuyVo.getHostName() + i ;
				if (this.cloudUserOrderService.checkVmNameIsExist(vmName, accountId)){
					errors.rejectValue("hostName",null, "该主机名称已被使用，请重新命名!");
					return "product/productCustomBuy_hostConfig";
				}
			}
		}
		
		
		customBuyVo.setHostAmount(vo.getHostAmount());
		customBuyVo.setHostName(vo.getHostName());
		customBuyVo.setStopHostTime(vo.getStopHostTime());
		customBuyVo.setIpAllocatType(vo.getIpAllocatType());
		
		HashMap<String, Object> orderItemMap =new HashMap<String,Object>();
		customBuyVo.clearPriceInfo();
		try {
			//数据中心
			CloudMdmZoneVo cloudMdmZoneVo = this.cloudMdmZoneService.findZone(vo.getMdmZoneId());
			orderItemMap.put("zone", cloudMdmZoneVo);
			customBuyVo.setZoneInterfaceId(cloudMdmZoneVo.getInterfaceId());
			//网络
			if (null != customBuyVo.getNetIds()){
				String netIdArray[] = customBuyVo.getNetIds().split(",");
				for (int i = 0 ; i < netIdArray.length; i++){
					if (null != netIdArray[i] && netIdArray[i].trim().length()>0) {
						CloudMdmNetworkVo cloudMdmNetworkVo = this.cloudMdmNetworkService.getMdmNetworkVoByid(netIdArray[i].trim());
						customBuyVo.addMdmNetWork(cloudMdmNetworkVo);
						if (StringUtils.isNotBlank(customBuyVo.getNetInterfaceIds())) {
							customBuyVo.setNetInterfaceIds(customBuyVo.getNetInterfaceIds() + "," + cloudMdmNetworkVo.getInterfaceId());
						} else {
							customBuyVo.setNetInterfaceIds(cloudMdmNetworkVo.getInterfaceId());
						}
					}
				}
			}
			//安全组
			CloudSecurityGroupVo CloudSecurityGroupVo = this.cloudSecurityGroupService.getSecurityGroupByID(vo.getSecurityGroupId());
			orderItemMap.put("securityGroup", CloudSecurityGroupVo);
			//模板
			CloudProductDetail prodTemplate = this.cloudMdmTemplateService.getCloudMdmTemplateByProdId(vo.getProdTemplateId());
			orderItemMap.put("template", prodTemplate);
			addToCountPrice(prodTemplate, customBuyVo);
			//计算资源
			CloudProductDetail prodCpu = this.cloudMdmCPUSolnService.getCloudMdmCPUSolnDetailByProdId(vo.getProdCpuSolnId());
			orderItemMap.put("cpu", prodCpu);
			addToCountPrice(prodCpu, customBuyVo);
			//磁盘资源
			CloudProductDetail prodDisk = this.cloudMdmDiskSolnService.getCloudMdmDiskSolnByProdId(vo.getProdDiskSolnId());
			if( null != prodDisk && null!=prodDisk.getCustomized() && prodDisk.getCustomized().equals("true")){
				if (null != prodDisk.getOneTimePrice()){
					prodDisk.setOneTimePrice(Integer.parseInt(customBuyVo.getDiskSize())/10 * prodDisk.getOneTimePrice());
				}
				if (null != prodDisk.getYearPrice()){
					prodDisk.setYearPrice(Integer.parseInt(customBuyVo.getDiskSize())/10 * prodDisk.getYearPrice());				
				}
				if (null != prodDisk.getMonthPrice()){
					prodDisk.setMonthPrice(Integer.parseInt(customBuyVo.getDiskSize())/10 * prodDisk.getMonthPrice());
				}
				if (null != prodDisk.getDayPrice()){
					prodDisk.setDayPrice(Integer.parseInt(customBuyVo.getDiskSize())/10 * prodDisk.getDayPrice());
				}
			}
			orderItemMap.put("disk", prodDisk);
			addToCountPrice(prodDisk, customBuyVo);
			
			//选择基础网络
			if (cloudMdmZoneVo.getNetworkType().equalsIgnoreCase(NetworkType.Basic.toString())){
				//基础网络上购买虚拟机 自动 购入IP
				CloudProductDetail ip = this.cloudMdmIPService.getCloudMdmIpProduct();
				orderItemMap.put("ip", ip);
				addToCountPrice(ip, customBuyVo);
				
				//设置安全组 ID
				if (null != CloudSecurityGroupVo){
					customBuyVo.setNetIds(CloudSecurityGroupVo.getInterfaceId());
					customBuyVo.setNetInterfaceIds(CloudSecurityGroupVo.getInterfaceId());
				}
			} else {
				//设置网络 ID
				//如果是账户，是否新建网络
				/*if(this.getCurrentUser(request).getUserFlag().equals(Constants.USER_FLAG_ACCOUNT)){
					if(null != customBuyVo.getNewNetFlag() && customBuyVo.getNewNetFlag().equals("1")){
						CloudMdmNetworkVo cloudMdmNetworkAddVo = this.addHighNet(request,customBuyVo);
					}
				}*/
			}
			
			
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		this.putCurCustomBuyVo(request, customBuyVo);
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		request.getSession().setAttribute("orderItemMap", orderItemMap);
		genResApproReqEmailInfo(orderItemMap,customBuyVo,this.getCurrentUser(request));
		
		return "product/productCustomBuy_infoConfirm";
	}
	
	/**
	 * 产品购买-自定义购买-选择计费
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectBilling")
	public String selectBilling(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		//选择计费
		return "product/productCustomBuy_selectBilling";
	}	

	/**
	 * 产品购买-自定义购买-购买完毕
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "finishBuy")
	public String finishBuy(HttpServletRequest request,
			HttpServletResponse response, CloudProductCustomBuyVo vo, ModelMap modelMap) {
		
		CloudProductCustomBuyVo customBuyVo = this.getCurCustomBuyVo(request);
		customBuyVo.setBillingCycle(vo.getBillingCycle());
		
		//创建新网络
		/*if(this.getCurrentUser(request).getUserFlag().equals(Constants.USER_FLAG_ACCOUNT)){
			if(null != customBuyVo.getNewNetFlag() && customBuyVo.getNewNetFlag().equals("1")){
				try {
					CloudMdmNetworkVo cloudMdmNetworkAddVo = this.addHighNet(request,customBuyVo);
					if (StringUtils.isNotBlank(customBuyVo.getNetInterfaceIds())) {
						customBuyVo.setNetInterfaceIds(customBuyVo.getNetInterfaceIds() + "," + cloudMdmNetworkAddVo.getInterfaceId());
					} else {
						customBuyVo.setNetInterfaceIds(cloudMdmNetworkAddVo.getInterfaceId());
					}
				} catch (Exception e) {
					e.printStackTrace();
					customBuyVo.setIsSuccessCreateVm("0");
					customBuyVo.setErroInfo("自定义购买失败：" + e.getMessage());
					modelMap.put("cloudProductCustomBuyVo", customBuyVo);
					return "product/productCustomBuy_finishBuy"; 
				}
			}
		}*/
		
		//创建主机数量
		Integer vmNumber = Integer.parseInt(vo.getHostAmount());
		this.putCurCustomBuyVo(request, customBuyVo);
		
		//此次购买涉及的总金额
		CloudUserOrderVo order = genCloudUserOrderVo(request,customBuyVo);
		Double  orderTotalPrice = vmNumber * (order.getOneTimeRebateAmount()+order.getCycleRebateAmount());
		//检查账户余额够不够
		 AccountExpenseVo expVo = this.accountExpenseService.getExpenseByUserId(this.getCurrentParentUser(request).getUserId());
		 if(expVo == null || (expVo.getPayTotalAmount()- expVo.getExpTotalAmount()) < Double.valueOf(orderTotalPrice)){ //
			 modelMap.put("orderAddMsg", "购买虚拟机失败，账户费用不足，请充值。");
			 modelMap.put("cloudProductCustomBuyVo", customBuyVo);
			 return "product/productCustomBuy_selectBilling"; 
		 }
		
		//创建订单
		HashMap<String, Object> orderItemMap = getOrderItemMap(request);
		
		CloudProductDetail prodTemplate = null;
		CloudProductDetail prodCpu = null;
		CloudProductDetail prodDisk = null;
		
		List<CloudUserOrderVo> lstOrderList = new ArrayList<CloudUserOrderVo>();
		List<CloudOrderApprovalVo> lstOrdeApprovalList = new ArrayList<CloudOrderApprovalVo>();
		try {
			for (int i =1 ; i<=vmNumber; i++){
				order = genCloudUserOrderVo(request,customBuyVo);
				if (vmNumber==1) {
					order.setVmName(customBuyVo.getHostName());
				} else {
					order.setVmName(customBuyVo.getHostName() + i);
				}
				List<CloudUserOrderItemVo> lstOrderItem = new ArrayList<CloudUserOrderItemVo>();
				//模板
				prodTemplate = (CloudProductDetail)orderItemMap.get("template");			
				CloudUserOrderItemVo orderItemTemplate = genCloudUserOrderItemVo(prodTemplate,customBuyVo);
				orderItemTemplate.setProdType(Constants.PROD_TYPE_TEMPLATE);
				lstOrderItem.add(orderItemTemplate);
				//计算资源
				prodCpu = (CloudProductDetail)orderItemMap.get("cpu");
				CloudUserOrderItemVo orderItemCpu = genCloudUserOrderItemVo(prodCpu,customBuyVo);
				orderItemCpu.setProdType(Constants.PROD_TYPE_CPU_SOLN);
				lstOrderItem.add(orderItemCpu);
				//磁盘资源
				prodDisk = (CloudProductDetail)orderItemMap.get("disk");
				if (null != prodDisk) {
					prodDisk.setDiskSize(customBuyVo.getDiskSize());
					CloudUserOrderItemVo orderItemDisk = genCloudUserOrderItemVo(prodDisk,customBuyVo);
					orderItemDisk.setProdType(Constants.PROD_TYPE_DISK_SOLN);
					lstOrderItem.add(orderItemDisk);
				}
				
				//基础网络上购买虚拟机 自动 购入IP
				CloudMdmZoneVo cloudMdmZoneVo = (CloudMdmZoneVo)orderItemMap.get("zone");
				if (cloudMdmZoneVo.getNetworkType().equalsIgnoreCase(NetworkType.Basic.toString())){
					CloudProductDetail prodIp = (CloudProductDetail)orderItemMap.get("ip");	
					CloudUserOrderItemVo orderItemIp = genCloudUserOrderItemVo(prodIp,customBuyVo);
					orderItemIp.setProdType(Constants.PROD_TYPE_IP);
					lstOrderItem.add(orderItemIp);
				}
				
				this.cloudUserOrderService.saveOrderAndItems(order, lstOrderItem);
				lstOrderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			customBuyVo.setIsSuccessCreateVm("0");
			customBuyVo.setErroInfo("创建虚拟机失败：" + e.getMessage());
			modelMap.put("cloudProductCustomBuyVo", customBuyVo);
			return "product/productCustomBuy_finishBuy"; 
		} 
		
		//插入资源审批表
		try {
			for (CloudUserOrderVo orderVo : lstOrderList) {
				CloudOrderApprovalVo cloudOrderAppprovalVo = new CloudOrderApprovalVo();
				cloudOrderAppprovalVo.setCloudUserOrder(orderVo);
				cloudOrderAppprovalVo.setBasicUser(this.getCurrentUser(request));
				cloudOrderAppprovalVo.setBasicAccount(this.getCurrentParentUser(request));
				if(this.getCurrentUser(request).getUserFlag().equals(Constants.USER_FLAG_ACCOUNT)){
					cloudOrderAppprovalVo.setApprovalFlag("1");
				} else {
					cloudOrderAppprovalVo.setApprovalFlag("0");
				}
				cloudOrderAppprovalVo.setCloudCpuSoln(this.cloudMdmCPUSolnService.getMdmCPUSolnByInterfaceId(prodCpu.getInterfaceId()));
				if (null != prodDisk) {
					cloudOrderAppprovalVo.setCloudMdmDiskSoln(this.cloudMdmDiskSolnService.getMdmDiskSolnByInterfaceId(prodDisk.getInterfaceId()));
				}
				cloudOrderAppprovalVo.setCloudMdmTemplate(this.cloudMdmTemplateService.getMdmTemplateByInterfaceId(prodTemplate.getInterfaceId()));
				cloudOrderAppprovalVo.setNetIds(orderVo.getNetIds());
				cloudOrderAppprovalVo.setCloudMdmZone((CloudMdmZoneVo)orderItemMap.get("zone"));
				cloudOrderAppprovalVo.setCreated(new Date());
				cloudOrderAppprovalVo.setCreatedBy(this.getCurrentUser(request).getUserName());
				if(null != customBuyVo.getStopHostTime() && StringUtils.isNotBlank(customBuyVo.getStopHostTime())) {
					cloudOrderAppprovalVo.setStopTime(DateUtil.convertDateTime(customBuyVo.getStopHostTime()));
				}
				if (null != prodDisk && null !=prodDisk.getCustomized() && prodDisk.getCustomized().equals("true")){
					cloudOrderAppprovalVo.setDiskSize(Double.parseDouble(customBuyVo.getDiskSize()));
				} else {
					cloudOrderAppprovalVo.setDiskSize(0D);
				}
				cloudOrderAppprovalVo.setVmName(orderVo.getVmName());
				this.cloudOrderAppprovalService.save(cloudOrderAppprovalVo);
				lstOrdeApprovalList.add(cloudOrderAppprovalVo);
			}
		} catch (ValidatorException e) {
			customBuyVo.setIsSuccessCreateVm("0");
			customBuyVo.setErroInfo("创建虚拟机失败：" + e.getMessage());
			modelMap.put("cloudProductCustomBuyVo", customBuyVo);
			return "product/productCustomBuy_finishBuy"; 
		}
		
		Integer successVmNumber=0, failVmNumber=0;
		boolean isSuccessCreateVm = false;
		StringBuilder errInfo = new StringBuilder();
		//账户直接创建虚拟机
		try {
			
			if(this.getCurrentUser(request).getUserFlag().equals(Constants.USER_FLAG_ACCOUNT)){
				for (CloudOrderApprovalVo item : lstOrdeApprovalList) {
					List<String> lstNetIds =new ArrayList<String>();
					if (null != item.getNetIds()) {
						String[] netIdsArr = item.getNetIds().split(",");
						for(String str : netIdsArr) {
							lstNetIds.add(str);
						}
					}
					CloudMdmVmVo vm = this.cloudMdmVMService.create(item.getBasicAccount().getUserAccount()
								, item.getCloudMdmZone().getInterfaceId()
								, item.getCloudCpuSoln().getInterfaceId()
								, item.getCloudMdmDiskSoln()!=null ? item.getCloudMdmDiskSoln().getInterfaceId() : null
								, item.getCloudMdmTemplate().getInterfaceId()
								, lstNetIds
								, item.getVmName()
								, item.getDiskSize().intValue()
								, item.getStopTime());
					if ( null != vm) {
						CloudUserOrderVo userOrder = item.getCloudUserOrder();
						userOrder.setState("1");
						userOrder.setCloudMdmVm(vm);
						userOrder.setBillingFlag(1);
						this.cloudUserOrderService.save(userOrder);
						
						List<CloudUserOrderItemVo> orderItems = this.cloudUserOrderItemService.getOrderItemsByOrderId(userOrder.getOrderId());
						for (CloudUserOrderItemVo orderitem : orderItems) {
							orderitem.setBillingFlag(1);
							this.cloudUserOrderItemService.save(orderitem);
						}
						
					}
					successVmNumber ++;
					isSuccessCreateVm =true;
				}
				
			} 
			
		} catch (CloudException e) {
			failVmNumber ++;
			errInfo.append("<br/> " + e.toString() );
			e.printStackTrace();
		} catch (ValidatorException e) {
			failVmNumber ++;
			errInfo.append("<br/> " + e.toString() );
			e.printStackTrace();
		}
		
		if(this.getCurrentUser(request).getUserFlag().equals(Constants.USER_FLAG_ACCOUNT)){
			if ( vmNumber == successVmNumber) {
				//全部创建成功
				customBuyVo.setIsSuccessCreateVm("1");
				customBuyVo.setSuccessVmNumber(successVmNumber.toString());
				customBuyVo.setFailVmNumber("0");
				
			} else if (isSuccessCreateVm) {
				//部分虚机创建成功
				customBuyVo.setIsSuccessCreateVm("2");
				customBuyVo.setSuccessVmNumber(successVmNumber.toString());
				customBuyVo.setFailVmNumber(failVmNumber.toString());
				customBuyVo.setErroInfo(errInfo.toString());
			} else {
				customBuyVo.setIsSuccessCreateVm("0");
				customBuyVo.setErroInfo(errInfo.toString());
			}
		} else {
			customBuyVo.setIsSuccessCreateVm("3");
			//用户购买，发送 申请审批 邮件给账户
			try {
				mailService.sendMail(
						this.getCurrentParentUser(request).getUserAccount(),
						"",
						BaseConfigurator.getInstance().getCompanyName() + " 虚机购买，申请审批",
						resApproReqEmailInfo.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		modelMap.put("cloudProductCustomBuyVo", customBuyVo);
		return "product/productCustomBuy_finishBuy"; 
		
	}
	
	private void putCurCustomBuyVo(HttpServletRequest request,CloudProductCustomBuyVo vo) {
		getSession(request).setAttribute("customBuyVo", vo);
	}
	
	private void remomveCurCustomBuyVo(HttpServletRequest request) {
		getSession(request).removeAttribute("customBuyVo");
	}
	
	
	private CloudProductCustomBuyVo getCurCustomBuyVo(HttpServletRequest request) {
		CloudProductCustomBuyVo customBuyVo = (CloudProductCustomBuyVo)getSession(request).getAttribute("customBuyVo");
		if (null == customBuyVo) {
			customBuyVo = new CloudProductCustomBuyVo();
			getSession(request).setAttribute("customBuyVo", customBuyVo);
		}
		return customBuyVo;
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Object> getOrderItemMap(HttpServletRequest request) {
		HashMap<String, Object> orderItemMap = (HashMap<String, Object>) getSession(request).getAttribute("orderItemMap"); 
		return orderItemMap;
	}
	
	
	private CloudUserOrderItemVo genCloudUserOrderItemVo(CloudProductDetail prodDetail, CloudProductCustomBuyVo customBuyVo) throws Exception{
		CloudUserOrderItemVo orderItemVo = new CloudUserOrderItemVo();
		orderItemVo.setPromotionId(prodDetail.getPromotionId());
		//orderItemVo.setActivityName(prodDetail.getActivityName());
		orderItemVo.setRebateFlag(prodDetail.getRebateFlag());
		orderItemVo.setRebateAmount(prodDetail.getRebateAmount());
		//orderItemVo.setPromotionStartDate(prodDetail.getStartDate());
		//orderItemVo.setPromotionEndDate(prodDetail.getEndDate());
		if(null != prodDetail.getDiskSize()) {
			orderItemVo.setDiskSize(Double.parseDouble(prodDetail.getDiskSize()));
		}
		CloudMdmProductVo mdmProduct = this.cloudMdmProductService.get(prodDetail.getProdId());
		orderItemVo.setCloudMdmProduct(mdmProduct);
		orderItemVo.setCloudMdmProductItem(this.cloudMdmProductItemService.getprodItemByProdItemId(prodDetail.getProdItemId()));
		
		if (null != customBuyVo.getBillingCycle()) {
			if (customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_DAY)
					||customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_MONTH)
					||customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_YEAR)
					||customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_HOUR)) {
				
				if(prodDetail.getPriceMode().equals(Constants.PRICE_MODE_ONE_TIME)){
					orderItemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
				} else {
					orderItemVo.setBillingType(Constants.BILLING_TYPE_CYCLE);
				}
				
			} else {
				orderItemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
			}
		} else {
			orderItemVo.setBillingType(Constants.BILLING_TYPE_SINGLE);
		}
		
		orderItemVo.setOneTimeBillingFlag(0);
		orderItemVo.setBillingFlag(0);
		orderItemVo.setBeginBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
		orderItemVo.setNextBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
		//orderItemVo.setResDestroyTime(DateUtil.convertDateTime(customBuyVo.getStopHostTime()));
		if(prodDetail.getPriceMode().equals(Constants.PRICE_MODE_ONE_TIME)){
			//orderItemVo.setProdDetailPrice(prodDetail.getOneTimePrice());
			//orderItemVo.setProdRebatePrice(prodDetail.getOneTimeRebatePrice());
		} else if(null != customBuyVo.getBillingCycle() && customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_YEAR)){
			//orderItemVo.setProdDetailPrice(prodDetail.getYearPrice());
			//orderItemVo.setProdRebatePrice(prodDetail.getYearRebatePrice());
		} else if(null != customBuyVo.getBillingCycle() && customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_MONTH)){
			//orderItemVo.setProdDetailPrice(prodDetail.getMonthPrice());
			//orderItemVo.setProdRebatePrice(prodDetail.getMonthRebatePrice());
		} else if(null != customBuyVo.getBillingCycle() && customBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_DAY)){
			//orderItemVo.setProdDetailPrice(prodDetail.getDayPrice());
			//orderItemVo.setProdRebatePrice(prodDetail.getDayRebatePrice());
		}
		
		return orderItemVo;
	}
	
	private CloudUserOrderVo genCloudUserOrderVo(HttpServletRequest request, CloudProductCustomBuyVo custBuyVo){
		CloudUserOrderVo order = new CloudUserOrderVo();
		order.setBasicUser(this.getCurrentUser(request));
		order.setBasicAccount(this.getCurrentParentUser(request));
		order.setBillingCycle(custBuyVo.getBillingCycle());
		order.setBuyType(Constants.PROD_BUY_CUSTOM);
		order.setBillingFlag(0);
		order.setOrderTime(new Date());
		order.setNetIds(custBuyVo.getNetInterfaceIds());
		order.setOneTimeProdAmount(custBuyVo.getOneTimePrice());
		order.setOneTimeRebateAmount(custBuyVo.getOneTimeRebatePrice());
		order.setBeginBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
		order.setNextBillingTime(DateUtil.convertDate(DateUtil.formatDate(DateUtil.getAfterDay(new Date(),1))));
		order.setState("0");
		order.setOrderType(3);
		order.setCreated(new Date());
		order.setCreatedBy(this.getCurrentUser(request).getUserName());
		order.setCreateId(this.getCurrentUser(request).getUserId());
		
		if(null != custBuyVo.getBillingCycle()) {
			if(custBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_YEAR)){
				order.setCycleOrderAmount(custBuyVo.getYearPrice());
				order.setCycleRebateAmount(custBuyVo.getYearRebatePrice());
			} else if(custBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_MONTH)){
				order.setCycleOrderAmount(custBuyVo.getMonthPrice());
				order.setCycleRebateAmount(custBuyVo.getMonthRebatePrice());
			} else if(custBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_DAY)){
				order.setCycleOrderAmount(custBuyVo.getDayPrice());
				order.setCycleRebateAmount(custBuyVo.getDayRebatePrice());
			}  else if(custBuyVo.getBillingCycle().equals(Constants.BILLING_CYCLE_HOUR)){
				order.setCycleOrderAmount(custBuyVo.getHourPrice());
				order.setCycleRebateAmount(custBuyVo.getHourRebatePrice());
			}
		}
		return order;
	}
	
	private void addToCountPrice(CloudProductDetail prodItem, CloudProductCustomBuyVo custBuyVo) {
		if (null == prodItem) {
			return;
		}
		CloudPromotionValue  promValue;
		
		// 一次性收费
		if ("0".equals(prodItem.getPriceMode())) {
			custBuyVo.setIsHaveOneTimePrice("1");
			//一次性收费 促销
			promValue = this.cloudPromotionProductService.getDiscountAmountByProdId(prodItem.getProdId(), prodItem.getOneTimePrice());
			if (null != promValue){
				prodItem.setOneTimeRebatePrice(promValue.getDiscountAmount());
				addPromotionToProdItem(prodItem, promValue);
			} else {
				prodItem.setOneTimeRebatePrice(prodItem.getOneTimePrice());
			}
			custBuyVo.addOneTimePriceProd(prodItem);
			custBuyVo.setOneTimePrice(custBuyVo.getOneTimePrice()+prodItem.getOneTimePrice());
			custBuyVo.setOneTimeRebatePrice(custBuyVo.getOneTimeRebatePrice()+prodItem.getOneTimeRebatePrice());
			
		} else {
			custBuyVo.setIsHaveCyclePrice("1");
			//日价格促销
			custBuyVo.setDayPrice(custBuyVo.getDayPrice()+prodItem.getDayPrice());
			promValue = this.cloudPromotionProductService.getDiscountAmountByProdId(prodItem.getProdId(), prodItem.getDayPrice());
			if (null != promValue){
				prodItem.setDayRebatePrice(promValue.getDiscountAmount());
				addPromotionToProdItem(prodItem, promValue);
			} else {
				prodItem.setDayRebatePrice(prodItem.getDayPrice());
			}
			custBuyVo.setDayRebatePrice(custBuyVo.getDayRebatePrice()+prodItem.getDayRebatePrice());
			
			//月价格促销
			custBuyVo.setMonthPrice(custBuyVo.getMonthPrice()+prodItem.getMonthPrice());
			promValue = this.cloudPromotionProductService.getDiscountAmountByProdId(prodItem.getProdId(), prodItem.getMonthPrice());
			if (null != promValue){
				prodItem.setMonthRebatePrice(promValue.getDiscountAmount());
				addPromotionToProdItem(prodItem, promValue);
			} else {
				prodItem.setMonthRebatePrice(prodItem.getMonthPrice());
			}
			custBuyVo.setMonthRebatePrice(custBuyVo.getMonthRebatePrice()+prodItem.getMonthRebatePrice());
			
			//年价格促销
			custBuyVo.setYearPrice(custBuyVo.getYearPrice()+prodItem.getYearPrice());
			promValue = this.cloudPromotionProductService.getDiscountAmountByProdId(prodItem.getProdId(), prodItem.getYearPrice());
			if (null != promValue){
				prodItem.setYearRebatePrice(promValue.getDiscountAmount());
				addPromotionToProdItem(prodItem, promValue);
			} else {
				prodItem.setYearRebatePrice(prodItem.getYearPrice());
			}
			custBuyVo.setYearRebatePrice(custBuyVo.getYearRebatePrice()+prodItem.getYearRebatePrice());
			
			//小时价格促销
			custBuyVo.setHourPrice(custBuyVo.getHourPrice()+prodItem.getHourPrice());
			promValue = this.cloudPromotionProductService.getDiscountAmountByProdId(prodItem.getProdId(), prodItem.getHourPrice());
			if (null != promValue){
				prodItem.setHourRebatePrice(promValue.getDiscountAmount());
				addPromotionToProdItem(prodItem, promValue);
			} else {
				prodItem.setHourRebatePrice(prodItem.getHourPrice());
			}
			custBuyVo.setHourRebatePrice(custBuyVo.getHourRebatePrice()+prodItem.getHourRebatePrice());
			
			custBuyVo.addCyclePriceProd(prodItem);
		}
	}
	
	private void addPromotionToProdItem(CloudProductDetail prodItem, CloudPromotionValue promoValue){
		prodItem.setPromotionId(promoValue.getPromotionId());
		prodItem.setActivityName(promoValue.getActivityName());
		prodItem.setRebateFlag(promoValue.getRebateFlag());
		prodItem.setRebateAmount(promoValue.getRebateAmount());
		prodItem.setStartDate(promoValue.getStartDate());
		prodItem.setEndDate(promoValue.getEndDate());
	}
	
	public CloudMdmNetworkVo addHighNet(HttpServletRequest request,CloudProductCustomBuyVo customBuyVo) throws Exception {
		
		try{
			BasicUserVo basicUser = this.getCurrentUser(request);
			
			String description = customBuyVo.getDescription();
			String networkName = customBuyVo.getNetworkName();
			String selValue = customBuyVo.getSelValue();
			String zoneId = customBuyVo.getZoneInterfaceId();
			String[] priceInfo = selValue.split("_");
			String prodId = priceInfo[0];				//产品主表ID
			String price = priceInfo[1];				//选择的计费价格
			String prodItemId = priceInfo[2];			//产品子表ID
			String ifId = priceInfo[3];					//接口元素ID
			String billingCycle = priceInfo[4];			//计费周期
			
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
				throw new Exception("网络添加失败，账户费用不足，请充值.");
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
			
			return networkVo;
		}catch(ValidatorException e){
			e.printStackTrace();
			throw new Exception("新建网络失败："+e.getMessage());
		}catch(CloudException e){
			e.printStackTrace();
			throw new Exception("新建网络失败："+e.getMessage());
		}
		
	}
	
	private void genResApproReqEmailInfo (HashMap orderItemMap , CloudProductCustomBuyVo custBuyVo, BasicUserVo userVo){
		//数据中心
		CloudMdmZoneVo cloudMdmZoneVo = (CloudMdmZoneVo) orderItemMap.get("zone");
		//安全组
		CloudSecurityGroupVo CloudSecurityGroupVo = (CloudSecurityGroupVo) orderItemMap.get("securityGroup");
		//模板
		CloudProductDetail prodTemplate = (CloudProductDetail) orderItemMap.get("template");
		//计算资源
		CloudProductDetail prodCpu = (CloudProductDetail) orderItemMap.get("cpu");
		//磁盘
		CloudProductDetail prodDisk =  (CloudProductDetail) orderItemMap.get("disk");
		//IP
		CloudProductDetail ip =  (CloudProductDetail) orderItemMap.get("ip");
		
		resApproReqEmailInfo.delete(0, resApproReqEmailInfo.length());
		resApproReqEmailInfo.append("亲爱的：" + userVo.getParentBasicUser().getUserName() + "，用户：" + userVo.getUserName() + "购买如下虚机，需要您的审批：" );
		resApproReqEmailInfo.append("<br>");
		resApproReqEmailInfo.append("|	项目类别		|	名称		|	描述		|");
		resApproReqEmailInfo.append("<br>");
		resApproReqEmailInfo.append("|	数据中心		|" + cloudMdmZoneVo.getName() + "  " + 	cloudMdmZoneVo.getDisplayText()	+ "|" +cloudMdmZoneVo.getDescription() +"|");
		resApproReqEmailInfo.append("<br>");
		if (cloudMdmZoneVo.getNetworkType().equalsIgnoreCase("Basic")) {
			if (null != CloudSecurityGroupVo) {
				resApproReqEmailInfo.append("|	安全组		|" + CloudSecurityGroupVo.getName() + "|" + CloudSecurityGroupVo.getDescription() +"|");
				resApproReqEmailInfo.append("<br>");
			}
		} else {
			for (CloudMdmNetworkVo net : custBuyVo.getMdmNetWorkList()) {
				resApproReqEmailInfo.append("|	网络		|" + net.getName() + "|" + net.getDisplaytext() +"|");
				resApproReqEmailInfo.append("<br>");
			}
		}
		resApproReqEmailInfo.append("|	模板		|" + prodTemplate.getProdName() + "|" + prodTemplate.getProdDesc() +"|");
		resApproReqEmailInfo.append("<br>");
		resApproReqEmailInfo.append("|	计算资源		|" + prodCpu.getProdName() + "|" + prodCpu.getProdDesc() +"|");
		resApproReqEmailInfo.append("<br>");
		if (null != prodDisk) {
			resApproReqEmailInfo.append("|	磁盘资源		|" + prodDisk.getProdName() + "|" + prodDisk.getProdDesc() +"|");
			resApproReqEmailInfo.append("<br>");
		}
		resApproReqEmailInfo.append("|	主机配置	|" + " 数量：" + custBuyVo.getHostAmount() + " 主机名：" + custBuyVo.getHostName() + "|" );
		
		if (null != prodDisk && null != custBuyVo.getProdDisk() && custBuyVo.getProdDisk().getCustomized().equalsIgnoreCase("true")) {
			resApproReqEmailInfo.append(" 自定义磁盘大小：" +  prodDisk.getDiskSize()  );
		}
		
		if (null != custBuyVo.getStopHostTime()) {
			resApproReqEmailInfo.append(" 停机时间：" +  custBuyVo.getStopHostTime() + "|" );
		}
		
		resApproReqEmailInfo.append("<br><br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。");
	}
	
	public CloudMdmZoneServiceI getCloudMdmZoneService() {
		return cloudMdmZoneService;
	}

	public void setCloudMdmZoneService(CloudMdmZoneServiceI cloudMdmZoneService) {
		this.cloudMdmZoneService = cloudMdmZoneService;
	}

	public CloudPromotionInfoServiceI getCloudPromotionInfoService() {
		return cloudPromotionInfoService;
	}

	public void setCloudPromotionInfoService(
			CloudPromotionInfoServiceI cloudPromotionInfoService) {
		this.cloudPromotionInfoService = cloudPromotionInfoService;
	}

	public CloudSecurityGroupServiceI getCloudSecurityGroupService() {
		return cloudSecurityGroupService;
	}

	public CloudMdmNetworkServiceI getCloudMdmNetworkService() {
		return cloudMdmNetworkService;
	}

	public CloudMdmCPUSolnServiceI getCloudMdmCPUSolnService() {
		return cloudMdmCPUSolnService;
	}

	public CloudMdmDiskSolnServiceI getCloudMdmDiskSolnService() {
		return cloudMdmDiskSolnService;
	}

	public CloudMdmTemplateServiceI getCloudMdmTemplateService() {
		return cloudMdmTemplateService;
	}

	public void setCloudSecurityGroupService(
			CloudSecurityGroupServiceI cloudSecurityGroupService) {
		this.cloudSecurityGroupService = cloudSecurityGroupService;
	}

	public void setCloudMdmNetworkService(
			CloudMdmNetworkServiceI cloudMdmNetworkService) {
		this.cloudMdmNetworkService = cloudMdmNetworkService;
	}

	public void setCloudMdmCPUSolnService(
			CloudMdmCPUSolnServiceI cloudMdmCPUSolnService) {
		this.cloudMdmCPUSolnService = cloudMdmCPUSolnService;
	}

	public void setCloudMdmDiskSolnService(
			CloudMdmDiskSolnServiceI cloudMdmDiskSolnService) {
		this.cloudMdmDiskSolnService = cloudMdmDiskSolnService;
	}

	public void setCloudMdmTemplateService(
			CloudMdmTemplateServiceI cloudMdmTemplateService) {
		this.cloudMdmTemplateService = cloudMdmTemplateService;
	}
	
	public void setCloudUserOrderService(
			CloudUserOrderServiceI cloudUserOrderService) {
		this.cloudUserOrderService = cloudUserOrderService;
	}

	public void setCloudMdmIPService(CloudMdmIPServiceI cloudMdmIPService) {
		this.cloudMdmIPService = cloudMdmIPService;
	}

	public void setCloudMdmProductItemService(
			CloudMdmProductItemServiceI cloudMdmProductItemService) {
		this.cloudMdmProductItemService = cloudMdmProductItemService;
	}

	public void setCloudPromotionProductService(
			CloudPromotionProductServiceI cloudPromotionProductService) {
		this.cloudPromotionProductService = cloudPromotionProductService;
	}

	public void setCloudMdmProductService(
			CloudMdmProductServiceI cloudMdmProductService) {
		this.cloudMdmProductService = cloudMdmProductService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}

	public void setCloudOrderAppprovalService(
			CloudOrderAppprovalServiceI cloudOrderAppprovalService) {
		this.cloudOrderAppprovalService = cloudOrderAppprovalService;
	}
	
	public void setCloudMdmVMService(CloudMdmVMServiceI cloudMdmVMService) {
		this.cloudMdmVMService = cloudMdmVMService;
	}
	
	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}

	@Override
	public BasicServiceI<CloudUserOrderVo> getService() {
		// TODO Auto-generated method stub
		return cloudUserOrderService;
	}
	
	public MailServiceI getMailService() {
		return mailService;
	}

	public void setMailService(MailServiceI mailService) {
		this.mailService = mailService;
	}

	@Override
	public String getViewPath() {
		// TODO Auto-generated method stub
		return "product";
	}
	
	@Autowired
	private CloudMdmZoneServiceI cloudMdmZoneService;
	
	@Autowired
	private CloudPromotionInfoServiceI cloudPromotionInfoService;
	
	@Autowired
	private CloudSecurityGroupServiceI cloudSecurityGroupService;
	
	@Autowired
	private CloudMdmNetworkServiceI cloudMdmNetworkService;
	
	@Autowired
	private CloudMdmCPUSolnServiceI cloudMdmCPUSolnService;
	
	@Autowired
	private CloudMdmDiskSolnServiceI cloudMdmDiskSolnService;
	
	@Autowired
	private CloudMdmTemplateServiceI cloudMdmTemplateService;
	
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	@Autowired
	private CloudMdmIPServiceI cloudMdmIPService;
	@Autowired
	private CloudPromotionProductServiceI cloudPromotionProductService;
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private AccountExpenseServiceI accountExpenseService;
	@Autowired
	private CloudOrderAppprovalServiceI cloudOrderAppprovalService;
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	@Autowired
	private MailServiceI mailService;
	
	private StringBuilder resApproReqEmailInfo = new StringBuilder();
	
	
	
}
