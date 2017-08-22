/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.util;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aabello
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Expenses.findBetween", 
        query = "SELECT e FROM Expenses e "
        + "WHERE e.dateCreated BETWEEN :dateCreated1 AND :dateCreated2"),
    
    @NamedQuery(name = "Expenses.findByExpenseTypeAndBetween", 
        query = "SELECT e FROM Expenses e "
        + "WHERE e.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND e.typeId.typeId = :typeId"),
    
    @NamedQuery(name = "Expenses.findBySectionExpenseTypeAndBetween", 
        query = "SELECT e FROM Expenses e "
        + "WHERE e.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND e.typeId.typeId = :typeId "
        + "AND e.sectionId.sectionId = :sectionId"),
    
    @NamedQuery(name = "Expenses.findBySectionAndBetween", 
        query = "SELECT e FROM Expenses e "
        + "WHERE e.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND e.sectionId.sectionId = :sectionId"),
    
    @NamedQuery(name = "Expenses.findBySection",
        query = "SELECT e FROM Expenses e "
        + "WHERE e.sectionId.sectionId = :sectionId"),
    
    @NamedQuery(name = "Expenses.findBySectionAndType",
        query = "SELECT e FROM Expenses e "
        + "WHERE e.sectionId.sectionId = :sectionId "
        + "AND e.typeId.typeId = :typeId "),
    
    @NamedQuery(name = "Expenses.findByType",
        query = "SELECT e FROM Expenses e "
        + "WHERE e.typeId.typeId = :typeId"),
    
    @NamedQuery(name = "Product.findBySection",
        query = "SELECT p FROM Product p "
        + "WHERE p.sectionId.sectionId = :sectionId"),
    
    @NamedQuery(name = "Stock.findBetween", 
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.dateCreated BETWEEN :dateCreated1 AND :dateCreated2"),
    
    @NamedQuery(name = "Stock.findByBetweenAndStockType", 
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND s.stockType = :stockType"),
    
    @NamedQuery(name = "Stock.findBySectionBetween", 
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND s.stockPK.sectionId = :sectionId"),
    
    @NamedQuery(name = "Stock.findBySectionAndDate",
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.sectionId = :sectionId "
        + "AND s.stockPK.dateCreated = :dateCreated"),
    
    @NamedQuery(name = "Stock.findBySectionAndStockType",
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.sectionId = :sectionId "
        + "AND s.stockType = :stockType"),
    
    @NamedQuery(name = "Stock.findBySectionAndStockTypeBetween", 
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND s.stockType = :stockType "
        + "AND s.stockPK.sectionId = :sectionId"),
    
    @NamedQuery(name = "Stock.findByProductBetween", 
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND s.stockPK.productId = :productId"),
    
    @NamedQuery(name = "Stock.findByProductAndStockTypeBetween", 
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.dateCreated BETWEEN :dateCreated1 AND :dateCreated2 "
        + "AND s.stockType = :stockType "
        + "AND s.stockPK.productId = :productId"),
    
    @NamedQuery(name = "Stock.findByProductAndSection",
        query = "SELECT s FROM Stock s "
        + "WHERE s.stockPK.productId = :productId "
        + "AND s.stockPK.sectionId = :sectionId")
})
public class StoredProcedures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoredProcedures)) {
            return false;
        }
        StoredProcedures other = (StoredProcedures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.util.StoredProcedures[ id=" + id + " ]";
    }
    
}
