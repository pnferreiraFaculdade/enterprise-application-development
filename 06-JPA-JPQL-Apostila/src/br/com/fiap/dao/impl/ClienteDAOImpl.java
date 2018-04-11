package br.com.fiap.dao.impl;

import java.math.BigDecimal;
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
		List<Cliente> teste =  em.createNativeQuery("with o as (select \r\n" + 
				"count(cd_reserva) \"count\", \r\n" + 
				"cliente_id_cliente \"cli\" \r\n" + 
				"from JPA_T_RESERVA \r\n" + 
				"group by CLIENTE_ID_CLIENTE)\r\n" + 
				"select * \r\n" + 
				"from JPA_T_CLIENTE where id_cliente in "
				+ "(select o.\"cli\" from o where o.\"count\" = "
				+ "(select max(o.\"count\") from o))", Cliente.class).getResultList();
		
		List<Cliente> teste2 = em.createQuery("from Cliente where id in (select r.cliente.id from Reserva r group by r.cliente.id having count(r) = (select max(count(rm)) from Reserva rm group by rm.cliente))", Cliente.class).getResultList();
		//return em.createQuery("from Cliente where id in (:ids)", Cliente.class).setParameter("ids", teste /*.stream().map(BigDecimal::intValue).collect(Collectors.toList())).getResultList();*/
		return teste2;
	}

	
}







