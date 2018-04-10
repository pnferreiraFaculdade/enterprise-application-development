package br.com.fiap.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}
  
	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		// TODO Auto-generated method stub
		//TypedQuery<Cliente> query = em.createQuery("from Cliente where endereco in (from Endereco where cidade in (from Cidade where uf = :estado))", Cliente.class);
		TypedQuery<Cliente> query = em.createQuery("from Cliente where endereco.cidade.uf = :estado", Cliente.class);
		query.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorQtDiasReserva(int numDias) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = em.createQuery("select cliente from Reserva r where r.numeroDias = :numDias", Cliente.class);
		query.setParameter("numDias", numDias);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		// TODO Auto-generated method stub
		
		TypedQuery<Cliente> query = em.createQuery("from Cliente where nome like :nome and endereco.cidade.nome = :cidade", Cliente.class);
		query.setParameter("nome", "%" + nome + "%");
		query.setParameter("cidade", cidade);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(Collection<String> estados) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = em.createQuery("from Cliente where endereco.cidade.uf in (:estados)", Cliente.class);
		query.setParameter("estados", estados);
		return query.getResultList();
	}

	@Override
	public long contarPorEstado(String uf) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf = :estado", Long.class).setParameter("estado", uf).getSingleResult();
	}

	@Override
	public List<Cliente> maiorReserva() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("with o as (select \r\n" + 
				"count(cd_reserva) \"count\", \r\n" + 
				"cliente_id_cliente \"cli\" \r\n" + 
				"from JPA_T_RESERVA \r\n" + 
				"group by CLIENTE_ID_CLIENTE)\r\n" + 
				"select o.\"cli\"\r\n" + 
				"from o where o.\"count\" = (select max(o.\"count\") from o);", Integer.class).getResultList();
	}

	
}







