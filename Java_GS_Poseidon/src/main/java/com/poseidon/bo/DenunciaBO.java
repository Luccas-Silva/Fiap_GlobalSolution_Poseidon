package com.poseidon.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dao.DenunciaDAO;
import com.poseidon.model.Denuncia;
import com.poseidon.service.API_ViaCEP;

public class DenunciaBO {
	
	API_ViaCEP cep = new API_ViaCEP();
	
	DenunciaDAO denunciadao = null;
	
	public void InsertBO(Denuncia denuncia) throws ClassNotFoundException, SQLException, Exception {
		DenunciaDAO denunciadao = new DenunciaDAO();
		denuncia.setEntereco_Denuncia(cep.getEndereco(denuncia.getEntereco_Denuncia()));
		denunciadao.Insert(denuncia);
	}
	
	public void DeleteBO(Integer Id_Denuncia) throws ClassNotFoundException, SQLException {
		DenunciaDAO denunciadao = new DenunciaDAO();
		denunciadao.Delete(Id_Denuncia);
	}
	
	public void UpdateBO(Denuncia denuncia) throws ClassNotFoundException, SQLException {
		DenunciaDAO denunciadao = new DenunciaDAO();
		denunciadao.Update(denuncia);
	}
	
	public List<Denuncia> SelectBO() throws ClassNotFoundException, SQLException {
		DenunciaDAO denunciadao = new DenunciaDAO();
		return (ArrayList<Denuncia>) denunciadao.Select();
	}

}
