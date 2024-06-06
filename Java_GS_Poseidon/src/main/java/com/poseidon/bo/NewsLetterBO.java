package com.poseidon.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dao.NewsLetterDAO;
import com.poseidon.model.NewsLetter;

public class NewsLetterBO {
	
	NewsLetterDAO newsletterdao = null;
	
	public void InsertBO(NewsLetter newsletter) throws ClassNotFoundException, SQLException, Exception {
		NewsLetterDAO newsletterdao = new NewsLetterDAO();
		newsletterdao.Insert(newsletter);
	}
	
	public void DeleteBO(Integer Id_NewsLetter) throws ClassNotFoundException, SQLException {
		NewsLetterDAO newsletterdao = new NewsLetterDAO();
		newsletterdao.Delete(Id_NewsLetter);
	}
	
	public void UpdateBO(NewsLetter newsletter) throws ClassNotFoundException, SQLException {
		NewsLetterDAO newsletterdao = new NewsLetterDAO();
		newsletterdao.Update(newsletter);
	}
	
	public List<NewsLetter> SelectBO() throws ClassNotFoundException, SQLException {
		NewsLetterDAO newsletterdao = new NewsLetterDAO();
		return (ArrayList<NewsLetter>) newsletterdao.Select();
	}

}
