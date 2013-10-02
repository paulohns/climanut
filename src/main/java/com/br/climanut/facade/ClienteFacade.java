package com.br.climanut.facade;

import java.io.Serializable;
import java.util.List;
import com.br.climanut.bean.Cliente;
import com.br.climanut.dao.ClienteDao;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Classe responsável pela regra de negócio de Cliente e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class ClienteFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ClienteDao clienteDao;    
	 
	public void create(Cliente cliente) throws ClassNotFoundException {
    	
    	if(cliente != null){
    		clienteDao = new ClienteDao();
    		clienteDao.beginTransaction();
    		clienteDao.save(cliente);
    		clienteDao.closeTransaction();
	    } else {
			return;
		}
    }
 
    public void update(Cliente cliente) {
    	if(cliente != null){
	    	clienteDao = new ClienteDao();
	    	clienteDao.beginTransaction();
	    	clienteDao.update(cliente);
	    	clienteDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Cliente find(int id) {
    	
    	if(id != 0){
	    	clienteDao = new ClienteDao();
	    	clienteDao.beginTransaction();
	        Cliente cliente = clienteDao.find(id);
	        clienteDao.closeTransaction();
	        return cliente;
    	} else {
    		return null;
    	}
    }
 
 
    public void delete(Cliente cliente) throws ClimanutExceptions {
    	if(cliente != null){
	    	clienteDao = new ClienteDao();
	        clienteDao.beginTransaction();
	        Cliente persistedcliente = clienteDao.findReferenceOnly(cliente.getIdCliente());
	        
	        if(persistedcliente != null){
	        	clienteDao.delete(persistedcliente);
	        	clienteDao.commitAndCloseTransaction();
	        } else {
	        	clienteDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir cliente", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir cliente", 0);
    	}
    }
	

	public List<Cliente> findAll() throws ClimanutExceptions{

		clienteDao = new ClienteDao();
        clienteDao.beginTransaction();
        List<Cliente> listaclientes = clienteDao.findAll();
        clienteDao.closeTransaction();
        
        return listaclientes;
	}
	

}
