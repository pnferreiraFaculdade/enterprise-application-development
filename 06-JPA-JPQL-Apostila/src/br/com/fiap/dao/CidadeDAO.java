package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cidade;

public interface CidadeDAO extends GenericDAO<Cidade,Integer>{

	public List<Cidade> listar();
	
	public List<Cidade> buscarPorEstado(String estado);
	
}
