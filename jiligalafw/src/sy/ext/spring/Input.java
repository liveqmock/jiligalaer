package sy.ext.spring;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.InputTag;

import sy.common.util.StringUtils;

/**
 * 
 * @author lidongbo
 * 
 */
public class Input extends InputTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7469707633494151840L;

	private String name;

	protected String getName() throws JspException {
		if (StringUtils.isNotBlank(name)) {
			return name;
		}
		return getPropertyPath();
	}

	public void setName(String name) {
		this.name = name;
	}

}
