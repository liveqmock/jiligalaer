package sy.controller.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.base.NoticeMessagesVo;
import sy.service.base.NoticeMessagesServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 系统公告信息
 * @author luobin
 *
 */

@Controller
@RequestMapping("/noticeMessages")
@SessionAttributes("noticeMessagesVo")
public class NoticeMessagesController extends BaseControllerTemplate<NoticeMessagesVo> {

	@Autowired
	private NoticeMessagesServiceI noticeMessagesService;
	
	@Override
	public BasicServiceI<NoticeMessagesVo> getService() {
		return noticeMessagesService;
	}

	public NoticeMessagesServiceI getNoticeMessagesService() {
		return noticeMessagesService;
	}

	public void setNoticeMessagesService(NoticeMessagesServiceI noticeMessagesService) {
		this.noticeMessagesService = noticeMessagesService;
	}



	protected void initContextParams(HttpServletRequest request, QueryContext context) {
		context.setSort(" updated desc ");
		BasicUserVo vo = this.getCurrentUser(request);
		request.setAttribute("userFlag", vo.getUserFlag());
	}
	

	
	@Override
	public String list(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		BasicUserVo vo = this.getCurrentUser(request);
		request.setAttribute("userFlag", vo.getUserFlag());
		
		QueryContext context = new ECContext(request, modelMap, getNameSpace());
		//清理上一次查询参数
		context.clearParmeters();
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		
		if("0".equals(queryType)){
			// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
			String timeFlag = request.getParameter("timeFlag");
			if ("1".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getTodayDate());
				context.put("$le_created", DateUtil.getTodayDate());
				
			} else if ("2".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfCurrWeek());
				context.put("$le_created", DateUtil.getLastDayOfCurrWeek());
				
			} else if ("3".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfLastWeek());
				context.put("$le_created", DateUtil.getLastDayOfLastWeek());
				
			} else if ("4".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getMonthFirstDay(null));
				context.put("$le_created", DateUtil.getMonthLastDay(null));
				
			} else if ("5".equals(timeFlag)){
				context.put("$ge_created", DateUtil.getFirstDayOfLastMonth());
				context.put("$le_created", DateUtil.getLastDayOfLastMonth());
				
			} else if ("6".equals(timeFlag)){
				context.put("$lt_created", DateUtil.getFirstDayOfLastMonth());
			}	
			
		}else{//高级搜索
			String dateS = request.getParameter("dateS");
			String dateE = request.getParameter("dateE");
			String content = request.getParameter("content");
			context.put("$ge_created", dateS);
			context.put("$le_created", dateE);
			context.put("$lk_content", content);
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			request.setAttribute("content", content);
			
		}

		List<?> list = getService().list(context);
		context.initTotalRows(modelMap);
		modelMap.put("list", list);
		
		return getViewPath() + "/noticeMessagesList";
	}

	@Override
	public String getViewPath() {
		return "base";
	}
	
	public String getSavedView() {
		return "/noticeMessages/list.do";
	}
}
