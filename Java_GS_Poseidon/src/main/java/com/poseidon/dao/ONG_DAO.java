package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.conexoes.ConexaoFactory;
import com.poseidon.model.ONG;

public class ONG_DAO {
	
	private Connection conexao;
	
	public ONG_DAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().conexao();
	}
	
	public String Insert(ONG ong) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("insert into "
				+ "ong values (?,?,?,?,?,?,?)");
		stmt.setInt(1, ong.getId_ONG());
		stmt.setString(2, ong.getNome());
		stmt.setString(3, ong.getEmail());
		stmt.setString(4, ong.getSenha());
		stmt.setString(5, ong.getEndereco());
		stmt.setString(6, ong.getTelefone());
		stmt.setString(7, ong.getDescricao());
		stmt.execute();
		stmt.close();
		return "Cadastro com sucesso!";
		
	}
	
	public String Delete(Integer Id_ONG) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("delete from "
				+ "ong where ID_ong = ?");
		stmt.setInt(1, Id_ONG);
		stmt.execute();
		stmt.close();
		return "Deletado com sucesso!";
		
	}
	
	public String Update(ONG ong) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("update ong set ID_ong = ?, "
				+ "nome_ong = ?, email_ong = ?, senha_ong = ?, endereco_ong = ?, telefone_ong = ?, descricao_ong = ?,"
				+ "where ID_ong = ?");
		stmt.setInt(1, ong.getId_ONG());
		stmt.setString(2, ong.getNome());
		stmt.setString(3, ong.getEmail());
		stmt.setString(4, ong.getSenha());
		stmt.setString(5, ong.getEndereco());
		stmt.setString(6, ong.getTelefone());
		stmt.setString(7, ong.getDescricao());
		stmt.setInt(8, ong.getId_ONG());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com sucesso!";
		
	}
	
	public List<ONG> Select() throws SQLException {
		List<ONG> ongs = new ArrayList<>();
		PreparedStatement stmt = conexao.prepareStatement("select * from ong");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			ONG ong = new ONG();
			ong.setId_ONG(rs.getInt(1));
			ong.setNome(rs.getString(2));
			ong.setEmail(rs.getString(3));
			ong.setSenha(rs.getString(4));
			ong.setEndereco(rs.getString(5));
			ong.setTelefone(rs.getString(6));
			ong.setDescricao(rs.getString(7));
			ongs.add(ong);
		}
		return ongs;
		
	}

}
