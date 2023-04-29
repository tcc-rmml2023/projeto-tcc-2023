package br.com.animalcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.animalcare.bean.Adotante;
import br.com.animalcare.util.Conexao;

public class DaoAdotante {
	
private final Connection c;
	
	public DaoAdotante() throws SQLException, ClassNotFoundException{
			this.c = new Conexao().getConnection();
	}

	public boolean inserirAdotante(Adotante adotante) {
		boolean sucesso = false;
		String sql = "INSERT INTO tb_adotante" + "(nome_adotante, cpf, email, telefone, "
				+ "cep ,logradouro, numero, complemento, bairro, cidade, uf )" 
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, adotante.getNome_adotante());
			stmt.setLong(2, adotante.getCpf());
			stmt.setString(3, adotante.getEmail());
			stmt.setString(4, adotante.getTelefone());
			stmt.setInt(5, adotante.getCep());
			stmt.setString(6, adotante.getLogradouro());
			stmt.setString(7, adotante.getNumero());
			stmt.setString(8, adotante.getBairro());
			stmt.setString(9, adotante.getComplemento());
			stmt.setString(10, adotante.getCidade());
			stmt.setString(11, adotante.getUf());

			int rowsAffected = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				adotante.setId_adotante(id);
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

	public boolean alterarAdotante(Adotante adotante) {
		boolean sucesso = false;
		String sql = "UPDATE tb_adotante SET nome_adotante = ?, cpf = ?, email = ?, "
				+ "telefone = ?, cep = ?,logradouro = ?, numero = ?, complemento = ?, "
				+ "bairro = ?, cidade = ?, uf = ? "
				+ "WHERE id_adotante = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setString(1, adotante.getNome_adotante());
			stmt.setLong(2, adotante.getCpf());
			stmt.setString(3, adotante.getEmail());
			stmt.setString(4, adotante.getTelefone());
			stmt.setInt(5, adotante.getCep());
			stmt.setString(6, adotante.getLogradouro());
			stmt.setString(7, adotante.getNumero());
			stmt.setString(8, adotante.getBairro());
			stmt.setString(9, adotante.getComplemento());
			stmt.setString(10, adotante.getCidade());
			stmt.setString(11, adotante.getUf());
			stmt.setInt(12, adotante.getId_adotante());

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
	
	public Adotante buscarAdotantePorCPF(Adotante adotante) {
		Adotante adotanteEncontrado = null;
		
		String sql = "SELECT * FROM tb_adotante WHERE cpf = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setLong(1, adotante.getCpf());

			ResultSet rsAdotante = stmt.executeQuery();
		
			if (rsAdotante.next()) {

				adotanteEncontrado = new Adotante(
						rsAdotante.getInt(1), 
						rsAdotante.getString(2), 
						rsAdotante.getLong(3), 
						rsAdotante.getString(4), 
						rsAdotante.getString(5),  
						rsAdotante.getInt(6), 
						rsAdotante.getString(7),
						rsAdotante.getString(8),
						rsAdotante.getString(9),
						rsAdotante.getString(10),
						rsAdotante.getString(11),
						rsAdotante.getString(12));
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return adotanteEncontrado;
	}

	public boolean excluirAdotante(Adotante adotante) {
		boolean sucesso = false;
		String sql = "DELETE FROM tb_adotante WHERE id_adotante = ?";

		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setLong(1, adotante.getId_adotante());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				sucesso = true;
			}
			
			stmt.close();
			c.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	}

	public List<Adotante> listarAdotantes(Adotante adotEnt) {

		List<Adotante> listAdotante = new ArrayList<>();

		String sql = "SELECT * FROM tb_adotante WHERE nome_adotante LIKE ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);

			stmt.setString(1, "%" + adotEnt.getNome_adotante() + "%");

			ResultSet rsAdotante = stmt.executeQuery();

			while (rsAdotante.next()) {

				Adotante adotante = new Adotante(
						rsAdotante.getInt(1), 
						rsAdotante.getString(2), 
						rsAdotante.getLong(3), 
						rsAdotante.getString(4),
						rsAdotante.getString(5), 
						rsAdotante.getInt(6), 
						rsAdotante.getString(7),
						rsAdotante.getString(8),
						rsAdotante.getString(9),
						rsAdotante.getString(10),
						rsAdotante.getString(11),
						rsAdotante.getString(12));
						
				listAdotante.add(adotante);
			}
			rsAdotante.close();
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listAdotante;
	}
}
