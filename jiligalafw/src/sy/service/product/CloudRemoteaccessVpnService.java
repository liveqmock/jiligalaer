package sy.service.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CSQuqeyContext;
import sy.common.util.cloudstack.CloudBean;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.PublicipaddressRepository;
import sy.common.util.cloudstack.RemoteaccessVpnRepository;
import sy.common.util.cloudstack.entity.Publicipaddress;
import sy.common.util.cloudstack.entity.RemoteaccessVpn;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudRemoteaccessVpn;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudRemoteaccessVpnVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudRemoteaccessVpnService")
public class CloudRemoteaccessVpnService extends
		SynchronizeDataService<CloudRemoteaccessVpn, CloudRemoteaccessVpnVo>
		implements CloudRemoteaccessVpnServiceI {

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;
	
	public <T extends CloudBean> List<CloudRemoteaccessVpnVo> getDatesFromInterface(Param ... params) throws ValidatorException {

		List<CloudRemoteaccessVpnVo> result = new ArrayList<CloudRemoteaccessVpnVo>();

		ProviderContext context = new ProviderContext();
		
		PublicipaddressRepository ipRepo = new PublicipaddressRepository(context);
		List<Publicipaddress> ips = ipRepo.list(new CSQuqeyContext(new Param("listall", "true")));
		for (Publicipaddress ip : ips) {
			CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"),new Param("publicipid",ip.getId()));

			RemoteaccessVpnRepository repository = new RemoteaccessVpnRepository(context);

			List<RemoteaccessVpn> cloudBeans = repository.list(qc);
			
			for (RemoteaccessVpn cloudBean : cloudBeans) {
				result.add(createVo(cloudBean));
			}
		}
		
		return result;

	}
	
	public void create(String accountName,String publicipid) throws ValidatorException,CloudException {

		CloudMdmAccountVo account = cloudMdmAccountService.findAccountByName(accountName);
		if(account == null){
			throw new ValidatorException("接口中不存在该账户."+accountName);
		}
		
		ProviderContext context = new ProviderContext();
		RemoteaccessVpnRepository service = new RemoteaccessVpnRepository(context);
		
		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"),new Param("publicipid",publicipid));
		List<RemoteaccessVpn> vpns = service.list(qc);
		if(CollectionUtils.isNotEmpty(vpns)){
			throw new ValidatorException("VPN已开启,不可以重新开启.");
		}
		
		RemoteaccessVpn vpn = new RemoteaccessVpn();
		vpn.setAccount(accountName);
		vpn.setDomainid(account.getDomainid());
		vpn.setPublicipid(publicipid);
		
		RemoteaccessVpn result = service.create(vpn);

		CloudRemoteaccessVpnVo vo = createVo(result);

		save(vo);
	}

	public void delete(String publicipid) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		RemoteaccessVpnRepository service = new RemoteaccessVpnRepository(context);
		service.delete(publicipid);
		update("Update CloudRemoteaccessVpn Set dataState = 0 Where publicipid = ?",
				publicipid);
	}



	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}



	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}

	@Override
	public List<CloudRemoteaccessVpnVo> listByIP(QueryContext context,
			String ipid) throws ValidatorException {
		context.equals("dataState", "1");
		context.equals("publicipid", ipid);
		List<CloudRemoteaccessVpnVo> vpns = super.list(context);
		return vpns;
	}
	
}
