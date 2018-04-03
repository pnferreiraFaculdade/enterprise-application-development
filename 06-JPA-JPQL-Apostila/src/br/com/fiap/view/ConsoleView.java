package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		List<Cidade> lista = cidadeDao.listar();
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		List<Cidade> lista2 = cidadeDao.buscarPorEstado("SP");
		for (Cidade cidade : lista2) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> lista3 = clienteDao.buscarPorEstado("BA");
		for (Cliente cliente : lista3) {
			System.out.println(cliente.getEndereco().getCidade().getUf());
		}
		
		List<Cliente> lista4 = clienteDao.listar();
		for (Cliente cliente : lista4) {
			System.out.println(cliente.getEndereco().getCidade().getUf());
		}
		
		List<Cliente> lista5 = clienteDao.buscarPorQtDiasReserva(10);
		for (Cliente cliente : lista5) {
			System.out.println(cliente.getNome());
		}
		
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		Transporte t = transporteDao.pesquisar(1);
		List<Pacote> lista6 = pacoteDao.buscarPorTransporte(t);
		for (Pacote pacote : lista6) {
			System.out.println(pacote.getTransporte().getEmpresa());
		}
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2017); 
		c1.set(Calendar.MONTH, Calendar.AUGUST); 
		c1.set(Calendar.DAY_OF_MONTH, 20);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2018); 
		c2.set(Calendar.MONTH, Calendar.MARCH); 
		c2.set(Calendar.DAY_OF_MONTH, 20);
		List<Pacote> lista7 = pacoteDao.buscarPorDatas(c1 , c2);
		for (Pacote pacote : lista7) {
			System.out.println(pacote.getDescricao());
		}
		
		List<Cliente> lista8 = clienteDao.buscar("a", "Salvador");
		for (Cliente cliente : lista8) {
			System.out.println(cliente.getNome() + " " + cliente.getEndereco().getCidade().getNome());
		}
		List<String> es = new ArrayList<>();
		es.add("SP");
		es.add("BA");
		List<Cliente> lista9 = clienteDao.buscarPorEstados(es);
		for (Cliente cliente : lista9) {
			System.out.println(cliente.getEndereco().getCidade().getUf());
		}
		
		em.close();
		factory.close();
	}

}



