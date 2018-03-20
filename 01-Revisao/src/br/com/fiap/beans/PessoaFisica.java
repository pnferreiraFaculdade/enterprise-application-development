package br.com.fiap.beans;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements InterfaceEstudante, Serializable{

	private static final long serialVersionUID = 1L;

	public String correr() {
		return "Correndo";
	}

	public void estudar() {
		System.out.println("Estudando");
	}

	public void fazerProvas() {
		System.out.println("Gabaritando");
	}
	
}
