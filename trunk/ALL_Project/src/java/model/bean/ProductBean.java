/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.entity.ProductDetails;
import model.session.ProductDetailsFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class ProductBean {
    @EJB
    private ProductDetailsFacade productDetailsFacade;

    private int idProductDetail;

    public int getIdProductDetail() {
        return idProductDetail;
    }

    public void setIdProductDetail(int idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    /** Creates a new instance of ProductBean */
    public ProductBean() {
    }   

    public List<ProductDetails> getListProductIndex(){
        return (List<ProductDetails>) productDetailsFacade.index(5);
    }

    public ProductDetails getProductDetail(){
        return (ProductDetails) productDetailsFacade.detailProduct(idProductDetail);
    }

    public String product(int id){
        idProductDetail = id;
        return "product";
    }
    
}
