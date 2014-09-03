package sy.service.product;

import java.util.List;

import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.product.CloudProductCombinationPriceVo;
import sy.service.shared.BasicServiceI;


/**
 * 产品主表
 * @author luobin
 *
 */
public interface CloudMdmProductServiceI extends BasicServiceI<CloudMdmProductVo> {

   List<CloudMdmProductVo> getAllCloudMdmProductByProdType(String prodType) throws Exception;
   
   /**
    * 保存产品信息
    * @param prodVo
    * @param itemVo
    * @throws ValidatorException
    */
   public void saveProd(CloudMdmProductVo prodVo, CloudMdmProductItemVo itemVo,List<CloudProductCombinationPriceVo> cloudProductCombinationPriceList) throws ValidatorException;
   
   /**
    * 删除产品（组合、单一）
    * @param prodId
    */
   public void delProductById(String prodId) throws ValidatorException;
}
