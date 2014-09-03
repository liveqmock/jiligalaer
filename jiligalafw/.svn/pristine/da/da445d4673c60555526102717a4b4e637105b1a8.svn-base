package sy.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.domain.model.base.NoticeMessages;
import sy.domain.vo.base.NoticeMessagesVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 系统公告信息service实现
 * @author luobin
 * 
 */
@Service("noticeMessagesService")
public class NoticeMessagesService extends BaseServiceTemplate<NoticeMessages, NoticeMessagesVo> implements NoticeMessagesServiceI{


   
	/**
	 * 获取所有的系统公告信息
	 */
	@Override
	public List<NoticeMessagesVo> getAllNoticeMessagesVo() throws Exception {
		return find(NoticeMessagesVo.class, "from NoticeMessages");
	}

	/**
	 * 根据ID获取公告信息
	 */
	@Override
	public NoticeMessagesVo getNoticeMessagesById(String messagesId) throws Exception {
		return this.get(messagesId);
	}
	
	
}
