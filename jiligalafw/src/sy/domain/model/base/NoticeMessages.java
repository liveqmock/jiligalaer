package sy.domain.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

/**
 * 系统公告信息PO
 * @author luobin
 *
 */
@Entity
@Table(name = "CLOUD_NOTICE_MESSAGES")
public class NoticeMessages implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971534758545616L;

	private String messId;
	
	private String messTitle;
	
	private String content;
	
	private Integer state;
	
	private String createdBy;
	
	private Date created;
	
	private String updatedBy;
	
	private Date updated;

	@Id
	@Column(name="MESS_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getMessId() {
		return messId;
	}

	public void setMessId(String messId) {
		this.messId = messId;
	}
	
	@Column(name="MESS_TITLE")
	public String getMessTitle() {
		return messTitle;
	}

	public void setMessTitle(String messTitle) {
		this.messTitle = messTitle;
	}

	@Column(name="CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name="UPDATED")
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
}
