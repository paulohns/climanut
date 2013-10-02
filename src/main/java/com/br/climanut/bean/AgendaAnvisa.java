package com.br.climanut.bean;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

/**
 * Classe responsável por armezanar os dados de agenda anvisa.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_agendaanvisa" )
public class AgendaAnvisa {
	
	/** Código de agenda ANVISA */
	private Integer 			idAgendaAnvisa;
	
	/** Código do cliente */
	@OneToMany
	@ForeignKey(name = "idCliente")
	private Cliente 			cliente; 
	
	/** Código da atividade ANVISA */
	@ManyToOne
	@ForeignKey(name = "idAtividadeAnvisa")
	private AtividadeAnvisa		atividadeAnvisa; 
	
	/** Data máxima para realizar a manutenção ANVISA */
	private Date 				dataFinal; 
	
	/** Status da agenda – Agendado, Fechado. */
	private Integer 			status;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdAgendaAnvisa() {
		return idAgendaAnvisa;
	}

	public void setIdAgendaAnvisa(Integer idAgendaAnvisa) {
		this.idAgendaAnvisa = idAgendaAnvisa;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public AtividadeAnvisa getAtividadeAnvisa() {
		return atividadeAnvisa;
	}

	public void setAtividadeAnvisa(AtividadeAnvisa atividadeAnvisa) {
		this.atividadeAnvisa = atividadeAnvisa;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	} 

}
