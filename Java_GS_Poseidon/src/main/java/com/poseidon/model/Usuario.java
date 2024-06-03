package com.poseidon.model;

public class Usuario {
	
	private static Integer sequence = 0;
	
	private Integer Id_Usuario;
	private String Nome;
	private String Email;
	private String Senha;
	private String Endereco;
	private String Telefone;
	
	public Usuario() {
		
	}
	public Usuario(Integer sequence, String nome, String email, String senha, String endereco, String telefone) {
		Id_Usuario = sequence++;
		Nome = nome;
		Email = email;
		Senha = senha;
		Endereco = endereco;
		Telefone = telefone;
	}
	
	public Integer getId_Usuario() {
		return Id_Usuario;
	}
	public void setId_Usuario(Integer id_Usuario) {
		Id_Usuario = id_Usuario;
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
	
	@Override
	public String toString() {
		return "Usuario [Id_Usuario=" + Id_Usuario + ", Nome=" + Nome + ", Email=" + Email + ", Senha=" + Senha
				+ ", Endereco=" + Endereco + ", Telefone=" + Telefone + "]";
	}
	
}
