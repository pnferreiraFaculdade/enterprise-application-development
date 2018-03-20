package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_EXJPA_LIVRO")
@SequenceGenerator(name="livro", sequenceName="SQ_T_EXJPA_LIVRO", allocationSize=1)
public class Livro {
	@Id
	@Column(name = "isbn", nullable = false)
	@GeneratedValue(generator="livro", strategy = GenerationType.SEQUENCE)
	private int isbn;
	@Column(name="titulo", nullable = false, length=200)
	private String titulo;
	@Column(name="preco")
	private float preco;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_lancamento")
	private Calendar dtLancamento;
	@Lob
	@Column(name = "capa")
	private byte[] capa;
	
	public Livro() {
		super();
	}
	
	public Livro(String titulo, float preco, Calendar dtLancamento, byte[] capa) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.dtLancamento = dtLancamento;
		this.capa = capa;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Calendar getDtLancamento() {
		return dtLancamento;
	}
	public void setDtLancamento(Calendar dtLancamento) {
		this.dtLancamento = dtLancamento;
	}
	public byte[] getCapa() {
		return capa;
	}
	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	
	
	
}
