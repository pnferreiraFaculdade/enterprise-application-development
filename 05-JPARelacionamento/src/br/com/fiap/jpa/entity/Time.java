package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRI_TIME")
@SequenceGenerator(allocationSize = 1, name = "time", sequenceName = "SQ_T_JRI_TIME")
public class Time {
	@Id
	@Column(name = "cd_time")
	@GeneratedValue(generator = "time", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_time", length = 250, nullable = false)
	private String nome;
	@Column(name = "nr_socio", nullable = false)
	private long numeroSocio;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_tecnico")
	private Tecnico tecnico;
	
	public Time(String nome, long numeroSocio, Tecnico tecnico, List<Patrocinio> patrocinios) {
		super();
		this.nome = nome;
		this.numeroSocio = numeroSocio;
		this.tecnico = tecnico;
		this.patrocinios = patrocinios;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public List<Patrocinio> getPatrocinios() {
		return patrocinios;
	}
	public void setPatrocinios(List<Patrocinio> patrocinios) {
		this.patrocinios = patrocinios;
	}

	@OneToMany(mappedBy = "time", cascade=CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "t_patrocinio_time", joinColumns = @JoinColumn(name = "cd_time"), inverseJoinColumns = @JoinColumn(name = "cd_patrocinio"))
	private List<Patrocinio> patrocinios;
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		jogador.setTime(this);
	}
	public Time(String nome, long numeroSocio, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.numeroSocio = numeroSocio;
		this.tecnico = tecnico;
	}
	
	public Time() {
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
	public long getNumeroSocio() {
		return numeroSocio;
	}
	public void setNumeroSocio(long numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	
}
