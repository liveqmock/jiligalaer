package sy.controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.controller.shared.BaseController;
import sy.service.cloud.CloudEventServiceI;
import sy.service.cloud.CloudMdmAccountServiceI;
import sy.service.cloud.CloudMdmUserServiceI;
import sy.service.product.CloudLBStickinessPolicyServiceI;
import sy.service.product.CloudLoadBalancerRuleInstanceServiceI;
import sy.service.product.CloudLoadbalancerruleServiceI;
import sy.service.product.CloudMdmCPUSolnServiceI;
import sy.service.product.CloudMdmDiskSolnServiceI;
import sy.service.product.CloudMdmEgressFirewallRuleServiceI;
import sy.service.product.CloudMdmFirewallruleServiceI;
import sy.service.product.CloudMdmIPServiceI;
import sy.service.product.CloudMdmNetworkServiceI;
import sy.service.product.CloudMdmNetworkSolnServiceI;
import sy.service.product.CloudMdmTemplateServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudMdmVolumeServiceI;
import sy.service.product.CloudMdmZoneServiceI;
import sy.service.product.CloudPortForwardingRuleServiceI;
import sy.service.product.CloudRemoteaccessVpnServiceI;
import sy.service.product.CloudSecurityGroupServiceI;
import sy.service.product.CloudVpnUserServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Controller
@RequestMapping("/sync")
public class SynchronizeDataController extends BaseController {

	private static final Logger log = Logger
			.getLogger(SynchronizeDataController.class);

	@Autowired
	private CloudMdmCPUSolnServiceI cloudMdmCPUSolnService;

	@Autowired
	private CloudMdmDiskSolnServiceI cloudMdmDiskSolnService;

	@Autowired
	private CloudMdmIPServiceI cloudMdmIPService;

	@Autowired
	private CloudMdmNetworkSolnServiceI cloudMdmNetworkSolnService;

	@Autowired
	private CloudMdmTemplateServiceI cloudMdmTemplateService;

	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;

	@Autowired
	private CloudMdmZoneServiceI cloudMdmZoneService;

	@Autowired
	private CloudMdmNetworkServiceI cloudMdmNetworkService;

	@Autowired
	private CloudMdmVolumeServiceI cloudMdmVolumeService;

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;

	@Autowired
	private CloudMdmUserServiceI cloudMdmUserService;

	@Autowired
	private CloudMdmEgressFirewallRuleServiceI cloudMdmEgressFirewallRuleService;

	@Autowired
	private CloudMdmFirewallruleServiceI cloudMdmFirewallruleService;

	@Autowired
	private CloudSecurityGroupServiceI cloudSecurityGroupService;

	@Autowired
	private CloudPortForwardingRuleServiceI cloudPortForwardingRuleService;

	@Autowired
	private CloudRemoteaccessVpnServiceI cloudRemoteaccessVpnService;

	@Autowired
	private CloudVpnUserServiceI cloudVpnUserService;

	@Autowired
	private CloudEventServiceI cloudEventService;

	@Autowired
	private CloudLoadbalancerruleServiceI cloudLoadbalancerruleService;
	
	@Autowired
	private CloudLBStickinessPolicyServiceI cloudLBStickinessPolicyService;
	
	@Autowired
	private CloudLoadBalancerRuleInstanceServiceI cloudLoadBalancerRuleInstanceService;
	
	@RequestMapping
	public String sync(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		try {
			cloudMdmCPUSolnService.sync();
			cloudMdmDiskSolnService.sync();
			cloudMdmIPService.sync();
			cloudMdmNetworkSolnService.sync();
			cloudMdmTemplateService.sync();
			cloudMdmVMService.sync();
			cloudMdmZoneService.sync();
			cloudMdmNetworkService.sync();
			cloudMdmVolumeService.sync();
			cloudMdmAccountService.sync();
			cloudMdmUserService.sync();
			cloudMdmEgressFirewallRuleService.sync();
			cloudMdmFirewallruleService.sync();
			cloudSecurityGroupService.sync();
			cloudPortForwardingRuleService.sync();
			cloudRemoteaccessVpnService.sync();
			cloudVpnUserService.sync();
			cloudEventService.sync();
			cloudLoadbalancerruleService.sync();
			cloudLBStickinessPolicyService.sync();
			cloudLoadBalancerRuleInstanceService.sync();
//			cloudMdmVMService.addDiskService("b1624e5f-3607-446e-b3aa-b1f53bbcb524", "admin", "159cf1bf-1709-4dfd-818c-3c0fdf2da7ab", null);
			
		} catch (Exception e) {
			log.error(e.getCause(), e);
		}

		return null;
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

	public CloudMdmTemplateServiceI getCloudMdmTemplateService() {
		return cloudMdmTemplateService;
	}

	public void setCloudMdmTemplateService(
			CloudMdmTemplateServiceI cloudMdmTemplateService) {
		this.cloudMdmTemplateService = cloudMdmTemplateService;
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

	public CloudMdmNetworkServiceI getCloudMdmNetworkService() {
		return cloudMdmNetworkService;
	}

	public void setCloudMdmNetworkService(
			CloudMdmNetworkServiceI cloudMdmNetworkService) {
		this.cloudMdmNetworkService = cloudMdmNetworkService;
	}

	public CloudMdmVolumeServiceI getCloudMdmVolumeService() {
		return cloudMdmVolumeService;
	}

	public void setCloudMdmVolumeService(
			CloudMdmVolumeServiceI cloudMdmVolumeService) {
		this.cloudMdmVolumeService = cloudMdmVolumeService;
	}

	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}

	public CloudMdmUserServiceI getCloudMdmUserService() {
		return cloudMdmUserService;
	}

	public void setCloudMdmUserService(CloudMdmUserServiceI cloudMdmUserService) {
		this.cloudMdmUserService = cloudMdmUserService;
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

	public CloudPortForwardingRuleServiceI getCloudPortForwardingRuleService() {
		return cloudPortForwardingRuleService;
	}

	public void setCloudPortForwardingRuleService(
			CloudPortForwardingRuleServiceI cloudPortForwardingRuleService) {
		this.cloudPortForwardingRuleService = cloudPortForwardingRuleService;
	}

	public CloudRemoteaccessVpnServiceI getCloudRemoteaccessVpnService() {
		return cloudRemoteaccessVpnService;
	}

	public void setCloudRemoteaccessVpnService(
			CloudRemoteaccessVpnServiceI cloudRemoteaccessVpnService) {
		this.cloudRemoteaccessVpnService = cloudRemoteaccessVpnService;
	}

	public CloudVpnUserServiceI getCloudVpnUserService() {
		return cloudVpnUserService;
	}

	public void setCloudVpnUserService(CloudVpnUserServiceI cloudVpnUserService) {
		this.cloudVpnUserService = cloudVpnUserService;
	}

	public CloudEventServiceI getCloudEventService() {
		return cloudEventService;
	}

	public void setCloudEventService(CloudEventServiceI cloudEventService) {
		this.cloudEventService = cloudEventService;
	}

	public CloudLoadbalancerruleServiceI getCloudLoadbalancerruleService() {
		return cloudLoadbalancerruleService;
	}

	public void setCloudLoadbalancerruleService(
			CloudLoadbalancerruleServiceI cloudLoadbalancerruleService) {
		this.cloudLoadbalancerruleService = cloudLoadbalancerruleService;
	}

	public CloudLBStickinessPolicyServiceI getCloudLBStickinessPolicyService() {
		return cloudLBStickinessPolicyService;
	}

	public void setCloudLBStickinessPolicyService(
			CloudLBStickinessPolicyServiceI cloudLBStickinessPolicyService) {
		this.cloudLBStickinessPolicyService = cloudLBStickinessPolicyService;
	}

	public CloudLoadBalancerRuleInstanceServiceI getCloudLoadBalancerRuleInstanceService() {
		return cloudLoadBalancerRuleInstanceService;
	}

	public void setCloudLoadBalancerRuleInstanceService(
			CloudLoadBalancerRuleInstanceServiceI cloudLoadBalancerRuleInstanceService) {
		this.cloudLoadBalancerRuleInstanceService = cloudLoadBalancerRuleInstanceService;
	}

}
