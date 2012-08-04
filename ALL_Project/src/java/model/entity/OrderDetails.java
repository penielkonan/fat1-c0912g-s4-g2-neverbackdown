/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "OrderDetails", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByOrderDetailID", query = "SELECT o FROM OrderDetails o WHERE o.orderDetailID = :orderDetailID"),
    @NamedQuery(name = "OrderDetails.findByAmount", query = "SELECT o FROM OrderDetails o WHERE o.amount = :amount"),
    @NamedQuery(name = "OrderDetails.findByTotalMoney", query = "SELECT o FROM OrderDetails o WHERE o.totalMoney = :totalMoney"),
    @NamedQuery(name = "OrderDetails.findByStatus", query = "SELECT o FROM OrderDetails o WHERE o.status = :status")})
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OrderDetailID", nullable = false)
    private Integer orderDetailID;
    @Column(name = "Amount")
    private Integer amount;
    @Column(name = "TotalMoney", precision = 19, scale = 4)
    private BigDecimal totalMoney;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne
    private ProductDetails productDetails;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @ManyToOne
    private Orders orders;

    public OrderDetails() {
    }

    public OrderDetails(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailID != null ? orderDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.orderDetailID == null && other.orderDetailID != null) || (this.orderDetailID != null && !this.orderDetailID.equals(other.orderDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.OrderDetails[orderDetailID=" + orderDetailID + "]";
    }

}
