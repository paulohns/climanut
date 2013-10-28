package com.br.climanut.facade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import com.br.climanut.bean.Bloco;
import com.br.climanut.bean.EquipamentosPorLocal;
import com.br.climanut.bean.Local;
import com.br.climanut.bean.Pavimento;
import com.br.climanut.bean.Sistema;
import com.br.climanut.dao.BlocoDao;
import com.br.climanut.dao.EquipamentosPorLocalDao;
import com.br.climanut.dao.LocalDao;
import com.br.climanut.dao.PavimentoDao;
import com.br.climanut.dao.SistemaDao;
import com.br.climanut.utils.ClimanutExceptions;

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

	private BlocoDao blocoDao;
	private PavimentoDao pavimentoDao;
	private LocalDao localDao;
	private EquipamentosPorLocalDao equipamentosPorLocalDao;
	private SistemaDao sistemaDao;   
	 
	public void create(Sistema sistema) throws ClimanutExceptions {
    	if(sistema != null){
	        sistemaDao = new SistemaDao();
	        sistemaDao.beginTransaction();
	        sistemaDao.save(sistema);
	        sistemaDao.closeTransaction();
	    } else {
			return;
		}
    
    }
	public void createBloco(Bloco bloco) throws ClimanutExceptions {
    	if(bloco != null){
	        blocoDao = new BlocoDao();
	        blocoDao.beginTransaction();
	        blocoDao.save(bloco);
	        blocoDao.closeTransaction();
	    } else {
			return;
		}
    }
	public void createPavimento(Pavimento pavimento) throws ClimanutExceptions {
    	if(pavimento != null){
    		pavimentoDao = new PavimentoDao();
    		pavimentoDao.beginTransaction();
    		pavimentoDao.save(pavimento);
    		pavimentoDao.closeTransaction();
	    } else {
			return;
		}
    }
	public void createLocal(Local local) throws ClimanutExceptions {
    	if(local != null){
    		localDao = new LocalDao();
    		localDao.beginTransaction();
    		localDao.save(local);
    		localDao.closeTransaction();
	    } else {
			return;
		}
    }
	public void createEquipamentosPorLocal(EquipamentosPorLocal equipamentosPorLocal) throws ClimanutExceptions {
    	if(equipamentosPorLocal != null){
    		equipamentosPorLocalDao = new EquipamentosPorLocalDao();
    		equipamentosPorLocalDao.beginTransaction();
    		equipamentosPorLocalDao.save(equipamentosPorLocal);
    		equipamentosPorLocalDao.closeTransaction();
	    } else {
			return;
		}
    }
	
    public void update(Sistema sistema) {
    	if(sistema != null){
	    	sistemaDao = new SistemaDao();
	    	sistemaDao.beginTransaction();
	    	sistemaDao.update(sistema);
	    	sistemaDao.closeTransaction();
    	} else {
    		return;
    	}
    }
 
    public Sistema find(int id) {
    	
    	if(id != 0){
	    	sistemaDao = new SistemaDao();
	    	sistemaDao.beginTransaction();
	        Sistema Sistema = sistemaDao.find(id);
	        sistemaDao.closeTransaction();
	        return Sistema;
    	} else {
    		return null;
    	}
    }
    public Bloco findBloco(int id) {
    	
    	if(id != 0){
	    	blocoDao = new BlocoDao();
	    	blocoDao.beginTransaction();
	        Bloco bloco = blocoDao.find(id);
	        blocoDao.closeTransaction();
	        return bloco;
    	} else {
    		return null;
    	}
    }
    public Pavimento findPavimento(int id) {
    	
    	if(id != 0){
	    	pavimentoDao = new PavimentoDao();
	    	pavimentoDao.beginTransaction();
	        Pavimento pavimento = pavimentoDao.find(id);
	        pavimentoDao.closeTransaction();
	        return pavimento;
    	} else {
    		return null;
    	}
    }
    public Local findLocal(int id) {
    	
    	if(id != 0){
	    	localDao = new LocalDao();
	    	localDao.beginTransaction();
	        Local local = localDao.find(id);
	        localDao.closeTransaction();
	        return local;
    	} else {
    		return null;
    	}
    }
    public List<EquipamentosPorLocal> findAllEquipamentosPorLocal() throws ClimanutExceptions{

		equipamentosPorLocalDao = new EquipamentosPorLocalDao();
		equipamentosPorLocalDao.beginTransaction();
        List<EquipamentosPorLocal> listaEquipamentosPorLocal = equipamentosPorLocalDao.findAll();
        equipamentosPorLocalDao.closeTransaction();
        
        return listaEquipamentosPorLocal;
	}
 
    public void delete(Sistema sistema) throws ClimanutExceptions {
    	if(sistema != null){
	    	sistemaDao = new SistemaDao();
	        sistemaDao.beginTransaction();
	        Sistema persistedSistema = sistemaDao.findReferenceOnly(sistema.getIdSistema());
	        
	        if(persistedSistema != null){
	        	sistemaDao.delete(persistedSistema);
	        	sistemaDao.commitAndCloseTransaction();
	        } else {
	        	sistemaDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Sistema", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Sistema", 0);
    	}
    }
    public void deleteBloco(Bloco bloco) throws ClimanutExceptions {
    	if(bloco != null){
	    	blocoDao = new BlocoDao();
	    	blocoDao.beginTransaction();
	        Bloco persistedBloco = blocoDao.findReferenceOnly(bloco.getIdBloco());
	        
	        if(persistedBloco != null){
	        	blocoDao.delete(persistedBloco);
	        	blocoDao.commitAndCloseTransaction();
	        } else {
	        	blocoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Bloco", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Bloco", 0);
    	}
    }
    public void deletePavimento(Pavimento pavimento) throws ClimanutExceptions {
    	if(pavimento != null){
	    	pavimentoDao = new PavimentoDao();
	    	pavimentoDao.beginTransaction();
	        Pavimento persistedPavimento = pavimentoDao.findReferenceOnly(pavimento.getIdPavimento());
	        
	        if(persistedPavimento != null){
	        	pavimentoDao.delete(persistedPavimento);
	        	pavimentoDao.commitAndCloseTransaction();
	        } else {
	        	pavimentoDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Pavimento", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Pavimento", 0);
    	}
    }
    public void deleteLocal(Local local) throws ClimanutExceptions {
    	if(local != null){
	    	localDao = new LocalDao();
	    	localDao.beginTransaction();
	        Pavimento persistedLocal = pavimentoDao.findReferenceOnly(local.getIdLocal());
	        
	        if(persistedLocal != null){
	        	localDao.delete(local);
	        	localDao.commitAndCloseTransaction();
	        } else {
	        	localDao.commitAndCloseTransaction();
	        	throw new ClimanutExceptions("Erro ao excluir Local", 0);
	        }
    	} else {
    		throw new ClimanutExceptions("Erro ao excluir Local", 0);
    	}
    }
	

	public List<Sistema> findAll() throws ClimanutExceptions{

		sistemaDao = new SistemaDao();
        sistemaDao.beginTransaction();
        List<Sistema> listaSistemas = sistemaDao.findAll();
        sistemaDao.closeTransaction();
        
        return listaSistemas;
	}
	public List<Sistema> filterSistema(Integer idCliente) throws ClimanutExceptions, ParseException {
		sistemaDao = new SistemaDao();
        sistemaDao.beginTransaction();
        List<Sistema> listaSistemas = sistemaDao.filterSistema(idCliente);
        sistemaDao.closeTransaction();
        
        return listaSistemas;
	}
	public List<Bloco> filterBloco(Integer idCliente) throws ClimanutExceptions, ParseException {
		blocoDao = new BlocoDao();
        blocoDao.beginTransaction();
        List<Bloco> listaBlocos = blocoDao.filterBloco(idCliente);
        blocoDao.closeTransaction();
        
        return listaBlocos;
	}
	public List<Pavimento> filterPavimento(Integer idBloco) throws ClimanutExceptions, ParseException {
		pavimentoDao = new PavimentoDao();
		pavimentoDao.beginTransaction();
        List<Pavimento> listaPavimentos = pavimentoDao.filterPavimento(idBloco);
        pavimentoDao.closeTransaction();
        
        return listaPavimentos;
	}
	public List<Local> filterLocal(Integer idPavimento) throws ClimanutExceptions, ParseException {
		localDao = new LocalDao();
		localDao.beginTransaction();
        List<Local> listaLocais = localDao.filterLocal(idPavimento);
        localDao.closeTransaction();
        
        return listaLocais;
	}
	
	

}
