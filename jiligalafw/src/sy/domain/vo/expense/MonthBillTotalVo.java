package sy.domain.vo.expense;

import java.util.Date;

import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;

/**
 * @author xhchen
 *
 */
public class MonthBillTotalVo extends BaseVo{
	
	private String month;
	private String monthTitle;
	private Double billTotal;
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonthTitle() {
		return monthTitle;
	}
	public void setMonthTitle(String monthTitle) {
		this.monthTitle = monthTitle;
	}
	public Double getBillTotal() {
		return billTotal;
	}
	public void setBillTotal(Double billTotal) {
		this.billTotal = billTotal;
	}
	
	
}
