package com.br.climanut.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.br.climanut.bean.Pessoa;
import com.br.climanut.bean.Tecnico;


public class TecnicoDao extends GenericDAO<Tecnico>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PessoaDao pessoaDao;

	public TecnicoDao() {
		super(Tecnico.class);
	}

	public List<Tecnico> findAll() {
		Criteria criteria = session.createCriteria("SELECT * FROM TB_TECNICO");

		@SuppressWarnings("unchecked")
		List<Tecnico> result = criteria.list(); 

		return result;
	}
	
	public void deletePessoa(Pessoa pessoa){
		pessoaDao = new PessoaDao();
        pessoaDao.beginTransaction();
        Pessoa persistedPessoa = pessoaDao.findReferenceOnly(pessoa.getIdPessoa());
        
        pessoaDao.closeTransaction();
        
        if(persistedPessoa != null){
        	session.delete(persistedPessoa);
        }
	}
	
	
}

