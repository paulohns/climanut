package com.br.climanut.utils;

/**
 * Classe responsável por gerenciar as exceções do sistema Climanut
 * 
 * @author PauloHenrique
 *
 */
public class ClimanutExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoErro;
	private String descricaoErro;
	
	
	public ClimanutExceptions(String desErro, int codErro) {		
		this.codigoErro = codErro;
		this.descricaoErro = desErro;
	}
	
	public ClimanutExceptions(Exception e) {
		
		
	}
	public int getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(int codigoErro) {
		this.codigoErro = codigoErro;
	}
	public String getDescricaoErro() {
		return descricaoErro;
	}
	public void setDescricaoErro(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}	
	
}

