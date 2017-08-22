/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ProductOtherUnits;
import com.fpms.persistence.entities.ProductOtherUnitsPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface ProductOtherUnitsEntityMngrLocal {
    
    public ProductOtherUnits create(ProductOtherUnits otherUnits);
    public ProductOtherUnits update(ProductOtherUnits otherUnits);
    public void delete(String productId, String sectionId, String unitName);
    public ProductOtherUnits get(String productId, String sectionId, String unitName);
    public List<ProductOtherUnits> getAll();
    public int count();
    
    
}
