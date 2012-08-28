/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.entity.OrderDetails;
import model.entity.Orders;
import model.entity.WareHouses;
import model.session.AccountsFacade;
import model.session.OrderDetailsFacade;
import model.session.OrdersFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class InvoicesBean {

    @EJB
    private AccountsFacade accountsFacade;
    @EJB
    private OrderDetailsFacade orderDetailsFacade;
    @EJB
    private OrdersFacade ordersFacade;
    private int orderID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /** Creates a new instance of InvoicesBean */
    public InvoicesBean() {
    }

    public String deleteInvoice(int orderID) {
        o = ordersFacade.getOrderByID(orderID);
        o.setStatus(false);
        ordersFacade.editOrder(o);
        return "invoices";
    }

    public List<Orders> getListOrder() {
        return ordersFacade.getList();
    }

    public double totalOrder() {
        return orderDetailsFacade.getTotalMoneyAll();
    }

    public List<Orders> getListDealerAuto() {
        WareHouseBean w = (WareHouseBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("wareHouseBean");
        return ordersFacade.getListDealer(w.getWareHouseID());
    }

    public List<Orders> getListDealerAutoLogin() {
        WareHouseBean w = (WareHouseBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("wareHouseBean");
        return ordersFacade.getListDealer(w.IdWareHouseLogin());
    }

    public List<Orders> getListDealer1() {
        return ordersFacade.getListDealer(1);
    }

    public List<Orders> getListDealer2() {
        return ordersFacade.getListDealer(2);
    }

    public List<Orders> getListDealer3() {
        return ordersFacade.getListDealer(3);
    }

    public List<Orders> getListHistoryCustomer() {
        OrderStep o = (OrderStep) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("orderStep");
        return ordersFacade.getListFromAccount(accountsFacade.getIdAccountByEmail(o.getEmaillogin()));
    }

    public List<OrderDetails> getListOrderDetail() {
        return orderDetailsFacade.getListOrderDetail(orderID);
    }

    public Orders getOrdershow() {
        return ordersFacade.findAll().get(orderID - 1);
    }

    public String orderDetail(int orderID) {
        this.orderID = orderID;
        return "history-details";
    }

    public double TotalMoneyByOrderID(int OrderID) {
        return orderDetailsFacade.getTotalMoney(OrderID);
    }

    public double TotalMoneyByOrderID() {
        return orderDetailsFacade.getTotalMoney(orderID);
    }
    ///////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    private int warehouseChange;

    public int getWarehouseChange() {
        return warehouseChange;
    }

    public void setWarehouseChange(int warehouseChange) {
        this.warehouseChange = warehouseChange;
    }
    Orders o = new Orders();

    public Orders getO() {
        return o;
    }

    public void setO(Orders o) {
        this.o = o;
    }

    public String updateInvoice() {
        o.setWareHouses(new WareHouses(warehouseChange));
        ordersFacade.editOrder(o);
        return "invoices";
    }

    public String editInvoice(int orderID) {
        o = ordersFacade.getOrderByID(orderID);
        return "invoice-update";
    }

    public double getPriceTotal(){
        return orderDetailsFacade.getTotalMoneyAll();
    }
}
