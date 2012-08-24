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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Factorys", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Factorys.findAll", query = "SELECT f FROM Factorys f"),
    @NamedQuery(name = "Factorys.findByFactoryID", query = "SELECT f FROM Factorys f WHERE f.factoryID = :factoryID"),
    @NamedQuery(name = "Factorys.findByFactoryName", query = "SELECT f FROM Factorys f WHERE f.factoryName = :factoryName"),
    @NamedQuery(name = "Factorys.findByAddress", query = "SELECT f FROM Factorys f WHERE f.address = :address"),
    @NamedQuery(name = "Factorys.findByCity", query = "SELECT f FROM Factorys f WHERE f.city = :city"),
    @NamedQuery(name = "Factorys.findByRegion", query = "SELECT f FROM Factorys f WHERE f.region = :region"),
    @NamedQuery(name = "Factorys.findByCountry", query = "SELECT f FROM Factorys f WHERE f.country = :country"),
    @NamedQuery(name = "Factorys.findByStatus", query = "SELECT f FROM Factorys f WHERE f.status = :status")})
public class Factorys implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FactoryID", nullable = false)
    private Integer factoryID;
    @Column(name = "FactoryName", length = 50)
    private String factoryName;
    @Column(name = "Address", length = 50)
    private String address;
    @Column(name = "City", length = 50)
    private String city;
    @Column(name = "Region", length = 50)
    private String region;
    @Column(name = "Country", length = 50)
    private String country;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "factorys")
    private Collection<WareHouses> wareHousesCollection;

    public Factorys() {
    }

    public Factorys(Integer factoryID) {
        this.factoryID = factoryID;
    }

    public Integer getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(Integer factoryID) {
        this.factoryID = factoryID;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<WareHouses> getWareHousesCollection() {
        return wareHousesCollection;
    }

    public void setWareHousesCollection(Collection<WareHouses> wareHousesCollection) {
        this.wareHousesCollection = wareHousesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factoryID != null ? factoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factorys)) {
            return false;
        }
        Factorys other = (Factorys) object;
        if ((this.factoryID == null && other.factoryID != null) || (this.factoryID != null && !this.factoryID.equals(other.factoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Factorys[factoryID=" + factoryID + "]";
    }

}
