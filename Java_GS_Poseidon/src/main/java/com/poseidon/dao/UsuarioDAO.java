package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.conexoes.ConexaoFactory;
import com.poseidon.model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().conexao();
	}
	
	public String Insert(Usuario usuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("insert into "
				+ "usuario values (?,?,?,?,?,?)");
		stmt.setInt(1, usuario.getId_Usuario());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setString(5, usuario.getEndereco());
		stmt.setString(6, usuario.getTelefone());
		stmt.execute();
		stmt.close();
		return "Cadastro com sucesso!";
	}
	
	public String Delete(Integer Id_Usuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("delete from "
				+ "usuario where ID_usuario = ?");
		stmt.setInt(1, Id_Usuario);
		stmt.execute();
		stmt.close();
		return "Deletado com sucesso!";
	}
	
	public String Update(Usuario usuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("update usuario set ID_usuario = ?, "
				+ "nome_ong = ?, email_ong = ?, senha_ong = ?, endereco_ong = ?, telefone_ong = ?,"
				+ "where ID_usuario = ?");
		stmt.setInt(1, usuario.getId_Usuario());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setString(5, usuario.getEndereco());
		stmt.setString(6, usuario.getTelefone());
		stmt.setInt(7, usuario.getId_Usuario());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com sucesso!";
	}
	
	public List<Usuario> Select() throws SQLException{
		List<Usuario> usuarios = new ArrayList<>();
		PreparedStatement stmt = conexao.prepareStatement("select * from usuario");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId_Usuario(rs.getInt(1));
			usuario.setNome(rs.getString(2));
			usuario.setEmail(rs.getString(3));
			usuario.setSenha(rs.getString(4));
			usuario.setEndereco(rs.getString(5));
			usuario.setTelefone(rs.getString(6));
			usuarios.add(usuario);
		}
		return usuarios;
		
	}

}
