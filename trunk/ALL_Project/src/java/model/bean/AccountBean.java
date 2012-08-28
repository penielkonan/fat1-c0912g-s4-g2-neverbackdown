/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import model.entity.AccountInformations;
import model.entity.Accounts;
import model.entity.Departments;
import model.session.AccountInformationsFacade;
import model.session.AccountsFacade;
import model.session.WareHousesFacade;
import sun.rmi.log.LogInputStream;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class AccountBean {


    @EJB
    private WareHousesFacade wareHousesFacade;
    @EJB
    private AccountInformationsFacade accountInformationsFacade;
    @EJB
    private AccountsFacade accountsFacade;


    /** Creates a new instance of AccountBean */
    public AccountBean() {
    }
    private String email, pass, emailCreate;
    private String oldpass, newpass, confirmation;
    boolean login = false;
    boolean admin = false;
    private int id;
    boolean error = false;
    private String errorDisplay;

    public String getErrorDisplay() {
        return errorDisplay;
    }

    public void setErrorDisplay(String errorDisplay) {
        this.errorDisplay = errorDisplay;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getEmailCreate() {
        return emailCreate;
    }

    public void setEmailCreate(String emailCreate) {
        this.emailCreate = emailCreate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    

    public String checkLoginAdmin() {
        boolean fag = accountsFacade.checkAccount(email, pass);
        if (fag == true) {
            Accounts a = accountsFacade.getAccountByEmail(email);
            if ( a.getDepartments().getDepartmentID() == 1) {
                id = accountsFacade.getIdAccountByEmail(email);
                login = true;
                admin = true;
                return "invoices";
            } else if (a.getDepartments().getDepartmentID() == 2) {
                id = accountsFacade.getIdAccountByEmail(email);
                login = true;
                return "invoices";
            }
        }
        return "index";
    }


    public String creatAccount() {
        return "order.xhtml";
    }
    AccountInformations acc;

    public AccountInformations getAcc() {
        return acc;
    }

    public void setAcc(AccountInformations acc) {
        this.acc = acc;
    }

    public AccountInformations getAccountInfo() {
        return acc;
    }

    public String updateacc() {
        accountInformationsFacade.EditInformations(acc);
        return "my-account";
    }

    public String updateaccAdmin() {
        accountInformationsFacade.EditInformations(acc);
        return "dashboard";
    }

    public String identity() {
        OrderStep orderStep = (OrderStep) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("orderStep");
        acc = accountInformationsFacade.getInfoByEmail(orderStep.getEmaillogin());
        return "identity";
    }

    public String profile() {
//        OrderStep orderStep = (OrderStep) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("orderStep");
        acc = accountInformationsFacade.getInfoByEmail(email);
        return "profile";
    }

    public String changedPass() {
        OrderStep orderStep = (OrderStep) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("orderStep");
        if (accountsFacade.checkAccount(orderStep.getEmaillogin(), oldpass) == true) {
            if (newpass.equalsIgnoreCase(confirmation)) {
                Accounts a = new Accounts();
                a.setAccountID(accountsFacade.getIdAccountByEmail(orderStep.getEmaillogin()));
                a.setStatus(true);
                a.setPassword(newpass);
                a.setEmail(orderStep.getEmaillogin());
                a.setDepartments(new Departments(3));
                accountsFacade.upAccount(a);
                return "my-account";
            }
            return "change-pass";
        } else {
            return "change-pass";
        }
    }

    public String changedPassAdmin() {
        if (accountsFacade.checkAccount(email, oldpass) == true) {
            if (newpass.equalsIgnoreCase(confirmation)) {
                Accounts a = accountsFacade.getAccountByEmail(email);
                a.setAccountID(accountsFacade.getIdAccountByEmail(email));
                a.setStatus(true);
                a.setPassword(newpass);
                a.setEmail(email);
                accountsFacade.upAccount(a);
                errorDisplay = "";
                error = false;
                return "dashboard";
            }
            errorDisplay = "PASSWORDS DONT MATCH";
            error = true;
            return "acc-settings";
        } else {
            errorDisplay = "CURRENT PASSWORD INCORRECT";
            error = true;
            return "acc-settings";
        }
    }

    public List<AccountInformations> getAccInfoByEmail() {
        return accountInformationsFacade.getInfo(email);
    }

    public int getWarehouseByEmail() {
        return wareHousesFacade.WarehouseIDByEmail(id);
    }

    public String logOut() {
        email = "";
        pass = "";
        login = false;
        admin = false;
        return "index";
    }

    Accounts aupdate = new Accounts();

    public Accounts getAupdate() {
        return aupdate;
    }

    public void setAupdate(Accounts aupdate) {
        this.aupdate = aupdate;
    }

    
    public String editAccount(int id){
        aupdate = accountsFacade.getAccountByID(id);
        return "accounts-customer-update";
    }

    public String updateAccount(){
        accountsFacade.upAccount(aupdate);
        return "accounts-customer";
    }

    public String deleteAccount(int id){
        aupdate = accountsFacade.getAccountByID(id);
        aupdate.setStatus(false);
        accountsFacade.upAccount(aupdate);
        return "accounts-dealer";
    }

    public String editAccountDealer(int id){
        aupdate = accountsFacade.getAccountByID(id);
        return "accounts-dealer-update";
    }

    public String updateAccountDealer(){
        accountsFacade.upAccount(aupdate);
        return "accounts-dealer";
    }

    public String deleteAccountDealer(int id){
        aupdate = accountsFacade.getAccountByID(id);
        aupdate.setStatus(false);
        accountsFacade.upAccount(aupdate);
        return "accounts-dealer";
    }

    public List<Accounts> getListCustomer(){
        return  accountsFacade.getCustomerAccount();
    }

    public List<Accounts> getListDealer(){
        return  accountsFacade.getDealerAccount();
    }

    public String CreaterDealer(){
        return "accounts-dealer";
    }

}
