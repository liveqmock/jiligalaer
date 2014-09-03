package sy.common.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
    
    private static Gson gson = null;
    
    static {
    	gson = new Gson();
    }

    public static Gson getGson() {
    	return gson;
    }

    public static String toJson(Object o) {
    	return gson.toJson(o);
    }
    
//    public static Object<T> toJson(String json, Class<T> classOfT) {
//    	return gson.fromJson(json, classOfT);
//    }
    @SuppressWarnings("unused")
	private static void demo(String str){
    	Gson gson = new Gson();
    	String json = gson.toJson(str, new TypeToken<List<List<Map<String, String>>>>(){}.getType());// to Json
    	List<List<Map<String, String>>> obj2 = gson.fromJson(str, new TypeToken<List<List<Map<String, String>>>>(){}.getType());
    }
    
}

