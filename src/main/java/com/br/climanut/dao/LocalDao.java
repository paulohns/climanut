package com.br.climanut.dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.br.climanut.bean.Local;


public class LocalDao extends GenericDAO<Local>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocalDao() {
		super(Local.class);
	}
	@SuppressWarnings("unchecked")
	public List<Local> filterLocal(Integer idPavimento) throws ParseException {
		
		Criteria criteria = session.createCriteria(Local.class, "local");
		
		if (idPavimento != null)
			criteria.createAlias("local.pavimento", "pavimento")
				.add(Restrictions.eqOrIsNull("pavimento.id", idPavimento));
		
		return criteria.list();
	}


}

