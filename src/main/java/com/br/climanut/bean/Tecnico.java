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
 * Classe responsável por armezanar os dados de técnico.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_tecnico" )
public class Tecnico{
	
	/**Código de identificação do técnico */
	private Integer 	idTecnico;
	
	/** Código de identificação de pessoa. */
	@OneToMany
	@ForeignKey(name = "idPessoa")
	private Pessoa 		pessoa;
	
	/**Registro do técnico */
	private Long		registro;
	
	/**Anotação de responsabilidade técnica */
	private Long		art;
	
	/** Identifica se o técnico é engenheiro */
	private boolean		engenheiro;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}
	public Long getRegistro() {
		return registro;
	}
	public void setRegistro(Long registro) {
		this.registro = registro;
	}
	public Long getArt() {
		return art;
	}
	public void setArt(Long art) {
		this.art = art;
	}
	public boolean isEngenheiro() {
		return engenheiro;
	}
	public void setEngenheiro(boolean engenheiro) {
		this.engenheiro = engenheiro;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@Access(AccessType.PROPERTY)
	@OneToOne
	public Pessoa getPessoa() {
		return pessoa;
	}
	
}
