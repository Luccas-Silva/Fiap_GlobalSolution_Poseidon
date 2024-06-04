package com.poseidon.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dao.ONG_DAO;
import com.poseidon.model.ONG;

public class ONG_BO {
	
	ONG_DAO ong_dao = null;
	
	public void InsertBO(ONG ong) throws ClassNotFoundException, SQLException {
		ONG_DAO ong_dao = new ONG_DAO();
		ong_dao.Insert(ong);
	}
	
	public void DeleteBO(Integer Id_ONG) throws ClassNotFoundException, SQLException {
		ONG_DAO ong_dao = new ONG_DAO();
		ong_dao.Delete(Id_ONG);
	}
	
	public void UpdateBO(ONG ong) throws ClassNotFoundException, SQLException {
		ONG_DAO ong_dao = new ONG_DAO();
		ong_dao.Update(ong);
	}
	
	public List<ONG> SelectBO() throws ClassNotFoundException, SQLException {
		ONG_DAO ong_dao = new ONG_DAO();
		return (ArrayList<ONG>) ong_dao.Select();
	}

}
