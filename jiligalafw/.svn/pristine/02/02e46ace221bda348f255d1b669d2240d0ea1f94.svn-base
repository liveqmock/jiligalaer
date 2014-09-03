package sy.controller.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicDictItemVo;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudProductPriceVo;
import sy.domain.vo.product.ProductPriceVo;
import sy.service.base.BasicDictItemServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudProductPriceServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 产品管理 - 产品定价
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/makePrice")
@SessionAttributes("cloudProductPriceVo")
public class ProductMakePriceController extends BaseControllerTemplate<CloudProductPriceVo> {
	@Autowired
	private BasicDictItemServiceI basicDictItemService;
	@Autowired
	private CloudMdmProductServiceI cloudMdmProductService;
	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;
	
	public BasicDictItemServiceI getBasicDictItemService() {
		return basicDictItemService;
	}
	
	public void setBasicDictItemService(
			BasicDictItemServiceI basicDictItemService) {
		this.basicDictItemService = basicDictItemService;
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
	
	public CloudProductPriceServiceI getCloudProductPriceService() {
		return cloudProductPriceService;
	}

	public void setCloudProductPriceService(
			CloudProductPriceServiceI cloudProductPriceService) {
		this.cloudProductPriceService = cloudProductPriceService;
	}

	@Override
	public BasicServiceI<CloudProductPriceVo> getService() {
		return cloudProductPriceService;
	}

	@Override
	public String getViewPath() {
		return "product";
	}
	
	
	/**
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "prodList")
	public String prodList(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {
		
		//产品类型
		List<BasicDictItemVo> prodTypeList = null;
		try {
			prodTypeList = basicDictItemService.getBaiscDictItemListByDictType("prodType");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("prodTypeList", prodTypeList);

		
		QueryContext context = new ECContext(request, modelMap, "prod");
		context.clearParmeters();
		String prodType = request.getParameter("prodType");
		String prodName = request.getParameter("prodName");
		String description = request.getParameter("description");
		String statrDate = request.getParameter("dateS");
		String endDate = request.getParameter("dateE");
		context.put("prodName", prodName);
		context.put("description", description);
		context.put("statrDate", statrDate);
		context.put("endDate", endDate);
		
		//组合产品
		List<ProductPriceVo> prodList = this.cloudProductPriceService.getProdPriceInfo(context, prodType);
		modelMap.put("list", prodList);
		modelMap.put("prodType", prodType);
		modelMap.put("prodName", prodName);
		modelMap.put("description", description);
		modelMap.put("dateS", statrDate);
		modelMap.put("dateE", endDate);
		context.initTotalRows(modelMap);
		
		return "product/prodPriceList";
	}
	
	/**
	 * 
	 * @param request
	 * @param modelMap
	 * @param id
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "editInit")
	public String editInit(HttpServletRequest request, ModelMap modelMap, String id)
			throws ValidatorException {
		String priceMode = request.getParameter("priceMode");
		String prodItemId = request.getParameter("prodItemId");
		CloudMdmProductItemVo prodVo = this.cloudMdmProductItemService.get(prodItemId);
		modelMap.put("prodVo", prodVo);
		
		QueryContext context = new ECContext(request, modelMap, "priceList");
		context.put("$eq_cloudMdmProductItem.id", prodItemId);
		List<?> priceList = this.cloudProductPriceService.list(context);
		
		modelMap.put("priceList", priceList);
		modelMap.put("priceMode", priceMode);
		return "product/prodPriceEdit";
	}
	

	/**
	 * 获取需要定价的产品列表
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap) throws ValidatorException {

		//产品类型
		List<BasicDictItemVo> prodTypeList = null;
		try {
			prodTypeList = basicDictItemService.getBaiscDictItemListByDictType("prodType");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("prodTypeList", prodTypeList);

		QueryContext context = new ECContext(request, modelMap, "prod");
		context.clearParmeters();
		
		String prodType = request.getParameter("prodType");
		if(null == prodType){
			prodType = "cpuSoln";
		}

		//组合产品
		List<Object[]> prodList = this.cloudProductPriceService.getMdmProductPriceInfo(context, prodType);
		modelMap.put("prodList", prodList);
		modelMap.put("prodType", prodType);
		
		return "product/prodMakePriceList";
	}

	/**
	 * 保存产品定价信息
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request,  ModelMap modelMap, @Valid CloudProductPriceVo vo, BindingResult errors) {
		String prodId = request.getParameter("prodId");
		String prodItemId = request.getParameter("prodItemId");
		
		String[] priceId = request.getParameterValues("priceId");
		String[] priceMode = request.getParameterValues("priceMode");
		String[] oneTimePrice = request.getParameterValues("oneTimePrice");
		String[] yearPrice = request.getParameterValues("yearPrice");
		String[] monthPrice = request.getParameterValues("monthPrice");
		String[] dayPrice = request.getParameterValues("dayPrice");
		String[] hourPrice = request.getParameterValues("hourPrice");
		
		String[] effectiveDate = request.getParameterValues("effectiveDate");
		String[] invalidDate = request.getParameterValues("invalidDate");
		
		List<CloudProductPriceVo> voList = new ArrayList<CloudProductPriceVo>();
		if(null != priceMode && priceMode.length>0){
			for(int i=0; i<priceMode.length; i++){
				CloudProductPriceVo priceVo = null;
				//已存在的产品价格日期
				if(priceId != null && priceId.length >= (i+1) && null != priceId[i]){
					try {
						priceVo = this.cloudProductPriceService.get(priceId[i]);
					} catch (ValidatorException e) {
						e.printStackTrace();
					}
				}else{
					priceVo = new CloudProductPriceVo();
				}
				
				try {
					priceVo.setCloudMdmProduct(this.cloudMdmProductService.get(prodId));
					priceVo.setCloudMdmProductItem(this.cloudMdmProductItemService.get(prodItemId));
					
				} catch (ValidatorException e) {
					e.printStackTrace();
				}
				
				priceVo.setPriceMode(priceMode[i]);
				if("0".equals(priceMode[i])){
					//一次性定价
					priceVo.setOneTimePrice(Double.parseDouble("".equals(oneTimePrice[i]) ? "0" : oneTimePrice[i].toString()));
					priceVo.setYearPrice(null);
					priceVo.setMonthPrice(null);
					priceVo.setDayPrice(null);
					priceVo.setHourPrice(null);
				}else{
					//周期性定价
					priceVo.setYearPrice(Double.parseDouble("".equals(yearPrice[i]) ? "0" : yearPrice[i].toString()));
					priceVo.setMonthPrice(Double.parseDouble("".equals(monthPrice[i]) ? "0" : monthPrice[i].toString()));
					priceVo.setDayPrice(Double.parseDouble("".equals(dayPrice[i]) ? "0" : dayPrice[i].toString()));
					priceVo.setHourPrice(Double.parseDouble("".equals(hourPrice[i]) ? "0" : hourPrice[i].toString()));
					priceVo.setOneTimePrice(null);
				}
				priceVo.setEffectiveDate(effectiveDate[i]);
				priceVo.setInvalidDate(invalidDate[i]);
				
				voList.add(priceVo);
			}
		}
		
		try {
			this.cloudProductPriceService.saveProdPrice(voList);
			modelMap.put("saveMsg", "保存成功");
			
		} catch (ValidatorException e) {
			modelMap.put("saveMsg", "保存失败");
			e.printStackTrace();
		}
		try {
			this.editInit(request, modelMap, prodId);
			
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		return "product/prodPriceEdit";
	}




}
