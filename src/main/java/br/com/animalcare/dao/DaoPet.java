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

	private final Connection conn;
	
	public DaoPet() throws SQLException, ClassNotFoundException {
		this.conn = new Conexao().getConnection();
	}
	
	Ong ong = new Ong();
	
	public boolean inserirPet(Pet pet) {
		boolean sucesso = false;
		
		String sql = "INSERT INTO tb_pet (nome_pet, idade, genero, obs, tb_pet.caminho_imagem, id_ong) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pet.getNome_pet());
			ps.setString(2, pet.getIdade());
			ps.setString(3, pet.getGenero());
			ps.setString(4, pet.getObs());
			ps.setString(5, pet.getCaminhoImagem());
			
			ps.setInt(6, pet.getId_ong());
		
			int rowsAffected = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				Integer id = rs.getInt(1);
				pet.setId_pet(id);
			}
			if (rowsAffected > 0) {
				sucesso = true;
			}
			ps.close();
			conn.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return sucesso;
	}
	
	public boolean alterarPet(Pet pet) {
		boolean sucesso = false;
		
		String sql = "UPDATE tb_pet SET nome_pet =?, idade =?, genero =?, obs=?, caminho_imagem=? "
						+ " WHERE id_pet =? AND id_ong =? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pet.getNome_pet());
			ps.setString(2, pet.getIdade());
			ps.setString(3, pet.getGenero());
			ps.setString(4, pet.getObs());
			ps.setString(4, pet.getCaminhoImagem());
			ps.setInt(5, pet.getId_pet());
			ps.setInt(6, pet.getId_ong());
			
			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
				sucesso = true;
			}
			ps.close();
			conn.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return sucesso;
	} 
	
	public ArrayList<Pet> listarPet(Ong ong) {
		ArrayList<Pet> listapet = new ArrayList<>();
		
		String sql = "SELECT tb_pet.id_pet, tb_pet.nome_pet, tb_pet.idade, tb_pet.genero, tb_pet.obs, "
				+ " tb_pet.caminho_imagem, "
				+ " tb_ong.nome_ong, " 
				+ " tb_ong.id_ong FROM tb_pet " 
				+ " INNER JOIN tb_ong " 
				+ " ON tb_pet.id_ong = tb_ong.id_ong "
				+ " WHERE tb_ong.id_ong = ?" ;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ong.getId_ong());
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
			
			Pet pet = new Pet();
			pet.setId_pet(rs.getInt("id_pet"));
			pet.setNome_pet(rs.getString("nome_pet"));
			pet.setIdade(rs.getString("idade"));
			pet.setGenero(rs.getString("genero"));
			pet.setObs(rs.getString("obs"));
			pet.setCaminhoImagem(rs.getString("caminho_imagem"));
			pet.setOng_nome(rs.getString("nome_ong"));
			pet.setId_ong(rs.getInt("id_ong"));
				
			listapet.add(pet);
			}
			
			ps.close();
			conn.close();
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listapet;
	}
	
	public boolean excluirPet(Pet pet, Ong ong) {
		
		boolean sucesso = false;
		String sql = "DELETE FROM tb_pet WHERE id_pet = ? AND id_ong = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pet.getId_pet());
			ps.setInt(2, ong.getId_ong());
			
			int rowsAffect = ps.executeUpdate();
			if(rowsAffect > 0) {
				sucesso = true;
			}
			
			ps.close();
			conn.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		 return sucesso;
	}
	
	public ArrayList<Pet> buscarPetOng() {
		ArrayList<Pet> listapetOng = new ArrayList<>();
		String sql = "SELECT tb_pet.id_pet, tb_pet.nome_pet, tb_pet.idade, tb_pet.genero, tb_pet.obs, "
				+ "tb_pet.caminho_imagem, "
				+ "tb_ong.nome_ong, tb_ong.cidade "
				+ "FROM tb_pet, tb_ong WHERE tb_pet.id_ong = tb_ong.id_ong ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Pet pet = new Pet();
				pet.setId_pet(rs.getInt("id_pet"));
				pet.setNome_pet(rs.getString("nome_pet"));
				pet.setIdade(rs.getString("idade"));
				pet.setGenero(rs.getString("genero"));
				pet.setObs(rs.getString("obs"));
				pet.setCaminhoImagem(rs.getString("caminho_imagem"));
				pet.setOng_nome(rs.getString("nome_ong"));
				pet.setOng_cidade(rs.getString("cidade"));

				listapetOng.add(pet);
			}
			ps.close();
			conn.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listapetOng;
	}
	
	public Pet buscaPetPorId(Pet petEncontrado) {
		
		final String BUSCA_PET_SQL = "SELECT tb_pet.id_pet, tb_pet.nome_pet, tb_pet.idade, tb_pet.genero, "
				+ "tb_pet.obs, "
				+ "tb_ong.id_ong, tb_ong.nome_ong, tb_ong.email "
				+ "FROM tb_pet "
				+ "INNER JOIN tb_ong "
				+ "ON tb_pet.id_ong = tb_ong.id_ong "
				+ "WHERE tb_pet.id_pet = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(BUSCA_PET_SQL);
			
			ps.setInt(1, petEncontrado.getId_pet());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				petEncontrado.setId_pet(rs.getInt(1));
				petEncontrado.setNome_pet(rs.getString(2));
				petEncontrado.setIdade(rs.getString(3));
				petEncontrado.setGenero(rs.getString(4));
				petEncontrado.setObs(rs.getString(5));
				petEncontrado.setId_ong(rs.getInt(6));
				petEncontrado.setOng_nome(rs.getString(7));
				petEncontrado.setEmailOng(rs.getString(8));
				
			}
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return petEncontrado;
	}
}
