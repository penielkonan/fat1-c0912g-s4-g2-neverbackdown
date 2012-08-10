/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.entity.ProductCategorys;
import model.entity.ProductDetails;
import model.session.ProductCategorysFacade;
import model.session.ProductDetailsFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class ProductBean {

    @EJB
    private ProductCategorysFacade productCategorysFacade;
    @EJB
    private ProductDetailsFacade productDetailsFacade;
    
    private int idProductDetail, cateId;
    private String cateName;

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getIdProductDetail() {
        return idProductDetail;
    }

    public void setIdProductDetail(int idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    /** Creates a new instance of ProductBean */
    public ProductBean() {
    }

    public List<ProductDetails> getListProductIndex() {
        return (List<ProductDetails>) productDetailsFacade.index(5);
    }

    public ProductDetails getProductDetail() {
        return (ProductDetails) productDetailsFacade.detailProduct(idProductDetail);
    }

    public List<ProductDetails> getProductByCateId() {
        return (List<ProductDetails>) productDetailsFacade.cateProduct(cateId);
    }

    public String getDetailCate(){
        return productCategorysFacade.detailCate(cateId).getDescription();
    }

    public int getCountByCategory() {
        return productDetailsFacade.CountProductById(cateId).intValue();
    }

    public String category(int id, String cateName) {
        this.cateId = id;
        this.cateName = cateName;
        return "category";
    }

    public String product(int id) {
        idProductDetail = id;
        return "product";
    }
}
