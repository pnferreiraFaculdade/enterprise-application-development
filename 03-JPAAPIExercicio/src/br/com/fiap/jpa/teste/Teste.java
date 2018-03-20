package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Sexo;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FindException;

public class Teste {

	public static void main(String[] args) throws CommitException, FindException {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		
		Motorista m = new Motorista(654645654, "Poliana", new GregorianCalendar(2017,  Calendar.JANUARY, 29), null, Sexo.FEMININO);
		Veiculo v = new Veiculo("POW-1234", "Preto", 2016);
		
		MotoristaDAOImpl daoMot = new MotoristaDAOImpl(em);
		VeiculoDAOImpl daoVeic = new VeiculoDAOImpl(em);
		
		daoMot.cadastrar(m);
		daoVeic.cadastrar(v);
		
		System.out.println(daoMot.buscar(m.getNumCarteira()));
		System.out.println(daoVeic.buscar(v.getCodigo()));
		
		m.setNome("Poliana Ferreira");
		daoMot.modificar(m);
		v.setAno(2017);
		daoVeic.modificar(v);
		
		System.out.println(daoMot.buscar(m.getNumCarteira()).getNome());
		System.out.println(daoVeic.buscar(v.getCodigo()).getCor());
		
		daoMot.apagar(m.getNumCarteira());
		daoVeic.apagar(v.getCodigo());
		daoMot.commit();
		daoVeic.commit();
		
		em.close();
		factory.close();
	}

}
