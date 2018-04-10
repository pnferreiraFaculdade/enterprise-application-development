package br.com.fiap.dao;

import java.util.Collection;
import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	public List<Cliente> listar();
	public List<Cliente> buscarPorEstado(String estado);
	public List<Cliente> buscarPorQtDiasReserva(int numDias);
	public List<Cliente> buscar(String nome, String cidade);
	public List<Cliente> buscarPorEstados(Collection<String> estados);

	public long contarPorEstado(String uf); 
	public List<Cliente> maiorReserva();

}