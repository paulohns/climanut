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
 * Classe responsável por armezanar os dados de Local.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_local" )
public class Local {
	
	/**Código de identificação */
	private Integer		idLocal;
	
	private String		descricaoLocal;
	
	/**Código do Pavimento */
	@OneToMany
	@ForeignKey(name = "idPavimento")
	private Pavimento pavimento;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public String getDescricaoLocal() {
		return descricaoLocal;
	}

	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}
	/**Tipo de atividade exercida no local */
	private String		tipoAtividade;
	
	/**Número de pessoas fixas */
	private Integer		pessoasFixas;

	/**Número de pessoas flutuantes */
	private Integer		pessoasFlutuantes;
	
	/**Área climatizada em m³ */
	private double		areaClimatizada;

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Pavimento getPavimento() {
		return pavimento;
	}

	public void setPavimento(Pavimento pavimento) {
		this.pavimento = pavimento;
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
