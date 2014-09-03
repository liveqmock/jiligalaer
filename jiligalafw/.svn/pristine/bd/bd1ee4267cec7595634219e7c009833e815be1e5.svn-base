package sy.ext.spring;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import sy.controller.base.BasicHelper;
import sy.domain.vo.shared.BaseVo;

/**
 * 
 * @author lidongbo
 * 
 */
public class WebDataInitBinder extends ConfigurableWebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		super.initBinder(binder, request);
		if (binder.getTarget() instanceof BaseVo) {
			if (BasicHelper.getCurrentUser(request) != null) {
				((BaseVo) binder.getTarget()).setExecutorName(BasicHelper
						.getCurrentUser(request).getUserName());
				((BaseVo) binder.getTarget()).setExecutorId(BasicHelper
						.getCurrentUser(request).getUserId());
			}
		}
	}

}
