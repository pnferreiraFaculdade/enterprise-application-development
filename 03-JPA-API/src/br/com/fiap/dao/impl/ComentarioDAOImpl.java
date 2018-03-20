package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ComentarioDAO;
import br.com.fiap.entity.Comentario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;

public class ComentarioDAOImpl implements ComentarioDAO{

	public EntityManager em;
	
	public ComentarioDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void cadastrar(Comentario c) {
		// TODO Auto-generated method stub
		em.persist(c);
	}

	@Override
	public Comentario buscar(int codigo) {
		// TODO Auto-generated method stub
		Comentario c = em.find(Comentario.class, codigo);
		return c;
	}

	@Override
	public void modificar(Comentario c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
	}

	@Override
	public void apagar(int codigo) throws FindException {
		// TODO Auto-generated method stub
		Comentario c = buscar(codigo);
		if(c == null)
			throw new FindException("Registro não encontrado");
		em.remove(c);
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new CommitException();
		}
	}

}
