package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_JRE3_CORRIDA")
public class Corrida {
	@Id
	@Column(name = "cd_corrida")
	private int codigo;
	@Column(name = "ds_origem", length = 150)
	private String origem;
	@Column(name = "ds_destino", length = 150)
	private String destino;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_corrida")
	private Calendar data;
	@Column(name = "vl_corrida", nullable = false)
	private float valor;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_motorista", nullable = false)
	private Motorista motorista;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_passageiro", nullable = false)
	private Passageiro passageiro;
	
	@OneToOne(mappedBy = "corrida", cascade = CascadeType.PERSIST)
	private Pagamento pagamento;
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Corrida(int codigo, String origem, String destino, Calendar data, float valor) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
	public Corrida() {
		// TODO Auto-generated constructor stub
	}
	
}
