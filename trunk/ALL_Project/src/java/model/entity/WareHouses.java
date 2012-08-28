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
@Table(name = "WareHouses", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "WareHouses.findAll", query = "SELECT w FROM WareHouses w"),
    @NamedQuery(name = "WareHouses.findByWareHouseID", query = "SELECT w FROM WareHouses w WHERE w.wareHouseID = :wareHouseID"),
    @NamedQuery(name = "WareHouses.findByWareHouseName", query = "SELECT w FROM WareHouses w WHERE w.wareHouseName = :wareHouseName"),
    @NamedQuery(name = "WareHouses.findByAddress", query = "SELECT w FROM WareHouses w WHERE w.address = :address"),
    @NamedQuery(name = "WareHouses.findByCity", query = "SELECT w FROM WareHouses w WHERE w.city = :city"),
    @NamedQuery(name = "WareHouses.findByRegion", query = "SELECT w FROM WareHouses w WHERE w.region = :region"),
    @NamedQuery(name = "WareHouses.findByCountry", query = "SELECT w FROM WareHouses w WHERE w.country = :country"),
    @NamedQuery(name = "WareHouses.findByStatus", query = "SELECT w FROM WareHouses w WHERE w.status = :status")})
public class WareHouses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WareHouseID", nullable = false)
    private Integer wareHouseID;
    @Column(name = "WareHouseName", length = 50)
    private String wareHouseName;
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
    @JoinColumn(name = "FactoryID", referencedColumnName = "FactoryID")
    @ManyToOne
    private Factorys factorys;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accounts;
    @OneToMany(mappedBy = "wareHouses")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "wareHouses")
    private Collection<ProductsInStock> productsInStockCollection;

    public WareHouses() {
    }

    public WareHouses(Integer wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    public Integer getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(Integer wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
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

    public Factorys getFactorys() {
        return factorys;
    }

    public void setFactorys(Factorys factorys) {
        this.factorys = factorys;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Collection<ProductsInStock> getProductsInStockCollection() {
        return productsInStockCollection;
    }

    public void setProductsInStockCollection(Collection<ProductsInStock> productsInStockCollection) {
        this.productsInStockCollection = productsInStockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wareHouseID != null ? wareHouseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WareHouses)) {
            return false;
        }
        WareHouses other = (WareHouses) object;
        if ((this.wareHouseID == null && other.wareHouseID != null) || (this.wareHouseID != null && !this.wareHouseID.equals(other.wareHouseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.WareHouses[wareHouseID=" + wareHouseID + "]";
    }

}
