package sy.common.util;

import java.util.Vector;

public class StringUtil {

    private StringUtil() {
    }
    
	/**
	 * NULL字符串转换，参数对象为null时，返回空字符串
	 * 
	 * @param o 转换原对象
	 * @return 字符串
	 */
	public static String nvl(Object o) {
		if (o == null) {
			return "";
		}
		return o.toString().trim();
	}
	
	/**
	 * NULL字符串转换，参数对象为null时，返回默认值
	 * 
	 * @param obj 转换原对象
	 * @param defaultStr 默认值
	 * @return 字符串
	 */
	public static String nvl(Object obj, String defaultStr) {
		if (obj == null) {
			return defaultStr;
		}
		return obj.toString().trim();
	}
	
	/**
	 * NULL字符串转换，参数对象为null或全部空格时，返回默认值
	 * 
	 * @param obj 转换原对象
	 * @param defaultStr 默认值
	 * @return 字符串
	 */
	public static String nvlspace(Object obj, String defaultStr) {
		if (obj == null || "".equals(obj.toString().trim())) {
			return defaultStr;
		}
		return obj.toString().trim();
	}
    
    /**
     * 检查输入的字符串是否为（Null/""/" ")
     * 
     * @param src String 被检查的字符串
     * @return tru/false
     */
    public static boolean isNull(String src) {
    	if ((src == null) || ("").equals(src.trim())) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 检查输入的字符串是否不为（Null/""/" ")
     * 
     * @param src String 被检查的字符串
     * @return tru/false
     */
    public static boolean isNotNull(String src) {
    	return !isNull(src);
    }
    
    /**
	 * 输入的字符串是否全为半角
	 * 
	 * @param src
	 * @return 是true;否false
	 */
    public static boolean isAllHalfWidthString(String src) {
        boolean result = true;

        for (int i = 0; (src != null) && (i < src.length()); i++) {
            char c = src.charAt(i);

            if (isHalfWidth(c)) {
                if ((c == '&') || (c == '<') || (c == '>') || (c == '"') ||
                        (c == '\'')) {
                    result = false;

                    break;
                } else {
                    continue;
                }
            } else {
                result = false;

                break;
            }
        }

        return result;
    }
    
    /**
     * 输入的字符是否为半角
     *
     * @param c 被检查的字符
     * @return 半角:true,全角:false
     */
    public static boolean isHalfWidth(char c) {
        boolean result = true;

        //Get the Unicode block containing the given character
        Character.UnicodeBlock cub = Character.UnicodeBlock.of(c);

        if (cub.equals(Character.UnicodeBlock.BASIC_LATIN)) {
            // Basic Latin
            result = true;
        } else if (cub.equals(
                    Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)) {
            // Halfwidth and Fullwidth Forms
            int type = Character.getType(c);

            if ((type == Character.MODIFIER_LETTER) ||
                    (type == Character.OTHER_LETTER)) {
                // MODIFIER_LETTER , OTHER_LETTER
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }
    
    /**
     * 检查传入的char是否是字母
     *
     * @param ch 被检查的char
     * @return 字母:true.其它:false
     */
    private static boolean _isAlpha(char ch) {
        return ((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z'));
    }

    /**
     * 检查传入的char是否是数字
     *
     * @param ch 被检查的char
     * @return 数字:true.其它:false
     */
    private static boolean _isNumber(char ch) {
        return ((ch >= '0') && (ch <= '9'));
    }
    
    /**
     * 检查是否为一个数字字符串
     * @param str
     * @return
     */
    public static boolean isNumberStr(String str) {
        if (isNull(str)) {
            return true;
        }

        char[] chArray = str.trim().toCharArray();

        for (int index = 0; index < chArray.length; index++) {
            if ( !_isNumber(chArray[index])) {
                return false;
            }
        }

        return true;
    }

    
    /**
     * 检查字符串是否是数字或字母或-
     *
     * @param str 被检查的字符串
    * @return 全为字符或数字或-：true,存在非字符或数字或-的字符:false
     */
    public static boolean isAlphaNumberMinus(String str) {
        if (!isNull(str)) {
            return false;
        }

        char[] chArray = str.toCharArray();

        for (int index = 0; index < chArray.length; index++) {
            if (!_isAlpha(chArray[index]) && !_isNumber(chArray[index]) && !('-'==chArray[index])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查字符串是否是数字或字母
     *
     * @param str 被检查的字符串
    * @return 全为字符或数字：true,存在非字符或数字的字符:false
     */
    public static boolean isAlphaNumber(String str) {
        if (!isNull(str)) {
            return false;
        }

        char[] chArray = str.toCharArray();

        for (int index = 0; index < chArray.length; index++) {
            if (!_isAlpha(chArray[index]) && !_isNumber(chArray[index])) {
                return false;
            }
        }

        return true;
    }
    
	/**
	 * 查找字符串
	 * 
	 * @param strSource 原始字符串
	 * @param strFrom 开始字符串
	 * @param strTo 结束字符串
	 * @return 字符串
	 */
	public static String find(String strSource, String strFrom, String strTo) {
		String strDest = "";
		int intFromIndex = strSource.indexOf(strFrom) + strFrom.length();
		int intToIndex = strSource.indexOf(strTo);
		if (intFromIndex < intToIndex) {
			strDest = strSource.substring(intFromIndex, intToIndex);
		}
		return strDest;
	}

	/**
	 * 字符串拆分
	 * 
	 * @param sInputStr 字符串
	 * @param cDelimiter 拆分字符
	 * @return 字符串数组
	 */
	public static String[] split(String sInputStr, char cDelimiter) {
		int iStrLen = sInputStr.length();
		int iTokCount = 0;

		if (0 == iStrLen)
			return null;

		for (int p = 0; p < iStrLen; p++)
			if (sInputStr.charAt(p) == cDelimiter)
				iTokCount++;

		String Tokens[] = new String[iTokCount + 1];

		int iToken = 0;
		int iLast = 0;
		for (int iNext = 0; iNext < iStrLen; iNext++) {
			if (sInputStr.charAt(iNext) == cDelimiter) {
				if (iLast == iNext)
					Tokens[iToken] = "";
				else
					Tokens[iToken] = sInputStr.substring(iLast, iNext);
				iLast = iNext + 1;
				iToken++;
			} // fi (sInputStr[iNext]==cDelimiter)
		} // next

		if (iLast >= iStrLen)
			Tokens[iToken] = "";
		else
			Tokens[iToken] = sInputStr.substring(iLast, iStrLen);

		return Tokens;
	}


	/**
	 * 将字符串（包括汉字）分割成固定长度的字符串数组
	 * 
	 * @param strParamTarget 字符串
	 * @param nParamLen 固定长度
	 * @return 字符串数组
	 */
	public static String[] splitLength(String strParamTarget, int nParamLen) {
		Vector<String> vctWork = new Vector<String>();
		int nCharLen;

		int nLen = 0;

		int i;
		StringBuffer sbWork = new StringBuffer("");
		char cWork;

		if (strParamTarget == null) {

		} else {

			for (i = 0; i < strParamTarget.length(); i++) {

				cWork = strParamTarget.charAt(i);

				if (String.valueOf(cWork).getBytes().length > 1) {
					nCharLen = 2;
				} else {
					nCharLen = 1;
				}

				if ((nLen + nCharLen) > nParamLen) {

					vctWork.addElement(sbWork.toString());

					sbWork = new StringBuffer("");
					nLen = 0;
				}

				nLen += nCharLen;

				sbWork.append(cWork);
			}
			vctWork.addElement(sbWork.toString());
		}

		return (String[]) vctWork.toArray(new String[0]);
	}

	/**
	 * 对GBK字符串进行转码成UTF-8
	 * 
	 * @param str 待解码字符串
	 * @return 字符串
	 * @throws Exception 
	 */
	public static String strGBKtoUtf8(String str) throws Exception {

		String toStr = null;

		if (str != null) {
			try {
				toStr = new String(str.getBytes("gbk"), "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

		return toStr;
	}
	
	/**
	 * 获取字符串中非GB2312字符
	 * 
	 * @param str 需要处理的字符串
	 * @return 字符串
	 */
	public static String getNotGB2312(String str) {
		str = nvl(str);
		char[] chars = str.toCharArray();
		String GB2312 = "";
		for (int i = 0; i < chars.length; i++) {
			try{
				byte[] bytes = ("" + chars[i]).getBytes("GB2312");
				if (bytes.length == 2) {
					int[] ints = new int[2];
					ints[0] = bytes[0] & 0xff;
					ints[1] = bytes[1] & 0xff;
					if (!(ints[0] >= 0xb0 && ints[0] <= 0xf7 && ints[1] >= 0xa1 && ints[1] <= 0xfe)) {
						GB2312 += chars[i];
					}
				}else{
					GB2312 += chars[i];
				}
			}catch(Exception e){
				GB2312 += chars[i];
				System.out.println("ERR====="+str);
				e.printStackTrace();
			}
		}
		return GB2312;
	}

	/**
	 * 取字符串的后几位，位数小于字符串，返回本身
	 * @param string
	 * @param num 获取的位数
	 * @return
	 */
    public static String subString(String string ,int num){
    	String returnValue = "";
    	if(string!=null){
        	int length = string.length();
        	
        	if(num>length){
        		returnValue = string;
        	}else{
        		returnValue = string.substring(length-num);
        	}
    	}
    	return returnValue;
    }
    
    /**
	 * 替代oldStr中head之前，end之后的字符串
	 * @param oldStr
	 * @param str
	 * @param head 
	 * @param end
	 * @return String
	 * 
	 */
	public static String strReplace(String oldStr ,String str,int head,int end){
		StringBuffer result = new StringBuffer();
		if(oldStr==null||oldStr==""){
			return result.toString();
		}else if(head>end||end>oldStr.length()||head<0){
			return oldStr;
		}
		
		for(int i=0;i<head;i++){
			result.append(str);
		}
		
		result.append(oldStr.substring(head,end));
		
		for(int i=end;i<oldStr.length();i++){
			result.append(str);
		}
		return result.toString();
	}
	 
	/**
	 * 截取字符串，输入字符串长度大于要截取的长度，则显示“…”
	 * @param input
	 * @param lettersNum 英文个数 ，一个中文占两个英文
	 * @return
	 */
	public static String subString2(String input,int lettersNum){
    	
    	if(input == null || input.trim() == ""){
    		return "";
    	}
    	String tmpStr = input.trim();
    	
    	if(tmpStr.length() * 2<= lettersNum){
    		return tmpStr;
    	}
    	
    	int num = 0;
    	String temp = "";
    	for(int i=0; i<tmpStr.length() && num < lettersNum; i++){
    		if(tmpStr.substring(i, i+1).getBytes().length > 1){
    			num += 2;
    			temp = tmpStr.substring(0, i+1);
    		}else{
    			num += 1;
    			temp = tmpStr.substring(0, i+1);
    		}
    	}
    	
    	if(temp.length() == tmpStr.length()){
    		return temp;
    	}else{
    		while(num > lettersNum - 2){
    			int i = temp.length();
    			
    			if(temp.substring(i-1, i).getBytes().length > 1){
    				num = num -2;
    			}else{
    				num = num - 1;
    			}
    			temp = temp.substring(0, i-1);
    		}
    		temp += "…";
    	}
    	
    	return temp;
    
	}
	
	/**
	 * 按字节截取字符串
	 * @param sourceStr
	 * @param byteLen
	 * @return
	 */
	public static String cutStringByByte(String sourceStr,int byteLen){
		if(sourceStr == null ) return "";
		String targetStr = sourceStr;
		byte[] sourceByte = sourceStr.getBytes();
    	if(sourceByte.length > byteLen){
    		targetStr = new String(sourceByte,0,byteLen);
    	}  
		return targetStr;
	}
    

	/**
	 * 把ISO-8859-1码转换成UTF-8
	 * 
	 * @param sISO
	 * @param sDBEncoding
	 * @return 字符串
	 */
	public static String ISOConvertUTF(String sISO, String sDBEncoding) {

		String sUTF;
		try {
			if (sISO == null || sISO.equals("")) {
				return "";
			} else {
				sISO = sISO.trim();
				sUTF = new String(sISO.getBytes(sDBEncoding), "GBK");
				return sUTF;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	/**
	 * 把UTF-8码转换成ISO-8859-1
	 * 
	 * @param sUTF
	 * @param sDBEncoding
	 * @return 字符串
	 */
	public static String UTFConvertISO(String sUTF, String sDBEncoding) {

		String sISO;
		try {
			if (sUTF == null || sUTF.equals("")) {
				return "";
			} else {
				sUTF = sUTF.trim();
				sISO = new String(sUTF.getBytes("GBK"), sDBEncoding);
				return sISO;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 把字符转换为Unicode(&#x????)编码
	 * 
	 * @param 转换前字符
	 * @return 转换后字符
	 */
	public static String toUnicodeX(String str) {
		char[] arChar = str.toCharArray();
		int iValue = 0;
		String uStr = "";
		for (int i = 0; i < arChar.length; i++) {
			iValue = (int) str.charAt(i);
			if (iValue <= 256) {
				uStr += "&#x00" + Integer.toHexString(iValue) + ";";
			}
			else {
				uStr += "&#x" + Integer.toHexString(iValue) + ";";
			}
		}
		return uStr;
	}

	/**
	 * 把字符转换为Unicode(\\u????)编码
	 * 
	 * @param 转换前字符
	 * @return 转换后字符
	 */
	public static String toUnicodeU(String str) {
		char[] arChar = str.toCharArray();
		int iValue = 0;
		String uStr = "";
		for (int i = 0; i < arChar.length; i++) {
			iValue = (int) str.charAt(i);
			if (iValue <= 256) {
				uStr += "\\u00" + Integer.toHexString(iValue);
			}
			else {
				uStr += "\\u" + Integer.toHexString(iValue);
			}
		}
		return uStr;
	}
}
