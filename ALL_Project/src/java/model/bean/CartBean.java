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

    private float priceOrder;

    public float getAllPrice() {
        return priceOrder;
    }

    public void setAllPrice(float priceOrder) {
        this.priceOrder = priceOrder;
    }

    private int amount = 1;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    List<Cart> lst = new ArrayList<Cart>();

    public List<Cart> getListCart() {
        return lst;
    }


    public void addToCart(int id, String name, String img, float price) {
        boolean fag = false;
        if (amount == 0) {
        } else {
            if (lst.size() == 0) {
                Cart c = new Cart(id, name, img, amount, price);
                lst.add(c);
                amount = 1;
            } else {
                for (Cart cart : lst) {
                    if (cart.getIdProduct() == id) {
                        cart.setAmountProduct(cart.getAmountProduct() + amount);
                        amount = 1;
                        fag = true;
                    }
                }
                if (fag == false) {
                    Cart c = new Cart(id, name, img, amount, price);
                    lst.add(c);
                    amount = 1;
                }
            }
        }
    }

    public void deleteItem(int id) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getIdProduct() == id) {
                lst.remove(i);
            }
        }
    }

    public float getPriceOrder() {
        priceOrder = 0;
        for (Cart cart : lst) {
            priceOrder += (cart.getAmountProduct()) * (cart.getPrice());
        }
        return priceOrder;
    }

    public int countProduct(){
        int amountProduct = 0;
        for (int i= 0; i < lst.size(); i++) {
           amountProduct += lst.get(i).getAmountProduct();
        }
        return amountProduct;
    }

    
}