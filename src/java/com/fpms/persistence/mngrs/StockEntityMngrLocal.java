/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.Stock;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface StockEntityMngrLocal {
    
    public Stock create(Stock stock);
    public Stock update(Stock stock);
    public void delete(String productId, String sectionId, Date date);
    public Stock get(String productId, String sectionId, Date date);
    public List<Stock> getAll();
    public int count();
    

    public List<Stock> getStocksBetween(Date from, Date to);

    public List<Stock> getStocksBetweenAndStockType(Date from, Date to, String stockType);
    
    public List<Stock> getStocksBySection(String sectionId);
    
    public List<Stock> getStocksBySectionBetween(String sectionId, Date from, Date to);

    public List<Stock> getStockBySectionAndStockTypeBetween(String sectionId,
            Date from, Date to, String stockType);
    
    public List<Stock> getStockByProduct(String productId);

    public List<Stock> getStocksByproductBetween(String productId, Date from, Date to);

    public List<Stock> getStocksByProductAndStockTypeBetween(String productId, Date from, Date to, String stockType);
    
    public List<Stock> getStocksByStockType(String stockType);

    public List<Stock> getStocksByProductAndSection(String productId, String sectionId);
    
    public List<Stock> getStocksBySectionAndDate(String sectionId, Date date);
    
    public List<Stock> getStocKsBySectionAndStockType(String sectionId, String stockType);
    
    
}
