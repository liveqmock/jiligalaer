package sy.common.util.cloudstack.entity;

/**
 * 
 * @author lidongbo
 * 
 */
public class StickinessMethodType {

	public static final StickinessMethod NONE = new StickinessMethodNone();
	public static final StickinessMethod LBCookieBased = new StickinessMethodLbCookie();
	public static final StickinessMethod AppCookieBased = new StickinessMethodAppCookie();
	public static final StickinessMethod SourceBased = new StickinessMethodSourceBased();

	public static StickinessMethod getInstance(String methodname) {
		if ("LbCookie".equals(methodname)) {
			return LBCookieBased;
		} else if ("AppCookie".equals(methodname)) {
			return AppCookieBased;
		} else if ("SourceBased".equals(methodname)) {
			return SourceBased;
		} else if ("None".equals(methodname)) {
			return NONE;
		}
		return NONE;
	}
}
