package br.com.animalcare.bean;

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
}
