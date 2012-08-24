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

    public boolean checkAccount(String email,String pass){
        String eql = "select a from Accounts a where a.email =:email and a.password =:pass";
        List<Accounts> lst =em.createQuery(eql).setParameter("email", email).setParameter("pass", pass).getResultList();
        if(lst.size() != 0){
            return true;
        }
        return false;
    }

    public int getIdAccountByEmail(String emailCreate){
        String eql = "select a.accountID from Accounts a where a.email =:emailCreate";
        return Integer.parseInt(em.createQuery(eql).setParameter("emailCreate", emailCreate).getSingleResult().toString()) ;
    }

    public void creatAccount(Accounts a){
        em.persist(a);
    }

    public void upAccount(Accounts a){
        em.merge(a);
    }

}
