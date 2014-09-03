package sy.domain.vo.expense;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import sy.domain.vo.product.CloudProductPriceVo;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.domain.vo.product.CloudUserOrderVo;

/**
 *
 * @author lidongbo
 *
 */
public class BillingParameter {

	private Date now;
	
	private Date todayBegin;
	
	private String today;
	
	private String currentHour;
	
	private Date afterFewDaysEnd;
	
	private String afterDay;
	
	private int fewDays;
	
	private final SimpleDateFormat formater_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	
	private final SimpleDateFormat formater_yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private final SimpleDateFormat formater_yyyyMMddHH = new SimpleDateFormat("yyyy-MM-dd HH");
	
	private final Map<String, List<CloudUserOrderVo>> orderCache;
	
	private final Map<String, List<CloudUserOrderItemVo>> orderItemCache;
	
	private final Map<String, CloudProductPriceVo> prodPriceCache;
	
	public BillingParameter(
			int fewDays,
			Map<String, List<CloudUserOrderVo>> orderCache,
			Map<String, List<CloudUserOrderItemVo>> orderItemCache, Map<String, CloudProductPriceVo> prodPriceCache) {
		super();
		this.fewDays = fewDays;
		this.orderCache = orderCache;
		this.orderItemCache = orderItemCache;
		this.prodPriceCache = prodPriceCache;
		init();
	}

	private void init(){
		now = new Date();
		todayBegin = now;
		try {
			todayBegin = formater_yyyyMMddHHmmss.parse(formater_yyyyMMdd.format(now)+" 00:00:00");
		} catch (ParseException e) {
		}
		
		today = formater_yyyyMMdd.format(todayBegin);
		
		currentHour = formater_yyyyMMddHH.format(now);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(todayBegin);
		calendar.add(Calendar.DATE, fewDays);
		
		afterFewDaysEnd = calendar.getTime();
		try {
			afterFewDaysEnd = formater_yyyyMMddHHmmss.parse(formater_yyyyMMdd.format(calendar.getTime()) + " 23:59:59");
		} catch (ParseException e) {
		}
		afterDay = formater_yyyyMMdd.format(afterFewDaysEnd);
	}
	
	public Date getNow() {
		return now;
	}

	public Date getTodayBegin() {
		return todayBegin;
	}

	public int getFewDays() {
		return fewDays;
	}

	public Map<String, List<CloudUserOrderVo>> getOrderCache() {
		return orderCache;
	}

	public Map<String, List<CloudUserOrderItemVo>> getOrderItemCache() {
		return orderItemCache;
	}

	public Date getAfterFewDaysEnd() {
		return afterFewDaysEnd;
	}

	public String getToday() {
		return today;
	}

	public SimpleDateFormat getFormater_yyyyMMdd() {
		return formater_yyyyMMdd;
	}
	
	public SimpleDateFormat getFormater_yyyyMMddHH() {
		return formater_yyyyMMddHH;
	}

	public String getAfterDay() {
		return afterDay;
	}

	public SimpleDateFormat getFormater_yyyyMMddHHmmss() {
		return formater_yyyyMMddHHmmss;
	}
	
	public String getTodayBegin_yyyyMMddHHmmss(){
		return getFormater_yyyyMMddHHmmss().format(getTodayBegin());
	}
	
	public String getAfterFewDaysEnd_yyyyMMddHHmmss(){
		return getFormater_yyyyMMddHHmmss().format(getAfterFewDaysEnd());
	}

	public Map<String, CloudProductPriceVo> getProdPriceCache() {
		return prodPriceCache;
	}

	public String getCurrentHour() {
		return currentHour;
	}
	
}
