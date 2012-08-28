/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "LogStores", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "LogStores.findAll", query = "SELECT l FROM LogStores l"),
    @NamedQuery(name = "LogStores.findByLogID", query = "SELECT l FROM LogStores l WHERE l.logID = :logID"),
    @NamedQuery(name = "LogStores.findByAtTime", query = "SELECT l FROM LogStores l WHERE l.atTime = :atTime"),
    @NamedQuery(name = "LogStores.findByStatus", query = "SELECT l FROM LogStores l WHERE l.status = :status")})
public class LogStores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LogID", nullable = false)
    private Integer logID;
    @Column(name = "AtTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atTime;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "TypeLogID", referencedColumnName = "TypeLogID")
    @ManyToOne
    private TypeLogs typeLogs;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accounts;

    public LogStores() {
    }

    public LogStores(Integer logID) {
        this.logID = logID;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public Date getAtTime() {
        return atTime;
    }

    public void setAtTime(Date atTime) {
        this.atTime = atTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TypeLogs getTypeLogs() {
        return typeLogs;
    }

    public void setTypeLogs(TypeLogs typeLogs) {
        this.typeLogs = typeLogs;
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
        hash += (logID != null ? logID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogStores)) {
            return false;
        }
        LogStores other = (LogStores) object;
        if ((this.logID == null && other.logID != null) || (this.logID != null && !this.logID.equals(other.logID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.LogStores[logID=" + logID + "]";
    }

}
