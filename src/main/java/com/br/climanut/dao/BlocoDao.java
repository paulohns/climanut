package com.br.climanut.dao;

import java.text.ParseException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.br.climanut.bean.Bloco;


public class BlocoDao extends GenericDAO<Bloco>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlocoDao() {
		super(Bloco.class);
	}
	@SuppressWarnings("unchecked")
	public List<Bloco> filter(Integer cliente) throws ParseException {
		
		Criteria criteria = session.createCriteria(Bloco.class, "bloco");
		
		if (cliente != null)
			criteria.createAlias("bloco.cliente", "cliente")
				.createAlias("cliente.pessoa", "pessoa")
				.add(Restrictions.eqOrIsNull("pessoa.id", cliente));
		
		return criteria.list();
	}
}

