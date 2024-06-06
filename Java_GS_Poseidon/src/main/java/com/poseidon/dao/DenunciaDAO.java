package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.conexoes.ConexaoFactory;
import com.poseidon.model.Denuncia;

public class DenunciaDAO {
	
	private Connection conexao;
	
	public DenunciaDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().conexao();
	}
	
	public String Insert(Denuncia denuncia) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("insert into "
				+ "denuncia values (?,?,?,?,?)");
		stmt.setInt(1, denuncia.getId_Denuncia());
		stmt.setString(2, denuncia.getEntereco_Denuncia());
		stmt.setString(3, denuncia.getDescricao_Denuncia());
		stmt.setBoolean(4, denuncia.isAnimal_Denuncia());
		stmt.setString(5, denuncia.getTelefone_Denuncia());
		stmt.execute();
		stmt.close();
		return "Cadastro com sucesso!";
	}
	
	public String Delete(Integer Id_Denuncia) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("delete from "
				+ "denuncia where ID_denuncia = ?");
		stmt.setInt(1, Id_Denuncia);
		stmt.execute();
		stmt.close();
		return "Deletado com sucesso!";
	}
	
	public String Update(Denuncia denuncia) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("update denuncia set ID_denuncia = ?, "
				+ "endereco_denuncia = ?, descricao_denuncia = ?, animal_denuncia = ?, telefone_denuncia,"
				+ "where ID_denuncia = ?");
		stmt.setInt(1, denuncia.getId_Denuncia());
		stmt.setString(2, denuncia.getEntereco_Denuncia());
		stmt.setString(3, denuncia.getDescricao_Denuncia());
		stmt.setBoolean(4, denuncia.isAnimal_Denuncia());
		stmt.setString(5, denuncia.getTelefone_Denuncia());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com sucesso!";
	}
	
	public List<Denuncia> Select() throws SQLException{
		List<Denuncia> denuncias = new ArrayList<>();
		PreparedStatement stmt = conexao.prepareStatement("select * from denuncia");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Denuncia denuncia = new Denuncia();
			denuncia.setId_Denuncia(rs.getInt(1));
			denuncia.setEntereco_Denuncia(rs.getString(2));
			denuncia.setDescricao_Denuncia(rs.getString(3));
			denuncia.setAnimal_Denuncia(rs.getBoolean(4));
			denuncia.setTelefone_Denuncia(rs.getString(5));
			denuncias.add(denuncia);
		}
		return denuncias;
		
	}

}
