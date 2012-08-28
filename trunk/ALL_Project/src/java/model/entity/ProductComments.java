/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ProductComments", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ProductComments.findAll", query = "SELECT p FROM ProductComments p"),
    @NamedQuery(name = "ProductComments.findByProductCommentID", query = "SELECT p FROM ProductComments p WHERE p.productCommentID = :productCommentID"),
    @NamedQuery(name = "ProductComments.findByName", query = "SELECT p FROM ProductComments p WHERE p.name = :name"),
    @NamedQuery(name = "ProductComments.findByEmail", query = "SELECT p FROM ProductComments p WHERE p.email = :email"),
    @NamedQuery(name = "ProductComments.findByTitle", query = "SELECT p FROM ProductComments p WHERE p.title = :title"),
    @NamedQuery(name = "ProductComments.findByStatus", query = "SELECT p FROM ProductComments p WHERE p.status = :status")})
public class ProductComments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductCommentID", nullable = false)
    private Integer productCommentID;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "Title", length = 50)
    private String title;
    @Lob
    @Column(name = "Comment", length = 2147483647)
    private String comment;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne
    private ProductDetails productDetails;

    public ProductComments() {
    }

    public ProductComments(Integer productCommentID) {
        this.productCommentID = productCommentID;
    }

    public Integer getProductCommentID() {
        return productCommentID;
    }

    public void setProductCommentID(Integer productCommentID) {
        this.productCommentID = productCommentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        hash += (productCommentID != null ? productCommentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductComments)) {
            return false;
        }
        ProductComments other = (ProductComments) object;
        if ((this.productCommentID == null && other.productCommentID != null) || (this.productCommentID != null && !this.productCommentID.equals(other.productCommentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.ProductComments[productCommentID=" + productCommentID + "]";
    }

}
