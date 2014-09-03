package sy.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

/**
 * Oracle方言的工具类
 * @author chenjj
 */
public class OracleDialect {

	/**
	 * Oracle Timestamp 转换成 标准Timestamp
	 * @param ts Oracle Timestamp
	 * @return 标准Timestamp
	 */
	public static Timestamp toTimestamp(TIMESTAMP ts) {
		try {
			return ts.timestampValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Oracle Timestamp 转换成 标准Timestamp
	 * @param obj Oracle Timestamp
	 * @return 标准Timestamp
	 */
	public static Timestamp toTimestamp(Object obj) {
		return toTimestamp((TIMESTAMP) obj);
	}

	/**
	 * Clob转换成String
	 * @param clob Clob
	 * @return String
	 */
	public static String clob2String(Clob clob) {
		StringBuffer sb;
		try {
			BufferedReader in = new BufferedReader(clob.getCharacterStream());
			sb = new StringBuffer();
			String line = in.readLine();
			while (line != null) {
				sb.append(line);
				line = in.readLine();
			}
			return sb.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Clob转换成String
	 * @param obj Clob
	 * @return String
	 */
	public static String clob2String(Object obj) {
		return clob2String((Clob) obj);
	}

	/**
	 * BigDecimal转换成Integer
	 * @param bd BigDecimal
	 * @return Integer
	 */
	public static Integer toInteger(BigDecimal bd) {
		return new Integer(bd.intValue());
	}

	/**
	 * BigDecimal转换成Integer
	 * @param obj BigDecimal
	 * @return Integer
	 */
	public static Integer toInteger(Object obj) {
		return new Integer(((BigDecimal) obj).intValue());
	}
}
