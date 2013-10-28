package com.br.climanut.dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.br.climanut.bean.Sistema;


public class SistemaDao extends GenericDAO<Sistema>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SistemaDao() {
		super(Sistema.class);
	}
	@SuppressWarnings("unchecked")
	public List<Sistema> filterSistema(Integer idCliente) throws ParseException {
		
		Criteria criteria = session.createCriteria(Sistema.class, "sistema");
		
		if (idCliente != null)
			criteria.createAlias("sistema.cliente", "cliente")
				.add(Restrictions.eqOrIsNull("cliente.id", idCliente));
		
		return criteria.list();
	}
}

