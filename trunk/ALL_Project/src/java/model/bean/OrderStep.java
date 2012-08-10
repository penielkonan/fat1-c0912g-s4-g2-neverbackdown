/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class OrderStep {

    /** Creates a new instance of OrderStep */
    public OrderStep() {
    }

    private int step;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int OrderStep(){
        return step;
    }

    public void Order(int id){
        this.step = id;
        //return "Order";
    }

}
