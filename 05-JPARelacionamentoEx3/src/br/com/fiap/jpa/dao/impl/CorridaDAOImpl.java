package br.com.fiap.jpa.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Corrida> buscarPorData(Calendar inicio, Calendar fim) {
		// TODO Auto-generated method stub
		return em.createQuery("from Corrida where data between :i and :f", Corrida.class).setMaxResults(30).setParameter("i", inicio).setParameter("f", fim).getResultList();
	}

	@Override
	public List<Corrida> buscarPorMotorista(Motorista m) {
		// TODO Auto-generated method stub
		return em.createQuery("from Corrida where motorista = :m", Corrida.class).setParameter("m", m).getResultList();
	}

	@Override
	public long buscarPorPassageiro(int codigo) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(r) from Corrida r where r.passageiro.codigo = :c", Long.class).setParameter("c", codigo).getSingleResult();
	}

	@Override
	public List<Corrida> buscarPorNomePassageiro(String nome) {
		// TODO Auto-generated method stub
		return em.createQuery("from Corrida where passageiro.nome like :n", Corrida.class).setMaxResults(40).setParameter("n", "%"+nome+"%").getResultList();
	}

	@Override
	public long contarPorMotoristaEData(int codigo, Calendar inicio, Calendar fim) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(c) from Corrida c where c.data between :i and :f and c.motorista.numCarteira = :cod", Long.class).setParameter("i", inicio).setParameter("f", fim).setParameter("cod", codigo).getSingleResult();
	}

	@Override
	public List<Corrida> buscarPor10MaxDePassageiro(int p) {
		// TODO Auto-generated method stub
		return em.createQuery("from Corrida c where c.passageiro.codigo = :p order by c.pagamento.valor desc", Corrida.class).setMaxResults(10).setParameter("p", p).getResultList();
	}

	@Override
	public List<Corrida> buscarPorMotoristaEPassageiro(int p, int m) {
		// TODO Auto-generated method stub
		return em.createQuery("from Corrida where passageiro.codigo = :p and motorista.numCarteira = :m", Corrida.class).setParameter("p", p).setParameter("m", m).getResultList();
	}

}
