package sy.common.util.cloudstack;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import sy.common.util.cloudstack.entity.EgressFirewallRule;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author lidongbo
 * 
 */
public class EgressFirewallRuleRepository extends
		AbstractServiceSupport<EgressFirewallRule> {

	public EgressFirewallRuleRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listEgressFirewallRules";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "createEgressFirewallRule";
	}
	
	@Override
	protected String getTagName() {
		return "firewallrule";
	}

	public void delete(String firewallRuleId){
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("id", firewallRuleId);
		parameters.add(param);

		String url = method.buildUrl("deleteEgressFirewallRule",
				parameters.toArray(new Param[] {}));

		Document doc;
		try {
			doc = method.get(url);
			
			try {
				doc = waitForJob(doc, "delete EgressFirewallRule job.");
			} catch (Exception e) {
				throw new CloudException(e);
			}
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		
		ProviderContext context = new ProviderContext();
		EgressFirewallRuleRepository service = new EgressFirewallRuleRepository(context);

		EgressFirewallRule obj = new EgressFirewallRule();
		obj.setCidrlist("10.1.1.0/27");
		obj.setNetworkid("3cd68f73-1ede-4062-86da-ab18319c62fd");
		obj.setStartport("5");
		obj.setEndport("6");
		obj.setProtocol("TCP");
		
		EgressFirewallRule objResult = service.create(obj);
		System.out.println(obj);
		System.out.println(objResult);

		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
		List<EgressFirewallRule> result = service.list(qc);
		System.out.println(result);
		System.out.println(result.size());
		
	}
	
}
