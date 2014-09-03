package sy.domain.model.promotion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.product.CloudMdmProduct;
import sy.domain.model.shared.PersistentObject;

/**
 *
 * @author xhchen
 *
 */
@Entity
@Table(name = "CLOUD_PROMOTION_PRODUCT")
public class CloudPromotionProduct implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3361995123139216671L;

	private String id;
	
	private CloudPromotionInfo cloudPromotionInfo;
	
	private CloudMdmProduct cloudMdmProduct;

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
	@JoinColumn(name = "PROMOTION_ID")
	public CloudPromotionInfo getCloudPromotionInfo() {
		return cloudPromotionInfo;
	}

	public void setCloudPromotionInfo(CloudPromotionInfo cloudPromotionInfo) {
		this.cloudPromotionInfo = cloudPromotionInfo;
	}

	@ManyToOne
	@JoinColumn(name = "PROD_ID")
	public CloudMdmProduct getCloudMdmProduct() {
		return cloudMdmProduct;
	}

	public void setCloudMdmProduct(CloudMdmProduct cloudMdmProduct) {
		this.cloudMdmProduct = cloudMdmProduct;
	}
}
