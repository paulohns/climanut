package com.br.climanut.facade;

import java.io.Serializable;

import com.br.climanut.bean.DadosEmpresa;
import com.br.climanut.bean.Equipamento;
import com.br.climanut.dao.DadosEmpresaDao;
import com.br.climanut.dao.EquipamentoDao;

/**
 * Classe responsável pela regra de negócio de DadosEmpresa e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class DadosEmpresaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DadosEmpresaDao dadosEmpresaDao;
	
	public DadosEmpresa find(int id) {
	    	
	    	if(id != 0){
	    		dadosEmpresaDao = new DadosEmpresaDao();
	    		dadosEmpresaDao.beginTransaction();
	    		DadosEmpresa dadosEmpresa = dadosEmpresaDao.find(id);
		        dadosEmpresaDao.closeTransaction();
		        return dadosEmpresa;
	    	} else {
	    		return null;
	    	}
	    }
	 

}
