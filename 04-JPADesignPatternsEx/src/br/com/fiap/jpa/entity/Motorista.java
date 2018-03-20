package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "T_JAIE_MOTORISTA")
public class Motorista {
	@Id
	@Column(name = "nr_carteira")
	private int numCarteira;
	@Column(name = "nm_motorista", nullable = false, length = 150)
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private Calendar dtNascimento;
	@Lob
	@Column(name = "fl_carteira")
	private byte[] foto;
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_sexo")
	private Sexo sexo;
	public Motorista(int numCarteira, String nome, Calendar dtNascimento, byte[] foto, Sexo sexo) {
		super();
		this.numCarteira = numCarteira;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.foto = foto;
		this.sexo = sexo;
	}
	public Motorista() {
		super();
	}
	public int getNumCarteira() {
		return numCarteira;
	}
	public void setNumCarteira(int numCarteira) {
		this.numCarteira = numCarteira;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
	
}
