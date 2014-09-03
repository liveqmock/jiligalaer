package sy.common.util.cloudstack;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import sy.common.util.cloudstack.entity.Firewallrule;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author lidongbo
 * 
 */
public class FirewallruleRepository extends
		AbstractServiceSupport<Firewallrule> {

	public FirewallruleRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listFirewallRules";
	}
	
	@Asynchronous
	protected String getCreateCommand() {
		return "createFirewallRule";
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

		String url = method.buildUrl("deleteFirewallRule",
				parameters.toArray(new Param[] {}));

		Document doc;
		try {
			doc = method.get(url);
			
			try {
				doc = waitForJob(doc, "delete firewallRule job.");
			} catch (Exception e) {
				throw new CloudException(e);
			}
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		FirewallruleRepository service = new FirewallruleRepository(context);

//		Firewallrule obj = new Firewallrule();
//		obj.setIpaddressid("4dc323ce-04c2-4650-a77c-c507d31e8e01");
//		obj.setProtocol("TCP");
//		obj.setCidrlist("10.1.1.0/25");
//		obj.setStartport("5");
//		obj.setEndport("6");
//		obj.setIcmpcode("");
//		obj.setIcmptype("");
//		
//		Firewallrule objResult = service.create(obj);
//		System.out.println(obj);
//		System.out.println(objResult);
		
		service.delete("7a72639d-ddea-4ffc-a065-ccfbdaf820da");
	}

}
