package sy.service.core;
/**
 *
 * @author lidongbo
 *
 */
public interface MailServiceI {

	public void sendMail(String toMail, String ccMail, String theme,
			String content) throws Exception;
	
}
