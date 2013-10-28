package com.br.climanut.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.br.climanut.bean.Cidade;
import com.br.climanut.dao.CidadeDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Cidade e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class CidadeFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CidadeDao cidadeDao = new CidadeDao();


	public List<Cidade> findAll() throws ClimanutExceptions{

		cidadeDao = new CidadeDao();
        cidadeDao.beginTransaction();
        List<Cidade> listacidades = cidadeDao.findAll();
        cidadeDao.closeTransaction();
        
        return listacidades;
	}
}
