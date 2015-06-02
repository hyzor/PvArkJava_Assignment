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
public class UsersService {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager entityManager;
    
    public void addUser(User user) {
        entityManager.persist(user);
    }
    
    public void deleteUser(User user) {
        entityManager.remove(user);
    }
    
    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }
    
    public List<User> getUsers() throws Exception {
        Query query = entityManager.createQuery("SELECT u from Users as u");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
