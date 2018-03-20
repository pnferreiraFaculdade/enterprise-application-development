package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Privacidade;
import br.com.fiap.entity.Publicacao;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao pub = new Publicacao("Poliana", new GregorianCalendar(2017, Calendar.FEBRUARY, 27), null, "Estou na aula de JPA, uhul", 16, Privacidade.RESTRITO);
		
		em.getTransaction().begin();
		em.persist(pub);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
