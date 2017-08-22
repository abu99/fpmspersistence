/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.Product;
import com.fpms.persistence.entities.ProductOtherUnits;
import com.fpms.persistence.entities.ProductOtherUnitsPK;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class ProductOtherUnitsEntityMngr implements 
        ProductOtherUnitsEntityMngrLocal{

    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    @EJB
    private ProductEntityMngrLocal productEntityMngr;
    @EJB
    private FarmSectionEntityMngrLocal sectionEntityMngr;
    
    @Override
    public ProductOtherUnits create(ProductOtherUnits otherUnits) {
        
        String productId = otherUnits.getProductOtherUnitsPK().getProductId();
        String sectionId = otherUnits.getProductOtherUnitsPK().getSectionId();
        Product product = productEntityMngr.get(productId);
        FarmSection section = sectionEntityMngr.get(sectionId);
        otherUnits.setFarmSection(section);
        otherUnits.setProduct(product);
        return crudServiceProvider.create(otherUnits);
    
    }

    @Override
    public ProductOtherUnits update(ProductOtherUnits otherUnits) {
        String productId = otherUnits.getProductOtherUnitsPK().getProductId();
        String sectionId = otherUnits.getProductOtherUnitsPK().getSectionId();
        Product product = productEntityMngr.get(productId);
        FarmSection section = sectionEntityMngr.get(sectionId);
        otherUnits.setFarmSection(section);
        otherUnits.setProduct(product);
        return crudServiceProvider.update(otherUnits);
    
    }

    @Override
    public void delete(String productId, String sectionId, String unitName) {
        ProductOtherUnits PoU = get(productId, sectionId, unitName);
        crudServiceProvider.delete(PoU);
    }

    @Override
    public ProductOtherUnits get(String productId, String sectionId, String unitName) {
        ProductOtherUnitsPK otherUnitsPK = new ProductOtherUnitsPK(productId,
                sectionId, unitName);
        return crudServiceProvider.find(otherUnitsPK, ProductOtherUnits.class);
    }

    @Override
    public List<ProductOtherUnits> getAll() {
       return crudServiceProvider.findByNamedQuery("ProductOtherUnits.findAll",
               ProductOtherUnits.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }
    
}
