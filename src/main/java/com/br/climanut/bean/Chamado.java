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
 * Classe responsável por armezanar os dados de chamado.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_chamado" )
public class Chamado {
	
	/**Código de chamado */
	private Integer		idChamado;
	
	/**Código de cliente */
	@OneToMany
	@ForeignKey(name = "idCliente")
	private Cliente		cliente;
	
	/**Descrição do chamado */
	private String		descricaoAtividade;
	
	/**Status do chamado. Ex.: Aberto; Cancelado; Agendado; Fechado. */
	private Integer		status;
	
	/**Observação para chamado */
	private String		observacao;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
