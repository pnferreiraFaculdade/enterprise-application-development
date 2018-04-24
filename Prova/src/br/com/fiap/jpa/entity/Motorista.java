package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NR_MOTORISTA")
public class Motorista {
	@Id
	@Column(name="nr_carteira")
	private long numeroCarteira;
	@Column(name="nm_motorista", length=150, nullable=false)
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	@Lob
	@Column(name="fl_carteira")
	private byte[] flCarteira;
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	@OneToMany(mappedBy="motorista", cascade=CascadeType.PERSIST)
	private List<Corrida> corridas = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_NR_VEICULO_MOTORISTA", joinColumns= {@JoinColumn(name="cd_motorista")}, 
		inverseJoinColumns= {@JoinColumn(name="cd_veiculo")})
	private List<Veiculo> veiculos;
	
	public void addCorridas(Corrida c) {
		c.setMotorista(this);
		corridas.add(c);
	}
	
	
	public Motorista(long numeroCarteira, String nome, Calendar dataNascimento, byte[] flCarteira, Genero genero,
			List<Veiculo> veiculos) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.flCarteira = flCarteira;
		this.genero = genero;
		this.veiculos = veiculos;
	}


	public Motorista(long numeroCarteira, String nome, Calendar dataNascimento, byte[] flCarteira, Genero genero) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.flCarteira = flCarteira;
		this.genero = genero;
	}
	
	public Motorista() {
		super();
	}
	
	public long getNumeroCarteira() {
		return numeroCarteira;
	}
	public void setNumeroCarteira(long numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
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
	public byte[] getFlCarteira() {
		return flCarteira;
	}
	public void setFlCarteira(byte[] flCarteira) {
		this.flCarteira = flCarteira;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public List<Corrida> getCorridas() {
		return corridas;
	}


	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}


	public List<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
