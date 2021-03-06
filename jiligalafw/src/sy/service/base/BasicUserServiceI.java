package sy.service.base;

import java.util.List;

import sy.common.util.validator.ValidatorException;
import sy.domain.model.base.BasicUserRole;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 *
 */
public interface BasicUserServiceI extends BasicServiceI<BasicUserVo> {

	BasicUserVo getBasicUserVoByUserAccount(String userAccount) throws Exception;
	BasicUserVo getBasicUserVoByUserId(String userId) throws Exception;
	BasicRoleVo getBasicRoleVoByUserId(String userId) throws Exception;

    List<BasicUserVo> getFilterBasicUserVoList(List<BasicUserVo> users,
			List<BasicUserRole> basicUserRoleList) ;
	String getParamByRequest(String [] requestValue) throws Exception;
	
	List<BasicUserVo> getBaiscUserVoListByParentBaiscUserVo(BasicUserVo basicUserVo) throws Exception;
	
	/**
	 * 控制板页面-获取账户个数
	 * @param userId
	 * @param userFlag
	 * @param userAccountType
	 * @return
	 * @throws Exception
	 */
	int getBasicUserVoCount(String userId,int userFlag,String userAccountType) throws Exception;
	
	/***
	 * 控制板页面-根据账户类型获取待审批账户个数
	 * @param userType
	 * @return
	 */
	public int getNoApprovalUserCount(String userType, String userId);
	/**
	 * 获取账户虚拟机个数
	 * @param userType
	 * @param userId
	 * @return
	 */
	public int getVmCount(String userType, String userId, String vmState);
	/**
	 * 获取账户IP个数
	 * @param userType
	 * @param userId
	 * @return
	 */
	public int getIpCount(String userType, String userId);
	/**
	 * 获取账户存储大小
	 * @param userType
	 * @param userId
	 * @return
	 */
	public Long getStorageSize(String userType, String userId);
	
	/**
	 * 根据账户ID获取下属用户
	 * 返回值：以逗号分隔的账户ID+用户ID拼接的字符串，如果没有下属用户返回自己的ID
	 * @param parentUserId
	 * @return
	 */
	public String getSubUserByParentUserId(String parentUserId);
	
	/**
	 * 根据账户ID查找被推荐人账户信息
	 * @param accountId
	 * @param startDate 可为null
	 * @param endDate 可为null
	 * @return
	 */
	public List<BasicUserVo> getRecommendedUsers(String accountId, String startDate, String endDate);
	
	/**
	 * 根据账户ID查找被推荐人  以逗号分隔的账户ID
	 * @param accountId
	 * @param startDate 可为null
	 * @param endDate 可为null
	 * @return
	 */
	public String getRecommendedUserStr(String accountId, String startDate, String endDate);
	
	/**
	 * 批量停用账户
	 * @param userList
	 */
	public void batchStopOrEnabledUser(List<BasicUserVo> userList, BasicUserVo currUser, String state)throws ValidatorException;
	
	/**
	 * 批量审批
	 * @param userIdArr
	 * @param currUser
	 * @param approvalState
	 * @param rejectRemark
	 * @throws ValidatorException
	 */
	public void batchApproval(List<BasicUserVo> userList, BasicUserVo currUser, String approvalState, String rejectRemark)throws ValidatorException;
	
	public boolean userCardIsExist(String userCard, String userAccount);
}
