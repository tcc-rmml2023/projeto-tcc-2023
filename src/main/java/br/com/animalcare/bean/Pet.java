package br.com.animalcare.bean;

import java.io.Serializable;
import java.util.Objects;

public class Pet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_pet;
	private String nome_pet;
	private String idade;
	private String genero;
	private String ong_nome;
	private String ong_cidade;
	private String obs;
	private Integer id_ong;
	private String emailOng;
	private String caminhoImagem;
	
	//private Adotante adotante;
	private Ong ong;
	
	public Pet() {
		super();
	}

	public Integer getId_pet() {
		return id_pet;
	}
	public void setId_pet(Integer id_pet) {
		this.id_pet = id_pet;
	}
	public String getNome_pet() {
		return nome_pet;
	}
	public void setNome_pet(String nome_pet) {
		this.nome_pet = nome_pet;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Integer getId_ong() {
		return id_ong;
	}
	public void setId_ong(Integer id_ong) {
		this.id_ong = id_ong;
	}

	
	public Ong getOng() {
		return ong;
	}
	public void setOng(Ong ong) {
		this.ong = ong;
	}
	
	public String getOng_nome() {
		return ong_nome;
	}
	public void setOng_nome(String ong_nome) {
		this.ong_nome = ong_nome;
	}
	public String getOng_cidade() {
		return ong_cidade;
	}
	public void setOng_cidade(String ong_cidade) {
		this.ong_cidade = ong_cidade;
	}

	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public String getEmailOng() {
		return emailOng;
	}
	public void setEmailOng(String emailOng) {
		this.emailOng = emailOng;
	}
	
	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome_pet);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(nome_pet, other.nome_pet);
	}
}
