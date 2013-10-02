package com.br.climanut.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**  
 * Classe que armazenará os dados da empresa Central Climatização.
 * @author PauloHenrique
 *
 */
@Entity
@Table( name = "tb_dadosempresa" )
public class DadosEmpresa {
	
	/** Nome da empresa. */
	private String nome; 
	
	/** Endereço da empresa. */
	private String endereço; 
	
	/** Telefone/Fax da empresa. */
	private String foneFax; 
	
	/** Telefone celular. */
	private String celular; 
	
	/** CNPJ da empresa. */
	private Long cnpj; 
	
	/** Inscrição Estadual da Empresa. */
	private Long ie; 
	
	/** Inscrição Municipal da Empresa. */
	private Long im; 
	
	/** Slogan da empresa. */
	private String slogan;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getFoneFax() {
		return foneFax;
	}

	public void setFoneFax(String foneFax) {
		this.foneFax = foneFax;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getIe() {
		return ie;
	}

	public void setIe(Long ie) {
		this.ie = ie;
	}

	public Long getIm() {
		return im;
	}

	public void setIm(Long im) {
		this.im = im;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
}