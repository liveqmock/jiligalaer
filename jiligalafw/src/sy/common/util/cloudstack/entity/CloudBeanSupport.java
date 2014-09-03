package sy.common.util.cloudstack.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import sy.common.util.cloudstack.CloudBean;

/**
 * 
 * @author lidongbo
 * 
 */
public class CloudBeanSupport implements CloudBean {

	public String getId(){
		return null;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
