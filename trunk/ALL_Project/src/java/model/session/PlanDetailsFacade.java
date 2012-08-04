/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.PlanDetails;

/**
 *
 * @author Admin
 */
@Stateless
public class PlanDetailsFacade extends AbstractFacade<PlanDetails> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanDetailsFacade() {
        super(PlanDetails.class);
    }

}
