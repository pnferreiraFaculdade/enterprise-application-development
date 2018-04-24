package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

public class ConsultaPK implements Serializable{

	private Calendar data;
	private int medico;
	private int paciente;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + medico;
		result = prime * result + paciente;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (medico != other.medico)
			return false;
		if (paciente != other.paciente)
			return false;
		return true;
	}
	
	
}
