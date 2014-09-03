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

/**
 *
 * @author lidongbo
 *
 */
@Entity
@Table(name = "BASIC_ROLE_RES")
public class BasicRoleRes implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3961995123139216601L;

	private String id;
	
	private BasicRole role;
	
	private BasicResource resource;

	@Id
	@Column(name="ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	public BasicRole getRole() {
		return role;
	}

	public void setRole(BasicRole role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name = "RES_ID")
	public BasicResource getResource() {
		return resource;
	}

	public void setResource(BasicResource resource) {
		this.resource = resource;
	}
}
