package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.conexoes.ConexaoFactory;
import com.poseidon.model.NewsLetter;

public class NewsLetterDAO {
	
	private Connection conexao;
	
	public NewsLetterDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().conexao();
	}
	
	public String Insert(NewsLetter newsletter) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("insert into "
				+ "newsletter values (?,?,?,?)");
		stmt.setInt(1, newsletter.getId_NewsLetter());
		stmt.setString(2, newsletter.getTitulo_NewsLetter());
		stmt.setString(3, newsletter.getAssunto_NewsLetter());
		stmt.setString(4, newsletter.getDescricao_NewsLetter());
		stmt.execute();
		stmt.close();
		return "Cadastro com sucesso!";
	}
	
	public String Delete(Integer Id_NewsLetter) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("delete from "
				+ "newsletter where ID_Newsletter = ?");
		stmt.setInt(1, Id_NewsLetter);
		stmt.execute();
		stmt.close();
		return "Deletado com sucesso!";
	}
	
	public String Update(NewsLetter newsletter) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("update newsletter set ID_Newsletter = ?, "
				+ "titulo_Newsletter = ?, assunto_Newsletter = ?, descricao_Newsletter,"
				+ "where ID_Newsletter = ?");
		stmt.setInt(1, newsletter.getId_NewsLetter());
		stmt.setString(2, newsletter.getTitulo_NewsLetter());
		stmt.setString(3, newsletter.getAssunto_NewsLetter());
		stmt.setString(4, newsletter.getDescricao_NewsLetter());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com sucesso!";
	}
	
	public List<NewsLetter> Select() throws SQLException{
		List<NewsLetter> newsletters = new ArrayList<>();
		PreparedStatement stmt = conexao.prepareStatement("select * from newsletter");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			NewsLetter newsletter = new NewsLetter();
			newsletter.setId_NewsLetter(rs.getInt(1));
			newsletter.setTitulo_NewsLetter(rs.getString(2));
			newsletter.setAssunto_NewsLetter(rs.getString(3));
			newsletter.setDescricao_NewsLetter(rs.getString(4));
			newsletters.add(newsletter);
		}
		return newsletters;
		
	}

}
