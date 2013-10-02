package com.br.climanut.bean;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

/**
 * Classe responsável por armezanar os dados de cliente.
 * @author PauloHenrique
 *
 * */

@Entity
@Table( name = "tb_cliente" )
public class Cliente{
	
	/** Código de identificação do cliente. */
	private Integer idCliente;
	
	/** Código de identificação de pessoa. */
	@OneToMany
	@ForeignKey(name = "idPessoa")
	private Pessoa pessoa;
	
	/** Identificação de contato. */
	@ManyToOne
	@ForeignKey(name = "idContato")
	private Contato contato;
	

	/** Nome do ambiente. */
	private String nomeAmbiente;
	
	/** Telefone ambiente. */
	private String telefoneAmbiente;
	
	/** Endereço ambiente. */
	private String enderecoAmbiente;
	

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdCliente() {
		
		return idCliente;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeAmbiente() {
		return nomeAmbiente;
	}

	public void setNomeAmbiente(String nomeAmbiente) {
		this.nomeAmbiente = nomeAmbiente;
	}

	public String getTelefoneAmbiente() {
		return telefoneAmbiente;
	}

	public void setTelefoneAmbiente(String telefoneAmbiente) {
		this.telefoneAmbiente = telefoneAmbiente;
	}

	public String getEnderecoAmbiente() {
		return enderecoAmbiente;
	}

	public void setEnderecoAmbiente(String enderecoAmbiente) {
		this.enderecoAmbiente = enderecoAmbiente;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Pessoa getPessoa() {
		return pessoa;
	}
	
}
