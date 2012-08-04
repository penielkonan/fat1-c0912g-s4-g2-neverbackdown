/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.ProductsInStock;

/**
 *
 * @author Admin
 */
@Stateless
public class ProductsInStockFacade extends AbstractFacade<ProductsInStock> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsInStockFacade() {
        super(ProductsInStock.class);
    }

}
