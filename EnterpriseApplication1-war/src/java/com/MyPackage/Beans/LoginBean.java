/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Beans;

import com.MyPackage.Entities.User;
import com.MyPackage.LoggedIn;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Hyzor
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    @Inject
    UserCredentialsBean credentials;
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU") 
    private EntityManager userDatabase;
    
    private User user;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public void DoLogin() {        
        /*
        Query loginQuery;
        loginQuery = userDatabase.createQuery("select u from Users u where u.username=:username and u.password=:password");
        loginQuery.setParameter("username", credentials.getUsername());
        loginQuery.setParameter("password", credentials.getPassword());
        
        List<Users> result = loginQuery.getResultList();
        
        if (!result.isEmpty()) {
            user = result.get(0);
            redirect = "home";
        } else {
            redirect = "errorLoginPage";
            // Error!
            // User not found.
        }
        */
        
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        
        FacesContext fContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fContext.getExternalContext().getRequest();
        
        try {
            request.login(username, password);
        } catch (ServletException e) {
            e.printStackTrace();
            fContext.addMessage(null, new FacesMessage("Login failed."));
        }
    }
    
    public boolean IsLoggedIn() {
        return user != null;
    }
    
    @Produces
    @LoggedIn
    User GetCurrentUser() {
        return user;
    }
}
