package sy.common.util.cloudstack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lidongbo
 * 
 */
public class CSQuqeyContext {

	private List<Param> parameters = new ArrayList<Param>();

	public CSQuqeyContext(Param... params) {
		if (params != null) {
			for (Param param : params) {
				parameters.add(param);
			}
		}
	}
	
	public void setPageNo(int pageNo) {
		parameters.add(new Param("page",pageNo));
	}

	public void setPageSize(int pageSize) {
		parameters.add(new Param("pagesize",pageSize));
	}
	
	public void addParameter(Param param) {
		parameters.add(param);
	}

	public List<Param> getParameters() {
		return parameters;
	}
	
	public Param[] getParametersAsArray() {
		return parameters.toArray(new Param[]{});
	}
	
	public Param getFirst(String key){
		for (Param param : parameters) {
			if(param.getKey().equals(key)){
				return param;
			}
		}
		return null;
	}
	
}
