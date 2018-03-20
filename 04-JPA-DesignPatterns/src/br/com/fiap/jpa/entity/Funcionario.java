package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JDP_FUNCIONARIO")
@SequenceGenerator(name = "func", sequenceName = "SQ_T_JDP_FUNCIONARIO", allocationSize = 1)
public class Funcionario {
	@Id
	@Column(name = "cd_funcionario")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_funcionario", length = 100, nullable = false)
	private String nome;
	@Column(name = "ds_cargo", length = 20)
	private String cargo;
	public Funcionario(String nome, String cargo) {
		super();
		this.nome = nome;
		this.cargo = cargo;
	}
	public Funcionario() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
