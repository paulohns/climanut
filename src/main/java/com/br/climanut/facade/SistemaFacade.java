package com.br.climanut.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.br.climanut.bean.Sistema;
import com.br.climanut.dao.SistemaDao;

/**
 * Classe responsável pela regra de negócio de Sistema e 
 * fazer a "ponte" entre a Servlet e a DAO.
 * @author PauloHenrique
 *
 * */
public class SistemaFacade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private SistemaDao sistemaDao;    
	 
    public void create(Sistema sistema) throws ClassNotFoundException {
    	//ActivityFacade activityFacade = new ActivityFacade();
    	
    	//if(activityFacade.find(Sistema.getActivity()) == null)
        //	throw new NullPointerException("Atividade não encontrada");        
        
        sistemaDao = new SistemaDao();
        sistemaDao.beginTransaction();
        sistemaDao.save(sistema);
        sistemaDao.commitAndCloseTransaction();
    }
 
    public void update(Sistema sistema) throws ClassNotFoundException {
		//ActivityFacade activityFacade = new ActivityFacade();
    	
    	//if(activityFacade.find(Sistema.getActivity()) == null)
        //q	throw new NullPointerException("Atividade não encontrada");
        
    	sistemaDao = new SistemaDao();
    	sistemaDao.beginTransaction();
    	//   Sistema persistedSistema = SistemaDao.find(Sistema.getId());
    	//persistedSistema.setDescription(Sistema.getDescription());
    	// persistedSistema.setActivity(Sistema.getActivity());
    	// persistedSistema.setValue(Sistema.getValue());
    	// persistedSistema.setDate(Sistema.getDate());
    	// persistedSistema.setType(Sistema.getType());
    	// SistemaDao.update(persistedsistema);
    	// SistemaDao.commitAndCloseTransaction();
    }
 
    public Sistema find(int id) {
    	sistemaDao = new SistemaDao();
    	sistemaDao.beginTransaction();
        Sistema Sistema = sistemaDao.find(id);
        sistemaDao.closeTransaction();
        return Sistema;
    }
 
   /* public List<Sistema> listAll() {
    	sistemaDao = new SistemaDao();
        sistemaDao.beginTransaction();
        List<Sistema> result = sistemaDao.findAll();
        sistemaDao.closeTransaction();
        return result;
    }*/
 
    public void delete(Sistema sistema) {
    	sistemaDao = new SistemaDao();
        sistemaDao.beginTransaction();
        Sistema persistedSistema = sistemaDao.findReferenceOnly(sistema.getIdSistema());
        sistemaDao.delete(persistedSistema);
        sistemaDao.commitAndCloseTransaction();
    }
	
    public List<Sistema> findByActivity(int activityId) {
    	ArrayList<Sistema> found = new ArrayList<Sistema>();
    	//List<Sistema> sistema = listAll();
    	
    	//for (Sistema sistema : sistema) {
    	//	if(Sistema.getActivity() == activityId)
    	//		found.add(sistema);
    	//}
    	
    	return found;
    }

}
