package sy.service.expense;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.expense.AccountExpenseItemVo;
import sy.domain.vo.expense.BillQueryParameterVo;
import sy.service.shared.BasicServiceI;

/**
 * 账户费用明细
 * @author luobin
 *
 */
public interface AccountExpenseItemServiceI extends BasicServiceI<AccountExpenseItemVo> {
	
	public List<Object[]> getAccountExpenseTotalList(BillQueryParameterVo queryParaVo);
	public Double getExpenseAmoutTotal(BillQueryParameterVo queryParaVo);
	
}
