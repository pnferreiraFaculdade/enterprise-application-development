package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Publicacao;

public class RefreshTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		
		Publicacao p = em.find(Publicacao.class, 1);
		System.out.println(p.getConteudo());
		p.setConteudo("Mudei o conteudo");
		System.out.println(p.getConteudo());
		em.refresh(p);
		System.out.println(p.getConteudo());
		
		em.close();
		factory.close();
	}

}
