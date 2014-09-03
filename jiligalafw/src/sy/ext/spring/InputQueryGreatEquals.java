package sy.ext.spring;
/**
 *
 * @author lidongbo
 *
 */
public class InputQueryGreatEquals extends InputQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8836541590777926272L;

	public void setPath(String path) {
		super.setPath(path, "ge");
	}
}
