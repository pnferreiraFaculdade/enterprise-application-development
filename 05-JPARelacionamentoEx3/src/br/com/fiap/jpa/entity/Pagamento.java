package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_JRE3_PAGAMENTO")
public class Pagamento {
	@Id
	@Column(name = "cd_pagamento")
	private int codigo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pagamento", nullable = false)
	private Calendar data;
	@Column(name = "vl_pagamento", nullable = false)
	private float valor;
	@Column(name = "ds_forma_pagamento", nullable = false)
	private String formaPag;
	@OneToOne
	@JoinColumn(name = "cd_corrida")
	private Corrida corrida;
	public Pagamento(int codigo, Calendar data, float valor, String formaPag) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
		this.formaPag = formaPag;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getFormaPag() {
		return formaPag;
	}
	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}
	public Corrida getCorrida() {
		return corrida;
	}
	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
}
