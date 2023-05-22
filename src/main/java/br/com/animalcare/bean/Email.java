package br.com.animalcare.bean;

import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class Email {

	private String emailTo;
	private String emailCC;
	private String message;
	private String assunto;
	
	public Email() {
	}

	public Email(String emailCC, String emailTo, String message, String assunto) {
		super();
		this.emailCC = emailCC;
		this.emailTo = emailTo;
		this.message = message;
		this.assunto = assunto;	}

	public String getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public boolean enviarGmail() {
		
		final String myMail = "animalcare.tcc@gmail.com";
		final String passWord = "rjqpepcixapfpyij";
		boolean retorno = false;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myMail, passWord);
			}
		});
		
		session.setDebug(true);

		try {
			MimeBodyPart logoPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource("C:\\img\\icone.png");
            
			logoPart.setDataHandler(new DataHandler(source));
            logoPart.setFileName("logo.png"); 

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(this.message,"text/html;charset=utf-8");
			
            MimeMultipart mimeMultpart = new MimeMultipart();
            mimeMultpart.addBodyPart(textBodyPart);
            mimeMultpart.addBodyPart(logoPart);
			
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(myMail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					this.emailTo));
			message.setRecipient(Message.RecipientType.CC, new InternetAddress(
					this.emailCC));
	
			message.setSubject(assunto);
			
			message.setContent(mimeMultpart);
			
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
