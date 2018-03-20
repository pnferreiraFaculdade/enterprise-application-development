package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRE_MOTORISTA")
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_T_JRE_MOTORISTA", name = "mot")
public class Motorista {
	@Id
	@Column(name = "cd_motorista")
	@GeneratedValue(generator = "mot", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_motorista", nullable = false)
	private String nome;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "nr_renavan"), inverseJoinColumns = @JoinColumn(name = "cd_motorista"))
	List<Carro> carros;
	public Motorista(String nome, List<Carro> carros) {
		super();
		this.nome = nome;
		this.carros = carros;
	}
	public Motorista() {
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
	
}
