package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.AtividadeAnvisa;
import com.br.climanut.dao.AtividadeAnvisaDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Atividade Anvisa e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class AtividadeAnvisaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private AtividadeAnvisaDao atividadeAnvisaDao;
	 
    public void create(AtividadeAnvisa atividadeAnvisa) throws ClimanutExceptions {
    	if(atividadeAnvisa != null){
    		atividadeAnvisaDao = new AtividadeAnvisaDao();
    		atividadeAnvisaDao.beginTransaction();
    		atividadeAnvisaDao.save(atividadeAnvisa);
    		atividadeAnvisaDao.closeTransaction();
	    } else {
			return;
		}
    
    }
 
    public void update(AtividadeAnvisa atividadeAnvisa) {
    	if(atividadeAnvisa != null){
    		atividadeAnvisaDao = new AtividadeAnvisaDao();
    		atividadeAnvisaDao.beginTransaction();
    		atividadeAnvisaDao.update(atividadeAnvisa);
    		atividadeAnvisaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public AtividadeAnvisa find(int id) {
    	
    	if(id != 0){
	    	atividadeAnvisaDao = new AtividadeAnvisaDao();
	    	atividadeAnvisaDao.beginTransaction();
	        AtividadeAnvisa atividadeAnvisa = atividadeAnvisaDao.find(id);
	        atividadeAnvisaDao.closeTransaction();
	        return atividadeAnvisa;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(AtividadeAnvisa atividadeAnvisa) throws ClimanutExceptions {
    	if(atividadeAnvisa != null){
    		atividadeAnvisaDao = new AtividadeAnvisaDao();
    		atividadeAnvisaDao.beginTransaction();
    		AtividadeAnvisa persistedagendaAnvisa = atividadeAnvisaDao.findReferenceOnly(atividadeAnvisa.getIdAtividadeAnvisa());
	        
	        if(persistedagendaAnvisa != null){
	        	atividadeAnvisaDao.delete(persistedagendaAnvisa);
	        	atividadeAnvisaDao.commitAndCloseTransaction();
	        } else {
	        	atividadeAnvisaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir agendaAnvisa", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir agendaAnvisa", 0);
    	}
    }
	

	public List<AtividadeAnvisa> findAll() throws ClimanutExceptions{

		atividadeAnvisaDao = new AtividadeAnvisaDao();
		atividadeAnvisaDao.beginTransaction();
        List<AtividadeAnvisa> listaAtividadeAnvisas = atividadeAnvisaDao.findAll();
        atividadeAnvisaDao.closeTransaction();
        
        return listaAtividadeAnvisas;
	}

}
