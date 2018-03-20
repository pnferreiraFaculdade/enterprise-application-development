package br.com.fiap.dao;

import br.com.fiap.entity.Publicacao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;

public interface PublicacaoDAO {

	void cadastrar(Publicacao pub);
	
	Publicacao buscar(int codigo);
	
	void modificar(Publicacao pub);
	
	void apagar(int codigo) throws FindException;
	
	void commit() throws CommitException;
	
}
