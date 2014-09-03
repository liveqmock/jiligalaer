package sy.common.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import sy.common.util.Constants;

/**
 * In this application we use a RuntimeException other than a checked Exception as exception for almost all application level Exception.
 */
public class AppRuntimeException extends RuntimeException implements Serializable {


	/** 消息类型 */
	private String type;
	
	/** 消息详细内容 */
	private String content;

	/** 消息中的可变属性 */
	private Map<String, Object> attrs = new HashMap<String, Object>(3);;

	public AppRuntimeException() {
		super();
		content = null; // zero represents unknown exception
	}

	public AppRuntimeException(String message) {
		super(message);
		content = null;
	}

	public AppRuntimeException(Throwable cause) {
		super(cause);
		content = null;
	}
	
	public AppRuntimeException(String message, Throwable cause) {
		super(message, cause);
		content = null;
	}

	public void setMessageContent(String content) {
		this.content = content;
	}
	
	@Override
	public String getMessage() {
		
		String message = super.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = Constants.DEFAULT_EXCEPTION_MSG;
		}
		return message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 取得消息ID
	 * 
	 * @return 消息ID
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 添加可变参数
	 * 
	 * @param attributeName  参数名
	 * 
	 * @param value 参数值
	 */
	public void setAttribute(String attributeName, String value) {
		// assert null != attributeName;
		// assert null != value;

		attrs.put(attributeName, value);
	}

	/**
	 * 取得参数列表
	 * 
	 * @return 参数列表
	 */
	public Map<String, Object> getAttribute() {
		return attrs;
	}
}
