package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Publicacao;

public class BuscaTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao p = em.find(Publicacao.class, 1);
		
		System.out.println(p.getConteudo());
		System.out.println(p.getAutor());
		em.close();
		fabrica.close();
		
	}

}
