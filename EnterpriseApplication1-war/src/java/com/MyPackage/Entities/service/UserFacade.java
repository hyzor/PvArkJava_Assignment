/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Entities.service;

import com.MyPackage.Entities.User;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Hyzor
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserFacade() {
        super(User.class);
    }
    
    public User findUser(String username) {
        return em.find(User.class, username);
    }
    
    public List<User> getUsers() throws Exception {
        Query query = em.createQuery("SELECT u from Users as u");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
