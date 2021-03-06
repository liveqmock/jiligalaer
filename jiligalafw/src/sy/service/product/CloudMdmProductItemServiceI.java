package sy.service.product;

import java.util.List;

import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudVmCellDetailVo;
import sy.service.shared.BasicServiceI;


/**
 * 产品子表
 * @author luobin
 *
 */
public interface CloudMdmProductItemServiceI extends BasicServiceI<CloudMdmProductItemVo> {


	/**
	 * 根据产品主表ID获取产品子表信息
	 * @param prodId
	 * @return
	 */
	CloudMdmProductItemVo getprodItemByProdId(String prodId) throws Exception;

	/**
	 * 账户添加网络:获取已定价、并且已生效的单一产品网络方案
    */
	public List<Object[]> getNetworkSingleProd(String zoneId);
	
	/**
	 * 获取 模板 单一产品列表
	 */
	public List<Object[]> getTemplateSingleProd(String zoneId);
		
	/**
	 * 获取 计算资源 单一产品列表
	 */
	public List<Object[]> getCpuSolnSingleProd();
	
	/**
	 * 获取 磁盘 资源 单一产品列表
	 */
	public List<Object[]> getDiskSolnSingleProd();
	
	/**
	 * 根据ItemId获取单一产品信息
	 * @param prodId
	 * @return
	 * @throws Exception
	 */
	public CloudMdmProductItemVo getProdByItemId(String itemId) throws Exception;
	/**
	 * 通过组合产品的id获取各元素的IF_ID
	 */
	public CloudVmCellDetailVo getVmCellDetailByProdId(String prodId) throws Exception;

	
	public CloudMdmProductItemVo getprodItemByProdItemId(String prodItemId) throws Exception;
	

}
