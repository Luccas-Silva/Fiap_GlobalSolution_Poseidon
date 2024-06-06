package com.poseidon.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dao.UsuarioDAO;
import com.poseidon.model.Usuario;
import com.poseidon.service.API_ViaCEP;

public class UsuarioBO {
	
	API_ViaCEP cep = new API_ViaCEP();
	
	UsuarioDAO usuario_dao = null;
	
	public void InsertBO(Usuario usuario) throws ClassNotFoundException, SQLException, Exception {
		UsuarioDAO usuario_dao = new UsuarioDAO();
		usuario.setEndereco(cep.getEndereco(usuario.getEndereco()));
		usuario_dao.Insert(usuario);
	}
	
	public void DeleteBO(Integer Id_Usuario) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuario_dao = new UsuarioDAO();
		usuario_dao.Delete(Id_Usuario);
	}
	
	public void UpdateBO(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuario_dao = new UsuarioDAO();
		usuario_dao.Update(usuario);
	}
	
	public List<Usuario> SelectBO() throws ClassNotFoundException, SQLException {
		UsuarioDAO usuario_dao = new UsuarioDAO();
		return (ArrayList<Usuario>) usuario_dao.Select();
	}

}
