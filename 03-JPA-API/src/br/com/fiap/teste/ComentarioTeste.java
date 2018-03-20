package br.com.fiap.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.impl.ComentarioDAOImpl;
import br.com.fiap.entity.Comentario;
import br.com.fiap.exception.CommitException;

public class ComentarioTeste {

	public static void main(String[] args) throws CommitException {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em  = factory.createEntityManager();
		
		Comentario c = new Comentario(Calendar.getInstance(), "Essa aula é legal!");
		
		ComentarioDAOImpl dao = new ComentarioDAOImpl(em);
		
		dao.cadastrar(c);
		dao.commit();
		factory.close();
	}

}
