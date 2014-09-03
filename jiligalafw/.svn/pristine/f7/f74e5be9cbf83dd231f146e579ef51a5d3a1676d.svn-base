package sy.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CSQuqeyContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.FreeipaddressRepository;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.FreeuserIpaddressByZoneid;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmIP;
import sy.domain.vo.product.CloudMdmIPVo;

/**
 * 空闲IP列表
 * @author luobin
 * 
 */
@Service("cloudMdmFreeIPService")
public class CloudMdmFreeIPService extends
		SynchronizeDataService<CloudMdmIP, CloudMdmIPVo> implements
		CloudMdmFreeIPServiceI {

	@Override
	public List<FreeuserIpaddressByZoneid> getFreeIpAddressByZoneid(String zoneid)
			throws ValidatorException, CloudException{
		
		ProviderContext context = new ProviderContext();
		FreeipaddressRepository service = new FreeipaddressRepository(context);

		CSQuqeyContext qc = new CSQuqeyContext(new Param("zoneid", zoneid));
		List<FreeuserIpaddressByZoneid> list = service.list(qc);

		return list;
	}

	public static void main(String[] args) {
		CloudMdmFreeIPService service = new CloudMdmFreeIPService();
		try {
			List<FreeuserIpaddressByZoneid> list =
					service.getFreeIpAddressByZoneid("3ef3de47-f066-4a42-b47c-628059e17a64");
			System.err.print(list.size());
			
		} catch (CloudException e) {
			e.printStackTrace();
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
	}
}
