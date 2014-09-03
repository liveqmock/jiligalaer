package sy.domain.en.product;


/**
 * 
 * @author luobin
 * 
 */
public enum ProdType {

	ZONE("数据中心"),
	CPU_SOLN("计算方案"), 
	DISK_SOLN("磁盘方案"), 
	TEMPLATE("模板"),
	NETWORK_SOLN("网络方案"), 
	KBPS("带宽"), 
	IP_ADDR("IP"), 
	COMP_PROD("组合产品");

	private final String name;

	private ProdType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static final ProdType prodType[] = { 
		ZONE,CPU_SOLN, DISK_SOLN, TEMPLATE, NETWORK_SOLN, KBPS, IP_ADDR, COMP_PROD };
	
	
}
