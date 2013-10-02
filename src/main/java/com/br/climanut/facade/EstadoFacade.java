package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.Estado;
import com.br.climanut.dao.EstadoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Estado e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class EstadoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private EstadoDao estadoDao;    
	 
	public void create(Estado estado) throws ClassNotFoundException {
    	
    	if(estado != null){
    		estadoDao = new EstadoDao();
    		estadoDao.beginTransaction();
    		estadoDao.save(estado);
    		estadoDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Estado estado) {
    	if(estado != null){
	    	estadoDao = new EstadoDao();
	    	estadoDao.beginTransaction();
	    	estadoDao.update(estado);
	    	estadoDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Estado find(int id) {
    	
    	if(id != 0){
	    	estadoDao = new EstadoDao();
	    	estadoDao.beginTransaction();
	        Estado estado = estadoDao.find(id);
	        estadoDao.closeTransaction();
	        return estado;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Estado estado) throws ClimanutExceptions {
    	if(estado != null){
	    	estadoDao = new EstadoDao();
	        estadoDao.beginTransaction();
	        Estado persistedestado = estadoDao.findReferenceOnly(estado.getIdEstado());
	        
	        if(persistedestado != null){
	        	estadoDao.delete(persistedestado);
	        	estadoDao.commitAndCloseTransaction();
	        } else {
	        	estadoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir estado", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir estado", 0);
    	}
    }
	

	public List<Estado> findAll() throws ClimanutExceptions{

		estadoDao = new EstadoDao();
        estadoDao.beginTransaction();
        List<Estado> listaestados = estadoDao.findAll();
        estadoDao.closeTransaction();
        
        return listaestados;
	}

}
