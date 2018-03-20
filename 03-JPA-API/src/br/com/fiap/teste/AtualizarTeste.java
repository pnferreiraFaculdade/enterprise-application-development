package br.com.fiap.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Privacidade;
import br.com.fiap.entity.Publicacao;

public class AtualizarTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		/*Publicacao p = em.find(Publicacao.class, 1);
		p.setAutor("PoliPoli");
		p.setNumCurtidas(14);
		*/
		Publicacao p =new Publicacao("Buk", Calendar.getInstance(), null, "Merge", 1, Privacidade.PRIVADO);
		p.setCodigo(1);
		em.merge(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		factory.close();

	}

}
