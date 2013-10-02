import org.hibernate.Session;

import com.br.climanut.bean.Equipamento;
import com.br.climanut.facade.EquipamentoFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.br.climanut.utils.HibernateUtil;


public class TesteMain {
	
	/** 
     * @param args 
	 * @throws ClimanutExceptions 
     */  
    public static void main(String[] args) throws ClimanutExceptions {  
  
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		Equipamento equipamento = new Equipamento();
		
		EquipamentoFacade equipamentoFacade = new EquipamentoFacade();
		
//		equipamento.setNumeroSerie("000929221");
		equipamento.setMarca("MOTOROLA");
		equipamento.setModelo("AP0123");
//		equipamento.setBtu(78528321);
		/*equipamento.setPeriodicidadeManutencao(1);
		equipamento.setStatus(1);*/
		
		/*equipamentoFacade.create(equipamento);
		equipamentoFacade.findByFilter(equipamento);*/
		
		
/*        Pessoa pessoa = new Pessoa(); //em.find(Pessoa.class, 2L);  
        
        
        PessoaFacade facade = new PessoaFacade();
        
        pessoa = facade.find(1);
        
        
        pessoa.setNome("ADMINISTRADOR");  
        pessoa.setLogin("Admin");
        pessoa.setSenha("admin123");
        pessoa.setTipoUsuario(0);*/
//        pessoaDAO.save(pessoa);  
  
        //    session.save(pessoa);
        //   session.getTransaction().commit();
      /*  em.getTransaction().begin();  
        em.persist(pessoa);  
        em.getTransaction().commit();  
        em.close();  
        emf.close(); */  
    } 
}
