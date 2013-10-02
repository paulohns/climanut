package com.br.climanut.dao;

import com.br.climanut.bean.Pessoa;

public class PessoaDao extends GenericDAO<Pessoa>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaDao() {
		super(Pessoa.class);
	}

	public Pessoa validateLogin(Pessoa usuario) {
		
		return null;
		
	}

}
