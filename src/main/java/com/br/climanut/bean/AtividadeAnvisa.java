package com.br.climanut.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Classe respons�vel por armezanar os dados de atividade anvisa
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_atividadeanvisa" )
public class AtividadeAnvisa {

	/** C�digo de atividade ANVISA */
	private Integer 	idAtividadeAnvisa; 
	
	/** Descri��o das atividades ANVISA */
	private String 	descricaoAtividade; 
	
	/** Periodicidade de manuten��o para cada atividade */
	private Integer 	periodicidadeManutencao;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdAtividadeAnvisa() {
		return idAtividadeAnvisa;
	}

	public void setIdAtividadeAnvisa(Integer idAtividadeAnvisa) {
		this.idAtividadeAnvisa = idAtividadeAnvisa;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public Integer getPeriodicidadeManutencao() {
		return periodicidadeManutencao;
	}

	public void setPeriodicidadeManutencao(Integer periodicidadeManutencao) {
		this.periodicidadeManutencao = periodicidadeManutencao;
	}
	
}
