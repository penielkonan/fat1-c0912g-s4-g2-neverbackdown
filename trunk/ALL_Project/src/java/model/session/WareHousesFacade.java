/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.WareHouses;

/**
 *
 * @author Admin
 */
@Stateless
public class WareHousesFacade extends AbstractFacade<WareHouses> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WareHousesFacade() {
        super(WareHouses.class);
    }

    public String RegionByID(int id){
        String eql ="SELECT w.region FROM WareHouses w WHERE w.accounts.accountID = :wareHouseID";
        return em.createQuery(eql).setParameter("wareHouseID", id).getSingleResult().toString();
    }

    public int WarehouseIDByEmail(int id){
        String eql="SELECT w.wareHouseID FROM WareHouses w WHERE w.accounts.accountID =:accountID";
        return Integer.parseInt(em.createQuery(eql).setParameter("accountID", id).getSingleResult().toString()) ;      
    }

    public List<WareHouses> getListWareHousr(){
        String eql = "SELECT w FROM WareHouses w WHERE w.status = 1";
        return em.createQuery(eql).getResultList();
    }

    public List<WareHouses> getListWareHousrNoStatus(){
        String eql = "SELECT w FROM WareHouses w ";
        return em.createQuery(eql).getResultList();
    }

    public WareHouses getWareHousesByID(int id){
        String eql = "SELECT w FROM WareHouses w WHERE w.wareHouseID = :wareHouseID";
        return (WareHouses) em.createQuery(eql).setParameter("wareHouseID", id).getSingleResult();
    }

    public void addWareHouse(WareHouses w){
        em.persist(w);
    }

    public void editWareHouses(WareHouses w){
        em.merge(w);
    }

     public void deleteWareHouses(WareHouses w){
        em.merge(w);
    }

}
