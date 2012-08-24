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
        String eql ="SELECT w.region FROM WareHouses w WHERE w.wareHouseID = :wareHouseID";
        return em.createQuery(eql).setParameter("wareHouseID", id).getSingleResult().toString();
    }
}
