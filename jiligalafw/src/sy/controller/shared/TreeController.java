package sy.controller.shared;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.cloudstack.entity.FreeuserIpaddressByZoneid;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.product.CloudMdmNicVo;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.domain.vo.product.CloudMdmZoneVo;
import sy.domain.vo.shared.TreeVo;
import sy.service.base.BasicUserServiceI;
import sy.service.product.CloudMdmFreeIPServiceI;
import sy.service.product.CloudMdmNicServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmZoneServiceI;

/**
 *
 * @author lidongbo
 *
 */

@Controller
@RequestMapping("/tree")
public class TreeController extends BaseController {
	
	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	@Autowired
	private CloudMdmZoneServiceI cloudMdmZoneService;
	@Autowired
	private CloudMdmNicServiceI cloudMdmNicService;
	@Autowired
	private CloudMdmFreeIPServiceI cloudMdmFreeIPService;
	
	
	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
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

	
	public CloudMdmNicServiceI getCloudMdmNicService() {
		return cloudMdmNicService;
	}

	public void setCloudMdmNicService(CloudMdmNicServiceI cloudMdmNicService) {
		this.cloudMdmNicService = cloudMdmNicService;
	}

	public CloudMdmFreeIPServiceI getCloudMdmFreeIPService() {
		return cloudMdmFreeIPService;
	}

	public void setCloudMdmFreeIPService(
			CloudMdmFreeIPServiceI cloudMdmFreeIPService) {
		this.cloudMdmFreeIPService = cloudMdmFreeIPService;
	}

	
	@RequestMapping(value = "example")
	public String example(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		List<TreeVo> nodes = new ArrayList<TreeVo>();	
		TreeVo v1 = new TreeVo();
		v1.setId("1");
		v1.setPid("0");
		v1.setName("A1");
		nodes.add(v1);
		TreeVo v2 = new TreeVo();
		v2.setId("11");
		v2.setPid("1");
		v2.setName("A11");
		nodes.add(v2);
		
		
		TreeVo v3 = new TreeVo();
		v3.setId("12");
		v3.setPid("1");
		v3.setName("A12");
		nodes.add(v3);
		request.setAttribute("tree", nodes);
		
		return "commons/ztree";
	}
	
	@RequestMapping(value = "accountTree")
	public String accountTree(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		List<TreeVo> nodes = new ArrayList<TreeVo>();
		QueryContext context = new QueryContext(request, modelMap, "accountTree",false);
		String userFlag = request.getParameter("userFlag");
		context.put("$eq_state", String.valueOf(Constants.USER_STATE_PASS));
		
		List<BasicUserVo> list = this.basicUserService.list(context);
		for(BasicUserVo vo : list){
			if(userFlag.equals(vo.getUserFlag().toString())){
				TreeVo treeVo = new TreeVo();
				//treeVo.setResult(false);
				treeVo.setPid("a");
				treeVo.setId(vo.getUserId());
				treeVo.setName(vo.getUserAccount());
				nodes.add(treeVo);
			}
		}
		
		request.setAttribute("tree", nodes);
		return "commons/ztree";
	}

	@RequestMapping(value = "vmTree")
	public String vmTree(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		List<TreeVo> nodes = new ArrayList<TreeVo>();
		QueryContext context = new QueryContext(request, modelMap, "vmTree", false);
		
		//静态nat绑定时：必须是在本IP地址所在网络下的虚机
		//缺少条件：网络ID
		String networkId = request.getParameter("networkId");
		context.clearParmeters();
		context.put("$eq_networkId", networkId);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		List<CloudMdmNicVo> nicList = this.cloudMdmNicService.list(context);
		String vmIds ="";
		for(CloudMdmNicVo nicVo : nicList){
			vmIds += nicVo.getVirtualmachineId()+",";
		}
		if(vmIds.length() > 1){
			vmIds = vmIds.substring(0,vmIds.length()-1);
		}else{
			vmIds = "-1";
		}
		
		context.clearParmeters();
		BasicUserVo basicUser = (BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		if(basicUser.getUserFlag() > 1){
			context.put("$eq_account", basicUser.getParentBasicUser().getUserAccount());
		}else{
			context.put("$eq_account", basicUser.getUserAccount());
		}
		context.put("$in_interfaceId", vmIds);
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		
		List<CloudMdmVmVo> list = this.cloudMdmVMService.list(context);
		for(CloudMdmVmVo vo : list){
			TreeVo treeVo = new TreeVo();
			treeVo.setPid("a");
			treeVo.setId(vo.getInterfaceId());
			treeVo.setName(vo.getDisplayName());
			nodes.add(treeVo);
		}
		
		request.setAttribute("tree", nodes);
		return "commons/ztree";
	}

	@RequestMapping(value = "zoneTree")
	public String zoneTree(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		List<TreeVo> nodes = new ArrayList<TreeVo>();
		QueryContext context = new QueryContext(request, modelMap, "zoneTree", false);
		context.put("$eq_networkType", "Advanced");
		context.put("$eq_dataState", String.valueOf(Constants.VALID_STATE));
		
		List<CloudMdmZoneVo> list = this.cloudMdmZoneService.list(context);
		for(CloudMdmZoneVo vo : list){
			TreeVo treeVo = new TreeVo();
			treeVo.setPid("a");
			treeVo.setId(vo.getInterfaceId());
			treeVo.setName(vo.getName());
			nodes.add(treeVo);
		}
		
		request.setAttribute("tree", nodes);
		return "commons/ztree";
	}

	@RequestMapping(value = "ipTree")
	public String ipTree(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		List<TreeVo> nodes = new ArrayList<TreeVo>();
		List<FreeuserIpaddressByZoneid> list = cloudMdmFreeIPService.getFreeIpAddressByZoneid(request.getParameter("zoneid"));
		
		for(FreeuserIpaddressByZoneid vo : list){
			TreeVo treeVo = new TreeVo();
			treeVo.setPid("a");
			treeVo.setId(vo.getUseripaddressid());
			treeVo.setName(vo.getPublicipaddress());
			nodes.add(treeVo);
		}
		
		request.setAttribute("tree", nodes);
		return "commons/ztree";
	}
}
