package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmIPVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.service.shared.BasicServiceI;


/**
 * IP表
 * @author cs
 *
 */
public interface CloudMdmIPServiceI extends BasicServiceI<CloudMdmIPVo>, SynchronizeDataServiceI {

	/**
	 * 查看网络下的IP列表
	 * @param context
	 * @param networkid
	 * @return
	 * @throws ValidatorException
	 */
	public List<CloudMdmIPVo> listByNetwork(QueryContext context,
			String networkid) throws ValidatorException;
	
	/**
	 * 申请获取新的IP
	 * @param accountName
	 * @param networkid
	 * @return
	 * @throws ValidatorException
	 */
	public CloudMdmIPVo associateIpAddress(String accountName,String networkid) throws ValidatorException,CloudException;
	
	
	public void disassociateIpAddress(String ipid) throws ValidatorException,CloudException;
	
	public void enableStaticNat(String ipaddressid,String virtualmachineid) throws ValidatorException,CloudException;
	
	public void disableStaticNat(String ipaddressid) throws ValidatorException,CloudException;
	
	public CloudMdmIPVo getIpAddrByInterfaceId(String interfaceId);
	
	public CloudProductDetail getCloudMdmIpProduct();
	
}
