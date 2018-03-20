package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EXJPA_EDITORA")
@SequenceGenerator(name="editora", sequenceName="SQ_T_EXJPA_EDITORA", allocationSize=1)
public class Editora {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator="editora", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="cnpj", nullable = false, length=100)
	private String cnpj;
	@Column(name="nome", nullable = false, length=300)
	private String nome;
	@Column(name="endereco", length=400)
	private String endereco;
	
	public Editora() {
		super();
	}
	
	public Editora(String cnpj, String nome, String endereco) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
}
