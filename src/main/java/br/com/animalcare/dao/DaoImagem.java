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

	private static final String INSERIR_IMAGEM = "INSERT INTO tb_imagem (imagemBase64, extensao, id_pet) VALUES (?, ?, ?)";
	private static final String SELECT_IMAGEM = "SELECT  tb_imagem.imagemBase64, tb_imagem.extensao FROM tb_imagem  INNER JOIN tb_pet ON tb_pet.id_pet = tb_imagem.id_pet WHERE tb_imagem.id_pet = ? ";
	
	private final Connection conn;

	public DaoImagem() throws SQLException, ClassNotFoundException {
		this.conn = new Conexao().getConnection();
	}

	public boolean inserir(Integer id, Imagem imagem) {

		try {
			boolean sucesso = false;
			PreparedStatement ps = conn.prepareStatement(INSERIR_IMAGEM);
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
			fecharConexao();
			return sucesso;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public Imagem listaImagens(Integer id) {

		Imagem imagem = new Imagem();

		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_IMAGEM);
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
			fecharConexao();
			return imagem;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);

		}
	}
	
	public void fecharConexao() throws SQLException {
		
		try {
			conn.close();
		} 
		finally {
			try 
			{
				conn.close();
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
		}
	}
}
