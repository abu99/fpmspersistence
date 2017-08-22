/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.util.crud;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author faizbash
 */
@Local
public interface CrudServiceProviderLocal {

    <T> T create(T t);

    void delete(Object t);

    <T> T find(Object id, Class<T> type);

    <T> List<T> findByDynamicQuery(Class<T> type,
            List<ParameterDefinition> parameters);

    <T> List<T> findByNamedQuery(String namedQueryName, Class<T> type);

    <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, Class<T> type);
<T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, Map<String, String> hints,
            Class<T> type);

    <T> List<T> findByNamedQuery(String queryName, int resultLimit, Class<T> type);

    <T> List<T> findByNamedQuery(String queryName, int resultLimit,
                int firstResult, Class<T> type);

    <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit, Class<T> type);

    <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, Map<String, String> hints,
            int resultLimit, Class<T> type);

    <T> List<T> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit, int firstResult,
            Class<T> type);

    <T> T update(T t);

    EntityManager getEntityManager();
}
