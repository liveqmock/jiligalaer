package sy.common.util.spring;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
 * @author lidongbo
 * 2010-11-30
 */
public class BeansHolder implements ApplicationContextAware,BeanPostProcessor{
	
	private static ApplicationContext _application ;
	/**
	 * 从Ioc容器获得对象
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		if (_application == null)
			return null;
		return _application.getBean(beanName);
	}

	public static BeanFactory getBeanFactory() {
		return _application;
	}
	
	public static ApplicationContext getApplicationContext() {
		return _application;
	}
	
	public synchronized void  setApplicationContext(ApplicationContext application)
			throws BeansException {
		_application = application;
	}
	
	public Object postProcessAfterInitialization(Object obj, String arg1)
			throws BeansException {
		return obj;
	}

	public Object postProcessBeforeInitialization(Object obj, String arg1)
			throws BeansException {
		return obj;
	}

}

