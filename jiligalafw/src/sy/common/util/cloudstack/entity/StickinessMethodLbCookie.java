package sy.common.util.cloudstack.entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lidongbo
 *
 */
public class StickinessMethodLbCookie extends StickinessMethod{

	private static final String[] PARAM_KEYS = new String[]{
			"cookie-name",
			"mode",
			"domain",
			"indirect",
			"nocache",
			"postonly"
	};
	
	StickinessMethodLbCookie() {
		super("LbCookie");
	}
	
	public String[] getParamKeys(){
		return PARAM_KEYS;
	}
	
	public static void main(String[] args) {
		
		StickinessMethodLbCookie sm = new StickinessMethodLbCookie();
		//{indirect=true, cookie-name=cookie_name, domain=domain_, nocache=true, postonly=true, mode=a}
		Map<String,String> params = new HashMap<String,String>();
		params.put("indirect", "true");
		params.put("cookie-name", "cookie_name");
		params.put("domain", "domain_");
		params.put("nocache", "true");
		params.put("postonly", "true");
		params.put("mode", "a");
		System.out.println(params);
//		System.out.println(sm.getParamString(params));
		System.out.println(sm.toParams(params));
	}
}
