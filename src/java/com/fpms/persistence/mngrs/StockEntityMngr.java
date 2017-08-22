/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;
import static com.fpms.util.crud.QueryParameter.*;
import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.Product;
import com.fpms.persistence.entities.Stock;
import com.fpms.persistence.entities.StockPK;
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
public class StockEntityMngr implements StockEntityMngrLocal{

    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    @EJB
    private ProductEntityMngrLocal productEntityMngr;
    @EJB
    private FarmSectionEntityMngrLocal sectionEntityMngr;
    
    @Override
    public Stock create(Stock stock) {
        String productId = stock.getStockPK().getProductId();
        String sectionId = stock.getStockPK().getSectionId();
        FarmSection section = sectionEntityMngr.get(sectionId);
        Product product = productEntityMngr.get(productId);
        stock.setFarmSection(section);
        stock.setProduct(product);
        return crudServiceProvider.create(stock);
    }

    @Override
    public Stock update(Stock stock) {
        String productId = stock.getStockPK().getProductId();
        String sectionId = stock.getStockPK().getSectionId();
        FarmSection section = sectionEntityMngr.get(sectionId);
        Product product = productEntityMngr.get(productId);
        stock.setFarmSection(section);
        stock.setProduct(product);
        return crudServiceProvider.update(stock);
    }

    @Override
    public void delete(String productId, String sectionId, Date date) {
        Stock stock = get(productId, sectionId, date);
        crudServiceProvider.delete(stock);
    }

    @Override
    public Stock get(String productId, String sectionId, Date date) {
        StockPK stockPk = new StockPK(productId, sectionId, date);
        return crudServiceProvider.find(stockPk, Stock.class);
    }

    @Override
    public List<Stock> getAll() {
        return crudServiceProvider.findByNamedQuery("Stock.findAll", Stock.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }

    @Override
    public List<Stock> getStocksBetween(Date from, Date to) {
        
        return crudServiceProvider.findByNamedQuery("Stock.findBetween",
                with("dateCreated1",from)
                .and("dateCreated2", to)
                .parameters(),
                Stock.class);
             
    }

    @Override
    public List<Stock> getStocksBetweenAndStockType(Date from, Date to, String stockType) {
        
        return crudServiceProvider.findByNamedQuery("Stock.findByBetweenAndStockType",
                with("dateCreated1",from)
                .and("dateCreated2", to)
                .and("stockType", stockType)
                .parameters(),
                Stock.class);
    }

    @Override
    public List<Stock> getStocksBySectionBetween(String sectionId, Date from, Date to) {
        
        return crudServiceProvider.findByNamedQuery("Stock.findBySectionBetween",
                with("sectionId", sectionId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(),
                 Stock.class);
    }

    @Override
    public List<Stock> getStockBySectionAndStockTypeBetween(String sectionId, Date from, Date to, String stockType) {
        
        return crudServiceProvider.findByNamedQuery("Stock.findBySectionAndStockTypeBetween",
                with("sectionId", sectionId)
                .and("dateCreated1", from)
                .and("dateCreated2", to).
                and("stockType", stockType)
                .parameters(),
                Stock.class);
    }

    @Override
    public List<Stock> getStocksByproductBetween(String productId, Date from, Date to) {
        return crudServiceProvider.findByNamedQuery("Stock.findByProductBetween", 
                with("productId", productId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(), 
                Stock.class);
    }

    @Override
    public List<Stock> getStocksByProductAndStockTypeBetween(String productId, Date from, Date to, String stockType) {
        return crudServiceProvider.findByNamedQuery("Stock.findByProductAndStockTypeBetween", 
                with("productId", productId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .and("stockType", stockType)
                .parameters(), 
                Stock.class);
    }

    @Override
    public List<Stock> getStocksBySection(String sectionId) {
        return crudServiceProvider.findByNamedQuery("Stock.findBySectionId", 
                with("sectionId", 
                sectionId).parameters(), 
                Stock.class);
    }

    @Override
    public List<Stock> getStockByProduct(String productId) {
        return crudServiceProvider.findByNamedQuery("Stock.findByProductId", 
                with("productId", 
                productId).parameters(), 
                Stock.class);
    }

    @Override
    public List<Stock> getStocksByStockType(String stockType) {
        return crudServiceProvider.findByNamedQuery("Stock.findByStockType", 
                with("stockType", stockType)
                .parameters(), 
                Stock.class);
    }
    
    @Override
    public List<Stock> getStocksByProductAndSection(String productId, String sectionId){
        return crudServiceProvider.findByNamedQuery("Stock.findByProductAndSection", 
                with("productId", productId).
                and("sectionId", sectionId).
                parameters(),Stock.class);
    }

    @Override
    public List<Stock> getStocksBySectionAndDate(String sectionId, Date date) {
        return crudServiceProvider.findByNamedQuery("Stock.findBySectionAndDate",
                with("sectionid", sectionId)
                .and("date", date)
                .parameters(),
                Stock.class);
    }

    @Override
    public List<Stock> getStocKsBySectionAndStockType(String sectionId, String stockType) {
        return crudServiceProvider.findByNamedQuery("Stock.findBySectionAndStockType",
                with("sectionId", sectionId)
                .and("stockType", stockType)
                .parameters(),
                Stock.class);
    }
}
