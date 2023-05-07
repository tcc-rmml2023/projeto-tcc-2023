import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class TesteMail {

	public static void main(String[] args) {

		String para = "murilo0300@hotmail.com.br";
		String de = "animalcare.tcc@gmail.com";

		final String myMail = "animalcare.tcc@gmail.com";
		final String passWord = "rjqpepcixapfpyij";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session sessão = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myMail, passWord);
			}
		});
		
		sessão.setDebug(true);
		
		try {
			Message message = new MimeMessage(sessão);
			message.setFrom(new InternetAddress(de));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
			message.setSubject("Teste email JavaMail");
			message.setText("Teste email Murilo!!");
			
			System.out.print("Mensagem");
			
			Transport.send(message);
			
			System.out.println("Sent message successfully....");
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}
