package sy.ext.spring;
/**
 *
 * @author lidongbo
 *
 */
public class InputQueryLessThan extends InputQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1794895041020955003L;

	public void setPath(String path) {
		super.setPath(path, "lt");
	}
}
