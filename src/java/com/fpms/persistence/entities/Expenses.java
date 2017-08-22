/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "expenses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e"),
    @NamedQuery(name = "Expenses.findByExpensesId", query = "SELECT e FROM Expenses e WHERE e.expensesId = :expensesId"),
    @NamedQuery(name = "Expenses.findByAmount", query = "SELECT e FROM Expenses e WHERE e.amount = :amount"),
    @NamedQuery(name = "Expenses.findByDateCreated", query = "SELECT e FROM Expenses e WHERE e.dateCreated = :dateCreated"),
    @NamedQuery(name = "Expenses.findByRemarks", query = "SELECT e FROM Expenses e WHERE e.remarks = :remarks")})
public class Expenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "expenses_id")
    private String expensesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    @ManyToOne(optional = false)
    private FarmSection sectionId;
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne(optional = false)
    private ExpenseType typeId;

    public Expenses() {
    }

    public Expenses(String expensesId) {
        this.expensesId = expensesId;
    }

    public Expenses(String expensesId, double amount, Date dateCreated, String remarks) {
        this.expensesId = expensesId;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.remarks = remarks;
    }

    public String getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(String expensesId) {
        this.expensesId = expensesId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public FarmSection getSectionId() {
        return sectionId;
    }

    public void setSectionId(FarmSection sectionId) {
        this.sectionId = sectionId;
    }

    public ExpenseType getTypeId() {
        return typeId;
    }

    public void setTypeId(ExpenseType typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expensesId != null ? expensesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.expensesId == null && other.expensesId != null) || (this.expensesId != null && !this.expensesId.equals(other.expensesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpms.persistence.entities.Expenses[ expensesId=" + expensesId + " ]";
    }
    
}
