/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.entity.Factorys;
import model.session.FactorysFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class FactoryBean {

    @EJB
    private FactorysFacade factorysFacade;
    /** Creates a new instance of FactoryBean */
    Factorys f = new Factorys();
    Factorys fnew = new Factorys();

    public Factorys getFnew() {
        return fnew;
    }

    public void setFnew(Factorys fnew) {
        this.fnew = fnew;
    }

    public Factorys getF() {
        return f;
    }

    public void setF(Factorys f) {
        this.f = f;
    }

    public FactoryBean() {
    }

    public List<Factorys> getListFactory() {
        return factorysFacade.getListFactory();
    }

    public String addFactory() {
        fnew.setStatus(true);
        factorysFacade.addFactory(fnew);
        return "factorys";
    }

    public String editFactory(int id) {
        f = factorysFacade.getFactoryByID(id);
        return "factorys-update";
    }

    public String updateFactory() {
        factorysFacade.editFactory(f);
        return "factorys";
    }

    public String deleteFactory(int id) {
        f = factorysFacade.getFactoryByID(id);
        f.setStatus(false);
        factorysFacade.deleteFactory(f);
        return "factorys";
    }
}
