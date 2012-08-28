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
@Table(name = "PlanDetails", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "PlanDetails.findAll", query = "SELECT p FROM PlanDetails p"),
    @NamedQuery(name = "PlanDetails.findByPlanDetailID", query = "SELECT p FROM PlanDetails p WHERE p.planDetailID = :planDetailID"),
    @NamedQuery(name = "PlanDetails.findByStatus", query = "SELECT p FROM PlanDetails p WHERE p.status = :status")})
public class PlanDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlanDetailID", nullable = false)
    private Integer planDetailID;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "planDetails")
    private Collection<Productions> productionsCollection;
    @JoinColumn(name = "PlanID", referencedColumnName = "PlanID")
    @ManyToOne
    private Plans plans;
    @JoinColumn(name = "FactoryID", referencedColumnName = "FactoryID")
    @ManyToOne
    private Factorys factorys;

    public PlanDetails() {
    }

    public PlanDetails(Integer planDetailID) {
        this.planDetailID = planDetailID;
    }

    public Integer getPlanDetailID() {
        return planDetailID;
    }

    public void setPlanDetailID(Integer planDetailID) {
        this.planDetailID = planDetailID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<Productions> getProductionsCollection() {
        return productionsCollection;
    }

    public void setProductionsCollection(Collection<Productions> productionsCollection) {
        this.productionsCollection = productionsCollection;
    }

    public Plans getPlans() {
        return plans;
    }

    public void setPlans(Plans plans) {
        this.plans = plans;
    }

    public Factorys getFactorys() {
        return factorys;
    }

    public void setFactorys(Factorys factorys) {
        this.factorys = factorys;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planDetailID != null ? planDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanDetails)) {
            return false;
        }
        PlanDetails other = (PlanDetails) object;
        if ((this.planDetailID == null && other.planDetailID != null) || (this.planDetailID != null && !this.planDetailID.equals(other.planDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.PlanDetails[planDetailID=" + planDetailID + "]";
    }

}
