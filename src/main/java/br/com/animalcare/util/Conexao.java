package br.com.animalcare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db_animalcare";
			String usuario = "root";
			String senha = "@rc1723Ma";
			return DriverManager.getConnection(url, usuario, senha);
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);

		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
