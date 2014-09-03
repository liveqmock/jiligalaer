package sy.service.cloud;

import org.springframework.stereotype.Service;

import sy.domain.model.cloud.CloudSystemCapacity;
import sy.domain.vo.cloud.CloudSystemCapacityVo;
import sy.service.product.SynchronizeDataService;

/**
 * 空闲IP列表
 * @author luobin
 * 
 */
@Service("cloudSystemCapacityService")
public class CloudSystemCapacityService extends
		SynchronizeDataService<CloudSystemCapacity, CloudSystemCapacityVo> implements CloudSystemCapacityServiceI {
	
	public void delAllSystemCapacity(){
		this.update("delete CloudSystemCapacity");
	}
}
