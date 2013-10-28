package com.br.climanut.dao;

import java.text.ParseException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.br.climanut.bean.Pavimento;

public class PavimentoDao extends GenericDAO<Pavimento>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PavimentoDao() {
		super(Pavimento.class);
	}
	@SuppressWarnings("unchecked")
	public List<Pavimento> filterPavimento(Integer idBloco) throws ParseException {
		
		Criteria criteria = session.createCriteria(Pavimento.class, "pavimento");
		
		if (idBloco != null)
			criteria.createAlias("pavimento.bloco", "bloco")
				.add(Restrictions.eqOrIsNull("bloco.id", idBloco));
		
		return criteria.list();
	}

}

