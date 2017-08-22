/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface FarmInfoEntityMngrLocal {
    
    public FarmInfo create(FarmInfo farmInfo);
    public FarmInfo update(FarmInfo farmInfo);
    public void delete(String farmId);
    public FarmInfo get(String farmId);
    public List<FarmInfo> getAll();
    public int count();
}
