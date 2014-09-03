package sy.domain.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import sy.domain.en.base.BasicRemindType;
import sy.domain.model.shared.PersistentObject;

/**
 * 提醒
 * @author lidongbo
 * 
 */
@Entity
@Table(name = "BASIC_REMIND")
public class BasicRemind implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1387388743561677114L;

	private String id;
	
	/** 账户ID */
	private String accountId;
	
	/** 用户ID */
	private String userId;

	/** 提醒类型，比如费用不足提醒，停机提醒，销毁提醒 */
	private BasicRemindType type;
	
	/** 消息 */
	private String message;
	
	private Date created;
	
	/** 系统提醒，计费功能 */
	private String createdBy;

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid", parameters = {
			@Parameter(name = "unsaved-value", value = "null")
	})
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ACCOUNT_ID")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "TYPE")
	@Enumerated(value = EnumType.STRING)
	public BasicRemindType getType() {
		return type;
	}

	public void setType(BasicRemindType type) {
		this.type = type;
	}

	@Column(name = "MESSAGE")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
