package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Ingressrule;

/**
 * 
 * @author lidongbo
 * 
 */
class IngressruleRepository extends AbstractServiceSupport<Ingressrule> {

	public IngressruleRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return null;
	}

	/*
	 <queryasyncjobresultresponse cloud-stack-version="3.0.6.2013-05-02T10:22:00Z">
		<accountid>1</accountid>
		<userid>1</userid>
		<cmd>com.cloud.api.commands.AuthorizeSecurityGroupIngressCmd</cmd>
		<jobstatus>1</jobstatus>
		<jobprocstatus>0</jobprocstatus>
		<jobresultcode>0</jobresultcode>
		<jobresulttype>object</jobresulttype>
		<jobresult>
		<securitygroup>
			<id>b538528a-1979-40e2-95ff-d23dc5cd6546</id>
			<name>lcms_limou</name>
			<description/>
			<account>admin</account>
			<domainid>1</domainid>
			<domain>ROOT</domain>
			<ingressrule>
				<ruleid>56ea1450-4576-4564-ba85-4ea3d0956f4b</ruleid>
				<protocol>tcp</protocol>
				<startport>1</startport>
				<endport>1</endport>
				<cidr>10.1.1.0/24</cidr>
			</ingressrule>
		</securitygroup>
		</jobresult>
		<created>2013-10-26T19:11:14+0800</created>
		<jobid>d01bec9f-9875-4636-b8db-3ea498aa05c8</jobid>
	</queryasyncjobresultresponse>
	 */
	@Override
	protected String getTagName() {
		return "ingressrule";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "authorizeSecurityGroupIngress";
	}
	
	public Ingressrule create(Ingressrule bean) {
		Ingressrule result = super.create(bean);
		result.setSecuritygroupid(bean.getSecuritygroupid());
		return result;
	}

	public void delete(String ingressruleId) {
		super.delete("id", ingressruleId, "revokeSecurityGroupIngress");
	}

}
