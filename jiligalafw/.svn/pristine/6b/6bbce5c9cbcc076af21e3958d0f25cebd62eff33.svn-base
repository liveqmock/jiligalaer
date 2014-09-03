package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.RemoteaccessVpn;

/**
 * 
 * @author lidongbo
 * 
 */
public class RemoteaccessVpnRepository extends
		AbstractServiceSupport<RemoteaccessVpn> {

	public RemoteaccessVpnRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listRemoteAccessVpns";
	}

	@Override
	protected String getTagName() {
		return "remoteaccessvpn";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "createRemoteAccessVpn";
	}

	public void delete(String publicipid) {
		super.delete("publicipid", publicipid, "deleteRemoteAccessVpn");
	}
}
