package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.dao.impl.CorridaDAOImpl;
import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.FormaPagamento;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Pagamento;
import br.com.fiap.jpa.entity.Passageiro;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		try {
			
			Veiculo v1 = new Veiculo("FRD-1234", "azul", 1987);
			Veiculo v2 = new Veiculo("POL-9876", "preto", 2017);
			Veiculo v3 = new	Veiculo("RTF-8833", "vermelho", 2000);
			
			Motorista m1 = new Motorista(23456789l, "Zuzu Gemea", new GregorianCalendar(1999, Calendar.JANUARY, 29),null , Genero.FEMININO);
			Motorista m2 = new Motorista(33456789l, "Thiago", new GregorianCalendar(1997, Calendar.SEPTEMBER, 27),null , Genero.MASCULINO);
			Motorista m3 = new Motorista(43456789l, "Rubens", new GregorianCalendar(1967, Calendar.MARCH, 13),null , Genero.OUTROS);
			
			Corrida c1 = new Corrida("Casa", "Fiap", Calendar.getInstance(), 13.56f);
			Corrida c2 = new Corrida("Fiap", "212 burger", new GregorianCalendar(2018, Calendar.APRIL, 1), 29.00f);
			Corrida c3 = new Corrida("Casa", "Fiap", new GregorianCalendar(2017, Calendar.APRIL, 21), 12.30f);
			
			Passageiro poli = new Passageiro("Poliana", new GregorianCalendar(1999, Calendar.JANUARY, 29), Genero.FEMININO);
			poli.addCorrida(c1);
			poli.addCorrida(c2);
			poli.addCorrida(c3);
			
			Pagamento pag1 = new Pagamento(Calendar.getInstance(), 13.56f, FormaPagamento.DINHEIRO);
			Pagamento pag2 = new Pagamento(new GregorianCalendar(2018, Calendar.APRIL, 1), 29.00f, FormaPagamento.DINHEIRO);
			Pagamento pag3 = new Pagamento(new GregorianCalendar(2017, Calendar.APRIL, 21), 12.30f, FormaPagamento.DINHEIRO);
			
			c1.setPagamento(pag1);
			c2.setPagamento(pag2);
			c3.setPagamento(pag3);
			m1.addCorridas(c1);
			m1.addCorridas(c2);
			m2.addCorridas(c3);
			
			List<Veiculo> vm1 = new ArrayList<>();
			vm1.add(v1);
			vm1.add(v2);
			List<Veiculo> vm2 = new ArrayList<>();
			vm2.add(v2);
			vm2.add(v3);
			List<Veiculo> vm3 = new ArrayList<>();
			vm3.add(v3);
			
			m1.setVeiculos(vm1);
			
			m2.setVeiculos(vm2);
			m3.setVeiculos(vm3);
			
			VeiculoDAO daoVei = new VeiculoDAOImpl(em);
			MotoristaDAO daoMot = new MotoristaDAOImpl(em);
			CorridaDAO daoCor = new CorridaDAOImpl(em);
			daoCor.cadastrar(c1);
			daoCor.cadastrar(c2);
			daoCor.cadastrar(c3);
			
			daoCor.commit();
			
			System.out.println(daoMot.buscar(23456789l).getNome());
			System.out.println(daoVei.buscar(1).getAno());
			Veiculo vMudar = daoVei.buscar(1);
			vMudar.setAno(1988);
			daoVei.modificar(vMudar);
			daoVei.commit();
			System.out.println(daoVei.buscar(1).getAno());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
			factory.close();
		}
	}
}