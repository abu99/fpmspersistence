/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "farm_info", catalog = "fpms", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmInfo.findAll", query = "SELECT f FROM FarmInfo f"),
    @NamedQuery(name = "FarmInfo.findByFarmId", query = "SELECT f FROM FarmInfo f WHERE f.farmId = :farmId"),
    @NamedQuery(name = "FarmInfo.findByFarmName", query = "SELECT f FROM FarmInfo f WHERE f.farmName = :farmName"),
    @NamedQuery(name = "FarmInfo.findByAddress", query = "SELECT f FROM FarmInfo f WHERE f.address = :address"),
    @NamedQuery(name = "FarmInfo.findByCity", query = "SELECT f FROM FarmInfo f WHERE f.city = :city"),
    @NamedQuery(name = "FarmInfo.findByFarmState", query = "SELECT f FROM FarmInfo f WHERE f.farmState = :farmState"),
    @NamedQuery(name = "FarmInfo.findByPhone", query = "SELECT f FROM FarmInfo f WHERE f.phone = :phone"),
    @NamedQuery(name = "FarmInfo.findByEmail", query = "SELECT f FROM FarmInfo f WHERE f.email = :email"),
    @NamedQuery(name = "FarmInfo.findByWebsite", query = "SELECT f FROM FarmInfo f WHERE f.website = :website")})
public class FarmInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "farmId")
    private String farmId;
    @Size(max = 64)
    @Column(name = "farmName")
    private String farmName;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 32)
    @Column(name = "city")
    private String city;
    @Size(max = 32)
    @Column(name = "farmState")
    private String farmState;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    @Size(max = 64)
    @Column(name = "website")
    private String website;

    public FarmInfo() {
    }

    public FarmInfo(String farmId) {
        this.farmId = farmId;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFarmState() {
        return farmState;
    }

    public void setFarmState(String farmState) {
        this.farmState = farmState;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (farmId != null ? farmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmInfo)) {
            return false;
        }
        FarmInfo other = (FarmInfo) object;
        if ((this.farmId == null && other.farmId != null) || (this.farmId != null && !this.farmId.equals(other.farmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.FarmInfo[ farmId=" + farmId + " ]";
    }
    
}
