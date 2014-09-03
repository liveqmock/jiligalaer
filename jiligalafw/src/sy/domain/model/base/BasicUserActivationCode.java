package sy.domain.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

@Entity
@Table(name = "BASIC_USER_ACTIVATION_CODE")
public class BasicUserActivationCode implements PersistentObject {

	private static final long serialVersionUID = 345232232L;

	/**
	 * 随机激活码 Key
	 */
	private String activationCode;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 状态,是否已激活使用过
	 */
	private Integer state;
    
	/**
	 * 创建日期.
	 */
	private Date created;
	
	/**
	 * 激活日期.
	 */
	private Date updated;
	
	
	@Id
	@Column(name = "ACTIVATION_CODE", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Column(name="UPDATED")
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	
}
