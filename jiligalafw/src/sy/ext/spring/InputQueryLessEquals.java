package sy.ext.spring;
/**
 *
 * @author lidongbo
 *
 */
public class InputQueryLessEquals extends InputQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8201289813564112190L;

	public void setPath(String path) {
		super.setPath(path, "le");
	}
}
