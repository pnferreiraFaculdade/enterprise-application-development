package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Veiculo> buscarPorAno(int ano) {
		// TODO Auto-generated method stub
		return em.createQuery("from Veiculo where ano >= :a").setParameter("a", ano).getResultList();
	}

}
