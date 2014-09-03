package sy.service.cloud;

import org.springframework.stereotype.Service;

import sy.domain.model.cloud.CloudEvent;
import sy.domain.vo.cloud.CloudEventVo;
import sy.service.product.SynchronizeDataService;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudEventService")
public class CloudEventService extends
		SynchronizeDataService<CloudEvent, CloudEventVo> implements
		CloudEventServiceI {

}
