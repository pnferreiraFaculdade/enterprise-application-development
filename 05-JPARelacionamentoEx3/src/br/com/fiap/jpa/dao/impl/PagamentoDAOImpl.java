package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.PagamentoDAO;
import br.com.fiap.jpa.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public double somarPorPassageiro(int p) {
		// TODO Auto-generated method stub
		return em.createQuery("select sum(p.valor) from Pagamento p where p.corrida.passageiro.codigo = :pag", Double.class).setParameter("pag", p).getSingleResult();
	}

}
