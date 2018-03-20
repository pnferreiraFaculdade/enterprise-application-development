package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRE_PLACA")
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_T_JRE_PLACA", name = "placa")
public class Placa {
	@Id
	@Column(name = "cd_placa")
	@GeneratedValue(generator = "placa", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nr_placa", nullable = false)
	private String numero;
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_pais", nullable = false)
	private Pais pais;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "nr_renavan")
	Carro carro;
	public Placa(String numero, Pais pais, Carro carro) {
		super();
		this.numero = numero;
		this.pais = pais;
		this.carro = carro;
	}
	public Placa() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
