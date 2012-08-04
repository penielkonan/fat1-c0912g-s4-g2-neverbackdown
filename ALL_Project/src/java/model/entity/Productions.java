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
@Table(name = "Productions", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Productions.findAll", query = "SELECT p FROM Productions p"),
    @NamedQuery(name = "Productions.findByProductionID", query = "SELECT p FROM Productions p WHERE p.productionID = :productionID"),
    @NamedQuery(name = "Productions.findByExpectedAmount", query = "SELECT p FROM Productions p WHERE p.expectedAmount = :expectedAmount"),
    @NamedQuery(name = "Productions.findByActualAmount", query = "SELECT p FROM Productions p WHERE p.actualAmount = :actualAmount"),
    @NamedQuery(name = "Productions.findByErrorAmount", query = "SELECT p FROM Productions p WHERE p.errorAmount = :errorAmount"),
    @NamedQuery(name = "Productions.findByStatus", query = "SELECT p FROM Productions p WHERE p.status = :status")})
public class Productions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductionID", nullable = false)
    private Integer productionID;
    @Column(name = "ExpectedAmount")
    private Integer expectedAmount;
    @Column(name = "ActualAmount")
    private Integer actualAmount;
    @Column(name = "ErrorAmount")
    private Integer errorAmount;
    @Lob
    @Column(name = "Description", length = 2147483647)
    private String description;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne
    private ProductDetails productDetails;
    @JoinColumn(name = "PlanDetailID", referencedColumnName = "PlanDetailID")
    @ManyToOne
    private PlanDetails planDetails;

    public Productions() {
    }

    public Productions(Integer productionID) {
        this.productionID = productionID;
    }

    public Integer getProductionID() {
        return productionID;
    }

    public void setProductionID(Integer productionID) {
        this.productionID = productionID;
    }

    public Integer getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(Integer expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public Integer getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Integer getErrorAmount() {
        return errorAmount;
    }

    public void setErrorAmount(Integer errorAmount) {
        this.errorAmount = errorAmount;
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

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public PlanDetails getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(PlanDetails planDetails) {
        this.planDetails = planDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productionID != null ? productionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productions)) {
            return false;
        }
        Productions other = (Productions) object;
        if ((this.productionID == null && other.productionID != null) || (this.productionID != null && !this.productionID.equals(other.productionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Productions[productionID=" + productionID + "]";
    }

}
