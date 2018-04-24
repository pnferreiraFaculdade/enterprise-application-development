package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.jpa.entity.Motorista;

public interface MotoristaDAO extends GenericDAO<Motorista, Long>{
	public List<Motorista> buscarPorNome(String nome);
	
	
}
