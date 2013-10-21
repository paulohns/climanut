package com.br.climanut.bean;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

/**
 * Classe responsável por armezanar os dados de Bloco.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_bloco" )
public class Bloco {
	
	/**Código de identificação */
	private Integer		idBloco;
	
	/**Descrição do bloco */
	private String		descricaoBloco;
	/**Código de identificação do cliente */
	@OneToOne
	@ForeignKey(name = "idCliente")
	private Cliente		cliente;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdBloco() {
		return idBloco;
	}

	public void setIdBloco(Integer idBloco) {
		this.idBloco = idBloco;
	}

	public String getDescricaoBloco() {
		return descricaoBloco;
	}

	public void setDescricaoBloco(String descricaoBloco) {
		this.descricaoBloco = descricaoBloco;
	}
	@Access(AccessType.PROPERTY)
	@OneToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
