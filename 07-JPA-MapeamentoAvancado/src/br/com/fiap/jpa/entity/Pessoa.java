package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@Entity
@Table(name="T_MA_PESSOA")
@SequenceGenerator(allocationSize=1, name="pessoa", sequenceName="SQ_T_MA_PESSOA")
public class Pessoa {
	@Id
	@Column(name="cd_")
	private int codigo;
	private String nome;
}
