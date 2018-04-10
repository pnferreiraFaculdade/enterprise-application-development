package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte t) {
		// TODO Auto-generated method stub
		TypedQuery<Pacote> query = em.createQuery("from Pacote where transporte = :t", Pacote.class);
		query.setParameter("t", t);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		// TODO Auto-generated method stub
		TypedQuery<Pacote> query = em.createQuery("from Pacote where dataSaida between :inicio and :fim", Pacote.class);
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		return query.getResultList();
	}

	@Override
	public double mediaPreco() {
		// TODO Auto-generated method stub
		return em.createQuery("select avg(p.preco) from Pacote p", Double.class).getSingleResult();
	}

}
