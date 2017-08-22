/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface ProductEntityMngrLocal {
    
    public Product create(Product product);
    public Product update(Product product);
    public void delete(String productId);
    public Product get(String productId);
    public List<Product> getAll();
    public int count();

    public List<Product> getProducts(String sectionId);

    
}
