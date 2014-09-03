package sy.domain.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

@Entity
@Table(name = "BASIC_USER_ROLE")
public class BasicUserRole implements PersistentObject{
	
	private static final long serialVersionUID = 21L;
	
	/**
	 * 主键
	 */
	private String userRoleId;
	/**
	 * 用户外键
	 */
	private BasicUser basicUser;
	
	/**
	 * 角色外键
	 */
	private BasicRole basicRole;

	@Id
	@Column(name="USER_ROLE_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	@ManyToOne()  
    @JoinColumn(name = "USER_ID") 
	public BasicUser getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUser basicUser) {
		this.basicUser = basicUser;
	}

	
	@ManyToOne()  
    @JoinColumn(name = "ROLE_ID") 
	public BasicRole getBasicRole() {
		return basicRole;
	}
	public void setBasicRole(BasicRole basicRole) {
		this.basicRole = basicRole;
	}

	
}
