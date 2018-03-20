package br.com.fiap.principal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Calendar hoje = Calendar.getInstance();
		ContaCorrente cc = new ContaCorrente(12, 3456, hoje , 34.5, TipoConta.COMUM);
		ContaPoupanca cp = new ContaPoupanca(13, 5678, hoje, 178987.4, 20);
		
		List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
		
		contas.add(new ContaCorrente(12, 9876, hoje , 7897.34, TipoConta.COMUM));
		contas.add(new ContaCorrente(13, 1234, hoje , 4563.36, TipoConta.COMUM));
		contas.add(new ContaCorrente(12, 5656, hoje , 1227.57, TipoConta.COMUM));
		/*
		for(int i = 0; i<contas.size(); i++){
			System.out.println(contas.get(i).numero + " = " + contas.get(i).saldo);
        }
		*/
		System.out.println(cp.getNumero());
		for (ContaCorrente contac : contas) {
			System.out.println(contac.getSaldo());
		}
		cc.retirar(34.5);
		
	}

}
