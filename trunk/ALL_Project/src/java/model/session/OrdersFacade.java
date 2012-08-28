/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Accounts;
import model.entity.Orders;

/**
 *
 * @author Admin
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    public void editOrder(Orders o){
        em.merge(o);
    }

    public void addOrder(Orders o){
        em.persist(o);
    }

    public void delete(Orders o){
        em.remove(o);
    }

    public Orders getOrderByID(int orderID){
        String eql ="SELECT o FROM Orders o WHERE o.orderID = :orderID";
        return (Orders) em.createQuery(eql).setParameter("orderID", orderID).getSingleResult();
    }

    public List<Orders> getList(){
        return em.createNamedQuery("Orders.findAll").getResultList();
    }
    
    public List<Orders> getListDealer(int id){
        String eql = "SELECT o FROM Orders o WHERE o.wareHouses.wareHouseID = :id";
        return em.createQuery(eql).setParameter("id", id).getResultList();
    }
    

    public Accounts findIdByEmail(String email){
        String eql = "SELECT a.accountID FROM Accounts a WHERE a.email = :email";
        return (Accounts) em.createQuery(eql).setParameter("email", email).getSingleResult();
    }

    public Accounts findEmailById(int id){
        String eql = "SELECT a.email FROM Accounts a WHERE a.accountID = :accountID";
        return (Accounts) em.createQuery(eql).setParameter("accountID", id).getSingleResult();
    }

    public List<Orders> getListFromAccount(int id){
        String eql = "SELECT o FROM Orders o WHERE o.accounts.accountID =:accountID";
        return em.createQuery(eql).setParameter("accountID", id).getResultList();
    }

}
