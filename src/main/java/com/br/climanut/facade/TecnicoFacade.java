package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;

import com.br.climanut.bean.Tecnico;
import com.br.climanut.dao.TecnicoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Tecnico e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class TecnicoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private TecnicoDao tecnicoDao;    
	 
    public void create(Tecnico tecnico) throws ClimanutExceptions {
    	if(tecnico != null){
	        tecnicoDao = new TecnicoDao();
	        tecnicoDao.beginTransaction();
	        tecnicoDao.save(tecnico);
	        //tecnicoDao.commitAndCloseTransaction();
	        tecnicoDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Tecnico tecnico) {
    	if(tecnico != null){
	    	tecnicoDao = new TecnicoDao();
	    	tecnicoDao.beginTransaction();
	    	tecnicoDao.update(tecnico);
	    	tecnicoDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Tecnico find(int id) {
    	
    	if(id != 0){
	    	tecnicoDao = new TecnicoDao();
	    	tecnicoDao.beginTransaction();
	        Tecnico Tecnico = tecnicoDao.find(id);
	        tecnicoDao.closeTransaction();
	        return Tecnico;
    	} else {
    		return null;
    	}
    }
 
    public void delete(Tecnico tecnico) throws ClimanutExceptions {
    	if(tecnico != null && tecnico.getPessoa()!= null){
	    	tecnicoDao = new TecnicoDao();
	        tecnicoDao.beginTransaction();
	        
	        tecnicoDao.deletePessoa(tecnico.getPessoa());
	        
	        Tecnico persistedTecnico = tecnicoDao.findReferenceOnly(tecnico.getIdTecnico());
	        
	        if(persistedTecnico != null){
	        	tecnicoDao.delete(persistedTecnico);
	        	tecnicoDao.commitAndCloseTransaction();
	        } else {
//	        	tecnicoDao.rollback();// commitAndCloseTransaction();
	        	tecnicoDao.closeTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Tecnico", 504);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Tecnico", 0);
    	}
    }
	
	public List<Tecnico> findAll() throws ClimanutExceptions{
		
		tecnicoDao = new TecnicoDao();
        tecnicoDao.beginTransaction();
        List<Tecnico> listaTecnicos = tecnicoDao.findAll();
        tecnicoDao.closeTransaction();
        
        return listaTecnicos;
	}
    
}
