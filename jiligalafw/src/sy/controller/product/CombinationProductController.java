package sy.controller.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseController;
import sy.domain.en.product.ProdType;
import sy.domain.vo.product.CloudMdmCPUSolnVo;
import sy.domain.vo.product.CloudMdmDiskSolnVo;
import sy.domain.vo.product.CloudMdmNetworkSolnVo;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.product.CloudMdmTemplateVo;
import sy.domain.vo.product.CloudMdmZoneVo;
import sy.domain.vo.product.CloudProductCombinationPriceVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.service.product.CloudMdmCPUSolnServiceI;
import sy.service.product.CloudMdmDiskSolnServiceI;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkSolnServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudMdmTemplateServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmZoneServiceI;
import sy.service.product.CloudProductPriceServiceI;
import sy.service.product.CloudUserOrderItemServiceI;

/**
 * 产品管理 - 组合产品维护
 * 
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/combinProd")
public class CombinationProductController extends BaseController {

	// 产品基础数据
	@Autowired
	private CloudMdmCPUSolnServiceI cloudMdmCPUSolnService;
	@Autowired
	private CloudMdmDiskSolnServiceI cloudMdmDiskSolnService;
	@Autowired
	private CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService;
	@Autowired
	private CloudMdmTemplateServiceI cloudMdmTemplateService;
	@Autowired
	private CloudMdmIPServiceI cloudMdmIPService;

	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	@Autowired
	private CloudMdmZoneServiceI cloudMdmZoneService;

	// 产品管理
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	
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

	public CloudMdmCPUSolnServiceI getCloudMdmCPUSolnService() {
		return cloudMdmCPUSolnService;
	}

	public void setCloudMdmCPUSolnService(
			CloudMdmCPUSolnServiceI cloudMdmCPUSolnService) {
		this.cloudMdmCPUSolnService = cloudMdmCPUSolnService;
	}

	public CloudMdmDiskSolnServiceI getCloudMdmDiskSolnService() {
		return cloudMdmDiskSolnService;
	}

	public void setCloudMdmDiskSolnService(
			CloudMdmDiskSolnServiceI cloudMdmDiskSolnService) {
		this.cloudMdmDiskSolnService = cloudMdmDiskSolnService;
	}

	public CloudMdmNetworkSolnServiceI getCloudMdmNetworkSolnService() {
		return cloudMdmNetworkSolnService;
	}

	public void setCloudMdmNetworkSolnService(
			CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService) {
		this.cloudMdmNetworkSolnService = cloudMdmNetworkSolnService;
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

	public CloudMdmProductItemServiceI getCloudMdmProductItemService() {
		return cloudMdmProductItemService;
	}

	public void setCloudMdmProductItemService(
			CloudMdmProductItemServiceI cloudMdmProductItemService) {
		this.cloudMdmProductItemService = cloudMdmProductItemService;
	}

	public CloudMdmProductServiceI getCloudMdmProductService() {
		return cloudMdmProductService;
	}

	public void setCloudMdmProductService(
			CloudMdmProductServiceI cloudMdmProductService) {
		this.cloudMdmProductService = cloudMdmProductService;
	}

	/**
	 * 产品管理-组合产品维护-产品列表页面
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductItemVo vo,
			ModelMap modelMap) throws ValidatorException {
		String prodId = request.getParameter("prodId");
		//组合产品是否已被购买
		QueryContext context = new ECContext(request, modelMap, "orderList");
		context.clearParmeters();
		context.put("$eq_cloudMdmProduct_id", prodId);
		
	    List<?> orderList = this.cloudUserOrderItemService.list(context);
		
		if(orderList == null || orderList.size() < 1){
			//删除产品和定价信息
			try {
				this.cloudMdmProductService.delProductById(prodId);
				modelMap.put("prodSaveMsg", "产品删除成功");

			} catch (ValidatorException e) {
				modelMap.put("prodSaveMsg", "产品删除失败");
				e.printStackTrace();
			}
		}else{
			modelMap.put("prodSaveMsg", "产品删除失败，该产品已被使用");
		}
		context.clearParmeters();
		context.put("$eq_prodType", Constants.PROD_TYPE_COMPLAINTION);
		String keyword = request.getParameter("keyword");// 产品查询关键字
		context.put("$lk_prodName", keyword);
		context.setPaging(false);
		context.setSort(" prodType asc ");
		List<CloudMdmProductVo> cloudMdmProductVoList = null;
		try {
			cloudMdmProductVoList = cloudMdmProductService.list(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.put("cloudMdmProductVoList", cloudMdmProductVoList);
		return "product/combinationProductList";
	}
	
	/**
	 * 产品管理-组合产品维护-产品列表页面
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductItemVo vo,
			ModelMap modelMap) throws ValidatorException {
		CloudProductDetail cloudMdmNetworkSolnDetail = null;
		CloudProductDetail cloudMdmDiskSolnDetail = null;
		CloudProductDetail cloudMdmCPUSolnDetail = null;
		CloudProductDetail cloudMdmTemplateDetail = null;
		CloudMdmZoneVo cloudMdmZoneVo = null;
		String combinationProductId = request.getParameter("prodId");	
		String saveFlag = request.getParameter("saveFlag");
		QueryContext context = new ECContext(request, modelMap, "prod");
		context.clearParmeters();
		context.put("$eq_prodType", Constants.PROD_TYPE_COMPLAINTION);
		String keyword = request.getParameter("keyword");// 产品查询关键字
		context.put("$lk_prodName", keyword);
		context.setPaging(false);
		context.setSort(" prodType asc ");
		List<CloudMdmProductVo> cloudMdmProductVoList = null;
		CloudMdmProductItemVo cloudMdmProductItemVo = null;
		try {
			cloudMdmProductVoList = cloudMdmProductService.list(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.put("mdmZoneName", "");
		if((StringUtils.isBlank(saveFlag) && StringUtils.isBlank(combinationProductId)) && null !=cloudMdmProductVoList &&  cloudMdmProductVoList.size() !=0){
			combinationProductId = cloudMdmProductVoList.get(0).getId();
		}
		// 应用于选择了一个产品id以后所要展示的产品明细
		if (StringUtils.isNotBlank(combinationProductId)) {
			try {
				cloudMdmProductItemVo = cloudMdmProductItemService
						.getprodItemByProdId(combinationProductId);
					modelMap.put("mdmZoneName", cloudMdmProductItemVo.getMdmZone().getName());
				cloudMdmDiskSolnDetail = cloudMdmDiskSolnService
						.getCloudMdmDiskSolnByCombProdId(combinationProductId);
				cloudMdmNetworkSolnDetail = cloudMdmNetworkSolnService
						.getCloudMdmNetworkSolnByCombProdId(combinationProductId);
				cloudMdmCPUSolnDetail = cloudMdmCPUSolnService
						.getCloudMdmCPUSolnDetailByCombProdId(combinationProductId);
				cloudMdmTemplateDetail = cloudMdmTemplateService
						.getCloudMdmTemplateByComnProdId(combinationProductId);
				request.setAttribute("cloudMdmDiskSolnDetail",
						cloudMdmDiskSolnDetail);
				request.setAttribute("cloudMdmCPUSolnDetail",
						cloudMdmCPUSolnDetail);
				request.setAttribute("cloudMdmTemplateDetail",
						cloudMdmTemplateDetail);
				request.setAttribute("cloudMdmNetworkSolnDetail",
						cloudMdmNetworkSolnDetail);
				CloudMdmProductItemVo itemVo =this.cloudMdmProductItemService.get(cloudMdmProductItemVo.getId());
				vo.setId(itemVo.getId());
				vo.setMdmProduct(itemVo.getMdmProduct());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 应用于点击确认保存后要展示的信息.
		if (StringUtils.isNotBlank(saveFlag)) {
			cloudMdmProductItemVo = new CloudMdmProductItemVo();
			String selectMdmDiskSolnId = (String) request.getSession()
					.getAttribute("product_mdmDiskSolnProdId");
			if (StringUtils.isNotBlank(selectMdmDiskSolnId)) {
				cloudMdmDiskSolnDetail = this.cloudMdmDiskSolnService
						.getCloudMdmDiskSolnByProdId(selectMdmDiskSolnId);
				request.setAttribute("cloudMdmDiskSolnDetail",
						cloudMdmDiskSolnDetail);
				request.setAttribute("diskState",
						"0");
			}else{
				request.setAttribute("diskState",
						"1");
			}
			String selectMdmCPUSolnId = (String) request.getSession()
					.getAttribute("product_mdmCPUSolnProdId");
			if (StringUtils.isNotBlank(selectMdmCPUSolnId)) {
				cloudMdmCPUSolnDetail = this.cloudMdmCPUSolnService
						.getCloudMdmCPUSolnDetailByProdId(selectMdmCPUSolnId);
				request.setAttribute("cloudMdmCPUSolnDetail",
						cloudMdmCPUSolnDetail);
			}
			String selectMdmTemplateId = (String) request.getSession()
					.getAttribute("product_mdmTemplateProdId");
			if (StringUtils.isNotBlank(selectMdmTemplateId)) {
				cloudMdmTemplateDetail = this.cloudMdmTemplateService
						.getCloudMdmTemplateByProdId(selectMdmTemplateId);
				request.setAttribute("cloudMdmTemplateDetail",
						cloudMdmTemplateDetail);
			}
			String selectMdmZoneId = (String) request.getSession().getAttribute(
					"product_mdmZoneId");
			if (StringUtils.isNotBlank(selectMdmZoneId)) {
				cloudMdmZoneVo = this.cloudMdmZoneService.get(selectMdmZoneId);
				cloudMdmProductItemVo.setMdmZone(cloudMdmZoneVo);
				modelMap.put("mdmZoneName",cloudMdmZoneVo.getName());
			}else{
				modelMap.put("mdmZoneName", "");
			}
			String mdmNetworkSolnId = (String) request.getSession()
					.getAttribute("product_mdmNetworkSolnProdId");
			if (StringUtils.isNotBlank(mdmNetworkSolnId)) {
				cloudMdmNetworkSolnDetail = this.cloudMdmNetworkSolnService
						.getCloudMdmNetworkSolnByProdId(mdmNetworkSolnId);
				request.setAttribute("cloudMdmNetworkSolnDetail",
						cloudMdmNetworkSolnDetail);
			}
			cloudMdmProductItemVo.setItemType(ProdType.COMP_PROD.toString());
			cloudMdmProductItemVo.setState(Constants.VALID_STATE);
			vo = new CloudMdmProductItemVo();
		}
		if(StringUtils.isNotBlank(saveFlag) || StringUtils.isNotBlank(combinationProductId)){
			modelMap.put("baocunFlag",1);
		}else{
			modelMap.put("baocunFlag",0);
		}
		if(StringUtils.isNotBlank(combinationProductId)){
			modelMap.put("shanchuFlag", 1);
		}else{
			modelMap.put("shanchuFlag", 0);
		}
		if(StringUtils.isBlank(saveFlag)){
			modelMap.put("editType","upd");	
		}else{
			modelMap.put("editType", request.getParameter("editType"));	
		}
		modelMap.put("cpId", combinationProductId);
		modelMap.put("cloudMdmProductVoList", cloudMdmProductVoList);
		modelMap.put("keyword", keyword);
	
		return "product/combinationProductList";
	}

	/**
	 * 产品定制-选择数据中心
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectDc")
	public String selectDc(HttpServletRequest request,
			HttpServletResponse response, CloudMdmZoneVo vo, ModelMap modelMap) {
		QueryContext context = new ECContext(request, modelMap, "mdmZone");
		context.clearParmeters();
		context.setPaging(false);
		List<CloudMdmZoneVo> mdmZoneList = null;
		try {
			mdmZoneList = this.cloudMdmZoneService.getCloudMdmZoneListByItemId(null, context);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		String selectMdmZoneId = (String) request.getSession().getAttribute(
				"product_mdmZoneId");
		if (null != mdmZoneList) {
			for (int i = 0; i < mdmZoneList.size(); i++) {
				if (StringUtils.isNotBlank(selectMdmZoneId)) {
					if (selectMdmZoneId.equals(mdmZoneList.get(i).getId())) {
						mdmZoneList.get(i).setSelectFlag("1");
					}
				} else {
					mdmZoneList.get(i).setSelectFlag("0");
				}
			}
		}
		modelMap.put("mdmZoneList", mdmZoneList);
		return "product/combinationProduct_selectDc";
	}


	/**
	 * 产品定制-选择模板
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectTemplate")
	public String selectTemplate(HttpServletRequest request,
			HttpServletResponse response, CloudMdmTemplateVo vo,
			ModelMap modelMap) {
		
		String mdmZoneId = request.getParameter("mdmZoneId");
		if (StringUtils.isNotBlank(mdmZoneId)) {
			request.getSession().setAttribute("product_mdmZoneId", mdmZoneId);
		}
		String selectMdmZoneId = (String) request.getSession().getAttribute(
				"product_mdmZoneId");
		if(StringUtils.isNotBlank(selectMdmZoneId)){
			mdmZoneId=selectMdmZoneId;
		}
		QueryContext context = new ECContext(request, modelMap, "mdmTemplate");
		context.clearParmeters();
		context.setPaging(false);
		List<CloudProductDetail> cloudMdmTemplateVoList = null;
		try {
			cloudMdmTemplateVoList = this.cloudMdmTemplateService.getCloudMdmTemplateListByItemId(null, mdmZoneId,context);
			
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		String selectMdmTemplateId = (String) request.getSession()
				.getAttribute("product_mdmTemplateProdId");
		if (null != cloudMdmTemplateVoList) {
			for (int i = 0; i < cloudMdmTemplateVoList.size(); i++) {
				if (StringUtils.isNotBlank(selectMdmTemplateId)) {
					if (selectMdmTemplateId.equals(cloudMdmTemplateVoList
							.get(i).getProdId())) {
						cloudMdmTemplateVoList.get(i).setSelectFlag("1");
					}
				} else {
					cloudMdmTemplateVoList.get(i).setSelectFlag("0");
				}
			}
		}
		modelMap.put("cloudMdmTemplateVoList", cloudMdmTemplateVoList);
		return "product/combinationProduct_selectTemplate";
	}

	/**
	 * 产品定制-选择计算资源
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "computResource")
	public String computResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmCPUSolnVo vo,
			ModelMap modelMap) {
		String mdmTemplateId = request.getParameter("mdmTemplateId");
		if (StringUtils.isNotBlank(mdmTemplateId)) {
			String[] templates = mdmTemplateId.split("__");
			request.getSession().setAttribute("product_mdmTemplateId",
					templates[0]);
			request.getSession().setAttribute("product_mdmTemplateProdId",
					templates[1]);
			request.getSession().setAttribute("product_mdmTemplatePriceId",
					templates[2]);
		}
		QueryContext context = new ECContext(request, modelMap, "mdmCPUSoln");
		context.clearParmeters();
		context.setPaging(false);
		List<CloudProductDetail> cloudMdmCPUSolnVoList = null;
		try {
			cloudMdmCPUSolnVoList = this.cloudMdmCPUSolnService.getCloudMdmCPUSolnListByItemId(null, context);
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String selectMdmCPUSolnId = (String) request.getSession().getAttribute(
				"product_mdmCPUSolnProdId");
		if (null != cloudMdmCPUSolnVoList) {
			for (int i = 0; i < cloudMdmCPUSolnVoList.size(); i++) {
				if (StringUtils.isNotBlank(selectMdmCPUSolnId)) {
					if (selectMdmCPUSolnId.equals(cloudMdmCPUSolnVoList.get(i)
							.getProdId())) {
						cloudMdmCPUSolnVoList.get(i).setSelectFlag("1");
					}
				} else {
					cloudMdmCPUSolnVoList.get(i).setSelectFlag("0");
				}
			}
		}
		modelMap.put("cloudMdmCPUSolnVoList", cloudMdmCPUSolnVoList);
		return "product/combinationProduct_computResource";
	}

	/**
	 * 产品定制-选择磁盘资源
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "diskResource")
	public String diskResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmDiskSolnVo vo,
			ModelMap modelMap) {
		String mdmCPUSolnId = request.getParameter("mdmCPUSolnId");
		if (StringUtils.isNotBlank(mdmCPUSolnId)) {
			String[] cpuSolns = mdmCPUSolnId.split("__");
			request.getSession().setAttribute("product_mdmCPUSolnId",
					cpuSolns[0]);
			request.getSession().setAttribute("product_mdmCPUSolnProdId",
					cpuSolns[1]);
			request.getSession().setAttribute("product_mdmCPUSolnPriceId",
					cpuSolns[2]);
		}
		QueryContext context = new ECContext(request, modelMap, "mdmDiskSoln");
		context.clearParmeters();
		context.setPaging(false);
		List<CloudProductDetail> cloudMdmDiskSolnVoList = null;
		try {
			cloudMdmDiskSolnVoList = this.cloudMdmDiskSolnService.getCloudMdmDiskSolnListByItemId(null, context);
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String selectMdmDiskSolnId = (String) request.getSession()
				.getAttribute("product_mdmDiskSolnProdId");
		if (null != cloudMdmDiskSolnVoList) {
			for (int i = 0; i < cloudMdmDiskSolnVoList.size(); i++) {
				if (StringUtils.isNotBlank(selectMdmDiskSolnId)) {
					if (selectMdmDiskSolnId.equals(cloudMdmDiskSolnVoList
							.get(i).getProdId())) {
						cloudMdmDiskSolnVoList.get(i).setSelectFlag("1");
					}
				} else {
					cloudMdmDiskSolnVoList.get(i).setSelectFlag("0");
				}
			}
		}
		modelMap.put("cloudMdmDiskSolnVoList", cloudMdmDiskSolnVoList);
		return "product/combinationProduct_diskResource";
	}

	/**
	 * 产品定制-选择网络方案
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
//	@RequestMapping(value = "networkSolution")
//	public String networkSolution(HttpServletRequest request,
//			HttpServletResponse response, CloudMdmNetworkSolnVo vo,
//			ModelMap modelMap) {
//		String mdmDiskSolnId = request.getParameter("mdmDiskSolnId");
//		if (StringUtils.isNotBlank(mdmDiskSolnId)) {
//			String[] diskSolns = mdmDiskSolnId.split("__");
//			request.getSession().setAttribute("product_mdmDiskSolnId",
//					diskSolns[0]);
//			request.getSession().setAttribute("product_mdmDiskSolnProdId",
//					diskSolns[1]);
//			request.getSession().setAttribute("product_mdmDiskSolnPriceId",
//					diskSolns[2]);
//		}
//		QueryContext context = new ECContext(request, modelMap,
//				"mdmNetworkSoln");
//		context.clearParmeters();
//		context.setPaging(false);
//		List<CloudProductDetail> cloudMdmNetworkSolnVoList = null;
//		try {
//			cloudMdmNetworkSolnVoList = this.cloudMdmNetworkSolnService
//					.getCloudMdmNetworkSolnListByItemId(null, context);
//		} catch (ValidatorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String selectMdmNetworkSolnId = (String) request.getSession()
//				.getAttribute("product_mdmNetworkSolnProdId");
//		if (null != cloudMdmNetworkSolnVoList) {
//			for (int i = 0; i < cloudMdmNetworkSolnVoList.size(); i++) {
//				if (StringUtils.isNotBlank(selectMdmNetworkSolnId)) {
//					if (selectMdmNetworkSolnId.equals(cloudMdmNetworkSolnVoList
//							.get(i).getProdId())) {
//						cloudMdmNetworkSolnVoList.get(i).setSelectFlag("1");
//					}
//				} else {
//					cloudMdmNetworkSolnVoList.get(i).setSelectFlag("0");
//				}
//			}
//		}
//		modelMap.put("cloudMdmNetworkSolnVoList", cloudMdmNetworkSolnVoList);
//		return "product/combinationProduct_networkSolution";
//	}

	/**
	 * 产品定制-信息确认
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "infoConfirm")
	public String infoConfirm(HttpServletRequest request,
			HttpServletResponse response, CloudUserOrderVo vo, ModelMap modelMap)
			throws ValidatorException {
//		CloudProductDetail cloudMdmNetworkSolnDetail = null;
		 CloudProductDetail cloudMdmDiskSolnDetail = null;
		 CloudProductDetail cloudMdmCPUSolnDetail = null;
		 CloudProductDetail cloudMdmTemplateDetail = null;
			CloudMdmZoneVo cloudMdmZoneVo = null;
//		String mdmNetworkSolnId = request.getParameter("mdmNetworkSolnId");
//		if (StringUtils.isNotBlank(mdmNetworkSolnId)) {
//			String[] networkSolns = mdmNetworkSolnId.split("__");
//			request.getSession().setAttribute("product_mdmNetworkSolnId",
//					networkSolns[0]);
//			request.getSession().setAttribute("product_mdmNetworkSolnProdId",
//					networkSolns[1]);
//			request.getSession().setAttribute("product_mdmNetworkSolnPriceId",
//					networkSolns[2]);
//			cloudMdmNetworkSolnDetail = this.cloudMdmNetworkSolnService.getCloudMdmNetworkSolnByProdId(networkSolns[1]);
//			request.setAttribute("cloudMdmNetworkSolnDetail", cloudMdmNetworkSolnDetail);
//		} else {
//			modelMap.put("cloudMdmNetworkSolnDetail", "");
//		}
		String mdmDiskSolnId = request.getParameter("mdmDiskSolnId");
		modelMap.put("diskState", "0");
		if (StringUtils.isNotBlank(mdmDiskSolnId)) {
			String[] diskSolns = mdmDiskSolnId.split("__");
			if(diskSolns.length !=0){
			request.getSession().setAttribute("product_mdmDiskSolnId",
					diskSolns[0]);
			request.getSession().setAttribute("product_mdmDiskSolnProdId",
					diskSolns[1]);
			request.getSession().setAttribute("product_mdmDiskSolnPriceId",
					diskSolns[2]);
			cloudMdmDiskSolnDetail = this.cloudMdmDiskSolnService.getCloudMdmDiskSolnByProdId(diskSolns[1]);
			}else{
				modelMap.put("diskState", "1");
			}
			request.setAttribute("cloudMdmDiskSolnDetail", cloudMdmDiskSolnDetail);
		} else {
			modelMap.put("cloudMdmDiskSolnDetail", "");
		}
		
		
//		String selectMdmDiskSolnId = (String) request.getSession()
//				.getAttribute("product_mdmDiskSolnProdId");
//		if (StringUtils.isNotBlank(selectMdmDiskSolnId)) {
//			cloudMdmDiskSolnDetail = this.cloudMdmDiskSolnService.getCloudMdmDiskSolnByProdId(selectMdmDiskSolnId);
//			request.setAttribute("cloudMdmDiskSolnDetail", cloudMdmDiskSolnDetail);
//		} else {
//			modelMap.put("cloudMdmDiskSolnDetail", "");
//		}
		String selectMdmCPUSolnId = (String) request.getSession().getAttribute(
				"product_mdmCPUSolnProdId");
		if (StringUtils.isNotBlank(selectMdmCPUSolnId)) {
			cloudMdmCPUSolnDetail = this.cloudMdmCPUSolnService.getCloudMdmCPUSolnDetailByProdId(selectMdmCPUSolnId);
			request.setAttribute("cloudMdmCPUSolnDetail", cloudMdmCPUSolnDetail);
		} else {
			modelMap.put("cloudMdmCPUSolnDetail", "");
		}
		String selectMdmTemplateId = (String) request.getSession()
				.getAttribute("product_mdmTemplateProdId");
		if (StringUtils.isNotBlank(selectMdmTemplateId)) {
			cloudMdmTemplateDetail = this.cloudMdmTemplateService.getCloudMdmTemplateByProdId(selectMdmTemplateId);
			request.setAttribute("cloudMdmTemplateDetail", cloudMdmTemplateDetail);
		} else {
			modelMap.put("cloudMdmTemplateDetail", "");
		}
		String selectMdmZoneId = (String) request.getSession().getAttribute(
				"product_mdmZoneId");
		if (StringUtils.isNotBlank(selectMdmZoneId)) {
			cloudMdmZoneVo = this.cloudMdmZoneService.get(selectMdmZoneId);
			modelMap.put("mdmZone", cloudMdmZoneVo);
		} else {
			modelMap.put("mdmZone", "");
		}
		return "product/combinationProduct_infoConfirm";
	}
	/**
	 * 保存组合产品信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap, @Valid CloudMdmProductItemVo vo, BindingResult errors) {
		try{
		     String prodName = vo.getMdmProduct().getProdName();
			CloudMdmProductVo prodVo = new CloudMdmProductVo();
			List<CloudProductCombinationPriceVo> cloudProductCombinationPriceList
			 = new ArrayList<CloudProductCombinationPriceVo>();
			
			prodVo.setState(Constants.VALID_STATE);
			prodVo.setProdName(prodName);
			prodVo.setDescription(vo.getMdmProduct().getDescription());
		    prodVo.setProdType(Constants.PROD_TYPE_COMPLAINTION);
//		    CloudMdmNetworkSolnVo cloudMdmNetworkSolnVo = null;
			CloudMdmDiskSolnVo cloudMdmDiskSolnVo = null;
			CloudMdmCPUSolnVo cloudMdmCPUSolnVo = null;
			CloudMdmTemplateVo cloudMdmTemplateVo = null;
			CloudMdmZoneVo cloudMdmZoneVo = null;
			vo = new CloudMdmProductItemVo();
			String selectMdmDiskSolnId = (String) request.getSession()
					.getAttribute("product_mdmDiskSolnId");
			
			if (StringUtils.isNotBlank(selectMdmDiskSolnId)) {
				cloudMdmDiskSolnVo = this.cloudMdmDiskSolnService
						.get(selectMdmDiskSolnId);
				vo.setMdmDiskSoln(cloudMdmDiskSolnVo);
				CloudProductCombinationPriceVo cloudProductCombinationPriceVo
				   = new CloudProductCombinationPriceVo();
				cloudProductCombinationPriceVo.setCloudMdmProduct(prodVo);
				cloudProductCombinationPriceVo.setCellId(selectMdmDiskSolnId);
				cloudProductCombinationPriceVo.setCellType("diskSoln");
				cloudProductCombinationPriceVo.setPriceId((String) request.getSession()
					.getAttribute("product_mdmDiskSolnPriceId"));
				cloudProductCombinationPriceVo.setSingleProdId((String) request.getSession()
						.getAttribute("product_mdmDiskSolnProdId"));
				cloudProductCombinationPriceList.add(cloudProductCombinationPriceVo);
			}
			String selectMdmCPUSolnId = (String) request.getSession().getAttribute(
					"product_mdmCPUSolnId");
			if (StringUtils.isNotBlank(selectMdmCPUSolnId)) {
				cloudMdmCPUSolnVo = this.cloudMdmCPUSolnService
						.get(selectMdmCPUSolnId);
				vo.setMdmCpuSoln(cloudMdmCPUSolnVo);
				CloudProductCombinationPriceVo cloudProductCombinationPriceVo
				   = new CloudProductCombinationPriceVo();
				cloudProductCombinationPriceVo.setCloudMdmProduct(prodVo);
				cloudProductCombinationPriceVo.setCellId(selectMdmCPUSolnId);
				cloudProductCombinationPriceVo.setCellType("cpuSoln");
				cloudProductCombinationPriceVo.setPriceId((String) request.getSession()
					.getAttribute("product_mdmCPUSolnPriceId"));
				cloudProductCombinationPriceVo.setSingleProdId((String) request.getSession()
						.getAttribute("product_mdmCPUSolnProdId"));
				cloudProductCombinationPriceList.add(cloudProductCombinationPriceVo);
			} 
			String selectMdmTemplateId = (String) request.getSession()
					.getAttribute("product_mdmTemplateId");
			if (StringUtils.isNotBlank(selectMdmTemplateId)) {
				cloudMdmTemplateVo = this.cloudMdmTemplateService
						.get(selectMdmTemplateId);
				vo.setMdmTemplate(cloudMdmTemplateVo);
				CloudProductCombinationPriceVo cloudProductCombinationPriceVo
				   = new CloudProductCombinationPriceVo();
				cloudProductCombinationPriceVo.setCloudMdmProduct(prodVo);
				cloudProductCombinationPriceVo.setCellId(selectMdmTemplateId);
				cloudProductCombinationPriceVo.setCellType("template");
				cloudProductCombinationPriceVo.setPriceId((String) request.getSession()
					.getAttribute("product_mdmTemplatePriceId"));
				cloudProductCombinationPriceVo.setSingleProdId((String) request.getSession()
						.getAttribute("product_mdmTemplateProdId"));
				cloudProductCombinationPriceList.add(cloudProductCombinationPriceVo);
			}
			String selectMdmZoneId = (String) request.getSession().getAttribute(
					"product_mdmZoneId");
			if (StringUtils.isNotBlank(selectMdmZoneId)) {
				cloudMdmZoneVo = this.cloudMdmZoneService.get(selectMdmZoneId);
				vo.setMdmZone(cloudMdmZoneVo);
			} 
//			String mdmNetworkSolnId =(String)request.getSession().getAttribute("product_mdmNetworkSolnId");
//			if (StringUtils.isNotBlank(mdmNetworkSolnId)) {
//				cloudMdmNetworkSolnVo = this.cloudMdmNetworkSolnService.get(mdmNetworkSolnId);
//				vo.setMdmNetworkSoln(cloudMdmNetworkSolnVo);
//				CloudProductCombinationPriceVo cloudProductCombinationPriceVo
//				   = new CloudProductCombinationPriceVo();
//				cloudProductCombinationPriceVo.setCloudMdmProduct(prodVo);
//				cloudProductCombinationPriceVo.setCellId(mdmNetworkSolnId);
//				cloudProductCombinationPriceVo.setCellType("networkSoln");
//				cloudProductCombinationPriceVo.setPriceId((String) request.getSession()
//					.getAttribute("product_mdmNetworkSolnPriceId"));
//				cloudProductCombinationPriceVo.setSingleProdId((String) request.getSession()
//						.getAttribute("product_mdmNetworkSolnProdId"));
//				cloudProductCombinationPriceList.add(cloudProductCombinationPriceVo);
//			} 
			vo.setState(1);
			vo.setItemType(Constants.PROD_TYPE_COMP_PROD);
			vo.setMdmProduct(prodVo);
			this.cloudMdmProductService.saveProd(prodVo,vo,cloudProductCombinationPriceList);
			request.getSession().setAttribute("product_mdmNetworkSolnId",null);
			request.getSession().setAttribute("product_mdmZoneId",null);
			request.getSession().setAttribute("product_mdmTemplateId",null);
			request.getSession().setAttribute("product_mdmCPUSolnId",null);
			request.getSession().setAttribute("product_mdmDiskSolnId",null);
			
			request.getSession().setAttribute("product_mdmNetworkSolnProdId",null);
			request.getSession().setAttribute("product_mdmTemplateProdId",null);
			request.getSession().setAttribute("product_mdmCPUSolnProdId",null);
			request.getSession().setAttribute("product_mdmDiskSolnProdId",null);
			
			request.getSession().setAttribute("product_mdmNetworkSolnPriceId",null);
			request.getSession().setAttribute("product_mdmTemplatePriceId",null);
			request.getSession().setAttribute("product_mdmCPUSolnPriceId",null);
			request.getSession().setAttribute("product_mdmDiskSolnPriceId",null);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}	
		return getRedirectStr("/combinProd/list.do");
	}

	
	/**
	 * 组成产品修改保存
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "editSave")
	public String editSave(HttpServletRequest request, ModelMap modelMap, @Valid CloudMdmProductVo vo, BindingResult errors) {
		try{
			String id = request.getParameter("cpId");
			String prodName = request.getParameter("mdmProduct.prodName");
			String description = request.getParameter("mdmProduct.description");
			
			vo = this.cloudMdmProductService.get(id);
			vo.setProdName(prodName);
			vo.setDescription(description);
			
			//保存产品主表：产品名称
			this.cloudMdmProductService.save(vo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return getRedirectStr("/combinProd/list.do");
	}

}
