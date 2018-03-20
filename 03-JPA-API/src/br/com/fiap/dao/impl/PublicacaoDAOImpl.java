package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PublicacaoDAO;
import br.com.fiap.entity.Publicacao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;

public class PublicacaoDAOImpl implements PublicacaoDAO{

	private EntityManager em;
	
	public PublicacaoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void cadastrar(Publicacao pub) {
		em.persist(pub);
	}

	@Override
	public Publicacao buscar(int codigo) {
		Publicacao p = em.find(Publicacao.class, codigo);
		return p;
	}

	@Override
	public void modificar(Publicacao pub) {
		em.merge(pub);
	}

	@Override
	public void apagar(int codigo) throws FindException {
		Publicacao p = buscar(codigo);
		if(p == null)
			throw new FindException("Registro não encontrado");
		em.remove(p);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		} 
	}

}
