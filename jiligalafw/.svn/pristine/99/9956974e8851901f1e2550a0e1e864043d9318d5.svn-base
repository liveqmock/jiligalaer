package sy.common.util2;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

import sy.common.util.StringUtil;

public class HtmlUtil {

    private HtmlUtil() {
    }
    
    /**
	 * NULL字符串转换，参数对象为null时，返回空字符串
	 * 将" " 替换为 "&nbsp;" 用于页面显示多个空格
	 * @param o 转换原对象
	 * @return 字符串
	 */
	public static String replaceSpace2nbsp(Object o) {
		if (o == null) {
			return "";
		}
		return o.toString().trim().replaceAll(" ", "&nbsp;");
	}
	
    /**
	 * 替换回车为br
	 * 
	 * @param text 原文本
	 * @return 替换后文本
	 */
	public static String replaceLineBreak2Br(String text) {
		return replace(text, "\n", "<br>\n");
	}

	/**
	 * 替换\t为4个html空格
	 * 
	 * @param text 原文本
	 * @return 替换后文本
	 */
	public static String replaceTab24Space(String text) {
		return replace(text, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	
	/**
	 * 对html标签或特殊字符串编码
	 * 
	 * @param html html代码
	 * @return String 替换后代码
	 */
	public static String replaceQuotes(String html) {

		html = replace(html, "\"", "&quot;");

		return html;
	}


	/**
	 * 对html标签或特殊字符串编码
	 * 
	 * @param html html代码
	 * @return String 替换后代码
	 */
	public static String replaceAllQuotes(String html) {

		html = replace(html, "\"", "&quot;");
		html = replace(html, "\'", "&apos;");

		return html;
	}

	/**
	 * 对html中js中引用的字符（比如alert中）转换 单引号
	 * 
	 * @param html html代码
	 * @return String 替换后代码
	 */
	public static String replaceJsApos(String html) {

		html = replace(html, "'", "\\'");

		return html;
	}
	/**
	 * 对html中js中引用的字符（比如alert中）转换 单引号
	 * 
	 * @param html html代码
	 * @return String 替换后代码
	 */
	public static String replaceJsQuote(String html) {

		html = replace(html, "\"", "\\\"");

		return html;
	}

	/**
	 * 对html标签或特殊字符串编码
	 * 
	 * @param html html代码
	 * @return String 替换后代码
	 */
	public static String HtmlEncode(String html) {

		if (StringUtil.isNull(html)) {
			return html;
		}

		html = replace(html, "&", "&amp;");
		html = replace(html, "<", "&lt;");
		html = replace(html, ">", "&gt;");
		html = replace(html, "\n", "<br>");
		html = replace(html, "\"", "&quot;");

		return html;
	}
	

	/**
	 * 把doc格式的字符串转换为html格式,但是对table保持原样
	 * @param sourceStr
	 * @return targetStr
	 */
	public static  String getTargetStr(String sourceStr){
		StringBuffer buf = new StringBuffer();
		int tabSIndex = sourceStr.indexOf("<table>");
      	int tabEIndex = sourceStr.indexOf("</table>");
      	if(tabSIndex == -1 || tabEIndex == -1){
      		return sourceStr;
      	}
      	String headStr = sourceStr.substring(0,tabSIndex);
      	headStr = headStr.replaceAll("\r\n","<br>");
      	String middleStr = sourceStr.substring(tabSIndex+1,tabEIndex);
      	String endStr = sourceStr.substring(tabEIndex+1,sourceStr.length()-1);
      	buf.append(headStr);
      	buf.append(middleStr);
      	if(endStr.indexOf("<table>") != -1){
      		buf.append(getTargetStr(endStr));
      	}
		return buf.toString();
	}
	
	/**
	 * 按单位给字符串加换行
	 * @param sourceStr
	 * @param cutUnit 字符串的单位
	 * @return
	 */
	public static String addBr(String sourceStr,int cutUnit){
		if(sourceStr == null || cutUnit <= 0){
			return "";
		}else{
			int len = sourceStr.length();
			if(len <= cutUnit){
				return sourceStr;
			}else{
				String targetStr = "";
				int strCount = len/cutUnit;
				int raminder = len%cutUnit;
				for(int i=0;i<strCount;i++){
					String frontSubStr = sourceStr.substring(cutUnit*i, cutUnit*(i+1));
					if((i == (strCount -1)) && (raminder == 0)){
						targetStr += frontSubStr;
					}else{
						targetStr += frontSubStr + "<br>";
					}
				}
				if(raminder != 0){
					targetStr += sourceStr.substring(cutUnit*strCount, len);
				}
				
				return targetStr;
			}
		}
	}
	
	/**
	 * 对字符串按照长度换行(当文字中有CSS样式时，适用)
	 * 
	 * @param s 需要换行的字符传
	 * @param len 多长时，需要换行
	 * @return HTML字符串
	 */
	public static String autoChangeRowWithCSS(String s, int len) {
		String[] oldS = s.split(",");
		String[] newS = s.split(",");
		String strNewS = "";
		String strOldS = "";
		for(int i = 0 ; i < newS.length ; i++){
			if(newS[i].charAt(0) == '<'){
				newS[i] = newS[i].substring(newS[i].indexOf(">")+1,newS[i].indexOf("<",2));
			}
			strNewS += "," + newS[i];
		}
		strNewS = strNewS.substring(1);
		strNewS = autoChangeRow(strNewS,len);
		newS = strNewS.split(",");
		for(int i = 0 ; i < oldS.length ; i++){
			if(oldS[i].charAt(0) == '<'){
				oldS[i] = oldS[i].substring(0,oldS[i].indexOf(">")+1) + newS[i] + oldS[i].substring(oldS[i].indexOf("<",2),oldS[i].length());
			}else{
				oldS[i] = newS[i];
			}
			strOldS += "," + oldS[i];
		}
		strOldS = strOldS.substring(1);
		return strOldS;
	}
	

	/**
	 * 对字符串按照长度换行
	 * 
	 * @param s 需要换行的字符传
	 * @param len 多长时，需要换行
	 * @return HTML字符串
	 */
	public static String autoChangeRow(String s, int len) {
		String sReurlt = "";
		for (int i = 0; i < s.length(); i = i + len) {
			if (i == 0) {
				sReurlt = s.substring(0, s.length() > len ? len : s.length());
			} else {
				sReurlt = sReurlt + "</br>";
				sReurlt = sReurlt + s.substring(i, s.length() > i + len ? i + len : s.length());
			}
		}
		return sReurlt;
	}
	
	/**
	 * 得到字符串的实际长度
	 * 
	 * @param s 字符串
	 * @return 实际长度
	 */
	public static int getStringWidth(String s) {
		System.setProperty("java.awt.headless", "true");

		Font font = new Font("Dialog", Font.PLAIN, 12);
		FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
		int iWidth = SwingUtilities.computeStringWidth(fontMetrics, s);
		return iWidth;
	}

	
	/**
	 * 按字体得到字符串的实际长度
	 * 
	 * @param s 字符串
	 * @param font 字体
	 * @return 实际长度
	 */
	public static int getStringWidth(String s, Font font) {
		System.setProperty("java.awt.headless", "true");

		FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
		int iWidth = SwingUtilities.computeStringWidth(fontMetrics, s);
		return iWidth;
	}

	/**
	 * 按字体得到字符串的实际长度
	 * 
	 * @param s 字符串
	 * @param fontName 字体名称
	 * @param size 字体大小
	 * @return
	 */
	public static int getStringWidth(String s,String fontName,int size) {
		System.setProperty("java.awt.headless", "true");
		
		Font font = new Font(fontName, Font.PLAIN, size);
		
		FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
		int iWidth = SwingUtilities.computeStringWidth(fontMetrics, s);
		return iWidth;
	}

	/**
	 * 按字体得到截取字符串并补足
	 * @param bottomText 字符串
	 * @param fixedWidth 要取得的字符串的长度
	 * @param addStr 补足的字字符串
	 * @param fontName 字体名称
	 * @param size　字体大小　
	 * @return
	 */
	public static String getFixedWidthString(String bottomText, int fixedWidth, String addStr, String fontName, int size) {

		if("".equals(StringUtil.nvl(bottomText))){
			return "";
		}
		
		int bottomTextWidth = getStringWidth(bottomText,fontName,size);//字符串宽度 

		if (bottomTextWidth > fixedWidth) { //check如果是
			while (bottomTextWidth > fixedWidth-2) {//每次length()减1
				bottomText = bottomText.substring(0, bottomText.length() - 1);
				bottomTextWidth = getStringWidth(bottomText);
			}
			bottomText += addStr;//将舍弃的部分变成"..."代替
		}
		return bottomText;
	}

	/**
	 * 字符串替换。如果不需要用正则表达式请用此方法； 否则用String.replaceAll(String regex, String replacement)
	 * 
	 * @param text 需要被处理的字符串
	 * @param from 需要被替换掉的字符串
	 * @param to 被替换成的字符串
	 * @return 被替换后的字符串
	 * @see String#replaceAll(String, String)
	 */
	public static String replace(String text, String from, String to) {
		if (text == null || from == null || to == null) {
			return null;
		}
		StringBuffer newText = new StringBuffer(text.length() * 2);
		int pos1 = 0;
		int pos2 = text.indexOf(from);
		while (pos2 >= 0) {
			newText.append(text.substring(pos1, pos2) + to);
			pos1 = pos2 + from.length();
			pos2 = text.indexOf(from, pos1);
		}
		newText.append(text.substring(pos1, text.length()));
		return newText.toString();
	}
	

	/**
	 * 检查是否为数字。可以包含小数点，但是小数点个数不能多于一个； 可以包含负号，但是不能只有负号而没有其他数字； 不允许包含逗号
	 * 
	 * @param s 被检查的字符串
	 * @return true 表示是数字, false 表示不是数字
	 */
	public static boolean isNumber(String s) {
		boolean pointfirsttime = true;

		int i = 0;
		if (s == null || s.length() < 1) {
			return false;
		}

		boolean negative = false;

		if (s.charAt(0) == '-') {
			i++;
			negative = true;
		}

		while (i < s.length()) {
			if (!Character.isDigit(s.charAt(i))) {
				if ('.' == s.charAt(i) && pointfirsttime) {
					pointfirsttime = false;
				} else {
					return false;
				}
			}
			i++;
		}

		if (negative && (i == 1)) {
			return false;
		}

		return true;
	}

	/**
	 * 检查是否为整数。可以为负整数，但是不能只有负号而没有其他数字
	 * 
	 * @param s 被检查的字符串
	 * @return true 表示是整数, false 表示不是整数
	 */
	public static boolean isInteger(String s) {
		int i = 0;
		if (s == null || s.trim().length() < 1) {
			return false;
		}

		boolean negative = false;

		if (s.charAt(0) == '-') {
			i++;
			negative = true;
		}

		while (i < s.length()) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
			i++;
		}
		if (negative && (i == 1)) {
			return false;
		}

		return true;
	}
	
	/**
	 * 检查是否为合法的Email
	 * 
	 * @param mail 字符串
	 * @return true 合法，false 非法
	 */
	public static boolean isEmail(String mail) {
		if (mail == null) {
			return false;
		}

		String mailstr = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pn = Pattern.compile(mailstr);

		boolean b = pn.matcher(mail).matches();

		System.out.println(b);

		return b;

	}
	
	/**
	 * 检查是否为合法的phone
	 * 
	 * @param phone 字符串
	 * @return true 合法，false 非法
	 */
	public static boolean isPhoneNumber(String phone) {
		if ("".equals(StringUtil.nvl(phone))) {
			return false;
		}
		String phonestr = "^(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$";
		Pattern pattern = Pattern.compile(phonestr);

		boolean b = pattern.matcher(phone).matches();

		return b;
	}
}
