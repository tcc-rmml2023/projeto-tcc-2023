package br.com.animalcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.animalcare.bean.Imagem;
import br.com.animalcare.util.Conexao;

public class DaoImagem {

	private final Connection conn;

	public DaoImagem() throws SQLException, ClassNotFoundException {
		this.conn = new Conexao().getConnection();
	}

	public boolean inserir(Integer id, Imagem imagem) {

		String sql = "INSERT INTO tb_imagem (imagemBase64, extensao, id_pet) VALUES (?, ?, ?)";

		try {
			boolean sucesso = false;
			PreparedStatement ps = conn.prepareStatement(sql);
			int i = 0;
			int rowsAffect = 0;

			for (String foto : imagem.getImagemBase64()) {

				ps.setString(1, foto);
				ps.setString(2, imagem.getExtencao().get(i));
				ps.setInt(3, id);

				ps.executeUpdate();
			}

			if (rowsAffect > 0) {
				sucesso = true;
			}

			return sucesso;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public Imagem listaImagens(Integer id) {

		Imagem imagem = new Imagem();
		String sql = "SELECT  tb_imagem.imagemBase64, tb_imagem.extensao " 
				+ " FROM tb_imagem "
				+ " INNER JOIN tb_pet "
				+ " ON tb_pet.id_pet = tb_imagem.id_pet " 
				+ " WHERE tb_imagem.id_pet = ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			List<String> imagemBase64 = new ArrayList<>();
			List<String> extensao = new ArrayList<>();

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String img = rs.getString("imagemBase64");
				String ext = rs.getString("extensao");

				imagemBase64.add(img);
				extensao.add(ext);
			}

			imagem.setImagemBase64(imagemBase64);
			imagem.setExtencao(extensao);

			ps.close();
			return imagem;
		}

		catch (SQLException e) {
			
			System.out.println(e.getMessage());
			throw new RuntimeException(e);

		}
	}
}
