package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.VpnUser;

/**
 * 
 * @author lidongbo
 * 
 */
public class VpnUserRepository extends AbstractServiceSupport<VpnUser> {

	public VpnUserRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listVpnUsers";
	}

	@Override
	protected String getTagName() {
		return "vpnuser";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "addVpnUser";
	}

	public void delete(String username, String accountName, String domainId) {
		super.delete("username", username, "removeVpnUser", new Param(
				"account", accountName), new Param("domainid", domainId));
	}
}
