package br.com.animalcare.bean;

public class UsuarioOng {

	
	private int id_usuario;
	private String email;
	private String senha;
	
	
	
	public UsuarioOng() {

	}

	public UsuarioOng(int id_usuario, String email, String senha) {

		this.id_usuario = id_usuario;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioOng(String email, String senha) {

		this.email = email;
		this.senha = senha;
	}

	public UsuarioOng(String email) {

		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}	
}
