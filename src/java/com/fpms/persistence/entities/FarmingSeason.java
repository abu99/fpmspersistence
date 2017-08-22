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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aabello
 */
@Entity
@Table(name = "farming_season")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmingSeason.findAll", query = "SELECT f FROM FarmingSeason f"),
    @NamedQuery(name = "FarmingSeason.findBySectionId", query = "SELECT f FROM FarmingSeason f WHERE f.farmingSeasonPK.sectionId = :sectionId"),
    @NamedQuery(name = "FarmingSeason.findByStartDate", query = "SELECT f FROM FarmingSeason f WHERE f.farmingSeasonPK.startDate = :startDate"),
    @NamedQuery(name = "FarmingSeason.findByEndDate", query = "SELECT f FROM FarmingSeason f WHERE f.endDate = :endDate"),
    @NamedQuery(name = "FarmingSeason.findByDescription", query = "SELECT f FROM FarmingSeason f WHERE f.description = :description")})
public class FarmingSeason implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FarmingSeasonPK farmingSeasonPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 32)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FarmSection farmSection;

    public FarmingSeason() {
    }

    public FarmingSeason(FarmingSeasonPK farmingSeasonPK) {
        this.farmingSeasonPK = farmingSeasonPK;
    }

    public FarmingSeason(FarmingSeasonPK farmingSeasonPK, Date endDate) {
        this.farmingSeasonPK = farmingSeasonPK;
        this.endDate = endDate;
    }

    public FarmingSeason(String sectionId, Date startDate) {
        this.farmingSeasonPK = new FarmingSeasonPK(sectionId, startDate);
    }

    public FarmingSeasonPK getFarmingSeasonPK() {
        return farmingSeasonPK;
    }

    public void setFarmingSeasonPK(FarmingSeasonPK farmingSeasonPK) {
        this.farmingSeasonPK = farmingSeasonPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FarmSection getFarmSection() {
        return farmSection;
    }

    public void setFarmSection(FarmSection farmSection) {
        this.farmSection = farmSection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (farmingSeasonPK != null ? farmingSeasonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmingSeason)) {
            return false;
        }
        FarmingSeason other = (FarmingSeason) object;
        if ((this.farmingSeasonPK == null && other.farmingSeasonPK != null) || (this.farmingSeasonPK != null && !this.farmingSeasonPK.equals(other.farmingSeasonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.FarmingSeason[ farmingSeasonPK=" + farmingSeasonPK + " ]";
    }
    
}
