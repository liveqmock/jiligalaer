package sy.service.base;

import org.springframework.stereotype.Service;

import sy.domain.model.base.BasicDict;
import sy.domain.vo.base.BasicDictVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 
 * @author luobin
 * 
 */
@Service("basicDictService")
public class BasicDictService extends
		BaseServiceTemplate<BasicDict, BasicDictVo> implements BasicDictServiceI {

}
