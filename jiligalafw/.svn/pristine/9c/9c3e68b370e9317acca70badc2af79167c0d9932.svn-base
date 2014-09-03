package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Egressrule;
import sy.common.util.cloudstack.entity.Ingressrule;
import sy.common.util.cloudstack.entity.SecurityGroup;

/**
 * 
 * @author lidongbo
 * 
 */
public class SecurityGroupRepository extends
		AbstractServiceSupport<SecurityGroup> {

	public SecurityGroupRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listSecurityGroups";
	}

	@Override
	protected String getTagName() {
		return "securitygroup";
	}

	protected String getCreateCommand() {
		return "createSecurityGroup";
	}
	
	public void delete(String securityGroupId){
		super.delete("id", securityGroupId, "deleteSecurityGroup");
	}
	
//	public Ingressrule createIngressrule(String securityGroupId, String cidrlist,
//			String domainId, String account, 
//			String protocol,
//			String startport, String endport,
//			String icmpcode, String icmptype) {
	
	public Ingressrule createIngressrule(Ingressrule ingressrule) {
		IngressruleRepository service = new IngressruleRepository(provider);
		return service.create(ingressrule);
	}
	
	public void deleteIngressrule(String ingressruleId) {
		IngressruleRepository service = new IngressruleRepository(provider);
		service.delete(ingressruleId);
	}
	
	public Egressrule createEgressrule(Egressrule egressrule) {
		EgressruleRepository service = new EgressruleRepository(provider);
		return service.create(egressrule);
	}
	
	public void deleteEgressrule(String egressruleId) {
		EgressruleRepository service = new EgressruleRepository(provider);
		service.delete(egressruleId);
	}
	
	public static void main(String[] args) {
		
		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);

//		SecurityGroup obj = new SecurityGroup();
//		obj.setAccount("cms_limou");
//		obj.setDomainid("1");
//		obj.setDescription("if_test");
//		obj.setName("if_test_name");
//		
//		SecurityGroup objResult = service.create(obj);
//		System.out.println(obj);
//		System.out.println(objResult);
//		
//		Ingressrule ingressrule = new Ingressrule();
//		ingressrule.setSecuritygroupid(objResult.getId());
//		ingressrule.setCidrlist("10.1.1.0/0");
//		ingressrule.setProtocol("TCP");
//		ingressrule.setStartport("1");
//		ingressrule.setEndport("100");
//		service.createIngressrule(ingressrule);
//
//		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
//		List<SecurityGroup> result = service.list(qc);
//		System.out.println(result);
//		System.out.println(result.size());
//
//		service.delete("cf4e5dce-82b3-40f1-b9c2-df5606ddeff8");
		service.deleteIngressrule("783a1c5f-8289-4416-a961-9153572dd4c2");
		
	}
	
}
