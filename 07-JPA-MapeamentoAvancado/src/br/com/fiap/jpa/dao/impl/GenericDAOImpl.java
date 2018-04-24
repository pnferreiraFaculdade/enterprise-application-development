package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public class GenericDAOImpl<Tabela, Chave> implements GenericDAO<Tabela, Chave>{

	protected EntityManager em;
	private Class<Tabela> cls;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		cls = (Class<Tabela>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(Tabela t) {
		// TODO Auto-generated method stub
		em.persist(t);
	}

	@Override
	public Tabela buscar(Chave c) {
		// TODO Auto-generated method stub
		return em.find(cls, c);
	}

	@Override
	public void modificar(Tabela t) {
		// TODO Auto-generated method stub
		em.merge(t);
	}

	@Override
	public void apagar(Chave c) throws FindException {
		// TODO Auto-generated method stub
		Tabela t = buscar(c);
		if(t == null)
			throw new FindException();
		em.remove(c);
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
}
