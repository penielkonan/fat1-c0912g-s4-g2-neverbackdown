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
@Table(name = "Plans", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Plans.findAll", query = "SELECT p FROM Plans p"),
    @NamedQuery(name = "Plans.findByPlanID", query = "SELECT p FROM Plans p WHERE p.planID = :planID"),
    @NamedQuery(name = "Plans.findByMonthPlan", query = "SELECT p FROM Plans p WHERE p.monthPlan = :monthPlan"),
    @NamedQuery(name = "Plans.findByYearPlan", query = "SELECT p FROM Plans p WHERE p.yearPlan = :yearPlan"),
    @NamedQuery(name = "Plans.findByStatus", query = "SELECT p FROM Plans p WHERE p.status = :status")})
public class Plans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlanID", nullable = false)
    private Integer planID;
    @Column(name = "MonthPlan", length = 10)
    private String monthPlan;
    @Column(name = "YearPlan", length = 5)
    private String yearPlan;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "plans")
    private Collection<PlanDetails> planDetailsCollection;

    public Plans() {
    }

    public Plans(Integer planID) {
        this.planID = planID;
    }

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public String getMonthPlan() {
        return monthPlan;
    }

    public void setMonthPlan(String monthPlan) {
        this.monthPlan = monthPlan;
    }

    public String getYearPlan() {
        return yearPlan;
    }

    public void setYearPlan(String yearPlan) {
        this.yearPlan = yearPlan;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<PlanDetails> getPlanDetailsCollection() {
        return planDetailsCollection;
    }

    public void setPlanDetailsCollection(Collection<PlanDetails> planDetailsCollection) {
        this.planDetailsCollection = planDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planID != null ? planID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plans)) {
            return false;
        }
        Plans other = (Plans) object;
        if ((this.planID == null && other.planID != null) || (this.planID != null && !this.planID.equals(other.planID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Plans[planID=" + planID + "]";
    }

}
