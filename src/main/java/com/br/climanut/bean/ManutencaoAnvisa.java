package com.br.climanut.bean;

import java.util.Date;

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
 * Classe respons�vel por armezanar os dados de manuten��o anvisa.
 * @author PauloHenrique
 * 
 * */
@Entity
@Table( name = "tb_manutencaoanvisa" )
public class ManutencaoAnvisa {
	
	/** C�digo de manuten��o ANVISA */
	private Integer 		idManutencaoAnvisa;
	
	/** C�digo de agenda ANVISA */
	@OneToOne
	@ForeignKey(name = "idAgendaAnvisa")
	private AgendaAnvisa	agendaAnvisa; 
	
	/** Data que foi feita a manuten��o ANVISA */
	private Date 			dataManutencaoAnvisa;
	
	/** Nome do respons�vel t�cnico pela execu��o */
	@OneToOne
	@ForeignKey(name = "idTecnico")
	private Tecnico 		executador;
	
	/** Nome do respons�vel t�cnico pela aprova��o */
	@OneToOne
	@ForeignKey(name = "idTecnico")
	private Tecnico			aprovador;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdManutencaoAnvisa() {
		return idManutencaoAnvisa;
	}

	public void setIdManutencaoAnvisa(Integer idManutencaoAnvisa) {
		this.idManutencaoAnvisa = idManutencaoAnvisa;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public AgendaAnvisa getAgendaAnvisa() {
		return agendaAnvisa;
	}

	public void setAgendaAnvisa(AgendaAnvisa agendaAnvisa) {
		this.agendaAnvisa = agendaAnvisa;
	}

	public Date getDataManutencaoAnvisa() {
		return dataManutencaoAnvisa;
	}

	public void setDataManutencaoAnvisa(Date dataManutencaoAnvisa) {
		this.dataManutencaoAnvisa = dataManutencaoAnvisa;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Tecnico getExecutador() {
		return executador;
	}

	public void setExecutador(Tecnico executador) {
		this.executador = executador;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Tecnico getAprovador() {
		return aprovador;
	}

	public void setAprovador(Tecnico aprovador) {
		this.aprovador = aprovador;
	}
	
}
