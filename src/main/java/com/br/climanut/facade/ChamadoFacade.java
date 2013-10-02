package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.Chamado;
import com.br.climanut.dao.ChamadoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Chamado e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class ChamadoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChamadoDao chamadoDao;	

	public void create(Chamado chamado) throws ClassNotFoundException {
	    	
	    	if(chamado != null){
	    		chamadoDao = new ChamadoDao();
	    		chamadoDao.beginTransaction();
	    		chamadoDao.save(chamado);
	    		chamadoDao.closeTransaction();
		    } else {
				return;
			}
	    }
	 
	    public void update(Chamado chamado) {
	    	if(chamado != null){
		    	chamadoDao = new ChamadoDao();
		    	chamadoDao.beginTransaction();
		    	chamadoDao.update(chamado);
		    	chamadoDao.closeTransaction();
	    	} else {
	    		return;
	    	}
	    }
	 
	    public Chamado find(int id) {
	    	
	    	if(id != 0){
		    	chamadoDao = new ChamadoDao();
		    	chamadoDao.beginTransaction();
		        Chamado chamado = chamadoDao.find(id);
		        chamadoDao.closeTransaction();
		        return chamado;
	    	} else {
	    		return null;
	    	}
	    }
	 
	 
	    public void delete(Chamado chamado) throws ClimanutExceptions {
	    	if(chamado != null){
		    	chamadoDao = new ChamadoDao();
		        chamadoDao.beginTransaction();
		        Chamado persistedchamado = chamadoDao.findReferenceOnly(chamado.getIdChamado());
		        
		        if(persistedchamado != null){
		        	chamadoDao.delete(persistedchamado);
		        	chamadoDao.commitAndCloseTransaction();
		        } else {
		        	chamadoDao.commitAndCloseTransaction();
		        	throw new ClimanutExceptions("Erro ao excluir chamado", 0);
		        }
	    	} else {
	    		throw new ClimanutExceptions("Erro ao excluir chamado", 0);
	    	}
	    }
		
	
		public List<Chamado> findAll() throws ClimanutExceptions{
	
			chamadoDao = new ChamadoDao();
	        chamadoDao.beginTransaction();
	        List<Chamado> listachamados = chamadoDao.findAll();
	        chamadoDao.closeTransaction();
	        
	        return listachamados;
		}

}
