package sy.common.util.cloudstack;

import java.util.List;

import sy.common.util.cloudstack.entity.LoadBalancerRuleInstance;

/**
 * 
 * @author lidongbo
 * 
 */
public class LoadBalancerRuleInstanceRepository extends
		AbstractServiceSupport<LoadBalancerRuleInstance> {

	public LoadBalancerRuleInstanceRepository(ProviderContext provider) {
		super(provider);
	}

	public List<LoadBalancerRuleInstance> list(CSQuqeyContext context) {
		List<LoadBalancerRuleInstance> result = super.list(context);
		Param id = context.getFirst("id");
		if(id == null){
			throw new CloudException("id参数不允许为空!");
		}
		for (LoadBalancerRuleInstance obj : result) {
			obj.setLbruleid(id.getValue());
		}
		return result;
	}
	
	@Override
	protected String getListCommand() {
		return "listLoadBalancerRuleInstances";
	}

	@Override
	protected String getTagName() {
		return "loadbalancerruleinstance";
	}
	
	
	public void addInstance(String lbruleid,List<String> vmids){
		StringBuilder virtualmachineids = new StringBuilder();
		for (String id : vmids) {
			if(virtualmachineids.length()!=0){
				virtualmachineids.append(",");
			}
			virtualmachineids.append(id);
		}
		executeAsyncCMD("assignToLoadBalancerRule", 
				new Param("id",lbruleid),
				new Param("virtualmachineids",virtualmachineids.toString())
		);
	}
	
	public void removeInstance(String lbruleid,List<String> vmids){
		
		StringBuilder virtualmachineids = new StringBuilder();
		for (String id : vmids) {
			if(virtualmachineids.length()!=0){
				virtualmachineids.append(",");
			}
			virtualmachineids.append(id);
		}
		executeAsyncCMD("removeFromLoadBalancerRule", 
				new Param("id",lbruleid),
				new Param("virtualmachineids",virtualmachineids.toString())
		);
	}
	
	public static void main(String[] args) {
		
//		ProviderContext context = new ProviderContext();
//		LoadBalancerRuleInstanceRepository service = new LoadBalancerRuleInstanceRepository(context);
		
//		List vmids = new ArrayList();
//		vmids.add("6db00f00-df03-40a1-bc93-0fca26d89c2a");
//		vmids.add("4a3c6a43-f3db-4296-878a-4e6a2399145c");
//		service.addInstance("8893984d-e48e-466f-8ea5-738dd64c0793", vmids);
		
//		List vmids = new ArrayList();
//		vmids.add("6db00f00-df03-40a1-bc93-0fca26d89c2a");
//		vmids.add("4a3c6a43-f3db-4296-878a-4e6a2399145c");
//		service.removeInstance("8893984d-e48e-466f-8ea5-738dd64c0793", vmids);
	}
}
