/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

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

}
