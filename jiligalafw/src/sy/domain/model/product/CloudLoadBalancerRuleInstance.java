package sy.domain.model.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

/**
 * 
 * @author lidongbo
 * 
 */
@Entity
@Table(name = "CLOUD_LOAD_BALANCER_RULE_INSTANCE")
public class CloudLoadBalancerRuleInstance implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1406239479238094661L;

	
	private String id;
	
	private String lbruleid;

	/**虚拟机ID*/
	private String virtualmachineid;

	/**
	 * 同步时间
	 */
	private Date syncTime;
	
	@Column
	public String getLbruleid() {
		return lbruleid;
	}

	public void setLbruleid(String lbruleid) {
		this.lbruleid = lbruleid;
	}

	@Column
	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	@Column(name = "SYNC_TIME")
	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
}
