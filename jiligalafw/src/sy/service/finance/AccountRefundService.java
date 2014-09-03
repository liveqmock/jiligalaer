package sy.service.finance;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.validator.ValidatorException;
import sy.domain.model.finance.AccountRefund;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountRefundVo;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.shared.BaseServiceTemplate;

/**
 * 账户申请、处理退款
 * @author luobin
 * 
 */
@Service("accountRefundService")
public class AccountRefundService 
	extends BaseServiceTemplate<AccountRefund, AccountRefundVo> 
		implements AccountRefundServiceI{

	@Autowired
	private AccountExpenseServiceI accountExpenseService;

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}
	
	/**
	 * 处理退款保存
	 */
	public void saveRefund(AccountExpenseVo expVo, AccountRefundVo refundVo) throws ValidatorException{
		if(expVo != null){
			//修改总费用表，验证退款金额是否大于账户余额
			if((expVo.getPayTotalAmount() - expVo.getExpTotalAmount()) > refundVo.getRefundAmount()){
				expVo.setPayTotalAmount(expVo.getPayTotalAmount() - refundVo.getRefundAmount());
			}else{
				throw new ValidatorException("退款失败，退款金额大于账户余额！");
			}
			expVo.setPayUpdated(new Date());
			this.accountExpenseService.save(expVo);
		}
		
		//修改账户退款表
		this.save(refundVo);
		
		
		//退款时需要验证下一次收费是否有钱支付，如果没有则处理虚机
		//--退款属于线下操作，退款人员可以自行查看该账户的余额情况，及虚机、网络、IP资源是否已经释放，确认无误后再退款。
		
		
	}
	
}
