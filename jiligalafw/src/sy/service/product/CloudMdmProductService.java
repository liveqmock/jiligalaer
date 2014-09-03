package sy.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmProduct;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.product.CloudProductCombinationPriceVo;
import sy.domain.vo.product.CloudProductPriceVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 产品主表
 * 
 * @author luobin
 * 
 */
@Service("cloudMdmProductService")
public class CloudMdmProductService extends
		BaseServiceTemplate<CloudMdmProduct, CloudMdmProductVo> implements
		CloudMdmProductServiceI {

	@Autowired
	private CloudMdmProductItemServiceI cloudMdmProductItemService;

	@Autowired
	private CloudProductCombinationPriceServiceI cloudProductCombinationPriceService;
	
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;

	public CloudMdmProductItemServiceI getCloudMdmProductItemService() {
		return cloudMdmProductItemService;
	}

	public void setCloudMdmProductItemService(
			CloudMdmProductItemServiceI cloudMdmProductItemService) {
		this.cloudMdmProductItemService = cloudMdmProductItemService;
	}

	public CloudProductCombinationPriceServiceI getCloudProductCombinationPriceService() {
		return cloudProductCombinationPriceService;
	}

	public void setCloudProductCombinationPriceService(
			CloudProductCombinationPriceServiceI cloudProductCombinationPriceService) {
		this.cloudProductCombinationPriceService = cloudProductCombinationPriceService;
	}

	public CloudProductPriceServiceI getCloudProductPriceService() {
		return cloudProductPriceService;
	}

	public void setCloudProductPriceService(
			CloudProductPriceServiceI cloudProductPriceService) {
		this.cloudProductPriceService = cloudProductPriceService;
	}

	@Override
	public List<CloudMdmProductVo> getAllCloudMdmProductByProdType(
			String prodType) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from CloudMdmProduct where state=1 and prodType="
				+ prodType;
		return this.find(CloudMdmProductVo.class, hql);
	}

	/**
	 * 保存产品信息
	 */
	public void saveProd(
			CloudMdmProductVo prodVo,
			CloudMdmProductItemVo itemVo,
			List<CloudProductCombinationPriceVo> cloudProductCombinationPriceList)
			throws ValidatorException {
		this.save(prodVo);
		this.cloudMdmProductItemService.save(itemVo);
		if (null != cloudProductCombinationPriceList
				&& cloudProductCombinationPriceList.size() != 0) {
			for (int i = 0; i < cloudProductCombinationPriceList.size(); i++) {
				cloudProductCombinationPriceService
						.save(cloudProductCombinationPriceList.get(i));
			}
		}
	}

	
	public void delProductById(String prodId) throws ValidatorException{
		CloudProductPriceVo priveVo = this.cloudProductPriceService.getPriceByProdId(prodId);
		if(null != priveVo){
			this.cloudProductPriceService.delete(priveVo.getId());
		}
		try {
			CloudMdmProductItemVo itemVo = this.cloudMdmProductItemService.getprodItemByProdId(prodId);
			this.cloudMdmProductItemService.delete(itemVo.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.delete(prodId);
	}
}
