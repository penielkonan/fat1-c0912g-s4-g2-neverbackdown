/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.AccountInformations;

/**
 *
 * @author Admin
 */
@Stateless
public class AccountInformationsFacade extends AbstractFacade<AccountInformations> {

    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountInformationsFacade() {
        super(AccountInformations.class);
    }

    public List<AccountInformations> getInfo(String email) {
        String eql = "SELECT a FROM AccountInformations a WHERE a.accounts.email =:email";
        return em.createQuery(eql).setParameter("email", email).getResultList();
    }

    public AccountInformations getInfoByEmail(String email) {
        String eql = "SELECT a FROM AccountInformations a WHERE a.accounts.email =:email";
        return (AccountInformations) em.createQuery(eql).setParameter("email", email).getSingleResult();
    }


    public List<AccountInformations> getSelectOneAjax(int id) {
        String eql = "SELECT a FROM AccountInformations a WHERE a.accountInfoID =:accountInfoID";
        return em.createQuery(eql).setParameter("accountInfoID", id).getResultList();
    }

    public void AddInformations(AccountInformations aInfo){
        em.persist(aInfo);
    }

    public void EditInformations(AccountInformations aEdit){
        em.merge(aEdit);
    }
}
