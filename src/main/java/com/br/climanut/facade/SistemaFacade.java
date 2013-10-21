package com.br.climanut.facade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.br.climanut.bean.Agenda;
import com.br.climanut.bean.Bloco;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Sistema;
import com.br.climanut.bean.Sistema;
import com.br.climanut.dao.AgendaDao;
import com.br.climanut.dao.BlocoDao;
import com.br.climanut.dao.SistemaDao;
import com.br.climanut.dao.SistemaDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Sistema e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class SistemaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BlocoDao blocoDao;
	private SistemaDao sistemaDao;   
	 
	public void create(Sistema sistema) throws ClimanutExceptions {
    	if(sistema != null){
	        sistemaDao = new SistemaDao();
	        sistemaDao.beginTransaction();
	        sistemaDao.save(sistema);
	        sistemaDao.closeTransaction();
	    } else {
			return;
		}
    
    }
	public void createBloco(Bloco bloco) throws ClimanutExceptions {
    	if(bloco != null){
	        blocoDao = new BlocoDao();
	        blocoDao.beginTransaction();
	        blocoDao.save(bloco);
	        blocoDao.closeTransaction();
	    } else {
			return;
		}
    }
	
    public void update(Sistema sistema) {
    	if(sistema != null){
	    	sistemaDao = new SistemaDao();
	    	sistemaDao.beginTransaction();
	    	sistemaDao.update(sistema);
	    	sistemaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Sistema find(int id) {
    	
    	if(id != 0){
	    	sistemaDao = new SistemaDao();
	    	sistemaDao.beginTransaction();
	        Sistema Sistema = sistemaDao.find(id);
	        sistemaDao.closeTransaction();
	        return Sistema;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Sistema sistema) throws ClimanutExceptions {
    	if(sistema != null){
	    	sistemaDao = new SistemaDao();
	        sistemaDao.beginTransaction();
	        Sistema persistedSistema = sistemaDao.findReferenceOnly(sistema.getIdSistema());
	        
	        if(persistedSistema != null){
	        	sistemaDao.delete(persistedSistema);
	        	sistemaDao.commitAndCloseTransaction();
	        } else {
	        	sistemaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Sistema", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Sistema", 0);
    	}
    }
	

	public List<Sistema> findAll() throws ClimanutExceptions{

		sistemaDao = new SistemaDao();
        sistemaDao.beginTransaction();
        List<Sistema> listaSistemas = sistemaDao.findAll();
        sistemaDao.closeTransaction();
        
        return listaSistemas;
	}
	public List<Bloco> filter(Integer cliente) throws ClimanutExceptions, ParseException {
		blocoDao = new BlocoDao();
        blocoDao.beginTransaction();
        List<Bloco> listaBlocos = blocoDao.filter(cliente);
        blocoDao.closeTransaction();
        
        return listaBlocos;
	}

}
