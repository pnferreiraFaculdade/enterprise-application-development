package br.com.fiap.bean;

import br.com.fiap.annotation.Tabela;

@Tabela(tabela="TAB_ALUNO")
public class Aluno {

	private int rm;
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
