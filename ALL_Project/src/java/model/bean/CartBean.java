/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.entity.Cart;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class CartBean {

    /** Creates a new instance of MyCart */
    public CartBean() {
    }

     private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    List<Cart> lst = new ArrayList<Cart>();

    public String addToCart(int id, String name, String img, float price) {
        if (amount == 0) {
            return "product";
        } else {
            if (lst.size() == 0) {
                Cart c = new Cart(id, name, img, amount, price);
                lst.add(c);
                amount = 0;
                return "product";
            } else {
                for (Cart cart : lst) {
                    if (cart.getIdProduct() == id) {
                        cart.setAmountProduct(cart.getAmountProduct() + amount);
                        amount = 0;
                        return "product";
                    }
                }
                Cart c = new Cart(id, name, img, amount, price);
                lst.add(c);
                amount = 0;
                return "product";
            }
        }
    }
}
