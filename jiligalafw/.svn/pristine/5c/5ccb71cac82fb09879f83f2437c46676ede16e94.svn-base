package sy.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.SecurityGroupRepository;
import sy.common.util.cloudstack.entity.SecurityGroup;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudSecurityGroup;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudEgressruleVo;
import sy.domain.vo.product.CloudIngressruleVo;
import sy.domain.vo.product.CloudSecurityGroupVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudSecurityGroupService")
public class CloudSecurityGroupService extends
		SynchronizeDataService<CloudSecurityGroup, CloudSecurityGroupVo>
		implements CloudSecurityGroupServiceI {

	@Autowired
	private CloudEgressruleServiceI cloudEgressruleService;

	@Autowired
	private CloudIngressruleServiceI cloudIngressruleService;
	
	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;
	
	protected void invalid(String interfaceId) throws ValidatorException{
		update("Update CloudEgressrule Set dataState = 0 Where interfaceId = ? ", interfaceId);
		update("Update CloudIngressrule Set dataState = 0 Where interfaceId = ? ", interfaceId);
	}
	
	protected void afterSync(List<CloudSecurityGroupVo> vos) throws ValidatorException{
		
		List<CloudEgressruleVo> egressrules = new ArrayList<CloudEgressruleVo>();
		List<CloudIngressruleVo> ingressrules = new ArrayList<CloudIngressruleVo>();
		
		for (CloudSecurityGroupVo cloudSecurityGroupVo : vos) {
			egressrules.addAll(cloudSecurityGroupVo.getEgressrule());
			ingressrules.addAll(cloudSecurityGroupVo.getIngressrule());
		}
		
		cloudEgressruleService.sync(egressrules);
		cloudIngressruleService.sync(ingressrules);
	}
	
	@Override
	public List<CloudSecurityGroupVo> getSecurityGroupListByAccount(String account)
			throws Exception {
		// TODO Auto-generated method stub
		List<CloudSecurityGroupVo> securityGroupList = null;
		try {
			securityGroupList = this.find(
					"from CloudSecurityGroup where dataState=1 and account = ? ",new Object[]{account});
		} catch (Exception e) {
			throw new Exception("获取账户安全组列表出错：" + e.getMessage());
		}
		return securityGroupList;
	}
	
	
	
	public void create(String accountName, String name,
			String description) throws ValidatorException,CloudException {

		CloudMdmAccountVo account = cloudMdmAccountService.findAccountByName(accountName);
		if(account == null){
			throw new ValidatorException("接口中不存在该账户."+accountName);
		}
		
		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);

		SecurityGroup obj = new SecurityGroup();
		obj.setAccount(accountName);
		obj.setDomainid(account.getDomainid());
		obj.setDescription(description);
		obj.setName(name);

		SecurityGroup result = service.create(obj);

		CloudSecurityGroupVo vo = createVo(result);

		save(vo);
	}

	public void delete(String securityGroupId) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);
		service.delete(securityGroupId);
		update("Update CloudSecurityGroup Set dataState = 0 Where interfaceId = ?",
				securityGroupId);
	}
	
	
	@Override
	public CloudSecurityGroupVo getSecurityGroupByID(String id) {
		return findUnique("From CloudSecurityGroup Where  id = ?", id);
	}
	
	public CloudEgressruleServiceI getCloudEgressruleService() {
		return cloudEgressruleService;
	}

	public void setCloudEgressruleService(
			CloudEgressruleServiceI cloudEgressruleService) {
		this.cloudEgressruleService = cloudEgressruleService;
	}

	public CloudIngressruleServiceI getCloudIngressruleService() {
		return cloudIngressruleService;
	}

	public void setCloudIngressruleService(
			CloudIngressruleServiceI cloudIngressruleService) {
		this.cloudIngressruleService = cloudIngressruleService;
	}

	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}

	

}
