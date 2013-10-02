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
 * Classe responsável por armezanar os dados de localização.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_localizacao" )
public class Localizacao {
	
	/**Código de identificação */
	private Integer		idLocalizacao;
	
	/**Código do Equipamento */
	@OneToMany
	@ForeignKey(name = "idEquipamento")
	private Equipamento	equipamento;
	
	/**Código do Sistema */
	@OneToMany
	@ForeignKey(name = "idSistema")
	private Sistema		sistema;
	
	/**Identifica cada equipamento como único */
	private Integer		numeroEquipamento;
	
	/**Bloco */
	private String		bloco;
	
	/**Pavimento */
	private String		pavimento;
	
	/**Local. Ex: Sala 205 */
	private String		local;
	
	/**Ativo ou Inativo */
	private Integer		status;
	
	/**Tipo de atividade exercida no local */
	private String		tipoAtividade;
	
	/**Número de pessoas fixas */
	private Integer		pessoasFixas;

	/**Número de pessoas flutuantes */
	private Integer		pessoasFlutuantes;
	
	/**Área climatizada em m³ */
	private double		areaClimatizada;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Integer getNumeroEquipamento() {
		return numeroEquipamento;
	}

	public void setNumeroEquipamento(Integer numeroEquipamento) {
		this.numeroEquipamento = numeroEquipamento;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getPavimento() {
		return pavimento;
	}

	public void setPavimento(String pavimento) {
		this.pavimento = pavimento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Integer getPessoasFixas() {
		return pessoasFixas;
	}

	public void setPessoasFixas(Integer pessoasFixas) {
		this.pessoasFixas = pessoasFixas;
	}

	public Integer getPessoasFlutuantes() {
		return pessoasFlutuantes;
	}

	public void setPessoasFlutuantes(Integer pessoasFlutuantes) {
		this.pessoasFlutuantes = pessoasFlutuantes;
	}

	public double getAreaClimatizada() {
		return areaClimatizada;
	}

	public void setAreaClimatizada(double areaClimatizada) {
		this.areaClimatizada = areaClimatizada;
	}
	
}
