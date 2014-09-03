package sy.service.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.BaseConfigurator;
import sy.common.util.Constants;
import sy.common.util.DateUtil;
import sy.common.util.StringUtils;
import sy.common.util.move.Mover;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudOrderApproval;
import sy.domain.vo.product.CloudMdmNetworkVo;
import sy.domain.vo.product.CloudMdmZoneVo;
import sy.domain.vo.product.CloudOrderApprovalVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.domain.vo.product.CloudSecurityGroupVo;
import sy.service.core.MailServiceI;
import sy.service.shared.BaseServiceTemplate;



/**
 * 用户订单
 * @author cs
 *
 */
@Service("cloudOrderAppprovalService")
public class CloudOrderAppprovalService extends
		BaseServiceTemplate<CloudOrderApproval, CloudOrderApprovalVo> implements
		CloudOrderAppprovalServiceI {
	
	public CloudOrderApprovalVo getCloudOrderApproById(String id) throws Exception {
		CloudOrderApprovalVo cloudOrderApprovalVo = null;
		if (StringUtils.isNotBlank(id)) {
			String hql = "from CloudOrderApproval orderAppro where orderAppro.id='" + id + "'";
			cloudOrderApprovalVo =this.findUnique(hql);
		}
		return cloudOrderApprovalVo;
	}
	
	public void sendVmCreateFinishEmail(CloudOrderApprovalVo orderApprovalVo) {
		StringBuilder vmCreateFinishEmailInfo = new StringBuilder();
		
		//数据中心
		CloudMdmZoneVo cloudMdmZoneVo = orderApprovalVo.getCloudMdmZone();
		//安全组
		CloudSecurityGroupVo CloudSecurityGroupVo = null;
		//网络列表
		List<CloudMdmNetworkVo> mdmNetWorkList = new ArrayList<CloudMdmNetworkVo>();
		if (cloudMdmZoneVo.getNetworkType().equalsIgnoreCase("Basic")) {
			if (StringUtils.isNotBlank(orderApprovalVo.getNetIds())) {
				CloudSecurityGroupVo = this.cloudSecurityGroupService.getSecurityGroupByID(orderApprovalVo.getNetIds());
			}
		} else {
			//网络
			if (StringUtils.isNotBlank(orderApprovalVo.getNetIds())) {
				String netIdArray[] = orderApprovalVo.getNetIds().split(",");
				for (int i = 0 ; i < netIdArray.length; i++){
					if (null != netIdArray[i] && netIdArray[i].trim().length()>0) {
						CloudMdmNetworkVo cloudMdmNetworkVo = this.cloudMdmNetworkService.getMdmNetworkVoByid(netIdArray[i].trim());
						mdmNetWorkList.add(cloudMdmNetworkVo);
					}
				}
			}
		}
		//模板
		CloudProductDetail prodTemplate = orderApprovalVo.getCloudMdmTemplate();
		//计算资源
		CloudProductDetail prodCpu = (CloudProductDetail) orderItemMap.get("cpu");
		//磁盘
		CloudProductDetail prodDisk =  (CloudProductDetail) orderItemMap.get("disk");
		//IP
		CloudProductDetail ip =  (CloudProductDetail) orderItemMap.get("ip");
		
		vmCreateFinishEmailInfo.append("亲爱的：" + orderApprovalVo.getBasicAccount().getUserName() + "，用户：" + orderApprovalVo.getBasicUser().getUserName() + "购买的如下虚机，已创建成功：" );
		vmCreateFinishEmailInfo.append("<br>");
		vmCreateFinishEmailInfo.append("|	项目类别		|	名称		|	描述		|");
		vmCreateFinishEmailInfo.append("<br>");
		vmCreateFinishEmailInfo.append("|	数据中心		|" + cloudMdmZoneVo.getName() + "  " + 	cloudMdmZoneVo.getDisplayText()	+ "|" +cloudMdmZoneVo.getDescription() +"|");
		vmCreateFinishEmailInfo.append("<br>");
		if (cloudMdmZoneVo.getNetworkType().equalsIgnoreCase("Basic")) {
            vmCreateFinishEmailInfo.append("|	安全组		|" + CloudSecurityGroupVo.getName() + "|" + CloudSecurityGroupVo.getDescription() +"|");
            vmCreateFinishEmailInfo.append("<br>");
		} else {
			for (CloudMdmNetworkVo net : mdmNetWorkList) {
				vmCreateFinishEmailInfo.append("|	网络		|" + net.getName() + "|" + net.getDisplaytext() +"|");
				vmCreateFinishEmailInfo.append("<br>");
			}
		}
		vmCreateFinishEmailInfo.append("|	模板		|" + prodTemplate.getProdName() + "|" + prodTemplate.getProdDesc() +"|");
		vmCreateFinishEmailInfo.append("<br>");
		vmCreateFinishEmailInfo.append("|	计算资源		|" + prodCpu.getProdName() + "|" + prodCpu.getProdDesc() +"|");
		vmCreateFinishEmailInfo.append("<br>");
		vmCreateFinishEmailInfo.append("|	磁盘资源		|" + prodDisk.getProdName() + "|" + prodDisk.getProdDesc() +"|");
		vmCreateFinishEmailInfo.append("<br>");
		vmCreateFinishEmailInfo.append("|	主机配置	|" + " 数量：" + custBuyVo.getHostAmount() + " 主机名：" + custBuyVo.getHostName() + "|" );
		
		if (custBuyVo.getProdDisk().getCustomized().equalsIgnoreCase("true")) {
			vmCreateFinishEmailInfo.append(" 自定义磁盘大小：" +  prodDisk.getDiskSize()  );
		}
		
		vmCreateFinishEmailInfo.append(" 停机时间：" +  custBuyVo.getStopHostTime() + "|" );
		
		vmCreateFinishEmailInfo.append("<br><br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。");
		try {
			mailService.sendMail(
					orderApprovalVo.getBasicAccount().getUserAccount(),
					"",
					BaseConfigurator.getInstance().getCompanyName() + " 虚机创建成功！",
					vmCreateFinishEmailInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private MailServiceI mailService;
	@Autowired
	private CloudSecurityGroupServiceI cloudSecurityGroupService;
	
	@Autowired
	private CloudMdmNetworkServiceI cloudMdmNetworkService;
}
