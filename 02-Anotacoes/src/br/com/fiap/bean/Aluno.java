package br.com.fiap.bean;

import br.com.fiap.anotation.Coluna;

public class Aluno {

	@Coluna(nome="cd_aluno")
	private int rm;
	@Coluna(nome="nm_aluno")
	private String nome;

	public Aluno() {
		super();
	}
	
	public Aluno(int rm, String nome) {
		super();
		this.rm = rm;
		this.nome = nome;
	}
	
	
	public int getRm() {
		return rm;
	}
	public void setRm(int rm) {
		this.rm = rm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
