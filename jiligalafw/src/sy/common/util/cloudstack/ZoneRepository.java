package sy.common.util.cloudstack;

import java.util.List;

import sy.common.util.cloudstack.entity.Zone;

/**
 *
 * @author lidongbo
 *
 */
public class ZoneRepository extends AbstractServiceSupport<Zone>{

	private static final String LIST_ZONES = "listZones";
	
	public ZoneRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return LIST_ZONES;
	}

	@Override
	protected String getTagName() {
		return "zone";
	}

	public List<Zone> list(CSQuqeyContext context) {
		context.addParameter(new Param("available", "true"));
		return super.list(context);
	}
	
	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		ZoneRepository service = new ZoneRepository(context);
		
		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
		List<Zone> result = service.list(qc);
		System.out.println(result);
		System.out.println(result.size());

	}
}
