package sy.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserQuotaVo;
import sy.service.base.BasicUserQuotaServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 系统测试用户个数设置、正式、测试用户信用额度设置
 * @author luobin
 *
 */
@Controller
@RequestMapping("/basicUserQuota")
@SessionAttributes("basicUserQuotaVo")
public class BasicUserQuotaController extends BaseControllerTemplate<BasicUserQuotaVo> {

	@Autowired
	private BasicUserQuotaServiceI basicUserQuotaService;
	
	@Override
	public BasicServiceI<BasicUserQuotaVo> getService() {
		return basicUserQuotaService;
	}

	public BasicUserQuotaServiceI getBasicUserQuotaService() {
		return basicUserQuotaService;
	}

	public void setBasicUserQuotaService(
			BasicUserQuotaServiceI basicUserQuotaService) {
		this.basicUserQuotaService = basicUserQuotaService;
	}


	@Override
	public String getViewPath() {
		return "base";
	}

	@Override
	public String edit(HttpServletRequest request, ModelMap modelMap, String id)
			throws ValidatorException {
		id = this.basicUserQuotaService.getUserQuotaInfo().getQuotaId();
		return super.edit(request, modelMap, id);
	}

	@Override
	public String save(HttpServletRequest request, ModelMap modelMap,
			BasicUserQuotaVo vo, BindingResult errors) {
		super.save(request, modelMap, vo, errors);
		errors.rejectValue("errors", null, "设置完成！");
		return getViewPath() + "/basicUserQuotaEdit";
	}
	
	
}
