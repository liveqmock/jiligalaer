package sy.common.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
/**
 * Email邮件发送处理器
 * @author lidongbo
 * */
public class EmailHandler {
	
	private static final Log log = LogFactory.getLog(EmailHandler.class);
	
	/**校验Email的正则表达式*/
	public final static String EMAIL_REG="\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\\b";
	
	private JavaMailSender mailSender;				//发送邮件
	private String fromEmail;						//用于发送系统邮箱
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
	/***
	 * info的值传递到helper
	 */
	private void doSetMail(EmailInfo info,MimeMessageHelper helper) 
		throws MessagingException{
		doSetMail(info, helper, false);
	}
	/***
	 * info的值传递到helper
	 */
	private void doSetMail(EmailInfo info,MimeMessageHelper helper,boolean isHTML)
		throws MessagingException{
		helper.setTo(info.getToEmail()); 			// 邮件接收地址
		if(!ArrayUtils.isEmpty(info.getCcEmail())){
			helper.setCc(info.getCcEmail());		// 邮件抄送地址
		}
		helper.setFrom(fromEmail); 					// 邮件发送地址,这里必须和xml里的邮件地址相同一致
		helper.setSubject(info.getTheme()); 		// 主题
		helper.setText(info.getContent(),isHTML); 	// 邮件内容
        for (File attachment : info.getAttachments()) {
        	try {
				helper.addAttachment(encodeAttachmentName(attachment.getName()), attachment);
			} catch (UnsupportedEncodingException e) {
				//转码失败,直接用文件名
				helper.addAttachment(attachment.getName(), attachment);
			}  
		}     
	}
	
	/***
	 * 发送文本Email
	 * @throws Exception 
	 */
	public void sendMail(EmailInfo info) throws Exception {
		checkEmailParams(info);	
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			doSetMail(info, helper);
			mailSender.send(msg); 						// 发送邮件
		}  catch (MessagingException e) {
			log.error(e.getMessage(), e);
			throw new Exception("send email timeout!",e);
		}
	}
	
	/**
	 * 附件名称中文显示
	 */
	private String encodeAttachmentName(String fileName) throws UnsupportedEncodingException{
		//第2个参数表示字符集，第三个为目标编码格式。   
		//MimeUtility.encodeWord(String word,String charset,String encoding)
		//解决附件名称的中文问题 
		return MimeUtility.encodeWord(fileName);
	}
	
	/**
	 * 发送HTML邮件
	 */
	public void sendHtmlMail(EmailInfo info)throws Exception{
		checkEmailParams(info);
		MimeMessage msg = mailSender.createMimeMessage();
		try{
			MimeMessageHelper helper = new MimeMessageHelper(msg,false,"utf-8");
			doSetMail(info, helper,true);//注意加参数true，表示启用html格式
			mailSender.send(msg);
		}catch(MessagingException e){
			log.error(e.getMessage(), e);
			throw new Exception("send email timeout！",e);
		} 
	}
	
	/**校验收件人地址是否为空
	 * @throws Exception */
	private void checkToMailEmpty(String[] toEmail) throws Exception{
		if(ArrayUtils.isEmpty(toEmail))
			throw new Exception("Email address of the recipient does not allow empty!");
	}
	
	/**
	 * 检查参数
	 */
	private void checkEmailParams(EmailInfo info)throws Exception{
		if(info==null){
			throw new Exception("Parameters of the system configuration error message, EmailInfo must be not null! ");
		}
		//没配置收件人则不继续
		checkToMailEmpty(info.getToEmail());
		for (int i = 0; i < info.getToEmail().length; i++) {
			if(StringUtils.isEmpty(info.getToEmail()[i])||!info.getToEmail()[i].matches(EMAIL_REG)){
				log.info("'"+info.getToEmail()[i]+"'Recipient Email address is not correct!");
				info.setToEmail((String[]) ArrayUtils.remove(info.getToEmail(), i--));
			}
		}
		//移除非法格式的收件人地址后,再次检查是否收件人为空
		checkToMailEmpty(info.getToEmail());
		//没配置抄送人则不继续
		if(ArrayUtils.isEmpty(info.getCcEmail())){
			return;
		}
		for (int i = 0; i < info.getCcEmail().length; i++) {
			if(StringUtils.isEmpty(info.getCcEmail()[i])||!info.getCcEmail()[i].matches(EMAIL_REG)){
				log.info("'"+info.getCcEmail()[i]+"'CarbonCopy Email address is not correct!");
				info.setCcEmail((String[]) ArrayUtils.remove(info.getCcEmail(), i--));
			}
		}
	}
}
