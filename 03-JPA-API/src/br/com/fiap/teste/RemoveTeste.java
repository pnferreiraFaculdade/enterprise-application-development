package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Publicacao;

public class RemoveTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
				
		Publicacao p = em.find(Publicacao.class, 1);
		em.remove(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
