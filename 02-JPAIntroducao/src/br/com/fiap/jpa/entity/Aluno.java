package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_INTJPA_ALUNO")
@SequenceGenerator(name="aluno", sequenceName="SQ_T_INTJPA_ALUNO", allocationSize=1)
public class Aluno implements Serializable{
	@Id
	@Column(name="cd_aluno", nullable = false)
	@GeneratedValue(generator="aluno", strategy = GenerationType.SEQUENCE)
	private int codigo; //PK
	
	@Column(name="nm_aluno", nullable = false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_matricula", nullable = false)
	private Calendar dataMatricula;

	@Column(name = "ds_bolsista", nullable = false)
	private boolean bolsista;
	
	@Column(name = "vl_desconto")
	private int desconto;
	
	@Column(name = "ds_turma")
	private String turma;
	
	@Column(name = "vl_media")
	private float media;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_sexo")
	private Sexo sexo;

	@Transient
	private float mensalidade;
	
	@Lob
	@Column(name="ds_foto")
	private byte[] foto;

	
	public Aluno() {
		super();
	}
	
	
	public Aluno(String nome, Calendar dataMatricula, boolean bolsista, int desconto, String turma,
			float media, Sexo sexo, float mensalidade, byte[] foto) {
		super();
		this.nome = nome;
		this.dataMatricula = dataMatricula;
		this.bolsista = bolsista;
		this.desconto = desconto;
		this.turma = turma;
		this.media = media;
		this.sexo = sexo;
		this.mensalidade = mensalidade;
		this.foto = foto;
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

	public Calendar getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Calendar dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public boolean isBolsista() {
		return bolsista;
	}

	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
	
	
}
