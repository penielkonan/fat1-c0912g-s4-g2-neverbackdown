/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author Admin
 */
public class Cart {

    private int idProduct;
    private String nameProduct;
    private String imgProduct;
    private int amountProduct;
    private float price;

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Cart(int idProduct, String nameProduct, String imgProduct, int amountProduct, float price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.imgProduct = imgProduct;
        this.amountProduct = amountProduct;
        this.price = price;
    }

    public float totalProduct() {
        return amountProduct * price;
    }

    public String nameProductCut() {
        if (nameProduct.length() < 17) {
            return nameProduct;
        } else {
            return nameProduct.substring(0, 17) + " ...";
        }

    }
}
