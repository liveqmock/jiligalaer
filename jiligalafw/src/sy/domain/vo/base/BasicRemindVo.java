package sy.domain.vo.base;

import java.util.Date;

import sy.domain.vo.shared.BaseVo;

/**
 * 提醒
 * @author lidongbo
 * 
 */
public class BasicRemindVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4382551507348223893L;

	private String id;

	/** 账户ID */
	private String accountId;

	/** 用户ID */
	private String userId;

	/** 提醒类型，比如费用不足提醒，停机提醒，销毁提醒 */
	private String type;

	/** 消息 */
	private String message;

	private Date created;

	/** 系统提醒，计费功能 */
	private String createdBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
