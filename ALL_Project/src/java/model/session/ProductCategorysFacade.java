/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.ProductCategorys;

/**
 *
 * @author Admin
 */
@Stateless
public class ProductCategorysFacade extends AbstractFacade<ProductCategorys> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductCategorysFacade() {
        super(ProductCategorys.class);
    }

}
