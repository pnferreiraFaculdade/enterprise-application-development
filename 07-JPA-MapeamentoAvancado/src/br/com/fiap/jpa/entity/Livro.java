package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livro {
	@Id
	@Column(name="nr_isbn")
	private long isbn;
	@Column(name="ds_titulo", nullable=false)
	private String titulo;
	//@Column(name="ds_categoria", nullable=)
	private CategoriaLivro categoria;
	private int numPaginas;
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public CategoriaLivro getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaLivro categoria) {
		this.categoria = categoria;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	
	
}
