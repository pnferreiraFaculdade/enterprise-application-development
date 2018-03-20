package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public abstract class GenericDAOImpl<Tabela, Chave> implements GenericDAO<Tabela, Chave> {

	private EntityManager em;
	
	private Class<Tabela> cls;
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		cls = (Class<Tabela>)((ParameterizedType) 
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0] ;
	}

	@Override
	public void cadastrar(Tabela tabela) {
		// TODO Auto-generated method stub
		em.persist(tabela);
	}

	@Override
	public Tabela buscar(Chave codigo) {
		// TODO Auto-generated method stub
		Tabela t = em.find(cls, codigo);
		return t;
	}

	@Override
	public void modificar(Tabela tabela) {
		// TODO Auto-generated method stub
		em.merge(tabela);
	}

	@Override
	public void excluir(Chave codigo) throws FindException {
		// TODO Auto-generated method stub
		Tabela t = buscar(codigo);
		if(t == null)
			throw new FindException();
		
		em.remove(t);
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			throw new CommitException();
		}
	}

	
	
}
