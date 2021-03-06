package br.com.testeswicket.contato;

import java.io.Serializable;

public class Contato implements Serializable{
	private static final long serialVersionUID = 6982487603929829074L;
	
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString(){
		return "{Contato: nome='" + nome + "' email='" + email + "' telefone='" + telefone + "'}";
	}
}
