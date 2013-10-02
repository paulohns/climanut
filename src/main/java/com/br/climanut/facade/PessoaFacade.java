package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.Pessoa;
import com.br.climanut.dao.PessoaDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Pessoa e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class PessoaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private PessoaDao pessoaDao;    
	 
public void create(Pessoa pessoa) throws ClassNotFoundException {
    	
    	if(pessoa != null){
    		pessoaDao = new PessoaDao();
    		pessoaDao.beginTransaction();
    		pessoaDao.save(pessoa);
    		pessoaDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Pessoa pessoa) {
    	if(pessoa != null){
	    	pessoaDao = new PessoaDao();
	    	pessoaDao.beginTransaction();
	    	pessoaDao.update(pessoa);
	    	pessoaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Pessoa find(int id) {
    	
    	if(id != 0){
	    	pessoaDao = new PessoaDao();
	    	pessoaDao.beginTransaction();
	        Pessoa pessoa = pessoaDao.find(id);
	        pessoaDao.closeTransaction();
	        return pessoa;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Pessoa pessoa) throws ClimanutExceptions {
    	if(pessoa != null){
	    	pessoaDao = new PessoaDao();
	        pessoaDao.beginTransaction();
	        Pessoa persistedpessoa = pessoaDao.findReferenceOnly(pessoa.getIdPessoa());
	        
	        if(persistedpessoa != null){
	        	pessoaDao.delete(persistedpessoa);
	        	pessoaDao.commitAndCloseTransaction();
	        } else {
	        	pessoaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir pessoa", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir pessoa", 0);
    	}
    }
	

	public List<Pessoa> findAll() throws ClimanutExceptions{

		pessoaDao = new PessoaDao();
        pessoaDao.beginTransaction();
        List<Pessoa> listapessoas = pessoaDao.findAll();
        pessoaDao.closeTransaction();
        
        return listapessoas;
	}

	public Pessoa validateLogin(Pessoa usuario) throws ClimanutExceptions {
    	
    	
    	Pessoa pessoa = new Pessoa();
		pessoa.setNome("Tecnico XXXXX!");
		//1 = Técnico 0 = Cliente
		pessoa.setTipoUsuario(1);
		return pessoa;
	}
	
}
