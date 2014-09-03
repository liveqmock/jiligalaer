package sy.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.StringUtils;
import sy.domain.model.base.BasicRole;
import sy.domain.model.base.BasicUser;
import sy.domain.model.base.BasicUserRole;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("basicUserRoleService")
public class BasicUserRoleService extends
		BaseServiceTemplate<BasicUserRole, BasicUserRoleVo> implements
		BasicUserRoleServiceI {

	public List<BasicRoleVo> getRoleByUser(BasicUserVo userVo) {
		return find(
				BasicRoleVo.class,
				"select user.basicRole from BasicUserRole user where user.basicUser.userId=? and user.basicRole.state=1 ",
				userVo.getUserId());
	}

	public int deleteByUserId(String userId) {
		return update(
				"delete from BasicUserRole userRole where userRole.basicUser.userId=?",
				userId);
	}

	@Override
	public void save(String userId, String roleIds) {
		// TODO Auto-generated method stub
		deleteByUserId(userId);
		if (StringUtils.isNotBlank(roleIds)) {
			String[] roleIdArr = roleIds.split(",");
			for (String id : roleIdArr) {
				BasicUserRole basicUserRole = new BasicUserRole();
				BasicUser basicUser = new BasicUser();
				basicUser.setUserId(userId);
				basicUserRole.setBasicUser(basicUser);

				BasicRole brv = new BasicRole();
				brv.setRoleId(id);
				basicUserRole.setBasicRole(brv);
				getBaseDao().save(basicUserRole);
			}
		}
	}

	@Override
	public List<BasicRoleVo> getRoleTotalByUser(
			List<BasicRoleVo> basicRoleVoTotalList, BasicUserVo userVo)
			throws Exception {
		// TODO Auto-generated method stub
		List<BasicRoleVo> basicRoleVoList = null;
		try {
			basicRoleVoList = this.getRoleByUser(userVo);
			if (null == basicRoleVoList) {
				return basicRoleVoTotalList;
			}
			for (BasicRoleVo basicRoleVoTotal : basicRoleVoTotalList) {
				for (BasicRoleVo basicRoleVo : basicRoleVoList) {
					if (basicRoleVoTotal.getRoleId().equals(
							basicRoleVo.getRoleId())) {
						basicRoleVoTotal.setIsUsed("check");
					}
				}
			}
		} catch (Exception e) {

		}
		return basicRoleVoTotalList;
	}

	@Override
	public List<BasicUserRole> getUserByRoles(String roleIds,QueryContext context) {
		// TODO Auto-generated method stub
		StringBuffer  hql = new StringBuffer();
		hql.append("select  user from BasicUserRole user where  user.basicRole.state=1 ");
		if(StringUtils.isNotBlank(roleIds)){
			String [] roleIdArr = roleIds.split(",");
			hql.append("and user.basicRole.roleId in (");
			for(int i=0;i<roleIdArr.length;i++){
				hql.append("'"+roleIdArr[i]+"',");
			}	
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		System.out.println(hql);
		return this.list(BasicUserRole.class, context, hql.toString());
	 
	}

@Override
public List<BasicUserVo>  getBasicUserRoleTotalByUser(String roleIds,QueryContext context) throws Exception{
	// TODO Auto-generated method stub
	StringBuffer  hql = new StringBuffer();
	hql.append("from BasicUser user  left join fetch   user.basicUserRole role  where  1=1  ").append(context.buildHqlConditions("user"));
	if(StringUtils.isNotBlank(roleIds)){
		String [] roleIdArr = roleIds.split(",");
		hql.append("and role.basicRole.roleId in (");
		for(int i=0;i<roleIdArr.length;i++){
			hql.append("'"+roleIdArr[i]+"',");
		}	
		hql.deleteCharAt(hql.length()-1);
		hql.append(")");
	}
	return this.list(BasicUser.class, BasicUserVo.class, context, hql.toString());
}

}
