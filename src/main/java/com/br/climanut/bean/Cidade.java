package com.br.climanut.bean;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

/**
 * Classe responsável por armezanar os dados de cidade.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_cidade" )
public class Cidade {
	
	/**Código de identificação de cidade */
	private Integer idCidade;
	
	/**Identificador do Estado */
	@OneToMany
	@ForeignKey(name = "idEstado")
	private Estado estado;
	
	/**Identificador do Estado */
	private String nomeCidade;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	
}
