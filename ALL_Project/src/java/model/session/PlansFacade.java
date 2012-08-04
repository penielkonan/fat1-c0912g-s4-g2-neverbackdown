/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Plans;

/**
 *
 * @author Admin
 */
@Stateless
public class PlansFacade extends AbstractFacade<Plans> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PlansFacade() {
        super(Plans.class);
    }

}
