package sy.service.base;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.Constants;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.base.BasicRole;
import sy.domain.vo.base.BasicRoleVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("basicRoleService")
public class BasicRoleService extends BaseServiceTemplate<BasicRole, BasicRoleVo> implements BasicRoleServiceI{

	@Autowired
	private BasicRoleResServiceI basicRoleResService;
	
	@Override
	public void presave(BasicRoleVo vo,BasicRole po) throws ValidatorException {

		if(!isUnique(po, "roleName")){
			throw new ValidatorException("roleName","角色名称不允许重复");
		}
		
		if(po.getState() == null){
			po.setState(1);
		}
	}
	
	public void postsave(BasicRoleVo vo,BasicRole po) throws ValidatorException{
		basicRoleResService.save(po.getRoleId(),vo.getResIds());
	}

	public BasicRoleResServiceI getBasicRoleResService() {
		return basicRoleResService;
	}

	public void setBasicRoleResService(BasicRoleResServiceI basicRoleResService) {
		this.basicRoleResService = basicRoleResService;
	}
   
	/**
	 * 获取所有的角色.
	 */
	@Override
	public List<BasicRoleVo> getAllBasicRoleVo() throws Exception {
		return find(BasicRoleVo.class,
				"from BasicRole");
	}

	private void updateState(BasicRoleVo vo, Integer state) {
		update("Update BasicRole Set state = ?,updatedBy=?,updated = ? Where roleId = ?",
				state, vo.getExecutorName(), new Date(), vo.getRoleId());
	}

	@Override
	public void disable(BasicRoleVo vo) {
		updateState(vo, 0);
	}

	@Override
	public void enable(BasicRoleVo vo) {
		updateState(vo, 1);
	}

	@Override
	public List<BasicRoleVo> getBasicRoleVoListByCreater(String creater)
			throws Exception {
		// TODO Auto-generated method stub
		return this.find("from BasicRole where createdBy=?", creater);
	}

	@Override
	public List<BasicRoleVo> getBasicRoleVoListByUserFlag(int userFlag)
			throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("from BasicRole where 1=1 ");
		if(userFlag==Constants.USER_FLAG_USER){
			sb.append("and roleFlag = 2");
		}
		return this.find(sb.toString());
	}
}
