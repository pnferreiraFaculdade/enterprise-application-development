package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.dao.PagamentoDAO;
import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.dao.impl.CorridaDAOImpl;
import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.dao.impl.PagamentoDAOImpl;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteConsulta {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		try {
			
			MotoristaDAO motDAO = new MotoristaDAOImpl(em);
			List<Motorista> lista1 = motDAO.buscarPorNome("n");
			for (Motorista motorista : lista1) {
				System.out.println(motorista.getNome());
			}
			
			CorridaDAO corDAO = new CorridaDAOImpl(em);
			List<Corrida> lista2 = corDAO.buscarPorData(new GregorianCalendar(1990, Calendar.JANUARY, 2), Calendar.getInstance());
			for (Corrida corrida : lista2) {
				System.out.println(corrida.getDestino());
			}
			
			VeiculoDAO veiDAO = new VeiculoDAOImpl(em);
			List<Veiculo> lista3 = veiDAO.buscarPorAno(2010);
			for (Veiculo veiculo : lista3) {
				System.out.println(veiculo.getPlaca());
			}
			
			lista2 = corDAO.buscarPorMotorista(motDAO.buscar(123));
			for (Corrida corrida : lista2) {
				System.out.println(corrida.getMotorista().getNome());
			}
			
			System.out.println(corDAO.buscarPorPassageiro(1));
			
			lista2 = corDAO.buscarPorNomePassageiro("a");
			for (Corrida corrida : lista2) {
				System.out.println(corrida.getPassageiro().getNome());
			}
			
			PagamentoDAO pagDAO = new PagamentoDAOImpl(em);
			System.out.println(pagDAO.somarPorPassageiro(2));
			System.out.println(corDAO.contarPorMotoristaEData(123, new GregorianCalendar(1990, Calendar.JANUARY, 2), Calendar.getInstance()));
			
			lista2 = corDAO.buscarPor10MaxDePassageiro(2);
			for (Corrida corrida : lista2) {
				System.out.println(corrida.getPassageiro().getNome());
			}
			
			lista2 = corDAO.buscarPorMotoristaEPassageiro(2, 123);
			for (Corrida corrida : lista2) {
				System.out.println(corrida.getPassageiro().getNome() + " " + corrida.getMotorista().getNome());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
			factory.close();
		}
	}
	
}
