package com.br.climanut.dao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.br.climanut.bean.Agenda;


public class AgendaDao extends GenericDAO<Agenda>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgendaDao() {
		super(Agenda.class);
	}

	@SuppressWarnings("unchecked")
	public List<Agenda> filter(String cliente, String dataInicio,
			String dataFim, String agendado, String cancelado, String fechado) throws ParseException {
		
		Criteria criteria = session.createCriteria(Agenda.class, "agenda");
		
		if (cliente != null && !cliente.isEmpty())
			criteria.createAlias("agenda.cliente", "cliente")
				.createAlias("cliente.pessoa", "pessoa")
				.add(Restrictions.eqOrIsNull("pessoa.nome", cliente));
		
		if (dataInicio != null && !dataInicio.isEmpty()) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			Date dataIni = (Date) formatter.parse(dataInicio);
			Date dataFin = (Date) formatter.parse(dataFim);
			
			criteria.add(Restrictions.between("agenda.dataAgenda", dataIni, dataFin));
		}
		
		if (Boolean.parseBoolean(agendado)) {
			if (Boolean.parseBoolean(cancelado)) {
				if (Boolean.parseBoolean(fechado)) {
					criteria.add(Restrictions.or(Restrictions.eq("agenda.status", 1),
							Restrictions.eq("agenda.status", 2),
							Restrictions.eq("agenda.status", 3)));
				}
				else {
					criteria.add(Restrictions.or(Restrictions.eq("agenda.status", 1),
							Restrictions.eq("agenda.status", 2)));
				}				
			}
			else if (Boolean.parseBoolean(fechado)) {
				criteria.add(Restrictions.or(Restrictions.eq("agenda.status", 1),
						Restrictions.eq("agenda.status", 3)));
			}
			else
				criteria.add(Restrictions.eqOrIsNull("agenda.status", 1));
		}
		else if (Boolean.parseBoolean(cancelado)) {
			if (Boolean.parseBoolean(fechado)) {
				criteria.add(Restrictions.or(Restrictions.eq("agenda.status", 2),
						Restrictions.eq("agenda.status", 3)));
			}
			else {
				criteria.add(Restrictions.eqOrIsNull("agenda.status", 2));
			}
		}
		else if (Boolean.parseBoolean(fechado))
			criteria.add(Restrictions.eqOrIsNull("agenda.status", 3));
		
		return criteria.list();
	}
}

