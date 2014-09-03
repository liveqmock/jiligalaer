package sy.common.util;

import java.util.HashSet;

/**
 * 独立IP检查器
 */
public class SingleIpChecker {
	
	public static String lastDate = DateUtil.getTodayDate();

	private static HashSet<String> showIPs = new HashSet<String>();
	private static HashSet<String> clickIPs = new HashSet<String>();
//	private static Map<String, Object> showIPs = new HashMap<String, Object>();
//	private static Map<String, Object> clickIPs = new HashMap<String, Object>();

	private SingleIpChecker() {}

	/**
	 * 判断是否本日独立IP
	 * 
	 * @return 1:是，0：否
	 */
	public static String isFirstShow(String ipAddr_adPlaceId) {

		reloadIpMap();
		
		if (showIPs.contains(ipAddr_adPlaceId)) {
			return "0";
		} else {
			showIPs.add(ipAddr_adPlaceId);
			return "1";
		}
	}
	
	/**
	 * 判断是否本日独立IP
	 * 
	 * @return 1:是，0：否
	 */
	public static String isFirstClick(String ipAddr_adPlaceId) {

		reloadIpMap();
		
		if (clickIPs.contains(ipAddr_adPlaceId)) {
			return "0";
		} else {
			clickIPs.add(ipAddr_adPlaceId);
			return "1";
		}
	}

	private static void reloadIpMap() {
		
		String thisDate = DateUtil.getTodayDateTime().substring(0, 10);
		
		if (! thisDate.equals(lastDate)) {
			lastDate = thisDate;
			
			showIPs.clear();
			clickIPs.clear();
		}
	}
}
