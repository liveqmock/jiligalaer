package sy.common.util.cloudstack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;

import sy.common.util.cloudstack.entity.NetworkType;
import sy.common.util.cloudstack.entity.Virtualmachine;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author lidongbo
 * 
 */
public class VirtualmachineRepository extends
		AbstractServiceSupport<Virtualmachine> {

	private static final String listVirtualMachines = "listVirtualMachines";
	private static final String deployVirtualMachine = "deployVirtualMachine";

	public VirtualmachineRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return listVirtualMachines;
	}

	@Override
	protected String getTagName() {
		return "virtualmachine";
	}

	public Virtualmachine create(String domainid, String accountName, String zoneid,
			String serviceofferingid,String diskofferingid, String templateid, List<String> networkOrSecuritygroupIds,
			String name,NetworkType networkType,Integer disksize,Date stoptime) {
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();
		
		Param param = new Param("domainid",domainid);
		parameters.add(param);
		param = new Param("account",accountName);
		parameters.add(param);
		param = new Param("zoneid",zoneid);
		parameters.add(param);
		param = new Param("serviceofferingid",serviceofferingid);
		parameters.add(param);
		param = new Param("diskofferingid",diskofferingid);
		parameters.add(param);
		param = new Param("templateid",templateid);
		parameters.add(param);
		if(networkOrSecuritygroupIds!=null){
			StringBuilder nwids = new StringBuilder();
			for (String id : networkOrSecuritygroupIds) {
				if(nwids.length()!=0){
					nwids.append(",");
				}
				nwids.append(id);
			}
			if(networkType == NetworkType.Advanced){
				param = new Param("networkids",nwids);
			}else if(networkType == NetworkType.Basic){
				param = new Param("securitygroupids",nwids);
			}
			parameters.add(param);
		}
		param = new Param("name",name);
		parameters.add(param);
		
		//stoptime=2013-03-20 16:12:12
		if (stoptime != null) {
			param = new Param("stoptime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stoptime));
			parameters.add(param);
		}
		
		param = new Param("size",disksize);
		parameters.add(param);
		
		String url = method.buildUrl(deployVirtualMachine,
				parameters.toArray(new Param[] {}));

		Document doc = method.get(url);

		try {
			doc = waitForJob(doc, deployVirtualMachine + " job.");
		} catch (Exception e) {
			throw new CloudException(e);
		}

		List<Virtualmachine> beans = doc2beans(doc, getTagName());
		if (beans != null) {
			return beans.get(0);
		}
		throw new CloudException("error. vm is empty.");
	}

	public void startup(String virtualmachineid) {
		executeAsyncCMD("startVirtualMachine", new Param("id",virtualmachineid));
	}

	public void stop(String virtualmachineid,Boolean forced) {
		executeAsyncCMD("stopVirtualMachine",
				new Param("id", virtualmachineid), new Param("forced", forced));
	}

	public void reboot(String virtualmachineid) {
		executeAsyncCMD("rebootVirtualMachine", new Param("id",virtualmachineid));
	}

	public void destroy(String virtualmachineid) {
		executeAsyncCMD("destroyVirtualMachine", new Param("id",virtualmachineid));
	}

	public void restore(String virtualmachineid) {
		executeAsyncCMD("restoreVirtualMachine", new Param("id",virtualmachineid));
	}
	
	public void resetPassword(String virtualmachineid) {
		executeAsyncCMD("resetPasswordForVirtualMachine", new Param("id",virtualmachineid));
	}
	
	public void changeService(String virtualmachineid, String serviceofferingid) {
		executeSyncCMD("changeServiceForVirtualMachine", new Param("id",
				virtualmachineid), new Param("serviceofferingid",
				serviceofferingid));
	}
	
	public void addDiskService(String virtualmachineid, String volumeid) {
		executeAsyncCMD("attachVolume", new Param("id", volumeid), new Param(
				"virtualmachineid", virtualmachineid));
	}

}
