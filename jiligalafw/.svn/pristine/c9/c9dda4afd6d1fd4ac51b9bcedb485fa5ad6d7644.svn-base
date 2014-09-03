package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Networkoffering;

/**
 * 
 * @author lidongbo
 * 
 */
public class NetworkofferingRepository extends
		AbstractServiceSupport<Networkoffering> {

	public NetworkofferingRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listNetworkOfferings";
	}

	@Override
	protected String getTagName() {
		return "networkoffering";
	}

}
