package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MA_CONSULTA")
@IdClass(ConsultaPK.class)
public class Consulta {
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_consulta")
	private Calendar data;
	@Column(name="ds_consulta")
	private String descricao;
	@Column(name="st_convenio", nullable=false)
	private boolean statusConvenio;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_paciente")
	private Paciente paciente;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="nr_crm")
	private Medico medico;
	
	
	
	public Consulta(Calendar data, String descricao, boolean statusConvenio, Paciente paciente, Medico medico) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.statusConvenio = statusConvenio;
		this.paciente = paciente;
		this.medico = medico;
	}
	public Consulta(Calendar data, String descricao, boolean statusConvenio) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.statusConvenio = statusConvenio;
	}
	public Consulta() {
		super();
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isStatusConvenio() {
		return statusConvenio;
	}
	public void setStatusConvenio(boolean statusConvenio) {
		this.statusConvenio = statusConvenio;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
}
