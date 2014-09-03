package sy.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

import sy.domain.vo.shared.BaseVo;

/**
 *
 * @author lidongbo
 *
 */
public class MainVo  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6615363709143182939L;
	private String navResId;
	
	
	private List<BasicResourceVo> svbResources = new ArrayList<BasicResourceVo>();
	
	private BasicResourceVo resource;

	public boolean isHasSuvNav(){
		return !svbResources.isEmpty();
	}
	

	public List<BasicResourceVo> getSvbResources() {
		return svbResources;
	}

	public void setSvbResources(List<BasicResourceVo> svbResources) {
		this.svbResources = svbResources;
	}
	
	public BasicResourceVo getResource() {
		return resource;
	}


	public void setResource(BasicResourceVo resource) {
		this.resource = resource;
	}


	public String getNavResId() {
		return navResId;
	}


	public void setNavResId(String navResId) {
		this.navResId = navResId;
	}
	
}
