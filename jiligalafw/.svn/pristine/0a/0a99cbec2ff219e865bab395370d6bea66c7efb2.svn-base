package sy.service.shared;

import java.util.Set;

/**
 *
 * @author lidongbo
 *
 */
public interface Hierarchical<T extends Hierarchical<T>> {

	T getParent();
	
	Set<T> getChildren();
	
	String getHierarchyCode();
	
	void setHierarchyCode(String code);
	
	Integer getHierarchyLevel();
	
	void setHierarchyLevel(Integer code);
}
