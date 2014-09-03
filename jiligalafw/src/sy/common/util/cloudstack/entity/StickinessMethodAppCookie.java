package sy.common.util.cloudstack.entity;
/**
 *
 * @author lidongbo
 *
 */
public class StickinessMethodAppCookie extends StickinessMethod{

	private static final String[] PARAM_KEYS = new String[]{
		"request-learn",
		"holdtime",
		"cookie-name",
		"prefix",
		"length",
		"mode"
	};
	
	StickinessMethodAppCookie() {
		super("AppCookie");
	}

	@Override
	public String[] getParamKeys() {
		return PARAM_KEYS;
	}
	
}
