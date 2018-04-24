package br.com.fiap.jpa.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.jpa.entity.Corrida;

public interface CorridaDAO extends GenericDAO<Corrida, Integer>{
	public List<Corrida> buscarPorData(Calendar incio, Calendar fim);
}
