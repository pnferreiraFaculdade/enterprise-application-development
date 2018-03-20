package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public interface MotoristaDAO {

	void cadastrar(Motorista m);
	
	Motorista buscar(int codigo);
	
	void modificar(Motorista m);
	
	void apagar(int codigo) throws FindException;
	
	void commit() throws CommitException;
	
}
