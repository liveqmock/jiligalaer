package sy.common.util.cloudstack;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import sy.common.util.cloudstack.entity.Network;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author lidongbo
 * 
 */
public class NetworkRepository extends AbstractServiceSupport<Network> {

	public NetworkRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listNetworks";
	}

	@Override
	protected String getTagName() {
		return "network";
	}

	protected String getCreateCommand() {
		return "createNetwork";
	}
	
	public void delete(String networkId){
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("id", networkId);
		parameters.add(param);

		String url = method.buildUrl("deleteNetwork",
				parameters.toArray(new Param[] {}));

		Document doc;
		try {
			doc = method.get(url);
			
			try {
				doc = waitForJob(doc, "delete network job.");
			} catch (Exception e) {
				throw new CloudException(e);
			}
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		NetworkRepository service = new NetworkRepository(context);

//		Network obj = new Network();
//		obj.setDomainid("1");
//		obj.setAccount("cms_limou");
//		obj.setName("cms_limou_test1");
//		obj.setDisplaytext("cms_limou_displaytext_test1");
//		obj.setZoneid("c7650b06-4c5b-4077-a53c-6103aba25f69");
//		obj.setNetworkofferingid("a672210d-7788-4445-97ff-5a8c50188c8d");
//		
//		Network objResult = service.create(obj);
//		System.out.println(obj);
//		System.out.println(objResult);
//
//		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
//		List<Network> result = service.list(qc);
//		System.out.println(result);
//		System.out.println(result.size());
		
		service.delete("6d8b3051-b094-4f0f-9f8c-30b74b7b1626");

	}
}
