package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Diskoffering;

/**
 *
 * @author lidongbo
 *
 */
public class DiskofferingRepository extends AbstractServiceSupport<Diskoffering> {

	private static final String LIST_DISKOFFERINGS = "listDiskOfferings";
	
	public DiskofferingRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return LIST_DISKOFFERINGS;
	}

	@Override
	protected String getTagName() {
		return "diskoffering";
	}

	
	
}
