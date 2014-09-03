package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.PortForwardingRule;

/**
 * 端口转发通信仓储
 * @author lidongbo
 * 
 */
public class PortForwardingRuleRepository extends
		AbstractServiceSupport<PortForwardingRule> {

	public PortForwardingRuleRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listPortForwardingRules";
	}

	@Override
	protected String getTagName() {
		return "portforwardingrule";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "createPortForwardingRule";
	}
	
	public void delete(String id) {
		super.delete("id", id, "deletePortForwardingRule");
	}
}
