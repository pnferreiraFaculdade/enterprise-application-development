package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRE_PROPRIEARIO")
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_T_JRE_PROPRIETARIO", name = "prop")
public class Proprietario {
	@Id
	@Column(name = "cd_propietario")
	@GeneratedValue(generator = "prop", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_propietario")
	private String nome;
	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.PERSIST)
	List<Carro> carros =  new ArrayList<Carro>();
	
	public void addCarro(Carro c) {
		carros.add(c);
		c.setProprietario(this);
	}
	
	public Proprietario(String nome) {
		super();
		this.nome = nome;
	}
	public Proprietario() {
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
