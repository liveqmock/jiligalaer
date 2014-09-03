package sy.controller.product;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicDictItemVo;
import sy.domain.vo.product.CloudMdmCPUSolnVo;
import sy.domain.vo.product.CloudMdmDiskSolnVo;
import sy.domain.vo.product.CloudMdmIPVo;
import sy.domain.vo.product.CloudMdmNetworkSolnVo;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.product.CloudMdmTemplateVo;
import sy.service.base.BasicDictItemServiceI;
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
import sy.service.product.CloudUserOrderServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 产品管理  - 单一产品维护
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/singleProd")
@SessionAttributes("cloudMdmProductVo")
public class SingleProductController extends BaseControllerTemplate<CloudMdmProductVo> {
	
	//产品基础数据
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
	
	//产品管理
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	
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
	
	public CloudUserOrderServiceI getCloudUserOrderService() {
		return cloudUserOrderService;
	}

	public void setCloudUserOrderService(
			CloudUserOrderServiceI cloudUserOrderService) {
		this.cloudUserOrderService = cloudUserOrderService;
	}

	public CloudProductPriceServiceI getCloudProductPriceService() {
		return cloudProductPriceService;
	}

	public void setCloudProductPriceService(
			CloudProductPriceServiceI cloudProductPriceService) {
		this.cloudProductPriceService = cloudProductPriceService;
	}

	public CloudUserOrderItemServiceI getCloudUserOrderItemService() {
		return cloudUserOrderItemService;
	}

	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}

	public BasicDictItemServiceI getBasicDictItemService() {
		return basicDictItemService;
	}

	public void setBasicDictItemService(BasicDictItemServiceI basicDictItemService) {
		this.basicDictItemService = basicDictItemService;
	}

	@Override
	public BasicServiceI<CloudMdmProductVo> getService() {
		return cloudMdmProductService;
	}
	
	public String getViewPath() {
		return "product";
	}
	
	/**
	 * 产品管理-产品列表页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap, "prodList");
		context.clearParmeters();
		context.put("$eq_basicDict_dictId", "prodType");
		context.put("$nin_itemCode", "IP,compProd");
		List<BasicDictItemVo> prodTypeList = basicDictItemService.list(context);
		modelMap.put("prodTypeList", prodTypeList);
		
		String prodTypeCond = request.getParameter("prodTypeCond");
		if(null == prodTypeCond || "".equals(prodTypeCond)){
			prodTypeCond = Constants.PROD_TYPE_CPU_SOLN;
		}
		context.clearParmeters();
		context.put("$eq_itemType", prodTypeCond);
		List<CloudMdmProductItemVo> itemList = this.cloudMdmProductItemService.list(context);
		String prodIds = "";
		for(CloudMdmProductItemVo vo : itemList){
			prodIds += vo.getMdmProduct().getId() + ",";
		}
		if(prodIds.length() > 1){
			prodIds = prodIds.substring(0,prodIds.length()-1);
		}else{
			prodIds = "-1";
		}
		
		//已建立的单一产品列表
		context.clearParmeters();
		context.put("$in_id", prodIds);
		context.put("$eq_prodType", Constants.PROD_TYPE_SINGLE);//单一产品
		context.put("$ne_prodName", Constants.PROD_TYPE_IP);//过滤IP产品
		String keyword = request.getParameter("keyword");//产品查询关键字
		context.put("$lk_prodName", keyword);
		context.setSort(" prodType asc ");
		
		List<?> prodList = this.cloudMdmProductService.list(context);
		modelMap.put("prodList", prodList);

		modelMap.put("prodTypeCond", prodTypeCond);
		modelMap.put("keyword", keyword);
		return "product/singleProductList";
	}

	/**
	 * 产品管理 -> 单一产品  -> 产品属性
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "prodAttr")
	public String prodAttr(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {

		String prodType = request.getParameter("prodType");
		String id = request.getParameter("id");
		
		//产品编辑：如果产品类型为空，那么ID为产品主表的ID
		CloudMdmProductItemVo itemVo = null;
		if(null == prodType){
			try {
				itemVo = this.cloudMdmProductItemService.getprodItemByProdId(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			prodType = itemVo.getItemType();
			
			if("cpuSoln".equals(itemVo.getItemType())){
				id = itemVo.getMdmCpuSoln().getId();
				
			}else if("diskSoln".equals(itemVo.getItemType())){
				id = itemVo.getMdmDiskSoln().getId();
				
			}else if("template".equals(itemVo.getItemType())){
				id = itemVo.getMdmTemplate().getId();
				
			}else if("networkSoln".equals(itemVo.getItemType())){
				id = itemVo.getMdmNetworkSoln().getId();
				
			}else if("ip".equals(itemVo.getItemType())){
				
			}else if("kbps".equals(itemVo.getItemType())){
				
			}else{
				
			}
		}
		
		//产品新增：各产品基本信息
		if("cpuSoln".equals(prodType)){
			CloudMdmCPUSolnVo mdmVo = this.cloudMdmCPUSolnService.get(id);
			modelMap.put("mdmVo", mdmVo);
			
			return "product/prod_attr/cpuSoln_attr";
		}else if("diskSoln".equals(prodType)){
			CloudMdmDiskSolnVo mdmVo = this.cloudMdmDiskSolnService.get(id);
			modelMap.put("mdmVo", mdmVo);
			
			return "product/prod_attr/diskSoln_attr";
		}else if("template".equals(prodType)){
			CloudMdmTemplateVo mdmVo = this.cloudMdmTemplateService.get(id);
			modelMap.put("mdmVo", mdmVo);
			
			return "product/prod_attr/template_attr";
		}else if("networkSoln".equals(prodType)){
			CloudMdmNetworkSolnVo mdmVo = this.cloudMdmNetworkSolnService.get(id);
			modelMap.put("mdmVo", mdmVo);
			
			return "product/prod_attr/networkSoln_attr";
		}else if("ip".equals(prodType)){
			
			return null;
		}else if("kbps".equals(prodType)){
			
			return null;
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 新增：保存单一产品信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap, @Valid CloudMdmProductVo vo, BindingResult errors) {
		try{
			String id = request.getParameter("id");//基础产品数据ID
			String prodType = request.getParameter("prodType");
			String prodName = request.getParameter("prodName");
			String description = request.getParameter("description");
			
			//判断元素是否已建立产品
			CloudMdmProductItemVo iVo = this.cloudMdmProductItemService.getProdByItemId(id);
			if(iVo != null){
				modelMap.put("prodSaveMsg", "已存在该单一产品");
				modelMap.put("prodList", new ArrayList<Object>());
				return "product/singleProductList";
			}
			
			//产品主表
			CloudMdmProductVo prodVo = new CloudMdmProductVo();
			prodVo.setProdName(prodName);
			prodVo.setProdType(Constants.PROD_TYPE_SINGLE);//单一产品
			prodVo.setState(Constants.VALID_STATE);
			prodVo.setDescription(description);
			
			//产品子表
			CloudMdmProductItemVo itemVo = new CloudMdmProductItemVo();
			itemVo.setItemType(prodType);//单一产品：计算方案、磁盘方案、网络方案、模板、IP；组合产品等
			if("cpuSoln".equals(prodType)){
				CloudMdmCPUSolnVo mdmVo = this.cloudMdmCPUSolnService.get(id);
				itemVo.setItemId(mdmVo.getId());
				itemVo.setMdmCpuSoln(mdmVo);
				
			}else if("diskSoln".equals(prodType)){
				CloudMdmDiskSolnVo mdmVo = this.cloudMdmDiskSolnService.get(id);
				itemVo.setItemId(mdmVo.getId());
				itemVo.setMdmDiskSoln(mdmVo);
				
			}else if("template".equals(prodType)){
				CloudMdmTemplateVo mdmVo = this.cloudMdmTemplateService.get(id);
				itemVo.setItemId(mdmVo.getId());
				itemVo.setMdmTemplate(mdmVo);
				
			}else if("networkSoln".equals(prodType)){
				CloudMdmNetworkSolnVo mdmVo = this.cloudMdmNetworkSolnService.get(id);
				itemVo.setItemId(mdmVo.getId());
				itemVo.setMdmNetworkSoln(mdmVo);
				
			}else if("ip".equals(prodType)){
				
			}	
			itemVo.setMdmProduct(prodVo);
			itemVo.setState(Constants.VALID_STATE);
			
			//保存产品主、子表信息
			this.cloudMdmProductService.saveProd(prodVo,itemVo,null);
			modelMap.put("prodSaveMsg", "产品添加成功");
			
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("prodSaveMsg", "产品添加失败");
			modelMap.put("prodList", new ArrayList<Object>());
			return "product/singleProductList";
		}
		
		return getRedirectStr("/singleProd/list.do");
		//modelMap.put("prodList", new ArrayList<Object>());
		//return "product/singleProductList";
	}

	/**
	 * 修改：保存单一产品信息
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
			String id = request.getParameter("id");//基础产品数据ID
			String prodName = request.getParameter("prodName");
			String description = request.getParameter("description");
			vo = this.cloudMdmProductService.get(id);
			vo.setProdName(prodName);
			vo.setDescription(description);
			
			//保存产品主表：产品名称
			this.cloudMdmProductService.save(vo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return getRedirectStr("/singleProd/list.do");
	}

	
	@Override
	public String delete(HttpServletRequest request, ModelMap modelMap,
			String id) throws ValidatorException{

		//单一产品是否已被购买
		QueryContext context = new ECContext(request, modelMap, "orderList");
		context.clearParmeters();
		context.put("$eq_cloudMdmProduct_id", id);
		List<?> orderList = this.cloudUserOrderItemService.list(context);
		
		if(orderList == null || orderList.size() < 1){
			//删除产品和定价信息
			try {
				this.cloudMdmProductService.delProductById(id);
				modelMap.put("prodSaveMsg", "产品删除成功");

			} catch (ValidatorException e) {
				modelMap.put("prodSaveMsg", "产品删除失败");
				e.printStackTrace();
			}
		}else{
			modelMap.put("prodSaveMsg", "产品删除失败，该产品已被使用");
		}
		
		//已建立的单一产品列表
		context.clearParmeters();
		context.put("$eq_prodType", Constants.PROD_TYPE_SINGLE);//单一产品
		context.put("$ne_prodName", Constants.PROD_TYPE_IP);//过滤IP产品
		context.setSort(" prodType asc ");
		List<?> prodList = this.cloudMdmProductService.list(context);
		modelMap.put("prodList", prodList);

		return "product/singleProductList";
	}

	/**
	 * 产品管理-选择资源主页面
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "selectResource")
	public String selectResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmProductVo vo, ModelMap modelMap) {

		return "product/singleProduct_resourceList";
	}

	/**
	 * 选择资源-计算方案
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "computResource")
	public String computResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmCPUSolnVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "cpuSoln");
		context.put("eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> list = this.cloudMdmCPUSolnService.list(context);
		modelMap.put("list", list);
		
		return "product/singleProduct_computResource";
	}

	/**
	 * 选择资源-磁盘方案
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "diskResource")
	public String diskResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmDiskSolnVo vo, ModelMap modelMap) throws ValidatorException {

		QueryContext context = new ECContext(request, modelMap, "diskSoln");
		context.put("eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> list = this.cloudMdmDiskSolnService.list(context);
		modelMap.put("list", list);
		
		return "product/singleProduct_diskResource";
	}

	/**
	 * 选择资源-模板
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "templateRes")
	public String templateRes(HttpServletRequest request,
			HttpServletResponse response, CloudMdmTemplateVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "templateRes");
		context.put("eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> list = this.cloudMdmTemplateService.list(context);
		modelMap.put("list", list);
		
		return "product/singleProduct_templateRes";
	}
	
	/**
	 * 选择资源-网络方案
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "networkSoln")
	public String networkSoln(HttpServletRequest request,
			HttpServletResponse response, CloudMdmNetworkSolnVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "network");
		context.put("eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<?> list = this.cloudMdmNetworkSolnService.list(context);
		modelMap.put("list", list);
		
		return "product/singleProduct_networkSoln";
	}
	
	
	
	/**
	 * 选择资源-基本网络
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "basicNet")
	public String basicNet(HttpServletRequest request,
			HttpServletResponse response, CloudMdmNetworkSolnVo vo, ModelMap modelMap) throws ValidatorException {
		
		return "product/singleProduct_basicNet";
	}
	
	/**
	 * 选择资源-高级网络
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "highNet")
	public String highNet(HttpServletRequest request,
			HttpServletResponse response, CloudMdmNetworkSolnVo vo, ModelMap modelMap) throws ValidatorException {
		
		return "product/singleProduct_highNet";
	}
	
	/**
	 * 选择资源-IP
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "ipResource")
	public String ipResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmIPVo vo, ModelMap modelMap) throws ValidatorException {
		
//		QueryContext context = new ECContext(request, modelMap, "ipRes");
//		context.put("$eq_state", String.valueOf(Constants.VALID_STATE));
//		List<?> list = this.cloudMdmIPService.list(context);
//		modelMap.put("list", list);
		
		return "product/singleProduct_ipResource";
	}
	
	/**
	 * 选择资源-带宽
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "kbpsResource")
	public String kbpsResource(HttpServletRequest request,
			HttpServletResponse response, CloudMdmNetworkSolnVo vo, ModelMap modelMap) throws ValidatorException {
		
		return "product/singleProduct_kbpsResource";
	}

	
}
