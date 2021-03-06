package sy.service.product;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.PublicipaddressRepository;
import sy.common.util.cloudstack.entity.Publicipaddress;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmIP;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudMdmIPVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.domain.vo.product.CloudRemoteaccessVpnVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * IP.
 * 
 * @author cs
 * 
 */
@Service("cloudMdmIPService")
public class CloudMdmIPService extends
		SynchronizeDataService<CloudMdmIP, CloudMdmIPVo> implements
		CloudMdmIPServiceI {

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;
	
	@Autowired
	private CloudRemoteaccessVpnServiceI cloudRemoteaccessVpnService;
	/**
	 * 查看网络下的IP列表
	 * @param context
	 * @param networkid
	 * @return
	 * @throws ValidatorException
	 */
	public List<CloudMdmIPVo> listByNetwork(QueryContext context,
			String networkid) throws ValidatorException {
		context.equals("associatednetworkid", networkid);
		context.equals("dataState", "1");
		List<CloudMdmIPVo> result = super.list(context);
		
		context.clearParmeters();
		for (CloudMdmIPVo cloudMdmIPVo : result) {
			List<CloudRemoteaccessVpnVo> vpns = cloudRemoteaccessVpnService.listByIP(context, cloudMdmIPVo.getInterfaceId());
			cloudMdmIPVo.setVpnEnabled(CollectionUtils.isNotEmpty(vpns));
		}
		
		return result;
	}

	@Override
	public CloudMdmIPVo associateIpAddress(String accountName, String networkid)
			throws ValidatorException, CloudException{
		
		CloudMdmAccountVo account = cloudMdmAccountService.findAccountByName(accountName);
		if(account == null){
			throw new ValidatorException("接口中不存在该账户."+accountName);
		}
		
		ProviderContext context = new ProviderContext();
		PublicipaddressRepository service = new PublicipaddressRepository(context);

		Publicipaddress obj = new Publicipaddress();
		obj.setDomainid(account.getDomainid());
		obj.setAccount(accountName);
		obj.setNetworkid(networkid);
		
		Publicipaddress result = service.create(obj);
		
		CloudMdmIPVo vo = createVo(result);

		save(vo);
		
		return vo;
	}

	@Override
	public void disassociateIpAddress(String ipid) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		PublicipaddressRepository service = new PublicipaddressRepository(context);
		service.delete(ipid);
		update("Update CloudMdmIP Set dataState = 0 Where interfaceId = ?", ipid);
	}
	
	@Override
	public void enableStaticNat(String ipaddressid, String virtualmachineid) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		PublicipaddressRepository service = new PublicipaddressRepository(context);
		service.enableStaticNat(ipaddressid, virtualmachineid);
		sync(ipaddressid,context);
	}

	@Override
	public void disableStaticNat(String ipaddressid) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		PublicipaddressRepository service = new PublicipaddressRepository(context);
		service.disableStaticNat(ipaddressid);
		sync(ipaddressid, context);
	}
	
	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}

	public CloudMdmIPVo getIpAddrByInterfaceId(String interfaceId){
		return this.findUnique("from CloudMdmIP Where interfaceId = ?", interfaceId);
	}

	public CloudRemoteaccessVpnServiceI getCloudRemoteaccessVpnService() {
		return cloudRemoteaccessVpnService;
	}

	public void setCloudRemoteaccessVpnService(
			CloudRemoteaccessVpnServiceI cloudRemoteaccessVpnService) {
		this.cloudRemoteaccessVpnService = cloudRemoteaccessVpnService;
	}

	@Override
	public CloudProductDetail getCloudMdmIpProduct() {
		String sql ="SELECT mp.id as prodId,mp.PROD_NAME as prodName,pp.id as priceId,pp.one_time_price as oneTimePrice," +
				"pp.year_price as yearPrice,pp.month_price as monthPrice,pp.day_price as dayPrice, pp.hour_price as hourPrice, " +
				"pp.price_mode as priceMode ,pi.id as prodItemId,'ip_if_id' as interfaceId"
				   +" FROM cloud_mdm_product_item pi "
				   +" inner join cloud_mdm_product mp on mp.ID=pi.PROD_ID "
				   +" inner join cloud_product_price pp on pp.PROD_ID=mp.ID "
				   +"    where pi.item_type='ip' AND pi.state='1'  and now()>=  pp.EFFECTIVE_DATE and now() <=pp.INVALID_DATE and mp.id='ipprice'";
		return this.findUniqueBySql(CloudProductDetail.class,sql);
	}
}
