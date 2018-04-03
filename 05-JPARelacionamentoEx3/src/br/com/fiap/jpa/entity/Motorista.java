package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "T_JRE3_MOTORISTA")
public class Motorista {
	@Id
	@Column(name = "nr_carteira")
	private int numCarteira;
	@Column(name = "nm_motorista", length = 150, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private Calendar dtNascimento;
	@Lob
	@Column(name = "fl_carteira")
	private byte[] flCarteira;
	@Column(name = "ds_genero")
	private Genero genero;
	
	@ManyToMany
	@JoinTable(name = "T_VEICULO_MOTORISTA", joinColumns = { @JoinColumn(name = "cd_motorista")}, inverseJoinColumns = @JoinColumn(name = "cd_veiculo"))
	private List<Veiculo> veiculos;
	
	@OneToMany(mappedBy = "motorista", cascade = CascadeType.PERSIST)
	private List<Corrida> corridas = new ArrayList<>();
	
	public void addCorrida(Corrida c) {
		c.setMotorista(this);
		corridas.add(c);
		
	}

	public int getNumCarteira() {
		return numCarteira;
	}

	public void setNumCarteira(int numCarteira) {
		this.numCarteira = numCarteira;
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

	public byte[] getFlCarteira() {
		return flCarteira;
	}

	public void setFlCarteira(byte[] flCarteira) {
		this.flCarteira = flCarteira;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	public Motorista(int numCarteira, String nome, Calendar dtNascimento, byte[] flCarteira, Genero genero) {
		super();
		this.numCarteira = numCarteira;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.flCarteira = flCarteira;
		this.genero = genero;
	}
	
	
	
	
}
