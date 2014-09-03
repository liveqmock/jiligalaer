package sy.common.util.cloudstack;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import sy.common.util.cloudstack.entity.Account;
import sy.common.util.cloudstack.entity.Domain;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author lidongbo
 * 
 */
public class AccountRepository extends AbstractServiceSupport<Account> {

	private static final String CREATE_ACCOUNT = "createAccount";

	private static final String LIST_ACCOUNTS = "listAccounts";

	private static final String UPDATE_ACCOUNT = "updateAccount";

	public AccountRepository(ProviderContext provider) {
		super(provider);
	}

	protected String getCreateCommand() {
		return CREATE_ACCOUNT;
	}

	@Override
	protected String getListCommand() {
		return LIST_ACCOUNTS;
	}

	@Override
	protected String getTagName() {
		return "account";
	}

	public Account create(Account bean) {
		
		DomainRepository service = new DomainRepository(provider);
		
		Domain domain = new Domain();
		domain.setName(bean.getUsername());
		domain = service.create(domain);
		
		bean.setDomainid(domain.getId());
		
		return super.create(bean);
	}
	
	public Account update(String accountid, String newname, String currentname) {
		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("newname", newname);
		parameters.add(param);
		param = new Param("account", currentname);
		parameters.add(param);
		param = new Param("id", accountid);
		parameters.add(param);

		String url = method.buildUrl(UPDATE_ACCOUNT,
				parameters.toArray(new Param[] {}));

		Document doc;
		try {
			doc = method.get(url);

			List<Account> beans = doc2beans(doc, getTagName());
			if (beans != null) {
				return beans.get(0);
			}
			return null;
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public void disable(String interfaceId) {

		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("id", interfaceId);
		parameters.add(param);
		//If true, only lock the account; else disable the account
		param = new Param("lock", "false");
		parameters.add(param);
		
		String url = method.buildUrl("disableAccount",
				parameters.toArray(new Param[] {}));
		try {
			method.get(url);
		} catch (CloudException e) {
			throw e;
		}
	}
	
	public void enable(String interfaceId) {

		RequestMethod method = new RequestMethod(provider);
		List<Param> parameters = new ArrayList<Param>();

		Param param = new Param("id", interfaceId);
		parameters.add(param);
		
		String url = method.buildUrl("enableAccount",
				parameters.toArray(new Param[] {}));
		try {
			method.get(url);
		} catch (CloudException e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		AccountRepository service = new AccountRepository(context);

		Account account = new Account();
		account.setAccounttype("2"); //Specify 0 for user, 1 for root admin, and 2 for domain admin
		account.setEmail("cms_wanger@cms.com");
		account.setFirstname("cms_wanger");
		account.setLastname("cms_wanger");
		account.setPassword("1");
		account.setUsername("dev");
		account.setTimezone("Asia/Shanghai");
		Account accountResult = service.create(account);
		System.out.println(account);
		System.out.println(accountResult);

		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
		List<Account> result = service.list(qc);
		System.out.println(result);
		System.out.println(result.size());

	}

}
