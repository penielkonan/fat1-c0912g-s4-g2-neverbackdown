/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ProductDetails", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ProductDetails.findAll", query = "SELECT p FROM ProductDetails p WHERE p.status = 1"),
    @NamedQuery(name = "ProductDetails.findByProductID", query = "SELECT p FROM ProductDetails p WHERE p.productID = :productID"),
    @NamedQuery(name = "ProductDetails.findByProductName", query = "SELECT p FROM ProductDetails p WHERE p.productName = :productName"),
    @NamedQuery(name = "ProductDetails.findByUnitPrice", query = "SELECT p FROM ProductDetails p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "ProductDetails.findByFigure", query = "SELECT p FROM ProductDetails p WHERE p.figure = :figure"),
    @NamedQuery(name = "ProductDetails.findByWidth", query = "SELECT p FROM ProductDetails p WHERE p.width = :width"),
    @NamedQuery(name = "ProductDetails.findByHeight", query = "SELECT p FROM ProductDetails p WHERE p.height = :height"),
    @NamedQuery(name = "ProductDetails.findByDepth", query = "SELECT p FROM ProductDetails p WHERE p.depth = :depth"),
    @NamedQuery(name = "ProductDetails.findByWeight", query = "SELECT p FROM ProductDetails p WHERE p.weight = :weight"),
    @NamedQuery(name = "ProductDetails.findBySizes", query = "SELECT p FROM ProductDetails p WHERE p.sizes = :sizes"),
    @NamedQuery(name = "ProductDetails.findByStatus", query = "SELECT p FROM ProductDetails p WHERE p.status = :status")})
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private Integer productID;
    @Column(name = "ProductName", length = 50)
    private String productName;
    @Lob
    @Column(name = "ProductDetail", length = 2147483647)
    private String productDetail;
    @Lob
    @Column(name = "ProductMoreInfo", length = 2147483647)
    private String productMoreInfo;
    @Column(name = "UnitPrice", precision = 19, scale = 4)
    private BigDecimal unitPrice;
    @Column(name = "Figure", length = 250)
    private String figure;
    @Column(name = "Width", length = 20)
    private String width;
    @Column(name = "Height", length = 20)
    private String height;
    @Column(name = "Depth", length = 20)
    private String depth;
    @Column(name = "Weight", length = 20)
    private String weight;
    @Column(name = "Sizes", length = 20)
    private String sizes;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "productDetails")
    private Collection<OrderDetails> orderDetailsCollection;
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID")
    @ManyToOne
    private ProductCategorys productCategorys;

    public ProductDetails() {
    }

    public ProductDetails(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductMoreInfo() {
        return productMoreInfo;
    }

    public void setProductMoreInfo(String productMoreInfo) {
        this.productMoreInfo = productMoreInfo;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    public ProductCategorys getProductCategorys() {
        return productCategorys;
    }

    public void setProductCategorys(ProductCategorys productCategorys) {
        this.productCategorys = productCategorys;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetails)) {
            return false;
        }
        ProductDetails other = (ProductDetails) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.ProductDetails[productID=" + productID + "]";
    }

    public String toDetailsCut() {
        String productDetailCut = "" + productDetail;
        return productDetail.substring(0, 200) + "...";
    }

    public double amount() {
        return unitPrice.doubleValue();
    }
}
