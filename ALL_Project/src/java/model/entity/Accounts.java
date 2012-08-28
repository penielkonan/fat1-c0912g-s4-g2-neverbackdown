/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Accounts", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccountID", query = "SELECT a FROM Accounts a WHERE a.accountID = :accountID"),
    @NamedQuery(name = "Accounts.findByEmail", query = "SELECT a FROM Accounts a WHERE a.email = :email"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password"),
    @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccountID", nullable = false)
    private Integer accountID;
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "Password", length = 50)
    private String password;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne
    private Departments departments;
    @OneToMany(mappedBy = "accounts")
    private Collection<WareHouses> wareHousesCollection;
    @OneToMany(mappedBy = "accounts")
    private Collection<AccountInformations> accountInformationsCollection;
    @OneToMany(mappedBy = "accounts")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "accounts")
    private Collection<LogStores> logStoresCollection;

    public Accounts() {
    }

    public Accounts(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Collection<WareHouses> getWareHousesCollection() {
        return wareHousesCollection;
    }

    public void setWareHousesCollection(Collection<WareHouses> wareHousesCollection) {
        this.wareHousesCollection = wareHousesCollection;
    }

    public Collection<AccountInformations> getAccountInformationsCollection() {
        return accountInformationsCollection;
    }

    public void setAccountInformationsCollection(Collection<AccountInformations> accountInformationsCollection) {
        this.accountInformationsCollection = accountInformationsCollection;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Collection<LogStores> getLogStoresCollection() {
        return logStoresCollection;
    }

    public void setLogStoresCollection(Collection<LogStores> logStoresCollection) {
        this.logStoresCollection = logStoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Accounts[accountID=" + accountID + "]";
    }

}
