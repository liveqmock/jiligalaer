package sy.service.finance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.validator.ValidatorException;
import sy.domain.model.finance.AccountPay;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountPayVo;
import sy.service.expense.AccountExpenseServiceI;
import sy.service.shared.BaseServiceTemplate;

/**
 * 财务管理 - 账户充值（线下）
 * @author luobin
 * 
 */
@Service("accountPayService")
public class AccountPayService extends BaseServiceTemplate<AccountPay, AccountPayVo> implements AccountPayServiceI{

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
	 * 保存账户充值信息，修改账户费用总表金额
	 */
	public void savePay(List<AccountPayVo> payList, AccountExpenseVo expVo) throws ValidatorException{
		for(AccountPayVo vo : payList){
			this.save(vo);
		}
		this.accountExpenseService.save(expVo);
	}
	
}
