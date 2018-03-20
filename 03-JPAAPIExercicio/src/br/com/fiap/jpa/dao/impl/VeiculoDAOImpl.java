package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public class VeiculoDAOImpl implements VeiculoDAO{

	EntityManager em;
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void cadastrar(Veiculo v) {
		// TODO Auto-generated method stub
		em.persist(v);
	}

	@Override
	public Veiculo buscar(int codigo) {
		// TODO Auto-generated method stub
		Veiculo v = em.find(Veiculo.class, codigo);
		return v;
	}

	@Override
	public void modificar(Veiculo v) {
		// TODO Auto-generated method stub
		em.merge(v);
	}

	@Override
	public void apagar(int codigo) throws FindException {
		// TODO Auto-generated method stub
			Veiculo v = buscar(codigo);
		if (v == null)
			throw new FindException("Codigo não encontrado");
		em.remove(v);
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		try {
		em.getTransaction().begin();
		em.getTransaction().commit();
		} catch(Exception e) {
			throw new CommitException();
		}
	}

}
