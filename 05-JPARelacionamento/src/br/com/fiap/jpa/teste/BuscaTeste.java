package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		TimeDAOImpl daoTime = new TimeDAOImpl(em);
		Time t = daoTime.buscar(2);
		System.out.println(t.getNome());
		System.out.println(t.getTecnico().getNome());
		em.close();
		factory.close();
	}

}
