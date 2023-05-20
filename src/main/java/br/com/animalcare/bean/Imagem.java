package br.com.animalcare.bean;

import java.io.Serializable;
import java.util.List;

public class Imagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_imagem;
	private List<String> imagemBase64;
	private List<String> extencao;
	
	public Imagem() {
	}

	public Integer getId_imagem() {
		return id_imagem;
	}

	public void setId_imagem(Integer id_imagem) {
		this.id_imagem = id_imagem;
	}

	public List<String> getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(List<String> imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	public List<String> getExtencao() {
		return extencao;
	}

	public void setExtencao(List<String> extencao) {
		this.extencao = extencao;
	}

	@Override
	public String toString() {
		return "Imagem [id_imagem=" + id_imagem + ", imagemBase64=" + imagemBase64 + ", extencao=" + extencao + "]";
	}
}
