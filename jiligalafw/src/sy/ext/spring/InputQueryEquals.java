package sy.ext.spring;
/**
 *
 * @author lidongbo
 *
 */
public class InputQueryEquals extends InputQuery {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4315281758989815385L;

	public void setPath(String path) {
		super.setPath(path, "eq");
	}
	
}
