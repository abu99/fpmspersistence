/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.Product;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import static com.fpms.util.crud.QueryParameter.*;

/**
 *
 * @author aabello
 */
@Stateless
public class ProductEntityMngr implements ProductEntityMngrLocal{

    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    @EJB
    private FarmSectionEntityMngrLocal farmSectionEntityMngr;
    
    @Override
    public Product create(Product product) {
        String sectionId = product.getSectionId().getSectionId();
        product.setSectionId(farmSectionEntityMngr.get(sectionId));
        return crudServiceProvider.create(product);
    }

    @Override
    public Product update(Product product) {
        String sectionId = product.getSectionId().getSectionId();
        product.setSectionId(farmSectionEntityMngr.get(sectionId));
        return crudServiceProvider.update(product);
    }

    @Override
    public void delete(String productId) {
        Product product = get(productId);
        crudServiceProvider.delete(product);
    }

    @Override
    public Product get(String productId) {
        return crudServiceProvider.find(productId, Product.class);
    }

    @Override
    public List<Product> getAll() {
        return crudServiceProvider.findByNamedQuery("Product.findAll", 
                Product.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }

    @Override
    public List<Product> getProducts(String sectionId) {
        return crudServiceProvider.findByNamedQuery("Product.findBySection",
                with("sectionId",sectionId)
                .parameters(), 
                Product.class);
    }
    
}
