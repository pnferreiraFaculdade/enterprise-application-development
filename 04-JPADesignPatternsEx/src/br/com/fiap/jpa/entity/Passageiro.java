package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_JAIE_PASSAGEIRO")
@SequenceGenerator(allocationSize = 1, name = "passageiro", sequenceName = "SQ_T_JAIE_PASSAGEIRO")
public class Passageiro {

	@Id
	@Column(name = "cd_passageiro")
	@GeneratedValue(generator = "passageiro", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_passageiro", nullable = false, length = 100)
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_sexo")
	private Sexo sexo;
	public Passageiro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passageiro(String nome, Calendar dataNascimento, Sexo sexo) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}
