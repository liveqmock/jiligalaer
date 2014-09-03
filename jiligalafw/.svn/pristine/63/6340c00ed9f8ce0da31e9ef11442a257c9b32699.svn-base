package sy.service.finance;

import sy.common.util.validator.ValidatorException;
import sy.domain.vo.expense.AccountExpenseVo;
import sy.domain.vo.finance.AccountRefundVo;
import sy.service.shared.BasicServiceI;

/**
 * 账户申请、处理退款
 * @author luobin
 *
 */
public interface AccountRefundServiceI extends BasicServiceI<AccountRefundVo> {

	/**
	 * 处理退款保存
	 * @param expVo
	 * @param refundVo
	 * @throws ValidatorException
	 */
	public void saveRefund(AccountExpenseVo expVo, AccountRefundVo refundVo) throws ValidatorException;

}
