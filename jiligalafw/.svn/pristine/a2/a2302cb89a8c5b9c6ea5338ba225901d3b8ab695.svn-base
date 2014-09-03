package sy.service.product;

import java.util.List;

import sy.common.util.cloudstack.CloudBean;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmNicVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudMdmNicServiceI extends BasicServiceI<CloudMdmNicVo>,
		SynchronizeDataServiceI {

	void sync(List<CloudMdmNicVo> vos) throws ValidatorException;

	public <T extends CloudBean> CloudMdmNicVo createVo(T bean);
}
