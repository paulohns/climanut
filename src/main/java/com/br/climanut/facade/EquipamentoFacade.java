package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;

import com.br.climanut.bean.Equipamento;
import com.br.climanut.dao.EquipamentoDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Equipamento e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class EquipamentoFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private EquipamentoDao equipamentoDao;    
	 
    public void create(Equipamento equipamento) throws ClimanutExceptions {
    	if(equipamento != null){
	        equipamentoDao = new EquipamentoDao();
	        equipamentoDao.beginTransaction();
	        equipamentoDao.save(equipamento);
	        equipamentoDao.closeTransaction();
	    } else {
			return;
		}
    
    }
 
    public void update(Equipamento equipamento) {
    	if(equipamento != null){
	    	equipamentoDao = new EquipamentoDao();
	    	equipamentoDao.beginTransaction();
	    	equipamentoDao.update(equipamento);
	    	equipamentoDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Equipamento find(int id) {
    	
    	if(id != 0){
	    	equipamentoDao = new EquipamentoDao();
	    	equipamentoDao.beginTransaction();
	        Equipamento Equipamento = equipamentoDao.find(id);
	        equipamentoDao.closeTransaction();
	        return Equipamento;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Equipamento equipamento) throws ClimanutExceptions {
    	if(equipamento != null){
	    	equipamentoDao = new EquipamentoDao();
	        equipamentoDao.beginTransaction();
	        Equipamento persistedEquipamento = equipamentoDao.findReferenceOnly(equipamento.getIdEquipamento());
	        
	        if(persistedEquipamento != null){
	        	equipamentoDao.delete(persistedEquipamento);
	        	equipamentoDao.commitAndCloseTransaction();
	        } else {
	        	equipamentoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Equipamento", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Equipamento", 0);
    	}
    }
	
	public List<Equipamento> findAll() throws ClimanutExceptions{

		equipamentoDao = new EquipamentoDao();
        equipamentoDao.beginTransaction();
        List<Equipamento> listaEquipamentos = equipamentoDao.findAll();
        equipamentoDao.closeTransaction();
        
        return listaEquipamentos;
	}
	

}
