/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmingSeason;
import com.fpms.persistence.entities.FarmingSeasonPK;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface FarmingSeasonEntityMngrLocal {
    
    public FarmingSeason create(FarmingSeason season);
    public FarmingSeason update(FarmingSeason season);
    public void delete(String sectionId, Date date);
    public FarmingSeason get(String sectionId, Date date);
    public List<FarmingSeason> getAll();
    public int count();
    
    
}
