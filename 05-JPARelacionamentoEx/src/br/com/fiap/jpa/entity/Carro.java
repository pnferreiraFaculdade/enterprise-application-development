package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_JRE_CARRO")
public class Carro {
	@Id
	@Column(name = "nr_renavan")
	private int numRenavan;
	@Column(name = "ds_cor", nullable = false, length = 50)
	private String cor;
	@Column(name = "nr_ano", nullable = false)
	private int ano;
	
	@ManyToOne
	@JoinColumn(name = "cd_proprietario")
	Proprietario proprietario;
	@ManyToMany(mappedBy = "carros")
	List<Motorista> motoristas;
	@OneToOne(mappedBy = "carro")
	Placa placa;
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public List<Motorista> getMotoristas() {
		return motoristas;
	}
	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}
	public Placa getPlaca() {
		return placa;
	}
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	
	
	public Carro(int numRenavan, String cor, int ano) {
		super();
		this.numRenavan = numRenavan;
		this.cor = cor;
		this.ano = ano;
	}
	public Carro() {
		super();
	}
	public int getNumRenavan() {
		return numRenavan;
	}
	public void setNumRenavan(int numRenavan) {
		this.numRenavan = numRenavan;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
