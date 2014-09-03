package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.LoadBalancerAlgorithm;
import sy.common.util.cloudstack.entity.Loadbalancerrule;

/**
 *
 * @author lidongbo
 *
 */
public class LoadbalancerruleRepository extends AbstractServiceSupport<Loadbalancerrule> {

	public LoadbalancerruleRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listLoadBalancerRules";
	}

	@Override
	protected String getTagName() {
		return "loadbalancerrule";
	}
	
	@Asynchronous
	protected String getCreateCommand() {
		return "createLoadBalancerRule";
	}
	
	protected String getCreatedTagName() {
		return "loadbalancer";
	}
	
	public void update(String id, String name, String description,
			LoadBalancerAlgorithm algorithm) {
		executeAsyncCMD("updateLoadBalancerRule", 
				new Param("id",id),
				new Param("name",name),
				new Param("description",description),
				new Param("algorithm",algorithm.CODE)
		);
	}
	
	public void delete(String ruleid) {
		super.delete("id", ruleid, "deleteLoadBalancerRule");
	}
	
	public static void main(String[] args) {
		
//		ProviderContext context = new ProviderContext();
//		LoadbalancerruleRepository service = new LoadbalancerruleRepository(context);
		
//		Loadbalancerrule bean = new Loadbalancerrule();
//		
//		bean.setAccount("limou@a.com");
//		bean.setDomainid("1");
//		bean.setName("blan_test_1");
//		bean.setPublicipid("10d329a2-a471-4ada-a660-68bcc3df0241");
//		bean.setPublicport("4");
//		bean.setPrivateport("4");
//		bean.setAlgorithm("roundrobin");
//		
//		service.create(bean);
		
//		service.update(
//				"2eaecbee-0fbd-46a7-b6c6-10355053f5a8", 
//				"blan_test_2", "description", 
//				LoadBalancerAlgorithm.source);
		
//		service.delete("2eaecbee-0fbd-46a7-b6c6-10355053f5a8");
		
	}
}
