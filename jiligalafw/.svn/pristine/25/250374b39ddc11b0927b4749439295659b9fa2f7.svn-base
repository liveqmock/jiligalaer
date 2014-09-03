package sy.service.base;

import java.util.Date;

import org.springframework.stereotype.Service;

import sy.domain.en.base.BasicRemindType;
import sy.domain.model.base.BasicRemind;
import sy.domain.vo.base.BasicRemindVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 提醒
 * 
 * @author lidongbo
 * 
 */
@Service("basicRemindService")
public class BasicRemindService extends
		BaseServiceTemplate<BasicRemind, BasicRemindVo> implements
		BasicRemindServiceI {

	@Override
	public void createRemind(String accountId, String userId,
			BasicRemindType type, String message, String createdBy) {

		BasicRemind remind = new BasicRemind();
		remind.setAccountId(accountId);
		remind.setUserId(userId);
		remind.setCreated(new Date());
		remind.setCreatedBy(createdBy);
		remind.setMessage(message);
		remind.setType(type);

		getBaseDao().save(remind);
	}

}
