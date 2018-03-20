package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.dao.impl.PlacaDAOImpl;
import br.com.fiap.jpa.dao.impl.ProprietarioDAOImpl;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Pais;
import br.com.fiap.jpa.entity.Placa;
import br.com.fiap.jpa.entity.Proprietario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) throws CommitException {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		Carro c1 = new Carro(456, "preto", 1987);
		Carro c2 = new Carro(457, "fhuidsghuis", 2017);
		Carro c3 = new Carro(458, "ruimmmm", 2017);
		
		Proprietario p = new Proprietario("Poliana");
		p.addCarro(c1);
		p.addCarro(c2);
		
		
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(c1);
		carros.add(c3);
		Motorista m = new Motorista("Poliana", carros);
		Placa placa = new Placa("rfe-4567", Pais.BRASIL, c1);
		
		
		ProprietarioDAOImpl daoProp = new ProprietarioDAOImpl(em);
		PlacaDAOImpl daoPlaca = new PlacaDAOImpl(em);
		MotoristaDAOImpl daoMot = new MotoristaDAOImpl(em);
		
		daoProp.cadastrar(p);
		daoPlaca.cadastrar(placa);
		daoMot.cadastrar(m);
		
		daoProp.commit();
		
		em.close();
	}

}
