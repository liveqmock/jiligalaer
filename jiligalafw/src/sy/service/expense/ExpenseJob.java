package sy.service.expense;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author lidongbo
 * 
 */
public class ExpenseJob {

	private static final Logger log = Logger
			.getLogger(ExpenseJob.class);
	
	@Autowired
	private AccountExpenseServiceI accountExpenseService;

	public void execute() {
		log.info("计费任务执行[开始].");
		accountExpenseService.billing();
		log.info("计费任务执行[结束].");
	}

	public AccountExpenseServiceI getAccountExpenseService() {
		return accountExpenseService;
	}

	public void setAccountExpenseService(
			AccountExpenseServiceI accountExpenseService) {
		this.accountExpenseService = accountExpenseService;
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = sdf.parse("2012-01-31");
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		System.out.println(sdf.format(cal.getTime()));

		System.out.println(new Date().compareTo(cal.getTime()));
		System.out.println(cal.getTime().compareTo(new Date()));

	}
}
