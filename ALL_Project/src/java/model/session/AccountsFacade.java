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

/**
 *
 * @author Admin
 */
@Stateless
public class AccountsFacade extends AbstractFacade<Accounts> {

    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountsFacade() {
        super(Accounts.class);
    }

    public Accounts getAccountByEmail(String email) {
        String eql = "SELECT a FROM Accounts a WHERE a.email =:email";
        return (Accounts) em.createQuery(eql).setParameter("email", email).getSingleResult();
    }

    public boolean checkAccount(String email, String pass) {
        String eql = "select a from Accounts a where a.email =:email and a.password =:pass and a.status = 1";
        List<Accounts> lst = em.createQuery(eql).setParameter("email", email).setParameter("pass", pass).getResultList();
        if (lst.size() != 0) {
            return true;
        }
        return false;
    }

    public int getIdAccountByEmail(String emailCreate) {
        String eql = "select a.accountID from Accounts a where a.email =:emailCreate";
        return Integer.parseInt(em.createQuery(eql).setParameter("emailCreate", emailCreate).getSingleResult().toString());
    }

    public void creatAccount(Accounts a) {
        em.persist(a);
    }

    public void upAccount(Accounts a) {
        em.merge(a);
    }

    public Accounts getAccountByID(int id) {
        String eql = "SELECT a FROM Accounts a WHERE a.accountID = :accountID";
        return (Accounts) em.createQuery(eql).setParameter("accountID", id).getSingleResult();
    }

    public List<Accounts> getCustomerAccount(){
        String eql = "SELECT a FROM Accounts a WHERE a.departments.departmentID = 3 and a.status = 1";
        return em.createQuery(eql).getResultList();
    }

    public List<Accounts> getDealerAccount(){
        String eql = "SELECT a FROM Accounts a WHERE a.departments.departmentID = 2 and a.status = 1";
        return em.createQuery(eql).getResultList();
    }

}
