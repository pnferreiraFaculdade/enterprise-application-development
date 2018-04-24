package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		Medico medico = new Medico(123, "Alberto", "Pediatra");
		Paciente paciente = new Paciente("Poliana", new GregorianCalendar(1999, Calendar.JANUARY, 29));
		Consulta consulta = new Consulta(Calendar.getInstance(), "Papis", false, paciente, medico);
		
		ConsultaDAO dao = new ConsultaDAOImpl(em);
		dao.cadastrar(consulta);
		try {
			dao.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		em.close();
		factory.close();
	}
	
}
