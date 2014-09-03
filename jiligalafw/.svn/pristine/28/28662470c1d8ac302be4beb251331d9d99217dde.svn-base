package sy.service.expense;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 
 * @author luobin
 * 
 */
public class RecommendRebateCalJob {

	private static final Logger log = Logger.getLogger(RecommendRebateCalJob.class);
	
	@Autowired
	private AccountExpenseServiceI accountExpenseService;

	public void execute() {
		log.info("推荐返利任务执行[开始].");
		this.accountExpenseService.recommendRebateCal();
		log.info("推荐返利任务执行[结束].");
	}

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}

}
