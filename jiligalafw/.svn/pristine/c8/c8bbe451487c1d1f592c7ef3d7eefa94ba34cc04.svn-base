package sy.common.model;

import java.io.Serializable;

import org.springframework.ui.ModelMap;

/**
 * 
 * @author lidongbo
 * 
 */
public class PageContext implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2167320495508508281L;
	
	public static int DEFAULT_PAGE = 1;
	public static int DEFAULT_PAGE_SIZE = 200;

	private boolean paging = true;

	private boolean export = false;

	private String exportType;

	private int pageNo = 1;

	private int pageSize = DEFAULT_PAGE_SIZE;

	private int totalRowCount;

	private int totalPageCount = 1;

	public void compute() {
		totalPageCount = totalRowCount % pageSize == 0 ? (totalRowCount / pageSize)
				: (totalRowCount / pageSize + 1);
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isPaging() {
		return paging;
	}

	public void setPaging(boolean paging) {
		this.paging = paging;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public boolean isExport() {
		return export;
	}

	public void setExport(boolean export) {
		this.export = export;
	}

	public String getExportType() {
		return exportType;
	}

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}

	public void initTotalRows(ModelMap modelMap) {
		modelMap.put("totalRows", getTotalRowCount());
	}
}
