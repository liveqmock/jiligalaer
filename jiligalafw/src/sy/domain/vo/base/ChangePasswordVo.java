package sy.domain.vo.base;

import sy.domain.vo.shared.BaseVo;

/**
 * 
 * @author lidongbo
 */
public class ChangePasswordVo extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1026848428699748522L;

	
	/**
	 * 账户名_电子邮箱
	 */
    private String userAccount;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 确认密码
	 */
	private String reUserPassword;
	
	/**
	 * 验证码
	 */

	private String rand;
	
	private String activationFlag;
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getReUserPassword() {
		return reUserPassword;
	}
	public void setReUserPassword(String reUserPassword) {
		this.reUserPassword = reUserPassword;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	public String getActivationFlag() {
		return activationFlag;
	}
	public void setActivationFlag(String activationFlag) {
		this.activationFlag = activationFlag;
	}
	
}
