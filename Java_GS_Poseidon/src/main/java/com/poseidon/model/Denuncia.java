package com.poseidon.model;

public class Denuncia {
	
private static Integer sequence = 0;
	
	private Integer Id_Denuncia;
	private String Entereco_Denuncia;
	private String Descricao_Denuncia;
	private boolean Animal_Denuncia;
	private String Telefone_Denuncia;
	
	public Denuncia() {
		
	}
	public Denuncia(Integer sequence, String entereco_Denuncia, String descricao_Denuncia, boolean animal_Denuncia, String telefone_Denuncia) {
		Id_Denuncia = sequence++;
		Entereco_Denuncia = entereco_Denuncia;
		Descricao_Denuncia = descricao_Denuncia;
		Animal_Denuncia = animal_Denuncia;
		Telefone_Denuncia = telefone_Denuncia;
	}
	
	public Integer getId_Denuncia() {
		return Id_Denuncia;
	}
	public void setId_Denuncia(Integer id_Denuncia) {
		Id_Denuncia = id_Denuncia;
	}
	
	public String getEntereco_Denuncia() {
		return Entereco_Denuncia;
	}
	public void setEntereco_Denuncia(String entereco_Denuncia) {
		Entereco_Denuncia = entereco_Denuncia;
	}
	
	public String getDescricao_Denuncia() {
		return Descricao_Denuncia;
	}
	public void setDescricao_Denuncia(String descricao_Denuncia) {
		Descricao_Denuncia = descricao_Denuncia;
	}
	
	public boolean isAnimal_Denuncia() {
		return Animal_Denuncia;
	}
	public void setAnimal_Denuncia(boolean animal_Denuncia) {
		Animal_Denuncia = animal_Denuncia;
	}
	
	public String getTelefone_Denuncia() {
		return Telefone_Denuncia;
	}
	public void setTelefone_Denuncia(String telefone_Denuncia) {
		Telefone_Denuncia = telefone_Denuncia;
	}
	
	@Override
	public String toString() {
		return "Denuncia [Id_Denuncia=" + Id_Denuncia + ", Entereco_Denuncia=" + Entereco_Denuncia
				+ ", Descricao_Denuncia=" + Descricao_Denuncia + ", Animal_Denuncia=" + Animal_Denuncia
				+ ", Telefone_Denuncia=" + Telefone_Denuncia + "]";
	}
	
}
