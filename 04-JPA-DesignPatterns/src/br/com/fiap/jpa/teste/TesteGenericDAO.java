package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.EmpresaDAOImpl;
import br.com.fiap.jpa.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.jpa.entity.Empresa;
import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteGenericDAO {

	public static void main(String[] args) throws CommitException {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		Funcionario f = new Funcionario("Poliana", "Presidente");
		Empresa e = new Empresa("7657657657576755", "BumBum", 12354354.85f);
		
		FuncionarioDAOImpl daoFunc = new FuncionarioDAOImpl(em);
		EmpresaDAOImpl daoEmp = new EmpresaDAOImpl(em);
		
		daoFunc.cadastrar(f); 
		daoEmp.cadastrar(e);
		
		System.out.println(daoFunc.buscar(f.getCodigo()).getNome());
		System.out.println(daoEmp.buscar(e.getCnpj()).getNome());
		
		daoFunc.commit();
		em.close();
		factory.close();

	}

}
