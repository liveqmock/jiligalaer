package sy.controller.product;

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
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.product.CloudMdmCPUSolnVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkSolnServiceI;
import sy.service.product.CloudMdmProductItemServiceI;
import sy.service.product.CloudMdmProductServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmZoneServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 我的资源 - IP地址申请
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/applyIp")
@SessionAttributes("cloudMdmProductVo")
public class ApplyIPaddrController extends BaseControllerTemplate<CloudMdmProductVo> {
	
	//产品基础数据
	@Autowired
	private CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService;
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
	
	@Override
	public BasicServiceI<CloudMdmProductVo> getService() {
		return cloudMdmProductService;
	}
	
	public String getViewPath() {
		return "myresources";
	}
	
	/**
	 * 发送申请IP
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException
	 */
	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap, @Valid CloudMdmProductVo vo, BindingResult errors) {
		
		modelMap.put("mess", "IP地址申请成功");
		
		return "myresources/applyIPAddr_finish";
	}

	/**
	 * 申请IP地址 - 网络列表
	 * @param request
	 * @param response
	 * @param vo
	 * @param modelMap
	 * @return
	 * @throws ValidatorException 
	 */
	@RequestMapping(value = "selectNetwork")
	public String selectNetwork(HttpServletRequest request,
			HttpServletResponse response, CloudMdmCPUSolnVo vo, ModelMap modelMap) throws ValidatorException {
		
		QueryContext context = new ECContext(request, modelMap, "network");
		List<?> list = this.cloudMdmNetworkSolnService.list(context);
		modelMap.put("list", list);
		
		return "myresources/applyIPAddr_selectNetwork";
	}


}
