package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProprietarioDAO;
import br.com.fiap.jpa.entity.Proprietario;

public class ProprietarioDAOImpl extends GenericDAOImpl<Proprietario, Integer> implements ProprietarioDAO{

	public ProprietarioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
