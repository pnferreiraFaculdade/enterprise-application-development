package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_JRE3_PASSAGEIRO")
@SequenceGenerator(allocationSize = 1, name = "passageiro", sequenceName = "SQ_T_JRE3_PASSAGEIRO")
public class Passageiro {
	@Id
	@Column(name = "cd_passageiro")
	@GeneratedValue(generator = "passageiro", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_passageiro", nullable
			 = false)
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private Calendar dtNascimento;
	@Column(name = "ds_genero")
	private Genero genero;
	
	@OneToMany(mappedBy = "passageiro")
	private List<Corrida> corridas = new ArrayList<>();
	
	public Passageiro(String nome, Calendar dtNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
	}

	public void addCorrida(Corrida c) {
		c.setPassageiro(this);
		corridas.add(c);
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}
	
	
	
}
