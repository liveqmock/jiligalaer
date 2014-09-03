package sy.common.model;

import java.util.List;

/**
 * 后台向前台返回JSON，用于easyui的datagrid
 * 
 */
public class DataGridJson {

	private Long total = (long) 0;// 总记录数
	private List rows;// 每行记录
	private List footer;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}

}