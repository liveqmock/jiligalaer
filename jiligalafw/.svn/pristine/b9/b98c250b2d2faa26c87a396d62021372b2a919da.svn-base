package sy.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.mail.EmailHandler;
import sy.common.mail.EmailInfo;

/**
 *
 * @author lidongbo
 *
 */
@Service("mailService")
public class MailService implements MailServiceI{

	
	/**
	 * 发送邮件
	 * 
	 * @param toMail
	 * @param ccMail
	 * @param theme
	 * @param content
	 * @throws Exception
	 */
	public void sendMail(String toMail, String ccMail, String theme,
			String content) throws Exception {
		EmailInfo emailInfo = new EmailInfo();
		emailInfo.setToEmail(new String[] { toMail });
		emailInfo.setCcEmail(new String[] { ccMail });
		emailInfo.setTheme(theme);
		emailInfo.setContent(content);

		emailHandler.sendHtmlMail(emailInfo);
	}
	
	@Autowired
	private EmailHandler emailHandler;

	public EmailHandler getEmailHandler() {
		return emailHandler;
	}

	public void setEmailHandler(EmailHandler emailHandler) {
		this.emailHandler = emailHandler;
	}
	
	
}
