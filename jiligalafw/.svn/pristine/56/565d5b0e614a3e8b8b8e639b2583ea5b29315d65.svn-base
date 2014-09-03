package sy.common.util2;

import java.sql.Timestamp;

public class SqlUtil {

    private SqlUtil() {
    }
    

	/**
	 * 将格式如2007-04-18 00:00:00.0的字符串，<br>
	 * 转换为用于sql的字符串(to_timestamp('2007-04-18 00:00:00.0' , 'yyyy-mm-dd hh24:mi:ssxff'))
	 * 
	 * @param s 待转换的字符串
	 * @return 例如to_timestamp('2007-04-18 00:00:00.0' , 'yyyy-mm-dd hh24:mi:ssxff')
	 */
	public static String toTimeStamp(String s) {
		String sql = "to_timestamp('" + s + "' , 'yyyy-mm-dd hh24:mi:ssxff')";
		return sql;
	}
	
	/**
	 * 将java.sql.timestamp，<br>
	 * 转换为用于sql的字符串(to_timestamp('2007-04-18 00:00:00.0' , 'yyyy-mm-dd hh24:mi:ssxff'))
	 * 
	 * @param timestamp 待转换的timestamp
	 * @return 例如to_timestamp('2007-04-18 00:00:00.0' , 'yyyy-mm-dd hh24:mi:ssxff')
	 */
	public static String toTimeStamp(Timestamp timestamp) {
		String sql = "to_timestamp('" + timestamp.toString() + "' , 'yyyy-mm-dd hh24:mi:ssxff')";
		return sql;
	}
    
    /**
	 *
	 * 把字符串转换成合适的SQL查询语言,适用于  like  
	 * @param str 转换的字符串 - 可以为null
	 * @return String 返回转换后新的SQL文字符串，如果字符串为null就返回null
	 * 将用户传入的检索条件中的特殊字符进行转义
	 * <br/>
	 * 将 ' 转换 \'
	 * <br/>
	 * 将 " 转换 \"
	 * <br/>
	 * 将 % 转换 \%
	 * <br/>
	 * 用法 " like '"+name+"'" 改写为   " like '"+CmnUtFunc.escapeSql(name)+"'"
	 */
	public static String escapeSql(String str) {
		if(str==null||str.equals("")){
			return str;
		}else{
			StringBuffer buf = new StringBuffer();
			for(int i=0;i<str.length();i++){
				char c = str.charAt(i);
					switch(c){   
					//将 ' 转换为 ''
					case '\'':
						buf.append("''");
						break;
					//将 " 转换为 \"
					case '\"':
					    buf.append("\"");
					    break;
					//将 % 转换为 \%    
					case '%':
						buf.append("\\%");
						break;
					//将 $ 转换为 \$    
					case '$':
						buf.append("\\$");
						break;
					//将 \ 转换为 \\    
					case '\\':
						buf.append("\\\\");
						break;	
					default:
						buf.append(c);
						break;
				}
			}
			return buf.toString();
		}
	}
    
    
    
}
