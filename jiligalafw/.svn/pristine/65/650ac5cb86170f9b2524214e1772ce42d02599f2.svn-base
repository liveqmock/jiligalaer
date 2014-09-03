package sy.common.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

    private static ObjectMapper objectMapper = null;
    
    static {
    	objectMapper = new ObjectMapper(); // can reuse, share globally
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }
    
    public static ObjectMapper getObjectMapper() {
    	return objectMapper;
    }

    public static String toJson(Object o) throws JsonGenerationException, JsonMappingException, IOException {
    	return objectMapper.writeValueAsString(o);
    }
    
//    public static <T> T toObj(String jsonStr, Class<T> clazz) {
//    	return objectMapper.convertValue(jsonStr, clazz);
//    }
    
//    public static Object<T> toJson(String json, Class<T> classOfT) {
//    	return gson.fromJson(json, classOfT);
//    }
    
    
}

