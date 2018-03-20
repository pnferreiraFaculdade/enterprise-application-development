package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Periodo;
import br.com.fiap.jpa.entity.Sexo;
import br.com.fiap.jpa.entity.Turma;
import br.com.fiap.jpa.entity.Unidade;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		Aluno aluno = new Aluno("Juninho", 
				new GregorianCalendar(2017, Calendar.JANUARY, 2), 
				false, 0, "2TDSA", 2, Sexo.MASCULINO, 1500, null);
		
		Turma turma = new Turma("2TDSA", 1020.00f, 40, false, null,
				new GregorianCalendar(2017, Calendar.FEBRUARY, 15), 
				Unidade.ACLIMACAO, Periodo.MATUTINO);
		
		em.getTransaction().begin();
		em.persist(aluno);
		em.persist(turma);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
