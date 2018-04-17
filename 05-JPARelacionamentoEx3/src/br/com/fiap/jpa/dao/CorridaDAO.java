package br.com.fiap.jpa.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;

public interface CorridaDAO extends GenericDAO<Corrida, Integer>{

	List<Corrida> buscarPorData(Calendar inicio, Calendar fim);
	List<Corrida> buscarPorMotorista(Motorista m);
	long buscarPorPassageiro(int codigo);
	List<Corrida> buscarPorNomePassageiro(String nome);
	long contarPorMotoristaEData(int codigo, Calendar inicio, Calendar fim);
	List<Corrida> buscarPor10MaxDePassageiro(int p);
	List<Corrida> buscarPorMotoristaEPassageiro(int p, int m);
}
