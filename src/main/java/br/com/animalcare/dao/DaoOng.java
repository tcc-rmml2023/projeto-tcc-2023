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

	private final Connection conn;

	public DaoOng() throws SQLException, ClassNotFoundException {
		this.conn = new Conexao().getConnection();
	}

	public boolean inserirOng(Ong ong) {

		boolean sucesso = false;
		String sql = "INSERT INTO tb_ong (nome_ong, telefone, cnpj, cep, logradouro, numero, complemento ,"
				+ " bairro, cidade, uf, email, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, ong.getNome_ong());
			ps.setString(2, ong.getTelefone());
			ps.setLong(3, ong.getCnpj());
			ps.setInt(4, ong.getCep());
			ps.setString(5, ong.getLogradouro());
			ps.setInt(6, ong.getNumero());
			ps.setString(7, ong.getComplemento());
			ps.setString(8, ong.getBairro());
			ps.setString(9, ong.getCidade());
			ps.setString(10, ong.getUf());
			ps.setString(11, ong.getEmail());
			ps.setString(12, ong.getSenha());

			int rowsAffected = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				Integer id = rs.getInt(1);
				ong.setId_ong(id);
			}
			if (rowsAffected > 0) {
				sucesso = true;
			}
			
			ps.close();
			conn.close();
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
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, ong.getNome_ong());
			ps.setString(2, ong.getTelefone());
			ps.setLong(3, ong.getCnpj());
			ps.setInt(4, ong.getCep());
			ps.setString(5, ong.getLogradouro());
			ps.setInt(6, ong.getNumero());
			ps.setString(7, ong.getComplemento());
			ps.setString(8, ong.getBairro());
			ps.setString(9, ong.getCidade());
			ps.setString(10, ong.getUf());
			ps.setString(11, ong.getEmail());
			ps.setString(12, ong.getSenha());
			ps.setInt(13, ong.getId_ong());

			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
				sucesso = true;
			}
			ps.close();
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
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, ong.getId_ong());

			ResultSet rsOng = ps.executeQuery();
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
			ps.close();
			conn.close();
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
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, ong.getId_ong());

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				sucesso = true;
			}
			ps.close();
			conn.close();
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
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + ongEnt.getNome_ong() + "%");

			ResultSet rsOng = ps.executeQuery();
			
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
			ps.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listarOngs;
	}

	public Ong buscarOngPorEmail(String email, String senha) {

		Ong usuarioOng = null;
		String sql = " SELECT * FROM tb_ong WHERE email = ? AND senha = ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
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
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioOng;
	}
}
