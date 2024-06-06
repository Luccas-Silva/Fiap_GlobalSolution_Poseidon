package com.poseidon.model;

public class NewsLetter {
	
	private static Integer sequence = 0;
	
	private Integer Id_NewsLetter;
	private String Titulo_NewsLetter;
	private String Assunto_NewsLetter;
	private String Descricao_NewsLetter;
	
	public NewsLetter() {
		
	}
	public NewsLetter(Integer sequence, String titulo_NewsLetter, String assunto_NewsLetter, String descricao_NewsLetter) {
		Id_NewsLetter = sequence++;
		Titulo_NewsLetter = titulo_NewsLetter;
		Assunto_NewsLetter = assunto_NewsLetter;
		Descricao_NewsLetter = descricao_NewsLetter;
	}
	
	public Integer getId_NewsLetter() {
		return Id_NewsLetter;
	}
	public void setId_NewsLetter(Integer id_NewsLetter) {
		Id_NewsLetter = id_NewsLetter;
	}
	
	public String getTitulo_NewsLetter() {
		return Titulo_NewsLetter;
	}
	public void setTitulo_NewsLetter(String titulo_NewsLetter) {
		Titulo_NewsLetter = titulo_NewsLetter;
	}
	
	public String getAssunto_NewsLetter() {
		return Assunto_NewsLetter;
	}
	public void setAssunto_NewsLetter(String assunto_NewsLetter) {
		Assunto_NewsLetter = assunto_NewsLetter;
	}
	
	public String getDescricao_NewsLetter() {
		return Descricao_NewsLetter;
	}
	public void setDescricao_NewsLetter(String descricao_NewsLetter) {
		Descricao_NewsLetter = descricao_NewsLetter;
	}
	
	@Override
	public String toString() {
		return "NewsLetter [Id_NewsLetter=" + Id_NewsLetter + ", Titulo_NewsLetter=" + Titulo_NewsLetter
				+ ", Assunto_NewsLetter=" + Assunto_NewsLetter + ", Descricao_NewsLetter=" + Descricao_NewsLetter + "]";
	}
}
