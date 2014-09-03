package sy.common.mail;

import java.io.File;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Test_mail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			sendMappingMail(null, "luobinhan588@163.com");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 * @param attachment
	 * @throws Exception 
	 */
	private static void sendMappingMail(File[] attachment, String emailAddr) throws Exception {
		try{
			EmailInfo emailInfo = new EmailInfo();
			//抄送人
			emailInfo.setCcEmail(new String[]{"luobin@winchannel.net"});
			//接收人
			emailInfo.setToEmail(new String[]{emailAddr});

			emailInfo.setTheme("主题");
			
			emailInfo.setContent("内容");
			
			//添加附件
			if (attachment != null) {
				File[] arrayOfFile;
				int j = (arrayOfFile = attachment).length;
				for (int i = 0; i < j; ++i) {
					File file = arrayOfFile[i];
					emailInfo.addAttachments(file);
				}
			}
			EmailHandler eh = new EmailHandler();
			eh.setMailSender(getMailSender());
			eh.setFromEmail("winchannel_service@163.com");
			eh.sendMail(emailInfo);
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	public static JavaMailSenderImpl getMailSender(){
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl(); 
		senderImpl.setPort(25);
		senderImpl.setHost("123.125.50.133");
		senderImpl.setUsername("winchannel_service@163.com");
		senderImpl.setPassword("winchannel123");
		return senderImpl;
	}
	
}
