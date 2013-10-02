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
 * Classe responsável por armezanar os dados de sistema.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_sistema" )
public class Sistema {
	
	/**Código de identificação do sistema */
	private Integer		idSistema;
	
	/**Código de identificação do cliente */
	@OneToOne
	@ForeignKey(name = "idCliente")
	private Cliente		cliente;
	
	/**Data de instalação do sistema */
	private Date		dataInstalacao;
	
	/**Status do Sistema. Ex.: Ativo ou Inativo */
	private Integer 	status;
	
	/**Status de instalação do sistema */
	private boolean		instalado;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean isInstalado() {
		return instalado;
	}

	public void setInstalado(boolean instalado) {
		this.instalado = instalado;
	}
	
}
