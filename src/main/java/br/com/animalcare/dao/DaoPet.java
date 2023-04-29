package br.com.animalcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.bean.Pet;
import br.com.animalcare.util.Conexao;

public class DaoPet {

	private final Connection c;
	
	public DaoPet() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}
	
	Ong ong = new Ong();
	
	public boolean inserirPet(Pet pet, Ong ong) {
		boolean sucesso = false;
		
		String sql = "INSERT INTO tb_pet (nome_pet, idade, genero, obs, id_ong) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pet.getNome_pet());
			stmt.setString(2, pet.getIdade());
			stmt.setString(3, pet.getGenero());
			stmt.setString(4, pet.getObs());
			stmt.setInt(5, pet.getId_ong());
			
			int rowsAffected = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				pet.setId_pet(id);
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
	
	public boolean alterarPet(Pet pet, Ong ong) {
		boolean sucesso = false;
		
		String sql = "UPDATE tb_pet SET nome_pet =?, idade =?, genero =?, obs=? "
						+ " WHERE id_pet =? AND id_ong =? ";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, pet.getNome_pet());
			stmt.setString(2, pet.getIdade());
			stmt.setString(3, pet.getGenero());
			stmt.setString(4, pet.getObs());
			stmt.setInt(5, pet.getId_pet());
			stmt.setInt(6, pet.getId_ong());
			
			int rowsAffected = stmt.executeUpdate();
			
			if (rowsAffected > 0) {
				sucesso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	} 
	
	public ArrayList<Pet> listarPets(Ong ong) {
		ArrayList<Pet> listaPets = new ArrayList<>();
		
		String sql = "SELECT tb_pet.id_pet, tb_pet.nome_pet, tb_pet.idade, tb_pet.genero, tb_pet.obs, "
				+ " tb_ong.nome_ong, " 
				+ " tb_ong.id_ong FROM tb_pet " 
				+ " INNER JOIN tb_ong " 
				+ " ON tb_pet.id_ong = tb_ong.id_ong "
				+ " WHERE tb_ong.id_ong = ?" ;

		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, ong.getId_ong());
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
			
			int id = rs.getInt("id_pet");
			String nome = 	rs.getString("nome_pet");
			String idade = 	rs.getString("idade");
			String genero = rs.getString("genero");
			String obs = rs.getString("obs");
			String nome_ong = rs.getString("nome_ong");
			int id_ong = rs.getInt("id_ong");
			
			Pet pet = new Pet();
			pet.setId_pet(id);
			pet.setNome_pet(nome);
			pet.setIdade(idade);
			pet.setGenero(genero);
			pet.setObs(obs);
			pet.setOng_nome(nome_ong);
			pet.setId_ong(id_ong);
				
			listaPets.add(pet);
			}
			stmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPets;
	}
	
	public boolean excluirPet(Pet pet, Ong ong) {
		
		boolean sucesso = false;
		String sql = "DELETE FROM tb_pet WHERE id_pet = ? AND id_ong = ? ";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, pet.getId_pet());
			stmt.setInt(2, ong.getId_ong());
			
			int rowsAffect = stmt.executeUpdate();
			if(rowsAffect > 0) {
				sucesso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		 return sucesso;
	}
	
	public ArrayList<Pet> buscarPetOng() {
		ArrayList<Pet> listaPetsOng = new ArrayList<>();
		String sql = "SELECT tb_pet.id_pet, tb_pet.nome_pet, tb_pet.idade, tb_pet.genero, tb_pet.obs, "
				+ "tb_ong.nome_ong, tb_ong.cidade "
				+ "FROM tb_pet, tb_ong WHERE tb_pet.id_ong = tb_ong.id_ong ";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				String nome = rs.getString("nome_pet");
				String idade = rs.getString("idade");
				String genero = rs.getString("genero");
				String obs = rs.getString("obs");
				String nome_ong = rs.getString("nome_ong");
				String nome_cidade = rs.getString("cidade");
			
				Pet pets = new Pet();
				pets.setNome_pet(nome);
				pets.setIdade(idade);
				pets.setGenero(genero);
				pets.setObs(obs);
				pets.setOng_nome(nome_ong);
				pets.setOng_cidade(nome_cidade);
				
				listaPetsOng.add(pets);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPetsOng;
	}
}
