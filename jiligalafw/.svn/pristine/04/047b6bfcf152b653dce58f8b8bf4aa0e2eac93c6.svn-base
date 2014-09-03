package sy.service.product;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import sy.common.util.move.Mover;
import sy.domain.model.product.CloudMdmProductItem;
import sy.domain.vo.product.CloudMdmProductItemVo;
import sy.domain.vo.product.CloudVmCellDetailVo;
import sy.service.shared.BaseServiceTemplate;


/**
 * 产品子表
 * @author luobin
 *
 */
@Service("cloudMdmProductItemService")
public class CloudMdmProductItemService extends
		BaseServiceTemplate<CloudMdmProductItem, CloudMdmProductItemVo> implements CloudMdmProductItemServiceI {

	/**
	 * 根据产品主表ID获取产品子表信息
	 */
	@Override
	public CloudMdmProductItemVo getprodItemByProdId(String prodId)
			throws Exception {
		// TODO Auto-generated method stub
		CloudMdmProductItemVo cloudMdmProductItemVo = null;
		CloudMdmProductItem cloudMdmProductItem = null;
		if (StringUtils.isNotBlank(prodId)) {
			String hql = "from CloudMdmProductItem pi where pi.mdmProduct.id='" + prodId + "' ";
			cloudMdmProductItem = (CloudMdmProductItem) createQuery(hql).uniqueResult();
			if (null != cloudMdmProductItem) {
				cloudMdmProductItemVo = Mover.getInstance().move(
						cloudMdmProductItem, new CloudMdmProductItemVo());
			}
		}
		return cloudMdmProductItemVo;
	}
	
	@Override
	public CloudMdmProductItemVo getprodItemByProdItemId(String prodItemId) throws Exception {
		CloudMdmProductItemVo cloudMdmProductItemVo = null;
		if (StringUtils.isNotBlank(prodItemId)) {
			String hql = "from CloudMdmProductItem pi where pi.id='" + prodItemId + "' ";
			cloudMdmProductItemVo =this.findUnique(hql);
		}
		return cloudMdmProductItemVo;
	}
	
	@Override
	public CloudMdmProductItemVo getProdByItemId(String itemId) throws Exception{
		CloudMdmProductItemVo cloudMdmProductItemVo = null;
		if (StringUtils.isNotBlank(itemId)) {
			String hql = "from CloudMdmProductItem pi where pi.itemId='" + itemId + "' ";
			cloudMdmProductItemVo =this.findUnique(hql);
//			CloudMdmProductItem cloudMdmProductItem = (CloudMdmProductItem) createQuery(hql).uniqueResult();
//			if (null != cloudMdmProductItem) {
//				cloudMdmProductItemVo = Mover.getInstance().move(cloudMdmProductItem, new CloudMdmProductItemVo());
//			}
		}
		return cloudMdmProductItemVo;
	}
	
	@Override
	public List<Object[]> getNetworkSingleProd(String zoneId){
		String sql="select 	m.ID as PROD_ID, m.PROD_NAME, s.NETWORKRATE, m.description, " +
				"			p.ID as PRICE_ID, p.ONE_TIME_PRICE, p.YEAR_PRICE, p.MONTH_PRICE, " +
				"			p.DAY_PRICE, i.ID as PROD_ITEM_ID, s.IF_ID, p.HOUR_PRICE " +
				"	from 	cloud_product_price p " +
				"			inner join cloud_mdm_product m on p.PROD_ID=m.ID " +
				"			inner join cloud_mdm_product_item i on i.PROD_ID=m.ID and i.ITEM_TYPE='networkSoln' " +
				"			inner join cloud_mdm_network_soln s on s.ID=i.NETWORK_SOLN_ID " +
				"	WHERE 	p.EFFECTIVE_DATE<=now() and p.INVALID_DATE>=now() and s.forvpc='false' "; 
		
		return super.getBaseDao().findBySQL(sql);
	}
	
	@Override
	public List<Object[]> getTemplateSingleProd(String zoneId){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.id,p.prod_name,t.displaytext,t.if_id, p.description ," +
				"	case when pri.price_mode='0' then CONCAT(' 一次性收费:' , pri.one_time_price , ' 元') " +
				"	else CONCAT(pri.year_price,'元/年；',pri.month_price,'元/月；',pri.day_price,'元/天；',pri.hour_price,'元/小时') end price" +" FROM cloud_mdm_product p ");
		sql.append("inner join cloud_mdm_product_item i on i.prod_id=p.id ");
		sql.append("inner join cloud_mdm_template t on t.id=i.item_id ");
		sql.append("inner join cloud_product_price pri on pri.prod_item_id=i.id ");
		sql.append(" where i.item_type='template' and i.state=1 and t.zoneid='" + zoneId + "'");
		sql.append(" and now() between pri.EFFECTIVE_DATE and pri.INVALID_DATE");
		return super.getBaseDao().findBySQL(sql.toString());
	}
	
	@Override
	public List<Object[]> getCpuSolnSingleProd(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.id,p.prod_name,c.displaytext,c.if_id, p.description ," +
				"	case when pri.price_mode='0' then CONCAT(' 一次性收费:' , pri.one_time_price , ' 元') " +
				"	else CONCAT(pri.year_price,'元/年；',pri.month_price,'元/月；',pri.day_price,'元/天；',pri.hour_price,'元/小时') end price" +"  FROM cloud_mdm_product p ");
		sql.append("inner join cloud_mdm_product_item i on i.prod_id=p.id ");
		sql.append("inner join cloud_mdm_cpu_soln c on c.id=i.item_id ");
		sql.append("inner join cloud_product_price pri on pri.prod_item_id=i.id ");
		sql.append("where i.item_type='cpuSoln' and i.state=1 ");
		sql.append(" and now() between pri.EFFECTIVE_DATE and pri.INVALID_DATE");
		return super.getBaseDao().findBySQL(sql.toString());
	}
	
	@Override
	public List<Object[]> getDiskSolnSingleProd(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.id,p.prod_name,disk.displaytext,disk.if_id,disk.iscustomized, p.description ," +
				"	case when pri.price_mode='0' then CONCAT(' 一次性收费:' , pri.one_time_price , ' 元') " +
				"	else CONCAT(pri.year_price,'元/年；',pri.month_price,'元/月；',pri.day_price,'元/天；',pri.hour_price,'元/小时') end price" +"  FROM cloud_mdm_product p ");
		sql.append("inner join cloud_mdm_product_item i on i.prod_id=p.id ");
		sql.append("inner join cloud_mdm_disk_soln disk on disk.id=i.item_id ");
		sql.append("inner join cloud_product_price pri on pri.prod_item_id=i.id ");
		sql.append("where i.item_type='diskSoln' and i.state=1 ");
		sql.append(" and now() between pri.EFFECTIVE_DATE and pri.INVALID_DATE");
		return super.getBaseDao().findBySQL(sql.toString());
	}

	@Override
	public CloudVmCellDetailVo getVmCellDetailByProdId(String prodId)
			throws Exception {
		// TODO Auto-generated method stub
		String sql="select cs.IF_ID as serviceofferingid,"
				+" ds.IF_ID as diskofferingid, "
				+"mt.IF_ID as templateid "
				+"from cloud_mdm_product p "
				+"inner join cloud_mdm_product_item pi on pi.prod_id=p.id "
				+"inner join cloud_mdm_cpu_soln cs on cs.id=pi.CPU_SOLN_ID "
				+"left join cloud_mdm_disk_soln ds on ds.id=pi.DISK_SOLN_ID "
				+"inner join cloud_mdm_template mt on mt.id =pi.TEMPLATE_ID "
				+"where  p.id='"+prodId+"'";

		return this.findUniqueBySql(CloudVmCellDetailVo.class,sql);
	}


	
	
}
