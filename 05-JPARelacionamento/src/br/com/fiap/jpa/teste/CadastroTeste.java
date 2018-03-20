package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.TecnicoDAOImpl;
import br.com.fiap.jpa.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Patrocinio;
import br.com.fiap.jpa.entity.Posicao;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import oracle.net.aso.t;

public class CadastroTeste {

	public static void main(String[] args) throws CommitException {
		
	EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	EntityManager em = fabrica.createEntityManager();
	
	Tecnico tec = new Tecnico("Poliana", true);
	Time time = new Time("Bum", 535435435, tec);

	Jogador jog1 = new Jogador("Thigao", 1233.4f, Posicao.GOLEIRO);
	Jogador jog2 = new Jogador("Thiago", 123333.4f, Posicao.ATACANTE);
	Jogador jog3 = new Jogador("Thiti", 12333.4f, Posicao.LATERAL);
	time.addJogador(jog1);
	time.addJogador(jog2);
	time.addJogador(jog3);
	
	Patrocinio p1 = new Patrocinio("Kaka", 543543543);
	Patrocinio p2 = new Patrocinio("Kiki", 78);
	
	List<Patrocinio> patrocinios = new ArrayList<>();
	patrocinios.add(p1);
	patrocinios.add(p2);
	
	time.setPatrocinios(patrocinios);
				
	TecnicoDAOImpl daoTec = new TecnicoDAOImpl(em);
	TimeDAOImpl daoTime = new TimeDAOImpl(em);
	
	daoTec.cadastrar(tec);
	daoTime.cadastrar(time);
	daoTec.commit();
	em.close();
	fabrica.close();
	
	}

	
	
}
