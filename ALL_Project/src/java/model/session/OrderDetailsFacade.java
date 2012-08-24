/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.OrderDetails;

/**
 *
 * @author Admin
 */
@Stateless
public class OrderDetailsFacade extends AbstractFacade<OrderDetails> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderDetailsFacade() {
        super(OrderDetails.class);
    }

    public void addOrderDetails(OrderDetails o){
        em.persist(o);
    }

    public double getTotalMoney(int OrderID){
        String eql = "SELECT SUM (o.totalMoney) from OrderDetails o WHERE o.orders.orderID =:orderID";
        return Double.parseDouble(em.createQuery(eql).setParameter("orderID", OrderID).getSingleResult().toString());
    }

    public List<OrderDetails> getListOrderDetail(int orderID){
        String eql = "SELECT o from OrderDetails o where o.orders.orderID =:orderID";
        return em.createQuery(eql).setParameter("orderID", orderID).getResultList();
    }

}
