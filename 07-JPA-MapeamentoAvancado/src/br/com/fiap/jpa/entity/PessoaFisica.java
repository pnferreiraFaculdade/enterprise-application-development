package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_MA_PESSOA_FISICA")
public class PessoaFisica extends Pessoa{
	@Column(name="nr_cpf")
	private long cpf;
	@Column(name="ds_sexo")
	private Sexo sexo;
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public PessoaFisica(long cpf, Sexo sexo) {
		super();
		this.cpf = cpf;
		this.sexo = sexo;
	}
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
		super();
	}
	
}
