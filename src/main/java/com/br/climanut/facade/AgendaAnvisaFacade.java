package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.AgendaAnvisa;
import com.br.climanut.dao.AgendaAnvisaDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Agenda Anvisa e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class AgendaAnvisaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private AgendaAnvisaDao agendaAnvisaDao;
	 
    public void create(AgendaAnvisa agendaAnvisa) throws ClimanutExceptions {
    	if(agendaAnvisa != null){
    		agendaAnvisaDao = new AgendaAnvisaDao();
    		agendaAnvisaDao.beginTransaction();
    		agendaAnvisaDao.save(agendaAnvisa);
    		agendaAnvisaDao.closeTransaction();
	    } else {
			return;
		}
    
    }
 
    public void update(AgendaAnvisa agendaAnvisa) {
    	if(agendaAnvisa != null){
	    	agendaAnvisaDao = new AgendaAnvisaDao();
	    	agendaAnvisaDao.beginTransaction();
	    	agendaAnvisaDao.update(agendaAnvisa);
	    	agendaAnvisaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public AgendaAnvisa find(int id) {
    	
    	if(id != 0){
	    	agendaAnvisaDao = new AgendaAnvisaDao();
	    	agendaAnvisaDao.beginTransaction();
	        AgendaAnvisa agendaAnvisa = agendaAnvisaDao.find(id);
	        agendaAnvisaDao.closeTransaction();
	        return agendaAnvisa;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(AgendaAnvisa agendaAnvisa) throws ClimanutExceptions {
    	if(agendaAnvisa != null){
	    	agendaAnvisaDao = new AgendaAnvisaDao();
	        agendaAnvisaDao.beginTransaction();
	        AgendaAnvisa persistedagendaAnvisa = agendaAnvisaDao.findReferenceOnly(agendaAnvisa.getIdAgendaAnvisa());
	        
	        if(persistedagendaAnvisa != null){
	        	agendaAnvisaDao.delete(persistedagendaAnvisa);
	        	agendaAnvisaDao.commitAndCloseTransaction();
	        } else {
	        	agendaAnvisaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir agendaAnvisa", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir agendaAnvisa", 0);
    	}
    }
	

	public List<AgendaAnvisa> findAll() throws ClimanutExceptions{

		agendaAnvisaDao = new AgendaAnvisaDao();
        agendaAnvisaDao.beginTransaction();
        List<AgendaAnvisa> listaagendaAnvisas = agendaAnvisaDao.findAll();
        agendaAnvisaDao.closeTransaction();
        
        return listaagendaAnvisas;
	}

}
