/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;
import model.entity.AccountInformations;
import model.entity.Accounts;
import model.entity.Cart;
import model.entity.Departments;
import model.entity.OrderDetails;
import model.entity.Orders;
import model.entity.Payments;
import model.entity.ProductDetails;
import model.entity.WareHouses;
import model.session.AccountInformationsFacade;
import model.session.AccountsFacade;
import model.session.DepartmentsFacade;
import model.session.OrderDetailsFacade;
import model.session.OrdersFacade;
import model.session.WareHousesFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class OrderStep implements Serializable {

    @EJB
    private DepartmentsFacade departmentsFacade;
    @EJB
    private OrderDetailsFacade orderDetailsFacade;
    @EJB
    private OrdersFacade ordersFacade;
    @EJB
    private WareHousesFacade wareHousesFacade;
    @EJB
    private AccountInformationsFacade accountInformationsFacade;
    @EJB
    private AccountsFacade accountsFacade;

    /** Creates a new instance of OrderStep */
    public OrderStep() {
    }
    private int step;
    private String emailCreater;
    private String fname, lname, password, company, address, address2, city, state, zip, country, addinfo, homephone, mobiphone, addalias;
    private String emaillogin, passwordlogin, addressOrder;
    private int regionOrder;
//    private String birthday;
    private String hello;
    private Date birthday;
    private String title = "Mr.";

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public int getRegionOrder() {
        return regionOrder;
    }

    public void setRegionOrder(int regionOrder) {
        this.regionOrder = regionOrder;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public String getEmaillogin() {
        return emaillogin;
    }

    public void setEmaillogin(String emaillogin) {
        this.emaillogin = emaillogin;
    }

    public String getPasswordlogin() {
        return passwordlogin;
    }

    public void setPasswordlogin(String passwordlogin) {
        this.passwordlogin = passwordlogin;
    }

//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
    public String getAddalias() {
        return addalias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddalias(String addalias) {
        this.addalias = addalias;
    }

    public String getAddinfo() {
        return addinfo;
    }

    public void setAddinfo(String addinfo) {
        this.addinfo = addinfo;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobiphone() {
        return mobiphone;
    }

    public void setMobiphone(String mobiphone) {
        this.mobiphone = mobiphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmailCreater() {
        return emailCreater;
    }

    public void setEmailCreater(String emailCreater) {
        this.emailCreater = emailCreater;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int OrderStep() {
        return step;
    }

    ///////////////////////////////
    public String Finish(int id, int payment) {
        this.step = id;
        Orders o = new Orders();
        o.setAccounts(new Accounts(accountsFacade.getIdAccountByEmail(emaillogin)));
        o.setWareHouses(new WareHouses(regionOrder));
        o.setPayments(new Payments(payment));
        o.setOrderDate(new Date());
        o.setDeliveryAdress(addressOrder);
        if (payment == 1) {
            o.setIsPay(false);
        } else {
            o.setIsPay(true);
        }
        o.setStatus(true);
        ordersFacade.addOrder(o);
        CartBean c = (CartBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cartBean");
        for (Cart cart : c.lst) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrders(new Orders(o.getOrderID()));
            orderDetails.setProductDetails(new ProductDetails(cart.getIdProduct()));
            orderDetails.setAmount(cart.getAmountProduct());
            orderDetails.setPrice(BigDecimal.valueOf(cart.getPrice()));
            orderDetails.setTotalMoney(BigDecimal.valueOf(cart.totalProduct()));
            orderDetails.setStatus(true);
            orderDetailsFacade.addOrderDetails(orderDetails);
        }
        return "order.xhtml";
    }

    public String Order(int id) {
        this.step = id;
        return "order.xhtml";
    }
    boolean login = false;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String checkLoginStep() {
        boolean fag = accountsFacade.checkAccount(emaillogin, passwordlogin);
        if (fag == true) {
            accounts = accountsFacade.getAccountByEmail(emaillogin);
            if (accounts.getDepartments().getDepartmentID() == 3) {
                this.step = 3;
                login = true;
                return "order";
            }
        }
        return "order";
    }

    public String getRegionbyID() {
        return wareHousesFacade.getWareHousesByID(regionOrder).getRegion();
    }

    public List<WareHouses> getListRegion() {
        return wareHousesFacade.getListWareHousr();
    }

    public List<AccountInformations> getAccInfoByEmail() {
        return accountInformationsFacade.getInfo(emaillogin);
    }

    public List<AccountInformations> getAddChoice() {
        return accountInformationsFacade.getSelectOneAjax(Integer.parseInt(selected));
    }

    public void listener(AjaxBehaviorEvent event) {
    }
    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String createAccount() {
        emaillogin = emailCreater;
        passwordlogin = password;
        Accounts a = new Accounts();
        a.setEmail(emailCreater);
        a.setPassword(password);
        a.setStatus(true);
        a.setDepartments(new Departments(3));
        accountsFacade.creatAccount(a);
        AccountInformations aInfo = new AccountInformations();
        aInfo.setAccounts(new Accounts(accountsFacade.getIdAccountByEmail(emailCreater)));
        aInfo.setTitle(title);
        aInfo.setFirstName(fname);
        aInfo.setLastName(lname);
        aInfo.setBirthDate(birthday);
        aInfo.setCompany(company);
        aInfo.setAddress(address);
        aInfo.setAddress2(address2);
        aInfo.setCity(city);
        aInfo.setState(state);
        aInfo.setZip(zip);
        aInfo.setCountry(country);
        aInfo.setAdditionalInformation(addinfo);
        aInfo.setHomePhone(homephone);
        aInfo.setTel(mobiphone);
        aInfo.setAddressAlias(address);
        accountInformationsFacade.AddInformations(aInfo);
        boolean fag = accountsFacade.checkAccount(emailCreater, password);
        if (fag == true) {
            if (a.getDepartments().getDepartmentID() == 3) {
                this.step = 3;
                login = true;
                return "order";
            }
        }
        this.step = 2;
        return "order";
    }
    Accounts accounts = new Accounts();

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public String myAccount() {
        boolean fag = accountsFacade.checkAccount(emaillogin, passwordlogin);
        if (fag == true) {
            accounts = accountsFacade.getAccountByEmail(emaillogin);
            if (accounts.getStatus() == false) {
                return "login";
            } else if (accounts.getDepartments().getDepartmentID() == 3) {
                this.step = 3;
                login = true;
                return "my-account";
            } else {
                return "login";
            }
        } else {
            return "login";
        }
    }

    public String register() {
        return "register";
    }

    public String logOut() {
        login = false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        return "index";
    }
}
