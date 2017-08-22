/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aabello
 */
@Entity
@Table(name = "farm_section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmSection.findAll", query = "SELECT f FROM FarmSection f"),
    @NamedQuery(name = "FarmSection.findBySectionId", query = "SELECT f FROM FarmSection f WHERE f.sectionId = :sectionId"),
    @NamedQuery(name = "FarmSection.findBySectionName", query = "SELECT f FROM FarmSection f WHERE f.sectionName = :sectionName"),
    @NamedQuery(name = "FarmSection.findByDescription", query = "SELECT f FROM FarmSection f WHERE f.description = :description")})
public class FarmSection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "section_id", nullable = false, length = 32)
    private String sectionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "section_name", nullable = false, length = 32)
    private String sectionName;
    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectionId")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmSection")
    private Collection<Stock> stockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmSection")
    private Collection<FarmingSeason> farmingSeasonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmSection")
    private Collection<ProductOtherUnits> productOtherUnitsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectionId")
    private Collection<Expenses> expensesCollection;

    public FarmSection() {
    }

    public FarmSection(String sectionId) {
        this.sectionId = sectionId;
    }

    public FarmSection(String sectionId, String sectionName) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @XmlTransient
    public Collection<FarmingSeason> getFarmingSeasonCollection() {
        return farmingSeasonCollection;
    }

    public void setFarmingSeasonCollection(Collection<FarmingSeason> farmingSeasonCollection) {
        this.farmingSeasonCollection = farmingSeasonCollection;
    }

    @XmlTransient
    public Collection<ProductOtherUnits> getProductOtherUnitsCollection() {
        return productOtherUnitsCollection;
    }

    public void setProductOtherUnitsCollection(Collection<ProductOtherUnits> productOtherUnitsCollection) {
        this.productOtherUnitsCollection = productOtherUnitsCollection;
    }

    @XmlTransient
    public Collection<Expenses> getExpensesCollection() {
        return expensesCollection;
    }

    public void setExpensesCollection(Collection<Expenses> expensesCollection) {
        this.expensesCollection = expensesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmSection)) {
            return false;
        }
        FarmSection other = (FarmSection) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.FarmSection[ sectionId=" + sectionId + " ]";
    }
    
}
