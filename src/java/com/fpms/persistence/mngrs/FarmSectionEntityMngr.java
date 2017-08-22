/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmSection;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class FarmSectionEntityMngr implements FarmSectionEntityMngrLocal{
    
    @EJB
    private CrudServiceProviderLocal crudServiceProvider;

    @Override
    public FarmSection create(FarmSection section) {
        return crudServiceProvider.create(section);
    }

    @Override
    public FarmSection update(FarmSection section) {
        return crudServiceProvider.update(section);
    }

    @Override
    public void delete(String sectionId) {
        FarmSection section = get(sectionId);
        crudServiceProvider.delete(section);
    }

    @Override
    public FarmSection get(String sectionId) {
        return crudServiceProvider.find(sectionId, FarmSection.class);
    }

    @Override
    public List<FarmSection> getAll() {
        return crudServiceProvider.findByNamedQuery("FarmSection.findAll", 
                FarmSection.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }
    
}
