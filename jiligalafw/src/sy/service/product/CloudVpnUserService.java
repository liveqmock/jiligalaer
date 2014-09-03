package sy.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.VpnUserRepository;
import sy.common.util.cloudstack.entity.VpnUser;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudVpnUser;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudVpnUserVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudVpnUserService")
public class CloudVpnUserService extends
		SynchronizeDataService<CloudVpnUser, CloudVpnUserVo> implements
		CloudVpnUserServiceI {

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;

	public void create(String accountName, String username,
			String password) throws ValidatorException, CloudException {

		CloudMdmAccountVo account = cloudMdmAccountService
				.findAccountByName(accountName);
		if (account == null) {
			throw new ValidatorException("接口中不存在该账户." + accountName);
		}

		ProviderContext context = new ProviderContext();
		VpnUserRepository service = new VpnUserRepository(context);

		VpnUser vpn = new VpnUser();
		vpn.setAccount(accountName);
		vpn.setDomainid(account.getDomainid());
		vpn.setUsername(username);
		vpn.setPassword(password);

		VpnUser result = service.create(vpn);

		CloudVpnUserVo vo = createVo(result);

		save(vo);
	}

	public void delete(String accountName, String username)
			throws ValidatorException, CloudException {

		CloudMdmAccountVo account = cloudMdmAccountService
				.findAccountByName(accountName);
		if (account == null) {
			throw new ValidatorException("接口中不存在该账户." + accountName);
		}

		ProviderContext context = new ProviderContext();
		VpnUserRepository service = new VpnUserRepository(context);
		service.delete(username, accountName, account.getDomainid());
		update("Update CloudVpnUser Set dataState = 0 Where username = ? And account = ?",
				username, accountName);
	}

	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}

}
