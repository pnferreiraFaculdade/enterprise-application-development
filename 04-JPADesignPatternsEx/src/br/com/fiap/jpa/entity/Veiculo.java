package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_JAIE_VEICULO")
@SequenceGenerator(name = "veiculo", sequenceName = "SQ_T_JAIE_VEICULO", allocationSize = 1)
public class Veiculo {
	@Id
	@Column(name = "cd_codigo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "ds_placa", nullable = false, length = 9)
	private String placa;
	@Column(name = "ds_cor", nullable = false, length = 20)
	private String cor;
	@Column(name = "nr_ano")
	private int ano;
	
	public Veiculo(String placa, String cor, int ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}
	public Veiculo() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
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
