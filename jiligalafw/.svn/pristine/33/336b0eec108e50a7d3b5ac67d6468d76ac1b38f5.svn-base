/*
 * Created on 2005-5-18 Window - Preferences - Java - Code Style - Code Templates
 */
package sy.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期格式化类
 * 
 * @author liby
 * @version $vision: 1.0 $ $Date: 2005/05/20 16:40:28 $
 */
public class DateUtil extends Date {
	private static final long serialVersionUID = 1L;
	
	private static String strFormat1 = "yyyy-MM-dd HH:mm";
	private static String strFormat2 = "yyyy-MM-dd";
	private static String strFormat3 = "yyyy/MM/dd";
	private static String strFormat4 = "yyyy/MM/dd HH:mm";
	private static String strFormat5 = "HH:mm";
	private static String strFormat6 = "h:mm a";
	private static String strFormat7 = "yyyyMMddHHmmss";
	private static String strFormat8 = "yyyy-MM-dd HH:mm:ss";
	private static String strFormat9 = "ddMMMyy";
	private static String strFormat10 = "yyyyMMdd";
	private static String strFormat15 = "yyMM";
	private static String strFormat17 = "MM/dd/yyyy";
	private static String strFormat18 = "dd/MM/yyyy";
	private static String strFormat19 = "yy-MM-dd";
	private static String strFormat20 = "yyyyMMddHHmmssSSS";
	
	/**
	 * 日期类型转化
	 * 
	 * @param tsp 日期
	 * @param iType 
	 *            0:yyyy年M月d日； <br>
	 *            1:yyyy-M-d; <br>
	 *            2:yyyy/M/d <br>
	 *            3:yyyy年MM月dd日; <br>
	 *            4:yyyy-MM-dd; <br>
	 *            5:yyyy/MM/dd; <br>
	 *            6:yyyy-MM-dd HH:mm; <br>
	 *            7:yyyy/MM/dd HH:mm; <br>
	 *            8:HH:mm <br>
	 *            9:h:mm a <br>
	 *            10:yyyyMMdd <br>
	 *            11:yyyyMMddHHmmss<br>
	 *            12:yyyy-MM-dd HH:mm:ss <br>
	 *            13:HH:mm:ss <br>
	 *            14:ddMMMyy <br>
	 *            15:yyMM <br>
	 *            16:上一个月日期yyyyMMdd
	 *            17:MM/dd/yyyy
	 *            18:dd/MM/yyyy
	 *            19:yy-MM-dd;
	 *            19:yyyyMMddHHmmssSSS;
	 * @return 日期串
	 */
	public static String formatDate(Timestamp tsp, int iType) {
		
		SimpleDateFormat sFormat1  = new SimpleDateFormat(strFormat1 );
		SimpleDateFormat sFormat2  = new SimpleDateFormat(strFormat2 );
		SimpleDateFormat sFormat3  = new SimpleDateFormat(strFormat3 );
		SimpleDateFormat sFormat4  = new SimpleDateFormat(strFormat4 );
		SimpleDateFormat sFormat5  = new SimpleDateFormat(strFormat5 );
		SimpleDateFormat sFormat6  = new SimpleDateFormat(strFormat6 );
		SimpleDateFormat sFormat7  = new SimpleDateFormat(strFormat7 );
		SimpleDateFormat sFormat8  = new SimpleDateFormat(strFormat8 );
		SimpleDateFormat sFormat9  = new SimpleDateFormat(strFormat9 );
		SimpleDateFormat sFormat10 = new SimpleDateFormat(strFormat10);
		SimpleDateFormat sFormat15 = new SimpleDateFormat(strFormat15);
		SimpleDateFormat sFormat17 = new SimpleDateFormat(strFormat17);
		SimpleDateFormat sFormat18 = new SimpleDateFormat(strFormat18);
		SimpleDateFormat sFormat19 = new SimpleDateFormat(strFormat19);
		SimpleDateFormat sFormat20 = new SimpleDateFormat(strFormat20);

		GregorianCalendar cal = new GregorianCalendar();

		if (tsp == null) {
			cal.setTime(new DateUtil());
		} else {
			cal.setTime(tsp);
		}

		String sDate = "";
		// 0:yyyy年M月d日
		if (iType == 0) {
			int iYear = cal.get(Calendar.YEAR);
			int iMonth = cal.get(Calendar.MONTH) + 1;
			int iDay = cal.get(Calendar.DAY_OF_MONTH);

			sDate = "" + iYear + "年" + iMonth + "月" + iDay + "日";
		}
		// 1:yyyy-M-d
		if (iType == 1) {
			int iYear = cal.get(Calendar.YEAR);
			int iMonth = cal.get(Calendar.MONTH) + 1;
			int iDay = cal.get(Calendar.DAY_OF_MONTH);

			sDate = "" + iYear + "-" + iMonth + "-" + iDay;
		}
		// 2:yyyy/M/d
		if (iType == 2) {
			int iYear = cal.get(Calendar.YEAR);
			int iMonth = cal.get(Calendar.MONTH) + 1;
			int iDay = cal.get(Calendar.DAY_OF_MONTH);

			sDate = "" + iYear + "/" + iMonth + "/" + iDay;
		}
		// 3:yyyy年MM月dd日;
		if (iType == 3) {
			String strYear = String.valueOf(cal.get(Calendar.YEAR));
			String strMonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
			strMonth = "00" + strMonth;
			strMonth = strMonth.substring(strMonth.length() - 2, strMonth.length());
			String strDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			strDay = "00" + strDay;
			strDay = strDay.substring(strDay.length() - 2, strDay.length());

			sDate = "" + strYear + "年" + strMonth + "月" + strDay + "日";
		}
		// 4:yyyy-MM-dd;
		if (iType == 4) {
			sDate = sFormat2.format(cal.getTime());
		}
		// 5:yyyy/MM/dd;
		if (iType == 5) {
			sDate = sFormat3.format(cal.getTime());
		}
		// 6:yyyy-MM-dd HH:mm;
		if (iType == 6) {
			sDate = sFormat1.format(cal.getTime());
		}
		// 7:yyyy/MM/dd HH:mm;
		if (iType == 7) {
			sDate = sFormat4.format(cal.getTime());
		}
		// 8:HH:mm
		if (iType == 8) {
			sDate = sFormat5.format(cal.getTime());
		}
		// 9:h:mm a
		if (iType == 9) {
			sDate = sFormat6.format(cal.getTime());
		}
		// 10:h:mm a
		if (iType == 10) {
			sDate = sFormat10.format(cal.getTime());
		}
		if (iType == 11) {
			sDate = sFormat7.format(cal.getTime());
		}
		// 12:yyyy-MM-dd HH:mm:ss;
		if (iType == 12) {
			sDate = sFormat8.format(cal.getTime());
		}
		// 13:HH:mm:ss;
		if (iType == 13) {
			sDate = sFormat8.format(cal.getTime());
			sDate = sDate.substring(10);
		}
		// 14:ddMMMyy
		if (iType == 14) {
			sDate = sFormat9.format(cal.getTime());
		}
		// 15:yyMM
		if (iType == 15) {
			sDate = sFormat15.format(cal.getTime());
		}
		if (iType == 16) {
			int iYear = cal.get(Calendar.YEAR);
			int iMonth = cal.get(Calendar.MONTH) + 1;
			int iDay = cal.get(Calendar.DAY_OF_MONTH);
			switch (iMonth) {
			case 1: {
				cal.set(iYear, Calendar.JANUARY, iDay);
				break;
			}
			case 2: {
				cal.set(iYear, Calendar.FEBRUARY, iDay);
				break;
			}
			case 3: {
				cal.set(iYear, Calendar.MARCH, iDay);
				break;
			}
			case 4: {
				cal.set(iYear, Calendar.APRIL, iDay);
				break;
			}
			case 5: {
				cal.set(iYear, Calendar.MAY, iDay);
				break;
			}
			case 6: {
				cal.set(iYear, Calendar.JUNE, iDay);
				break;
			}
			case 7: {
				cal.set(iYear, Calendar.JULY, iDay);
				break;
			}
			case 8: {
				cal.set(iYear, Calendar.AUGUST, iDay);
				break;
			}
			case 9: {
				cal.set(iYear, Calendar.SEPTEMBER, iDay);
				break;
			}
			case 10: {
				cal.set(iYear, Calendar.OCTOBER, iDay);
				break;
			}
			case 11: {
				cal.set(iYear, Calendar.NOVEMBER, iDay);
				break;
			}
			case 12: {
				cal.set(iYear, Calendar.DECEMBER, iDay);
				break;
			}
			}
			cal.add(Calendar.MONTH, -1);
			sDate = sFormat2.format(cal.getTime());

		}
		// 17:MM/dd/yyyy
		if (iType == 17) {
			sDate = sFormat17.format(cal.getTime());
		}
		
		// 18:dd/MM/yyyy
		if (iType == 18) {
			sDate = sFormat18.format(cal.getTime());
		}
		// 19:yy-MM-dd;
		if (iType == 19) {
			sDate = sFormat19.format(cal.getTime());
		}
		if (iType == 20) {
			sDate = sFormat20.format(cal.getTime());
		}
		return sDate;
	}

	/**
	 * 日期类型转化
	 * 
	 * @param sTsp 日期串
	 * @param iType 0:yyyy年M月d日； <br>
	 *            1:yyyy-M-d; <br>
	 *            2:yyyy/M/d <br>
	 *            3:yyyy年MM月dd日; <br>
	 *            4:yyyy-MM-dd; <br>
	 *            5:yyyy/MM/dd; <br>
	 *            6:yyyy-MM-dd HH:mm; <br>
	 *            7:yyyy/MM/dd HH:mm; <br>
	 *            8:HH:mm <br>
	 *            9:h:mm a <br>
	 *            10:yyyyMMdd <br>
	 *            11:yyyyMMddHHmmSS<br>
	 *            12:yyyy-MM-dd HH:mm:ss <br>
	 *            13:HH:mm:ss <br>
	 *            14:ddMMMyy <br>
	 *            15:yyMM <br>
	 *            17:MM/dd/yyyy <br>
	 *            18:dd/MM/yyyy <br>
	 *            19:yy-MM-dd
	 * @return 日期串
	 */
	public static String formatDate(String sTsp, int iType) {

		if (sTsp == null || "".equals(sTsp)) {
			return "";
		}

		if (sTsp.length() == 10) {
			return formatDate(convertTimestamp(sTsp), iType);
		} else if (sTsp.length() > 10) {
			String[] sDatas = sTsp.split("\\.");
			if (sDatas.length > 2) {
				if (sDatas.length > 1) {
					String[] sDates = sDatas[0].split("-");
					if (sDates[1].length() == 1)
						sDates[1] = "0" + sDates[1];
					if (sDates[2].length() == 1)
						sDates[2] = "0" + sDates[2];

					for (int i = 1; i < 4; i++) {
						sDatas[i] = sDatas[i].trim();
						if (sDatas[i].length() == 1)
							sDatas[i] = "0" + sDatas[i];
					}

					sTsp = sDates[0] + "-" + sDates[1] + "-" + sDates[2] + " " + sDatas[1] + ":" + sDatas[2] + ":" + sDatas[3] + ".000000000";
				}
			}

			return formatDate(Timestamp.valueOf(sTsp), iType);
		} else {
			return "";
		}
	}
	
	/**
	 * String转换为Date
	 * 
	 * @param sDate 日期"yyyy-MM-dd"
	 * @return 日期Date
	 */
	public static Date convertDate(String sDate) {
		SimpleDateFormat sFormat = new SimpleDateFormat(strFormat2);
		Date d = null;
		try {
			d = sFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * String转换为Date
	 * 
	 * @param sDate 日期"yyyy-MM-dd HH:mm:ss"
	 * @return 日期Date
	 */
	public static Date convertDateTime(String sDate) {
		SimpleDateFormat sFormat = new SimpleDateFormat(strFormat8);
		Date d = null;
		try {
			d = sFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * String转换为Timestamp
	 * 
	 * @param sDate 日期 "yyyy-MM-dd" / "yyyy-MM-dd HH:mm:ss"
	 * @return 日期Timestamp
	 */
	public static Timestamp convertTimestamp(String sDate) {
		if (sDate.length() == 10) {
			sDate = sDate + " 00:00:00";
		}
		if (sDate.length() == 16) {
			sDate = sDate + ":00";
		}
		return Timestamp.valueOf(sDate);
	}

	/**
	 * 日期格式化
	 * 
	 * @param date 日期
	 * @return 日期"yyyy-MM-dd"
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat sFormat = new SimpleDateFormat(strFormat2);
		if (date == null) {
			return "";
		}
		return sFormat.format(date);
	}

	/**
	 * 时间格式化
	 * 
	 * @param date 日期
	 * @return "HH:mm"
	 */
	public static String formatTime(Date date) {
		SimpleDateFormat sFormat = new SimpleDateFormat(strFormat5);
		if (date == null) {
			return "";
		}
		return sFormat.format(date);
	}
	
	/**
	 * 日期格式化
	 * 
	 * @param date 日期
	 * @return 日期"yyyy-MM-dd HH:mm:ss"
	 */
	public static String formatDateTime(Date date) {
		SimpleDateFormat sFormat = new SimpleDateFormat(strFormat8);
		if (date == null) {
			return "";
		}
		return sFormat.format(date);
	}

	/**
	 * 取得n分钟前的时间
	 * 
	 * @param date 日期
	 * @param lminute
	 * @return 时间Timestamp
	 */
	public static Timestamp getAfterMinute(Date date, long lminute) {

		long lngTime = date.getTime() - lminute * 60 * 1000;

		return new Timestamp(lngTime);
	}

	/**
	 * 取得指定日期几天后的日期
	 * 
	 * @param date 日期
	 * @param afterDays 天数
	 * @return 日期
	 */
	public static Date getAfterDay(Date date, int afterDays) {
		GregorianCalendar cal = new GregorianCalendar();
		if (date == null) {
			cal.setTime(new DateUtil());
		} else {
			cal.setTime(date);
		}
		cal.add(java.util.Calendar.DATE, afterDays);
		return cal.getTime();
	}

	/**
	 * 取得指定日期几天后的日期
	 * 
	 * @param sDate 日期
	 * @param afterDays 天数
	 * @return 日期
	 */
	public static String getAfterDay(String sDate, int afterDays) {
		Date date = null;
		try {
			date = convertDate(sDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		date = getAfterDay(date, afterDays);
		return formatDate(date);
	}
	
	/**
	 * 获得几个月后的日期
	 * 
	 * @param date 日期
	 * @param afterMonth 月数
	 * @return 日期Date
	 */
	public static Date getAfterMonth(Date date, int afterMonth) {
		GregorianCalendar cal = new GregorianCalendar();
		if (date == null) {
			cal.setTime(new DateUtil());
		} else {
			cal.setTime(date);
		}
		cal.add(java.util.Calendar.MONTH, afterMonth);
		return cal.getTime();
	}
	
	/**
	 * 获得几个月后的日期 
	 * 
	 * @param sDate 日期
	 * @param afterMonth 月数
	 * @return 日期"yyyy-MM-dd HH:mm"
	 */
	public static String getAfterMonth(String sDate, int afterMonth) {
		SimpleDateFormat sFormat1 = new SimpleDateFormat(strFormat1);
		
		Date date = null;
		try {
			date = sFormat1.parse(sDate);
			date = getAfterMonth(date, afterMonth);
			return sFormat1.format(date);
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获得几年后的日期
	 * 
	 * @param date 日期
	 * @param afterYear 年数
	 * @return 日期Date
	 */
	public static Date getAfterYear(Date date, int afterYear) {
		GregorianCalendar cal = new GregorianCalendar();
		if (date == null) {
			cal.setTime(new DateUtil());
		} else {
			cal.setTime(date);
		}
		cal.add(java.util.Calendar.YEAR, afterYear);
		return cal.getTime();
	}

	/**
	 * 取得时间差
	 * 
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return 日期2-日期1的毫秒时间差
	 */
	public static long getDateDifference(Date date1, Date date2) {
		Calendar cld1Work = Calendar.getInstance();
		Calendar cld2Work = Calendar.getInstance();
		Calendar cld1 = Calendar.getInstance();
		Calendar cld2 = Calendar.getInstance();
		long lTime1;
		long lTime2;

		cld1Work.setTime(date1);
		cld2Work.setTime(date2);
		cld1.clear();
		cld2.clear();
		cld1.set(cld1Work.get(Calendar.YEAR), cld1Work.get(Calendar.MONTH), cld1Work.get(Calendar.DATE));
		cld2.set(cld2Work.get(Calendar.YEAR), cld2Work.get(Calendar.MONTH), cld2Work.get(Calendar.DATE));
		lTime1 = (cld1.getTime()).getTime();
		lTime2 = (cld2.getTime()).getTime();

		return (lTime2 - lTime1) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 构造函数
	 */
	public DateUtil() {
		super(getCalendarNow().getTime().getTime());
	}
	
	/**
	 * 取当前系统时间
	 * 
	 * @return 时间Calendar
	 */
	public static Calendar getCalendarNow() {
		return Calendar.getInstance();
	}
	
	/**
	 * 当前时间
	 * 
	 * @return 时间Timestamp
	 */
	public java.sql.Timestamp getTimestampNow() {
		return new java.sql.Timestamp(this.getTime());
	}
	
	/**
	 * 取当前日期(yyyy-mm-dd)
	 * 
	 * @return 时间Timestamp
	 */
	public static String getTodayDate() {
		return formatDate(new DateUtil().getTimestampNow(),4);
	}
	
	/**
	 * 取当前日期(yyyy-mm-dd hh:mm:ss)
	 * 
	 * @return 时间Timestamp
	 */
	public static String getTodayDateTime() {
		return formatDate(new DateUtil().getTimestampNow(),12);
	}

	/**
	 * 取当前日期(yyyyMMddHHmmss)
	 * 
	 * @return 时间Timestamp
	 */
	public static String getTodayDateTimeS() {
		return formatDate(new DateUtil().getTimestampNow(),11);
	}
	
	/**
	 * 取当前日期(yyyyMMddHHmmssSSS)
	 * 
	 * @return 时间Timestamp
	 */
	public static String getTodayDateTimeSSS() {
		return formatDate(new DateUtil().getTimestampNow(),20);
	}
	
	/**
	 * 取得月份第一天日期
	 * @param sDate(yyyy-mm-dd) : 如为Null，默认取当前系统时间
	 * @return yyyy-mm-dd
	 */
	public static String getMonthFirstDay(String sDate) {
		Date date = null;
		if(!StringUtil.isNull(sDate)) {
			date = convertDate(sDate);
		}
		Calendar gc = Calendar.getInstance();
		if (date != null) {
			gc.setTime(date);
		}
		gc.set(Calendar.DATE, 1);
		
		return formatDate(gc.getTime());
	}

	/**
	 * 取得月份最后一天日期
	 * @param sDate(yyyy-mm-dd) : 如为Null，默认取当前系统时间
	 * @return yyyy-mm-dd
	 */
	public static String getMonthLastDay(String sDate) {
		Date date = null;
		
		if(!StringUtil.isNull(sDate)) {
			date = convertDate(sDate);
		}
		Calendar gc = Calendar.getInstance();
		if (date != null) {
			gc.setTime(date);
		}
		gc.add(Calendar.MONTH, 1);
		gc.add(Calendar.DATE, -gc.get(Calendar.DAY_OF_MONTH));
		
		return formatDate(gc.getTime());
	}

	/**
	 * @描述: 得到本年的第一天
	 * 
	 */
	public static String getFirstDayOfYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return String.valueOf(year) + "-01-01";
	}

	/**
	 * @描述: 得到本年的最后一天
	 * 
	 */
	public static String getLastDayOfYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return String.valueOf(year) + "-12-31";
	}
	
	/**
	 * @描述: 得到去年的第一天
	 * 
	 */
	public static String getFirstDayOfLastYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return String.valueOf(year-1) + "-01-01";
	}

	/**
	 * @描述: 得到去年的最后一天
	 * 
	 */
	public static String getLastDayOfLastYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return String.valueOf(year-1) + "-12-31";
	}
	
	/**
	 * @描述: 得到上月的第一天
	 * 
	 */
	public static String getFirstDayOfLastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(cal.getTimeInMillis() - cal.get(Calendar.DAY_OF_MONTH) * 86400000L);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return formatDate(cal.getTime());
	}

	/**
	 * @描述: 得到上月的最后一天
	 * 
	 */
	public static String getLastDayOfLastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(cal.getTimeInMillis() - cal.get(Calendar.DAY_OF_MONTH) * 86400000L);
		return formatDate(cal.getTime());
	}

	/**
	 * @描述: 得到下月的第一天
	 * 
	 */
	public static String getFirstDayOfNextMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.setTimeInMillis(cal.getTimeInMillis() + cal.getActualMaximum(Calendar.DAY_OF_MONTH) * 86400000L);
		return formatDate(cal.getTime());
	}

	/**
	 * @描述: 得到下月的最后一天
	 * 
	 */
	public static String getLastDayOfNextMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(cal.getTimeInMillis() + cal.getActualMaximum(Calendar.DAY_OF_MONTH) * 86400000L);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.setTimeInMillis(cal.getTimeInMillis() + (cal.getActualMaximum(Calendar.DAY_OF_MONTH)-1) * 86400000L);
		return formatDate(cal.getTime());
	}

	/**
	 * @描述: 得到上周的第一天
	 * 
	 */
	public static String getFirstDayOfLastWeek() {
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
			calendar.add(Calendar.WEEK_OF_YEAR, -2);
		}else{
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
		}
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000L);
		return formatDate(calendar.getTime());
	}

	/**
	 * @描述: 得到上周的最后一天
	 * 
	 */
	public static String getLastDayOfLastWeek() {
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
			calendar.add(Calendar.WEEK_OF_YEAR, -2);
		}else{
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
		}
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000L);
		return formatDate(calendar.getTime());
	}

	/**
	 * @描述: 得到本周的第一天
	 * 
	 */
	public static String getFirstDayOfCurrWeek() {
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
			calendar.setTimeInMillis(calendar.getTimeInMillis() - 86400000L * 7);
		}
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000L);
		return formatDate(calendar.getTime());
	}

	/**
	 * @描述: 得到本周的最后一天
	 * 
	 */
	public static String getLastDayOfCurrWeek() {
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
			calendar.setTimeInMillis(calendar.getTimeInMillis() - 86400000L * 7);
		}	
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000L);
		return formatDate(calendar.getTime());
	}
	
	/**
	 * 获取下一个小时整点的时间
	 * @return
	 */
	public static Date getNextHourOfCurrHour() {
		java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH"); 
		SimpleDateFormat sFormat = new SimpleDateFormat(strFormat8);
		java.util.Calendar calendar=java.util.Calendar.getInstance(); 
		calendar.setTime(new Date());
		calendar.add(java.util.Calendar.HOUR, 1); 
		String nextHourDate = df.format(calendar.getTime()) + ":00:00";
		try {
			return sFormat.parse(nextHourDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args){
		System.err.println("1:"+getNextHourOfCurrHour());
		
//		System.err.println("1:"+getFirstDayOfCurrWeek());
//		System.err.println("2:"+getLastDayOfCurrWeek());
//		
//		System.err.println("1:"+getFirstDayOfLastWeek());
//		System.err.println("2:"+getLastDayOfLastWeek());
	}
	/**
	 * 取得日期，星期几
	 * 
	 * @param dateTime : dateTime
	 * @return "星期日","星期一","星期二","星期三","星期四","星期五","星期六"
	 */
	public static String getWeekDayName(String dateTime) throws ParseException {

		String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Date d = convertDate(dateTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		String week_day_name = dayNames[day - 1];
		return week_day_name;
	}
	
	/**
	 * 传入的日期格式是否是yyyy-MM-dd
	 * 
	 * @param in 被检查的日期
	 * @return 是指定的日期格式:true,否则:false
	 */
	public static boolean isFormatDate(String in) {
		return isFormatDate(in, "yyyy-MM-dd");
	}

    /**
     * 传入的日期格式是否是指定的日期格式
     *
     * @param in 被检查的日期
     * @param format 指定的日期格式
     * @return 是指定的日期格式:true,否则:false
     */
    private static boolean isFormatDate(String in, String format) {
        if (!StringUtil.isNull(format)) {
            return false;
        }

        final SimpleDateFormat sdFormat = new SimpleDateFormat(format);
        Date dateCompare = null;
        String sDate = "";

        try {
            dateCompare = sdFormat.parse(in, new ParsePosition(0));
            sDate = sdFormat.format(dateCompare);
        } catch (final Exception e) {
            return false;
        }

        if (dateCompare == null) {
            return false;
        } else {
            return sDate.equals(in);
        }
    }

    /**
     * 比较两个日期先后
     *
     * @param date1 : yyyy-MM-dd
     * @param date1 : yyyy-MM-dd
     * @return date1 > date2 : true，  else : false
     */
	public static boolean compareDate(String date1, String date2) {
		if (isFormatDate(date1, "yyyy-MM-dd") && isFormatDate(date2, "yyyy-MM-dd")) {
			if (date1.compareTo(date2) > 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * 比较两个日期先后
	 * 
     * @param date1 : yyyy-MM-dd
     * @param date1 : yyyy-MM-dd
     * @return date1 > date2 : true，  else : false
	 * */
	public static boolean compareDate2(String date1, String date2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * 将Date类型转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 * @param pattern 字符串格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "null";
		}
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		return new java.text.SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date convert(String date) {
		return convert(date, null);
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 * @param pattern 格式
	 * @return
	 */
	public static Date convert(String date, String pattern) {
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (date == null || date.equals("") || date.equals("null")) {
			return null;
		}
		Date d = null;
		try {
			d = new java.text.SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
		}
		return d;
	}
	
	/**
	  * 得到某年某月的第一天
	  * 
	  * @param year
	  * @param month
	  * @return
	  */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));

		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	 
	 /**
	  * 得到某年某月的最后一天
	  * 
	  * @param year
	  * @param month
	  * @return
	  */ 
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);

		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	 
}
