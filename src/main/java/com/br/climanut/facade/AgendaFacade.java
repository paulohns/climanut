package com.br.climanut.facade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import com.br.climanut.bean.Agenda;
import com.br.climanut.dao.AgendaDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Agenda e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class AgendaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private AgendaDao agendaDao;     
	 
    public void create(Agenda agenda) throws ClimanutExceptions {
    	if(agenda != null){
    		agendaDao = new AgendaDao();
    		agendaDao.beginTransaction();
    		agendaDao.save(agenda);
    		agendaDao.closeTransaction();
	    } else {
			return;
		}
    
    }
 
    public void update(Agenda agenda) {
    	if(agenda != null){
	    	agendaDao = new AgendaDao();
	    	agendaDao.beginTransaction();
	    	agendaDao.update(agenda);
	    	agendaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Agenda find(int id) {
    	
    	if(id != 0){
	    	agendaDao = new AgendaDao();
	    	agendaDao.beginTransaction();
	        Agenda Agenda = agendaDao.find(id);
	        agendaDao.closeTransaction();
	        return Agenda;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Agenda agenda) throws ClimanutExceptions {
    	if(agenda != null){
	    	agendaDao = new AgendaDao();
	        agendaDao.beginTransaction();
	        Agenda persistedAgenda = agendaDao.findReferenceOnly(agenda.getIdAgenda());
	        
	        if(persistedAgenda != null){
	        	agendaDao.delete(persistedAgenda);
	        	agendaDao.commitAndCloseTransaction();
	        } else {
	        	agendaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Agenda", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Agenda", 0);
    	}
    }
	

	public List<Agenda> findAll() throws ClimanutExceptions{

		agendaDao = new AgendaDao();
        agendaDao.beginTransaction();
        List<Agenda> listaAgendas = agendaDao.findAll();
        agendaDao.closeTransaction();
        
        return listaAgendas;
	}

	public List<Agenda> filter(String cliente, String dataInicio,
			String dataFim, String agendado, String cancelado, String fechado) throws ClimanutExceptions, ParseException {
		agendaDao = new AgendaDao();
        agendaDao.beginTransaction();
        List<Agenda> listaAgendas = agendaDao.filter(cliente, dataInicio, dataFim, agendado, cancelado, fechado);
        agendaDao.closeTransaction();
        
        return listaAgendas;
	}
}
