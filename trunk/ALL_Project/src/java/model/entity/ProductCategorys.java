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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ProductCategorys", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ProductCategorys.findAll", query = "SELECT p FROM ProductCategorys p"),
    @NamedQuery(name = "ProductCategorys.findByProductCategoryID", query = "SELECT p FROM ProductCategorys p WHERE p.productCategoryID = :productCategoryID"),
    @NamedQuery(name = "ProductCategorys.findByProductCategoryName", query = "SELECT p FROM ProductCategorys p WHERE p.productCategoryName = :productCategoryName"),
    @NamedQuery(name = "ProductCategorys.findByDescription", query = "SELECT p FROM ProductCategorys p WHERE p.description = :description"),
    @NamedQuery(name = "ProductCategorys.findByStatus", query = "SELECT p FROM ProductCategorys p WHERE p.status = :status")})
public class ProductCategorys implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductCategoryID", nullable = false)
    private Integer productCategoryID;
    @Column(name = "productCategoryName", length = 30)
    private String productCategoryName;
    @Column(name = "Description", length = 1073741823)
    private String description;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "productCategorys")
    private Collection<ProductDetails> productDetailsCollection;

    public ProductCategorys() {
    }

    public ProductCategorys(Integer productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public Integer getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(Integer productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<ProductDetails> getProductDetailsCollection() {
        return productDetailsCollection;
    }

    public void setProductDetailsCollection(Collection<ProductDetails> productDetailsCollection) {
        this.productDetailsCollection = productDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCategoryID != null ? productCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategorys)) {
            return false;
        }
        ProductCategorys other = (ProductCategorys) object;
        if ((this.productCategoryID == null && other.productCategoryID != null) || (this.productCategoryID != null && !this.productCategoryID.equals(other.productCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.ProductCategorys[productCategoryID=" + productCategoryID + "]";
    }

}
