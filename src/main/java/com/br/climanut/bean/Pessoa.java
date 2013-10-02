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
 * Classe respons�vel por armezanar os dados de pessoa.
 * @author Silvana
 *
 * */
@Entity
@Table( name = "tb_pessoa" )
public class Pessoa {
	
	/**C�digo de identifica��o de pessoa */
	private Integer idPessoa;
	
	/** Tipo de pessoa. 
	 * 1 para T�cnico e 0 para Cliente */
	private Integer tipoUsuario;
	
	/**C�digo de Cidade */
	@OneToOne
	@ForeignKey(name = "idCidade")
	private Cidade cidade;
	
	/**Nome da pessoa */
	private String nome;
	
	/**N�mero do telefone fixo */
	private String telefoneFixo;
	
	/**N�mero do telefone celular */
	private String telefoneCelular;
	
	/**N�mero do CPF ou CNPJ */
	private Long idFederal;
	
	/**Login de acesso - E-mail */
	private String login;
	
	/**Senha de acesso */
	private String senha;
	
	/** N�mero do endere�o. */
	private String numero;
	
	/** Complemento do endere�o. */
	private String complemento;
	
	/** Bairro do endere�o. */
	private String bairro;
	
	/** Bairro do endere�o. */
	private String cep;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Access(AccessType.PROPERTY)
	@OneToOne
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public Long getIdFederal() {
		return idFederal;
	}
	public void setIdFederal(Long idFederal) {
		this.idFederal = idFederal;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCep() {
		return cep;
	}
		
}
