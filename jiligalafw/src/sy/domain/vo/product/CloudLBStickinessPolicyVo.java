package sy.domain.vo.product;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import sy.common.util.cloudstack.entity.LBStickinessPolicy;
import sy.common.util.cloudstack.entity.StickinessMethod;
import sy.common.util.cloudstack.entity.StickinessMethod.Policy;
import sy.common.util.cloudstack.entity.StickinessMethodAppCookie;
import sy.common.util.cloudstack.entity.StickinessMethodLbCookie;
import sy.common.util.cloudstack.entity.StickinessMethodSourceBased;
import sy.common.util.cloudstack.entity.StickinessMethodType;

/**
 * 
 * @author lidongbo
 * 
 */
public class CloudLBStickinessPolicyVo extends
		CloudDataSyncBuilder<LBStickinessPolicy> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4826563807534247634L;
	private String lbruleid;
	private String name;
	private String methodname;
	private String params;

	// SourceBased
	@Policy(name = "expire", source = { StickinessMethodSourceBased.class })
	private String expire;
	@Policy(name = "tablesize", source = { StickinessMethodSourceBased.class })
	private String tablesize;

	// LbCookie
	@Policy(name = "indirect", source = { StickinessMethodLbCookie.class })
	private String indirect;
	@Policy(name = "cookie-name", source = { 
			StickinessMethodLbCookie.class,
			StickinessMethodAppCookie.class })
	private String cookieName;
	@Policy(name = "domain", source = { StickinessMethodLbCookie.class })
	private String domain;
	@Policy(name = "nocache", source = { StickinessMethodLbCookie.class })
	private String nocache;
	@Policy(name = "postonly", source = { StickinessMethodLbCookie.class })
	private String postonly;
	@Policy(name = "mode", source = { 
			StickinessMethodLbCookie.class,
			StickinessMethodAppCookie.class })
	private String mode;

	// AppCookie
	@Policy(name = "request-learn", source = { StickinessMethodAppCookie.class })
	private String requestLearn;
	@Policy(name = "holdtime", source = { StickinessMethodAppCookie.class })
	private String holdtime;
	@Policy(name = "prefix", source = { StickinessMethodAppCookie.class })
	private String prefix;
	@Policy(name = "length", source = { StickinessMethodAppCookie.class })
	private String length;

	public void init(){
		if (methodname == null) {
			return;
		}
		if (params == null || params.trim().length() < 3) {
			return;
		}
		
		String params = this.params.substring(1, this.params.length()-1);
		String[] parampair = params.split(",");
		
		Map<String,String> paramMap = new HashMap<String,String>();
		
		if(parampair == null){
			return;
		}
		
		for (String param : parampair) {
			String[] ky = param.split("=");
			if (ky == null || ky.length != 2
					|| ky[0] == null 
					|| ky[1] == null) {
				continue;
			}
			
			paramMap.put(ky[0].trim(), ky[1].trim());
		}
		
		StickinessMethod method = StickinessMethodType.getInstance(getMethodname());
		
		if(method == null){
			return;
		}
		
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			if(!field.isAnnotationPresent(Policy.class)){
				continue;
			}
			Policy policy = field.getAnnotation(Policy.class);
			Class<? extends StickinessMethod>[] sources = policy.source();
			boolean exists = false;
			for (Class<? extends StickinessMethod> source : sources) {
				if(source.isAssignableFrom(method.getClass())){
					exists = true;
				}
			}
			
			if(!exists){
				continue;
			}
			
			String key = policy.name();
			
			String value = paramMap.get(key);
			if(value == null){
				continue;
			}
			
			field.setAccessible(true);
			try {
				field.set(this, value);
			} catch (Exception e) {
				//ignore
			}
		}
	}
	
	public String getLbruleid() {
		return lbruleid;
	}

	public void setLbruleid(String lbruleid) {
		this.lbruleid = lbruleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethodname() {
		return methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	/////////
	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getTablesize() {
		return tablesize;
	}

	public void setTablesize(String tablesize) {
		this.tablesize = tablesize;
	}

	public String getIndirect() {
		return indirect;
	}

	public void setIndirect(String indirect) {
		this.indirect = indirect;
	}

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNocache() {
		return nocache;
	}

	public void setNocache(String nocache) {
		this.nocache = nocache;
	}

	public String getPostonly() {
		return postonly;
	}

	public void setPostonly(String postonly) {
		this.postonly = postonly;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRequestLearn() {
		return requestLearn;
	}

	public void setRequestLearn(String requestLearn) {
		this.requestLearn = requestLearn;
	}

	public String getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(String holdtime) {
		this.holdtime = holdtime;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	public static void main(String[] args) {
		CloudLBStickinessPolicyVo vo = new CloudLBStickinessPolicyVo();
		vo.setMethodname("LbCookie");
		vo.setParams("{indirect=true, cookie-name=cookie_name, domain=domain_, nocache=true, postonly=true, mode=a}");
		vo.init();
		System.out.println(vo);
	}
}
