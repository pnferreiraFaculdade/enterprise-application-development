package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Autor;
import br.com.fiap.jpa.entity.Editora;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.entity.Sexo;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autor autor = new Autor("Nome", Sexo.MASCULINO, "do cara", new GregorianCalendar(1999, Calendar.MARCH, 12));
		Livro livro = new Livro("Um menino na varanda", 34.55f, new GregorianCalendar(1934, Calendar.MARCH, 30) , null);
		Editora editora = new Editora("467843292", "Editora bosta", null);
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2tdsa2");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(autor);
		em.persist(livro);
		em.persist(editora);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
		
	}

}
