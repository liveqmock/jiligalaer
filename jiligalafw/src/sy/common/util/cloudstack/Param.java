package sy.common.util.cloudstack;

/**
 * 
 * @author lidongbo
 * 
 */
public class Param implements Comparable<Param> {
	private String key = null;
	private String value = null;

	public Param(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public Param(String key, Number value) {
		this.key = key;
		if (value != null) {
			this.value = value.toString();
		}
	}
	
	public Param(String key, Object value) {
		this.key = key;
		if (value != null) {
			this.value = value.toString();
		}
	}

	public int compareTo(Param other) {
		if (other == null) {
			return 1;
		} else if (other == this) {
			return 0;
		} else {
			return getKey().toLowerCase().compareTo(
					other.getKey().toLowerCase());
		}
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public String toString(){
		return "&"+key+"="+value;
	}
}
