package br.com.fiap.entity;

import java.util.Calendar;

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
@Table(name = "T_APIJPA_COMENTARIO")
@SequenceGenerator(name = "comentario", sequenceName = "SQ_T_APIJPA_COMENTARIO",  allocationSize = 1)
public class Comentario {
    @Id
    @Column(name="cd_comentario")
    @GeneratedValue(generator = "comentario", strategy =GenerationType.SEQUENCE)
	int codigo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="dt_comentario")
	Calendar data;
    @Column(name = "ds_conteudo", length = 200)
	String conteudo;
    
	public Comentario() {
		super();
	}

	public Comentario(Calendar data, String conteudo) {
		super();
		this.data = data;
		this.conteudo = conteudo;
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

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
    
    
	
}
