package sy.domain.vo.base;

import sy.domain.vo.shared.BaseVo;

public class LoginVo extends BaseVo{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1026848408699748352L;

	/**
	 * 账户名_电子邮箱
	 */
    private String userAccount;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 验证码
	 */

	private String rand;
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
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
}
