package com.br.climanut.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.Mnemonic;

import com.br.climanut.bean.AgendaAnvisa;
import com.br.climanut.bean.ManutencaoAnvisa;
import com.br.climanut.dao.AgendaAnvisaDao;
import com.br.climanut.dao.ManutencaoAnvisaDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de ManutencaoAnvisaAnvisa e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class ManutencaoAnvisaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManutencaoAnvisaDao manutencaoAnvisaDao;    
	 
    public void create(ManutencaoAnvisa manutencaoAnvisa) throws ClassNotFoundException {
    	
    	if(manutencaoAnvisa != null){
    		manutencaoAnvisaDao = new ManutencaoAnvisaDao();
    		manutencaoAnvisaDao.beginTransaction();
    		manutencaoAnvisaDao.save(manutencaoAnvisa);
    		manutencaoAnvisaDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(ManutencaoAnvisa manutencaoAnvisa) {
    	if(manutencaoAnvisa != null){
	    	manutencaoAnvisaDao = new ManutencaoAnvisaDao();
	    	manutencaoAnvisaDao.beginTransaction();
	    	manutencaoAnvisaDao.update(manutencaoAnvisa);
	    	manutencaoAnvisaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public ManutencaoAnvisa find(int id) {
    	
    	if(id != 0){
	    	manutencaoAnvisaDao = new ManutencaoAnvisaDao();
	    	manutencaoAnvisaDao.beginTransaction();
	        ManutencaoAnvisa manutencaoAnvisa = manutencaoAnvisaDao.find(id);
	        manutencaoAnvisaDao.closeTransaction();
	        return manutencaoAnvisa;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(AgendaAnvisa manutencaoAnvisa) throws ClimanutExceptions {
    	if(manutencaoAnvisa != null){
	    	manutencaoAnvisaDao = new ManutencaoAnvisaDao();
	        manutencaoAnvisaDao.beginTransaction();
	        ManutencaoAnvisa persistedmanutencaoAnvisa = manutencaoAnvisaDao.findReferenceOnly(manutencaoAnvisa.getIdAgendaAnvisa());
	        
	        if(persistedmanutencaoAnvisa != null){
	        	manutencaoAnvisaDao.delete(persistedmanutencaoAnvisa);
	        	manutencaoAnvisaDao.commitAndCloseTransaction();
	        } else {
	        	manutencaoAnvisaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir manutencaoAnvisa", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir manutencaoAnvisa", 0);
    	}
    }
	

	public List<ManutencaoAnvisa> findAll() throws ClimanutExceptions{

		manutencaoAnvisaDao = new ManutencaoAnvisaDao();
        manutencaoAnvisaDao.beginTransaction();
        List<ManutencaoAnvisa> listamanutencaoAnvisas = manutencaoAnvisaDao.findAll();
        manutencaoAnvisaDao.closeTransaction();
        
        return listamanutencaoAnvisas;
	}
}
