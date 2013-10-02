package com.br.climanut.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Manutencao;


public class ManutencaoDao extends GenericDAO<Manutencao>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManutencaoDao() {
		super(Manutencao.class);
	}
}

