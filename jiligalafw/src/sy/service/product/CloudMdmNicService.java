package sy.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmNic;
import sy.domain.vo.product.CloudMdmNicVo;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudMdmNicService")
public class CloudMdmNicService extends
		SynchronizeDataService<CloudMdmNic, CloudMdmNicVo>
		implements CloudMdmNicServiceI {

	public void sync(List<CloudMdmNicVo> vos) throws ValidatorException{
		super.sync(vos);
	}
}
