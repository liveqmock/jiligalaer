package sy.common.util;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.stereotype.Component;



/**
 * 将返回的JSON格式中，日期类型转化为字符串类型，用于前台显示
 * 
 */
@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context)throws IOException, JsonProcessingException {
		parser.getText();
		System.out.println(11111111);
		return new Date();
	}
}
