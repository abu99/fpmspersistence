/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.FarmingSeason;
import com.fpms.persistence.entities.FarmingSeasonPK;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class FarmingSeasonEntityMngr implements FarmingSeasonEntityMngrLocal{

    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    @EJB
    private FarmSectionEntityMngrLocal farmSectionEntityMngr;

    @Override
    public FarmingSeason create(FarmingSeason season) {
        String sectionId = season.getFarmingSeasonPK().getSectionId();
        FarmSection section = farmSectionEntityMngr.get(sectionId);
        season.setFarmSection(section);
        
        return crudServiceProvider.create(season);
    }

    @Override
    public FarmingSeason update(FarmingSeason season) {
        String sectionId = season.getFarmingSeasonPK().getSectionId();
        FarmSection section = farmSectionEntityMngr.get(sectionId);
        season.setFarmSection(section);
        
        return crudServiceProvider.update(season);
    }

    @Override
    public void delete(String sectionId, Date date) {
        
        FarmingSeason season = get(sectionId,date);
        crudServiceProvider.delete(season);
    }   
    
    @Override
    public FarmingSeason get(String sectionId, Date date) {
        FarmingSeasonPK seasonPK = new FarmingSeasonPK(sectionId, date);
        return crudServiceProvider.find(seasonPK, FarmingSeason.class);
    }

    @Override
    public List<FarmingSeason> getAll() {
        return crudServiceProvider.findByNamedQuery("FarmingSeason.findAll", 
                FarmingSeason.class);
    }

    @Override
    public int count() {
       return getAll().size();
    }


    
    
}
