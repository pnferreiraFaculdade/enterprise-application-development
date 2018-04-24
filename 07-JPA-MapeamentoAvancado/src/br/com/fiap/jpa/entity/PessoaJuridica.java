package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_MA_PESSOA_JURIDICA")
public class PessoaJuridica {
	@Column(name="nr_cnpj")
	private long cnpj;
	@Column(name="nm_fantasia")
	private String nomeFantasia;
	public PessoaJuridica(long cnpj, String nomeFantasia) {
		super();
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}
	public PessoaJuridica() {
		super();
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
	
}
