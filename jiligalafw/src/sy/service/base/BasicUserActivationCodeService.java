package sy.service.base;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import sy.common.util.move.Mover;
import sy.domain.model.base.BasicUserActivationCode;
import sy.domain.vo.base.BasicUserActivationCodeVo;
import sy.service.shared.BaseServiceTemplate;
@Service("basicUserActivationCodeService")
public class BasicUserActivationCodeService  extends BaseServiceTemplate<BasicUserActivationCode,BasicUserActivationCodeVo> implements
	BasicUserActivationCodeServiceI {

	@Override
	public BasicUserActivationCodeVo getUserActivationBykey(
			String activationCode) throws Exception {
		// TODO Auto-generated method stub
		BasicUserActivationCodeVo basicUserActivationCodeVo = null;
		BasicUserActivationCode basicUserActivationCode = null;
		if(StringUtils.isNotBlank(activationCode)){
			basicUserActivationCode =(BasicUserActivationCode) createQuery("from BasicUserActivationCode where state=1 and activationCode=?", activationCode).uniqueResult();
			if(null != basicUserActivationCode){
				basicUserActivationCodeVo = Mover.getInstance().move(basicUserActivationCode,new BasicUserActivationCodeVo());
			}
		}
		return basicUserActivationCodeVo;
	}

	

}
