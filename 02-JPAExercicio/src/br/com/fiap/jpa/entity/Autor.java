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
@Table(name="T_EXJPA_AUTOR")
@SequenceGenerator(name="autor", sequenceName="SQ_T_EXJPA_AUTOR", allocationSize=1)
public class Autor {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator="autor", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name="nome", nullable = false, length=300)
	private String nome;
	@Enumerated()
	@Column(name="sexo", nullable = false)
	private Sexo sexo;
	@Column(name="sobrenome", nullable = false, length=300)
	private String sobrenome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento", nullable = false)
	private Calendar dtNascimento;
	
	public Autor() {
		super();
	}
	
	public Autor(String nome, Sexo sexo, String sobrenome, Calendar dtNascimento) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
}
