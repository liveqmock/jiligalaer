package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Egressrule;

/**
 * 
 * @author lidongbo
 * 
 */
class EgressruleRepository extends AbstractServiceSupport<Egressrule> {
	
	public EgressruleRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return null;
	}

	@Override
	protected String getTagName() {
		return "egressrule";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "authorizeSecurityGroupEgress";
	}
	
	public Egressrule create(Egressrule bean) {
		Egressrule result = super.create(bean);
		result.setSecuritygroupid(bean.getSecuritygroupid());
		return result;
	}

	public void delete(String egressruleId) {
		super.delete("id", egressruleId, "revokeSecurityGroupEgress");
	}
}
