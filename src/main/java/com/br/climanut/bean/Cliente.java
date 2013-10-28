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
	
	/** Nome do ambiente. */
	private String nomeAmbiente;
	
	/** Telefone ambiente. */
	private String telefoneAmbiente;
	
	/** Rua ambiente. */
	private String rua;
	
	/** Número do Endereço do ambiente. */
	private String numero;
	
	/** Complemento do endereço do ambiente. */
	private String complemento;
	
	/** Bairro do endereço do ambiente. */
	private String bairro;
	

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdCliente() {
		
		return idCliente;
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

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne
	public Pessoa getPessoa() {
		return pessoa;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
