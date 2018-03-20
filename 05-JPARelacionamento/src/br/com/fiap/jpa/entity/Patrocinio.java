package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRI_PATROCINIO")
@SequenceGenerator(allocationSize = 1 ,name = "pat", sequenceName = "SQ_T_JRI_PATROCINIO")
public class Patrocinio {
	@Id
	@Column(name = "cd_patrocinio")
	@GeneratedValue(generator = "pat", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_patrocinio", length = 250, nullable = false)
	private String nome;
	@Column(name = "vl_patrocinio", nullable = false)
	private double valor;
	@ManyToMany(mappedBy = "patrocinios")
	List<Time> times = new ArrayList<>();
	
	public Patrocinio(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	public Patrocinio() {
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public List<Time> getTimes() {
		return times;
	}
	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	
	
}
