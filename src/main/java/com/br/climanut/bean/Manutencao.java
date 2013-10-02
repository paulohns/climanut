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
 * Classe respons�vel por armezanar os dados de manuten��o
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_manutencao" )
public class Manutencao {

	/**C�digo de manuten��o */
	private Integer		idManutencao;
	
	/**C�digo da localiza��o */
	@OneToMany
	@ForeignKey(name = "idLocalizacao")
	private Localizacao	localizacao;
	
	/**C�digo da agenda */
	@OneToMany
	@ForeignKey(name = "idAgenda")
	private Agenda		agenda;
	
	/**Data da realiza��o da manuten��o */
	private Date		dataManutencao;
	
	/**Situa��o da corrente - okay ou N�o okay */
	private String		corrente;
	
	/**Observa��o da situa��o da corrente */
	private String		obsCorrente;
	
	/**Situa��o da press�o Hi - okay ou n�o okay */
	private String		pressaoHi;
	
	/**Observa��o da situa��o da press�o Hi */
	private String		obsPressaoHi;
	
	/**Situa��o da press�o Low - okay ou n�o okay */
	private String		pressaoLow;
	
	/**Observa��o da situa��o da press�o Low */
	private String		obsPressaoLow;
	
	/**Situa��o dos filtros - okay ou n�o okay */
	private String		filtros;
	
	/**Observa��o da situa��o dos filtros */
	private String		obsFiltros;
	
	/**Situa��o da temperatura - okay ou n�o okay */
	private String		temperatura;
	
	/**Observa��o da situa��o da temperatura */
	private String		obsTemperatura;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getCorrente() {
		return corrente;
	}

	public void setCorrente(String corrente) {
		this.corrente = corrente;
	}

	public String getObsCorrente() {
		return obsCorrente;
	}

	public void setObsCorrente(String obsCorrente) {
		this.obsCorrente = obsCorrente;
	}

	public String getPressaoHi() {
		return pressaoHi;
	}

	public void setPressaoHi(String pressaoHi) {
		this.pressaoHi = pressaoHi;
	}

	public String getObsPressaoHi() {
		return obsPressaoHi;
	}

	public void setObsPressaoHi(String obsPressaoHi) {
		this.obsPressaoHi = obsPressaoHi;
	}

	public String getPressaoLow() {
		return pressaoLow;
	}

	public void setPressaoLow(String pressaoLow) {
		this.pressaoLow = pressaoLow;
	}

	public String getObsPressaoLow() {
		return obsPressaoLow;
	}

	public void setObsPressaoLow(String obsPressaoLow) {
		this.obsPressaoLow = obsPressaoLow;
	}

	public String getFiltros() {
		return filtros;
	}

	public void setFiltros(String filtros) {
		this.filtros = filtros;
	}

	public String getObsFiltros() {
		return obsFiltros;
	}

	public void setObsFiltros(String obsFiltros) {
		this.obsFiltros = obsFiltros;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getObsTemperatura() {
		return obsTemperatura;
	}

	public void setObsTemperatura(String obsTemperatura) {
		this.obsTemperatura = obsTemperatura;
	}
	
}
