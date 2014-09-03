package sy.common.util.cloudstack.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lidongbo
 * 
 */
public class Service extends CloudBeanSupport {

	private String name;
	
	@EntityClass(cloudBean = Capability.class)
	private List<Capability> capability = new ArrayList<Capability>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Capability> getCapability() {
		return capability;
	}

	public void setCapability(List<Capability> capability) {
		this.capability = capability;
	}
	
	
}
