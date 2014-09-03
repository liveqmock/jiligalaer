package sy.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lidongbo
 *
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

	/**
	 * 去除首尾空格后判断是否为空
	 */
	public static boolean isTrimEmpty(String str) {
		if (str != null)
			str = str.trim();
		return isEmpty(str);
	}
	
	/**
	 * 检查一个字符串是否符合Email地址格式
	 * @param emailAddress
	 * @return 符合Email地址格式，返回 True.
	 */
	public static boolean checkEmailAddress(String emailAddress){     
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");     
		Matcher m = p.matcher(emailAddress);     
		return m.find(); 
	}
	
}
