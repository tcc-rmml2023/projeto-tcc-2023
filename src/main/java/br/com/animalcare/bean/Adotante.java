package br.com.animalcare.bean;

import java.io.Serializable;

public class Adotante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome_adotante;
	private Long cpf;
	private String email;
	private String telefone;
	
	public Adotante() {
		
	}

	public Adotante(String nome_adotante, Long cpf, String email, String telefone) {
		super();
		this.nome_adotante = nome_adotante;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome_adotante() {
		return nome_adotante;
	}

	public void setNome_adotante(String nome_adotante) {
		this.nome_adotante = nome_adotante;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
