package br.com.animalcare.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Ong implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_ong;
	private String nome_ong;
	private String telefone;
	private Long cnpj;
	private Integer cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String email;
	private String senha;
	
	private ArrayList<Pet> pets;
	private Pet pet;
	
	public Ong(String nome_ong, String telefone, Long cnpj, Integer cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf, String email, String senha) {

		this.nome_ong = nome_ong;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.senha = senha;
		
	}
	public Ong(Integer id_ong, String nome_ong, String telefone, Long cnpj, Integer cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf, String email, String senha) {

		this.id_ong = id_ong;
		this.nome_ong = nome_ong;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.senha = senha;
	}

	public Ong(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	public Ong() {
		super();
	}
	public Integer getId_ong() {
		return id_ong;
	}
	public void setId_ong(Integer id_ong) {
		this.id_ong = id_ong;
	}
	public String getNome_ong() {
		return nome_ong;
	}
	public void setNome_ong(String nome_ong) {
		this.nome_ong = nome_ong;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
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
	
	public ArrayList<Pet> getPets() {
		return pets;
	}

	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cnpj, email, senha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ong other = (Ong) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(email, other.email)
				&& Objects.equals(senha, other.senha);
	}
}
