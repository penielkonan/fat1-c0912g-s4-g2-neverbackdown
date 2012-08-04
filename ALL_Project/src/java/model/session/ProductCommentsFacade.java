/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.ProductComments;

/**
 *
 * @author Admin
 */
@Stateless
public class ProductCommentsFacade extends AbstractFacade<ProductComments> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductCommentsFacade() {
        super(ProductComments.class);
    }

}
