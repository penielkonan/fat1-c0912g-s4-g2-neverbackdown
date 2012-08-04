/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.ProductDetails;

/**
 *
 * @author Admin
 */
@Stateless
public class ProductDetailsFacade extends AbstractFacade<ProductDetails> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductDetailsFacade() {
        super(ProductDetails.class);
    }

    public List<ProductDetails> index(int top){
        String eql = "SELECT p FROM ProductDetails p WHERE p.productID < :productID and p.status = 1";
        return em.createQuery(eql).setParameter("productID", top).getResultList();
    }

    public ProductDetails detailProduct(int id){
        String eql = "SELECT p FROM ProductDetails p WHERE p.productID = :productID and p.status = 1";
        return (ProductDetails) em.createQuery(eql).setParameter("productID", id).getSingleResult();
    }
}
