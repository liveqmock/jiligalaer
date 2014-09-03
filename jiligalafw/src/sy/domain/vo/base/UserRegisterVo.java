package sy.domain.vo.base;

import sy.domain.vo.shared.BaseVo;

public class UserRegisterVo extends BaseVo{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1026848408699748352L;

	private String userName;
	
	/**
	 * 账户名_电子邮箱
	 */
    private String userAccount;
	/**
	 * 账户类型
	 */
    private String userAccountType;
    private String userIdentity;
    private String userPassword;
    /**
     * 确认密码
     */
    private String reUserPassword;
    /**
     * 联系电话.
     */
    private String tel;

    /**
     *公司名称.
     */
    private String companyName;
    /**
     * 营业执照号.
     */
    private String businessLicense;

    /**
     * 企业组织机构代码.
     */
    private String businewssOrgCode;

    /**
     * 税务登记证.
     */
    private String taxCode;

    /**
     * 身份证号.IDENTITY_CARD
     */
    private String identityCard;
    private Integer userFlag;
    private String invitationKey;
    private String companyLogoFileURI;
    private String birthDate;

    private String remark;
    private String rand;
	
	public String getUserAccountType() {
		return userAccountType;
	}
	public void setUserAccountType(String userAccountType) {
		this.userAccountType = userAccountType;
	}
	public String getUserIdentity() {
		return userIdentity;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getReUserPassword() {
		return reUserPassword;
	}
	public String getTel() {
		return tel;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public String getBusinewssOrgCode() {
		return businewssOrgCode;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public String getRemark() {
		return remark;
	}
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setReUserPassword(String reUserPassword) {
		this.reUserPassword = reUserPassword;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public void setBusinewssOrgCode(String businewssOrgCode) {
		this.businewssOrgCode = businewssOrgCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	
	public String getInvitationKey() {
		return invitationKey;
	}
	public void setInvitationKey(String invitationKey) {
		this.invitationKey = invitationKey;
	}
	public String getCompanyLogoFileURI() {
		return companyLogoFileURI;
	}
	public void setCompanyLogoFileURI(String companyLogoFileURI) {
		this.companyLogoFileURI = companyLogoFileURI;
	}
	public Integer getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
