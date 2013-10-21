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
 * Classe responsável por armezanar os dados de Pavimento.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_pavimento" )
public class Pavimento {
	
	/**Código de identificação */
	private Integer		idPavimento;
	
	private String		descricaoPavimento;
	
	/**Código do Bloco */
	@OneToMany
	@ForeignKey(name = "idBloco")
	private Bloco bloco;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdPavimento() {
		return idPavimento;
	}

	public void setIdPavimento(Integer idPavimento) {
		this.idPavimento = idPavimento;
	}

	public String getDescricaoPavimento() {
		return descricaoPavimento;
	}

	public void setDescricaoPavimento(String descricaoPavimento) {
		this.descricaoPavimento = descricaoPavimento;
	}
	
	@Access(AccessType.PROPERTY)
	@OneToOne
	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	
}