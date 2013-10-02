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
 * Classe respons�vel por armezanar os dados de t�cnico.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_tecnico" )
public class Tecnico{
	
	/**C�digo de identifica��o do t�cnico */
	private Integer 	idTecnico;
	
	/** C�digo de identifica��o de pessoa. */
	@OneToMany
	@ForeignKey(name = "idPessoa")
	private Pessoa 		pessoa;
	
	/**Registro do t�cnico */
	private Long		registro;
	
	/**Anota��o de responsabilidade t�cnica */
	private Long		art;
	
	/** Identifica se o t�cnico � engenheiro */
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
