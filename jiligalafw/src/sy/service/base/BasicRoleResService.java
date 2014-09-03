package sy.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.StringUtils;
import sy.domain.model.base.BasicResource;
import sy.domain.model.base.BasicRole;
import sy.domain.model.base.BasicRoleRes;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.BasicRoleResVo;
import sy.domain.vo.base.BasicRoleVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("basicRoleResService")
public class BasicRoleResService extends
		BaseServiceTemplate<BasicRoleRes, BasicRoleResVo> implements
		BasicRoleResServiceI {

	public String getResIdsByRoleId(String roleId){
		List<BasicResourceVo> resList = find(
				BasicResourceVo.class,
				"select auth.resource from BasicRoleRes auth where auth.role.roleId=?",
				roleId);
		String resId = "";
		for (BasicResourceVo res : resList) {
			if (!resId.equals("")) {
				resId += ",";
			}
			resId += res.getResId();
		}
		return resId;
	}
	
	public int deleteByRoleId(String roleId) {
		return update("delete from BasicRoleRes where role.roleId=?", roleId);
	}

	@Override
	public void save(String roleId, String resIds) {
		
		deleteByRoleId(roleId);
		
		if (StringUtils.isNotBlank(resIds)) {
			String[] resIdArr = resIds.split(",");
			for (String id : resIdArr) {
				BasicRoleRes brr = new BasicRoleRes();
				
				BasicRole role = new BasicRole();
				role.setRoleId(roleId);
				brr.setRole(role);
				
				BasicResource res = new BasicResource();
				res.setResId(id);
				brr.setResource(res);
				getBaseDao().save(brr);
			}
		}
	}
	
	public List<BasicResourceVo> getResourcesByRole(List<BasicRoleVo> roles) {

		List<String> roleIds = new ArrayList<String>();
		for (BasicRoleVo vo : roles) {
			if (vo == null || vo.getRoleId() == null) {
				continue;
			}
			roleIds.add(vo.getRoleId());
		}
		String roleIdsStr = StringUtils.join(roleIds, "','");

		if (StringUtils.isNotBlank(roleIdsStr)) {
			return find(BasicResourceVo.class,
					"select brr.resource from BasicRoleRes brr where brr.role.roleId in ('"
							+ roleIdsStr + "')");
		}

		return new ArrayList<BasicResourceVo>();
	}

}
