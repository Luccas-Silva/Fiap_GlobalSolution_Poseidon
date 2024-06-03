package com.poseidon.model;

public class ONG {
	
	private static Integer sequence = 0;
	
	private Integer Id_ONG;
	private String Nome;
    private String Email;
    private String Senha;
    private String Endereco;
    private String Telefone;
    private String Descricao;
    
    public ONG() {
    	
    }
	public ONG(Integer sequence, String nome, String email, String senha, String endereco, String telefone, String descricao) {
		Id_ONG = sequence++;
		Nome = nome;
		Email = email;
		Senha = senha;
		Endereco = endereco;
		Telefone = telefone;
		Descricao = descricao;
	}
	
	public Integer getId_ONG() {
		return Id_ONG;
	}
	public void setId_ONG(Integer id_ONG) {
		Id_ONG = id_ONG;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "ONG [Id_ONG=" + Id_ONG + ", Nome=" + Nome + ", Email=" + Email + ", Senha=" + Senha + ", Endereco="
				+ Endereco + ", Telefone=" + Telefone + ", Descricao=" + Descricao + "]";
	}
	
}
