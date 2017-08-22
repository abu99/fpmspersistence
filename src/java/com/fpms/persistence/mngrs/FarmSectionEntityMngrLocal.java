/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmSection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface FarmSectionEntityMngrLocal {
    
    public FarmSection create(FarmSection section);
    public FarmSection update(FarmSection section);
    public void delete(String sectionId);
    public FarmSection get(String sectionId);
    public List<FarmSection> getAll();
    public int count();
    
}
