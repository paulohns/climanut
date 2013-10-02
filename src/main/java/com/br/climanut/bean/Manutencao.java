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
 * Classe responsável por armezanar os dados de manutenção
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_manutencao" )
public class Manutencao {

	/**Código de manutenção */
	private Integer		idManutencao;
	
	/**Código da localização */
	@OneToMany
	@ForeignKey(name = "idLocalizacao")
	private Localizacao	localizacao;
	
	/**Código da agenda */
	@OneToMany
	@ForeignKey(name = "idAgenda")
	private Agenda		agenda;
	
	/**Data da realização da manutenção */
	private Date		dataManutencao;
	
	/**Situação da corrente - okay ou Não okay */
	private String		corrente;
	
	/**Observação da situação da corrente */
	private String		obsCorrente;
	
	/**Situação da pressão Hi - okay ou não okay */
	private String		pressaoHi;
	
	/**Observação da situação da pressão Hi */
	private String		obsPressaoHi;
	
	/**Situação da pressão Low - okay ou não okay */
	private String		pressaoLow;
	
	/**Observação da situação da pressão Low */
	private String		obsPressaoLow;
	
	/**Situação dos filtros - okay ou não okay */
	private String		filtros;
	
	/**Observação da situação dos filtros */
	private String		obsFiltros;
	
	/**Situação da temperatura - okay ou não okay */
	private String		temperatura;
	
	/**Observação da situação da temperatura */
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
