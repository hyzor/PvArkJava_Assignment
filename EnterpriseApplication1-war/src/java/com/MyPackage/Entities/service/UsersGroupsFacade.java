/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Entities.service;

import com.MyPackage.Entities.Item;
import com.MyPackage.Entities.User;
import com.MyPackage.Entities.UsersGroups;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jesper
 */
@Stateless
public class UsersGroupsFacade extends AbstractFacade<UsersGroups> {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;

    public UsersGroupsFacade() {
        super(UsersGroups.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<UsersGroups> getUsers() throws Exception {
        Query query = em.createQuery("SELECT u from Users_Groups as u");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
