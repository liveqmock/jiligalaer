package sy.domain.vo.shared;

import java.io.Serializable;

import sy.common.util.Constants;

/**
 * 
 * @author lidongbo
 * 
 */
public abstract class BaseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errors;
	
	private String executorId;
	
	private String executorName;
	
	private String stateStr;

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getExecutorName() {
		return executorName;
	}

	public void setExecutorName(String executorName) {
		this.executorName = executorName;
	}

	public String getExecutorId() {
		return executorId;
	}

	public void setExecutorId(String executorId) {
		this.executorId = executorId;
	}

	public String getStateStr() {
		if(Constants.VALID_STATE == 1){
			stateStr = "有效";
		}else{
			stateStr = "无效";
		}
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
}
