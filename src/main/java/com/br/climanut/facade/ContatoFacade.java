package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.AgendaAnvisa;
import com.br.climanut.bean.Contato;
import com.br.climanut.dao.ContatoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Contato e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class ContatoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ContatoDao contatoDao;    
	 
	public void create(Contato contato) throws ClassNotFoundException {
    	
    	if(contato != null){
    		contatoDao = new ContatoDao();
    		contatoDao.beginTransaction();
    		contatoDao.save(contato);
    		contatoDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Contato contato) {
    	if(contato != null){
	    	contatoDao = new ContatoDao();
	    	contatoDao.beginTransaction();
	    	contatoDao.update(contato);
	    	contatoDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Contato find(int id) {
    	
    	if(id != 0){
	    	contatoDao = new ContatoDao();
	    	contatoDao.beginTransaction();
	        Contato contato = contatoDao.find(id);
	        contatoDao.closeTransaction();
	        return contato;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Contato contato) throws ClimanutExceptions {
    	if(contato != null){
	    	contatoDao = new ContatoDao();
	        contatoDao.beginTransaction();
	        Contato persistedcontato = contatoDao.findReferenceOnly(contato.getIdContato());
	        
	        if(persistedcontato != null){
	        	contatoDao.delete(persistedcontato);
	        	contatoDao.commitAndCloseTransaction();
	        } else {
	        	contatoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir contato", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir contato", 0);
    	}
    }
	

	public List<Contato> findAll() throws ClimanutExceptions{

		contatoDao = new ContatoDao();
        contatoDao.beginTransaction();
        List<Contato> listacontatos = contatoDao.findAll();
        contatoDao.closeTransaction();
        
        return listacontatos;
	}
}
