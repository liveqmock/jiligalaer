package sy.ext.extreme;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.filter.AbstractExportFilter;
import org.extremecomponents.table.filter.ExportResponseWrapper;

/**
 *
 * @author lidongbo
 *
 */
public class ExportFilter extends AbstractExportFilter {
    private boolean responseHeadersSetBeforeDoFilter;

    public void init(FilterConfig filterConfig) throws ServletException {
        String responseHeadersSetBeforeDoFilter = filterConfig.getInitParameter("responseHeadersSetBeforeDoFilter");
        if (StringUtils.isNotBlank(responseHeadersSetBeforeDoFilter)) {
            this.responseHeadersSetBeforeDoFilter = new Boolean(responseHeadersSetBeforeDoFilter).booleanValue();
        }
    }
    
    public void destroy() {}

    protected void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain, String exportFileName) throws IOException, ServletException {
		exportFileName = new String(exportFileName.getBytes("GBK"),
				"ISO-8859-1");
    	if (responseHeadersSetBeforeDoFilter) {
            setResponseHeaders((HttpServletResponse) response, exportFileName);
        }
        chain.doFilter(request, new ExportResponseWrapper((HttpServletResponse) response));
        if (!responseHeadersSetBeforeDoFilter) {
            setResponseHeaders((HttpServletResponse) response, exportFileName);
        }
    }
}
