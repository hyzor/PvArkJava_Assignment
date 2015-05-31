/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import com.MyPackage.Entities.Users;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hyzor
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    @Inject
    UserCredentials credentials;
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU") 
    private EntityManager userDatabase;
    
    private Users user;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public void DoLogin() {
        Query loginQuery;
        loginQuery = userDatabase.createQuery("select u from Users u where u.username=:username and u.password=:password");
        loginQuery.setParameter("username", credentials.getUsername());
        loginQuery.setParameter("password", credentials.getPassword());
        
        List<Users> result = loginQuery.getResultList();
        
        if (!result.isEmpty()) {
            user = result.get(0);
        } else {
            // Error!
            // User not found.
        }
    }
    
    public boolean IsLoggedIn() {
        return user != null;
    }
    
    @Produces
    @LoggedIn
    Users GetCurrentUser() {
        return user;
    }
}
