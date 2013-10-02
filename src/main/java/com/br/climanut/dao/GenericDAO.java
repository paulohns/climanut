package com.br.climanut.dao;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.climanut.utils.HibernateUtil;
 
abstract class GenericDAO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private EntityManager em;
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 
    private Class<T> entityClass;
    
    public void beginTransaction() {
    	session.beginTransaction();
    }
 
    public void commit() {
    	session.getTransaction().commit();
    }
 
    public void rollback() {
    	session.getTransaction().rollback();
    }
 
    public void closeTransaction() {
    	session.getTransaction().commit();
    }
 
    public void commitAndCloseTransaction() {
    	session.getTransaction().commit();
    }
 
    public void flush() {
        em.flush();
    }
 
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
 
    public void save(T entity) {
        session.save(entity);
    }
 
    public void delete(T entity) {
        session.delete(entity);
    }
 
	public void update(T entity) {	
    	session.update(entity);
    }
 
    @SuppressWarnings("unchecked")
	public T find(int entityID) {
        return (T) session.get(entityClass, entityID);
    }
 
    @SuppressWarnings("unchecked")
	public T findReferenceOnly(int entityID) {
    	return (T) session.get(entityClass, entityID);
    }
 
    @SuppressWarnings({ "unchecked"})
    public List<T> findByFilter(T entity, Map<String, String> mapBean) {
    	Criteria criteria = session.createCriteria(entityClass);
    	
    	List<String> listaChave = new ArrayList<String>();
    	List<String> listaValor = new ArrayList<String>();
    	
    	for (Entry<String, String> entry :  mapBean.entrySet()) {
    		listaValor.add(entry.getValue());
    		listaChave.add(entry.getKey());
    	}
    	
    	for(int i = 0; i < mapBean.size(); i ++){
    		System.out.println(listaValor.get(i) + " - " + listaChave.get(i));
 			criteria.add( Restrictions.like(listaChave.get(i), listaValor.get(i)) );
    	}
    	
    	List<T> result = criteria.list(); 
    	
    	return result;
    }
 
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
 
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = (T) query.getSingleResult();
 
        } catch (NoResultException e) {
            System.out.println("No result found for named query: " + namedQuery);
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
    
    @SuppressWarnings({ "unchecked"})
	public List<T> findAll() {
    	return session.createCriteria(entityClass).list();
    }
    
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
    @SuppressWarnings({ "unused", "unchecked" })
	private List<T> findByNome(String nome){
        return session.createCriteria(entityClass).add(Restrictions.ilike("nomeAmbiente", nome)).list();

    }
}