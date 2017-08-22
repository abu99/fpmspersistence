/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.util.crud;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author faizbash
 */
@Stateless
public class CrudServiceProvider implements CrudServiceProviderLocal {
    @PersistenceContext(unitName = "fpmspersistencePU")
    
    private EntityManager em;

    @Override
    public <T> T create(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public <T> T find(Object id, Class<T> type) {
        return (T) em.find(type, id);
    }
    
    @Override
    public void delete(Object t) {
        em.remove(em.merge(t));
        //Object ref = em.getReference(t.getClass(), t);
        //em.remove(ref);
        //em.merge(t);
    }

    @Override
    public <T> T update(T t) {
        return (T) em.merge(t);
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName, Class<T> type) {
        return em.createNamedQuery(namedQueryName).getResultList();
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, Class<T> type) {
        return findByNamedQuery(namedQueryName, parameters, 0, type);
    }

    @Override 
    public <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, Map<String, String> hints,
            Class<T> type) {
        return findByNamedQuery(namedQueryName, parameters, hints, 0, type);
    }

    @Override
    public <T> List<T> findByNamedQuery(String queryName, int resultLimit,
            Class<T> type) {
        return this.em.createNamedQuery(queryName).
                setMaxResults(resultLimit).
                getResultList();
    }

    @Override
    public <T> List<T> findByNamedQuery(String queryName, int resultLimit,
            int firstResult, Class<T> type) {
        
        Query query = this.em.createNamedQuery(queryName);
        query.setFirstResult(firstResult);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        return query.getResultList();
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters,
                int resultLimit, Class<T> type) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, Map<String, String> hints,
                int resultLimit, Class<T> type) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        //hints
        Set<Entry<String, Object>> hintsEntry = parameters.entrySet();
        for (Entry<String, Object> entry : hintsEntry) {
            query.setHint(entry.getKey(), entry.getValue());
        }
        
        return query.getResultList();
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit, int firstResult, Class<T> type) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        query.setFirstResult(firstResult);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    @Override
    public <T> List<T> findByDynamicQuery(Class<T> type,
            List<ParameterDefinition> parameters) {
        //generate query
        String queryString = generateQuery(type, parameters);

        Query query = this.em.createQuery(queryString);

        //set parameters
        int k = 1;  //param position
        for (ParameterDefinition param : parameters) {
            if (param.getValue() != null)
                query.setParameter(k++, param.getValue());
        }

        return query.getResultList();
    }

    //helper method
    private <T> String generateQuery(Class<T> type,
            List<ParameterDefinition> parameters) {
        final String VAR = "obj";
        StringBuilder queryBuilder = new StringBuilder(
                String.format("SELECT %s FROM %s %s", VAR,
                type.getSimpleName(), VAR)
        );
        if (parameters.isEmpty()) { //no conditions
            return queryBuilder.toString();
        }
        //WHERE clause
        Iterator<ParameterDefinition> itr = parameters.iterator();
        int k = 1;  //parameter position
        ParameterDefinition firstParam = itr.next(); //always type WITH
        if (firstParam.getValue() == null) {
            queryBuilder.append(String.format(
                            " WHERE %s.%s IS NULL", VAR, firstParam.getName()));
        } else {
            queryBuilder.append(String.format(" WHERE %s.%s = ?%d",
                VAR, firstParam.getName(), k++));
        }
        //append parameters
        for ( ; itr.hasNext(); ) {
            ParameterDefinition nextParam = itr.next();
            if (nextParam.getValue() == null) {
                queryBuilder.append(String.format(
                            " %s %s.%s IS NULL", nextParam.getParameterType(),
                            VAR, nextParam.getName()));
            } else {
                queryBuilder.append(String.format(
                    " %s %s.%s = ?%s", nextParam.getParameterType(), VAR,
                    nextParam.getName(), k++));
            }
        }
        return queryBuilder.toString();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

