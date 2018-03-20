package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRI_JOGADOR")
@SequenceGenerator(allocationSize = 1, name = "jog", sequenceName = "SQ_T_JRI_JOGADOR")
public class Jogador {
	@Id
	@Column(name = "cd_jogador")
	@GeneratedValue(generator = "jog", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_jogador", length = 250, nullable = false)
	private String nome;
	@Column(name = "vl_salario", nullable = false)
	private double salario;
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_posicao")
	private Posicao posicao;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_time")
	private Time time;
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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Jogador(String nome, double salario, Posicao posicao) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.posicao = posicao;
	}
	public Jogador() {
		super();
	}
	
	
}
