package sy.common.util.cloudstack.entity;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sy.common.util.cloudstack.Param;

/**
 * 
 * @author lidongbo
 * 
 */
public abstract class StickinessMethod {

	protected String _name;

	private boolean exists(String key){
		boolean result = false;
		String[] keys = getParamKeys();
		for (String string : keys) {
			if(key.equals(string)){
				return true;
			}
		}
		return result;
	}
	
	private void checkAndSet(int i ,String key,String value,List<Param> result){
		if(value.contains("=")){
        	throw new IllegalArgumentException(("填写内容中不允许出现'='"));
        }else if(value.contains(",")){
        	throw new IllegalArgumentException(("填写内容中不允许出现','"));
        }
        result.add(new Param("param["+i+"].name", key));
        result.add(new Param("param["+i+"].value", value));
	}
	
	public List<Param> toParams(Map<String,String> params){
		
		List<Param> result = new ArrayList<Param>();
		
		result.add(new Param("methodname", _name));
		
		int i = 0;
        for(String key :params.keySet()){
            String value = params.get(key);
            if(!exists(key)){
            	continue;
            }
            checkAndSet(i, key, value, result);
            i++;
        }
		
        return result;
	};
	
	@Target({ FIELD })
	@Retention(RUNTIME)
	public @interface Policy {
		String name();
		Class<? extends StickinessMethod>[] source();
	}
	
	@SuppressWarnings("unchecked")
	public List<Param> toParams(Object obj){
		
		if(obj instanceof Map){
			return toParams((Map<String,String>)obj);
		}
		
		int i = 0;
		List<Param> result = new ArrayList<Param>();
		result.add(new Param("methodname", _name));
		
		Class<? extends Object> clzz = obj.getClass();
		for (Field field : clzz.getDeclaredFields()) {
			
			if(!field.isAnnotationPresent(Policy.class)){
				continue;
			}
			
			Policy policy = field.getAnnotation(Policy.class);
			Class<? extends StickinessMethod>[] sources = policy.source();
			
			for(Class<? extends StickinessMethod> source :sources){
				if(!this.getClass().isAssignableFrom(source)){
					continue;
				}
				
				field.setAccessible(true);
				try {
					String key = policy.name();
					Object value = field.get(obj);
					if(value == null){
						continue;
					}
					checkAndSet(i, key, value.toString(), result);
					i++;
				} catch (Exception e) {
					//ignore
				}
			}
		}
		return result;
	}
	
	public abstract String[] getParamKeys();
	
	protected StickinessMethod(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

}
