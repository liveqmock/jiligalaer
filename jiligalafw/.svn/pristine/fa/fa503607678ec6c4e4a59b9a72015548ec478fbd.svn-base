package sy.service.expense;

import java.util.List;

import sy.domain.vo.expense.AccountExpenseVo;
import sy.service.shared.BasicServiceI;

/**
 * 账户总费用
 * @author luobin
 *
 */
public interface AccountExpenseServiceI extends BasicServiceI<AccountExpenseVo> {
	
	public AccountExpenseVo getExpenseByUserId(String userId);
	
	/**
	 * 控制板：获取账户余额及当月消费金额
	 * @return
	 */
	public List<Object[]> getAccountAllExpense(String userId);
	
	
	void billing();
	
	/**是否处于计费处理过程中*/
	public boolean isBilling(String expenseId);
	
	/**是否处于计费处理过程中*/
	public boolean isBilling();
	
	/** 推荐返利计算 */
	void recommendRebateCal();
	
}
