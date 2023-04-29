package br.com.animalcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.animalcare.bean.UsuarioOng;
import br.com.animalcare.util.Conexao;

public class DaoUsuarioOng {

	private Connection c;

	public DaoUsuarioOng() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public UsuarioOng inserir(UsuarioOng usuario) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO tb_usuario" + "email, senha" + "VALUES (?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, usuario.getEmail());
		stmt.setString(2, usuario.getSenha());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			usuario.setId_usuario(id);
		}
		stmt.close();
		return usuario;
	}

	public UsuarioOng alterar(UsuarioOng usuario) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE tb_usuario SET email = ?, senha = ? WHERE = id_usuario = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, usuario.getEmail());
		stmt.setString(2, usuario.getSenha());
		stmt.setInt(3, usuario.getId_usuario());

		stmt.execute();
		stmt.close();

		return usuario;
	}

	public UsuarioOng excluir(UsuarioOng usuario) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FORM tb_usuario WHERE id_usuario = ?";

		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, usuario.getId_usuario());

		stmt.execute();
		stmt.close();
		c.close();

		return usuario;
	}

	public UsuarioOng buscar(UsuarioOng usuario) throws SQLException, ClassNotFoundException {

		String sql = "SELECT email FROM tb_usuario WHERE email = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, usuario.getEmail());
		;

		ResultSet rs = stmt.executeQuery();
		UsuarioOng retornoUsuario = null;

		while (rs.next()) {

			retornoUsuario = new UsuarioOng(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		stmt.close();

		return retornoUsuario;
	}

	public List<UsuarioOng> listar(UsuarioOng usuario) throws SQLException, ClassNotFoundException {

		List<UsuarioOng> listUsuario = new ArrayList<>();

		String sql = "SELECT email FROM tb_usuario WHERE email LIKE ?";

		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, "%" + usuario.getEmail() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			UsuarioOng usuList = new UsuarioOng(

					rs.getString(1));
			listUsuario.add(usuList);
		}

		rs.close();
		stmt.close();

		return listUsuario;
	}

	public UsuarioOng buscaEmail(String email)throws SQLException, ClassNotFoundException {
		
		UsuarioOng usuario = new UsuarioOng();
		String sql = "SELECT email FROM tb_usuario WHERE email = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, usuario.getEmail());
		;

		ResultSet rs = stmt.executeQuery();
		UsuarioOng retornoUsuario = null;

		while (rs.next()) {

			retornoUsuario = new UsuarioOng(rs.getString(1));
		}
		stmt.close();

		return retornoUsuario;
	}
}
