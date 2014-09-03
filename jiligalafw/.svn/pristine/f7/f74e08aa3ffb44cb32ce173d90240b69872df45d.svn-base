package sy.service.shared;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lidongbo
 *
 */
public class ContainerStartupListener implements InitializingBean{

	private static final Logger log = Logger
			.getLogger(ContainerStartupListener.class);
	
	@Autowired
	private SynchronizeDataProcessor synchronizeDataProcessor;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		//启动后同步接口数据
		try {
			synchronizeDataProcessor.syncData();
		} catch (Exception e) {
			log.error("同步接口数据时发生错误:"+e.getMessage(), e);
		}
		//更新同步无效订单
		try {
			synchronizeDataProcessor.syncUpdateOrder();
		} catch (Exception e) {
			log.error("同步接口数据时发生错误:"+e.getMessage(), e);
		}
		
		//检查是否存在订单存在但虚拟机不存在,不会发生,除非是保存订单时存在逻辑BUG！
	}

	public SynchronizeDataProcessor getSynchronizeDataProcessor() {
		return synchronizeDataProcessor;
	}

	public void setSynchronizeDataProcessor(
			SynchronizeDataProcessor synchronizeDataProcessor) {
		this.synchronizeDataProcessor = synchronizeDataProcessor;
	}
}
