package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.dao.impl.CorridaDAOImpl;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Pagamento;
import br.com.fiap.jpa.entity.Passageiro;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		Corrida corrida = new Corrida(12, "FIAP Aclima��o", "FIAP Paulista", Calendar.getInstance(), 10);
		Corrida corrida2 = new Corrida(13, "fisdjfisjiom", "Baaaaaa", Calendar.getInstance(), 12);
		Passageiro passageiro = new Passageiro("Joaozinho", new GregorianCalendar(1999, Calendar.JANUARY, 2), Genero.MASCULINO);
		Passageiro passageiro2 = new Passageiro("Casquinha", new GregorianCalendar(1876, Calendar.JANUARY, 14), Genero.FEMININO);
		
		Motorista motorista = new Motorista(123, "Aninha", new GregorianCalendar(1990, Calendar.JANUARY, 2), null, Genero.FEMININO);
		Motorista motorista2 = new Motorista(124, "Bananinha", new GregorianCalendar(1981, Calendar.JANUARY, 24), null, Genero.MASCULINO);
		
		Pagamento pagamento = new Pagamento(56, Calendar.getInstance(), 10, "Dinheiro");
		
		Veiculo veiculo1 = new Veiculo("AAA8965", "Branco", 2010);
		Veiculo veiculo2 = new Veiculo("BBB9099", "Azul", 2015);
		
		corrida.setMotorista(motorista);
		corrida2.setMotorista(motorista2);
		corrida.setPassageiro(passageiro);
		corrida2.setPassageiro(passageiro2);
		
		corrida.setPagamento(pagamento); //mappedBy precisa setar o outro lado para a cascata
		pagamento.setCorrida(corrida);
		
		List<Veiculo> veiculos = new ArrayList<>();
		veiculos.add(veiculo1);
		veiculos.add(veiculo2);
		
		motorista.setVeiculos(veiculos);
		
		CorridaDAO dao = new CorridaDAOImpl(em);
		
		try {
			dao.cadastrar(corrida2);
			dao.cadastrar(corrida); //cadastra todas as entidades por cascata
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
