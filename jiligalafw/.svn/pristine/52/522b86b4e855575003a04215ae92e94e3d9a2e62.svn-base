package sy.controller.shared;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.IllegalClassException;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.StringUtils;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public abstract class BaseControllerTemplate<VO extends BaseVo> extends
		BaseController {

	private static final Logger log = Logger
			.getLogger(BaseControllerTemplate.class);
	
	private final String mappingPath;

	private final String formBeanName;

	public BaseControllerTemplate() {
		RequestMapping rm = getClass().getAnnotation(RequestMapping.class);
		if (rm != null && rm.value() != null && rm.value().length > 0) {
			mappingPath = rm.value()[0];
		} else {
			throw new IllegalClassException(
					"请在Controller中类描述中定义@RequestMapping，且第一个元素不允许为空！");
		}

		SessionAttributes sa = getClass()
				.getAnnotation(SessionAttributes.class);
		if (sa != null && sa.value() != null && sa.value().length > 0) {
			formBeanName = sa.value()[0];
		} else {
			throw new IllegalClassException(
					"请在Controller中类描述中定义@SessionAttributes，且第一个元素不允许为空！");
		}

	}

	public abstract BasicServiceI<VO> getService();

	public abstract String getViewPath();

	public String getListView() {
		return getViewPath() + "/" + mappingPath +"List";
	}

	public String getEditView() {
		return getViewPath() + "/" + mappingPath +"Edit";
	}

	public String getFormBeanName() {
		return formBeanName;
	}

	public String getSuccesedView() {
		return mappingPath + "/list.do";
	}
	
	public String getDeletedView() {
		return getSuccesedView();
	}
	
	public String getSavedView() {
		return getSuccesedView();
	}

	public String getNameSpace() {
		return formBeanName+"List";
	}
	
	public String getCloseView() {
		return mappingPath + "/close.do";
	}
	
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		QueryContext context = new ECContext(request,modelMap,getNameSpace());
		initContextParams(request, context);
		List<VO> list = getService().list(context);
		afterQueryList(request, list, context, modelMap);
		return getListView();
	}

	protected void initContextParams(HttpServletRequest request,
			QueryContext context) {
		
	}
	
	protected void afterQueryList(HttpServletRequest request, List<VO> list,
			QueryContext context, ModelMap modelMap) {
		context.initTotalRows(modelMap);
		modelMap.put("list", list);
	}

	@RequestMapping(value = "edit")
	public String edit(HttpServletRequest request, ModelMap modelMap, String id)
			throws ValidatorException {
		VO obj = getService().get(id);
		prepareEditView(request, modelMap, obj);
		return getEditView();
	}

	protected void prepareEditView(HttpServletRequest request,
			ModelMap modelMap, VO obj) {
		modelMap.put(getFormBeanName(), obj);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(HttpServletRequest request, ModelMap modelMap, @Valid VO vo, BindingResult errors){
		if (errors.hasErrors()) {
			prepareEditView(request, modelMap, vo);
			return getEditView();
		}
		try {
			getService().save(vo);
		} catch (ValidatorException e) {
			String errorKey = "errors";
			if(StringUtils.isNotBlank(e.getErrorKey())){
				errorKey = e.getErrorKey();
			}
			errors.rejectValue(errorKey,null, e.getMessage());
			prepareEditView(request, modelMap, vo);
			return getEditView();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			errors.rejectValue("errors",null, e.getMessage());
			prepareEditView(request, modelMap, vo);
			return getEditView();
		}
		return getRedirectStr(getSavedView());
	}

	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request, ModelMap modelMap,
			String id) throws ValidatorException {
		getService().delete(id);
		return getRedirectStr(getDeletedView());
	}
	
	@RequestMapping(value = "close")
	public String close(HttpServletRequest request, ModelMap modelMap,
			String id) throws ValidatorException {
		return "commons/close";
	}
	
	protected BasicUserVo getCurrentUser(HttpServletRequest request) {
		return (BasicUserVo)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
	}
	
	protected String getCurAccountName(HttpServletRequest request) {
		BasicUserVo user = (BasicUserVo) request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		if (user.getUserFlag()==Constants.USER_FLAG_ACCOUNT 
				|| user.getUserFlag()==Constants.USER_FLAG_ADMIN) {
			return user.getUserAccount();
		} else {
			return user.getParentBasicUser().getUserAccount();
		}
	}

	protected BasicUserVo getCurrentParentUser(HttpServletRequest request) {
		BasicUserVo user = (BasicUserVo) request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		if (user.getUserFlag()==Constants.USER_FLAG_ACCOUNT 
				|| user.getUserFlag()==Constants.USER_FLAG_ADMIN) {
			return user;
		} else {
			return user.getParentBasicUser();
		}
	}
}
