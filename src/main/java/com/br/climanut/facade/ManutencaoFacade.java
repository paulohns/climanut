package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.Manutencao;
import com.br.climanut.dao.ManutencaoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Manutencao e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class ManutencaoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private ManutencaoDao manutencaoDao;    
	 
	public void create(Manutencao manutencao) throws ClassNotFoundException {
    	
    	if(manutencao != null){
    		manutencaoDao = new ManutencaoDao();
    		manutencaoDao.beginTransaction();
    		manutencaoDao.save(manutencao);
    		manutencaoDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Manutencao manutencao) {
    	if(manutencao != null){
	    	manutencaoDao = new ManutencaoDao();
	    	manutencaoDao.beginTransaction();
	    	manutencaoDao.update(manutencao);
	    	manutencaoDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Manutencao find(int id) {
    	
    	if(id != 0){
	    	manutencaoDao = new ManutencaoDao();
	    	manutencaoDao.beginTransaction();
	        Manutencao manutencao = manutencaoDao.find(id);
	        manutencaoDao.closeTransaction();
	        return manutencao;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Manutencao manutencao) throws ClimanutExceptions {
    	if(manutencao != null){
	    	manutencaoDao = new ManutencaoDao();
	        manutencaoDao.beginTransaction();
	        Manutencao persistedmanutencao = manutencaoDao.findReferenceOnly(manutencao.getIdManutencao());
	        
	        if(persistedmanutencao != null){
	        	manutencaoDao.delete(persistedmanutencao);
	        	manutencaoDao.commitAndCloseTransaction();
	        } else {
	        	manutencaoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir manutencao", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir manutencao", 0);
    	}
    }
	

	public List<Manutencao> findAll() throws ClimanutExceptions{

		manutencaoDao = new ManutencaoDao();
        manutencaoDao.beginTransaction();
        List<Manutencao> listamanutencaos = manutencaoDao.findAll();
        manutencaoDao.closeTransaction();
        
        return listamanutencaos;
	}
}
