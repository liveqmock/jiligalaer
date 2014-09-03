package sy.domain.model.base;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;


@Entity
@Table(name = "BASIC_USER")
public class BasicUser implements PersistentObject{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String userId;
	/**
	 * 账户名_电子邮箱
	 */
    private String userAccount;
	/**
	 *姓名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	
	/**
	 * 账户或用户标识. 
	 * 0表示账户
	 * 1表示用户
	 */
    private Integer userFlag;
    /**
     * 联系电话.
     */
    private String tel;
    
    /**
     *公司名称.
     */
    private String companyName;
    
    /**
     * 公司logo文件名.
     */
    private String companyLogoFileURI;
    
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
    
    private Date birthDate;
    
    private String remark;
    
    private Date registerDate;
    
    private Date approvalDate;
    
    private String refuseMemo;
    
    private Integer state;
    
	private String createdBy;
	
	private Date created;
	
	private String updatedBy;
	
	private Date updated;
	/**
	 * 账户类型.
	 */
	private BasicDictItem userTypeDictItem;
    /**
     * 账户身份.
     */
	private BasicDictItem userIdentityDictItem;
	/**
	 * 所属部门.
	 */
	private BasicDictItem userDepartmentDictItem;
	/**
	 * 账户被邀请账户ID.
	 */
	private BasicUser inviteBasicUser;
	/**
	 * 用户所属账户ID.
	 */
	private BasicUser parentBasicUser;
	
	private BasicDictItem geoDictItem;
	/**
	 * 行业ID.INDUSTRY
	 */
	private BasicDictItem industryDictItem;
	
	
	private Set<BasicUserRole> basicUserRole;	
	
	@Transient
	public boolean isAdmin() {
		return false;
	}
	
	@Id
	@Column(name="USER_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="USER_PASSWORD")
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Column(name="USER_ACCOUNT")
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
    
	@Column(name="USER_FLAG")
	public Integer getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}

	@Column(name="TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name="COMP_LOGO_FILE_URI")
	public String getCompanyLogoFileURI() {
		return companyLogoFileURI;
	}

	public void setCompanyLogoFileURI(String companyLogoFileURI) {
		this.companyLogoFileURI = companyLogoFileURI;
	}

	@Column(name="BUSINESS_LICENSE")
	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	@Column(name="BUSINESS_ORG_CODE")
	public String getBusinewssOrgCode() {
		return businewssOrgCode;
	}

	public void setBusinewssOrgCode(String businewssOrgCode) {
		this.businewssOrgCode = businewssOrgCode;
	}

	@Column(name="TAX_CODE")
	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	
	@Column(name="IDENTITY_CARD")
	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	@Column(name="BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="REGISTER_DATE")
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name="APPROVAL_DATE")
	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Column(name="REFUSE_MEMO")
	public String getRefuseMemo() {
		return refuseMemo;
	}

	public void setRefuseMemo(String refuseMemo) {
		this.refuseMemo = refuseMemo;
	}

	@Column(name="STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name="UPDATED")
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@ManyToOne()  
    @JoinColumn(name = "USER_ACCOUNT_TYPE_ID") 
	public BasicDictItem getUserTypeDictItem() {
		return userTypeDictItem;
	}

	public void setUserTypeDictItem(BasicDictItem userTypeDictItem) {
		this.userTypeDictItem = userTypeDictItem;
	}

	@ManyToOne()  
    @JoinColumn(name = "USER_IDENTITY_ID") 
	public BasicDictItem getUserIdentityDictItem() {
		return userIdentityDictItem;
	}

	public void setUserIdentityDictItem(BasicDictItem userIdentityDictItem) {
		this.userIdentityDictItem = userIdentityDictItem;
	}

	@ManyToOne()  
    @JoinColumn(name = "USER_DEPART_ID") 
	public BasicDictItem getUserDepartmentDictItem() {
		return userDepartmentDictItem;
	}

	public void setUserDepartmentDictItem(BasicDictItem userDepartmentDictItem) {
		this.userDepartmentDictItem = userDepartmentDictItem;
	}

	@ManyToOne()  
    @JoinColumn(name = "INVITE_USER_ID") 
	public BasicUser getInviteBasicUser() {
		return inviteBasicUser;
	}

	public void setInviteBasicUser(BasicUser inviteBasicUser) {
		this.inviteBasicUser = inviteBasicUser;
	}

	@ManyToOne()  
    @JoinColumn(name = "PARENT_USER_ID") 
	public BasicUser getParentBasicUser() {
		return parentBasicUser;
	}

	public void setParentBasicUser(BasicUser parentBasicUser) {
		this.parentBasicUser = parentBasicUser;
	}

	@ManyToOne()  
    @JoinColumn(name = "GEO_ID") 
	public BasicDictItem getGeoDictItem() {
		return geoDictItem;
	}

	public void setGeoDictItem(BasicDictItem geoDictItem) {
		this.geoDictItem = geoDictItem;
	}

	@ManyToOne()  
    @JoinColumn(name = "INDUSTRY_ID") 
	public BasicDictItem getIndustryDictItem() {
		return industryDictItem;
	}

	public void setIndustryDictItem(BasicDictItem industryDictItem) {
		this.industryDictItem = industryDictItem;
	}
	
	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name="USER_ID") 
	public Set<BasicUserRole> getBasicUserRole() {
		return basicUserRole;
	}

	public void setBasicUserRole(Set<BasicUserRole> basicUserRole) {
		this.basicUserRole = basicUserRole;
	}
	
	
}
