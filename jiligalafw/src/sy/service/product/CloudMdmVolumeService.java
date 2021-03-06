package sy.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.VolumeRepository;
import sy.common.util.cloudstack.entity.Volume;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmVolume;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudMdmVolumeVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudMdmVolumeService")
public class CloudMdmVolumeService extends
		SynchronizeDataService<CloudMdmVolume, CloudMdmVolumeVo> implements
		CloudMdmVolumeServiceI {

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	
	
	public CloudMdmVMServiceI getCloudMdmVMService() {
		return cloudMdmVMService;
	}

	public void setCloudMdmVMService(CloudMdmVMServiceI cloudMdmVMService) {
		this.cloudMdmVMService = cloudMdmVMService;
	}

	/**创建卷.*/
	public CloudMdmVolumeVo create(String name, String zoneid,
			String accountName, String diskofferingid, Long disksize)
			throws ValidatorException, CloudException {

		CloudMdmAccountVo account = cloudMdmAccountService
				.findAccountByName(accountName);
		if (account == null) {
			throw new ValidatorException("接口中不存在该账户." + accountName);
		}
		ProviderContext context = new ProviderContext();
		Volume volume = new Volume();
		volume.setZoneid(zoneid);
		volume.setAccount(accountName);
		volume.setDomainid(account.getDomainid());
		volume.setName(name);
		volume.setDiskofferingid(diskofferingid);
		volume.setSize(disksize);
		VolumeRepository volumRepo = new VolumeRepository(context);
		Volume result = volumRepo.create(volume);

		CloudMdmVolumeVo vo = createVo(result);

		save(vo);
		return vo;
	}
	
	public void delete(String volumeid) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		VolumeRepository service = new VolumeRepository(context);
		service.delete(volumeid);
		update("Update CloudMdmVolume Set dataState = 0 Where interfaceId = ?", volumeid);
	}
	
	public List<CloudMdmVolumeVo> list(QueryContext context) throws ValidatorException{
		List<CloudMdmVolumeVo> list = super.list(context);
		for(CloudMdmVolumeVo vo : list){
			if(vo.getVirtualmachineid() != null){
				vo.setVmname(this.cloudMdmVMService.getVmByInterfaceId(vo.getVirtualmachineid()).getName());
			}
		}
		return list;
	}
	
	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}
}
