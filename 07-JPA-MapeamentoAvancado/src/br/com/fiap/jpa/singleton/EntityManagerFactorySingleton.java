package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory factory;
	private EntityManagerFactorySingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static EntityManagerFactory getInstance() {
		if(factory == null)
			factory = Persistence.createEntityManagerFactory("oracle");
		return factory;
	}
	
	
}
