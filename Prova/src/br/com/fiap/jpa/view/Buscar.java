package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.dao.impl.CorridaDAOImpl;
import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Buscar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		try {
			MotoristaDAO daoMot = new MotoristaDAOImpl(em);
			List<Motorista> lista = daoMot.buscarPorNome("u");
			for (Motorista motorista : lista) {
				System.out.println(motorista.getNome());
			}
			
			CorridaDAO daoCor = new CorridaDAOImpl(em);
			List<Corrida> lista2 = daoCor.buscarPorData(new GregorianCalendar(1900, Calendar.APRIL, 21), new GregorianCalendar(2018, Calendar.APRIL, 26));
			for (Corrida corrida : lista2) {
				System.out.println(corrida.getOrigem());
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			em.close();
			factory.close();
		}
	}

}
