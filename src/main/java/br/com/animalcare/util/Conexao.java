package br.com.animalcare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/db_animalcare";
	private static final String USER = "root";
	private static final String PASSWWORD = "@rc1723Ma";
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			return DriverManager.getConnection(URL, USER, PASSWWORD);
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);

		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
