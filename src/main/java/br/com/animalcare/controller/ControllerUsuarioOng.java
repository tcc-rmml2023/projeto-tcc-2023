package br.com.animalcare.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.animalcare.bean.UsuarioOng;
import br.com.animalcare.dao.DaoUsuarioOng;

public class ControllerUsuarioOng {
	
	DaoUsuarioOng usuarioOngDao = null;
	
	public UsuarioOng inserir(UsuarioOng usuario) throws ClassNotFoundException, SQLException {
		
		usuarioOngDao = new DaoUsuarioOng();
		 return usuarioOngDao.inserir(usuario);
	}
	
	public UsuarioOng alterar(UsuarioOng usuario) throws ClassNotFoundException, SQLException {
		
		usuarioOngDao = new DaoUsuarioOng();
		 return usuarioOngDao.alterar(usuario);
	}

	public UsuarioOng exlcuir(UsuarioOng usuario) throws ClassNotFoundException, SQLException {
	
		usuarioOngDao = new DaoUsuarioOng();
		return usuarioOngDao.excluir(usuario);
	}
	
	public UsuarioOng buscar(UsuarioOng usuario) throws ClassNotFoundException, SQLException {
		
		usuarioOngDao = new DaoUsuarioOng();
		 return usuarioOngDao.buscar(usuario);
	}
	
	public List<UsuarioOng> listar(UsuarioOng usuario) throws ClassNotFoundException, SQLException{
		
		usuarioOngDao = new DaoUsuarioOng();
		return usuarioOngDao.listar(usuario);
	}
}
