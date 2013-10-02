package com.br.climanut.bean;

import java.util.Date;

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
 * Classe responsável por armezanar os dados de agenda
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_agenda" )
public class Agenda {

	/** Código de agenda */
	private Integer idAgenda; 
	
	/** Nome do cliente */
	@OneToMany
	@ForeignKey(name = "idCliente")
	private Cliente cliente; 
	
	/** Código do técnico */
	@OneToMany
	@ForeignKey(name = "idTecnico")
	private Tecnico tecnico; 
	
	/** Código do chamado */
	@OneToMany
	@ForeignKey(name = "idChamado")
	private Chamado chamado; 
	
	/** Data para realizar a manutenção */
	private Date dataAgenda; 
	
	/** Descrição da atividade a ser realizada */
	private String descricaoAtividade; 

	/** Status da Agenda – Agendado, Fechado */
	private Integer status;

	/** Observação da atividade */
	private String observacao;
	
	/** Quem incluiu agenda, 0sistema ou 1tecnico  */
	private Integer incluidoPor;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
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
	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
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

	public void setIncluidoPor(Integer incluidoPor) {
		this.incluidoPor = incluidoPor;
	}

	public Integer getIncluidoPor() {
		return incluidoPor;
	}
	
}
