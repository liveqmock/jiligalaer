package sy.service.shared;

import sy.common.util.validator.ValidatorException;

/**
 *
 * @author lidongbo
 *
 */
public interface SaveCallback<VO,PO> {

	public void presave(VO vo,PO po) throws ValidatorException;
	
	public void postsave(VO vo,PO po) throws ValidatorException;
	
}
