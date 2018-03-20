package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_JAIE_PAGAMENTO")
@SequenceGenerator(name = "pag", sequenceName = "SQ_T_JAIE_PAGAMENTO", allocationSize = 1)
public class Pagamento {
	@Id
	@Column(name = "cd_pagamento")
	@GeneratedValue(generator = "pag", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pagamento", nullable = false )
	private Calendar data;
	@Column(name = "vl_pagamento", nullable = false)
	private float valor;
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_forma_pagamento", nullable = false)
	private FormaPag descricaoForma;
	public Pagamento(Calendar data, float valor, FormaPag descricaoForma) {
		super();
		this.data = data;
		this.valor = valor;
		this.descricaoForma = descricaoForma;
	}
	public Pagamento() {
		super();
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
	public FormaPag getDescricaoForma() {
		return descricaoForma;
	}
	public void setDescricaoForma(FormaPag descricaoForma) {
		this.descricaoForma = descricaoForma;
	}
	
	
}
