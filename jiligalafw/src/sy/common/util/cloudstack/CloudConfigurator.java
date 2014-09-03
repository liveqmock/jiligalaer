package sy.common.util.cloudstack;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author lidongbo
 * 
 */
public class CloudConfigurator {

	private static final String CONFIG_PATH = "/config/cloudstack.properties";

	private static CloudConfigurator instance;

	private Properties props;
	
	private String url;

	private CloudConfigurator() {
		init();
	}

	private void init() {
		Properties props = new Properties();
		try {

			InputStream ips = CloudConfigurator.class
					.getResourceAsStream(CONFIG_PATH);
			props.load(ips);
			this.url = props.getProperty("server.url");
			ips.close();
		} catch (Exception e) {
			throw new CloudException(e);
		}
	}

	public static CloudConfigurator getInstance() {
		if (instance == null) {
			instance = new CloudConfigurator();
		}
		return instance;
	}

	public String getUrl() {
		return url;
	}
	
	Properties getProperties() {
		return props;
	}

	public static void main(String[] args) {
		System.out.println(CloudConfigurator.getInstance().getUrl());
	}
}
