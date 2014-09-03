package sy.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudUserOrderItem;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.service.shared.BaseServiceTemplate;


/**
 * 用户订单明细
 * @author cs
 *
 */
@Service("cloudUserOrderItemService")
public class CloudUserOrderItemService extends
		BaseServiceTemplate<CloudUserOrderItem, CloudUserOrderItemVo> implements CloudUserOrderItemServiceI {
	
	@Autowired
	private CloudProductPriceServiceI cloudProductPriceService;
	
	
	public CloudProductPriceServiceI getCloudProductPriceService() {
		return cloudProductPriceService;
	}

	public void setCloudProductPriceService(
			CloudProductPriceServiceI cloudProductPriceService) {
		this.cloudProductPriceService = cloudProductPriceService;
	}


	@Override
	public CloudUserOrderItemVo getOrderItemByOrderIdAndProdType(String orderId, String prodType){
		String hql = "from CloudUserOrderItem where cloudUserOrder.orderId='"+orderId+"' and resDestroyTime is null and cloudMdmProductItem.itemType=?";
		return this.findUnique(hql, prodType);
	}
	
	
	public CloudUserOrderItemVo getOrderItemByVmIdAndProdType(String vmId, String prodType){
		//自定义购买：由于更改计算方案会创建新的订单挂在该虚拟机上，如果多次更换计算方案后，会存在多个计算方案的订单，只有一个有效的订单。
		//快速购买：由于更改计算方案会创建新的订单挂在该虚拟机上，原计算方案不用管理（打包的产品），如果多次更换计算方案后，会存在多个计算方案的订单，只有一个有效的订单。
//		String sql = "select 	i.* " +
//				"	from 		cloud_user_order o " +
//				"				inner join cloud_user_order_item i on o.ORDER_ID=i.ORDER_ID " +
//				"	where 		1=1 and o.VM_ID='"+vmId+"' and i.PROD_TYPE='"+prodType+"' and i.RES_DESTROY_TIME is null " +
//				"	order by 	o.ORDER_TIME desc ";
//		
//		return this.findUniqueBySql(sql);
		
		String hql = "from CloudUserOrderItem where cloudUserOrder.cloudMdmVm.id='"+vmId+"' " +
				"and resDestroyTime is null and prodType='"+prodType+"' and state='"+Constants.VALID_STATE+"' " +
				"order by cloudUserOrder.orderTime desc ";
		return this.findUnique(hql);
	}
	
	/**获取可以计费的订单列表,账户、购买人、创建时间进行排序*/
	@Override
	public List<CloudUserOrderItemVo> getStartBillingOrderItems() {
		String hql =
				  " From 	CloudUserOrderItem " 
				+ " Where 	resDestroyTime is null " 	//没有销毁过
				+ " And 	billingFlag = " + Constants.BILLING_FALG_START	//处于开始计费状态
				+ " And 	oneTimeBillingFlag = 0 "  	//未发生过一次性计费
				+ " And 	cloudUserOrder.state=" + Constants.VALID_STATE  //账单处于有效状态
				+ " Order by cloudUserOrder.basicAccount asc,cloudUserOrder.basicUser asc,cloudUserOrder.created asc";
		return find(hql);
	}



	@Override
	public List<CloudUserOrderItemVo> getOrderItemsByOrderId(String orderId) {
		String hql =
				  " From 	CloudUserOrderItem " 
				+ " Where 	cloudUserOrder.orderId='" + orderId + "' and resDestroyTime is null " ;
		return find(hql);
	}
	
	public List<CloudUserOrderItemVo> list(QueryContext context) throws ValidatorException{
		List<CloudUserOrderItemVo> list = super.list(context);
		if(list != null){
			for(CloudUserOrderItemVo vo : list){
				vo.setCloudProductPrice(
					this.cloudProductPriceService.getPriceByProdId(vo.getCloudMdmProduct().getId()));
			}
		}
		
		return list;
	}
	
}
