package br.com.animalcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.util.Conexao;

public class DaoOng {

	private final Connection c;

	public DaoOng() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public boolean inserirOng(Ong ong) {

		boolean sucesso = false;
		String sql = "INSERT INTO tb_ong (nome_ong, telefone, cnpj, cep, logradouro, numero, complemento ,bairro, cidade, uf, email, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, ong.getNome_ong());
			stmt.setString(2, ong.getTelefone());
			stmt.setLong(3, ong.getCnpj());
			stmt.setInt(4, ong.getCep());
			stmt.setString(5, ong.getLogradouro());
			stmt.setInt(6, ong.getNumero());
			stmt.setString(7, ong.getComplemento());
			stmt.setString(8, ong.getBairro());
			stmt.setString(9, ong.getCidade());
			stmt.setString(10, ong.getUf());
			stmt.setString(11, ong.getEmail());
			stmt.setString(12, ong.getSenha());

			int rowsAffected = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				ong.setId_ong(id);
			}
			if (rowsAffected > 0) {
				sucesso = true;
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	}

	public boolean alterarOng(Ong ong) {
		boolean sucesso = false;
		String sql = "UPDATE tb_ong SET nome_ong = ?, telefone = ?, cnpj = ?, cep = ?, "
				+ " logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, "
				+ " email = ?, senha = ? WHERE id_ong = ? ";

		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setString(1, ong.getNome_ong());
			stmt.setString(2, ong.getTelefone());
			stmt.setLong(3, ong.getCnpj());
			stmt.setInt(4, ong.getCep());
			stmt.setString(5, ong.getLogradouro());
			stmt.setInt(6, ong.getNumero());
			stmt.setString(7, ong.getComplemento());
			stmt.setString(8, ong.getBairro());
			stmt.setString(9, ong.getCidade());
			stmt.setString(10, ong.getUf());
			stmt.setString(11, ong.getEmail());
			stmt.setString(12, ong.getSenha());
			stmt.setInt(13, ong.getId_ong());

			int rowsAffected = stmt.executeUpdate();
			
			if (rowsAffected > 0) {
				sucesso = true;
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	}

	public Ong buscarOngPorId(Ong ong) {
		
		Ong ongEncontrada = null;
		
		String sql = "SELECT * FROM tb_ong WHERE id_ong = ?";

		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setLong(1, ong.getId_ong());

			ResultSet rsOng = stmt.executeQuery();
			if (rsOng.next()) {

				ongEncontrada = new Ong(
						rsOng.getInt(1), 
						rsOng.getString(2), 
						rsOng.getString(3), 
						rsOng.getLong(4),
						rsOng.getInt(5), 
						rsOng.getString(6), 
						rsOng.getInt(7), 
						rsOng.getString(8), 
						rsOng.getString(9),
						rsOng.getString(10), 
						rsOng.getString(11), 
						rsOng.getString(12), 
						rsOng.getString(13));
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ongEncontrada;
	}

	public boolean excluirOng(Ong ong) {
		boolean sucesso = false;
		String sql = "DELETE FROM tb_ong WHERE id_ong = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setInt(1, ong.getId_ong());

			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				sucesso = true;
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	}

	public List<Ong> listarOng(Ong ongEnt) {

		List<Ong> listarOngs = new ArrayList<>();

		String sql = "SELECT * FROM tb_ong WHERE nome_ong LIKE ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setString(1, "%" + ongEnt.getNome_ong() + "%");

			ResultSet rsOng = stmt.executeQuery();
			
			Ong ong = new Ong();
			while (rsOng.next()) {

				 ong = new Ong(
						rsOng.getInt(1), 
						rsOng.getString(2), 
						rsOng.getString(3), 
						rsOng.getLong(4),
						rsOng.getInt(5), 
						rsOng.getString(6), 
						rsOng.getInt(7), 
						rsOng.getString(8), 
						rsOng.getString(9),
						rsOng.getString(10), 
						rsOng.getString(11), 
						rsOng.getString(12), 
						rsOng.getString(13));

				listarOngs.add(ong);
			}
			rsOng.close();
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listarOngs;
	}

	public Ong buscarOngPorEmail(String email, String senha) {

		Ong usuarioOng = null;
		String sql = "SELECT * FROM tb_ong WHERE email = ? AND senha = ?";

		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuarioOng = new Ong();
				usuarioOng.setId_ong(rs.getInt("id_ong"));
				usuarioOng.setNome_ong(rs.getString("nome_ong"));
				usuarioOng.setTelefone(rs.getString("telefone"));
				usuarioOng.setCnpj(rs.getLong("cnpj"));
				usuarioOng.setCep(rs.getInt("cep"));
				usuarioOng.setLogradouro(rs.getString("logradouro"));
				usuarioOng.setNumero(rs.getInt("numero"));
				usuarioOng.setComplemento(rs.getString("complemento"));
				usuarioOng.setBairro(rs.getString("bairro"));
				usuarioOng.setCidade(rs.getString("cidade"));
				usuarioOng.setUf(rs.getString("uf"));
				usuarioOng.setEmail(rs.getString("email"));
				usuarioOng.setSenha(rs.getString("senha"));

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioOng;
	}
}
