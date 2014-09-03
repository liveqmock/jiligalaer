package sy.service.product;

import java.util.Date;
import java.util.List;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.service.shared.BasicServiceI;

/**
 * 产品主数据 - 虚拟机
 * 
 * @author luobin
 * 
 */
public interface CloudMdmVMServiceI extends BasicServiceI<CloudMdmVmVo>,
		SynchronizeDataServiceI {

	/**创建*/
	public CloudMdmVmVo create(String accountName, String zoneid, String serviceofferingid,
			String diskofferingid,
			String templateid, List<String> networkOrSecuritygroupIds, String name,Integer disksize,Date stoptime)
			throws ValidatorException,CloudException;
	
	
	/**启动*/
	public void startup(String virtualmachineid) throws ValidatorException,CloudException;
	
	/**停止*/
	public void stop(String virtualmachineid,Boolean forced) throws ValidatorException,CloudException;
	
	/**重启*/
	public void reboot(String virtualmachineid) throws ValidatorException,CloudException;
	
	/**销毁*/
	public void destroy(String virtualmachineid) throws ValidatorException,CloudException;
	
	/**重置虚拟机 */
	public void restore(String virtualmachineid) throws ValidatorException,CloudException;
	
	/**重置密码 */
	public void resetPassword(String virtualmachineid) throws ValidatorException,CloudException;
	
	/**
	 * 我的资源-我的虚拟机-详细信息
	 * @param vmId
	 * @param context
	 * @return
	 * @throws ValidatorException
	 */
	public CloudMdmVmVo getVmById(String vmId) throws ValidatorException;
	
	public CloudMdmVmVo getVmByInterfaceId(String interfaceId) throws ValidatorException;
	
	/**调整计算方案.*/
	public void changeService(String virtualmachineid,String serviceofferingid) throws ValidatorException;
	
	/**添加磁盘方案.*/
	public void addDiskService(String virtualmachineid, String accountName,
			String diskofferingid, Long disksize) throws ValidatorException;

}
