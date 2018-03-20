package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRI_TECNICO")
@SequenceGenerator(allocationSize = 1, name ="tec", sequenceName = "SQ_T_JRI_TECNICO")
public class Tecnico {
	@Id
	@Column(name = "cd_tecnico")
	@GeneratedValue(generator = "tec", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_tecnico", length = 250, nullable = false)
	private String nome;
	@Column(name = "st_capacitacao", nullable = false)
	private boolean capacitacao;
	@OneToOne(mappedBy = "tecnico")
	private Time time;
	
	public Tecnico(String nome, boolean capacitacao) {
		super();
		this.nome = nome;
		this.capacitacao = capacitacao;
	}
	
	public Tecnico() {
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
	public boolean isCapacitacao() {
		return capacitacao;
	}
	public void setCapacitacao(boolean capacitacao) {
		this.capacitacao = capacitacao;
	}
	
	
}
