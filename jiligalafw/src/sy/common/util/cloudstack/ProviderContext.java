package sy.common.util.cloudstack;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.BooleanUtils;

/**
 * 
 * @author lidongbo
 * 
 */
public class ProviderContext {

	private String accountId;

	public static final String DEFAULT_ENDPOINT = CloudConfigurator
			.getInstance().getUrl();

	private String endpoint;

	private Properties props = new Properties();

	public ProviderContext() {
		this.endpoint = DEFAULT_ENDPOINT;
	}

	public Date parseTime(String timestamp) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); // 2013-07-08T22:00:03+0800

		try {
			return df.parse(timestamp);
		} catch (ParseException e) {
			throw new CloudException(e);
		}
	}

	public Boolean parseBoolean(String bool){
		return BooleanUtils.toBoolean(bool);
	}
	
	public Integer parseInteger(String value) {
		return Integer.parseInt(value);
	}
	
	public Long parseLong(String value) {
		return Long.parseLong(value);
	}

	public ProviderContext(String endpoint) {
		this.endpoint = endpoint;
	}

	public ProviderContext(String accountId, String endpoint) {
		this.accountId = accountId;
		this.endpoint = endpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void putPropertie(String key, Object value) {
		props.put(key, value);
	}

	public Properties getCustomProperties() {
		return props;
	}

	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(context.parseTime("2013-07-08T22:00:03+0800")));

	}
	
}
