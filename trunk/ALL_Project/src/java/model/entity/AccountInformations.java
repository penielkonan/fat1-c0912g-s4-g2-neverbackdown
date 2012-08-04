/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "AccountInformations", catalog = "ALL_Project", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "AccountInformations.findAll", query = "SELECT a FROM AccountInformations a"),
    @NamedQuery(name = "AccountInformations.findByAccountInfoID", query = "SELECT a FROM AccountInformations a WHERE a.accountInfoID = :accountInfoID"),
    @NamedQuery(name = "AccountInformations.findByLastName", query = "SELECT a FROM AccountInformations a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "AccountInformations.findByFirstName", query = "SELECT a FROM AccountInformations a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AccountInformations.findByBirthDate", query = "SELECT a FROM AccountInformations a WHERE a.birthDate = :birthDate"),
    @NamedQuery(name = "AccountInformations.findByAddress", query = "SELECT a FROM AccountInformations a WHERE a.address = :address"),
    @NamedQuery(name = "AccountInformations.findByCity", query = "SELECT a FROM AccountInformations a WHERE a.city = :city"),
    @NamedQuery(name = "AccountInformations.findByRegion", query = "SELECT a FROM AccountInformations a WHERE a.region = :region"),
    @NamedQuery(name = "AccountInformations.findByCountry", query = "SELECT a FROM AccountInformations a WHERE a.country = :country"),
    @NamedQuery(name = "AccountInformations.findByHomePhone", query = "SELECT a FROM AccountInformations a WHERE a.homePhone = :homePhone"),
    @NamedQuery(name = "AccountInformations.findByTel", query = "SELECT a FROM AccountInformations a WHERE a.tel = :tel"),
    @NamedQuery(name = "AccountInformations.findByEmail", query = "SELECT a FROM AccountInformations a WHERE a.email = :email"),
    @NamedQuery(name = "AccountInformations.findByPhoto", query = "SELECT a FROM AccountInformations a WHERE a.photo = :photo"),
    @NamedQuery(name = "AccountInformations.findByNotes", query = "SELECT a FROM AccountInformations a WHERE a.notes = :notes")})
public class AccountInformations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AccountInfoID", nullable = false)
    private Integer accountInfoID;
    @Column(name = "LastName", length = 50)
    private String lastName;
    @Column(name = "FirstName", length = 50)
    private String firstName;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "Address", length = 250)
    private String address;
    @Column(name = "City", length = 50)
    private String city;
    @Column(name = "Region", length = 50)
    private String region;
    @Column(name = "Country", length = 50)
    private String country;
    @Column(name = "HomePhone", length = 30)
    private String homePhone;
    @Column(name = "Tel", length = 20)
    private String tel;
    @Column(name = "Email", length = 100)
    private String email;
    @Column(name = "Photo", length = 100)
    private String photo;
    @Column(name = "Notes", length = 1073741823)
    private String notes;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Accounts accounts;

    public AccountInformations() {
    }

    public AccountInformations(Integer accountInfoID) {
        this.accountInfoID = accountInfoID;
    }

    public Integer getAccountInfoID() {
        return accountInfoID;
    }

    public void setAccountInfoID(Integer accountInfoID) {
        this.accountInfoID = accountInfoID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        hash += (accountInfoID != null ? accountInfoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountInformations)) {
            return false;
        }
        AccountInformations other = (AccountInformations) object;
        if ((this.accountInfoID == null && other.accountInfoID != null) || (this.accountInfoID != null && !this.accountInfoID.equals(other.accountInfoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.AccountInformations[accountInfoID=" + accountInfoID + "]";
    }

}
