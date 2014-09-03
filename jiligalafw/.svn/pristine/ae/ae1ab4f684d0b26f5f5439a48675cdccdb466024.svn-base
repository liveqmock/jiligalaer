package sy.controller.base;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.BaseConfigurator;
import sy.common.util.DateUtil;
import sy.common.util.StringUtils;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.domain.vo.product.CloudOrderApprovalVo;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.service.core.MailServiceI;
import sy.service.product.CloudMdmVMServiceI;
import sy.service.product.CloudOrderAppprovalServiceI;
import sy.service.product.CloudUserOrderItemServiceI;
import sy.service.product.CloudUserOrderServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 资源审批（账户审批用户购买的资源是否可用）
 * @author luobin
 * 
 */
@Controller
@RequestMapping("/resourcesApproval")
@SessionAttributes("cloudOrderApprovalVo")
public class resourcesApprovalController extends BaseControllerTemplate<CloudOrderApprovalVo> {

	
	
	protected void initContextParams(HttpServletRequest request,
			QueryContext context) {
		
	}
	
	/**
	 * 查询用户审批信息
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		
		QueryContext context = new ECContext(request,modelMap,getNameSpace());
		String startDate = request.getParameter("dateS");
		String endDate = request.getParameter("dateE");
		//context.clearParmeters();
		initContextParams(request, context);
		
		String queryType = request.getParameter("queryType");
		
		context.put("$eq_approvalFlag", null);
		context.put("$in_approvalFlag", null);
		context.put("$le_created", null);
		context.put("$ge_created", null);
		
		if ("0".equals(queryType) || "1".equals(queryType)) {
			if ("0".equals(queryType)) {
				// 1:今日    2:本周     3:上周    4: 本月     5:上月     6:其它
				String timeFlag = request.getParameter("timeFlag");
				if ("1".equals(timeFlag)){
					context.put("$le_created", DateUtil.getTodayDate());
					context.put("$ge_created", DateUtil.getTodayDate());
					
				} else if ("2".equals(timeFlag)){
					context.put("$ge_created", DateUtil.getFirstDayOfCurrWeek());
					context.put("$le_created", DateUtil.getLastDayOfCurrWeek());
					
				} else if ("3".equals(timeFlag)){
					context.put("$ge_created", DateUtil.getFirstDayOfLastWeek());
					context.put("$le_created", DateUtil.getLastDayOfLastWeek());
					
				} else if ("4".equals(timeFlag)){
					context.put("$ge_created", DateUtil.getMonthFirstDay(null));
					context.put("$le_created", DateUtil.getMonthLastDay(null));
					
				} else if ("5".equals(timeFlag)){
					context.put("$ge_created", DateUtil.getFirstDayOfLastMonth());
					context.put("$le_created", DateUtil.getLastDayOfLastMonth());
					
				} else if ("6".equals(timeFlag)){
					context.put("$le_created", DateUtil.getFirstDayOfLastMonth());
				}
			} else if ("1".equals(queryType)) {
				//审批状态
				String stateFlag = request.getParameter("stateFlag");
				context.put("$eq_approvalFlag", stateFlag);
			}  
		} else {
			try{
				
				if (startDate != null && startDate.length()>0){
					context.put("$ge_created", startDate);
				}
				if (endDate != null && endDate.length()>0){
					context.put("$le_created", endDate);
				}
				
				
				String[] stateArr = request.getParameterValues("state");
				String stateStr = "";
				if(stateArr != null && stateArr.length > 0){
					for(int i=0; i<stateArr.length; i++){
						stateStr += stateArr[i] + ",";
					}
					context.put("$in_approvalFlag", stateStr.substring(0, stateStr.length()-1));
					request.setAttribute("stateStr", stateStr.substring(0, stateStr.length()-1));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//用户创建的|account_id(也就是当前账户ID) 不等于 user_id
		context.put("$ne_basicUser.userId", this.getCurrentUser(request).getUserId());
		
		//当前账户下的用户创建的|acctount_id 等于当前账户
		context.put("$eq_basicAccount.userId", this.getCurrentUser(request).getUserId());
		
		List<CloudOrderApprovalVo> list = getService().list(context);
		afterQueryList(request, list, context, modelMap);
		request.setAttribute("queryType", queryType);
		request.setAttribute("dateS", startDate);
		request.setAttribute("dateE", endDate);
		
		return getViewPath() + "/resourcesApprovalList";
	}

	/**
	 * 审批通过
	 * @param userId
	 * @param request
	 * @param vo
	 * @param modelMap
	 * @param errors
	 * @return
	 * @throws ValidatorException
	 */

	@RequestMapping(method = RequestMethod.POST, value = "approval")
	public String approval(HttpServletRequest request, HttpServletResponse response,
			BasicUserVo vo, ModelMap modelMap, BindingResult errors) throws ValidatorException {
		
		String approvalState = request.getParameter("approvalState");
		String id = request.getParameter("id");
		String rejectRemark = request.getParameter("rejectRemark");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter wr = null;
		String exceptionMsg = null;
		StringBuilder successMsg= new StringBuilder();
		CloudOrderApprovalVo orderApproval = null;
		try {
			wr = response.getWriter();
			orderApproval = this.cloudOrderAppprovalService.getCloudOrderApproById(id);
			orderApproval.setApprovalRemark(rejectRemark);
			//审批通过
			if(approvalState.equals("1")){
				
				List<String> lstNetIds =new ArrayList<String>();
				if (null != orderApproval.getNetIds()) {
					String[] netIdsArr = orderApproval.getNetIds().split(",");
					for(String str : netIdsArr) {
						lstNetIds.add(str);
					}
				}
				
				CloudMdmVmVo vm = this.cloudMdmVMService.create(orderApproval.getBasicAccount().getUserAccount()
							, orderApproval.getCloudMdmZone().getInterfaceId()
							, orderApproval.getCloudCpuSoln().getInterfaceId()
							, orderApproval.getCloudMdmDiskSoln()!=null ? orderApproval.getCloudMdmDiskSoln().getInterfaceId() : null
							, orderApproval.getCloudMdmTemplate().getInterfaceId()
							, lstNetIds
							, orderApproval.getVmName()
							, orderApproval.getDiskSize() != null ? orderApproval.getDiskSize().intValue() : null
							, orderApproval.getStopTime());
				
				if ( null != vm) {
					//successMsg .append("虚拟机创建成功！");
					
					orderApproval.setApprovalFlag("1");
					orderApproval.setUpdated(new Date());
					orderApproval.setUpdatedBy(this.getCurrentUser(request).getUserName());
					this.cloudOrderAppprovalService.save(orderApproval);
					//successMsg .append(",审批成功！");
					
					CloudUserOrderVo userOrder = orderApproval.getCloudUserOrder();
					userOrder.setState("1");
					userOrder.setCloudMdmVm(vm);
					userOrder.setBillingFlag(1);
					userOrder.setBeginBillingTime(DateUtil.getNextHourOfCurrHour());
					userOrder.setNextBillingTime(DateUtil.getNextHourOfCurrHour());
					
					//事务控制：订单状态修改应该移到service中去
					this.cloudUserOrderService.save(userOrder);
					List<CloudUserOrderItemVo> orderItems = this.cloudUserOrderItemService.getOrderItemsByOrderId(userOrder.getOrderId());
					for (CloudUserOrderItemVo item : orderItems) {
						item.setBillingFlag(1);
						item.setBeginBillingTime(DateUtil.getNextHourOfCurrHour());
						item.setNextBillingTime(DateUtil.getNextHourOfCurrHour());
						this.cloudUserOrderItemService.save(item);
					}
					
					successMsg.append("审批通过，虚拟机创建成功。");
					
					mailService.sendMail(
							orderApproval.getBasicUser().getUserAccount(),
							"",
							BaseConfigurator.getInstance().getCompanyName() + " 资源审批通过",
							getApprovalPassMailContent(orderApproval));
				}
			} else {
				//拒绝
				orderApproval.setApprovalFlag("2");
				orderApproval.setUpdated(new Date());
				orderApproval.setUpdatedBy(this.getCurrentUser(request).getUserName());
				this.cloudOrderAppprovalService.save(orderApproval);
				successMsg.append("操作成功，该申请已拒绝！");
				
				mailService.sendMail(
						orderApproval.getBasicUser().getUserAccount(),
						"",
						BaseConfigurator.getInstance().getCompanyName() + " 资源审批拒绝",
						getApprovalRejectPassMailContent(orderApproval));
			}
			
			
			if (StringUtils.isNotEmpty(successMsg.toString())) {
				wr.write(successMsg.toString());
				return null;
			}
		} catch (Exception e) {
			exceptionMsg = e.getMessage();
		} finally {
			if (wr != null) {
				if (StringUtils.isNotEmpty(exceptionMsg)) {
					//审批失败保存
					orderApproval.setApprovalFlag("3");
					this.cloudOrderAppprovalService.save(orderApproval);
					
					try {
						mailService.sendMail(
								orderApproval.getBasicUser().getUserAccount(),
								"",
								BaseConfigurator.getInstance().getCompanyName() + " 资源审批失败",
								getApprovalFailMailContent(orderApproval, exceptionMsg));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(approvalState.equals("1")){
						wr.write(successMsg.toString() + " 审批操作出错：" + exceptionMsg);
					} else {
						wr.write(successMsg.toString() + " 拒绝操作出错：" + exceptionMsg);
					}
					
				}
				wr.flush();
				wr.close();
			}
		}
		
		return null;
		
	}
	
	private String getApprovalPassMailContent(CloudOrderApprovalVo orderApproval) {
		String content = "亲爱的：" + orderApproval.getBasicUser().getUserName() 
				+ "<br>您好！您创建虚拟机的申请已通过审批，虚拟机已创建成功，主机名："
				+ orderApproval.getVmName()
				+ "<br> 审批意见：" + orderApproval.getApprovalRemark()
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}
	
	private String getApprovalRejectPassMailContent(CloudOrderApprovalVo orderApproval) {
		String content = "亲爱的：" + orderApproval.getBasicUser().getUserName() 
				+ "<br>您好！您创建虚拟机的申请已被拒绝，主机名："
				+ orderApproval.getVmName()
				+ "<br> 拒绝原因：" + orderApproval.getApprovalRemark()
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}
	
	private String getApprovalFailMailContent(CloudOrderApprovalVo orderApproval, String error) {
		String content = "亲爱的：" + orderApproval.getBasicUser().getUserName() 
				+ "<br>您好！您申请的虚拟机资源在创建时失败，主机名："
				+ orderApproval.getVmName()
				+ "<br> 失败原因：" + error
				+ "<br>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。";
		return content;
	}

	public CloudOrderAppprovalServiceI getCloudOrderAppprovalService() {
		return cloudOrderAppprovalService;
	}


	public void setCloudOrderAppprovalService(
			CloudOrderAppprovalServiceI cloudOrderAppprovalService) {
		this.cloudOrderAppprovalService = cloudOrderAppprovalService;
	}
	
	public void setCloudMdmVMService(CloudMdmVMServiceI cloudMdmVMService) {
		this.cloudMdmVMService = cloudMdmVMService;
	}

	public void setCloudUserOrderService(
			CloudUserOrderServiceI cloudUserOrderService) {
		this.cloudUserOrderService = cloudUserOrderService;
	}

	public void setCloudUserOrderItemService(
			CloudUserOrderItemServiceI cloudUserOrderItemService) {
		this.cloudUserOrderItemService = cloudUserOrderItemService;
	}

	public String getViewPath(){
		return "base";
	}
	
	public MailServiceI getMailService() {
		return mailService;
	}

	public void setMailService(MailServiceI mailService) {
		this.mailService = mailService;
	}
	
	@Override
	public BasicServiceI<CloudOrderApprovalVo> getService() {
		return cloudOrderAppprovalService;
	}
	
	@Autowired
	private CloudOrderAppprovalServiceI cloudOrderAppprovalService;
	
	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	
	@Autowired
	private CloudUserOrderServiceI cloudUserOrderService;
	@Autowired
	private CloudUserOrderItemServiceI cloudUserOrderItemService;
	
	@Autowired
	private MailServiceI mailService;

}
