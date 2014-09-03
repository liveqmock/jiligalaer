package sy.domain.en.base;

/**
 * 提醒类型
 * @author lidongbo
 * 
 */
public enum BasicRemindType {

	NOT_ENOUGH_EXPENSE("费用不足"),
	PRE_STOP("即将停机"), AFTER_STOP("已停机"),
	PRE_DESTROY("即将销毁"), AFTER_DESTROY("已摧毁"), ;

	private final String name;

	private BasicRemindType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
