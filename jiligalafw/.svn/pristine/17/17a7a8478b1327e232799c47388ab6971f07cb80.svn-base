package sy.common.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/***
 * Email实体
 * @author lidongbo
 */
public class EmailInfo {
	
	protected String fromEmail;	//发件人地址
	protected String fromName;	//发件人名称
	protected String[] toEmail;	//收件人地址
	protected String[] ccEmail;	//抄送人地址
	protected String toName;	//收件人名称
	protected String content;	//发件内容
	protected String theme;		//主题
	
	//附件
	protected List<File> attachments=new ArrayList<File>();
	
	public void addAttachments(File attachment) {
		attachments.add(attachment);
	}
	public List<File> getAttachments() {
		return attachments;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String[] getToEmail() {
		return toEmail;
	}
	public void setToEmail(String[] toEmail) {
		this.toEmail = toEmail;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String[] getCcEmail() {
		return ccEmail;
	}
	public void setCcEmail(String[] ccEmail) {
		this.ccEmail = ccEmail;
	}
}
