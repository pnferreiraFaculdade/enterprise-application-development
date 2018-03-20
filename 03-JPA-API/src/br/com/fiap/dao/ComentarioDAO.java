package br.com.fiap.dao;

import br.com.fiap.entity.Comentario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;

public interface ComentarioDAO {

	void cadastrar(Comentario c);
	
	Comentario buscar(int codigo);
	
	void modificar(Comentario c);
	
	void apagar(int codigo) throws FindException;
	
	void commit() throws CommitException;
	
	
}
