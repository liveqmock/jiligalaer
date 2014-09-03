package sy.common.util.validator.pattern;
/**
 * 
 * 常用的Java正则表达式
 * @author lidongbo
 * 2010-12-3
 */
public class CommonJavaPattern {

	/**
	 * 需要区分大小写标志
	 */
	public final static String EMAIL = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}\\b";
	
	/**
	 * 小数
	 */
	public final static String DEMICAL = "^(-?\\d+)(\\.\\d+)?$"; 
	
	/**正整数*/
	public final static String POSITIVE_INTEGER="^\\+?\\d+$";
}

