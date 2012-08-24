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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Orders", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o WHERE o.status = 1"),
    @NamedQuery(name = "Orders.findByOrderID", query = "SELECT o FROM Orders o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByDeliveryAdress", query = "SELECT o FROM Orders o WHERE o.deliveryAdress = :deliveryAdress"),
    @NamedQuery(name = "Orders.findByRequireDate", query = "SELECT o FROM Orders o WHERE o.requireDate = :requireDate"),
    @NamedQuery(name = "Orders.findByShipDate", query = "SELECT o FROM Orders o WHERE o.shipDate = :shipDate"),
    @NamedQuery(name = "Orders.findByDeliveryDate", query = "SELECT o FROM Orders o WHERE o.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Orders.findByIsPay", query = "SELECT o FROM Orders o WHERE o.isPay = :isPay"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderID", nullable = false)
    private Integer orderID;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "DeliveryAdress", length = 200)
    private String deliveryAdress;
    @Column(name = "RequireDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requireDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Column(name = "DeliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Column(name = "IsPay")
    private Boolean isPay;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "orders")
    private Collection<OrderDetails> orderDetailsCollection;
    @JoinColumn(name = "WareHouseID", referencedColumnName = "WareHouseID")
    @ManyToOne
    private WareHouses wareHouses;
    @JoinColumn(name = "PaymentID", referencedColumnName = "PaymentID")
    @ManyToOne
    private Payments payments;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accounts;

    public Orders() {
    }

    public Orders(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public Date getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(Boolean isPay) {
        this.isPay = isPay;
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

    public WareHouses getWareHouses() {
        return wareHouses;
    }

    public void setWareHouses(WareHouses wareHouses) {
        this.wareHouses = wareHouses;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
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
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Orders[orderID=" + orderID + "]";
    }

    public String orderStatus(boolean b) {
        if (b == true) {
            return "Successful transactions";
        } else {
            return "Awaiting cheque payment";
        }
    }

    public String paymentName(int paymentID) {
        if (paymentID == 1) {
            return "Cheque";
        } else {
            return "Bank wire";
        }
    }
}
