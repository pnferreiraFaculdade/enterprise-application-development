package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_JDS_EMPRESA")
public class Empresa {
	@Id
	@Column(name = "cd_cnpj", length = 20)
	private String cnpj;
	@Column(name = "nm_empresa", length = 100, nullable = false)
	private String nome;
	@Column(name = "vl_faturamento")
	private float faturamento;
	public Empresa(String cnpj, String nome, float faturamento) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.faturamento = faturamento;
	}
	public Empresa() {
		super();
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
	public float getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}
	
	
	
}
