/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aabello
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByProductId", query = "SELECT s FROM Stock s WHERE s.stockPK.productId = :productId"),
    @NamedQuery(name = "Stock.findBySectionId", query = "SELECT s FROM Stock s WHERE s.stockPK.sectionId = :sectionId"),
    @NamedQuery(name = "Stock.findByQuatity", query = "SELECT s FROM Stock s WHERE s.quatity = :quatity"),
    @NamedQuery(name = "Stock.findByAmount", query = "SELECT s FROM Stock s WHERE s.amount = :amount"),
    @NamedQuery(name = "Stock.findByStockType", query = "SELECT s FROM Stock s WHERE s.stockType = :stockType"),
    @NamedQuery(name = "Stock.findByDateCreated", query = "SELECT s FROM Stock s WHERE s.stockPK.dateCreated = :dateCreated"),
    @NamedQuery(name = "Stock.findByRemarks", query = "SELECT s FROM Stock s WHERE s.remarks = :remarks")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockPK stockPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quatity")
    private int quatity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "stock_type")
    private String stockType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FarmSection farmSection;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Stock() {
    }

    public Stock(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public Stock(StockPK stockPK, int quatity, double amount, String stockType, String remarks) {
        this.stockPK = stockPK;
        this.quatity = quatity;
        this.amount = amount;
        this.stockType = stockType;
        this.remarks = remarks;
    }

    public Stock(String productId, String sectionId, Date dateCreated) {
        this.stockPK = new StockPK(productId, sectionId, dateCreated);
    }

    public StockPK getStockPK() {
        return stockPK;
    }

    public void setStockPK(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public FarmSection getFarmSection() {
        return farmSection;
    }

    public void setFarmSection(FarmSection farmSection) {
        this.farmSection = farmSection;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockPK != null ? stockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockPK == null && other.stockPK != null) || (this.stockPK != null && !this.stockPK.equals(other.stockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.Stock[ stockPK=" + stockPK + " ]";
    }
    
}
