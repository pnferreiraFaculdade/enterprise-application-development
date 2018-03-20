package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataTeste {

	
	public static void main(String[] args) {
		//Criar uma data
		Calendar hoje = Calendar.getInstance();
		//Criar um formatador de data
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//Imprimir a data
		System.out.println(formata.format(hoje.getTime()));
		
		//String => Data
		String carnaval = "13/02/2018 12:12:11";
		try {
			System.out.println(formata.parse(carnaval));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//Criar um objeto com uma data especifica
		Calendar formatura = new GregorianCalendar(2018, Calendar.DECEMBER, 2);
		//Imprimir a data
		System.out.println(formata.format(formatura.getTime()));
	}
	
}
