package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Domain;


/**
 *
 * @author lidongbo
 *
 */
public class DomainRepository extends AbstractServiceSupport<Domain> {

	private static final String CREATE = "createDomain";

	private static final String LIST = "listDomains";
	
	public DomainRepository(ProviderContext provider) {
		super(provider);
	}
	
	protected String getCreateCommand() {
		return CREATE;
	}
	
	@Override
	protected String getListCommand() {
		return LIST;
	}

	@Override
	protected String getTagName() {
		return "domain";
	}

}
