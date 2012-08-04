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
import model.session.ProductCategorysFacade;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class CategoryBean {
    @EJB
    private ProductCategorysFacade productCategorysFacade;

    /** Creates a new instance of CategoryBean */
    public CategoryBean() {
    }

    public List<ProductCategorys> getListCategory(){
        return productCategorysFacade.findAll();
    }

}
