package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public interface GenericDAO<Tabela, Chave> {

	void cadastrar(Tabela tabela);
	
	Tabela buscar(Chave codigo);
	
	void modificar(Tabela tabela);
	
	void excluir(Chave codigo) throws FindException;
	
	void commit() throws CommitException;
}
