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
 * Classe que armazenará os dados de contato.
 * @author PauloHenrique
 *
 */
@Entity
@Table( name = "tb_contato" )
public class Contato {
	
	/** Código do contato */
	private Integer idContato; 
	
	/** Nome do contato. */
	private String nome; 
	
	/** Telefone fixo do contato. */
	private String telefoFixo; 
	
	/** Ramal do telefone do contato. */
	private Integer ramal; 
	
	/** Telefone celular do contato. */
	private String telefoneCelular;
	
	/** Cliente dono do contato */
	@ForeignKey(name = "idCliente")
	@OneToMany
	private Cliente cliente;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefoFixo() {
		return telefoFixo;
	}

	public void setTelefoFixo(String telefoFixo) {
		this.telefoFixo = telefoFixo;
	}

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
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
