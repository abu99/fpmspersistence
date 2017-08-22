/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aabello
 */
@Entity
@Table(name = "product_other_units")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductOtherUnits.findAll", query = "SELECT p FROM ProductOtherUnits p"),
    @NamedQuery(name = "ProductOtherUnits.findByProductId", query = "SELECT p FROM ProductOtherUnits p WHERE p.productOtherUnitsPK.productId = :productId"),
    @NamedQuery(name = "ProductOtherUnits.findBySectionId", query = "SELECT p FROM ProductOtherUnits p WHERE p.productOtherUnitsPK.sectionId = :sectionId"),
    @NamedQuery(name = "ProductOtherUnits.findByUnitName", query = "SELECT p FROM ProductOtherUnits p WHERE p.productOtherUnitsPK.unitName = :unitName"),
    @NamedQuery(name = "ProductOtherUnits.findByCount", query = "SELECT p FROM ProductOtherUnits p WHERE p.count = :count")})
public class ProductOtherUnits implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductOtherUnitsPK productOtherUnitsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count")
    private int count;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FarmSection farmSection;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductOtherUnits() {
    }

    public ProductOtherUnits(ProductOtherUnitsPK productOtherUnitsPK) {
        this.productOtherUnitsPK = productOtherUnitsPK;
    }

    public ProductOtherUnits(ProductOtherUnitsPK productOtherUnitsPK, int count) {
        this.productOtherUnitsPK = productOtherUnitsPK;
        this.count = count;
    }

    public ProductOtherUnits(String productId, String sectionId, String unitName) {
        this.productOtherUnitsPK = new ProductOtherUnitsPK(productId, sectionId, unitName);
    }

    public ProductOtherUnitsPK getProductOtherUnitsPK() {
        return productOtherUnitsPK;
    }

    public void setProductOtherUnitsPK(ProductOtherUnitsPK productOtherUnitsPK) {
        this.productOtherUnitsPK = productOtherUnitsPK;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        hash += (productOtherUnitsPK != null ? productOtherUnitsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductOtherUnits)) {
            return false;
        }
        ProductOtherUnits other = (ProductOtherUnits) object;
        if ((this.productOtherUnitsPK == null && other.productOtherUnitsPK != null) || (this.productOtherUnitsPK != null && !this.productOtherUnitsPK.equals(other.productOtherUnitsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.ProductOtherUnits[ productOtherUnitsPK=" + productOtherUnitsPK + " ]";
    }
    
}
