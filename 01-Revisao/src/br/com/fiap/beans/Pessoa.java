package br.com.fiap.beans;

public abstract class Pessoa {

	private String nome;
	
	public String caminhar() {
		return "caminhando";
	}
	
	public abstract String correr();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
