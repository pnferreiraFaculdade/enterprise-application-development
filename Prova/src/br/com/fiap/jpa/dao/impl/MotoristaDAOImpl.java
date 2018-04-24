package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Long> implements MotoristaDAO{

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Motorista> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return em.createQuery("from Motorista where nome like :n", Motorista.class).setMaxResults(50).setParameter("n", "%" + nome + "%").getResultList();
	}


}
