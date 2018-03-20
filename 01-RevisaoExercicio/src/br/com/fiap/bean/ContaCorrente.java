package br.com.fiap.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta{
	
	private TipoConta tipo;
	
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int agencia, int numero, 
			Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void retirar(double valor) throws Exception{
		if(valor > saldo && tipo == TipoConta.COMUM) 
			throw new Exception("Saldo insuficiente");
		else 
			saldo -= valor;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
	
	
}
