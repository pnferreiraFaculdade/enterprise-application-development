package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public interface GenericDAO<Tabela, Chave>{
	
	public void cadastrar(Tabela t);
	public Tabela buscar(Chave c);
	public void modificar(Tabela t);
	public void apagar(Chave c) throws FindException;
	public void commit() throws CommitException;

}
