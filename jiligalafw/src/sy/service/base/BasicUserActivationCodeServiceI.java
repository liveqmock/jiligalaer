package sy.service.base;

import sy.domain.vo.base.BasicUserActivationCodeVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author xhchen
 *
 */
public interface BasicUserActivationCodeServiceI extends BasicServiceI<BasicUserActivationCodeVo> {
	BasicUserActivationCodeVo getUserActivationBykey(String activationCode) throws Exception;
	
}
