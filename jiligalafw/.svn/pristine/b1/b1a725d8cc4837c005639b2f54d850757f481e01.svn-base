package sy.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicRemindVo;
import sy.service.base.BasicRemindServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 提醒
 * @author lidongbo
 *
 */
@Controller
@RequestMapping("/reminder")
@SessionAttributes("basicRemindVo")
public class BasicRemindController extends BaseControllerTemplate<BasicRemindVo> {

	@Autowired
	private BasicRemindServiceI basicRemindService;
	
	@Override
	public BasicServiceI<BasicRemindVo> getService() {
		return basicRemindService;
	}

	@Override
	public String getViewPath() {
		return "base";
	}

	public BasicRemindServiceI getBasicRemindService() {
		return basicRemindService;
	}

	public void setBasicRemindService(BasicRemindServiceI basicRemindService) {
		this.basicRemindService = basicRemindService;
	}
	
}
