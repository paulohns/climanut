package com.br.climanut.bean;

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
 * Classe respons�vel por armezanar os dados de Bloco.
 * @author PauloHenrique
 *
 * */
@Entity
@Table( name = "tb_equipamentosporlocal" )
public class EquipamentosPorLocal {
	
	/**C�digo de identifica��o */
	private Integer		idEquipamentosPorLocal;
	
	/**N�mero de identifica��o utilizado pela Central */
	private String		numeroInterno;
	
	/**N�mero de identifica��o utilizado pela Central */
	private Integer		status;

	/**C�digo de identifica��o do cliente */
	@OneToOne
	@ForeignKey(name = "idCliente")
	private Cliente		cliente;
	/**C�digo de identifica��o do equipamento */
	@OneToOne
	@ForeignKey(name = "idEquipamento")
	private Equipamento		equipamento;
	/**C�digo de identifica��o do local */
	@OneToOne
	@ForeignKey(name = "idLocal")
	private Local		local;
	
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
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdEquipamentosPorLocal() {
		return idEquipamentosPorLocal;
	}

	public void setIdEquipamentosPorLocal(Integer idEquipamentosPorLocal) {
		this.idEquipamentosPorLocal = idEquipamentosPorLocal;
	}
	
	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@Access(AccessType.PROPERTY)
	@OneToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
