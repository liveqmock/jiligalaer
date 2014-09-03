package sy.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

import sy.domain.vo.shared.BaseVo;

/**
 * 
 * @author lidongbo
 * 
 */
public class HeaderVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2895745540425293131L;

	private String id;

	private List<BasicResourceVo> resources = new ArrayList<BasicResourceVo>();

	public List<BasicResourceVo> getResources() {
		return resources;
	}

	public void setResources(List<BasicResourceVo> resources) {
		this.resources = resources;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}