package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.PlacaDAO;
import br.com.fiap.jpa.entity.Placa;

public class PlacaDAOImpl extends GenericDAOImpl<Placa, Integer> implements PlacaDAO{

	public PlacaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
