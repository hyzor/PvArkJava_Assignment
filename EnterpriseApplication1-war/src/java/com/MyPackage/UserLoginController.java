/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import com.MyPackage.Beans.NavigationBean;
import com.MyPackage.Beans.UserCredentialsBean;
import com.MyPackage.Entities.User;
import com.MyPackage.Entities.service.UserFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Hyzor
 */
@Named
@SessionScoped
public class UserLoginController implements Serializable {
    
    @EJB
    UserFacade usersFacade;
    
    @Inject
    UserCredentialsBean credentials;
    
    @Inject
    NavigationBean navigationBean;
    
    private User user;
    
    public String doLogin() {
        String result = "fail";
        
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
            result = "success";
            user = usersFacade.findUser(username);
        } catch (ServletException e) {
            e.printStackTrace();
            fContext.addMessage(null, new FacesMessage("Login failed."));
        }
        
        return result;
    }
    
    public String doLogout() {
        String result = "logoutFail";
        
        FacesContext fContext = FacesContext.getCurrentInstance();
        ExternalContext extContext = fContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) extContext.getRequest();
        try {
            request.logout();
            extContext.invalidateSession();
            user = null;
            result = "logoutSuccess";
        } catch (ServletException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public boolean isLoggedIn() {
        return user != null;
    }
    
    @Produces
    @LoggedIn
    User getCurrentUser() {
        return user;
    }
}