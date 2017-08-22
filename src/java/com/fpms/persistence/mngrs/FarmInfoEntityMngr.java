/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmInfo;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class FarmInfoEntityMngr implements FarmInfoEntityMngrLocal{
    
    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    
    @Override
    public FarmInfo create(FarmInfo farmInfo) {
        return crudServiceProvider.create(farmInfo);
    }

    @Override
    public FarmInfo update(FarmInfo farmInfo) {
        return crudServiceProvider.update(farmInfo);
    }

    @Override
    public void delete(String farmId) {
        FarmInfo farminfo = get(farmId);
        crudServiceProvider.delete(farminfo);
    }

    @Override
    public FarmInfo get(String farmId) {
        return crudServiceProvider.find(farmId, FarmInfo.class);
    }

    @Override
    public List<FarmInfo> getAll() {
        return crudServiceProvider.findByNamedQuery("FarmInfo.findAll", FarmInfo.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }
    
}
