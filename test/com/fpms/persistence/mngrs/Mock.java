/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ExpenseType;
import com.fpms.persistence.entities.Expenses;
import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.FarmingSeason;
import com.fpms.persistence.entities.FarmingSeasonPK;
import com.fpms.persistence.entities.Product;
import com.fpms.persistence.entities.ProductOtherUnits;
import com.fpms.persistence.entities.ProductOtherUnitsPK;
import com.fpms.persistence.entities.Stock;
import com.fpms.persistence.entities.StockPK;
import com.fpms.persistence.entities.User;
import com.fpms.persistence.test.common.ServiceLocator;
import java.util.Date;

/**
 *
 * @author aabello
 */
public class Mock {
    static ExpenseType expenseType;
    static FarmSection section;
    static FarmingSeasonPK seasonPK;
    static ProductOtherUnitsPK PoUPK;
    static StockPK stockPK;

    public static void setUpExpenses() throws Exception {
        
        ExpensesEntityMngrLocal instance = new ServiceLocator().
                lookup(ExpensesEntityMngrLocal.class);
        setUpExpenseType();
        setUpSections();
        expenseType = new ExpenseType("ex01");
        section = new FarmSection("SEC01");
        Expenses ex = new Expenses("exp01", 1000, new Date(2013-1900, 6, 17),
                "payed salaries of staff");
        ex.setTypeId(expenseType);
        ex.setSectionId(section);
        
        instance.create(ex);
    }
    
    public static void cleanUpExpenses() throws Exception{
        
        ExpensesEntityMngrLocal instance = new ServiceLocator().
                lookup(ExpensesEntityMngrLocal.class);
        
        instance.delete("exp01");
        cleanUpSections();
        cleanUpExpenseType();
    }
    
    public static void setUpUser() throws Exception {
        UserEntityMngrLocal instance = new ServiceLocator().
                lookup(UserEntityMngrLocal.class);
        User user = new User("user002", "Abubakar Bello", "modibbos", "Farm Manager");
        
        instance.create(user);
    }

    public static void cleanUpUser() throws Exception{
        UserEntityMngrLocal instance = new ServiceLocator().
                lookup(UserEntityMngrLocal.class);
        instance.delete("user002");
    }
    
    public static void setUpSections() throws Exception{
        
        FarmSectionEntityMngrLocal instance = new ServiceLocator().
                lookup(FarmSectionEntityMngrLocal.class);
        
        FarmSection section = new FarmSection("SEC01", "Poultry");
        FarmSection section2 = new FarmSection("SEC02", "Animal Production");
        instance.create(section);
        instance.create(section2);
        
    }
    
    public static void cleanUpSections() throws Exception{
        
        FarmSectionEntityMngrLocal instance = new ServiceLocator().
                lookup(FarmSectionEntityMngrLocal.class);
        
        instance.delete("SEC01");
        instance.delete("SEC02");
    }
    
    public static void setUpExpenseType() throws Exception{
    
        ExpenseTypeEntityMngrLocal instance = new ServiceLocator().
                lookup(ExpenseTypeEntityMngrLocal.class);
        
        ExpenseType expType = new ExpenseType("ex01", "Machinery");
        
        instance.create(expType);
        
    }
    
    public static void cleanUpExpenseType() throws Exception{
        
        ExpenseTypeEntityMngrLocal instance = new ServiceLocator().
                lookup(ExpenseTypeEntityMngrLocal.class);
        
        instance.delete("ex01");
        
    }
    
    public static void setUpSeason() throws Exception{
        
        FarmingSeasonEntityMngrLocal instance = new ServiceLocator().
                lookup(FarmingSeasonEntityMngrLocal.class);
        setUpSections();
        seasonPK = new FarmingSeasonPK("SEC01", new Date(2012-1900, 9, 1));
        FarmingSeason season = new FarmingSeason(seasonPK, new Date(2013-1900, 9, 2));
        
        instance.create(season);
    
    }
    
    public static void cleanUpSeason() throws Exception{
        FarmingSeasonEntityMngrLocal instance = new ServiceLocator().
                lookup(FarmingSeasonEntityMngrLocal.class);
        instance.delete("SEC01", new Date(2012-1900, 9, 1));
        
        cleanUpSections();
    }

    public static void setUpProduct() throws Exception {
        
        ProductEntityMngrLocal instance = new ServiceLocator().
                lookup(ProductEntityMngrLocal.class);
        setUpSections();
        Product product = new Product("prod1", "maize", "sack");
        product.setSectionId(new FarmSection("SEC01"));
        instance.create(product);
    }

    public static void cleanUpProduct() throws Exception {
        ProductEntityMngrLocal instance = new ServiceLocator().
                lookup(ProductEntityMngrLocal.class);
        instance.delete("prod1");
        cleanUpSections();
    }

    static void setUpProductOtherUnits() throws Exception{
        
        ProductOtherUnitsEntityMngrLocal instance = new ServiceLocator().
                lookup(ProductOtherUnitsEntityMngrLocal.class);
        
        setUpProduct();
        PoUPK = new ProductOtherUnitsPK("prod1", "SEC01", "pack");
        ProductOtherUnits PoU = new ProductOtherUnits();
        PoU.setProductOtherUnitsPK(PoUPK);
        PoU.setCount(24);
        instance.create(PoU);
    }

    static void cleanUpProductOtherUnits() throws Exception{
        ProductOtherUnitsEntityMngrLocal instance = new ServiceLocator().
                lookup(ProductOtherUnitsEntityMngrLocal.class);
        
        instance.delete("prod1", "SEC01", "pack");
        cleanUpProduct();
    
    }

    public static void setUpStock() throws Exception {
        StockEntityMngrLocal instance = new ServiceLocator().
                lookup(StockEntityMngrLocal.class);
        
        setUpProduct();
        
        stockPK = new StockPK("prod1", "SEC01", new Date(2011-1900, 0, 1));
        
        Stock stock = new Stock();
        stock.setStockPK(stockPK);
        stock.setQuatity(24);
        stock.setAmount(10000.0);
        stock.setStockType("IN");
        stock.setRemarks("remarks");
        instance.create(stock);
        
    }

    public static void cleanUpStock() throws Exception{
        
        StockEntityMngrLocal instance = new ServiceLocator().
                lookup(StockEntityMngrLocal.class);
        
        instance.delete("prod1", "SEC01", new Date(2011-1900, 0, 1));
        cleanUpProduct();
    }
}
