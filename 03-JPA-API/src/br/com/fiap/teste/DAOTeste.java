package br.com.fiap.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.impl.PublicacaoDAOImpl;
import br.com.fiap.entity.Privacidade;
import br.com.fiap.entity.Publicacao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;

public class DAOTeste {

	public static void main(String[] args) throws CommitException, FindException {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		
		PublicacaoDAOImpl dao = new PublicacaoDAOImpl(em);
		Publicacao p = new Publicacao("Poliana", Calendar.getInstance(), null, "Cadastrei uma coisa", 0, Privacidade.PUBLICO);
		dao.cadastrar(p);
		int cod = p.getCodigo();
		System.out.println(dao.buscar(cod).getAutor());
		p.setAutor("Afe");
		dao.modificar(p);
		System.out.println(dao.buscar(cod).getAutor());
		dao.apagar(cod);
		dao.commit();
		em.close();
		factory.close();
		
		
	}

}
