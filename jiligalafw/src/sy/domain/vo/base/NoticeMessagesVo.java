package sy.domain.vo.base;

import java.util.Date;

import sy.common.util.validator.annotations.ValidateSize;
import sy.common.util.valuesetter.Create;
import sy.common.util.valuesetter.Update;
import sy.domain.vo.shared.BaseVo;

/**
 * 系统公告信息VO
 * @author luobin
 *
 */
public class NoticeMessagesVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String messId;
	
	@ValidateSize(description="标题",max=200)
	private String messTitle;
	
	@ValidateSize(description="内容",max=2000)
	private String content;
	
	private Integer state;
	
	@Create
	private String createdBy;
	
	@Create
	private Date created;
	
	@Update
	private String updatedBy;
	
	@Update
	private Date updated;
	

	public String getMessId() {
		return messId;
	}

	public void setMessId(String messId) {
		this.messId = messId;
	}

	public String getMessTitle() {
		return messTitle;
	}

	public void setMessTitle(String messTitle) {
		this.messTitle = messTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
