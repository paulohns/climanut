package com.br.climanut.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Classe responsável por armezanar os dados de estado.
 * @author Silvana
 *
 * */
@Entity
@Table( name = "tb_estado" )
public class Estado {
	
	/**Código de identificação do Estado */
	private int idEstado;
	
	/**Sigla do Estado */
	private String sigla;
	
	/**Nome do Estado */
	private String estado;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
