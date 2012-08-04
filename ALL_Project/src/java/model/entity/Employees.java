/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Employees", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeID", query = "SELECT e FROM Employees e WHERE e.employeeID = :employeeID")})
public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeID;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne
    private Departments departments;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accounts;

    public Employees() {
    }

    public Employees(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Employees[employeeID=" + employeeID + "]";
    }

}
