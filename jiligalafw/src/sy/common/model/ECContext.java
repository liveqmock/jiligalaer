package sy.common.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.extremecomponents.table.context.HttpServletRequestContext;
import org.extremecomponents.table.core.TableConstants;
import org.extremecomponents.table.filter.ExportFilterUtils;
import org.springframework.ui.ModelMap;

/**
 * 
 * @author lidongbo
 * 
 */
public class ECContext extends QueryContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6901809529528872773L;

	private static final String JOIN = "_";
	
	private HttpServletRequestContext context;

	public ECContext(HttpServletRequest request, ModelMap modelMap) {
		this(request, modelMap, "ec");
	}

	public ECContext(HttpServletRequest request, ModelMap modelMap,
			String nameSpace) {
		super(request, modelMap, nameSpace);
	}

	protected void initParams(HttpServletRequest request, ModelMap modelMap) {
		context = new HttpServletRequestContext((HttpServletRequest) request);
		super.initParams(request,modelMap);
	}
	
	protected void initParams() {

		put(TableConstants.EXPORT_TABLE_ID, null);

		String ev = get(getNameSpace() + JOIN + TableConstants.EXPORT_VIEW);
		if (ExportFilterUtils.isExported(context)) {
			setPageNo(DEFAULT_PAGE);
			setPaging(false);
			setPageSize(Integer.MAX_VALUE);
			setExport(true);
			setExportType(ev);
			put(getNameSpace() + JOIN + TableConstants.EXPORT_VIEW, null);
			put(getNameSpace() + JOIN + TableConstants.EXPORT_FILE_NAME, null);
		} else {

			String pageNoStr = get(getNameSpace() + JOIN + TableConstants.PAGE);
			if (pageNoStr != null && pageNoStr.length() > 0
					&& NumberUtils.isNumber(pageNoStr)) {
				setPageNo(NumberUtils.toInt(pageNoStr));
			} else {
				setPageNo(DEFAULT_PAGE);
			}

			String pageSizeStr = get(getNameSpace() + JOIN
					+ TableConstants.CURRENT_ROWS_DISPLAYED);
			if (pageSizeStr != null && pageSizeStr.length() > 0
					&& NumberUtils.isNumber(pageSizeStr)) {
				setPageSize(NumberUtils.toInt(pageSizeStr));
			} else {
				setPageSize(DEFAULT_PAGE_SIZE);
			}
		}

	}

}
