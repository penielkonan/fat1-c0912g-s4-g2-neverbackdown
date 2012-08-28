/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Factorys;

/**
 *
 * @author Admin
 */
@Stateless
public class FactorysFacade extends AbstractFacade<Factorys> {
    @PersistenceContext(unitName = "ALL_ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public FactorysFacade() {
        super(Factorys.class);
    }

    public List<Factorys> getListFactory(){
        String eql = "SELECT f FROM Factorys f WHERE f.status = 1";
        return em.createQuery(eql).getResultList();
    }

     public Factorys getFactoryByID(int id){
        String eql = "SELECT f FROM Factorys f WHERE f.factoryID =:id ";
        return (Factorys) em.createQuery(eql).setParameter("id", id).getSingleResult();
    }

    public void addFactory(Factorys f){
        em.persist(f);
    }

    public void editFactory(Factorys f){
        em.merge(f);
    }

     public void deleteFactory(Factorys f){
        em.merge(f);
    }

}
