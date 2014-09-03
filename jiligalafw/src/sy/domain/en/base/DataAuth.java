package sy.domain.en.base;
/**
 *
 * @author lidongbo
 *
 */
public enum DataAuth {

	UNLIMITED("无限制"),SELF_ONLY("仅自己"),SELF_FOLLOW("自己及以下")
	;
	
	private final String name;
	
	private DataAuth(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
