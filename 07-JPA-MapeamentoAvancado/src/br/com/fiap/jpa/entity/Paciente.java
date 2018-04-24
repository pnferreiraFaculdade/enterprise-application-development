package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
@Table(name="T_MA_PACIENTE")
@SequenceGenerator(allocationSize=1, name="paciente", sequenceName="SQ_T_MA_PACIENTE")
public class Paciente {
	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="nm_paciente", nullable=false)
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	
	
	public Paciente(String nome, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	public Paciente() {
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
