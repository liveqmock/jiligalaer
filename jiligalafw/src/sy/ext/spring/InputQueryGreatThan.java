package sy.ext.spring;
/**
 *
 * @author lidongbo
 *
 */
public class InputQueryGreatThan extends InputQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1740746210533508510L;

	public void setPath(String path) {
		super.setPath(path, "gt");
	}
}
