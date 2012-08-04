/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Accounts", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccountID", query = "SELECT a FROM Accounts a WHERE a.accountID = :accountID"),
    @NamedQuery(name = "Accounts.findByUserName", query = "SELECT a FROM Accounts a WHERE a.userName = :userName"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password"),
    @NamedQuery(name = "Accounts.findByCreationDate", query = "SELECT a FROM Accounts a WHERE a.creationDate = :creationDate"),
    @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AccountID", nullable = false)
    private Integer accountID;
    @Column(name = "UserName", length = 50)
    private String userName;
    @Column(name = "Password", length = 50)
    private String password;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "accounts")
    private Collection<AccountInformations> accountInformationsCollection;
    @OneToMany(mappedBy = "accounts")
    private Collection<Employees> employeesCollection;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<AccountInformations> getAccountInformationsCollection() {
        return accountInformationsCollection;
    }

    public void setAccountInformationsCollection(Collection<AccountInformations> accountInformationsCollection) {
        this.accountInformationsCollection = accountInformationsCollection;
    }

    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
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
