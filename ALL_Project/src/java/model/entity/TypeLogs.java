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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "TypeLogs", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TypeLogs.findAll", query = "SELECT t FROM TypeLogs t"),
    @NamedQuery(name = "TypeLogs.findByTypeLogID", query = "SELECT t FROM TypeLogs t WHERE t.typeLogID = :typeLogID"),
    @NamedQuery(name = "TypeLogs.findByTypeName", query = "SELECT t FROM TypeLogs t WHERE t.typeName = :typeName")})
public class TypeLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TypeLogID", nullable = false)
    private Integer typeLogID;
    @Column(name = "TypeName", length = 50)
    private String typeName;
    @Lob
    @Column(name = "Description", length = 2147483647)
    private String description;
    @OneToMany(mappedBy = "typeLogs")
    private Collection<LogStores> logStoresCollection;

    public TypeLogs() {
    }

    public TypeLogs(Integer typeLogID) {
        this.typeLogID = typeLogID;
    }

    public Integer getTypeLogID() {
        return typeLogID;
    }

    public void setTypeLogID(Integer typeLogID) {
        this.typeLogID = typeLogID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (typeLogID != null ? typeLogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLogs)) {
            return false;
        }
        TypeLogs other = (TypeLogs) object;
        if ((this.typeLogID == null && other.typeLogID != null) || (this.typeLogID != null && !this.typeLogID.equals(other.typeLogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.TypeLogs[typeLogID=" + typeLogID + "]";
    }

}
