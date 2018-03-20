package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public class MotoristaDAOImpl implements MotoristaDAO{

	EntityManager em;
	
	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void cadastrar(Motorista m) {
		// TODO Auto-generated method stub
		em.persist(m);
	}

	@Override
	public Motorista buscar(int codigo) {
		// TODO Auto-generated method stub
		Motorista m = em.find(Motorista.class, codigo);
		return m;
	}

	@Override
	public void modificar(Motorista m) {
		// TODO Auto-generated method stub
		em.merge(m);
	}

	@Override
	public void apagar(int codigo) throws FindException {
		// TODO Auto-generated method stub
		Motorista m = buscar(codigo);
		if(m == null)
			throw new FindException("Motorista não encontrado");
		em.remove(m);
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
