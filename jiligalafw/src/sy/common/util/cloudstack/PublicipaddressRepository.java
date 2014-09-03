package sy.common.util.cloudstack;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import sy.common.util.cloudstack.entity.Publicipaddress;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 *
 * @author lidongbo
 *
 */
public class PublicipaddressRepository extends AbstractServiceSupport<Publicipaddress> {

	private static final String LIST_PUBLICIPADDRESSES = "listPublicIpAddresses";
	
	public PublicipaddressRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return LIST_PUBLICIPADDRESSES;
	}

	@Override
	protected String getTagName() {
		return "publicipaddress";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "associateIpAddress";
	}
	
	protected String getCreatedTagName(){
		return "ipaddress";
	}
	
	public void delete(String ipid) {
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("id", ipid);
		parameters.add(param);

		String url = method.buildUrl("disassociateIpAddress",
				parameters.toArray(new Param[] {}));

		Document doc;
		try {
			doc = method.get(url);
			
			try {
				doc = waitForJob(doc, "disassociateIpAddress job.");
			} catch (Exception e) {
				throw new CloudException(e);
			}
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public void enableStaticNat(String ipaddressid,String virtualmachineid) {
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("virtualmachineid", virtualmachineid);
		parameters.add(param);
		param = new Param ("ipaddressid",ipaddressid);
		parameters.add(param);
		
		String url = method.buildUrl("enableStaticNat",
				parameters.toArray(new Param[] {}));

		try {
			method.get(url);
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public void disableStaticNat(String ipaddressid) {
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param ("ipaddressid",ipaddressid);
		parameters.add(param);
		
		String url = method.buildUrl("disableStaticNat",
				parameters.toArray(new Param[] {}));

		Document doc;
		try {
			doc = method.get(url);
			
			try {
				doc = waitForJob(doc, "disassociateIpAddress job.");
			} catch (Exception e) {
				throw new CloudException(e);
			}
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		
		ProviderContext context = new ProviderContext();
		PublicipaddressRepository service = new PublicipaddressRepository(context);

//		Publicipaddress obj = new Publicipaddress();
//		obj.setDomainid("1");
//		obj.setAccount("cms_limou");
////		obj.setZoneid("c7650b06-4c5b-4077-a53c-6103aba25f69");
//		obj.setNetworkid("5661dd9d-435b-43dd-852d-936c4dc0b880");
//		
//		Publicipaddress result = service.create(obj);
//		System.out.println(obj);
//		System.out.println(result);
		
//		service.delete("31d59eb6-3b24-4419-917b-452f3f8d94a0");
//		service.enableStaticNat("31d59eb6-3b24-4419-917b-452f3f8d94a0", "24d5d416-885d-40f9-b8ae-e241bd6415e5");
		service.disableStaticNat("31d59eb6-3b24-4419-917b-452f3f8d94a0");
	}
}
