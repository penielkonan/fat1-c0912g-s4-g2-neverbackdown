/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Employees;

/**
 *
 * @author Admin
 */
@Stateless
public class EmployeesFacade extends AbstractFacade<Employees> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeesFacade() {
        super(Employees.class);
    }

    public String Department(String email){
        String eql = "select e.departments.departmentID from Employees e where e.accounts.email =:email";
        return em.createQuery(eql).setParameter("email", email).getSingleResult().toString();
    }

    public void CreateEmployee(Employees e){
        em.persist(e);
    }

}
