package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		// TODO Auto-generated method stub
		TypedQuery<Cidade> query = em.createQuery("from Cidade", Cidade.class);
		return query.getResultList();
	}

	@Override
	public List<Cidade> buscarPorEstado(String estado) {
		// TODO Auto-generated method stub
		TypedQuery<Cidade> query = em.createQuery("from Cidade where uf = :nmEst", Cidade.class);
		query.setParameter("nmEst", estado);
		
		return query.getResultList();
	}

}
