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
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.cloud.CloudEventVo;
import sy.service.cloud.CloudEventServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 我的警告
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/warning")
@SessionAttributes("cloudEventVo")
public class WarningController extends BaseControllerTemplate<CloudEventVo> {

	@Autowired
	private CloudEventServiceI cloudEventService;

	public String getViewPath(){
		return "base";
	}

	public CloudEventServiceI getCloudEventService() {
		return cloudEventService;
	}

	public void setCloudEventService(CloudEventServiceI cloudEventService) {
		this.cloudEventService = cloudEventService;
	}


	@Override
	public BasicServiceI<CloudEventVo> getService() {
		return cloudEventService;
	}
	
	protected void initContextParams(HttpServletRequest request,
			QueryContext context) {
		
	}
	
	/**
	 * 获取用户警告信息
	 */
	@RequestMapping(value = "myWarning")
	public String myWarning(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		QueryContext context = new ECContext(request,modelMap,getNameSpace());
	    context.clearParmeters();
	    context.setSort(" created desc ");
	    
		String queryType = request.getParameter("queryType");
		request.setAttribute("queryType", queryType);
		BasicUserVo userVo = this.getCurrentUser(request);
		//当前用户
		if(userVo.getUserFlag() ==  Constants.USER_FLAG_ACCOUNT){
			context.put("$eq_account", userVo.getUserAccount());
		}else if(userVo.getUserFlag() ==  Constants.USER_FLAG_USER){
			context.put("$eq_account", userVo.getParentBasicUser().getUserAccount());
		}
		
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
			context.put("$ge_created", dateS);
			context.put("$le_created", dateE);
			request.setAttribute("dateS", dateS);
			request.setAttribute("dateE", dateE);
			
			String keyword = request.getParameter("keyword");
			context.put("$lk_description", keyword);
			request.setAttribute("keyword", keyword);
		}
	    
	    context.put("$eq_level", Constants.EVENT_LEVEL_INFO);
	    List<?> eventList = this.getService().list(context);
	    
		context.initTotalRows(modelMap);
		modelMap.put("list", eventList);
		
		return getViewPath() + "/myWarningList";
	}


}
