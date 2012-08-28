/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entity.Factorys;
import model.entity.WareHouses;
import model.session.WareHousesFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class WareHouseBean {

    @EJB
    private WareHousesFacade wareHousesFacade;

    /** Creates a new instance of WareHouseBean */
    public WareHouseBean() {
    }
    
    private int wareHouseID;

    public int getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    WareHouses w = new WareHouses();

    public WareHouses getW() {
        return w;
    }

    public void setW(WareHouses w) {
        this.w = w;
    }
    private int factoryChane;

    public int getFactoryChane() {
        return factoryChane;
    }

    public void setFactoryChane(int factoryChane) {
        this.factoryChane = factoryChane;
    }

    public String Region(int id) {
        return wareHousesFacade.RegionByID(id);
    }

    public List<WareHouses> getListWareHouse() {
        return wareHousesFacade.getListWareHousr();
    }

    public List<WareHouses> getListWareHouseNoStatus() {
        return wareHousesFacade.getListWareHousrNoStatus();
    }

    public String WareHouseRegion(int id){
        this.wareHouseID = id;
        return "invoices-region";
    }

    public int IdWareHouseLogin(){
        AccountBean a = (AccountBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("accountBean");
        return wareHousesFacade.WarehouseIDByEmail(a.getId());
    }

    public String editWareHouse(int id) {
        w = wareHousesFacade.getWareHousesByID(id);
        return "warehouses-update";
    }

    public String updateWareHouse() {
        w.setFactorys(new Factorys(factoryChane));
        wareHousesFacade.editWareHouses(w);
        return "warehouses";
    }

    public String deleteWareHouse(int id) {
        w = wareHousesFacade.getWareHousesByID(id);
        w.setStatus(false);
        wareHousesFacade.deleteWareHouses(w);
        return "warehouses";
    }
}
