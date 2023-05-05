package br.com.animalcare.email;

import java.util.Properties;

import br.com.animalcare.bean.Email;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EnviarEmail {

	public EnviarEmail() {

	}
	
	private Email email;
	
	public boolean enviarGmail() {
		boolean retorno = false;
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("animalcare.tcc@gmail.com", "rmmlfatec2023");

			}
		});
		
		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("animalcare.tcc@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					this.email.getEmailAdotante()));
	
			message.setSubject("Email de confirmação!!");
			message.setContent(email.getMensagem(),"text/html; charset=utf-8");

			//send message
			Transport.send(message);

			retorno = true;
		} 
		catch (Exception e) {
			retorno = false;
			e.printStackTrace();
		}
		return retorno;
	}
}
