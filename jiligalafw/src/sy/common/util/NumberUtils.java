package sy.common.util;

import java.text.DecimalFormat;


/**
 *
 * @author lidongbo
 *
 */
public class NumberUtils extends org.apache.commons.lang.math.NumberUtils {

	
	public static String format(Number v, String pattern) {
		if (v == null) {
			v = 0.0;
		}
		try {
			return new DecimalFormat(pattern).format(v);
		}
		catch(Exception e) {}
		
		return v.toString();
	}
	
}
