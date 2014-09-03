package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.User;

/**
 *
 * @author lidongbo
 *
 */
public class UserRepository extends AbstractServiceSupport<User> {

	public UserRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listUsers";
	}

	@Override
	protected String getTagName() {
		return "user";
	}

}
