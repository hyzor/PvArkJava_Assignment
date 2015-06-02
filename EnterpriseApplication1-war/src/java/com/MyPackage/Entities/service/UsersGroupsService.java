/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Entities.service;

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
public class UsersGroupsService {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager entityManager;
    
    public void addUserGroup(UsersGroups userGroup) {
        entityManager.persist(userGroup);
    }
    
    public void deleteUserGroup(UsersGroups userGroup) {
        entityManager.remove(userGroup);
    }
    
    public UsersGroups findUsersGroups(int id) {
        return entityManager.find(UsersGroups.class, id);
    }
    
    public List<UsersGroups> getUsers() throws Exception {
        Query query = entityManager.createQuery("SELECT u from Users_Groups as u");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
