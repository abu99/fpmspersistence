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
@Table(name = "expense_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpenseType.findAll", query = "SELECT e FROM ExpenseType e"),
    @NamedQuery(name = "ExpenseType.findByTypeId", query = "SELECT e FROM ExpenseType e WHERE e.typeId = :typeId"),
    @NamedQuery(name = "ExpenseType.findByTypeName", query = "SELECT e FROM ExpenseType e WHERE e.typeName = :typeName"),
    @NamedQuery(name = "ExpenseType.findByRemarks", query = "SELECT e FROM ExpenseType e WHERE e.remarks = :remarks")})
public class ExpenseType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "type_id")
    private String typeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "type_name")
    private String typeName;
    @Size(max = 100)
    @Column(name = "remarks")
    private String remarks;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "typeId")
    private Collection<Expenses> expensesCollection;

    public ExpenseType() {
    }

    public ExpenseType(String typeId) {
        this.typeId = typeId;
    }

    public ExpenseType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpenseType)) {
            return false;
        }
        ExpenseType other = (ExpenseType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.ExpenseType[ typeId=" + typeId + " ]";
    }
    
}
