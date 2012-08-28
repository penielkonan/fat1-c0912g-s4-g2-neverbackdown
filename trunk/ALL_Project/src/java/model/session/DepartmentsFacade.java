/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Departments;

/**
 *
 * @author Admin
 */
@Stateless
public class DepartmentsFacade extends AbstractFacade<Departments> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentsFacade() {
        super(Departments.class);
    }

    public String Department(String email){
        String eql = "select a.departments.DepartmentID from Accounts a where a.email =:email";
        return em.createQuery(eql).setParameter("email", email).getSingleResult().toString();
    }

}
