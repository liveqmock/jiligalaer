package sy.ext.spring;

/**
 * 
 * @author lidongbo
 * 
 */
public class InputQuery extends Input {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084404059755310963L;

	public void setPath(String path) {
		super.setPath(buildPath(path));
		setName(path);
	}

	protected void setPath(String name, String prefix) {
		prefix = new StringBuilder("$").append(prefix).append("_").toString();
		super.setPath(buildPath(name, prefix));
		setName(buildName(name, prefix));
	}

	private String buildName(String name, String prefix) {
		return new StringBuilder(prefix).append(name).toString();
	}

	private String buildPath(String name) {
		return buildPath(name, "");
	}

	private String buildPath(String name, String prefix) {
		return new StringBuilder("params['").append(buildName(name, prefix))
				.append("']").toString();
	}

}
