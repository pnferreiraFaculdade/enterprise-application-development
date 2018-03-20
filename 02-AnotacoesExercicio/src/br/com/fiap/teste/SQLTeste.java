package br.com.fiap.teste;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.bean.Aluno;

public class SQLTeste {

	public static void main(String[] args) {
		Aluno aluno = new Aluno(2, "Thiago");
		String tabela = aluno.getClass().getAnnotation(Tabela.class).tabela();
		String msg = "SELECT * FROM " + tabela;
		System.out.println(msg);
		
	}

}
