package sy.common.util2;

import java.util.HashMap;
import java.util.Map;

public class CmnUtil {

	/**
	 * 判断Map1,Map2的数值是否相等
	 * 
	 * @param mp1,mp2
	 * @return boolean 真或假
	 */
	public static boolean equalsStringMap(Map<String, Object> map1, Map<String, Object> map2) {

		if (map1 == null) {
			map1 = new HashMap<String, Object>();
		}
		if (map2 == null) {
			map2 = new HashMap<String, Object>();
		}
		boolean result = true;

		for (String key : map1.keySet()) {
			if (!((String) (map2.get(key))).equals((String) (map1.get(key)))) {
				result = false;
				break;
			}
		}
		return result;
	}

}