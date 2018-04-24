package br.com.fiap.jpa.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.entity.Corrida;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Corrida> buscarPorData(Calendar incio, Calendar fim) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Corrida.buscarPorData", Corrida.class).setParameter("i", incio).setParameter("f", fim).getResultList();
	}

}
