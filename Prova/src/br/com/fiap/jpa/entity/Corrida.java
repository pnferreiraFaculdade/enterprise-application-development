package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NR_CORRIDA")
@NamedQuery(name="Corrida.buscarPorData", query="from Corrida where data between :i and :f")
@SequenceGenerator(allocationSize=1, name="corrida", sequenceName="SQ_T_NR_CORRIDA")
public class Corrida {
	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="ds_origem", length=150)
	private String origem;
	@Column(name="ds_destino", length=150)
	private String destino;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_corrida")
	private Calendar data;
	@Column(name="vl_corrida", nullable=false)
	private float valor;
	
	@OneToOne(mappedBy="corrida", cascade=CascadeType.PERSIST)
	private Pagamento pagamento;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_passageiro", nullable=false)
	private Passageiro passageiro;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_motorista", nullable=false)
	private Motorista motorista;
	
	public Corrida() {
		super();
	}
	
	public Corrida(String origem, String destino, Calendar data, float valor, Pagamento pagamento,
			Passageiro passageiro, Motorista motorista) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.valor = valor;
		this.pagamento = pagamento;
		this.passageiro = passageiro;
		this.motorista = motorista;
	}

	public Corrida(String origem, String destino, Calendar data, float valor) {
		super();
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
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	
	
}
