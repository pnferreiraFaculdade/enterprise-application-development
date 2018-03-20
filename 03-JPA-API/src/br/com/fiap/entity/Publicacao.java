package br.com.fiap.entity;

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
@Table(name = "T_APIJPA_PUBLICACAO")
@SequenceGenerator(name = "publicacao", sequenceName = "SQ_T_APIJPA_PUBLICACAO", allocationSize=1)
public class Publicacao {
	@Id
	@Column(name = "cd_publicacao")
	@GeneratedValue(generator = "publicacao", strategy =  GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_autor", nullable = false, length = 50)
	private String autor;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_publicacao", nullable = false)
	private Calendar data;
	@Lob
	@Column(name = "fl_imagem")
	private byte[] imagem;
	@Column(name = "ds_conteudo", nullable = false, length = 250)
	private String conteudo;
	@Column(name = "nr_curtida")
	private int numCurtidas;
	@Column(name = "ds_privacidade", nullable = false)
	private Privacidade privacidade;
	public Publicacao(String autor, Calendar data, byte[] imagem, String conteudo, int numCurtidas,
			Privacidade privacidade) {
		super();
		this.autor = autor;
		this.data = data;
		this.imagem = imagem;
		this.conteudo = conteudo;
		this.numCurtidas = numCurtidas;
		this.privacidade = privacidade;
	}
	public Publicacao() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public int getNumCurtidas() {
		return numCurtidas;
	}
	public void setNumCurtidas(int numCurtidas) {
		this.numCurtidas = numCurtidas;
	}
	public Privacidade getPrivacidade() {
		return privacidade;
	}
	public void setPrivacidade(Privacidade privacidade) {
		this.privacidade = privacidade;
	}
	
	
	
}
