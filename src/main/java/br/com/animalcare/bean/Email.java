package br.com.animalcare.bean;

import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class Email {

	private String emailOng;
	private String emailAdotante;
	private String solicitacao;
	
	public Email() {
	}

	public Email(String emailOng, String emailAdotante, String solicitacao) {
		super();
		this.emailOng = emailOng;
		this.emailAdotante = emailAdotante;
		this.solicitacao = solicitacao;
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

	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	public boolean enviarGmail() {
		
		String assunto = "Solicitação de adoção";
		String myMail = "animalcare.tcc@gmail.com";
		String passWord = "rjqpepcixapfpyij";
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
			Message message = new MimeMessage(session);
			
			MimeMultipart multipart = new MimeMultipart();
			
			BodyPart bp = new MimeBodyPart();
			
			String htmlText = "<h5>logo animalcare</h5><img src=\"cid:image\">";
			bp.setContent(htmlText, "text/html");
			
			multipart.addBodyPart(bp);
			
			bp = new MimeBodyPart();
			
			DataSource img = new FileDataSource("C:\\eclipse-teste\\animalcare\\src\\main\\webapp\\resources\\img\\icone.png");
			
			bp.setDataHandler(new DataHandler(img));
			bp.setHeader("Content - ID", "<image>");
			
			multipart.addBodyPart(bp);
			
			message.setFrom(new InternetAddress(myMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					this.emailAdotante));
			message.setRecipient(Message.RecipientType.CC, new InternetAddress(
					this.emailOng));
	
			message.setSubject(assunto);
			
			message.setContent(this.solicitacao, "text/html; charset=utf-8");
			
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
