package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CarroDAO;
import br.com.fiap.jpa.entity.Carro;

public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer> implements CarroDAO{

	public CarroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
