package br.com.animalcare.bean;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Email {

	private String emailOng;
	private String emailAdotante;
	private String mensagem;
	
	public Email() {
	}

	public Email(String emailOng, String emailAdotante, String mensagem) {
		super();
		this.emailOng = emailOng;
		this.emailAdotante = emailAdotante;
		this.mensagem = mensagem;
	}

	public String getEmailOng() {
		return emailOng;
	}

	public void setEmailOng(String emailOng) {
		this.emailOng = emailOng;
	}

	public String getEmailAdotante() {
		return emailAdotante;
	}

	public void setEmailAdotante(String emailAdotante) {
		this.emailAdotante = emailAdotante;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
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
					this.emailAdotante));
	
			message.setSubject("Email de confirmação!!");
			message.setContent(this.mensagem,"text/html; charset=utf-8");

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
