package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public interface VeiculoDAO {
	
	void cadastrar(Veiculo v);
	
	Veiculo buscar(int codigo);
	
	void modificar(Veiculo v);
	
	void apagar(int codigo) throws FindException;
	
	void commit() throws CommitException;
	
}
