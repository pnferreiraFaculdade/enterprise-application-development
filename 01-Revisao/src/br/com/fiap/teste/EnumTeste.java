package br.com.fiap.teste;

import br.com.fiap.beans.EnumEscolaridade;

public class EnumTeste {

	public static void main(String[] args) {
		EnumEscolaridade escolaridade = EnumEscolaridade.FUNDAMENTAL_COMPLETO;
		
		if (escolaridade == EnumEscolaridade.FUNDAMENTAL_COMPLETO) {
			System.out.println(escolaridade);
		}
	}
	
}
