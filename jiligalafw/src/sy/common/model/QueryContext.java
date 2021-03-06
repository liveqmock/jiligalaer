package sy.common.model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import sy.common.util.StringUtils;

/**
 * 
 * @author lidongbo
 *
 */
public class QueryContext extends PageContext{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2059752335287883637L;
	
	public final static Pattern PATTERN_DATE = Pattern.compile("[0-9]{4}\\-[0-9]{1,2}\\-[0-9]{1,2}");
	
	public static final String PREFIX = "$";
	public static final String LIKE = "lk";
	public static final String EQUALS = "eq";
	public static final String NOT_EQUALS = "ne";
	public static final String LESS_THAN = "lt";
	public static final String GREAT_THAN = "gt";
	public static final String LESS_EQUALS = "le";
	public static final String GREAT_EQUALS = "ge";
	public static final String LIKE_LEFT = "lkl";
	public static final String LIKE_RIGHT = "lkr";
	public static final String IN = "in";
	public static final String NOT_IN = "nin";
	public static final String IS_NULL = "nl";
	public static final String IS_NOT_NULL = "nn";
	
	public static final String withPrefix(String suffix){
		return new StringBuilder(PREFIX).append(suffix).toString();
	}
	
	public static final Map<String, String> EXP = new HashMap<String, String>();
	static {
		EXP.put(withPrefix(EQUALS), "='?'");
		EXP.put(withPrefix(NOT_EQUALS), "<>'?'");
		EXP.put(withPrefix(LESS_THAN), "<'?'");
		EXP.put(withPrefix(GREAT_THAN), ">'?'");
		EXP.put(withPrefix(LESS_EQUALS), "<='?'");
		EXP.put(withPrefix(GREAT_EQUALS), ">='?'");
		EXP.put(withPrefix(LIKE), " like '%?%'");
		EXP.put(withPrefix(LIKE_LEFT), " like '?%'");
		EXP.put(withPrefix(LIKE_RIGHT), " like '%?'");
		EXP.put(withPrefix(IN), " in (?)");
		EXP.put(withPrefix(NOT_IN), " not in (?)");
		EXP.put(withPrefix(IS_NULL), " is null");
		EXP.put(withPrefix(IS_NOT_NULL), " is not null");
	}
	
	public static String FIRST = "first";
	
	private String sort = null;
	
	private String order = "asc";
	
	private String nameSpace;
	
	protected Map<String,String> params = new HashMap<String,String>();
	
	private boolean useSession = true;
	
	public QueryContext() {
		initParams();
	}
	
	public QueryContext(HttpServletRequest request, ModelMap modelMap,
			String nameSpace) {
		this(request, modelMap, nameSpace, true);
	}
	
	public QueryContext(HttpServletRequest request, ModelMap modelMap,
			String nameSpace,boolean useSession) {
		this.nameSpace = nameSpace;
		initParams(request,modelMap);
		initParams();
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public void put(String key,String value){
		params.put(key, value);
	}
	
	public void putAll(Map<String,String> m){
		params.putAll(m);
	}
	
	public String get(String key){
		return params.get(key);
	}
	
	public String remove(String key){
		return params.remove(key);
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	
	protected void initParams(HttpServletRequest request, ModelMap modelMap) {
		if(useSession){
			if ("1".equals(request.getParameter(FIRST))) {
				request.getSession().removeAttribute(nameSpace);
			}

			if (request.getSession().getAttribute(nameSpace) != null) {
				putAll(((QueryContext) request.getSession().getAttribute(nameSpace)).params);
				remove(FIRST);
			}
		}

		@SuppressWarnings("rawtypes")
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement().toString();
			this.put(name, request.getParameter(name));
		}
		
		if(useSession){
			request.getSession().setAttribute(nameSpace, this);
		}
		
		modelMap.put(nameSpace, this);
	}

	protected void initParams() {
		// TODO Auto-generated method stub
		
	}
	
	
	public String buildHqlConditions(String alias) {
		alias = StringUtils.isNotBlank(alias) ? alias + "." : "";
		StringBuilder conditions = new StringBuilder();
		Set<String> keys = params.keySet();
		for (String key : keys) {
			String[] val = StringUtils.split(get(key), ";");
			if (val == null) {
				continue;
			}
			String[] exp = StringUtils.split(key, ";");
			StringBuilder cond = new StringBuilder(50);
			for (int i = 0; i < exp.length && i < val.length; i++) {
				if (exp[i].indexOf(PREFIX) == 0 && StringUtils.isNotEmpty(val[i])) {
					String prefix = exp[i].substring(0, exp[i].indexOf("_"));
					if (EXP.containsKey(prefix)) {
						String name = alias + exp[i].substring(prefix.length() + 1).replaceAll("_", ".");
						String queryExp = EXP.get(prefix);
						if (PATTERN_DATE.matcher(val[i]).matches()) {
							if (prefix.equals(withPrefix(LESS_THAN)) || prefix.equals(withPrefix(LESS_EQUALS))) {
								val[i] = val[i] + " 23:59:59";
							}
						}
						if (withPrefix(IN).equals(prefix)) {
							String v = "'" + StringUtils.replace(val[i], ",", "','") + "'";
							if (cond.length() == 0) {
								cond.append(" and (").append(name).append(StringUtils.replace(queryExp, "?", v));
							}
							else {
								cond.append(" or ").append(name).append(StringUtils.replace(queryExp, "?", v));
							}
						}else if(withPrefix(NOT_IN).equals(prefix)){
							String v = "'" + StringUtils.replace(val[i], ",", "','") + "'";
							if (cond.length() == 0) {
								cond.append(" and (").append(name).append(StringUtils.replace(queryExp, "?", v));
							}
							else {
								cond.append(" or ").append(name).append(StringUtils.replace(queryExp, "?", v));
							}
						}
						else {
							String[] values = StringUtils.split(val[i], ",");
							for (String v : values) {
								if (cond.length() == 0) {
									cond.append(" and (").append(name).append(StringUtils.replace(queryExp, "?", v));
								}
								else {
									cond.append(" or ").append(name).append(StringUtils.replace(queryExp, "?", v));
								}
							}
						}
					}
				}
			}
			if (cond.length() > 0) {
				conditions.append(cond.append(")"));
			}
		}
		return conditions.toString();
	}
	
	public String buildSort(String alias){
		
		if (StringUtils.isNotBlank(sort)) {
			StringBuilder orderBy = new StringBuilder().append(" order by ");
			
			String[] s = sort.replaceAll("_", ".").split("\\,");
			int len = s.length;
			if (len > 0) {
				orderBy.append(alias).append(".").append(StringUtils.trim(s[0]));
			}
			for (int i = 1; i < len; i++) {
				orderBy.append(",").append(alias).append(".").append(StringUtils.trim(s[i]));
			}
			return orderBy.toString();
	   	}
		
		return "";
	}
	
	public Map<String,String> getParams(){
		return params;
	}
	
	private static String buildPrefix(String prefix,String name){
		return new StringBuilder(withPrefix(prefix)).append("_").append(name).toString();
	}
	
	public void like(String name,String value){
		params.put(buildPrefix(LIKE, name), value);
	}
	
	public void equals(String name,String value){
		params.put(buildPrefix(EQUALS, name), value);
	}
	
	public void notEquals(String name,String value){
		params.put(buildPrefix(NOT_EQUALS, name), value);
	}
	
	public void lessThan(String name,String value){
		params.put(buildPrefix(LESS_THAN, name), value);
	}
	
	public void greatThan(String name,String value){
		params.put(buildPrefix(GREAT_THAN, name), value);
	}
	
	public void lessEquals(String name,String value){
		params.put(buildPrefix(LESS_EQUALS, name), value);
	}

	public void greatEquals(String name,String value){
		params.put(buildPrefix(GREAT_EQUALS, name), value);
	}
	
	public void likeLeft(String name,String value){
		params.put(buildPrefix(LIKE_LEFT, name), value);
	}
	
	public void likeRight(String name,String value){
		params.put(buildPrefix(LIKE_RIGHT, name), value);
	}
	
	public void in(String name,String value){
		params.put(buildPrefix(IN, name), value);
	}
	
	public void isNull(String name){
		params.put(buildPrefix(IS_NULL, name), "");
	}

	public void isNotNull(String name){
		params.put(buildPrefix(IS_NOT_NULL, name), "");
	}
	
	public void clearParmeters(){
		if(params!=null){
			params.clear();
		}
	}
	
	public void clearSort(){
		sort = null;
	}
	
}
