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
@Table(name = "ProductsInStock", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ProductsInStock.findAll", query = "SELECT p FROM ProductsInStock p"),
    @NamedQuery(name = "ProductsInStock.findByProductInStockID", query = "SELECT p FROM ProductsInStock p WHERE p.productInStockID = :productInStockID"),
    @NamedQuery(name = "ProductsInStock.findByAmountStock", query = "SELECT p FROM ProductsInStock p WHERE p.amountStock = :amountStock"),
    @NamedQuery(name = "ProductsInStock.findByStatus", query = "SELECT p FROM ProductsInStock p WHERE p.status = :status")})
public class ProductsInStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductInStockID", nullable = false)
    private Integer productInStockID;
    @Column(name = "AmountStock")
    private Integer amountStock;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "WareHouseID", referencedColumnName = "WareHouseID")
    @ManyToOne
    private WareHouses wareHouses;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne
    private ProductDetails productDetails;

    public ProductsInStock() {
    }

    public ProductsInStock(Integer productInStockID) {
        this.productInStockID = productInStockID;
    }

    public Integer getProductInStockID() {
        return productInStockID;
    }

    public void setProductInStockID(Integer productInStockID) {
        this.productInStockID = productInStockID;
    }

    public Integer getAmountStock() {
        return amountStock;
    }

    public void setAmountStock(Integer amountStock) {
        this.amountStock = amountStock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public WareHouses getWareHouses() {
        return wareHouses;
    }

    public void setWareHouses(WareHouses wareHouses) {
        this.wareHouses = wareHouses;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productInStockID != null ? productInStockID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsInStock)) {
            return false;
        }
        ProductsInStock other = (ProductsInStock) object;
        if ((this.productInStockID == null && other.productInStockID != null) || (this.productInStockID != null && !this.productInStockID.equals(other.productInStockID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.ProductsInStock[productInStockID=" + productInStockID + "]";
    }

}
