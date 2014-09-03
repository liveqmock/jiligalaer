package sy.service.finance;

import java.util.List;

import sy.common.util.validator.ValidatorException;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountPayVo;
import sy.service.shared.BasicServiceI;

/**
 * 财务管理 - 账户充值（线下）
 * @author luobin
 *
 */
public interface AccountPayServiceI extends BasicServiceI<AccountPayVo> {

	/**
	 * 保存账户充值信息，修改账户费用总表金额
	 * @param payVo
	 * @param expVo
	 * @throws ValidatorException
	 */
	public void savePay(List<AccountPayVo> payList, AccountExpenseVo expVo) throws ValidatorException;
	
}
