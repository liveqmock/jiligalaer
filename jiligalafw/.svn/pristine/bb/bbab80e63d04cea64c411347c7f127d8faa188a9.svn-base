package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Serviceoffering;

/**
 * 
 * @author lidongbo
 * 
 */
public class ServiceofferingRepository extends
		AbstractServiceSupport<Serviceoffering> {

	private static final String LIST_SERVICEOFFERINGS = "listServiceOfferings";
	
	public ServiceofferingRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return LIST_SERVICEOFFERINGS;
	}

	@Override
	protected String getTagName() {
		return "serviceoffering";
	}

}
