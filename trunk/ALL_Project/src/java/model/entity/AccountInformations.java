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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "AccountInformations.findByTitle", query = "SELECT a FROM AccountInformations a WHERE a.title = :title"),
    @NamedQuery(name = "AccountInformations.findByFirstName", query = "SELECT a FROM AccountInformations a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AccountInformations.findByLastName", query = "SELECT a FROM AccountInformations a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "AccountInformations.findByBirthDate", query = "SELECT a FROM AccountInformations a WHERE a.birthDate = :birthDate"),
    @NamedQuery(name = "AccountInformations.findByCompany", query = "SELECT a FROM AccountInformations a WHERE a.company = :company"),
    @NamedQuery(name = "AccountInformations.findByAddress", query = "SELECT a FROM AccountInformations a WHERE a.address = :address"),
    @NamedQuery(name = "AccountInformations.findByAddress2", query = "SELECT a FROM AccountInformations a WHERE a.address2 = :address2"),
    @NamedQuery(name = "AccountInformations.findByCity", query = "SELECT a FROM AccountInformations a WHERE a.city = :city"),
    @NamedQuery(name = "AccountInformations.findByState", query = "SELECT a FROM AccountInformations a WHERE a.state = :state"),
    @NamedQuery(name = "AccountInformations.findByZip", query = "SELECT a FROM AccountInformations a WHERE a.zip = :zip"),
    @NamedQuery(name = "AccountInformations.findByCountry", query = "SELECT a FROM AccountInformations a WHERE a.country = :country"),
    @NamedQuery(name = "AccountInformations.findByAdditionalInformation", query = "SELECT a FROM AccountInformations a WHERE a.additionalInformation = :additionalInformation"),
    @NamedQuery(name = "AccountInformations.findByHomePhone", query = "SELECT a FROM AccountInformations a WHERE a.homePhone = :homePhone"),
    @NamedQuery(name = "AccountInformations.findByTel", query = "SELECT a FROM AccountInformations a WHERE a.tel = :tel"),
    @NamedQuery(name = "AccountInformations.findByAddressAlias", query = "SELECT a FROM AccountInformations a WHERE a.addressAlias = :addressAlias")})
public class AccountInformations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccountInfoID", nullable = false)
    private Integer accountInfoID;
    @Column(name = "Title", length = 20)
    private String title;
    @Column(name = "FirstName", length = 50)
    private String firstName;
    @Column(name = "LastName", length = 50)
    private String lastName;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "Company", length = 50)
    private String company;
    @Column(name = "Address", length = 250)
    private String address;
    @Column(name = "Address2", length = 250)
    private String address2;
    @Column(name = "City", length = 50)
    private String city;
    @Column(name = "State", length = 50)
    private String state;
    @Column(name = "Zip", length = 50)
    private String zip;
    @Column(name = "Country", length = 50)
    private String country;
    @Column(name = "AdditionalInformation", length = 300)
    private String additionalInformation;
    @Column(name = "HomePhone", length = 30)
    private String homePhone;
    @Column(name = "Tel", length = 20)
    private String tel;
    @Column(name = "AddressAlias", length = 50)
    private String addressAlias;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
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

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
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
