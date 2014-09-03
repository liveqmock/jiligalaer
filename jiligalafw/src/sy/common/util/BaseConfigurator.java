package sy.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseConfigurator {

	private static final String CONFIG_PATH = "/config/base.properties";
	
	static {
	
	}
	
	private static BaseConfigurator instance;
	private String serverAddress;
	private String companyName;
	private String welcomeContent;
	public static BaseConfigurator getInstance() {
		if (instance == null) {
			instance = new BaseConfigurator();
		}
		return instance;
	}

	private BaseConfigurator() {
		init();
	}
	public void init() {
		Properties props = new Properties();
		InputStream ips = null;
		try {
			ips = BaseConfigurator.class.getResourceAsStream(CONFIG_PATH);
			props.load(ips);
			this.serverAddress = props.getProperty("serverAddress");
			this.companyName = props.getProperty("companyName");
			this.welcomeContent = props.getProperty("welcomeContent");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ips !=null){
				try {
					ips.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWelcomeContent() {
		return welcomeContent;
	}

	public void setWelcomeContent(String welcomeContent) {
		this.welcomeContent = welcomeContent;
	}
	
	
}
