package com.br.climanut.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Classe responsável por armezanar os dados de equipamento.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_equipamento" )
public class Equipamento {
	
	/**Código de identificação do equipmento */
	private Integer		idEquipamento;
	
	/**Número de série do equipamento */
	private String		numeroSerie;
	
	/**Potência do equipamento – BTU’s */
	private double		btu;
	
	/**Marca do equipamento */
	private String		marca;
	
	/**Modelo do equipamento */
	private String		modelo;
	
	/**Periodicidade de manutenção */
	private Integer		periodicidadeManutencao;
	
	/**Status do equipamento */
	private Integer		status;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(Integer idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public double getBtu() {
		return btu;
	}

	public void setBtu(double btu) {
		this.btu = btu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getPeriodicidadeManutencao() {
		return periodicidadeManutencao;
	}

	public void setPeriodicidadeManutencao(Integer periodicidadeManutencao) {
		this.periodicidadeManutencao = periodicidadeManutencao;
	}

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
