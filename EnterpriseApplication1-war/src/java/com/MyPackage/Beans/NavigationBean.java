/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Hyzor
 */
@Named
@SessionScoped
public class NavigationBean implements Serializable {
    
    private static final String facesRedirectStr = "?faces-redirect=true";

    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }
    
    public String getRegistrationPage() {
        return "userRegistration.xhtml";
    }
    
    public String redirectToRegistrationPage() {
        return getRegistrationPage() + facesRedirectStr;
    }
    
    public String getLoginPage() {
        return "/loginPage.xhtml";
    }
    
    public String redirectToLoginPage() {
        return getLoginPage() + facesRedirectStr;
    }
    
    public String getHomePage() {
        return "/secured/home.xhtml";
    }
    
    public String redirectToHomePage() {
        return getHomePage() + facesRedirectStr;
    }
}
