package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.Localizacao;
import com.br.climanut.dao.LocalizacaoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Localizacao e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class LocalizacaoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private LocalizacaoDao localizacaoDao;    
	 
	public void create(Localizacao localizacao) throws ClassNotFoundException {
    	
    	if(localizacao != null){
    		localizacaoDao = new LocalizacaoDao();
    		localizacaoDao.beginTransaction();
    		localizacaoDao.save(localizacao);
    		localizacaoDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Localizacao localizacao) {
    	if(localizacao != null){
	    	localizacaoDao = new LocalizacaoDao();
	    	localizacaoDao.beginTransaction();
	    	localizacaoDao.update(localizacao);
	    	localizacaoDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Localizacao find(int id) {
    	
    	if(id != 0){
	    	localizacaoDao = new LocalizacaoDao();
	    	localizacaoDao.beginTransaction();
	        Localizacao localizacao = localizacaoDao.find(id);
	        localizacaoDao.closeTransaction();
	        return localizacao;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Localizacao localizacao) throws ClimanutExceptions {
    	if(localizacao != null){
	    	localizacaoDao = new LocalizacaoDao();
	        localizacaoDao.beginTransaction();
	        Localizacao persistedlocalizacao = localizacaoDao.findReferenceOnly(localizacao.getIdLocalizacao());
	        
	        if(persistedlocalizacao != null){
	        	localizacaoDao.delete(persistedlocalizacao);
	        	localizacaoDao.commitAndCloseTransaction();
	        } else {
	        	localizacaoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir localizacao", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir localizacao", 0);
    	}
    }
	

	public List<Localizacao> findAll() throws ClimanutExceptions{

		localizacaoDao = new LocalizacaoDao();
        localizacaoDao.beginTransaction();
        List<Localizacao> listalocalizacaos = localizacaoDao.findAll();
        localizacaoDao.closeTransaction();
        
        return listalocalizacaos;
	}

}
