package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	public List<Pacote> buscarPorTransporte(Transporte t);
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	public double mediaPreco();
	List<Pacote> buscarPorDescricao(String desc);
}
