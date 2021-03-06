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
@Table(name = "T_JRE3_VEICULO")
@SequenceGenerator(allocationSize = 1, name = "veiculo", sequenceName = "SQ_T_JRE3_VEICULO")
public class Veiculo {
	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "ds_placa", length = 9, nullable = false)
	private String placa;
	@Column(name = "ds_cor", length = 20, nullable = false)
	private String cor;
	@Column(name = "nr_ano")
	private int ano;
	
	@ManyToMany(mappedBy = "veiculos")
	List<Motorista> motoristas;

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public Veiculo( String placa, String cor, int ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
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

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}
	
	
	
	
}
