package sy.service.product;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.NetworkRepository;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.Network;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmNetwork;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudMdmNetworkVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudMdmNetworkService")
public class CloudMdmNetworkService extends
		SynchronizeDataService<CloudMdmNetwork, CloudMdmNetworkVo>
		implements CloudMdmNetworkServiceI {

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;
	

	public CloudMdmNetworkVo create(String accountName, String zoneid,
			String networkofferingid, String networkName,
			String networkDisplaytext) throws ValidatorException,CloudException {

		CloudMdmAccountVo account = cloudMdmAccountService.findAccountByName(accountName);
		if(account == null){
			throw new ValidatorException("接口中不存在该账户."+accountName);
		}
		ProviderContext context = new ProviderContext();
		NetworkRepository service = new NetworkRepository(context);

		Network obj = new Network();
		obj.setDomainid(account.getDomainid());
		obj.setAccount(accountName);
		obj.setName(networkName);
		obj.setDisplaytext(networkDisplaytext);
		
		obj.setZoneid(zoneid);
		obj.setNetworkofferingid(networkofferingid);
		
		Network result = service.create(obj);
		
		CloudMdmNetworkVo vo = createVo(result);

		save(vo);
		
		return vo;
	}

	@Override
	public void delete(String networkid) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		NetworkRepository service = new NetworkRepository(context);
		service.delete(networkid);
		update("Update CloudMdmNetwork Set dataState = 0 Where interfaceId = ?", networkid);
	}
	
	@Override
	public List<CloudMdmNetworkVo> getNetworkByZoneAccount(String zoneId, String account)
			throws Exception {
		// TODO Auto-generated method stub
		List<CloudMdmNetworkVo> networkList = null;
		try {
			networkList = this.find(
					"from CloudMdmNetwork where dataState=1 and zoneid=? and account=? ", new Object[]{zoneId,account});
		} catch (Exception e) {
			throw new Exception("获取网络列表出错：" + e.getMessage());
		}
		return networkList;
	}
	
	@Override
	public CloudMdmNetworkVo getMdmNetworkVoByid(String id) {
		return findUnique("From CloudMdmNetwork Where  id = ?", id);
	}
	

	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}
	@Override
	public CloudMdmNetworkVo getBasicNetByZone(String zone) throws Exception {
		// TODO Auto-generated method stub
		String sql ="select cmn.ID AS id ,cmn.name as name,cmn.displayText as displayText,cmn.zoneid as zoneId "
					+"from cloud_mdm_network cmn "
					+"inner join cloud_mdm_zone  cmz on cmz.IF_ID = cmn.ZONEID "
					+" where cmz.network_Type='Basic' and cmz.ID='"+zone+"'";
		System.out.println(sql);
		return this.findUniqueBySql(sql);
		
	}

	@Override
	public List<CloudMdmNetworkVo> getUserNetWorksByZoneAccount(
			String userAccount,String zoneId) throws Exception {
		// TODO Auto-generated method stub
		String hql="select distinct  cuo.cloudMdmNetwork  from CloudUserOrder cuo where cuo.state=1 and cuo.cloudMdmNetwork.dataState=1 " +
				" and cuo.basicAccount.userAccount='"+userAccount+"' and  cuo.cloudMdmNetwork.zoneid='"+zoneId+"'" ;
		return this.find(CloudMdmNetworkVo.class,hql);
	}
	
	
	public boolean checkNetworkNameIsExist(String networkName, String accountId){
		StringBuilder sql = new StringBuilder();
		sql.append("select COUNT(1) ");
		sql.append("from CLOUD_MDM_NETWORK ");
		sql.append("where DATA_STATE='1' and account='" + accountId +"' and name='"+networkName+"' ");
		List<?> list = super.getBaseDao().findBySQL(sql.toString());
		 
		int num =((BigInteger)list.get(0)).intValue();
		
		if (num > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
}
