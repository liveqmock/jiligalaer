package sy.service.product;

import java.util.List;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.entity.FreeuserIpaddressByZoneid;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmIPVo;
import sy.service.shared.BasicServiceI;


/**
 * 空闲IP列表
 * @author luobin
 *
 */
public interface CloudMdmFreeIPServiceI extends BasicServiceI<CloudMdmIPVo>, SynchronizeDataServiceI {


	public List<FreeuserIpaddressByZoneid> getFreeIpAddressByZoneid(String zoneid) throws ValidatorException, CloudException;
	
}
