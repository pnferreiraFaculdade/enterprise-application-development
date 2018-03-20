package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	private static final float RENDIMENTO = 0.005f;
	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int agencia, int numero, 
			Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void retirar(double valor) throws Exception {
		if(valor + taxa <= saldo) saldo -= valor + taxa;
		else throw new Exception("Saldo Insuficiente");
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
	

}
