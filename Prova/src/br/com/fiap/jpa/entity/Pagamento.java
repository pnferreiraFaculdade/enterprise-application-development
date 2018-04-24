package br.com.fiap.jpa.entity;

import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NR_PAGAMENTO")
@SequenceGenerator(allocationSize=1, name="pag", sequenceName="SQ_T_NR_PAGAMENTO")
public class Pagamento {
	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(generator="pag", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pagamento", nullable=false)
	private Calendar dataPagamento;
	@Column(name="vl_pagamento", nullable=false)
	private float valorPagamento;
	@Enumerated(EnumType.STRING)
	@Column(name="ds_forma_pagamento", nullable=false)
	private FormaPagamento formaPagamento;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_corrida")
	private Corrida corrida;
	
	public Pagamento() {
		super();
	}
	public Pagamento(Calendar dataPagamento, float valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Calendar getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public float getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Pagamento(Calendar dataPagamento, float valorPagamento, FormaPagamento formaPagamento, Corrida corrida) {
		super();
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
		this.corrida = corrida;
	}
	public Corrida getCorrida() {
		return corrida;
	}
	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
	
	
	
}
